package model.vo;

public class LivroVO {

	private int idLivro;
	private String nome;
	private String ano;
	private String autor;
	
	public LivroVO() {
		super();
	}

	public LivroVO(int idLivro, String nome, String ano, String autor) {
		super();
		this.idLivro = idLivro;
		this.nome = nome;
		this.ano = ano;
		this.autor = autor;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	
}
