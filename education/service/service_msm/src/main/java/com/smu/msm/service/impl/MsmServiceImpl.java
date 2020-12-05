package com.smu.msm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.utils.JSONUtils;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.smu.msm.service.MsmService;
import com.smu.msm.utils.ConstantMsmYtils;
import com.smu.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class MsmServiceImpl implements MsmService {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Override
    public boolean send(String phone) {
        if(StringUtils.isEmpty(phone)){
            return false;
        }
        String code = redisTemplate.opsForValue().get(phone);
        if(!StringUtils.isEmpty(code)){
            return true;
        }
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ConstantMsmYtils.ACCESS_KEY_ID, ConstantMsmYtils.ACCESS_KEY_SECRET);
        IAcsClient client = new DefaultAcsClient(profile);

        Map<String,Object> param = new HashMap<>();
        code = RandomUtil.getFourBitRandom();
        param.put("code", code);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers",phone);
        request.putQueryParameter("TemplateParam", JSONObject.toJSONString(param));
        request.putQueryParameter("SignName", "大伟在线教育");
        request.putQueryParameter("TemplateCode", "SMS_206546186");
        try {
            CommonResponse response = client.getCommonResponse(request);
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);
            return response.getHttpResponse().isSuccess();
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        }
    }
}
