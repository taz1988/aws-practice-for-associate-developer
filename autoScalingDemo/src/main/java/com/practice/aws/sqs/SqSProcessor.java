package com.practice.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("producer")
public class SqSProcessor {

    @Autowired
    private AmazonSQS amazonSQS;
    @Value("#{systemProperties['aws.sqs.queueUrl']}")
    private String queueUrl;

    public void sendTestMessages(int number) {
        for (int i = 0; i < number; i++) {
            sendATestMessage();
        }
    }

    public void sendATestMessage() {
        amazonSQS.sendMessage(new SendMessageRequest(queueUrl, "Auto scale demo, test message"));
    }

}
