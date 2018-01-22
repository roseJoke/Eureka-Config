package com.kuliao.eurek.infeign;


import com.kuliao.eurek.entity.User;
import org.springframework.stereotype.Component;

@Component
public class HelloServiceFallback implements UserFeignClient {
    @Override
    public String hello1() {
        return null;
    }
    @Override
    public String hello() {
        return "error11"+"\n";
    }

    @Override
    public String hello(String name) {
        return "error22"+"\n";
    }

    @Override
    public User hello(Long id, String username) {
        return new User(12,"未知"+"\n");
    }


    @Override
    public String hello(User user) {
        return "Error33"+"\n";
    }
}