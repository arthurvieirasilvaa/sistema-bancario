package br.com.arthur.banco.application;

import br.com.arthur.banco.domain.exception.ContaInexistenteException;
import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;
import br.com.arthur.banco.domain.model.Conta;
import br.com.arthur.banco.service.ContaService;
import br.com.arthur.banco.service.TransacaoService;

public class TransacaoController {
    private final UI ui;
    private final TransacaoService transacaoService;
    private final ContaService contaService;

    public TransacaoController(UI ui,
                               TransacaoService transacaoService,
                               ContaService contaService) {
        this.ui = ui;
        this.transacaoService = transacaoService;
        this.contaService = contaService;
    }

    public void depositar() {
        try {
            System.out.print("Número da conta: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.buscarConta(numero);

            System.out.print("Valor a ser depositado: R$");
            double valor = this.ui.lerDecimal();

            this.transacaoService.depositar(conta, valor);
            System.out.println("Depósito de R$"+valor+" realizado com sucesso!");
        }catch (ContaInexistenteException e) {
            e.printStackTrace();
            System.out.println("A conta não existe!");
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("O valor depositado está inválido!");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao realizar o depósito!");
        }
    }

    public void sacar() {
        try {
            System.out.print("Número da conta: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.buscarConta(numero);

            System.out.print("Valor a ser sacado: R$");
            double valor = this.ui.lerDecimal();

            try {
                this.transacaoService.sacar(conta, valor);
                System.out.println("Saque de R$"+valor+" realizado com sucesso!");
            }catch (SaldoInsuficienteException e) {
                e.printStackTrace();
                System.out.println("Saldo insuficiente!");
            }
        }catch (ContaInexistenteException e) {
            e.printStackTrace();
            System.out.println("A conta não existe!");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao realizar o saque!");
        }
    }

    public void realizarTransferencia() {
        try {
            System.out.println("Número da conta de origem (saque): ");
            String numeroOrigem = this.ui.lerTexto();
            Conta origem = this.contaService.buscarConta(numeroOrigem);

            System.out.println("Número da conta de destino (depósito): ");
            String numeroDestino = this.ui.lerTexto();
            Conta destino = this.contaService.buscarConta(numeroDestino);

            System.out.println("Valor a ser transferido: R$");
            double valor = this.ui.lerDecimal();

            try {
                this.transacaoService.transferir(origem, destino, valor);
            }catch (SaldoInsuficienteException e) {
                e.printStackTrace();
                System.out.println("Saldo insuficiente!");
            }
        }catch (ContaInexistenteException e) {
            e.printStackTrace();
            System.out.println("A conta não existe!");
        }catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.out.println("O valor transferido está inválido!");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao realizar a transferência!");
        }
    }
}