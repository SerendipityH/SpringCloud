package com.serendipity;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 */
@Component
public class ProductSender {

    @Autowired
    private AmqpTemplate amqpTemplate;
    
    //exchange 交换器名称
    @Value("${mq.config.exchange}")
    private String exchange;
    
   
    
    public void send(String msg) {
        // 向消息队列发送消息
        // 参数一:交换器名称
        // 参数二:路由键
        // 参数三:消息
        amqpTemplate.convertAndSend(exchange,"order.log.info","user.log.info.."+msg);
        amqpTemplate.convertAndSend(exchange,"order.log.error","user.log.error.."+msg);
        amqpTemplate.convertAndSend(exchange,"order.log.debug","user.log.debug.."+msg);
        amqpTemplate.convertAndSend(exchange,"order.log.warn","user.log.warn.."+msg);
        
    }
}
