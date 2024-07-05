# Sistema de Seleção de curriculo 📃

[Link do Projeto](https://github.com/arimateia-souza/selecao-curriculo)

## Índice

- [Sobre](#sobre-)
- [Funcionalidades](#funcionalidades-)
- [Ferramentas](#ferramentas-)
- [Implementações adicionais](#implementações-adicionais-)
- [Como Usar](#como-usar-)
- [Contato](#contato-)

## Sobre 📄

Projeto desenvolvido para teste pratico de estágio que tem cum formulario
com campos: nome, email, telefone, cargoDesejado, escolaridade
observacoes, curriculo, ip, dataEnvio, CEP e Arquivo. Após o envio das informaçoes para o
formulario, é enviado uma mensagem de email com as informaçoes preenchidas no formulario
para quem realizou o envio do formulario endereco;

## Funcionalidades 💻

- Enviar formulario
- Anexar arquivo .pdf, .docx ou .doc
- Todos os dados inseridos pelo usuário são cadastrados em um banco de dados
- Cadastrar endereço inserindo apenas o CEP


## Ferramentas 🛠

- Spring-boot-starter-data-jpa
- Starter-thymeleaf
- Starter-validation
- Starter-web
- Devtools
- Postgresql
- Lombok
- Servlet-api
- Jackson-databind
- Starter-mail
- Gson
## Implementações adicionais ➕
O endereço do usuário com os campos: cep, logradouro, bairro, uf são preenchidos automaticamente após o usuario informar seu CEP no formulario.
O preenchimento desses campos são feitos consumindo a API: [via cep](https://viacep.com.br).
## Como Usar 📘

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/arimateia-souza/selecao-curriculo.git
2. **Configurar o banco de dados:** 
Substitua as variaveis no arquivo .properties
   1. DATABASE_HOST=````seuhost````;
   2. DATABASE_NAME=````NomeDoSeuBD````;
   3. DATABASE_USERNAME=````nomeDoSeuUsuarioBD````;
   4. DATABASE_PASSWORD=````senhaDoBD````;

3. **Configurar o banco de dados:**
   Foi usado o [Mailtrap](https://mailtrap.io/) para fazer o envio de emails enquanto teste da aplicação.
Substitua as variaveis no arquivo .properties pelas suas credenciais.
    1. MAIL_USER=````user````;
    2. MAIL_PASSWORD=````senha````;

## Contato ✉

GitHub - [arimateia-souza](https://github.com/arimateia-souza)

LinkedIn - [arimateia-souza](https://github.com/arimateia-souza)