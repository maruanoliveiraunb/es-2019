
import A2C.Banco;
import A2C.MenuGeral;
import SmokeTest.ST1;
import SmokeTest.Smoker;

public class main {

	public static void main(String[] args) throws Exception {

		Banco BancoC = new Banco();

		Smoker SmokeTest = new Smoker();
		SmokeTest.Iniciar(BancoC);

		MenuGeral mg = new MenuGeral(BancoC);

		while (mg.Executando == true) {

			mg.Inicio();

		}

	}

}