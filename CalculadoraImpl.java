import java.rmi.RemoteException;

public class CalculadoraImpl implements Interfaz {
    @Override
    public float sumar(float n1, float n2) throws RemoteException { return n1 + n2; }
    
    @Override
    public float restar(float n1, float n2) throws RemoteException { return n1 - n2; }
    
    @Override
    public float multiplicar(float n1, float n2) throws RemoteException { return n1 * n2; }
    
    @Override
    public float dividir(float n1, float n2) throws RemoteException {
        return (n2 == 0) ? 0 : n1 / n2;
    }
    
    @Override
    public float raizCuadrada(float n1) throws RemoteException {
        return (float) Math.sqrt(n1);
    }
}