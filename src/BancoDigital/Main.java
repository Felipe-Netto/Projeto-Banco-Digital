package BancoDigital;

import BancoDigital.Cliente.ClientList;
import BancoDigital.Contas.ContasMap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op = 1;
        ClientList clientList = new ClientList();
        ContasMap contasMap = new ContasMap();
        OperacoesBanco operacoesBanco = new OperacoesBanco(scanner, clientList, contasMap);

        while (op != 0) {
            System.out.println("=== Banco Digital ===");
            System.out.println("1. Abrir conta");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Transferir");
            System.out.println("5. Consultar conta");
            System.out.println("6. Listar contas");
            System.out.println("0. Sair");
            try {
                op = scanner.nextInt();
                switch (op) {
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    case 1:
                        operacoesBanco.abrirConta();
                        break;
                    case 2:
                        operacoesBanco.realizarSaque();
                        break;
                    case 3:
                        operacoesBanco.realizarDeposito();
                        break;
                    case 4:
                        operacoesBanco.realizarTransferencia();
                        break;
                    case 5:
                        operacoesBanco.consultarConta();
                        break;
                    case 6:
                        operacoesBanco.listarContas();
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, insira um número.");
                scanner.next();
            }
        }
    }
}
