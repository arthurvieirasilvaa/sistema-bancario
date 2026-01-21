# 💰 Sistema Bancário em Java

## 📌 Descrição

Neste projeto, foi desenvolvido um **Sistema Bancário** em Java,
com foco na aplicação prática dos conceitos de Programação Orientada a Objetos (POO)
e na organização do código por **camadas de responsabilidade**.

Dessa forma, o sistema simula funcionalidades básicas de um banco real,
como **cadastro de clientes**, **criação de contas**, **operações financeiras**
(depósitos, saques e transferências), **consulta de saldo** e **visualização de extrato**,
incluindo o **registro de transações financeiras**.

Além disso, o sistema é executado no próprio console, sem interface gráfica,
utilizando apenas memória (sem banco de dados), sendo estruturado de forma que
possa facilitar a evolução para versões mais avançadas, com banco de dados e interface gráfica.

## 🛠️ Tecnologias Utilizadas

- Java;
- Intellij IDEA;
- Git;
- GitHub.

## 🧠 Conceitos de Programação Utilizados

- Programação Orientada a Objetos (POO);
- Classes e Objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Classes Abstratas;
- Exceções Customizadas;
- Enum;
- Separação de responsabilidade (arquitetura em camadas);
- Validações de regras de negócios.

## ⚙️ Funcionalidades

### 👤 Clientes
- Cadastro de clientes;
- Remoção de clientes;
- Consulta de dados dos clientes;
- Validação de CPF duplicado.

### 🏦 Contas Bancárias
- Criação de contas (corrente e poupança);
- Remoção de contas;
- Consulta de saldo;
- Visualização de extrato bancário com histórico de operações;
- Aplicação de rendimento mensal em conta poupança.

### 💸 Transações
- Depósito;
- Saque (com validação de saldo e limite);
- Transferência entre contas;
- Registro automático de transações.

## 🧱 Arquitetura do Projeto

O projeto está organizado em camadas, seguindo boas práticas de design:

- **application:** interface com o usuário, menus e *controllers*;
- **domain.exception:** exceções customizadas do domínio;
- **domain.model:** entidades do domínio (Cliente, Conta, Transação, entre outras.);
- **service:** regras de negócio e validações.


## 📂 Estrutura do Projeto

```
src
└── br
    └── com
        └── arthur
            └── banco
                ├── application
                │   ├── ClienteController.java
                │   ├── ContaController.java
                │   ├── Main.java
                │   ├── Menu.java
                │   ├── TransacaoController.java
                │   └── UI.java
                ├── domain
                │   ├── exception
                │   │   ├── ClienteInexistenteException.java
                │   │   ├── ContaInexistenteException.java
                │   │   ├── CpfDuplicadoException.java
                │   │   └── SaldoInsuficienteException.java
                │   └── model
                │       ├── Cliente.java
                │       ├── Conta.java
                │       ├── ContaCorrente.java
                │       ├── ContaPoupanca.java
                │       ├── TipoTransacao.java
                │       └── Transacao.java
                └── service
                    ├── ClienteService.java
                    ├── ContaService.java
                    └── TransacoesService.java

```

## 🚀 Como Executar

### Pré-requisitos

- Java JDK 17 (ou superior);
- Intellij IDEA (ou outra IDE Java);
- Git.

### Passos

1. Clonar o repositório:

```
git clone https://github.com/arthurvieirasilvaa/sistema-bancario.git
```

2. Abra o projeto no Intellij IDEA
3. Execute a classe: br.com.arthur.banco.application.Main

