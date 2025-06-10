package dao;

import controller.ControllerOrcamentoProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Orcamento;
import model.OrcamentoProduto;
import model.Produto;
import model.StatusOrcamento;
import model.Usuario;
import util.ConexaoBD;

public class OrcamentoDAO {

    public boolean cadastrarOrcamentoDAO(Orcamento orcamento) {
        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();
        ResultSet rs = null;

        try {
            // Insere o orçamento
            String sqlOrcamento = "INSERT INTO orcamento (codigo_orcamento, cliente, usuario, data_inicio, data_termino, periodo, valor_liquido, valor_total, desconto, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            pstmt = conexao.prepareStatement(sqlOrcamento, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, orcamento.getCodigo_orcamento());
            pstmt.setInt(2, orcamento.getCliente().getIdcliente());
            pstmt.setInt(3, orcamento.getUsuario().getIdusuario());
            pstmt.setDate(4, new java.sql.Date(orcamento.getDataInicio().getTime()));
            pstmt.setDate(5, new java.sql.Date(orcamento.getDataTermino().getTime()));
            pstmt.setInt(6, orcamento.getPeriodo());
            pstmt.setDouble(7, orcamento.getValorLiquido());
            pstmt.setDouble(8, orcamento.getValorTotal());
            pstmt.setDouble(9, orcamento.getDesconto());
            pstmt.setString(10, orcamento.getStatus().name()); // Corrigido para usar name()
            pstmt.executeUpdate();

            // Obtém o ID do orçamento inserido
            int idOrcamento = -1;
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idOrcamento = rs.getInt(1);
            }

            // Verifica se o registro já existe
            String sqlVerificaDuplicata = "SELECT * FROM orcamento_produto WHERE idorcamento = ? AND idproduto = ? AND quantidade = ?";
            PreparedStatement pstmtVerifica = conexao.prepareStatement(sqlVerificaDuplicata);
            for (Produto produto : orcamento.getProdutos()) {
                pstmtVerifica.setInt(1, idOrcamento);
                pstmtVerifica.setInt(2, produto.getIdproduto());
                pstmtVerifica.setInt(3, produto.getQuantidade());
                ResultSet rsVerifica = pstmtVerifica.executeQuery();

                // Se o registro já existe, não insere novamente
                if (rsVerifica.next()) {
                    continue; // Pula para a próxima iteração do loop
                }

                // Se o registro não existe, insere normalmente
                OrcamentoProduto op = new OrcamentoProduto();
                op.setIdorcamento(idOrcamento); // Define o ID de orçamento para o produto
                op.setIdproduto(produto.getIdproduto()); // Define o ID do produto
                op.setProdutoValor(produto.getPreco()); // Define o valor do produto
                op.setQuantidade(produto.getQuantidade()); // Define a quantidade do produto
                OrcamentoProdutoDAO opDAO = new OrcamentoProdutoDAO();
                opDAO.cadastrarOrcamentoProdutoDAO(op);
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }
    }

    public boolean atualizarOrcamentoDAO(Orcamento orcamento) {
        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();

        try {
            // Verifica se o cliente existe antes de atualizar o orçamento
            if (!clienteExiste(orcamento.getCliente().getIdcliente())) {
                System.out.println("Cliente não encontrado.");
                return false;
            }

            // Atualiza o orçamento
            String sqlOrcamento = "UPDATE orcamento SET codigo_orcamento = ?, cliente = ?, usuario = ?, data_inicio = ?, data_termino = ?, periodo = ?,valor_liquido = ?, valor_total = ?, desconto = ?, status = ? WHERE idorcamento = ?";
            pstmt = conexao.prepareStatement(sqlOrcamento);
            pstmt.setString(1, orcamento.getCodigo_orcamento());
            pstmt.setInt(2, orcamento.getCliente().getIdcliente());
            pstmt.setInt(3, orcamento.getUsuario().getIdusuario());
            pstmt.setDate(4, new java.sql.Date(orcamento.getDataInicio().getTime()));
            pstmt.setDate(5, new java.sql.Date(orcamento.getDataTermino().getTime()));
            pstmt.setInt(6, orcamento.getPeriodo());
            pstmt.setDouble(7, orcamento.getValorLiquido());
            pstmt.setDouble(8, orcamento.getValorTotal());
            pstmt.setDouble(9, orcamento.getDesconto());
            pstmt.setString(10, orcamento.getStatus().toString());
            pstmt.setInt(11, orcamento.getIdorcamento());
            pstmt.executeUpdate();

            // Remove todos os produtos associados ao orçamento
            ControllerOrcamentoProduto cop = new ControllerOrcamentoProduto();
            cop.controllerExcluirOP(orcamento.getIdorcamento());

            // Insere os novos produtos associados ao orçamento
            for (Produto produto : orcamento.getProdutos()) {
                OrcamentoProduto op = new OrcamentoProduto();
                op.setIdorcamento(orcamento.getIdorcamento()); // Define o ID do orçamento para o produto
                op.setIdproduto(produto.getIdproduto());
                op.setProdutoValor(produto.getPreco());
                op.setQuantidade(produto.getQuantidade());
                cop.controllerCadastrarOP(op);
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }
    }

// Método para verificar se o cliente existe
    private boolean clienteExiste(int idCliente) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.retonaClienteDAO(idCliente);
        return cliente != null;
    }

