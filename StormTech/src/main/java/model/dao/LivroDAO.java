package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.vo.LivroVO;

public class LivroDAO {

	public boolean verificaLivro(int idLivro) {
		// TODO Auto-generated method stub
		return false;
	}

	public void update(LivroVO livro) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean insert(LivroVO livro) {
		Connection conn = ConexaoBanco.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO livro " + "(nome, ano, autor) " + "VALUES ( ?, ?, ?)");
			ps.setString(1, livro.getNome());
			ps.setString(2, livro.getAno());
			ps.setString(3, livro.getAutor());

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


