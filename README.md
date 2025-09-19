# 💰 API de Controle Financeiro

API desenvolvida em **Spring Boot** com **PostgreSQL** para cadastro e gerenciamento de despesas por usuário.  
Inclui documentação automática com **Swagger/OpenAPI**.

---

## 🚀 Tecnologias

- Java 21  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL 13.21
- Swagger (Springdoc OpenAPI)  

---

## 📌 Funcionalidades

- Cadastro de usuários (sem duplicar nomes).  
- Cadastro de despesas com:
  - Data
  - Descrição
  - Nome
  - Valor
  - Usuário associado
- Consulta de todas as despesas ou por usuário.
- Integração com banco de dados PostgreSQL.

---
## 🧑 Endpoints para usuários

Cadastro de Usuários

---

Endereço da aplicação
````bash
localhost:8080
````

## POST para inserir um usuário
```bash
/user/insert
```
Corpo da requisição

```
{
  "id": int,
  "nome": "string",
  "email": "string",
  "senha": "string",
}
```
---

## POST para inserir receita
```bash
/user/salary
```
Corpo da requisição

```
{
  "id": int,
  "salario": double
}
```
---

## GET para listar users
```bash
/user
```
Resposta esperada

```
{
    "id": 0,
    "nome": "string",
    "email": "string",
    "senha": "string"
  }
```
---

## PUT para atualizar dados do usuário
```bash
/user/update/{id}
```
Corpo da requisição

```
{
  "id": 0,
  "nome": "string",
  "email": "string",
  "senha": "string"
}
```

---

## DELETE para deletar um usuário

```bash
/user/{id}
```

Resposta esperada

```
{
  "success": true,
  "message": "string",
  "salario": 0.1
}
```

---

## 💸 Endpoints para Despesas

Cadastrar despesa

## POST 

```bash
/despesas
```

Corpo da requisição

```
{
  "id": 0,
  "nome": "string",
  "description": "string",
  "value": 0.1,
  "dataDespesa": "2025-09-19",
  "userId": 0
}
```

--- 

Listar despesas por usuário

## GET 

```bash
/despesas/usuario/{id}
```

Resposta esperada

```
[
  {
    "id": 0,
    "nome": "string",
    "description": "string",
    "value": 0.1,
    "dataDespesa": "2025-09-19",
    "userId": 0
  }
]
```

---

Obter saldo atual

## GET 

```bash
/despesas/saldo/{id}
```

Resposta esperada 

```
{
  "success": true,
  "message": "string",
  "salario": 100.0
}

```

Atualizar despesa 

## PUT

```bash
/despesas/update/{id}
```

Corpo da requisição

```
{
  "id": 0,
  "nome": "string",
  "description": "string",
  "value": 0.1,
  "dataDespesa": "2025-09-19",
  "userId": 0
}
```

---

Deletar uma despesa 

## DELETE

```bash
/despesas/delete/{id}
```

Resposta esperada

```
{
  "success": true,
  "message": "string",
  "salario": 0.1
}
```

---
## ⚙️ Configuração do Ambiente

### 1. Clonar o repositório
```bash
git clone https://github.com/brunocarvalh/controle-financeiro.git
cd controle-financeiro
