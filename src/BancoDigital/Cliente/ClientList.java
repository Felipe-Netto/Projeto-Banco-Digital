package BancoDigital.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClientList {

    List<Cliente> clienteList;

    public ClientList(){
        clienteList = new ArrayList<>();
    }

    public void adicionarCliente(String nome, String cpf){
        clienteList.add( new Cliente(nome, cpf) );
    }

    public List<Cliente> getClienteList(){
        return clienteList;
    }
}
