package br.com.arthur.banco.domain.model;

import br.com.arthur.banco.domain.exception.SaldoInsuficienteException;

public abstract class Conta {
    protected String numero;
    protected String agencia;
    protected double saldo;
    protected Cliente cliente;

    public Conta(String numero, String agencia, double saldo, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }
    
    public void verificaValor(double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("O valor depositado deve ser maior do que 0");
        }
    }

    public void depositar(double valor) {
        verificaValor(valor);
        this.saldo += valor;
    }

    public abstract void sacar(double valor) throws SaldoInsuficienteException;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
