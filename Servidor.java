import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    private static final int PUERTO = 1200; 

    public static void main(String[] args) {
        try {
            Interfaz implementacion = new Interfaz() {
                @Override
                public float sumar(float n1, float n2) { return n1 + n2; }
                @Override
                public float restar(float n1, float n2) { return n1 - n2; }
                @Override
                public float multiplicar(float n1, float n2) { return n1 * n2; }
                @Override
                public float dividir(float n1, float n2) {
                    return (n2 == 0) ? 0 : n1 / n2;
                }
            };

            Interfaz stub = (Interfaz) UnicastRemoteObject.exportObject(implementacion, 0);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.rebind("Calculadora", stub); //

            System.out.println("Servidor listo en el puerto " + PUERTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}