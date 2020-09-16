# Custumer Service

### Requisitos

1. JDK 8
1. Maven 3

### Rodando

1. Clone o projeto: `https://github.com/diegopereira33/dpereiraofc-provapratica.git`

1. Entre na pasta `dpereirapofc-provapratica e execute: `mvn spring-boot:run`

1. Obtem token `http://localhost:8080/authenticate` - Body: 

   ```json
   {
       "username":"springuser",
       "password":"password"
   }
   ```

1. Acesse: `http://localhost:8080/customers` Authorization type: Bearer Token: *token*

1. Crie - POST: `http://localhost:8080/customers` Authorization type: Bearer Token: *token* - Body

```json
{
   "name": "teste",
   "email": "teste@email.com"
}
```



6. Atualize - PUT: `http://localhost:8080/customers/id` Authorization type: Bearer Token: *token* - Body 

```json
{
   "name": "java",
   "email": "java@email.com"
}
```

7. Delete - DELETE: `http://localhost:8080/customers/id` Authorization type: Bearer Token: *token* 



