# catalogo_de_produtos

Desenvolvimento de uma API Rest com Spring Boot

A API Rest está configurada para ser acessado na porta 8095, ela pode ser alterada no arquivo ‘application.properties’.

O projeto está usando o banco de dados em memória (h2).

Para subir o aplicativo, basta executar o comando “java -jar catalogodeprodutos-0.0.1-SNAPSHOT.jar” no terminal, ou subir pela IDE (exe: Eclipse).

Para acessar os endpoint foi utilizado o “Postman”.

Documentação da API pode ser acessada via Swagger

```shell
http://localhost:8095/swagger-ui.html
```

![Screenshot](screenshot-1.png)

Observações:
Faltou implementar o endpoint: “GET /products/search”; e
A validação dos endpoints através de script automatizado;
