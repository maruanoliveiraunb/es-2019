package Modelos;

public class Usuario {

	private String usuario = "";
	private String senha = "";
	private int ID = 0;

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
}
