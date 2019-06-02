package com.serendipity.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.serendipity.Sender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.serendipity.App.class)
public class QueueTest {

    @Autowired
    private Sender sender;

    @Test
    public void test() throws Exception {
        int flag = 0;
        while (true) {
            flag++;
            Thread.sleep(2000);
            sender.send("Hello RabbitMQ "+flag);
        }

    }
}
