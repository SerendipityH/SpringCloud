package com.serendipity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.serendipity.UserSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.serendipity.App.class)
public class QueueTest {

    @Autowired
    private UserSender userSender;
    
  
    
    @Test
    public void test() {
       userSender.send("Hello Rabbitmq");
    }
}
