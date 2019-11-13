package SmokeTest;

import A2C.Banco;

public class ST1 {

	public void Iniciar(Banco BancoC) {

		System.out.println(" ---------------- Smoke Teste : ST1 ---------------------------------");

		// Teste para adicionar usuarios
		System.out.println("    - LUANFREITAS : " + BancoC.usuario_criar("luanfreitas", "123").getFrase());
		System.out.println("    - MARUAN : " + BancoC.usuario_criar("maruan", "456").getFrase());
		System.out.println("    - LAFETA : " + BancoC.usuario_criar("lafeta", "789").getFrase());

		System.out.println(" ---------------- ---------------- ---------------------------------");

	}
}
