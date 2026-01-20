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
            this.ui.exibirMensagem("Número da conta: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.buscarConta(numero);

            this.ui.exibirMensagem("Valor a ser depositado: R$");
            double valor = this.ui.lerDecimal();

            this.transacaoService.depositar(conta, valor);
            this.ui.exibirMensagem("Depósito de R$"+valor+" realizado com sucesso!\n");
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (IllegalArgumentException e) {
            this.ui.exibirMensagem("O valor depositado está inválido ou as contas de origem e destino são iguais!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao realizar o depósito!\n");
        }
    }

    public void sacar() {
        try {
            this.ui.exibirMensagem("Número da conta: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.buscarConta(numero);

            this.ui.exibirMensagem("Valor a ser sacado: R$");
            double valor = this.ui.lerDecimal();

            this.transacaoService.sacar(conta, valor);
            this.ui.exibirMensagem("Saque de R$"+valor+" realizado com sucesso!\n");
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (SaldoInsuficienteException e) {
            this.ui.exibirMensagem("Saldo insuficiente!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao realizar o saque!\n");
        }
    }

    public void realizarTransferencia() {
        try {
            this.ui.exibirMensagem("Número da conta de origem (saque): ");
            String numeroOrigem = this.ui.lerTexto();
            Conta origem = this.contaService.buscarConta(numeroOrigem);

            this.ui.exibirMensagem("Número da conta de destino (depósito): ");
            String numeroDestino = this.ui.lerTexto();
            Conta destino = this.contaService.buscarConta(numeroDestino);

            this.ui.exibirMensagem("Valor a ser transferido: R$");
            double valor = this.ui.lerDecimal();

            this.transacaoService.transferir(origem, destino, valor);
            this.ui.exibirMensagem("Transferência de R$"+valor+" realizada com sucesso!\n");
        }catch (ContaInexistenteException e) {
            this.ui.exibirMensagem("A conta não existe!\n");
        }catch (IllegalArgumentException e) {
            this.ui.exibirMensagem("O valor transferido está inválido!\n");
        }catch (SaldoInsuficienteException e) {
            this.ui.exibirMensagem("Saldo insuficiente!\n");
        }catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao realizar a transferência!\n");
        }
    }
}
