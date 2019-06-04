package model.vo;

public class LivroVO {

	private int idLivro;
	private String titulo;
	private String edicao;
	private String autor;
	
	public LivroVO() {
		super();
	}

	public LivroVO(int idLivro, String titulo, String edicao, String autor) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.edicao = edicao;
		this.autor = autor;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
