package SmokeTest;

import A2C.Banco;
import A2C.Resposta;

public class ST1 {

	public void Iniciar(Banco BancoC) {
		
		System.out.println(" ---------------- Smoke Teste : ST1 ---------------------------------");
		
		
		Resposta r = BancoC.usuario_criar("douglas","12345678");

		System.out.println("    -  " + r.getFrase());

		
		
		System.out.println(" ---------------- ---------------- ---------------------------------");

		
	}
}
