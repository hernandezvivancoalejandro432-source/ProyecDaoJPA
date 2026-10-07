FROM tomcat:10.1-jdk17-temurin

WORKDIR /usr/local/tomcat

COPY target/ProyecDaoJPA-1.0-SNAPSHOT.war webapps/ROOT.war

EXPOSE 8081

CMD ["catalina.sh", "run"]