import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interfaz extends Remote {
    float sumar(float n1, float n2) throws RemoteException;
    float restar(float n1, float n2) throws RemoteException;
    float multiplicar(float n1, float n2) throws RemoteException;
    float dividir(float n1, float n2) throws RemoteException;
    float raizCuadrada(float n1) throws RemoteException;
}