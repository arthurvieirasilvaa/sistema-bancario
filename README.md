# 💰 Sistema Bancário em Java (POO)

## 📌 Descrição

Neste projeto, foi desenvolvido um **Sistema Bancário** em Java,
com foco na aplicação prática dos conceitos de Programação Orientada a Objetos (POO).

Dessa forma, o sistema simula funcionalidades básicas de um banco real,
como **cadastro de clientes**, **criação de contas**, **operações financeiras**
(depósitos, saques e transferências), entre outras.

Além disso, o sistema é executado no próprio console, sem interface gráfica,
utilizando apenas memória (sem banco de dados), sendo estruturado de forma que
possa facilitar a evolução para versões mais avançadas, com banco de dados e interface gráfica.

## 🛠️ Tecnologias Utilizadas

- Java;
- Intellij IDEA;
- Git;
- GitHub.

## 🧠 Conceitos de Programação Utilizados

- Classes e Objetos;
- Encapsulamento;
- Herança;
- Polimorfismo;
- Classes Abstratas;
- Exceções Customizadas.

## ⚙️ Funcionalidades

- Cadastro de Clientes;
- Criação de contas;
- Operações financeiras;
- Consulta de informações;
- Tratamento de erros.

## 🧱 Estrutura do Projeto

```
src
└── br
    └── com
        └── arthur
            └── banco
                ├── application
                │   ├── Main.java
                │   ├── Menu.java
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

