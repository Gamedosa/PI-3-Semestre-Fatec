package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.OrcamentoProduto;
import util.ConexaoBD;

public class OrcamentoProdutoDAO {

    public boolean cadastrarOrcamentoProdutoDAO(OrcamentoProduto OP) {
        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();

        try {
            String sql = "INSERT INTO orcamento_produto (idorcamento, idproduto, produtoValor, quantidade) VALUES (?, ?, ?, ?)";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, OP.getIdorcamento());
            pstmt.setInt(2, OP.getIdproduto());
            pstmt.setDouble(3, OP.getProdutoValor());
            pstmt.setInt(4, OP.getQuantidade());

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir Orçamento produto: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }
    }

    public boolean deletarOrcamentoProdutoDAO(int idOrcamentoProduto) {

        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();

        try {

            String sql = "DELETE FROM orcamento_produto WHERE idorcamento = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, idOrcamentoProduto);

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao excluir Orçamento produto:" + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public boolean atualizarOrcamentoProdutoDAO(OrcamentoProduto OP) {

        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();

        try {

            String sql = "UPDATE orcamento_produto SET "
                    + "idorcamento = ?,"
                    + "idproduto = ?,"
                    + "produtoValor =?,"
                    + "quantidade = ? "
                    + "WHERE id = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, OP.getIdorcamento());
            pstmt.setInt(2, OP.getIdproduto());
            pstmt.setDouble(3, OP.getProdutoValor());
            pstmt.setInt(4, OP.getQuantidade());
            pstmt.setInt(5, OP.getId());

            int linhasAfetadas = pstmt.executeUpdate();
            return linhasAfetadas > 0;

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Orçamento produto: " + e.getMessage());
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }

    }

    public List<OrcamentoProduto> retornaOrcamentoProdutoDAO(int idorcamento) {
        List<OrcamentoProduto> listaOrcamentoProdutos = new ArrayList<>();
        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();
        ResultSet rs = null;

        try {
            String sql = "SELECT idorcamento,idproduto,produtoValor,quantidade FROM orcamento_produto WHERE idorcamento = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, idorcamento);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                OrcamentoProduto op = new OrcamentoProduto();
                op.setIdorcamento(rs.getInt("idorcamento"));
                op.setIdproduto(rs.getInt("idproduto"));
                op.setProdutoValor(rs.getDouble("produtoValor"));
                op.setQuantidade(rs.getInt("quantidade"));
                listaOrcamentoProdutos.add(op);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return listaOrcamentoProdutos;
    }

    public ArrayList<OrcamentoProduto> ListarOrcamentoProdutoDAO() {
        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();
        ResultSet rs = null;
        OrcamentoProduto OP = null;

        ArrayList<OrcamentoProduto> listaOP = new ArrayList<>();

        try {

            String sql = "SELECT * FROM orcamento_produto";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                OP = new OrcamentoProduto();
                OP.setIdorcamento(rs.getInt("idorcamento"));
                OP.setIdproduto(rs.getInt("idproduto"));
                OP.setProdutoValor(rs.getDouble("produtoValor"));
                OP.setQuantidade(rs.getInt("quantidade"));

                listaOP.add(OP);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return listaOP;

    }

}
