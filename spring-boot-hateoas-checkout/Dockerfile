FROM ubuntu:precise
#make sure the package repository is up to date
run apt-get update
run apt-get install -y less
run apt-get install -y software-properties-common
run apt-get install -y software-properties-common python-software-properties
run add-apt-repository -y ppa:webupd8team/java
run apt-get update

run echo "oracle-java8-installer shared/accepted-oracle-license-v1-1 boolean true" | debconf-set-selections
run apt-get install -y oracle-java8-installer

ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
ENV PATH $PATH:$JAVA_HOME/bin

COPY /target/checkout.jar /sources/app.jar
EXPOSE 8080
CMD java -Djava.security.egd=file:/dev/./urandom -jar /sources/app.jar


