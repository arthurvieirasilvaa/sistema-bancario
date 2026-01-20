package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.model.Conta;

public class TransacaoService {
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) {
        conta.sacar(valor);
    }

    public void transferir(Conta origem, Conta destino, double valor) {
        if(origem.equals(destino)) {
            throw new IllegalArgumentException("A conta de origem deve ser diferente da de destino!");
        }

        origem.sacar(valor);
        destino.depositar(valor);
    }
}