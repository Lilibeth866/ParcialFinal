import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Vuelo {
    String origen;
    String destino;
    int plazas;
    String duracion;

    public Vuelo(String origen, String destino, int plazas, String duracion) {
        this.origen = origen;
        this.destino = destino;
        this.plazas = plazas;
        this.duracion = duracion;
    }

    // Metodo para guardar datos de vuelos en un archivo
    public static void guardarVuelos(List<Vuelo> vuelos, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Vuelo vuelo : vuelos) {
                writer.write(String.format("R;%s;%s;%s;%d;%s%n",
                        vuelo.origen, vuelo.destino, vuelo.duracion, vuelo.plazas, vuelo.duracion));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para cargar datos de vuelos desde un archivo
    public static List<Vuelo> cargarVuelos(String fileName) {
        List<Vuelo> vuelos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts[0].equals("R")) {
                    Vuelo vuelo = new Vuelo(parts[1], parts[2], Integer.parseInt(parts[6]), parts[3]);
                    vuelos.add(vuelo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vuelos;
    }
}
