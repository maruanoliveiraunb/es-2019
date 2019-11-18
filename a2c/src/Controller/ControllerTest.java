package Controller;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class ControllerTest extends TestCase {

	
	// UNIT TESTING
	
	@Test
	void test() {
		
		Banco BancoC = new Banco();
		
		 Assert.assertEquals(true, BancoC.usuario_criar("maruan","maruan@unb.br", "222.222.222-22","456").getStatus());
	   	 
	}

}
