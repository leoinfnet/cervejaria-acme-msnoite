FROM amazoncorretto:21
MAINTAINER leogloriainfnet
ENV SENHA_BANCO=123456
WORKDIR /app
COPY app.jar ./
ENTRYPOINT ["java", "-jar", "app.jar"]
