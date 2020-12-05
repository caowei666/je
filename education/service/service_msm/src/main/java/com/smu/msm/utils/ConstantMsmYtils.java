package com.smu.msm.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantMsmYtils implements InitializingBean {
    @Value("${aliyun.oss.file.keyid}")
    private String accessKeyId;

    @Value("${aliyun.oss.file.keysecret}")
    private String accessKeySecret;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = accessKeyId;
        ACCESS_KEY_SECRET = accessKeySecret;
    }
}
