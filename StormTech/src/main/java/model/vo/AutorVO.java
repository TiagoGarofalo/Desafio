package model.vo;

public class AutorVO {
	
	private int idAutor;
	private String nome;

	public AutorVO() {
		super();
	}

	public AutorVO(int idAutor, String nome) {
		super();
		this.idAutor = idAutor;
		this.nome = nome;
	}

	public int getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

		
}
