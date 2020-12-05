package com.smu.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smu.base.exception.MyException;
import com.smu.edu.domain.UcenterMember;
import com.smu.edu.dao.UcenterMemberMapper;
import com.smu.edu.service.UcenterMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smu.edu.vo.RegisterParams;
import com.smu.utils.JwtUtils;
import com.smu.utils.MD5;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author caowei
 * @since 2020-12-05
 */
@Service
public class UcenterMemberServiceImpl extends ServiceImpl<UcenterMemberMapper, UcenterMember> implements UcenterMemberService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(UcenterMember ucenterMember) {
        String mobile = ucenterMember.getMobile();
        String password = ucenterMember.getPassword();
        if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
            throw new MyException(20001,"用户名和密码不能为空");
        }
        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        UcenterMember member = baseMapper.selectOne(wrapper);
        if(member == null){
            throw new MyException(20001,"用户不存在");
        }
        if(member.getIsDisabled()){
            throw new MyException(20001,"该用户已经被禁用，请联系管理员");
        }
        if(!MD5.encrypt(password).equals(member.getPassword())){
            throw new MyException(20001,"密码错误");
        }
        String jwtToken = JwtUtils.getJwtToken(member.getId(), member.getNickname());
        return jwtToken;
    }

    @Override
    public void register(RegisterParams registerParams) {
        String mobile = registerParams.getMobile();
        String code = registerParams.getCode();
        String nickname = registerParams.getNickname();
        String password = registerParams.getPassword();
        if(StringUtils.isEmpty(nickname) || StringUtils.isEmpty(password) || StringUtils.isEmpty(code) || StringUtils.isEmpty(mobile)){
            throw new MyException(20001,"注册信息不能为空");
        }
        String redisCode = redisTemplate.opsForValue().get(mobile);
        if(!code.equals(redisCode)){
            throw new MyException(20001,"验证码错误");
        }

        QueryWrapper<UcenterMember> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        Integer integer = baseMapper.selectCount(wrapper);
        if(integer > 0){
            throw new MyException(20001,"该手机号已注册");
        }
        UcenterMember member = new UcenterMember();
        registerParams.setPassword(MD5.encrypt(password));
        BeanUtils.copyProperties(registerParams,member);
        member.setAwatar("https://caowei-edu.oss-cn-beijing.aliyuncs.com/2020/12/04/e09ab39790e546cfb27741e9c309892ftimg.jpg");
        baseMapper.insert(member);
    }
}
