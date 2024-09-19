FROM amazoncorretto:21
LABEL author=Lgloria
ENV SENHA_BANCO=123456
WORKDIR /app
COPY app.jar ./
ENTRYPOINT ["java", "-jar",  "app.jar"]
