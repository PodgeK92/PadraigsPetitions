FROM tomcat:latest
ADD target/Padraigspetitions.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]