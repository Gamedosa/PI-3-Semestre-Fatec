package controller;

import dao.ClienteDAO;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ControllerCliente {

    private final ClienteDAO clienteDAO;
    
    public ControllerCliente(){
        this.clienteDAO = new ClienteDAO();
    }
    
    public boolean controllerCadastrarCliente(Cliente cliente){
        return clienteDAO.cadastrarClienteDAO(cliente);
    }
    
    public boolean controllerAtualizarCliente(Cliente cliente){
        return clienteDAO.atualizarClienteDAO(cliente);
    }
    
    public boolean controllerExcluirCliente(int id){
        return clienteDAO.excluirClienteDAO(id);
    }
    
    public Cliente controllerRetornaCliente(int id){
        return clienteDAO.retonaClienteDAO(id);
    }
    
    public ArrayList<Cliente> controllerListaCliente(){
        return clienteDAO.listaClienteDAO();
    }
    
    public List<Cliente> controllerRetornarClientePorCpf(String cpf){
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente = clienteDAO.retonaClientePorCpfDAO(cpf);
        if(cliente != null){
            clientes.add(cliente);
        }
        
        return clientes;
    }
    
}
