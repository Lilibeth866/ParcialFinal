import java.io.*;
import java.util.ArrayList;
import java.util.List;
class Compania {
    String nombre;

    public Compania(String nombre) {
        this.nombre = nombre;
    }

    // Metodo para guardar datos de companias en un archivo
    public static void guardarCompanias(List<Compania> companias, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Compania compania : companias) {
                writer.write(String.format("%s%n", compania.nombre));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo para cargar datos de companias desde un archivo
    public static List<Compania> cargarCompanias(String fileName) {
        List<Compania> companias = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                // Asegurarse de que haya suficientes partes antes de acceder al indice 13
                if (parts.length >= 14) {
                    // Asumiendo que el nombre de la compania esta en el indice 13
                    Compania compania = new Compania(parts[13]);
                    companias.add(compania);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return companias;
    }

}
