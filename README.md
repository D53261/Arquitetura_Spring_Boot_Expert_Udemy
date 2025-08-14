# README dos estudos sobre arquitetura Spring
## Parte do curso: Spring Boot Expert: JPA, REST, JWT, OAuth2 com Docker e AWS
Aqui estão apresentados os códigos usados durante a realização do curso da plataforma Udemy com nome mencionado acerca de uma sessão: Arquitetura do Spring Framework.

<hr></hr>

## Arquitetura Spring no Projeto

Este projeto utiliza a arquitetura do Spring Framework para organizar o código em camadas bem definidas, facilitando o desenvolvimento, manutenção e testes. As principais camadas presentes nas pastas montadora e todos são:


## 1. Controller
   Camada responsável por receber as requisições HTTP, processar os dados de entrada e retornar respostas. Os controllers usam anotações como @RestController e @RequestMapping para definir rotas e métodos HTTP. Exemplos: MontadoraController e TodoController.


## 2. Service
   Contém a lógica de negócio da aplicação. Os serviços recebem dados dos controllers, processam regras e interagem com os repositórios. São marcados com @Service. Exemplos: MontadoraService e TodoService.


## 3. Repository
   Camada de acesso a dados, responsável por operações de CRUD no banco. Utiliza interfaces que estendem JpaRepository, permitindo que o Spring Data gere automaticamente os métodos de persistência. Exemplos: MontadoraRepository e TodoRepository.


## 4. Entity
   Modelos de dados que representam as tabelas do banco. São anotados com @Entity e possuem atributos que refletem as colunas das tabelas. Exemplos: MontadoraEntity e TodoEntity.


## 5. Validação e Tratamento de Erros
   O projeto pode conter validações customizadas para garantir regras de negócio, como evitar duplicidade de registros. Exceções são lançadas e tratadas para garantir respostas adequadas ao cliente.

## 6. Configurações
   O Spring Boot permite configurar diversos aspectos da aplicação por meio de arquivos como application.properties ou application.yml, além de classes Java anotadas com @Configuration. Nessas configurações, é possível definir parâmetros de conexão com banco de dados, portas, perfis de ambiente, beans customizados e integrações externas.

### Exemplo de configurações comuns:


* application.properties: Define propriedades como URL do banco, usuário, senha, porta do servidor, etc.
* Classes com @Configuration: Permitem criar beans personalizados, configurar CORS, segurança, entre outros.

Essas configurações tornam o projeto flexível e adaptável a diferentes ambientes e necessidades.

<hr></hr> Essa arquitetura segue o padrão MVC (Model-View-Controller) adaptado para APIs REST, promovendo separação de responsabilidades e reutilização de código. Cada pasta (montadora e todos) possui seus próprios controllers, services, repositories e entities, tornando o projeto modular e organizado.

## Feito por:
### Danilo Ribeiro 
### Linkedin: https://www.linkedin.com/in/danilo-ribeiro-catroli-da-silva/
### Email: danilo051007@gmail.com
