package model.bo;


import model.dao.LivroDAO;
import model.vo.LivroVO;

public class LivroBO {

	public boolean salvar(LivroVO livro) {
LivroDAO dao = new LivroDAO();
		
		if (dao.verificaLivro(livro.getIdLivro())) {
			dao.update(livro);

		}else dao.insert(livro);

		return true;
	}
	}

	


