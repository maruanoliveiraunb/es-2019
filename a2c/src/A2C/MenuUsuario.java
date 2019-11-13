package A2C;

import java.util.Scanner;

import Modelos.Carona;
import Modelos.MetodoPagamento;
import Modelos.Pedido;

public class MenuUsuario {

	private Banco BancoC;
	public boolean Executando = true;
	private int uid = 0;

	public MenuUsuario(Banco BancoCorrente, int id) {
		BancoC = BancoCorrente;
		uid = id;

	}

	public void Inicio() {

		System.out.println(" -------------- ---------- " + "A2C - " + BancoC.usuario_obterid(uid).getUsuario()
				+ " ---------- -----------------");

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
		System.out.printf(" - lc  : Listar Caronas \n");
		System.out.printf(" - rc  : Remover Carona \n");

		System.out.printf("\n");
		System.out.printf(" - cmp  : Cadastrar Metodo de Pagamento \n");
		System.out.printf(" - lmp  : Listar Metodos de Pagamento \n");
		System.out.printf(" - rmp  : Remover Metodo de Pagamento \n");

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
		case "ecc":
			excluir_carona();
			break;

		case "pc":
			procurar_carona();
			break;
		case "sc":
			solicitar_carona();
			break;
		case "lc":
			listar_pedidos();
			break;
		case "rc":
			remover_pedido();
			break;

		case "cmp":
			metodopagamento_criar();
			break;
		case "lmp":
			metodopagamento_listar();
			break;
		case "rmp":
			metodopagamento_excluir();
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

		if (BancoC.caronas_listar(uid).size() == 0) {

			System.out.println("    - Nenhuma carona compartilhada cadastrada  !!!");

		} else {

			for (Carona CaronaC : BancoC.caronas_listar(uid)) {

				System.out.printf("\n    -  %d : - %s as %s com %d vagas ", CaronaC.getCID(), CaronaC.getDestino(),
						CaronaC.getHorario(), CaronaC.getVagas());

			}

			System.out.println("");
			System.out.println("");

		}

	}

	public void excluir_carona() {
		System.out.printf("\n\n ----------- EXCLUIR CARONA COMPARTILHADA ----------------\n\n");

		System.out.printf("CID : ");
		Scanner sc = new Scanner(System.in);
		int cid = sc.nextInt();

		Resposta r = BancoC.caronas_excluir(uid, cid);

		System.out.println("    -  " + r.getFrase());

	}

	public void procurar_carona() {
		System.out.printf("\n\n ----------- PROCURAR CARONA ----------------\n\n");

		System.out.printf("Destino : ");
		Scanner sc = new Scanner(System.in);
		String destino = sc.nextLine();

		if (BancoC.caronas_procurar(uid, destino).size() == 0) {

			System.out.println("\n    - Nenhuma carona compartilhada cadastrada  !!!\n");

		} else {

			for (Carona CaronaC : BancoC.caronas_procurar(uid, destino)) {

				System.out.printf("\n    -  %d : - %s as %s com %d vagas ", CaronaC.getCID(), CaronaC.getDestino(),
						CaronaC.getHorario(), CaronaC.getVagas());

			}

			System.out.println("");
			System.out.println("");

		}

	}

	public void solicitar_carona() {
		System.out.printf("\n\n ----------- SOLICITAR CARONA ----------------\n\n");

		System.out.printf("CID : ");
		Scanner sc = new Scanner(System.in);
		int cid = sc.nextInt();

		Resposta r = BancoC.caronas_solicitar(uid, cid);

		System.out.println("    -  " + r.getFrase());

	}

	public void listar_pedidos() {
		System.out.printf("\n\n ----------- LISTAR SOLITICAÇÕES DE CARONAS ----------------\n\n");

		if (BancoC.pedidos_listar(uid).size() == 0) {

			System.out.println("\n    - Nenhum Pedido de carona solicitado  !!!\n");

		} else {

			for (Pedido PedidoC : BancoC.pedidos_listar(uid)) {

				Carona CaronaC = BancoC.ObterCaronaID(PedidoC.getCID());

				System.out.printf("\n    -  %d : - %s as %s ", PedidoC.getPID(), CaronaC.getDestino(),
						CaronaC.getHorario());

			}

			System.out.println("");
			System.out.println("");

		}

	}

	public void remover_pedido() {
		System.out.printf("\n\n ----------- EXCLUIR SOLICITAÇÃO DE CARONA ----------------\n\n");

		System.out.printf("PID : ");
		Scanner sc = new Scanner(System.in);
		int cid = sc.nextInt();

		Resposta r = BancoC.pedidos_remover(uid, cid);

		System.out.println("    -  " + r.getFrase());

	}

	public void metodopagamento_criar() {

		System.out.printf("\n\n ----------- CRIAR METODO DE PAGAMENTO ----------------\n\n");

		System.out.printf("Metodo : ");
		Scanner sc = new Scanner(System.in);
		String metodo = sc.nextLine();

		System.out.printf("Cartao : ");
		Scanner sc2 = new Scanner(System.in);
		String cartao = sc2.nextLine();

		Resposta r = BancoC.metododePagamento_criar(uid, metodo, cartao);

		System.out.println("    -  " + r.getFrase());

	}

	public void metodopagamento_excluir() {
		System.out.printf("\n\n ----------- EXCLUIR METODO DE PAGAMENTO ----------------\n\n");

		System.out.printf("MPID : ");
		Scanner sc = new Scanner(System.in);
		int mpid = sc.nextInt();

		Resposta r = BancoC.metodoPagamento_excluir(uid, mpid);

		System.out.println("    -  " + r.getFrase());

	}

	public void metodopagamento_listar() {
		System.out.printf("\n\n ----------- LISTAR METODOS DE PAGAMENTOS ----------------\n\n");

		if (BancoC.metodoPagamento_listar(uid).size() == 0) {

			System.out.println("\n    - Nenhum metodo de pagamento cadastrado  !!!\n");

		} else {

			for (MetodoPagamento MetodoPagamentoC : BancoC.metodoPagamento_listar(uid)) {

				System.out.printf("\n    -  %d : - %s   ->  Cartão : %s ", MetodoPagamentoC.getMPID(),
						MetodoPagamentoC.getMetodo(), MetodoPagamentoC.getCartao());

			}

			System.out.println("");
			System.out.println("");

		}

	}
}
