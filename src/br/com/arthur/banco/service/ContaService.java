package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.exception.ContaInexistenteException;
import br.com.arthur.banco.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class ContaService {
    private List<Conta> contas = new ArrayList<>();

    public Conta criarContaCorrente(String agencia, Cliente cliente, double limite) {
        double numero = (int) (Math.random() * 100);
        ContaCorrente contaCorrente = new ContaCorrente(String.valueOf(numero), agencia, 0, cliente, limite);
        contas.add(contaCorrente);

        return contaCorrente;
    }

    public Conta criarContaPoupanca(String agencia, Cliente cliente) {
        double numero = (int) (Math.random() * 100);
        ContaPoupanca contaPoupanca = new ContaPoupanca(String.valueOf(numero), agencia,0, cliente);
        contas.add(contaPoupanca);

        return contaPoupanca;
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

    public List<String> visualizarExtrato(String numero) {
        Conta conta = buscarConta(numero);
        List<String> extrato = new ArrayList<>();

        for(Transacao transacao : conta.getTransacoes()) {
            extrato.add(transacao);
        }

        return extrato;
    }
}