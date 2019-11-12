package A2C;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

public class MenuGeral {

	Banco bancoc = new Banco();

	
	public void Inicio() throws ParserConfigurationException, SAXException, IOException, TransformerException {

		
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
		default:
			System.out.println("OPCAO DESCONHECIDA !!! \n");
			break;
		}

	}

	public void usuario_criar() throws ParserConfigurationException, SAXException, IOException, TransformerException {
		System.out.printf("\n\n ----------- CRIAR USUARIO ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf(" Senha : ");
		Scanner sc2 = new Scanner(System.in);
		String senha = sc2.nextLine();

		System.out.printf(" Confirmar : ");
		Scanner sc3 = new Scanner(System.in);
		String senhac = sc2.nextLine();
		
		bancoc.usuario_criar(usuario);
	}
	public void usuario_login() {
		System.out.printf("\n\n ----------- LOGIN ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf(" Senha : ");
		Scanner sc2 = new Scanner(System.in);
		String senha = sc2.nextLine();

	}
}
