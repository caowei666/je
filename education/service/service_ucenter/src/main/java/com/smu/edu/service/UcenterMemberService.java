package com.smu.edu.service;

import com.smu.edu.domain.UcenterMember;
import com.baomidou.mybatisplus.extension.service.IService;
import com.smu.edu.vo.RegisterParams;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author caowei
 * @since 2020-12-05
 */
public interface UcenterMemberService extends IService<UcenterMember> {

    String login(UcenterMember ucenterMember);

    void register(RegisterParams registerParams);
}
