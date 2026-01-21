package br.com.arthur.banco.application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {
    private final Scanner scanner;
    public static final short OPCAO_SAIR = 0;
    public static final short OPCAO_VOLTAR = -1;

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenuPrincipal() {
        System.out.println("##### Sistema Bancário (Menu Principal) #####");
        System.out.println("1) Acessar menu clientes");
        System.out.println("2) Acessar menu contas");
        System.out.println("3) Acessar menu transações");
        System.out.println("0) Sair");
        System.out.println("------------------------------------");
        System.out.print("Digite uma opção: ");
    }

    public void exibirMenuClientes() {
        System.out.println("##### Sistema Bancário (Menu Clientes) #####");
        System.out.println("1) Cadastrar cliente");
        System.out.println("2) Remover cliente");
        System.out.println("3) Visualizar dados do cliente");
        System.out.println("-1) Voltar");
        System.out.println("------------------------------------");
        System.out.print("Digite uma opção: ");
    }

    public void exibirMenuContas() {
        System.out.println("##### Sistema Bancário (Menu Contas) #####");
        System.out.println("1) Criar conta corrente");
        System.out.println("2) Criar conta poupança");
        System.out.println("3) Remover conta");
        System.out.println("4) Consultar saldo");
        System.out.println("5) Visualizar extrato");
        System.out.println("6) Aplicar rendimento mensal em conta poupança");
        System.out.println("-1) Voltar");
        System.out.println("------------------------------------");
        System.out.print("Digite uma opção: ");
    }

    public void exibirMenuTransacoes() {
        System.out.println("##### Sistema Bancário (Menu Transações) #####");
        System.out.println("1) Depositar");
        System.out.println("2) Sacar");
        System.out.println("3) Realizar transferência");
        System.out.println("-1) Voltar");
        System.out.println("------------------------------------");
        System.out.print("Digite uma opção: ");
    }

    public void exibirMensagem(String mensagem) {
        System.out.print(mensagem);
    }

    public int lerOpcao() {
        while(true) {
            try {
                return Integer.parseInt(this.scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.\n");
            }
        }
    }

    public String lerTexto() {
        String texto = "";
        do {
            texto = this.scanner.nextLine().trim();
        } while(texto.isEmpty());

        return texto;
    }

    public LocalDate lerData() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                return LocalDate.parse(this.scanner.nextLine(), dateTimeFormatter);
            }catch (DateTimeParseException e) {
                System.out.println("Formato de data inválida! Use dd/MM/yyyy\n");
            }
        }
    }

    public double lerDecimal() {
        double numero;
        while (true) {
            try {
                numero = this.scanner.nextDouble();
                this.scanner.nextLine();
                return numero;
            }catch (InputMismatchException e) {
                this.scanner.nextLine();
                System.out.println("Entrada inválida! Informe um número.\n");
            }
        }
    }
}