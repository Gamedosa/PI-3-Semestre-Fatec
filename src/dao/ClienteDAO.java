package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cliente;
import util.ConexaoBD;

public class ClienteDAO {

    public boolean cadastrarClienteDAO(Cliente cliente) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "INSERT INTO cliente ("
                    + "nome, "
                    + "cpf, "
                    + "celular, "
                    + "email, "
                    + "cep, "
                    + "logradouro, "
                    + "numero, "
                    + "complemento, "
                    + "bairro, "
                    + "localidade, "
                    + "uf) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getCelular());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getCep());
            pstmt.setString(6, cliente.getLogradouro());
            pstmt.setString(7, cliente.getNumero());
            pstmt.setString(8, cliente.getComplemento());
            pstmt.setString(9, cliente.getBairro());
            pstmt.setString(10, cliente.getLocalidade());
            pstmt.setString(11, cliente.getUf());

            int linhaAfetada = pstmt.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao inserir cliente: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public boolean atualizarClienteDAO(Cliente cliente) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "UPDATE cliente SET "
                    + "nome = ?, "
                    + "cpf = ?, "
                    + "celular = ?,"
                    + "email = ?, "
                    + "cep = ?, "
                    + "logradouro = ?, "
                    + "numero = ?, "
                    + "complemento = ?, "
                    + "bairro = ?, "
                    + "localidade = ?, "
                    + "uf = ? "
                    + "WHERE idcliente = ?";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getCelular());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getCep());
            pstmt.setString(6, cliente.getLogradouro());
            pstmt.setString(7, cliente.getNumero());
            pstmt.setString(8, cliente.getComplemento());
            pstmt.setString(9, cliente.getBairro());
            pstmt.setString(10, cliente.getLocalidade());
            pstmt.setString(11, cliente.getUf());
            pstmt.setInt(12, cliente.getIdcliente());

            int linhaAfetada = pstmt.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cliente: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public boolean excluirClienteDAO(int id) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "DELETE FROM cliente WHERE idcliente = ?";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);

            int linhaAfetada = pstmt.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar cliente: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public Cliente retonaClienteDAO(int id) {

        Cliente cliente = null;
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT idcliente, "
                    + "nome, "
                    + "cpf,"
                    + "celular,"
                    + "email,"
                    + "cep,"
                    + "logradouro,"
                    + "numero,"
                    + "complemento,"
                    + "bairro,"
                    + "localidade,"
                    + "uf "
                    + "FROM cliente WHERE idcliente = ?";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setLocalidade(rs.getString("localidade"));
                cliente.setUf(rs.getString("uf"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao carregar o usuário: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return cliente;
    }

    public ArrayList<Cliente> listaClienteDAO() {

        Cliente cliente = null;
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<Cliente> listaCliente = new ArrayList<>();

        try {

            String sql = "SELECT * FROM cliente";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setLocalidade(rs.getString("localidade"));
                cliente.setUf(rs.getString("uf"));
                
                listaCliente.add(cliente);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: "+e.getMessage());
        }finally{
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }
        
        return listaCliente;

    }

    public Cliente retonaClientePorCpfDAO(String cpf) {

        Cliente cliente = null;
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {

            String sql = "SELECT idcliente, "
                    + "nome, "
                    + "cpf,"
                    + "celular,"
                    + "email,"
                    + "cep,"
                    + "logradouro,"
                    + "numero,"
                    + "complemento,"
                    + "bairro,"
                    + "localidade,"
                    + "uf "
                    + "FROM cliente WHERE cpf = ?";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, cpf);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("idcliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setCelular(rs.getString("celular"));
                cliente.setEmail(rs.getString("email"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setNumero(rs.getString("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setBairro(rs.getString("bairro"));
                cliente.setLocalidade(rs.getString("localidade"));
                cliente.setUf(rs.getString("uf"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao carregar o usuário: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return cliente;
    }
    
}
