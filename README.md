# Desafio Itaú

## Introdução

Este é um desafio do Itaú que consiste em criar uma API que irá expor um endpoint para verificar se uma determinada senha é válida, seguindo os critérios abaixo:

- Nove ou mais caracteres
- Ao menos 1 dígito
- Ao menos 1 letra minúscula
- Ao menos 1 letra maiúscula
- Ao menos 1 caractere especial
    - Considere como especial os seguintes caracteres: !@#$%^&*()-+
- Não possuir caracteres repetidos dentro do conjunto

Exemplo:

```c#
IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true
```

> **_Nota:_**  Espaços em branco não devem ser considerados como caracteres válidos.
## Descrição do Projeto

Para a execução deste Desafio, foi criado um Projeto Web, utilizando a linguagem Java e o framework Spring.

## Executando a Aplicação

**1.** Clone o Projeto do Git em seu Ambiente de Desenvolvimento 

**2.** Dentro do diretorio do projeto clonado, execute o seguinte comando:
```mvn clean install```

**3.** Para executar a aplicação, execute o seguinte comando:
```mvn spring-boot:run```

## Consumindo a API

Ao executar a aplicação, será disponibilizado a seguinte API:

```
POST /challenge/api/password HTTP/1.1
Host: http://localhost:8080
Content-Type: application/json
```

A API foi criada para receber uma determinada senha a ser validada. A senha deverá ser enviada no **body** da requisição, e o conteúdo no formato Json, conforme a seguir:
```
{
	"password": "123mudar"
}
```
O retorno da API consiste em valor booleano igual a **true**, se a senha for válida ou **false** caso algum requisito(citados anteriormente) não for atendido.


## Validações implementadas

Para validar a senha recebida pela API foram implementados alguns métodos, visando contemplar os cenários abaixo:

- Verificar se uma string contém algum dígito numérico
- Verificar se uma string contém algum caracter com UpperCase
- Verificar se uma string contém algum caracter com LowerCase
- Validar se a senha tem os caracteres especiais válidos
- Validar se a senha tem algum caracter duplicado.


## Executando os testes automatizados

com intuito em garantir a qualidade da solução foram implementados diversos Testes Unitários, os quais podem ser executados com o seguinte comando:
```mvn test``` 



