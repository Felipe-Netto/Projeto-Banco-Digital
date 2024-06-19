package BancoDigital;

import BancoDigital.Cliente.Cliente;
import BancoDigital.Contas.Conta;
import BancoDigital.Contas.ContaCorrente;
import BancoDigital.Contas.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco();

        Cliente felipe = new Cliente("Felipe", "123.456.789-12");

        Conta contaCorrente = new ContaCorrente(felipe);
        Conta contaPoupanca = new ContaPoupanca(felipe);

        contaCorrente.depositar(100);
        contaCorrente.transferir(100, contaPoupanca);

        contaCorrente.exibirExtrato();
        contaPoupanca.exibirExtrato();


    }

}
