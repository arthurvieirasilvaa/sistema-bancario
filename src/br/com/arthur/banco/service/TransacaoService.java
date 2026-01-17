package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;
import br.com.arthur.banco.domain.model.Conta;

public class TransacaoService {
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) throws SaldoInsuficienteException {
        conta.sacar(valor);
    }

    public void transferir(Conta origem, Conta destino, double valor) throws SaldoInsuficienteException {
        origem.sacar(valor);
        destino.depositar(valor);
    }
}
