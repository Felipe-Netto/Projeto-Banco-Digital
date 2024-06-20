package BancoDigital.Contas;

import BancoDigital.Cliente.Cliente;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente){
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor > saldo){
            System.out.println("Saldo insuficiente!");
        }else{
            saldo -= valor;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if(valor > saldo){
            System.out.println("Saldo insuficiente!");
        }else {
            sacar(valor);
            contaDestino.depositar(valor);
        }
    }

    public int getAgencia(){
        return agencia;
    }

    public int getNumero(){
        return numero;
    }

    public double getSaldo(){
        return saldo;
    }

    public Cliente getCliente(){
        return cliente;
    }

    protected void imprimirInfosConta(){
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("CPF do titular: " + cliente.getCpf());
        System.out.println("Agencia: " + getAgencia());
        System.out.println("Numero da conta: " + getNumero());
        System.out.println("Saldo: " + saldo + "\n");
    }

}
