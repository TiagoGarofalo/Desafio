package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.vo.LivroVO;

public class LivroDAO {

	public boolean verificaLivro(int idLivro) {
		String sql = "SELECT COUNT(*) FROM LIVRO WHERE ID_LIVRO = ?";
		boolean idJaCadastrado = false;
		
		Connection conn = ConexaoBanco.getConnection();
		PreparedStatement stmt = ConexaoBanco.getPreparedStatement(conn, sql);
		ResultSet resultado = null;
		try{
			stmt.setInt(1, idLivro);
			resultado = stmt.executeQuery();
			while(resultado.next()){
				int quantidadeRegistros = resultado.getInt(1);
				idJaCadastrado = (quantidadeRegistros > 0);
			}
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao consultar o Livro = " + idLivro);
		} finally {
			ConexaoBanco.closeResultSet(resultado);
			ConexaoBanco.closeStatement(stmt);
			ConexaoBanco.closeConnection(conn);
		}
		return idJaCadastrado;
	}

	public boolean update(LivroVO livro) {
		try {
			Connection conn = ConexaoBanco.getConnection();
			String sql = "UPDATE LIVRO SET TITULO = ?, AUTOR = ?, EDICAO=? WHERE ID_LIVRO= ?";

			PreparedStatement ps = ConexaoBanco.getPreparedStatement(conn, sql);

			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getEdicao());

			ps.execute();

			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean insert(LivroVO livro) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO LIVRO " + "(TITULO, AUTOR, EDICAO) " + "VALUES ( ?, ?, ?)");
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getAutor());
			ps.setString(3, livro.getEdicao());

			ps.execute();
			ps.close();
			conn.close();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
