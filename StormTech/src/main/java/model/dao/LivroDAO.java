package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.vo.LivroVO;

public class LivroDAO {

	public ArrayList<LivroVO> realizarConsultas(String consulta) throws SQLException {

		String parametros = "";

		if (consulta.equalsIgnoreCase("1")) {
			parametros = " ORDER BY TITULO ASC";
		}

		if (consulta.equalsIgnoreCase("2")) {
			parametros = " ORDER BY AUTOR ASC, TITULO DESC";
		}

		if (consulta.equalsIgnoreCase("3")) {
			parametros = " ORDER BY EDICAO DESC, AUTOR DESC, TITULO ASC";
		}

		if (consulta.equalsIgnoreCase("4")) {
			parametros = " ORDER BY ANO ASC";
		}

		String query = " SELECT * FROM LIVRO" + parametros;

		Connection conexao = ConexaoBanco.getConnection();
		PreparedStatement prepStmt = ConexaoBanco.getPreparedStatement(conexao, query);
		ArrayList<LivroVO> consultas = new ArrayList<LivroVO>();

		ResultSet result = prepStmt.executeQuery();

		try {
			while (result.next()) {
				LivroVO l = new LivroVO();

				// Obtendo valores pelo nome da coluna da tabela

				l.setIdLivro(result.getInt("ID_LIVRO"));
				l.setTitulo(result.getString("TITULO"));
				l.setAutor(result.getString("AUTOR"));
				l.setEdicao(result.getString("EDICAO"));
				consultas.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return consultas;
	}
}
