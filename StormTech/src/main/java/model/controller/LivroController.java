package model.controller;


import model.bo.LivroBO;
import model.vo.LivroVO;

public class LivroController {

	public boolean salvar(LivroVO livro) {
		LivroBO bo = new LivroBO();

		return bo.salvar(livro);
	}

}
