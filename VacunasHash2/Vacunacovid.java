import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Vacunacovid {
    private Map<String, String> vacunas;
    private File archivo;

    public Vacunacovid() {
        this.archivo = new File("vacuna.txt");
        this.vacunas = leerArchivo();
    }


    private Map<String, String> leerArchivo(){
        File archivotxt = new File(archivo.toURI());
        try{
            if(!archivotxt.exists()){
                archivotxt.createNewFile();
            }
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        Map<String, String> vacunas = new HashMap<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))){
            while ((line = br.readLine()) != null){
                String[] parts = line.split(":");
                String cui = parts[0];
                String vacuna = parts[1];

                vacunas.put(cui, vacuna);
            }
        } catch (IOException ex) {
            System.out.println("Error al leer el archivo.");;
        }
        return vacunas;
    }

    void guardararchivo(String cui, String datos) {
        try {
            String datosAntiguos = vacunas.get(cui); // leer los datos antiguos para este CUI
            if (datosAntiguos != null) {
                // si hay datos antiguos, concatenarlos con los nuevos datos
                datos = datosAntiguos + ", " + datos;
            }
            FileWriter fw = new FileWriter(archivo, true);
            String IngresarDatos = cui + ":" + datos + "\n";
            fw.write(IngresarDatos);
            fw.close();
            vacunas.put(cui, datos); // actualizar la lista de vacunas con los datos ingresados
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }



    public String buscarVacunas(String cui){
        String vacunasCui = vacunas.get(cui);

        if(vacunasCui == null){
            return "No hay datos ingresados con este CUI.";
        }
        return vacunasCui;
    }

    public String toString(){
        StringBuilder ls = new StringBuilder();

        for(Map.Entry<String, String> entry : vacunas.entrySet()){
            ls.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return ls.toString();
    }
}