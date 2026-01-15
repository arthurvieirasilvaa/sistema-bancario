package br.com.arthur.banco.domain;

public abstract class Conta {
    private String numero;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    public Conta(String numero, String agencia, double saldo, Cliente cliente) {
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void verInformacoes() {
        System.out.println("###### Dados da Conta ######");
        System.out.println("Número: "+this.numero);
        System.out.println("Agência: "+this.agencia);
        System.out.println("Saldo: R$"+this.saldo);
        System.out.println("Nome do cliente: "+this.cliente.getNome());
        System.out.println("-----------------------------------");
    }

    public void depositar(double valor) {
        if(valor <= 0) {
            throw new IllegalArgumentException("O valor depositado deve ser maior do que 0");
        }

        this.saldo += valor;
        System.out.println("O valor de R$"+valor+" foi depositado com sucesso!");
    }

    public abstract void sacar(double valor);



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
