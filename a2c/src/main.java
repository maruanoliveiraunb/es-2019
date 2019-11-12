import java.util.Scanner;

import A2C.Banco;
import A2C.MenuGeral;
import SmokeTest.ST1;

public class main {

	public static void main(String[] args) throws Exception {

		
		Banco BancoC = new Banco();

		ST1 SmokeTestCorrente = new ST1();
		
		SmokeTestCorrente.Iniciar(BancoC);
		
		
		MenuGeral mg = new MenuGeral(BancoC);
		

			while (true) {

			mg.Inicio();
			

				
			}

		}

}