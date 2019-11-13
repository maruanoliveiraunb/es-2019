package A2C;

import java.util.Scanner;

public class MenuGeral {

	private Banco BancoC;
	public boolean Executando = true;

	public MenuGeral(Banco BancoCorrente) {
		BancoC = BancoCorrente;

	}

	public void Inicio() {

		System.out.println(" -------------- ---------- " + "A2C" + " ---------- -----------------");

		System.out.printf("\n");
		System.out.printf("\n");

		System.out.println("Escolha uma opção abaixo : ");
		System.out.printf("\n");

		System.out.printf(" - uc  : Criar novo Usuario \n");
		System.out.printf(" - ul  : Login \n");
		System.out.printf(" - ue  : Esqueci a senha \n");
		System.out.printf(" - ur  : Resgatar conta \n");

		System.out.printf("\n");
		System.out.printf(" - s  : Sair \n");
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
		case "ur":
			usuario_resgatar();
			break;
		case "s":
			Executando = false;

			System.out.printf("\n");

			System.out.printf("Saindo .... \n");

			break;
		default:
			System.out.println("OPCAO DESCONHECIDA !!! \n");
			break;
		}

		sc.close();
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

		if (senha.equals(senhac)) {

			Resposta r = BancoC.usuario_criar(usuario, senha);

			System.out.println("    -  " + r.getFrase());

		} else {
			System.out.println("    - Senha nao confere !!! ");
		}

		sc.close();
		sc2.close();
		sc3.close();
		
	}

	public void usuario_login() {
		System.out.printf("\n\n ----------- LOGIN ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf(" Senha : ");
		Scanner sc2 = new Scanner(System.in);
		String senha = sc2.nextLine();

		Resposta r = BancoC.usuario_login(usuario, senha);
		if (r.getStatus() == true) {

			int tmpid = Integer.parseInt(r.getFrase());

			MenuUsuario mg = new MenuUsuario(BancoC, tmpid);

			while (mg.Executando == true) {

				mg.Inicio();

			}

		} else {
			System.out.println("    -  " + r.getFrase());
		}

		sc.close();
		sc2.close();
	}

	public void usuario_esquecimento() {
		System.out.printf("\n\n ----------- ESQUECI A SENHA ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		Resposta r = BancoC.usuario_esquecimento(usuario);
		if (r.getStatus() == true) {

			System.out.println("    -  " + r.getFrase());

		} else {
			System.out.println("    -  " + r.getFrase());
		}

		sc.close();
	}

	public void usuario_resgatar() {
		System.out.printf("\n\n ----------- RESGATAR ----------------\n\n ");

		System.out.printf("Usuario : ");
		Scanner sc = new Scanner(System.in);
		String usuario = sc.nextLine();

		System.out.printf("Codigo de Resgate : ");
		Scanner sc2 = new Scanner(System.in);
		String resgate = sc2.nextLine();

		Resposta r = BancoC.usuario_resgatar(usuario, resgate);
		if (r.getStatus() == true) {

			System.out.println("    - " + r.getFrase());

		} else {
			System.out.println("    -  " + r.getFrase());
		}

		sc.close();
		sc2.close();
	}

}
