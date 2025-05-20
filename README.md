# java21

> brew install java  
> echo 'export PATH="/usr/local/opt/openjdk/bin:$PATH"' >> /Users/mauriciosimoes/.zshrc  
> java -version     
openjdk version "23.0.2" 2025-01-21
OpenJDK Runtime Environment Homebrew (build 23.0.2)
OpenJDK 64-Bit Server VM Homebrew (build 23.0.2, mixed mode, sharing)

Alternativa: Instalar o java através da própria página
https://jdk.java.net/24/

> brew install maven
> mvn -version
Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /usr/local/Cellar/maven/3.9.9/libexec
Java version: 23.0.2, vendor: Homebrew, runtime: /usr/local/Cellar/openjdk/23.0.2/libexec/openjdk.jdk/Contents/Home
Default locale: pt_BR, platform encoding: UTF-8s
OS name: "mac os x", version: "15.4.1", arch: "x86_64", family: "mac"

Plugins VSCode:
Extension Pack for Java	- Pacote oficial da Microsoft para Java
Spring Boot Extension Pack - Ferramentas para Spring Boot
Lombok Annotations - Suporte a anotações Lombok
Docker - Se for usar containers
PostgreSQL - Se for usar banco PostgreSQL

# D0 do projeto
> https://start.spring.io
Maven
Java
Spring Boot 3.5.0
Java 21
Dependencies:
- Spring Web (para APIs REST)
- Spring Data JPA (se usar banco de dados)
- Lombok (para reduzir boilerplate)

Comenta a parte de banco do pom.xml (spring-boot-starter-data-jpa)

> mvn spring-boot:run  

Se precisar rodar o build sem os testes
> mvn clean install -DskipTests 

# Hoje Levantar aplicação

> docker-compose up -d  
> docker ps  
> mvn spring-boot:run  
