# shortUrl

# 1.Subject
URL을 입력받아 짧게 줄여주고, Shortening된 URL을 입력하면 원래 URL로 리다이렉트하는 URL Shortening Service

# 2.Environment
- JDK 1.8
- Spring Boot
- MariaDB
- JSP
- jquery
- CSS

# 3.Install
Repository Clone

$ git clone https://github.com/wisdomkwak/shortUrl

# DB 생성

CREATE DATABASE 'shorturl'

# DB 유저 생성

CREATE USER 'test01'@'%' IDENTIFIED BY'test1234';

# 테이블 생성

CREATE TABLE URL(

ID INT NOT NULL AUTO_INCREMENT,

LONGURL VARCHAR(1024),

CNT INT NOT NULL DEFAULT 1,

PRIMARY KEY ( ID )

);

# 4.Usage
Build

$ mvn install

# Execute
$ java -jar target/test-1.0.0-BUILD-SNAPSHOT.war
