package br.com.arthur.banco.domain.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private final String cpf;
    private LocalDate dataNascimento;
    private final List<Conta> contas = new ArrayList<>();

    public Cliente(String nome, String cpf, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<Conta> getContas() {
        return List.copyOf(this.contas);
    }
}