Bar System - Sistema de Gestão de Estoque 🍷

Um sistema completo e responsivo para gerenciamento de bares e restaurantes, focado no controle de estoque, fluxo de caixa e gestão de fornecedores. O projeto utiliza uma arquitetura monolítica com Spring Boot no backend e uma interface moderna em React.js (via CDN) integrada.

📸 Funcionalidades Principais

🔐 Segurança & Acesso

Multi-usuário: Sistema de Login e Cadastro real conectado ao banco de dados.

Isolamento de Dados: Cada usuário vê apenas o seu próprio estoque e faturamento.

📦 Controle de Estoque

CRUD Completo: Adicionar, editar e excluir bebidas.

Controle de Quantidade: Botões rápidos (+/-) para ajuste de estoque.

Alertas Visuais: Indicadores automáticos para produtos com estoque baixo (< 10 unidades).

Busca: Filtro em tempo real por nome ou categoria.

💰 Vendas & Financeiro

PDV (Ponto de Venda): Registro rápido de vendas com baixa automática no estoque.

Dashboard: Visão geral com Total de Produtos, Valor em Estoque e Itens Críticos.

Relatórios: Gráfico de Ranking dos produtos mais vendidos (Top 5) e Faturamento Diário.

🚚 Gestão

Fornecedores: Cadastro e gerenciamento de parceiros comerciais.

🚀 Tecnologias Utilizadas

Backend (API REST)

Java 17

Spring Boot 3 (Web, Data JPA)

PostgreSQL (Banco de dados relacional)

Lombok (Para redução de código boilerplate)

Frontend (Client-Side)

HTML5 & CSS3

React.js (Utilizado via CDN para simplicidade e leveza)

Tailwind CSS (Estilização utilitária e responsiva)

Lucide Icons (Ícones modernos)

📂 Estrutura do Projeto

src/
├── main/
│   ├── java/com/araujodev/...
│   │   ├── controller/   # Endpoints da API (Bebidas, Vendas, Usuários)
│   │   ├── model/        # Entidades do Banco (JPA)
│   │   └── repository/   # Comunicação com PostgreSQL
│   └── resources/
│       ├── application.properties # Configuração do Banco
│       └── static/
│           └── index.html         # Frontend (Single Page Application)


🛠️ Como Rodar o Projeto

Pré-requisitos

Ter o Java JDK 17 (ou superior) instalado.

Ter o PostgreSQL instalado e rodando.

Ter o Maven (opcional, se usar o wrapper do projeto).

Passo 1: Configurar o Banco de Dados

Crie um banco de dados no PostgreSQL chamado bar_db.
No arquivo src/main/resources/application.properties, ajuste seu usuário e senha:

spring.datasource.url=jdbc:postgresql://localhost:5432/bar_db
spring.datasource.username=seu_usuario_postgres
spring.datasource.password=sua_senha_postgres
spring.jpa.hibernate.ddl-auto=update


Passo 2: Executar o Backend

Abra o projeto no IntelliJ IDEA, Eclipse ou VS Code e execute a classe principal BarSystemApplication.java.

Ou via terminal:

./mvnw spring-boot:run


Passo 3: Acessar o Sistema

Com o backend rodando, abra o navegador e acesse:

🔗 http://localhost:8080

O Frontend será carregado automaticamente pela pasta static.

🤝 Contribuindo

Faça um Fork do projeto.

Crie uma Branch para sua Feature (git checkout -b feature/NovaFeature).

Faça o Commit (git commit -m 'Adicionando nova feature').

Faça o Push (git push origin feature/NovaFeature).

Abra um Pull Request.

📝 Licença

Este projeto está sob a licença MIT. Sinta-se à vontade para usar e modificar.

Desenvolvido com 💙 por Macelo Araujo
