package com.dodony.cloud.Controller;

import com.dodony.cloud.Entity.User;
import com.dodony.cloud.FeignClient2;
import com.dodony.cloud.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);


    @Autowired
    private RestTemplate restTemplate;

    //    @Autowired
//    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    // feign
    @Autowired
    private UserFeignClient userFeignClient;

    // 有权限feigh
    @Autowired
    private FeignClient2 feignClient2;

    // 一般访问
//    @GetMapping("/user/{id}")
//    public User findById(@PathVariable Long id) {
//        return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
//    }
    // feign访问
    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.userFeignClient.findById(id);
    }


//    @GetMapping("/user-instance")
//    public List<ServiceInstance> showInfo() {
//      return this.discoveryClient.getInstances("microservice-provider-user");
//    }

    @GetMapping("/log-instance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        // 打印当前选择的节点
        MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
    }

    /**
     * 有权限访问reign
     * @param serviceName
     * @return
     */
    @GetMapping("/{serviceName}")
    public String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName) {
        return this.feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
    }
}