package com.practice.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@Profile("consumer")
public class SqSConsumer implements InitializingBean {

    @Autowired
    private AmazonSQS amazonSQS;
    @Value("#{systemProperties['aws.sqs.queueUrl']}")
    private String queueUrl;

    public void eatMessage() throws InterruptedException {
        while (true) {
            ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest(queueUrl);
            receiveMessageRequest.setMaxNumberOfMessages(1);
            List<Message> messages = amazonSQS.receiveMessage(receiveMessageRequest).getMessages();
            for (Message message : messages) {
                System.out.println("  Message");
                System.out.println("    MessageId:     " + message.getMessageId());
                System.out.println("    ReceiptHandle: " + message.getReceiptHandle());
                System.out.println("    MD5OfBody:     " + message.getMD5OfBody());
                System.out.println("    Body:          " + message.getBody());
                for (Map.Entry<String, String> entry : message.getAttributes().entrySet()) {
                    System.out.println("  Attribute");
                    System.out.println("    Name:  " + entry.getKey());
                    System.out.println("    Value: " + entry.getValue());
                }
                String messageReceiptHandle = messages.get(0).getReceiptHandle();
                amazonSQS.deleteMessage(new DeleteMessageRequest(queueUrl, messageReceiptHandle));
            }
            Thread.sleep(TimeUnit.MINUTES.toMillis(1));
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        eatMessage();
    }
}
