
import A2C.Banco;
import A2C.MenuGeral;
import SmokeTest.Smoker;

public class main {

	public static void main(String[] args)  {

		Banco BancoC = new Banco();

		Smoker SmokeTest = new Smoker();
		SmokeTest.Iniciar(BancoC);

		MenuGeral MenuGeralC = new MenuGeral(BancoC);

		while (MenuGeralC.Executando == true) {

			MenuGeralC.MostrarMenu();

		}

	}

}