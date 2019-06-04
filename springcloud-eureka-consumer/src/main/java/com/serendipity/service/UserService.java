package com.serendipity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.serendipity.pojo.User;

@Service
public class UserService {

    @Autowired
    private LoadBalancerClient loadBalancerClient; // 负载均衡

    public List<User> getUsers() {
        // 选择调用服务的名称
        // ServiceInstance 封装了服务的基本信息，如IP、端口
        ServiceInstance sInstance = loadBalancerClient.choose("eureka-provider");
        // 拼接访问服务的URL
        StringBuffer sb = new StringBuffer();
        sb.append("http://").append(sInstance.getHost()).append(":").append(sInstance.getPort())
                .append("/user");

        // springMVC RestTemplate
        RestTemplate rTemplate = new RestTemplate();
        ParameterizedTypeReference<List<User>> type =
                new ParameterizedTypeReference<List<User>>() {};
        // 封装了返回值信息
        ResponseEntity<List<User>> responseEntity =
                rTemplate.exchange(sb.toString(), HttpMethod.GET, null, type);

        List<User> list = responseEntity.getBody();
        return list;
    }
}
