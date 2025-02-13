# InternBank

Este é um projeto de exemplo para gerenciar transações bancárias.

## Estrutura do Projeto

- `src/`: Código-fonte do projeto
- `Dockerfile`: Arquivo de configuração do Docker
- `docker-compose.yml`: Arquivo de configuração do Docker Compose
- `README.md`: Documentação do projeto

## Como Rodar o Projeto

### Usando Docker e Docker Compose

1. Certifique-se de que Docker e Docker Compose estão instalados na sua máquina.
2. Compile o projeto com `mvn clean package`.
3. Execute o comando `docker-compose up --build` para iniciar o contêiner.

### Sem Docker

1. Certifique-se de que o Java está instalado na sua máquina.
2. Compile o projeto com `mvn clean package`.
3. Execute o comando `java -jar target/internbank.jar`.

## Contribuição

Contribuições são bem-vindas! Por favor, envie um pull request ou abra uma issue para discutir mudanças.

## Licença

Este projeto está licenciado sob a licença MIT.
