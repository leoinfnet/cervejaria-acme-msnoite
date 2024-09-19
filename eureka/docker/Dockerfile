FROM amazoncorretto:21
LABEL author=Lgloria
EXPOSE 8761
WORKDIR /app
COPY app.jar ./
ENTRYPOINT ["java", "-jar",  "app.jar"]
