import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Clase Principal
public class Main {
    public static void main(String[] args) {
        List<Aeropuerto> aeropuertos = Aeropuerto.cargarAeropuertos("lista aeropuertos.txt");
        List<Vuelo> vuelos = Vuelo.cargarVuelos("vuelos.txt");
        List<Compania> companias = Compania.cargarCompanias("vuelos.txt");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Mostrar lista de vuelos de salida desde cada aeropuerto");
            System.out.println("2. Mostrar lista de vuelos de llegada a cada aeropuerto");
            System.out.println("3. Guardar datos en archivos");
            System.out.println("4. Salir");

            System.out.print("Seleccione una opci0n: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarSalidas(aeropuertos, vuelos);
                    break;
                case "2":
                    mostrarLlegadas(aeropuertos, vuelos);
                    break;
                case "3":
                    guardarDatos(aeropuertos, vuelos, companias);
                    break;
                case "4":
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("Opcion no valida. Intentelo de nuevo.");
            }
        }
    }

    private static void mostrarSalidas(List<Aeropuerto> aeropuertos, List<Vuelo> vuelos) {
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.println("\nAEROPUERTO salidas: " + aeropuerto.nombre);
            for (Vuelo vuelo : vuelos) {
                if (vuelo.origen.equals(aeropuerto.codigo)) {
                    System.out.println(vuelo.origen + "\t" + vuelo.destino + "\t" + vuelo.plazas + "\t" + vuelo.duracion);
                }
            }
        }
    }

    private static void mostrarLlegadas(List<Aeropuerto> aeropuertos, List<Vuelo> vuelos) {
        for (Aeropuerto aeropuerto : aeropuertos) {
            System.out.println("\nAEROPUERTO llegadas: " + aeropuerto.nombre);
            for (Vuelo vuelo : vuelos) {
                if (vuelo.destino.equals(aeropuerto.codigo)) {
                    System.out.println(vuelo.origen + "\t" + vuelo.destino + "\t" + vuelo.plazas + "\t" + vuelo.duracion);
                }
            }
        }
    }

    private static void guardarDatos(List<Aeropuerto> aeropuertos, List<Vuelo> vuelos, List<Compania> companias) {
        Aeropuerto.guardarAeropuertos(aeropuertos, "lista_aeropuertos_guardado.txt");
        Vuelo.guardarVuelos(vuelos, "vuelos_guardado.txt");
        Compania.guardarCompanias(companias, "companias_guardado.txt");
        System.out.println("Datos guardados exitosamente.");
    }
}
