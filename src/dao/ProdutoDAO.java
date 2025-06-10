package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Produto;
import util.ConexaoBD;

public class ProdutoDAO {

    public boolean cadastrarProdutoDAO(Produto produto) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "INSERT INTO produto (nome, quantidade, preco, imagem, observacao) VALUES (?,?,?,?,?)";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setBytes(4, produto.getImagem());
            pstmt.setString(5, produto.getObservacao());

            int linhaAfetadas = pstmt.executeUpdate();
            return linhaAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário:" + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public boolean atualizarProdutoDAO(Produto produto) {
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "UPDATE produto SET nome = ?, quantidade = ?, preco = ?, imagem = ?, observacao = ? WHERE idproduto = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, produto.getNome());
            pstmt.setInt(2, produto.getQuantidade());
            pstmt.setDouble(3, produto.getPreco());
            pstmt.setBytes(4, produto.getImagem());
            pstmt.setString(5, produto.getObservacao());
            pstmt.setInt(6, produto.getIdproduto());

            int linhaAfetadas = pstmt.executeUpdate();
            return linhaAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário:" + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }
    }

    public boolean excluirProdutoDAO(int id) {
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;

        try {

            String sql = "DELETE FROM produto WHERE idproduto = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);

            int linhaAfetadas = pstmt.executeUpdate();
            return linhaAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário:" + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }
    }

    public Produto retornaProdutoDAO(int id){
        
        Produto produto = null;
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            String sql = "SELECT idproduto, nome, quantidade, preco, imagem, observacao FROM produto WHERE idproduto = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                produto = new Produto();
                produto.setIdproduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                
                byte[] imagem = rs.getBytes("imagem");
                produto.setImagem(imagem);
                
                produto.setObservacao(rs.getString("observacao"));
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao retornar produto: "+e.getMessage());
        }finally{
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }
        
        return produto;
        
    }
    
    public ArrayList<Produto> listaProdutoDAO(){
        
        Produto produto = null;
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> listaProduto = new ArrayList<>();
        
        try {
            
            String sql = "SELECT * FROM produto";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();
            
            while(rs.next()){
                produto = new Produto();
                produto.setIdproduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                
                byte[] imagem = rs.getBytes("imagem");
                produto.setImagem(imagem);
                
                produto.setObservacao(rs.getString("observacao"));
                
                listaProduto.add(produto);
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao retornar produto: "+e.getMessage());
        }finally{
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }
        
        return listaProduto;
        
    }
    
    public Produto retornaProdutoPeloNomeDAO(String nome){
        
        Produto produto = null;
        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            
            String sql = "SELECT * FROM produto WHERE nome LIKE ? ";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, '%'+nome+'%');
            rs = pstmt.executeQuery();
            
            if(rs.next()){
                produto = new Produto();
                produto.setIdproduto(rs.getInt("idproduto"));
                produto.setNome(rs.getString("nome"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));
                
                byte[] imagem = rs.getBytes("imagem");
                produto.setImagem(imagem);
                
                produto.setObservacao(rs.getString("observacao"));
            }
            
        } catch (SQLException e) {
            System.out.println("Erro ao retornar produto: "+e.getMessage());
        }finally{
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }
        
        return produto;
        
    }
}
