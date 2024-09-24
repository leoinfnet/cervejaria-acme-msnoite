FROM amazoncorretto:21
LABEL author=Lgloria
WORKDIR /app
COPY app.jar ./
EXPOSE 8888
ENTRYPOINT ["java", "-jar",  "app.jar"]
