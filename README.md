# 📧 Envio de E-mails com Spring Boot + Gmail SMTP

Este projeto permite o envio de e-mails usando o SMTP do Gmail, configurado de maneira dinâmica para facilitar testes.

## 🚀 Como Configurar

### 1️⃣ Clone o Repositório
```bash
git clone https://github.com/AndreCA1/Envio_de_Email.git
cd Envio_de_Email
```

### 2️⃣ Configure o E-mail do Gmail
Crie um arquivo **`.env`** sem nome na raiz do projeto e adicione suas credenciais SMTP:

```
SMTP_USER=seu-email@gmail.com
SMTP_PASS=sua-senha-de-app
```

⚠ **Importante:** Para usar o Gmail, você precisa gerar uma **Senha de App**:  
🔹 Acesse: [myaccount.google.com/apppasswords](https://myaccount.google.com/apppasswords)  
🔹 Gere uma senha e use-a no `SMTP_PASS`.  

### 3️⃣ Execute a Aplicação

Execute em alguma IDE ou com o Maven
```bash
mvn spring-boot:run
```
Agora a API estará rodando em `http://localhost:8080/api/emails`.

### 4️⃣ Teste o Envio de E-mail

Depois abra o arquivo index.hmtl localizado em "Envio_de_Email\src\main\resources\static\index.html" 
E tente enviar um E-mail

## 🔧 Configuração Automática de Variáveis
Este projeto carrega automaticamente as credenciais SMTP do Gmail do arquivo **`.env`**, graças à configuração no `application.properties`:

```properties
spring.config.import=optional:file:.env[.properties]
```

---

## 🛠 Tecnologias Utilizadas
- Java 17+
- Spring Boot 3+
- Spring Mail
- SMTP (Gmail)

---

## ❌ Segurança: Evitando Exposição de Credenciais
✔ O arquivo `.env` está **ignorado no Git** (`.gitignore`).
✔ **Nunca exponha suas credenciais diretamente no código-fonte**.

---

Agora você pode rodar o projeto e enviar e-mails com seu próprio Gmail! 🚀📨

