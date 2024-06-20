package BancoDigital;

import BancoDigital.Cliente.Cliente;
import BancoDigital.Contas.Conta;
import BancoDigital.Cliente.ClientList;
import BancoDigital.Contas.ContasMap;

import java.util.Scanner;

public class OperacoesBanco {
    private static Scanner scanner;
    private static ClientList clientList;
    private static ContasMap contasMap;

    public OperacoesBanco(Scanner scanner, ClientList clientList, ContasMap contasMap) {
        this.scanner = scanner;
        this.clientList = clientList;
        this.contasMap = contasMap;
    }

    public static void abrirConta() {
        System.out.println("=== Abrir Conta ===");
        System.out.print("Digite seu nome: ");
        String nome = scanner.next();
        System.out.print("Digite seu cpf: ");
        String cpf = scanner.next();
        clientList.adicionarCliente(nome, cpf);

        System.out.println("Qual tipo de conta deseja abrir?");
        System.out.println("1. Conta corrente");
        System.out.println("2. Conta poupanca");
        int opConta = scanner.nextInt();

        if (opConta == 1 || opConta == 2) {
            boolean clienteEncontrado = false;
            boolean contaExistente = false;

            for (Cliente c : clientList.getClienteList()) {
                if (c.getCpf().equalsIgnoreCase(cpf) && c.getNome().equalsIgnoreCase(nome)) {
                    clienteEncontrado = true;

                    for (Conta conta : contasMap.getContasMap().values()) {
                        if (conta.getCliente().getCpf().equalsIgnoreCase(cpf)) {
                            contaExistente = true;
                            break;
                        }
                    }

                    if (contaExistente) {
                        System.out.println("Já existe uma conta com esse CPF");
                    } else {
                        if (opConta == 1) {
                            contasMap.adicionarContaCorrente(cpf, c);
                            System.out.println("Conta corrente criada com sucesso!");
                        } else {
                            contasMap.adicionarContaPoupanca(cpf, c);
                            System.out.println("Conta poupança criada com sucesso!");
                        }
                    }
                    break;
                }
            }

            if (!clienteEncontrado) {
                System.out.println("Cliente não encontrado na lista.");
            }
        } else {
            System.out.println("Opção inválida!");
        }
    }

    public void realizarSaque() {
        System.out.println("=== Saque ===");

        Conta contaSaque = null;

        System.out.print("Digite o valor do saque: ");
        double valorSaque = scanner.nextDouble();

        System.out.print("Digite o número da sua conta: ");
        int numeroConta = scanner.nextInt();

        for(Conta c : contasMap.getContasMap().values()){
            if(c.getNumero() == numeroConta){
                contaSaque = c;
            }
        }

        if(contaSaque != null){
            contaSaque.sacar(valorSaque);
            System.out.println("Seu saldo atual é: " + contaSaque.getSaldo());
        }else{
            System.out.println("Conta não encontrada!");
        }
    }

    public void realizarDeposito() {
        System.out.println("=== Depósito ===");

        System.out.print("Digite o valor do depósito: ");
        double valorDeposito = scanner.nextDouble();

        System.out.print("Digite o número da sua conta: ");
        int numeroConta = scanner.nextInt();

        if (valorDeposito <= 0) {
            System.out.println("O valor do depósito deve ser positivo.");
            return;
        }

        Conta contaDeposito = null;

        for (Conta c : contasMap.getContasMap().values()) {
            if (c.getNumero() == numeroConta) {
                contaDeposito = c;
                break;
            }
        }

        if (contaDeposito != null) {
            contaDeposito.depositar(valorDeposito);
            System.out.println("Depósito realizado com sucesso!");
            System.out.println("Seu saldo atual é: " + contaDeposito.getSaldo());
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void realizarTransferencia() {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        System.out.print("Digite o número da sua conta: ");
        int numeroConta = scanner.nextInt();
        System.out.print("Digite o valor a ser transferido: ");
        double valorTransfer = scanner.nextDouble();
        System.out.print("Digite a conta destino: ");
        int numeroContaTransfer = scanner.nextInt();

        for(Conta c : contasMap.getContasMap().values()){
            if(c.getNumero() == numeroConta){
                contaOrigem = c;
                break;
            }
        }

        for(Conta cd : contasMap.getContasMap().values()){
            if(cd.getNumero() == numeroContaTransfer){
                contaDestino = cd;
                break;
            }
        }

        if(contaOrigem != null && contaDestino != null){
            contaOrigem.transferir(valorTransfer, contaDestino);
            System.out.println("Seu saldo atual é de: " + contaOrigem.getSaldo());
        }else{
            if(contaOrigem == null){
                System.out.println("Conta de origem não encontrada");
            }
            if(contaDestino == null){
                System.out.println("Conta de destino não encontrada");
            }
        }
    }

    public void consultarConta() {
        System.out.println("=== Consultar Conta ===");

        System.out.print("Digite o número da sua conta: ");
        int numeroConta = scanner.nextInt();

        Conta contaExtrato = null;

        for (Conta c : contasMap.getContasMap().values()) {
            if (c.getNumero() == numeroConta) {
                contaExtrato = c;
                break;
            }
        }

        if (contaExtrato != null) {
            contaExtrato.exibirExtrato();
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    public void listarContas() {
        System.out.println("=== Listar Contas ===");

        for (Conta c : contasMap.getContasMap().values()) {
            c.exibirExtrato();
        }
    }
}

