package com.example.hystrixdashboardexample;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestResource {

    @HystrixCommand(fallbackMethod = "fallBackHello", commandKey = "hello", groupKey = "hello" )
    @GetMapping("/hello")
    public String hello()
     {

         if(RandomUtils.nextBoolean()){
             throw new RuntimeException( "Failed!");
         }
         return "Hello World";
     }

     public String fallBackHello()
     {
         return "Fall back hello initiated";
     }


}
