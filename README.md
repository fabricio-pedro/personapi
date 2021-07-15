# Person Api

Esse projeto faz parte da parte pratica do Santander Bootcamp | Fullstack Developer oferecido pela DIO

Essa api tem as operações básica de um crud (create, read, update, delete) para recurso pessoa.\
Você pode baixar esse projeto em formato zip ou cloná-lo através deste repositório.

Para executar esse projeto você deve usar o terminal, mudar para pasta do projeto e digitar:

./mvnw spring-boot:run\

Deve ser observar que o projeto esta configurado para perfil de desenvolvimento se quiser mudar de perfil, digite:

./mvnw spring-boot:run\ -Dspring.profiles.active=prod

Deve se lembrar de criar antes o arquivo applications-prod.properties e escrever algumas propriedades para o banco de
dados desejado bem definir no pom as dependencias do banco de dados.

As tecnologias utilizadas neste projeto são:\
* Spring Boot
* Spring Data JPA
* Spring Boot DevTools
* H2
* Lombok

Apesar deste projeto cumprir como proposto pelo Bootcamp pretendo aprimorá-lo acrescentando outros recursos, como por exemplo segurança,
utilizando para isso o spring boot security. Caso queira acompanhar, seja bem vindo.

