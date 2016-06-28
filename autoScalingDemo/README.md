#Practice Auto scaling scenarios with AWS

The purpose of this app to learn more about AWS auto scaling feature. In this labs, we will check and experiment with different scenarios, which help us to understand how auto scaling work.

#Test Scenarios

##Auto scaling with ELB, based on HTTP response times

**Business scenario:** We have a service which has an SLA that every API call will be not slower than 5000 ms. The load for this service is very different (sometimes low, sometimes high). When the load is low, we want to run only a few servers to save money. 

**Possible solution:** Create an ELB load balancer, which is connected an auto scaling group. This group will be increase the instance number, if the HTTP response times are equal or bigger than 5000ms for one minute. If the response time is below 1000ms for 5 min, then decrease it.

### Create an AMI
The first step is to build an AMI (amazon machine image). This custom image will be used by the auto scaling group, what we will create in the next step.

An Amazon Machine Image (AMI) provides the information required to launch an instance, which is a virtual server in the cloud.

For this example, I will create an EBS-backed AMI. The AMI creation process is this:
![creation process of the AMI machine](http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/images/running-instance.png)

The first step is to create a properly configured ec2 instance, what we use for AMI creation. This include instance starting,
installing necessary software, copy our application to the instance and make sure, that our application start after a server reboot.
These are the commands, what we will use to configure our server:
```
sudo yum remove java-1.7.0-openjdk.x86_64
sudo yum install -y java-1.8.0-openjdk.x86_64
java -version 
sudo yum install -y vsftpd.x86_64
sudo service vsftpd status
sudo service vsftpd status
sudo vim /etc/rc.local
nohup java -jar /home/ec2-user/autoScalingDemo-0.0.1-SNAPSHOT.jar
```
Of course in real life this will be not enough, need other security configurations!

After you tested your server, and make sure, that your application work properly after reboot, you can start to create your AMI image.
You can easily do that vie web management console (only for EBS based images).

### Create ELB and CloudWatch alarms
The next step is to create the load balancer, which will be attached to the auto scale group. Furthermore we create the alarms. This way we can use the alarms, when create the auto scaling group.

### Create a Launch configuration
The next step is, to create a launch configuration. This configuration specify the EC2 instance configuration and used by auto scaling group when start a new instance.

### Create an auto scaling group with the Launch configuration
After we created the launch configuration, we have to use it. We have to create an auto scaling group which use the configuration. Here you can configure scaling options. After the group is created, you have to attach the ELB to the group.


###Resources
* http://docs.aws.amazon.com/autoscaling/latest/userguide/autoscaling-load-balancer.html
* http://docs.aws.amazon.com/AWSEC2/latest/UserGuide/AMIs.html
* http://docs.aws.amazon.com/autoscaling/latest/userguide/as-scale-based-on-demand.html
* http://docs.aws.amazon.com/ElasticLoadBalancing/latest/DeveloperGuide/elb-cloudwatch-metrics.html
* http://docs.aws.amazon.com/AmazonCloudWatch/latest/DeveloperGuide/AlarmThatSendsEmail.html

## Auto scaling based on SQS state

**Business scenario:** We have a job, which do some processing, which is time consuming. This reason we want to use it in an async way, so we use SQS service to store the process requests. Based on the number of messages in the SQS we want to start more servers in order to make more quicker the processing. 

**Possible solution:** Similarly we create an auto scaling group, which use the SQS service. Before creating the auto service group, we set-up the SQS and alarms for it.


###Resources
* http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSGettingStartedGuide/QueuePermissions.html
* https://github.com/aws/aws-sdk-java
* http://docs.aws.amazon.com/AWSSimpleQueueService/latest/SQSGettingStartedGuide/WorkingWithSQS.html
* https://github.com/aws/aws-sdk-java/tree/master/src/samples

## Auto scaling witch docker images

**Business scenario:** It is the same, as the first case, but we want to use docker images for the simpler release. 

**Possible solution:** Wrap our application to a docker container, and implement an EC2 container auto scaling group solution for it.

###Create docker image
This is the content of the Dockerfile
```
FROM ubuntu
COPY target/autoScalingDemo-0.0.1-SNAPSHOT.jar /var/
RUN apt-get update
RUN apt-get install -y openjdk-8-jre 
CMD java -jar /var/autoScalingDemo-0.0.1-SNAPSHOT.jar
```

###Configure a docker repository
Docker repository is responsible to store docker containers. It is a version control system basically for docker containers. Usually we use private repositories to store our application containers.
In order to be able to push a container to the repository, you have to install the aws cli!

After you have installed aws cli, you have to use the following commands:
```
aws configure
aws ecr get-login
docker build -t auto-scaling-demo .
docker tag auto-scaling-demo:latest 166245936529.dkr.ecr.eu-west-1.amazonaws.com/demo-repository:latest
docker push 166245936529.dkr.ecr.eu-west-1.amazonaws.com/demo-repository:latest
```

###Create cluster
First we have to create a docker cluster, which contains ec2 instances and other settings, for running docker images. A cluster will execute services

###Create a task definition
We create a task definition, which is a description of an application that contains one or more container definitions. 

###Create service
Last we have to create a service for 

###Resources
* http://docs.aws.amazon.com/AmazonECS/latest/developerguide/Welcome.html
* https://docs.docker.com/engine/
* https://docs.docker.com/engine/userguide/eng-image/dockerfile_best-practices/
* https://docs.docker.com/engine/reference/builder/
* http://docs.aws.amazon.com/cli/latest/userguide/installing.html




