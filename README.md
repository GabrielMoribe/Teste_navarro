# Webhook API - Teste Navarro Capital


## Proposta

Criar duas rotas:

- `POST /webhook` — recebe um JSON com `{ "id": 123, "mensagem": "Olá" }` e salva em memória.
- `GET /mensagens` — lista todas as mensagens recebidas.

Sem banco de dados — apenas estrutura.

## Como rodar

```bash
mvn spring-boot:run
```

A aplicação sobe na porta `8080`.

## Endpoints

### POST /webhook

Recebe e salva uma mensagem.

```
POST http://localhost:8080/webhook

{
  "id": 123,
  "mensagem": "Olá"
}
```

Resposta `201 Created`:
```json
{
  "id": 123,
  "mensagem": "Olá"
}
```

### GET /mensagens

Lista todas as mensagens salvas.

```
GET http://localhost:8080/mensagens
```

Resposta `200 OK`:
```json
[
  {
    "id": 123,
    "mensagem": "Olá"
  }
]
```