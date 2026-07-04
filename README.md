# ☕ Api-treino

Uma das minhas primeiras aplicações backend: API REST desenvolvida para praticar os fundamentos do ecossistema **Spring** — criação de endpoints, arquitetura em camadas (Controller → Service → Repository), persistência com Spring Data JPA e consultas derivadas (query methods).

> 📚 **Status:** projeto de estudos concluído (julho/2024). Esta foi uma das minhas primeiras aplicações backend — um CRUD completo da entidade `Pessoa` com validações e consultas customizadas, marcando meu ponto de partida no mundo Java/Spring.

## 🛠️ Tecnologias

- **Java 17**
- **Spring Boot 3.3** (Web, Data JPA, DevTools)
- **MySQL 8**
- **Lombok**
- **Maven**

## 🏗️ Arquitetura

O projeto segue a estrutura clássica em camadas do Spring:

```
src/main/java/br/com/projeto/api/
├── controller/    # Endpoints REST (Controller)
├── servico/       # Regras de negócio e validações (Servico)
├── repository/    # Acesso a dados com CrudRepository (Repositorio)
└── model/         # Entidades JPA (Pessoa, Mensagem)
```

## 📌 Endpoints

### CRUD de Pessoa

| Método | Rota | Descrição |
|--------|------|-----------|
| `POST` | `/api` | Cadastra uma pessoa (valida nome vazio e idade negativa) |
| `GET` | `/api` | Lista todas as pessoas |
| `GET` | `/api/{codigo}` | Busca pessoa pelo código |
| `PUT` | `/api` | Atualiza uma pessoa |
| `DELETE` | `/api/{codigo}` | Remove uma pessoa |

### Consultas customizadas (Query Methods)

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/api/contador` | Total de registros (`count`) |
| `GET` | `/api/ordenarNomes` | Lista ordenada por nome |
| `GET` | `/api/ordenarNomes2` | Filtra por nome e ordena por idade (desc) |
| `GET` | `/api/nomeContem` | Nomes que contêm um termo (`Containing`) |
| `GET` | `/api/iniciaCom` | Nomes que iniciam com um termo (`StartsWith`) |
| `GET` | `/api/terminaCom` | Nomes que terminam com um termo (`EndsWith`) |
| `GET` | `/api/somaIdades` | Soma das idades via `@Query` nativa |

### Endpoints de teste

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/teste` | Verifica se a API está no ar |
| `GET` | `/boasVindas/{nome}` | Retorna saudação com `@PathVariable` |
| `POST` | `/pessoa` | Ecoa o objeto recebido no `@RequestBody` |
| `GET` | `/status` | Retorna status HTTP 201 |

### Exemplo de requisição

```http
POST /api
Content-Type: application/json

{
  "nome": "Luan",
  "idade": 25
}
```

## 🚀 Como rodar

### Pré-requisitos

- Java 17+
- MySQL 8 rodando localmente

### Passo a passo

1. Clone o repositório:

```bash
git clone https://github.com/luanmvcosta0/Api-treino.git
cd Api-treino
```

2. Crie o banco de dados no MySQL:

```sql
CREATE DATABASE api_spring;
```

> As tabelas são criadas/atualizadas automaticamente pelo Hibernate (`ddl-auto=update`).

3. Configure as credenciais do banco via variáveis de ambiente:

```bash
export MYSQL_HOST=localhost
export MYSQL_USERNAME=root
export MYSQL_PASSWORD=sua_senha
```

4. Suba a aplicação com o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

A API ficará disponível em `http://localhost:8080`.

## 🎯 O que eu pratiquei nesse projeto

- Criação de API REST com Spring Web (`@RestController`, `@PathVariable`, `@RequestBody`)
- Arquitetura em camadas e injeção de dependências (`@Autowired`, `@Service`, `@Repository`)
- Persistência com Spring Data JPA e mapeamento de entidades (`@Entity`)
- Query methods derivados (`findBy...Containing`, `StartsWith`, `OrderBy...Desc`)
- Consultas nativas com `@Query`
- Validações de entrada e respostas HTTP adequadas com `ResponseEntity`

---

Feito por [Luan Costa](https://github.com/luanmvcosta0) 👋
