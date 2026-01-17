package br.com.arthur.banco.application;

import br.com.arthur.banco.domain.exception.ClienteInexistenteException;
import br.com.arthur.banco.domain.exception.CpfDuplicadoException;
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
        try {
            System.out.println("Nome: ");
            String nome = this.ui.lerTexto();

            System.out.println("CPF: ");
            String cpf = this.ui.lerTexto();

            System.out.println("Data de nascimento (dd/MM/yyyy): ");
            LocalDate dataNascimento = this.ui.lerData();

            Cliente cliente = this.clienteService.cadastrarCliente(nome, cpf, dataNascimento);
            System.out.println("Cliente "+cliente.getNome()+" cadastrado com sucesso!");
        }catch (CpfDuplicadoException e) {
            e.printStackTrace();
            System.out.println("O CPF informado já existe!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao cadastrar o cliente!");
        }
    }

    public void removerCliente() {
        try {
            System.out.println("Informe o CPF do cliente que você deseja remover: ");
            String cpf = this.ui.lerTexto();

            Cliente cliente = this.clienteService.removerCliente(cpf);
            System.out.println("Cliente "+cliente.getNome()+" removido com sucesso!");
        }catch (ClienteInexistenteException e) {
            e.printStackTrace();
            System.out.println("O cliente não existe!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao remover o cliente!");
        }
    }

    public void visualizarDadosCliente() {
        try {
            System.out.println("Informe o CPF do cliente que você obter os dados: ");
            String cpf = this.ui.lerTexto();

            Cliente cliente = this.clienteService.buscarCliente(cpf);
            System.out.println("Dados do cliente:");
            System.out.println("Nome: "+cliente.getNome());
            System.out.println("CPF: "+cliente.getCpf());
            System.out.println("Data de nascimento: "+cliente.getDataNascimento());
        }catch (ClienteInexistenteException e) {
            e.printStackTrace();
            System.out.println("O cliente não existe!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao buscar o cliente!");
        }
    }
}