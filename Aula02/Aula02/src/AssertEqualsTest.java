import static org.junit.Assert.*;
import org.junit.Test;

public class AssertEqualsTest {

   @Test
   public void testeIgualdade_Sucesso() {
      String resultadoEsperado = "Registro salvo com sucesso!";
      String resultadoObtido = "Registro salvo com sucesso!";
		
      assertEquals(resultadoEsperado, resultadoObtido);
   }
	
   @Test
   public void testeIgualdade_Falha() {
      String resultadoEsperado = "Registro salvo com sucesso!";
      String resultadoObtido = "Funcionário já existe!";
		
      assertEquals(resultadoEsperado, resultadoObtido);
   }
}