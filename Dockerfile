FROM openjdk:17-jdk-slim

# wait-for-it 스크립트를 컨테이너로 복사
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh

# JAR 파일을 app.jar로 복사
ARG JAR_FILE=./build/libs/dockerprac-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# MySQL이 시작될 때까지 대기한 후 애플리케이션 실행
ENTRYPOINT ["/wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "/app.jar"]