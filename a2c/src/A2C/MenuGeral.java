package A2C;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class MenuGeral {

	
	private Banco BancoC;
	
	
	public MenuGeral(Banco BancoCorrente	) {
		BancoC = BancoCorrente;

	}
	
	
	public void Inicio(			)  {


		System.out.println(" -------------- ---------- " + "A2C" + " ---------- -----------------");

		System.out.printf("\n");
		System.out.printf("\n");

		System.out.println("Escolha uma opção abaixo : ");
		System.out.printf("\n");

		System.out.printf(" - uc  : Criar novo Usuario \n");
		System.out.printf(" - ul  : Login \n");
		System.out.printf(" - ue  : Esqueci a senha \n");
		System.out.printf(" - uv  : Verificar conta \n");
		System.out.printf("\n");

		System.out.printf("Opcao : ");

		Scanner sc = new Scanner(System.in);
		String opcao = sc.nextLine();
		opcao = opcao.toLowerCase();

		switch (opcao) {
		case "uc":
			usuario_criar();
			break;
		case "ul":
			usuario_login();
			break;
		case "ue":
			usuario_esquecimento();
			break;
		default:
			System.out.println("OPCAO DESCONHECIDA !!! \n");
			break;
		}

	}

	public void usuario_criar() {
		System.out.printf("\n\n ----------- CRIAR USUARIO ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf(" Senha : ");
		Scanner sc2 = new Scanner(System.in);
		String senha = sc2.nextLine();

		System.out.printf(" Confirmar : ");
		Scanner sc3 = new Scanner(System.in);
		String senhac = sc3.nextLine();
		
		if (senha.equals(senhac)){
				
			Resposta r = BancoC.usuario_criar(usuario,senha);
		
			System.out.println("    -  " + r.getFrase());

		}else {
			System.out.println("    - Senha nao confere !!! ");
		}
		
		
	}
	public void usuario_login() {
		System.out.printf("\n\n ----------- LOGIN ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf(" Senha : ");
		Scanner sc2 = new Scanner(System.in);
		String senha = sc2.nextLine();

		
		Resposta r = BancoC.usuario_login(usuario,senha);
		if (r.getStatus()==true) {
			
			
		} else {	
			System.out.println("    -  " + r.getFrase());
		}
		
		
		
	}
	
	public void usuario_esquecimento() {
		System.out.printf("\n\n ----------- ESQUECI A SENHA ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		
		Resposta r = BancoC.usuario_esquecimento(usuario);
		if (r.getStatus()==true) {
			
			System.out.println("    -  " + r.getFrase());

		} else {	
			System.out.println("    -  " + r.getFrase());
		}
		
		
		
	}
	
	
	public void usuario_verificar() {
		System.out.printf("\n\n ----------- VERIFICADOR ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf("Codigo de Resgate : ");
		Scanner sc2 = new Scanner(System.in);
		String resgate = sc2.nextLine();

		
		Resposta r = BancoC.usuario_resgatar(usuario,resgate);
		if (r.getStatus()==true) {
			
			System.out.println("    - " + r.getFrase());

			
			
		} else {	
			System.out.println("    -  " + r.getFrase());
		}
		
		
		
	}
	
}
