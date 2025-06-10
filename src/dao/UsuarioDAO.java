package dao;

import controller.ControllerPerfilAcesso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PerfilAcesso;
import model.Usuario;
import util.ConexaoBD;

public class UsuarioDAO {

    public static boolean cadastrarUsuarioDAO(Usuario usuario) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "INSERT INTO usuario (nome, login, senha, perfil_acesso) VALUES (?, ?, ?, ?)";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setInt(4, usuario.getPerfilAcesso().getIdperfilAcesso());

            int linhaAfetadas = pstmt.executeUpdate();
            return linhaAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public static boolean atualizarUsuarioDAO(Usuario usuario) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ?, perfil_acesso = ? WHERE idusuario = ?";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setString(1, usuario.getNome());
            pstmt.setString(2, usuario.getLogin());
            pstmt.setString(3, usuario.getSenha());
            pstmt.setInt(4, usuario.getPerfilAcesso().getIdperfilAcesso());
            pstmt.setInt(5, usuario.getIdusuario());

            int linhaAfetadas = pstmt.executeUpdate();
            return linhaAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public static boolean excluirUsuarioDAO(int id) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "DELETE FROM usuario WHERE idusuario = ?";
            pstmt = conexao.prepareStatement(sql);

            pstmt.setInt(1, id);

            int linhaAfetadas = pstmt.executeUpdate();
            return linhaAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public static ArrayList<Usuario> listaUsuarioDAO() {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {

            String sql = "SELECT * FROM usuario";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("idusuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));

                int idPerfil_acesso = rs.getInt("perfil_acesso");

                ControllerPerfilAcesso cpa = new ControllerPerfilAcesso();
                PerfilAcesso perflAcesso = cpa.controllerRetornarPerfilAcesso(idPerfil_acesso);

                usuario.setPerfilAcesso(perflAcesso);

                usuarios.add(usuario);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return usuarios;
    }

    public Usuario retornarUsuarioDAO(int id) {

        Usuario u = null;

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT  idusuario, nome, login, senha, perfil_acesso FROM usuario WHERE idusuario = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdusuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                int idPerfil_acesso = rs.getInt("perfil_acesso");

                ControllerPerfilAcesso cpa = new ControllerPerfilAcesso();
                PerfilAcesso perflAcesso = cpa.controllerRetornarPerfilAcesso(idPerfil_acesso);
                u.setPerfilAcesso(perflAcesso);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return u;

    }

    public Usuario validaUsuarioDAO(Usuario usuario) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Usuario usuarioValidado = null;

        try {

            String sql = "SELECT idusuario, nome, login, senha, perfil_acesso FROM usuario WHERE login = ? AND senha = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, usuario.getLogin());
            pstmt.setString(2, usuario.getSenha());
            rs = pstmt.executeQuery();

            if (rs.next()) {
                usuarioValidado = new Usuario();
                usuarioValidado.setIdusuario(rs.getInt("idUsuario"));
                usuarioValidado.setNome(rs.getString("nome"));
                usuarioValidado.setLogin(rs.getString("login"));
                usuarioValidado.setSenha(rs.getString("senha"));

                int idPerfil_acesso = rs.getInt("perfil_acesso");

                ControllerPerfilAcesso cpa = new ControllerPerfilAcesso();
                PerfilAcesso perflAcesso = cpa.controllerRetornarPerfilAcesso(idPerfil_acesso);
                                
                if(perflAcesso != null){
                    
                    String tipoAcesso = perflAcesso.getTipoPerfil();
                    
                    usuarioValidado.setPerfilAcesso(perflAcesso);
                    
                }else{
                    System.out.println("Perfil de Acesso não encontrado para o ID informado: "+ idPerfil_acesso);
                }

            }

        } catch (SQLException e) {
            System.out.println("Erro ao validar usuários: " + e.getMessage());
        }finally{
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }
        
        return usuarioValidado;

    }
    
    public Usuario retornarUsuarioPeloNomeDAO(String nome) {

        Usuario u = null;

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT  idusuario, nome, login, senha, perfil_acesso FROM usuario WHERE nome = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nome);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                u = new Usuario();
                u.setIdusuario(rs.getInt("idUsuario"));
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));

                int idPerfil_acesso = rs.getInt("perfil_acesso");

                ControllerPerfilAcesso cpa = new ControllerPerfilAcesso();
                PerfilAcesso perflAcesso = cpa.controllerRetornarPerfilAcesso(idPerfil_acesso);
                u.setPerfilAcesso(perflAcesso);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return u;

    }

}
