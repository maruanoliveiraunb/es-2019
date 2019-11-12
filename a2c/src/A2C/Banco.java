package A2C;

import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.UUID;

import Modelos.Esquecimento;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import Modelos.Usuario;



public class Banco {

	public ArrayList<Usuario> Usuarios = new ArrayList();
	public ArrayList<Esquecimento> Esquecimentos = new ArrayList();

	
	public Resposta usuario_criar(String nome,String senha ) {
		
		Resposta ret = new Resposta(false,"Usuario nao cadastrado !!");
		
		if(nome.length()<5) {
			return new Resposta(false,"Nome de usuário invalido !!");
		}
		
		
		Usuario Novo = new Usuario();
		Novo.setUsuario(nome);
		Novo.setSenha(senha);
		Usuarios.add(Novo);
		
		return new Resposta(true,"Usuario cadastrado com sucesso ");
	}
	
	
public Resposta usuario_login(String nome,String senha ) {
		
		Resposta ret;
		
		boolean encontrado = false;
		
		for (Usuario usuarioC: Usuarios) {
		   
		    if (usuarioC.getUsuario().equals(nome)){
		    	encontrado = true;
		    	break;
		    }
		}
		
		if (encontrado == false){
			ret =new Resposta(false,"Usuario nao encontrado !!");	
		} else {
			ret= new Resposta(true,"Usuario encontrado !!");	
		}
		
		return ret;
		
	}
	



public Resposta usuario_esquecimento(String usuariovalor ) {
		
		Resposta ret;
		
		boolean encontrado = false;
		
		for (Usuario usuarioC: Usuarios) {
		   
		    if (usuarioC.getUsuario().equals(usuariovalor)){
		    	encontrado = true;
		    	break;
		    }
		}
		
		if (encontrado == false){
			ret =new Resposta(false,"Usuario nao encontrado !!");	
		} else {
			
			

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date(1,1,1);
		String datacorrente =  dateFormat.format(date);


		UUID uuid = UUID.randomUUID();
        String resgate = uuid.toString();
        resgate = resgate.toUpperCase();
        resgate = resgate.substring(25);
        
        for (Esquecimento esquecimentoC: Esquecimentos) {
			   
		    if (esquecimentoC.getUsuario().equals(usuariovalor)){
if (esquecimentoC.getStatus().equals("Esperando")){
	esquecimentoC.setStatus("Expirou");
}
		    }
		}
        
        
			Esquecimentos.add(new Esquecimento(usuariovalor,resgate,"Esperando",datacorrente));
			

			
			ret= new Resposta(true,"CODIGO DE RESGATE : " + resgate);	
		}
		
		return ret;
		
	}
	

public Resposta usuario_resgatar(String usuariovalor,String resgatevalor ) {
	
	Resposta ret =new Resposta(false,"Usuario nao encontrado !!");	
	
	boolean encontrado = false;
	
	for (Usuario usuarioC: Usuarios) {
	   
	    if (usuarioC.getUsuario().equals(usuariovalor)){
	    	encontrado = true;
	    	break;
	    }
	}
	

	if (encontrado == false){
		ret =new Resposta(false,"Usuario nao encontrado !!");	
	} else {
		
		encontrado = false;
		
		for (Esquecimento esquecimentoC: Esquecimentos) {
			   
		    if (esquecimentoC.getUsuario().equals(usuariovalor)){
		    	if (esquecimentoC.getStatus().equals("Esperando")) {
		    		encontrado = true;
		    		
		    		if (esquecimentoC.getResgate().equals(resgatevalor) ){
		    			esquecimentoC.setStatus("Concluido");
		    			
		    			ret= new Resposta(true,"Resgatado !!");	
		    			
		    		} else {
		    			ret= new Resposta(false,"Resgate incorreto !!");	
		    		}
		    		
			    	break;
		    	}
		    	
		    }
		}
		
	
	}
	return ret;
	
	
}

}


