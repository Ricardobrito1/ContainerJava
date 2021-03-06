FROM ubuntu
WORKDIR /root/appjava
COPY App.java /root/appjava
#Instal JDK
RUN apk add openjdk8 
ENV JAVA_HOME /usr/lib/jvm/java-1.8-openjdk
ENV  PATH $PATH:$JAVA_HOME/bin

#Compile our HelloWorld
run javac App.java

entrypoint java HJ