package A2C;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.UUID;

import Modelos.Carona;
import Modelos.Esquecimento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import Modelos.Usuario;

public class Banco {

	public ArrayList<Usuario> Usuarios = new ArrayList();
	public ArrayList<Esquecimento> Esquecimentos = new ArrayList();
	public ArrayList<Carona> Caronas = new ArrayList();

	
	
	private int UID = 0;
	private int CID = 0;
	
	public Resposta usuario_criar(String usuariovalor, String senha) {

		usuariovalor=usuariovalor.toLowerCase();

		Resposta ret = new Resposta(false, "Usuario nao cadastrado !!");

		if (usuariovalor.length() < 5) {
			return new Resposta(false, "Nome de usuário invalido !!");
		}

		Usuario Novo = new Usuario();
		Novo.setID(UID);
		Novo.setUsuario(usuariovalor);
		Novo.setSenha(senha);
		Usuarios.add(Novo);
		
		
		UID +=1;
		
		return new Resposta(true, "Usuario cadastrado com sucesso ");
	}

	public Resposta usuario_login(String usuariovalor, String senha) {

		usuariovalor=usuariovalor.toLowerCase();

		
		Resposta ret;
		int usuarioid = 0;
		
		
		boolean encontrado = false;

		for (Usuario usuarioC : Usuarios) {

			if (usuarioC.getUsuario().equals(usuariovalor)) {
				encontrado = true;
				usuarioid = usuarioC.getID();
				break;
			}
		}

		if (encontrado == false) {
			ret = new Resposta(false, "Usuario nao encontrado !!");
		} else {
			ret = new Resposta(true, String.valueOf(usuarioid));
		}

		return ret;

	}

	public Usuario usuario_obterid(int id) {

		for (Usuario usuarioC : Usuarios) {

			if (usuarioC.getID() == id) {
				return usuarioC;
				
			}
		}

		return null;

	}
	
	public int usuario_obteridPorUsuario(String usuarionome) {

		usuarionome = usuarionome.toLowerCase();
		
		for (Usuario usuarioC : Usuarios) {

			if (usuarioC.getUsuario().equals(usuarionome)) {
				return usuarioC.getID();
				
			}
		}

		return -1;

	}
	
	
	public Resposta usuario_esquecimento(String usuariovalor) {

		usuariovalor=usuariovalor.toLowerCase();
		
		Resposta ret;

		boolean encontrado = false;

		for (Usuario usuarioC : Usuarios) {

			if (usuarioC.getUsuario().equals(usuariovalor)) {
				encontrado = true;
				break;
			}
		}

		if (encontrado == false) {
			ret = new Resposta(false, "Usuario nao encontrado !!");
		} else {

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date(1, 1, 1);
			String datacorrente = dateFormat.format(date);

			UUID uuid = UUID.randomUUID();
			String resgate = uuid.toString();
			resgate = resgate.toUpperCase();
			resgate = resgate.substring(25);

			for (Esquecimento esquecimentoC : Esquecimentos) {

				if (esquecimentoC.getUsuario().equals(usuariovalor)) {
					if (esquecimentoC.getStatus().equals("Esperando")) {
						esquecimentoC.setStatus("Expirou");
					}
				}
			}

			Esquecimentos.add(new Esquecimento(usuariovalor, resgate, "Esperando", datacorrente));

			ret = new Resposta(true, "CODIGO DE RESGATE : " + resgate);
		}

		return ret;

	}

	public Resposta usuario_resgatar(String usuariovalor, String resgatevalor) {

		Resposta ret = new Resposta(false, "Usuario nao encontrado !!");

		boolean encontrado = false;

		for (Usuario usuarioC : Usuarios) {

			if (usuarioC.getUsuario().equals(usuariovalor)) {
				encontrado = true;
				break;
			}
		}

		if (encontrado == false) {
			ret = new Resposta(false, "Usuario nao encontrado !!");
		} else {

			encontrado = false;

			for (Esquecimento esquecimentoC : Esquecimentos) {

				if (esquecimentoC.getUsuario().equals(usuariovalor)) {
					if (esquecimentoC.getStatus().equals("Esperando")) {
						encontrado = true;

						if (esquecimentoC.getResgate().equals(resgatevalor)) {
							esquecimentoC.setStatus("Concluido");

							ret = new Resposta(true, "Resgatado !!");

						} else {
							ret = new Resposta(false, "Resgate incorreto !!");
						}

						break;
					}

				}
			}

			if (encontrado==false) {
				ret = new Resposta(false, "Usuario nao encontrado !!");
			}
		}
		return ret;

	}
	
	
	public Resposta caronas_criar(int usuarioid, String destino,String horario,int vagas,String modelo) {

		if (destino.length()<3){
			return new Resposta(false, "Carona não cadastrada : Destino invalido ! ");
		}
		
		if (horario.length()<6){
			return new Resposta(false, "Carona não cadastrada : Horario invalido ! ");
		}
		
		if (vagas<1){
			return new Resposta(false, "Carona não cadastrada : Vagas invalidas ! ");
		}
	
		if (modelo.length()<3){
			return new Resposta(false, "Carona não cadastrada : Modelo invalido ! ");
		}
		
		Carona Novo = new Carona();
		
		Novo.setCID(CID);
		Novo.setUsuarioID(usuarioid);
		Novo.setDestino(destino);
		Novo.setHorario(horario);
		Novo.setVagas(vagas);
		Novo.setModelo(modelo);
		
		
		Caronas.add(Novo);
		
		
		CID +=1;
		
		return new Resposta(true, "Carona cadastrada com sucesso ");
	}
	
	
	public ArrayList<Carona>  caronas_listar(int usuarioid) {

	 ArrayList<Carona> subcaronas = new ArrayList();

		for (Carona CaronaC : Caronas) {
			if (CaronaC.getUsuarioID() == usuarioid) {
				subcaronas.add(CaronaC);
			}
		}
		
		return subcaronas;
	}
	

	public Resposta caronas_excluir(int usuarioid, int cid) {

		for (Carona CaronaC : Caronas) {
			
			if (CaronaC.getCID() == cid) {
				
				if (CaronaC.getUsuarioID()==usuarioid) {
					Caronas.remove(CaronaC);
					return new Resposta(true, "Carona excluida com sucesso ");
				}
				else {
					return new Resposta(false, "Acesso nao autorizado");
				}
				
			}
		}
		
		
		return new Resposta(false, "Acesso nao autorizado");

	}
	
	
	public ArrayList<Carona>  caronas_procurar(int usuarioid,String destino) {

		 ArrayList<Carona> subcaronas = new ArrayList();

			for (Carona CaronaC : Caronas) {
				if (CaronaC.getUsuarioID() == usuarioid) {
					
				} else {
					
					if (CaronaC.getDestino().contentEquals(destino)) {
						subcaronas.add(CaronaC);
					}
				}
			}
			
			return subcaronas;
		}
	
	
}
