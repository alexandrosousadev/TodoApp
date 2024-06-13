# TodoApp

Uma aplicação de lista de tarefas para gerenciar suas atividades diárias.

## Funcionalidades

- Adicionar novas tarefas
- Marcar tarefas como concluídas
- Excluir tarefas
- Visualizar lista de tarefas pendentes e concluídas

## Tecnologias Utilizadas

- Java (90.3%)
- Shell Script (6.4%)
- Batchfile (3.3%)

## Instalação

### Pré-requisitos

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) instalado
- [Apache Maven](https://maven.apache.org/install.html) instalado (se o projeto utilizar Maven para gerenciamento de dependências)

### Passos para instalação

1. Clone o repositório:
    ```sh
    git clone https://github.com/alexandrosousadev/TodoApp.git
    ```

2. Navegue até o diretório do projeto:
    ```sh
    cd TodoApp
    ```

3. Compile o projeto (se estiver usando Maven):
    ```sh
    mvn clean install
    ```

4. Execute o aplicativo:
    ```sh
    java -jar target/TodoApp.jar
    ```

### Scripts de Shell e Batch

- Para ambientes Unix/Linux, use os scripts Shell fornecidos:
    ```sh
    ./scripts/setup.sh
    ./scripts/start.sh
    ```

- Para ambientes Windows, use os scripts Batch fornecidos:
    ```cmd
    .\scripts\setup.bat
    .\scripts\start.bat
    ```

## Uso

- Abra o navegador e acesse `http://localhost:8080` para visualizar a aplicação.
- Adicione, marque como concluídas e exclua tarefas conforme necessário.

## Estrutura do Projeto

TodoApp
├── src
│ ├── main
│ │ ├── java
│ │ │ └── com
│ │ │ └── example
│ │ │ └── todo
│ │ │ ├── controller
│ │ │ │ └── TodoController.java
│ │ │ ├── model
│ │ │ │ └── Todo.java
│ │ │ └── service
│ │ │ └── TodoService.java
│ │ └── resources
│ │ └── application.properties
├── scripts
│ ├── setup.sh
│ ├── start.sh
│ ├── setup.bat
│ └── start.bat
├── pom.xml
├── README.md
└── target
└── TodoApp.jar

## Contribuição

1. Faça um fork do projeto.
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`).
3. Commite suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Faça push para a branch (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto está licenciado sob a Licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.TodoApp
