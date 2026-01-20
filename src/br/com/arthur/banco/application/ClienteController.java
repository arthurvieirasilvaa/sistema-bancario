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
            this.ui.exibirMensagem("Nome: ");
            String nome = this.ui.lerTexto();

            this.ui.exibirMensagem("CPF: ");
            String cpf = this.ui.lerTexto();

            this.ui.exibirMensagem("Data de nascimento (dd/MM/yyyy): ");
            LocalDate dataNascimento = this.ui.lerData();

            Cliente cliente = this.clienteService.cadastrarCliente(nome, cpf, dataNascimento);
            this.ui.exibirMensagem("Cliente "+cliente.getNome()+" cadastrado com sucesso!\n");
        }catch (CpfDuplicadoException e) {
            this.ui.exibirMensagem("O CPF informado já existe!\n");
        }
        catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao cadastrar o cliente!\n");
        }
    }

    public void removerCliente() {
        try {
            this.ui.exibirMensagem("Informe o CPF do cliente que você deseja remover: ");
            String cpf = this.ui.lerTexto();

            Cliente cliente = this.clienteService.removerCliente(cpf);
            this.ui.exibirMensagem("Cliente "+cliente.getNome()+" removido com sucesso!\n");
        }catch (ClienteInexistenteException e) {
            this.ui.exibirMensagem("O cliente não existe!\n");
        }
        catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao remover o cliente!\n");
        }
    }

    public void visualizarDadosCliente() {
        try {
            this.ui.exibirMensagem("Informe o CPF do cliente que você obter os dados: ");
            String cpf = this.ui.lerTexto();

            Cliente cliente = this.clienteService.buscarCliente(cpf);
            this.ui.exibirMensagem("Dados do cliente:\n");
            this.ui.exibirMensagem("Nome: "+cliente.getNome()+"\n");
            this.ui.exibirMensagem("CPF: "+cliente.getCpf()+"\n");
            this.ui.exibirMensagem("Data de nascimento: "+cliente.getDataNascimento()+"\n");
        }catch (ClienteInexistenteException e) {
            this.ui.exibirMensagem("O cliente não existe!\n");
        }
        catch (Exception e) {
            this.ui.exibirMensagem("Ocorreu um erro ao buscar o cliente!\n");
        }
    }
}