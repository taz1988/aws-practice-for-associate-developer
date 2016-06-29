#This is for demo EC2 container service and auto scaling
FROM ubuntu
COPY target/autoScalingDemo-0.0.1-SNAPSHOT.jar /var/
RUN apt-get update
RUN apt-get install -y openjdk-8-jre 
CMD java -jar /var/autoScalingDemo-0.0.1-SNAPSHOT.jar
