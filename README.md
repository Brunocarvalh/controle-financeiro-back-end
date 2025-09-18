# 💰 API de Controle Financeiro

API desenvolvida em **Spring Boot** com **PostgreSQL** para cadastro e gerenciamento de despesas por usuário.  
Inclui documentação automática com **Swagger/OpenAPI**.

---

## 🚀 Tecnologias

- Java 21  
- Spring Boot  
- Spring Data JPA  
- PostgreSQL  
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
## Endpoints

Cadastro de Usuários

````bash
localhost:8080
````

## POST
```bash
/user/insert
```
```
{
  "id": 0,
  "nome": "string",
  "email": "string",
  "senha": "string",
  "despesas": [
    {
      "id": 0,
      "nome": "string",
      "description": "string",
      "value": 0.1,
      "dataDespesa": "2025-09-18",
      "userId": 0
    }
  ]
}
```


---
## ⚙️ Configuração do Ambiente

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/controle-financeiro.git
cd controle-financeiro
