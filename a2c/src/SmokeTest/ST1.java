package SmokeTest;

import A2C.Banco;
import A2C.Resposta;

public class ST1 {

	public void Iniciar(Banco BancoC) {
		
		System.out.println(" ---------------- Smoke Teste : ST1 ---------------------------------");
		
		
		

		System.out.println("    - LUANFREITAS : " + BancoC.usuario_criar("luanfreitas","123").getFrase());
		System.out.println("    - MARUAN : " + BancoC.usuario_criar("maruan","456").getFrase());
		System.out.println("    - LAFETA : " + BancoC.usuario_criar("lafeta","789").getFrase());

		
		int LUANFREITAS_ID = BancoC.usuario_obteridPorUsuario("luanfreitas");
		
		System.out.println("    - LUANFFTEITAS : " + BancoC.caronas_criar(LUANFREITAS_ID, "Setor Bancario Sul", "12/11/19 20:30", 4, "Fusca Amarelo").getFrase());
		System.out.println("    - LUANFFTEITAS : " + BancoC.caronas_criar(LUANFREITAS_ID, "Setor Bancario Sul", "13/11/19 20:30", 4, "Fusca Amarelo").getFrase());
		System.out.println("    - LUANFFTEITAS : " + BancoC.caronas_criar(LUANFREITAS_ID, "Setor Bancario Sul", "14/11/19 20:30", 4, "Fusca Amarelo").getFrase());
		System.out.println("    - LUANFFTEITAS : " + BancoC.caronas_criar(LUANFREITAS_ID, "Setor Bancario Sul", "15/11/19 20:30", 4, "Fusca Amarelo").getFrase());

		
		int MARUAN_ID = BancoC.usuario_obteridPorUsuario("maruan");
		
		System.out.println("    - MARUAN : " + BancoC.caronas_criar(MARUAN_ID, "Ceilandia - Setor O", "10/11/19 20:30", 4, "Hyndai Veloster 2012").getFrase());
		System.out.println("    - MARUAN : " + BancoC.caronas_criar(MARUAN_ID, "Ceilandia - Setor O", "11/11/19 20:30", 4, "Hyndai Veloster 2012").getFrase());
		System.out.println("    - MARUAN : " + BancoC.caronas_criar(MARUAN_ID, "Ceilandia - Setor O", "20/11/19 20:30", 4, "Hyndai Veloster 2012").getFrase());
		System.out.println("    - MARUAN : " + BancoC.caronas_criar(MARUAN_ID, "Ceilandia - Setor O", "21/11/19 20:30", 4, "Hyndai Veloster 2012").getFrase());

		
		
		System.out.println(" ---------------- ---------------- ---------------------------------");

		
	}
}
