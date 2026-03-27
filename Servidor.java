import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor {
    private static final int PUERTO = 1200; 

    public static void main(String[] args) {
        try {
            Interfaz implementacion = new CalculadoraImpl();

            Interfaz stub = (Interfaz) UnicastRemoteObject.exportObject(implementacion, 0);
            Registry registry = LocateRegistry.createRegistry(PUERTO);
            registry.rebind("Calculadora", stub);

            System.out.println("Servidor listo en el puerto " + PUERTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}