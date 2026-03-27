import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.rmi.RemoteException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraTest {

    private CalculadoraImpl calculadora;

    @BeforeEach
    public void setUp() {
        calculadora = new CalculadoraImpl();
    }

    @Test
    public void testSumar() throws RemoteException {
        assertEquals(5.0f, calculadora.sumar(2.0f, 3.0f));
        assertEquals(-1.0f, calculadora.sumar(-4.0f, 3.0f));
    }

    @Test
    public void testRestar() throws RemoteException {
        assertEquals(10.0f, calculadora.restar(15.0f, 5.0f));
    }

    @Test
    public void testMultiplicar() throws RemoteException {
        assertEquals(20.0f, calculadora.multiplicar(4.0f, 5.0f));
        assertEquals(0.0f, calculadora.multiplicar(4.0f, 0.0f));
    }

    @Test
    public void testDividir() throws RemoteException {
        assertEquals(2.5f, calculadora.dividir(5.0f, 2.0f));
        assertEquals(0.0f, calculadora.dividir(5.0f, 0.0f)); 
    }

    @Test
    public void testRaizCuadrada() throws RemoteException {
        assertEquals(4.0f, calculadora.raizCuadrada(16.0f));
    }
}