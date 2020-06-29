FROM openjdk:14-alpine
COPY build/libs/sppr-bot-*-all.jar sppr-bot.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "sppr-bot.jar"]