package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.LivroDAO;
import model.vo.LivroVO;

public class LivroBO {

	LivroDAO dao = new LivroDAO();

	public List<LivroVO> listarLivros(String consulta) throws SQLException {
		ArrayList<LivroVO> consulta1 = dao.realizarConsultas(consulta);
		return consulta1;
	}
}
