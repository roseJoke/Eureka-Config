package com.kuliao.eurek.infeign;

import com.kuliao.eurek.config.LoggingConfig;
import com.kuliao.eurek.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="eureka-provider",fallback = HelloServiceFallback.class,configuration= LoggingConfig.class)
public interface UserFeignClient {

    @RequestMapping(value="/hh",method=RequestMethod.GET)
     public String hello1();

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value="/hello1",method=RequestMethod.GET)
    String hello(@RequestParam("name")String name);

    @RequestMapping(value="/hello2",method=RequestMethod.GET)
    User hello(@RequestHeader("id")Long id, @RequestHeader("username")String username);

    @RequestMapping(value="/hello3",method=RequestMethod.GET)
    String hello(@RequestBody User user);


}
