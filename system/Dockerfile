# OpenJDK 17 tabanlı bir imaj kullanacağız
FROM openjdk:17-jdk-slim

# Jar dosyasının nereden alınacağını belirtiyoruz
ARG JAR_FILE=target/*.jar

# Jar dosyasını konteyner içerisine kopyalıyoruz
COPY ${JAR_FILE} app.jar

# Uygulamanın çalışacağı portu belirtiyoruz
EXPOSE 8080

# Uygulamanın çalıştırılma komutu
ENTRYPOINT ["java", "-jar", "/app.jar"]