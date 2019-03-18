# Projeto Estudo Spring Boot - OAuth2

Este é um projeto de estudo que foi utilizado o Spring Boot + Spring Security + Spring OAuth2.

O intuito foi implementar alguns endpoint responsável por gerar uma chave de licença para um software, onde este endpoint poderá ser acessado apenas após a autenticação do usuário através do oAuth2.

- Endpoint Autenticação OAuth2
    - Url : http://localhost:8080/oauth/token?grant_type=password&username=junior&password=123
    - Method : POST
    - Authorization : 
    ```
    type : Basic Auth
    username : apigeradorlicenca
    password : apigeradorlicenca918273
    ``` 
    
- Endpoint Geração De Licença Software
    - Url : http://localhost:8080/geradorLicenca/gerarToken
    - Method : POST
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json
    - Body : raw
    ```
        { 
            "urlSistema": "http://localhost/teste",
            "empresa": "Exemplo Empresa",
            "idEmpresa": "2002",
            "cnpjEmpresa": "46.900.152/0001-41",
            "idOrganizacao": "2001",
            "qtdeDiaLicenca": 60 
        }
    ```

- Endpoint Listar Perfil
    - Url : http://localhost:8080/perfil/listar
    - Method : POST
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json

- Endpoint Listar Usuário
    - Url : http://localhost:8080/usuario/listar
    - Method : POST
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json

- Endpoint Listar Usuário Paginado
    - Url : http://localhost:8080/usuario/listarPaginado/0/1
    - Method : GET
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json
 
- Endpoint Gravar Usuário
    - Url : http://localhost:8080/usuario/gravar
    - Method : POST
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json
    - Body : raw
    ```
        {
            "nome" : "tet",
            "email" : "teste",
            "senha" : "123"
        }
    ```
 
- Endpoint Alterar Usuário
    - Url : http://localhost:8080/usuario/alterar
    - Method : PUT
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json
    - Body : raw
    ```
        {
            "id": "5c8fdd486a1d482818f1a4f4",
            "nome" : "priscila",
            "email" : "priscila",
            "senha" : "123",
            "perfis": [
                {
                    "id": "5c01319b1a76720d5c43f848",
                    "nome": "ROLE_ADMIN",
                    "authority": "ROLE_ADMIN"
                }
            ]
        }
    ```
    
- Endpoint Excluir Usuário
    - Url : http://localhost:8080/usuario/excluir/ID_CLIENTE
    - Method : DELETE
    - Headers : 
        - Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        - Content-Type : application/json
