#Information
I write this app to practice AWS services usage, and how to implement application for AWS architecture.

#Story of the application
We want to start a new startup **called TörökSoft =)** on the field of the image processing. We want to write an app, which do digital segmentation for our clients. This digital segmentation calculation need time, so we want to process the input images async, and present the results when our async job is done. We decided to write a web app where our client can upload the images, what they want to process. When the processing finished, we would send an email to the client with a link, where he can download the image.

## Features of our application
We need to handle the following features
* User registration
* User login
* File upload feature
* File download feature / list of finished images

# The architecture of our application
![arch](architecture.png)

#Resources
* http://cloud.spring.io/spring-cloud-aws/spring-cloud-aws.html
* https://en.wikipedia.org/wiki/Image_segmentation