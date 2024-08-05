
## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [SpringDoc OpenAPI 3](https://springdoc.org/v2/#spring-webflux-support)
- [Mysql](https://www.postgresql.org/download/)


## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io)

O Swagger poderá ser visualizado em [localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- Criar Tarefa
```
$ http POST :8080/api/todos nome="Todo 1" descricao="Todo 1 descricao" prioridade=MEDIA

[
  {
    "descricao": "Todo 1 descricao",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": MEDIA,
    "realizado": false
  }
]
```

- Listar Tarefas
```
$ http GET :8080/api/todos

[
  {
    "descricao": "Todo 1 descricao",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": MEDIA,
    "realizado": false
  }
]
```

- Atualizar Tarefa
```
$ http PUT :8080/api/todos/1 nome="Todo 1" descricao="Todo 1 descricao" prioridade=BAIXA

[
  {
    "descricao": "Todo 1 descricao",
    "id": 1,
    "nome": "Todo 1",
    "prioridade": BAIXA,
    "realizado": false
  }
]
```

- Remover Tarefa
```
http DELETE :8080/api/todos/1

[ ]