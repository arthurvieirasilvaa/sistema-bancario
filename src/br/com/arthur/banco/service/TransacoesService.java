package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;
import br.com.arthur.banco.domain.model.Conta;

public class TransacoesService {
    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) throws SaldoInsuficienteException {
        System.out.println("R$"+valor+" sacado com sucesso da conta!");
    }

    public void transferir(Conta origem, Conta destino, double valor) throws SaldoInsuficienteException {
        origem.sacar(valor);
        destino.depositar(valor);
    }
}
