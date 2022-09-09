# great-desafio-backend

# Visão geral

O projeto é uma aplicação back-end com objetivo de demonstrar a produtividade de construir APIs utilizando o ecossistema [Spring Boot](https://projects.spring.io/spring-boot).

## Tecnologias

- [Spring Boot](https://projects.spring.io/spring-boot) é uma ferramenta que simplifica a configuração e execução de aplicações Java stand-alone,  com conceitos de dependências “starters”, auto configuração e servlet container embutidos é proporcionado uma grande produtividade desde o start-up da aplicação até sua ida a produção.

- [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) é um framework já consolidado no mercado, que a partir da versão fornece mecanismos simplificados para a criação de APIs RESTful através de anotação, além disso, também possui recursos de serialização e deserialização de objetos de forma transparente 
 
- [Spring Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web) Starter para construção de aplicações web, incluindo RESTful, usando Spring MVC. Usa o Tomcat como o contêiner incorporado padrão.
 
- [Spring Data](http://projects.spring.io/spring-data/) é um framework que abstrai o acesso ao modelo de dados, independente a tecnologia de base de dados.

# Setup da aplicação (local)

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 11
PostgreSQL 12
Maven
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/pinheirovictor/great-desafio-backend.git
```
Feito isso, acesse o projeto:
```
cd great-desafio-backend
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080
```
Tomcat started on port(s): 8080 (http)
Started AppConfig in xxxx seconds (JVM running for xxxx)
```

# API

O projeto disponibiliza uma API em 1 contexto diferentes: Usuario, onde utiliza o padrão Rest de comunicação, produzindo e consumindo arquivos no formato JSON.

#### Usuario

   - /usuarios (POST)
     - Espera as informações do modelo de dados Usário, exemplo:
       ```
             {
                "name":"jose",
                "cpf":"1555",
                "rg":"12345678",
                "birthDate":"2022-09-08",
                "motherName":"maria"
             }
        ```                
   - /usuarios (GET)
   - /usuarios?nome=victor (GET)
   - /usuarios?cpf=000 (GET)
   - /usuarios?rg=00 (GET)
   - /usuarios/cpf/000 (GET)
   - /usuarios/cpf/000 (DELETE)
