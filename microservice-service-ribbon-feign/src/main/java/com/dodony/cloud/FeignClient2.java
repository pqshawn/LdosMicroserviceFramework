package com.dodony.cloud;


import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="microserver-discovery-eureka",url="http://peer1:8761/", configuration = AuthConfiguration.class)
public interface FeignClient2 {
    @RequestLine("GET /eureka/apps/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@Param("serviceName") String serviceName);

}
