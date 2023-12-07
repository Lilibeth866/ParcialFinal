import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Aeropuerto {
    String codigo;
    String nombre;
    String poblacion;
    String pais;
    int gmt;

    public Aeropuerto(String codigo, String nombre, String poblacion, String pais, int gmt) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.pais = pais;
        this.gmt = gmt;
    }

    // Metodo para guardar datos de aeropuertos en un archivo
    public static void guardarAeropuertos(List<Aeropuerto> aeropuertos, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Aeropuerto aeropuerto : aeropuertos) {
                writer.write(String.format("%s\t%s\t%s\t%s\t%d%n",
                        aeropuerto.codigo, aeropuerto.nombre, aeropuerto.poblacion, aeropuerto.pais, aeropuerto.gmt));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para cargar datos de aeropuertos desde un archivo
    public static List<Aeropuerto> cargarAeropuertos(String fileName) {
        List<Aeropuerto> aeropuertos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#")) continue;  // Ignorar lineas de comentarios
                String[] parts = line.split("\t");
                // Asegurar que hay suficientes partes antes de acceder al indice 4
                if (parts.length >= 5) {
                    // Asegurar que la cadena sea un numero antes de convertirla
                    String gmtString = parts[4].trim();
                    if (gmtString.matches("-?\\d+")) {
                        int gmt = Integer.parseInt(gmtString);
                        Aeropuerto aeropuerto = new Aeropuerto(parts[0], parts[1], parts[3], parts[2], gmt);
                        aeropuertos.add(aeropuerto);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aeropuertos;
    }

}
