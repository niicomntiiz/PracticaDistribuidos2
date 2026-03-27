import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    private static final String IP = "localhost";
    private static final int PUERTO = 1200;
    
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(IP, PUERTO);
            Interfaz interfaz = (Interfaz) registry.lookup("Calculadora");
            Scanner sc = new Scanner(System.in);
            int eleccion;
            float n1, n2 = 0, resultado = 0;

            do {
                System.out.println("\n[0] Sumar | [1] Restar | [2] Multiplicar | [3] Dividir | [4] Raíz Cuadrada | [-1] Salir");
                try { eleccion = Integer.parseInt(sc.nextLine()); } catch (Exception e) { eleccion = -1; }

                if(eleccion >= 0 && eleccion <= 4){
                    System.out.print("Número 1: ");
                    n1 = Float.parseFloat(sc.nextLine());
                    
                    if (eleccion != 4) {
                        System.out.print("Número 2: ");
                        n2 = Float.parseFloat(sc.nextLine());
                    }

                    switch (eleccion) {
                        case 0 -> resultado = interfaz.sumar(n1, n2);
                        case 1 -> resultado = interfaz.restar(n1, n2);
                        case 2 -> resultado = interfaz.multiplicar(n1, n2);
                        case 3 -> resultado = interfaz.dividir(n1, n2);
                        case 4 -> resultado = interfaz.raizCuadrada(n1);
                    }
                    System.out.println("Resultado => " + resultado);
                } else if (eleccion != -1) {
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                }
            } while (eleccion != -1);
        } catch (Exception e) {
            System.err.println("Error: No se pudo conectar. ¿Está el servidor encendido?");
            e.printStackTrace();
        }
    }
}