package br.com.arthur.banco.service;

import br.com.arthur.banco.domain.exception.ClienteInexistenteException;
import br.com.arthur.banco.domain.exception.CpfDuplicadoException;
import br.com.arthur.banco.domain.model.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public void validarCpf(String cpf) {
        for(Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)) {
                throw new CpfDuplicadoException("Já existe um cliente cadastrado com o CPF "+cpf);
            }
        }
    }

    public Cliente cadastrarCliente(String nome, String cpf, LocalDate dataNascimento) {
        validarCpf(cpf);
        Cliente cliente = new Cliente(nome, cpf, dataNascimento);
        clientes.add(cliente);

        return cliente;
    }
    
    
    public Cliente removerCliente(String cpf) {
        Cliente cliente = buscarCliente(cpf);
        clientes.remove(cliente);
        return cliente;
    }

    public Cliente buscarCliente(String cpf) {
        for(Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        throw new ClienteInexistenteException("O cliente com CPF "+cpf+" não existe!");
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}