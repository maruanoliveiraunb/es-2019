package A2C;

import java.util.Scanner;

import Modelos.Carona;



public class MenuUsuario {

	private Banco BancoC;
	public boolean Executando = true;
private int uid=0;

	public MenuUsuario(Banco BancoCorrente,int id) {
		BancoC = BancoCorrente;
		uid=id;

	}

	public void Inicio() {

		System.out.println(" -------------- ---------- " + "A2C - " + BancoC.usuario_obterid(uid).getUsuario() + " ---------- -----------------");

		System.out.printf("\n");
		System.out.printf("\n");

		System.out.println("Escolha uma opção abaixo : ");
		System.out.printf("\n");

		System.out.printf(" - ccc  : Criar Carona Compartilhada\n");
		System.out.printf(" - lcc  : Listar Carona Compartilhada\n");
		System.out.printf(" - ecc  : Excluir Carona Compartilhada \n");

		System.out.printf("\n");
		System.out.printf(" - pc  : Procurar Carona \n");
		System.out.printf(" - sc  : Solicitar Carona \n");
		System.out.printf(" - rc  : Remover Carona \n");


		System.out.printf("\n");
		System.out.printf(" - s  : Sair \n");
		System.out.printf("\n");

		System.out.printf("Opcao : ");

		Scanner sc = new Scanner(System.in);
		String opcao = sc.nextLine();
		opcao = opcao.toLowerCase();

		switch (opcao) {
		case "ccc":
			carona_criar();
			break;
		case "lcc":
			listar_caronas();
			break;
		case "s":
			Executando = false;
			break;
		default:
			System.out.println("OPCAO DESCONHECIDA !!! \n");
			break;
		}

	}

	
	public void carona_criar() {
		System.out.printf("\n\n ----------- CRIAR CARONA COMPARTILHADA ----------------\n\n");

		System.out.printf("Destino : ");
		Scanner sc = new Scanner(System.in);
		String destino = sc.nextLine();

		System.out.printf("Horario : ");
		Scanner sc2 = new Scanner(System.in);
		String horario = sc2.nextLine();

		System.out.printf("Modelo : ");
		Scanner sc3 = new Scanner(System.in);
		String modelo = sc3.nextLine();

		System.out.printf("Vagas : ");
		Scanner sc4 = new Scanner(System.in);
		int vagas = sc4.nextInt();
		
	

		Resposta r = BancoC.caronas_criar(uid, destino, horario, vagas, modelo);

		System.out.println("    -  " + r.getFrase());

		

	}

	public void listar_caronas() {
		System.out.printf("\n\n ----------- LISTAR CARONAS COMPARTILHADAS ----------------\n\n");

		if (BancoC.caronas_listar(uid).size()==0){
			
			System.out.println("    - Nenhuma carona compartilhada cadastrada  !!!");

			
		}else {
			
			for (Carona CaronaC : BancoC.caronas_listar(uid)) {
				
				System.out.printf("\n    -  %d : - %s as %s com %d vagas ",CaronaC.getCID(),CaronaC.getDestino(),CaronaC.getHorario(),CaronaC.getVagas());

			}
			
			System.out.println("");
			System.out.println("");
			
		}
		
		
		


	}
	
	
}

