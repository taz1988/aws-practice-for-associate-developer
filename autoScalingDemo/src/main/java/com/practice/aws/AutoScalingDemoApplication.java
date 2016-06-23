package com.practice.aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutoScalingDemoApplication {

    public static void main(String[] args) {
        AutoScalingDemoApplication application = new AutoScalingDemoApplication();
        application.startApplication(args);
    }

    private void startApplication(String[] args) {
        SpringApplication.run(AutoScalingDemoApplication.class, args);
    }

    @Bean
    public AmazonSQS createAmazonSqsClient() {
        if (System.getProperty("spring.profiles.active").contains("sqs")) {
            AWSCredentials credentials = new BasicAWSCredentials(System.getProperty("aws.accessKey"), System.getProperty("aws.secretKey"));
            return new AmazonSQSClient(credentials);
        }
        return null;
    }
}
