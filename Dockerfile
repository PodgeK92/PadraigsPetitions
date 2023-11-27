FROM tomcat:latest
ADD target/Padraigspetitions.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]