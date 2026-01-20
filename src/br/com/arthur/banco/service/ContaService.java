package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.exception.ContaInexistenteException;
import br.com.arthur.banco.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class ContaService {
    private final List<Conta> contas = new ArrayList<>();
    private static int SEQUENCIA_IDS = 1;

    private String gerarNumeroConta() {
        return String.valueOf(SEQUENCIA_IDS++);
    }

    public Conta criarContaCorrente(String agencia, Cliente cliente, double limite) {
        String numero = gerarNumeroConta();
        ContaCorrente contaCorrente = new ContaCorrente(numero, agencia, cliente, limite);
        contas.add(contaCorrente);

        return contaCorrente;
    }

    public Conta criarContaPoupanca(String agencia, Cliente cliente) {
        String numero = gerarNumeroConta();
        ContaPoupanca contaPoupanca = new ContaPoupanca(numero, agencia, cliente);
        contas.add(contaPoupanca);

        return contaPoupanca;
    }

    public Conta removerConta(String numero) {
        Conta conta = buscarConta(numero);
        contas.remove(conta);
        return conta;
    }

    public Conta buscarConta(String numero) {
        for(Conta conta : contas) {
            if(conta.getNumero().equals(numero)) {
                return conta;
            }
        }

        throw new ContaInexistenteException("A conta com o número "+numero+" não existe!");
    }

    public double consultarSaldo(String numero) {
        Conta conta = buscarConta(numero);
        return conta.getSaldo();
    }

    public List<Transacao> obterExtrato(String numero) {
        Conta conta = buscarConta(numero);
        return conta.getTransacoes();
    }
}