    public boolean deleteOrcamentoDAO(int idOrcamento) {
        PreparedStatement pstmt = null;
        Connection conexao = ConexaoBD.conectar();

        try {
            // Remove todos os produtos associados ao orçamento
            OrcamentoProdutoDAO opDAO = new OrcamentoProdutoDAO();
            opDAO.deletarOrcamentoProdutoDAO(idOrcamento);

            // Remove o orçamento da tabela orcamento
            String sqlDeleteOrcamento = "DELETE FROM orcamento WHERE idorcamento = ?";
            pstmt = conexao.prepareStatement(sqlDeleteOrcamento);
            pstmt.setInt(1, idOrcamento);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt);
        }
    }

    public ArrayList<Orcamento> ListaOrcamentoDAO() {
        ArrayList<Orcamento> listaOrcamentos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoBD.conectar();
            String sql = "SELECT o.codigo_orcamento, o.idorcamento, c.nome AS nome_cliente, u.nome AS nome_usuario, o.data_inicio, o.data_termino, o.periodo, o.valor_total, o.desconto, o.status "
                    + "FROM orcamento o "
                    + "JOIN cliente c ON o.cliente = c.idcliente "
                    + "JOIN usuario u ON o.usuario = u.idusuario";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Orcamento orcamento = new Orcamento();
                orcamento.setCodigo_orcamento(rs.getString("codigo_orcamento"));
                orcamento.setIdorcamento(rs.getInt("idorcamento"));

                Cliente cliente = new Cliente();
                cliente.setNome(rs.getString("nome_cliente"));
                orcamento.setCliente(cliente);

                Usuario usuario = new Usuario();
                usuario.setNome(rs.getString("nome_usuario"));
                orcamento.setUsuario(usuario);

                orcamento.setDataInicio(rs.getDate("data_inicio"));
                orcamento.setDataTermino(rs.getDate("data_termino"));
                orcamento.setPeriodo(rs.getInt("periodo"));
                orcamento.setValorTotal(rs.getDouble("valor_total"));
                orcamento.setDesconto(rs.getDouble("desconto"));
                orcamento.setStatus(StatusOrcamento.valueOf(rs.getString("status")));

                // Obtendo os produtos associados a este orçamento
                OrcamentoProdutoDAO opDAO = new OrcamentoProdutoDAO();
                ArrayList<OrcamentoProduto> produtos = opDAO.ListarOrcamentoProdutoDAO();

                // Preenchendo a lista de produtos do orçamento
                ArrayList<Produto> listaProdutos = new ArrayList<>();
                for (OrcamentoProduto op : produtos) {
                    Produto produto = new Produto();
                    produto.setIdproduto(op.getIdproduto());
                    produto.setPreco(op.getProdutoValor());
                    // Se necessário, preencher outros atributos do produto
                    listaProdutos.add(produto);
                }
                orcamento.setProdutos(listaProdutos);

                listaOrcamentos.add(orcamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return listaOrcamentos;
    }

    public Orcamento retornaOrcamentoDAO(int pIdOrcamento) {
        Orcamento orcamento = null;
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conexao = ConexaoBD.conectar();
            String sqlOrcamento = "SELECT o.codigo_orcamento, o.idorcamento, o.cliente, o.usuario, o.data_inicio, o.data_termino, o.periodo, o.valor_total, o.desconto, o.status, c.nome AS nome_cliente, u.nome AS nome_usuario "
                    + "FROM orcamento o "
                    + "JOIN cliente c ON o.cliente = c.idcliente "
                    + "JOIN usuario u ON o.usuario = u.idusuario "
                    + "WHERE o.idorcamento = ?";
            pstmt = conexao.prepareStatement(sqlOrcamento);
            pstmt.setInt(1, pIdOrcamento);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                orcamento = new Orcamento();
                orcamento.setCodigo_orcamento(rs.getString("codigo_orcamento"));
                orcamento.setIdorcamento(rs.getInt("idorcamento"));
                orcamento.setDataInicio(rs.getDate("data_inicio"));
                orcamento.setDataTermino(rs.getDate("data_termino"));
                orcamento.setPeriodo(rs.getInt("periodo"));
                orcamento.setValorTotal(rs.getDouble("valor_total"));
                orcamento.setDesconto(rs.getDouble("desconto"));
                orcamento.setStatus(StatusOrcamento.valueOf(rs.getString("status")));

                Cliente cliente = new Cliente();
                cliente.setIdcliente(rs.getInt("cliente"));
                cliente.setNome(rs.getString("nome_cliente")); // Supondo que o nome do cliente esteja na tabela cliente
                orcamento.setCliente(cliente);

                Usuario usuario = new Usuario();
                usuario.setIdusuario(rs.getInt("usuario"));
                usuario.setNome(rs.getString("nome_usuario")); // Supondo que o nome do usuário esteja na tabela usuario
                orcamento.setUsuario(usuario);

                // Buscando os produtos associados a este orçamento
                OrcamentoProdutoDAO opDAO = new OrcamentoProdutoDAO();
                List<OrcamentoProduto> listaOrcamentoProdutos = opDAO.retornaOrcamentoProdutoDAO(pIdOrcamento);

                // Preenchendo a lista de produtos do orçamento
                ArrayList<Produto> listaProdutos = new ArrayList<>();
                for (OrcamentoProduto op : listaOrcamentoProdutos) {
                    Produto produto = new Produto();
                    produto.setIdproduto(op.getIdproduto());
                    produto.setPreco(op.getProdutoValor());
                    // Se necessário, preencher outros atributos do produto
                    listaProdutos.add(produto);
                }
                orcamento.setProdutos(listaProdutos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return orcamento;
    }
}
