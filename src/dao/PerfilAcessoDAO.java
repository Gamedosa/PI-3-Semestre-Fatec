package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PerfilAcesso;
import util.ConexaoBD;

public class PerfilAcessoDAO {

    public static ArrayList<PerfilAcesso> listaPerfilAcessoDAO() {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        ArrayList<PerfilAcesso> perfis = new ArrayList<>();

        try {

            String sql = "SELECT * FROM perfil_acesso";
            pstmt = conexao.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                PerfilAcesso pa = new PerfilAcesso();
                pa.setIdperfilAcesso(rs.getInt("idperfil_acesso"));
                pa.setTipoPerfil(rs.getString("tipo_perfil"));

                perfis.add(pa);

            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar os tipos de perfis de acesso: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return perfis;

    }

    public static PerfilAcesso retornarPerfilAcessoDAO(int idPerfil) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PerfilAcesso pa = new PerfilAcesso();

        try {

            String sql = "SELECT * FROM perfil_acesso WHERE idperfil_acesso = ?";
            pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, idPerfil);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                pa.setIdperfilAcesso(rs.getInt("idperfil_acesso"));
                pa.setTipoPerfil(rs.getString("tipo_perfil"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao retornar o tipo de perfi de acesso: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return pa;
    }

    public static PerfilAcesso retornarPerfilAcessoPorTipoDAO(String tipoPerfill) {

        Connection conexao = ConexaoBD.conectar();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PerfilAcesso pa = new PerfilAcesso();

        try {

            String sql = "SELECT * FROM perfil_acesso WHERE tipo_perfil = ?";

            pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, tipoPerfill);
            rs = pstmt.executeQuery();

            if (rs.next()) {

                pa.setIdperfilAcesso(rs.getInt("idperfil_acesso"));
                pa.setTipoPerfil(rs.getString("tipo_perfil"));

            }

        } catch (SQLException e) {
            System.out.println("Erro ao retornar o tipo de perfi de acesso: " + e.getMessage());
        } finally {
            ConexaoBD.fecharConexao(conexao, pstmt, rs);
        }

        return pa;
    }

}
