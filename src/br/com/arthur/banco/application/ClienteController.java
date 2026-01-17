package br.com.arthur.banco.application;

import br.com.arthur.banco.domain.model.Cliente;
import br.com.arthur.banco.service.ClienteService;

import java.time.LocalDate;

public class ClienteController {
    private final UI ui;
    private final ClienteService clienteService;

    public ClienteController(UI ui, ClienteService clienteService) {
        this.ui = ui;
        this.clienteService = clienteService;
    }

    public void cadastrarCliente() {
        System.out.println("Nome: ");
        String nome = ui.lerTexto();

        System.out.println("CPF: ");
        String cpf = ui.lerTexto();

        System.out.println("Data de nascimento (dd/MM/yyyy): ");
        LocalDate dataNascimento = ui.lerData();

        Cliente cliente = clienteService.cadastrarCliente(nome, cpf, dataNascimento);

        if(cliente == null) {
            System.out.println("Ocorreu um erro ao cadastrar o cliente!");
        }

        else {
            System.out.println("Cliente "+cliente.getNome()+" cadastrado com sucesso!");
        }
    }

    public void removerCliente() {
        System.out.println("Informe o CPF do cliente que você deseja remover: ");
        String cpf = ui.lerTexto();

        Cliente cliente = clienteService.removerCliente(cpf);

        if(cliente == null) {
            System.out.println("Ocorreu um erro ao remover o cliente!");
        }

        else {
            System.out.println("Cliente "+cliente.getNome()+" removido com sucesso!");
        }
    }

    public void visualizarDadosCliente() {
        System.out.println("Informe o CPF do cliente que você obter os dados: ");
        String cpf = ui.lerTexto();

        Cliente cliente = clienteService.buscarCliente(cpf);

        if(cliente == null) {
            System.out.println("Ocorreu um erro ao buscar o cliente!");
        }

        else {
            System.out.println("Dados do cliente:");
            System.out.println("Nome: "+cliente.getNome());
            System.out.println("CPF: "+cliente.getCpf());
            System.out.println("Data de nascimento: "+cliente.getDataNascimento());
        }
    }
}