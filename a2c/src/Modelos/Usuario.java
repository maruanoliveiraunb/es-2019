package Modelos;

public class Usuario {

	private int ID = 0;

	private String usuario = "";
	private String senha = "";
	private String email = "";

	public int getID() {
		return this.ID;
	}

	public void setID(int valor) {
		this.ID = valor;
	}

	public void setUsuario(String valor) {
		this.usuario = valor;
	}

	public void setSenha(String valor) {
		this.senha = valor;
	}

	public String getUsuario() {
		return this.usuario;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	
	public void setEmail(String valor) {
		this.email = valor;
	}

	public String getEmail() {
		return this.email;
	}
	
	
	
}
