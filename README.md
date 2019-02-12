# Projeto Estudo Spring OAuth2

Este é um projeto de estudo que foi utilizado o Spring Boot + Spring Security + Spring OAuth2.

O intuito foi implementar alguns endpoint responsável por gerar uma chave de licença para um software, onde este endpoint poderá ser acessado apenas após a autenticação do usuário através do oAuth2.

Endpoint de Autenticação
    Url : http://localhost:8080/oauth/token?grant_type=password&username=junior&password=123
    Method : POST
    Authorization : 
        tyspe : Basic Auth
        username : apigeradorlicenca
        password : apigeradorlicenca918273
        
Endpoint de Geração de Licença
    Url : http://localhost:8080/geradorLicenca/gerarToken
    Method : POST
    Headers : 
        Authorization : Bearer INFORMAR O TOKEN GERADO PELA CHAMADA AO ENDPOINT ANTERIOR
        Content-Type : application/json
    Body : raw
        {
          "urlSistema": "http://localhost/teste",
          "empresa": "Exemplo Smpresa",
          "idEmpresa": "2002",
          "cnpjEmpresa": "46.900.152/0001-41",
          "idOrganizacao": "2001",
          "qtdeDiaLicenca": 60
        }        
