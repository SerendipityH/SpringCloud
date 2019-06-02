package com.serendipity;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 消息接收者
 * 
 * @
 * @Queue value:配置队列名称
 *        autoDelete:是否是一个可用删除的临时队列
 *        
 *@Exchange value:交换器名称        
 */
@Component
@RabbitListener(
        bindings=@QueueBinding(
                exchange = @Exchange(value="${mq.config.exchange}",type=ExchangeTypes.DIRECT),
                value = @Queue(value="${mq.config.queue.info}",autoDelete="true"),
                key="${mq.config.queue.info.routing.key}"
           )
        )
public class InfoReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Info....recevier:" + msg);
    }
}
