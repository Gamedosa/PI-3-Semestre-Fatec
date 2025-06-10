package controller;

import dao.UsuarioDAO;
import java.util.ArrayList;
import model.Usuario;

public class ControllerUsuario {

    UsuarioDAO uDAO;
    
    public ControllerUsuario(){
        this.uDAO = new UsuarioDAO();
    }
    
    public boolean controllerCadastrarUsuario(Usuario usuario){
        return uDAO.cadastrarUsuarioDAO(usuario);
    }
    
    public boolean controllerAtualizarUsuario(Usuario usuario){
        return uDAO.atualizarUsuarioDAO(usuario);
    }
    
    public boolean controllerExcluirUsuario(int id){
        return uDAO.excluirUsuarioDAO(id);
    }
    
    public ArrayList<Usuario> controllerListaUsuario(){
        return uDAO.listaUsuarioDAO();
    }
    
    public Usuario ControllerRetornarUsuario(int id){
        return uDAO.retornarUsuarioDAO(id);
    }
    
    public Usuario controllerValidaUsuario(Usuario usuario){
        return uDAO.validaUsuarioDAO(usuario);
    }
    
    public Usuario ControllerRetornaUsuarioPeloNome(String nome){
        return uDAO.retornarUsuarioPeloNomeDAO(nome);
    }
    
}
