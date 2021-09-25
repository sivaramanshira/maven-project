FROM maven:3.6.1-jdk-8 as maven_builder

FROM maven_builder as maven1
WORKDIR /app
COPY . /app/
RUN ls -l /app
RUN mvn clean install
RUN ls -l /app

FROM tomcat:8.5.43-jdk8 as prod
ENV ENV_NAME=prod
COPY --from=maven1 /app/webapp/target/webapp.war /usr/local/tomcat/webapps
RUN ls -la /usr/local/tomcat/webapps/*
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]

FROM maven_builder as maven2
WORKDIR /app
ADD maven-project/ /app/
RUN ls -l /app
RUN ls
RUN mvn clean install
RUN ls -l /app/

FROM tomcat:8.5.43-jdk8 as dev
ENV ENV_NAME=dev
COPY --from=maven2 /app/webapp/target/webapp.war /usr/local/tomcat/webapps
RUN ls -la /usr/local/tomcat/webapps/*
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
