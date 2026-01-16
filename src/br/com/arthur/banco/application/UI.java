package br.com.arthur.banco.application;

import java.util.Scanner;

public class UI {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("##### Sistema Bancário #####");
        System.out.println("1) Cadastrar cliente;");
        System.out.println("2) Visualizar dados cliente;");
        System.out.println("3) Criar conta corrente;");
        System.out.println("4) Criar conta poupança;");
        System.out.println("5) Depositar;");
        System.out.println("6) Sacar;");
        System.out.println("7) Realizar transferência;");
        System.out.println("8) Consultar saldo;");
        System.out.println("9) Visualizar extrato;");
        System.out.println("0) Sair;");
        System.out.println("------------------------------------");
        System.out.println("Digite uma opção: ");
    }

    public short lerOpcao() {
        return scanner.nextShort();
    }

    public void cadastrarCliente() {

    }

    public void visualizarDadosCliente() {

    }

    public void criarContaCorrente() {

    }

    public void criarContaPoupanca() {

    }

    public void depositar() {

    }

    public void sacar() {

    }

    public void realizarTransferencia() {

    }

    public void consultarSado() {

    }

    public void visualizarExtrato() {

    }
}
