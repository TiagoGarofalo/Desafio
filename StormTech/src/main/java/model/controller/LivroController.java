package model.controller;

import java.sql.SQLException;
import java.util.List;

import model.bo.LivroBO;
import model.vo.LivroVO;

public class LivroController {

	LivroBO bo = new LivroBO();

	public List<LivroVO> listarLivros(String consulta) throws SQLException {

		return bo.listarLivros(consulta);
	}

}
