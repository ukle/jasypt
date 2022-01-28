package com.example.demo;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {

    @Autowired
    private StringEncryptor jasyptStringEncryptor;

    @GetMapping("enc")
    public String enc(@RequestParam String str, @RequestParam int type) {
        if (!StringUtils.hasLength(str)) {
            return "参数为空";
        }
        try {
            if (type == 0) {
                return jasyptStringEncryptor.encrypt(str);
            } else {
                return jasyptStringEncryptor.decrypt(str);
            }
        } catch (Exception exp) {
            return "错误：" + exp.getMessage();
        }
    }
}
