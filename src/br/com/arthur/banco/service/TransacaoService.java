package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;
import br.com.arthur.banco.domain.model.Conta;

public class TransacaoService {
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) throws SaldoInsuficienteException {
        if(valor > conta.getSaldo()) {
            throw new SaldoInsuficienteException("O valor fornecido para saque é maior do que o saldo!");
        }
        conta.sacar(valor);
    }

    public void transferir(Conta origem, Conta destino, double valor) throws SaldoInsuficienteException {
        if(valor > origem.getSaldo()) {
            throw new SaldoInsuficienteException("O valor fornecido para saque é maior do que o saldo!");
        }
        origem.sacar(valor);
        destino.depositar(valor);
    }
}