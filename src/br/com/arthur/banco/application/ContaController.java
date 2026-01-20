package br.com.arthur.banco.application;

import br.com.arthur.banco.domain.exception.ClienteInexistenteException;
import br.com.arthur.banco.domain.exception.ContaInexistenteException;
import br.com.arthur.banco.domain.model.Cliente;
import br.com.arthur.banco.domain.model.Conta;
import br.com.arthur.banco.service.ClienteService;
import br.com.arthur.banco.service.ContaService;

import java.util.List;

public class ContaController {
    private final UI ui;
    private final ContaService contaService;
    private final ClienteService clienteService;

    public ContaController(UI ui, ContaService contaService, ClienteService clienteService) {
        this.ui = ui;
        this.contaService = contaService;
        this.clienteService = clienteService;
    }

    private Cliente buscarCliente() {
        System.out.print("CPF do cliente: ");
        String cpf = this.ui.lerTexto();

        return this.clienteService.buscarCliente(cpf);
    }

    public void criarContaCorrente() {
        try {
            System.out.print("Agência: ");
            String agencia = this.ui.lerTexto();

            Cliente cliente = buscarCliente();

            System.out.print("Limite da conta: ");
            double limite = this.ui.lerDecimal();

            Conta conta = this.contaService.criarContaCorrente(agencia, cliente, limite);
            System.out.println("A conta corrente da agência "+conta.getAgencia()+" e número "+conta.getNumero()+" foi criada com sucesso!");
        }catch (ClienteInexistenteException e) {
            e.printStackTrace();
            System.out.println("O cliente não existe!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao criar a conta corrente");
        }
    }

    public void criarContaPoupanca() {
        try {
            System.out.print("Agência: ");
            String agencia = this.ui.lerTexto();

            Cliente cliente = buscarCliente();

            Conta conta = this.contaService.criarContaPoupanca(agencia, cliente);
            System.out.println("A conta poupança da agência "+conta.getAgencia()+" e número "+conta.getNumero()+" foi criada com sucesso!");
        }catch (ClienteInexistenteException e) {
            e.printStackTrace();
            System.out.println("O cliente não existe!");
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao criar a conta poupança");
        }
    }

    public void removerConta() {
        try {
            System.out.print("Informe o número da conta que será removida: ");
            String numero = this.ui.lerTexto();

            Conta conta = this.contaService.removerConta(numero);
            System.out.println("A conta de número "+conta.getNumero()+" foi removida com sucesso!");
        }catch (ContaInexistenteException e) {
            e.printStackTrace();
            System.out.println("A conta não existe!");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao remover o cliente!");
        }
    }

    public void consultarSado() {
        try {
            System.out.print("Informe o número da conta que você deseja consultar o saldo: ");
            String numero = this.ui.lerTexto();

            double saldo = this.contaService.consultarSaldo(numero);
            System.out.println("O saldo da conta é R$"+saldo);
        }catch (ContaInexistenteException e) {
            e.printStackTrace();
            System.out.println("A conta não existe!");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao consultar o saldo!");
        }
    }

    public void visualizarExtrato() {
        try {
            System.out.print("Informe o número da conta que você deseja visualizar o extrato: ");
            String numero = this.ui.lerTexto();

            List<String> extrato = this.contaService.visualizarExtrato(numero);
            for(String info : extrato) {
                System.out.println(info);
            }
        }catch (ContaInexistenteException e) {
            e.printStackTrace();
            System.out.println("A conta não existe!");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao visualizar o extrato!");
        }
    }
}