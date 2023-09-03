import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * La clase Sede representa una sede de la universidad con diferentes estudiantes.
 */
public class Sede {
    private String nombre; //El nombre de la sede
    private ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>(); //Una lista con los diferentes estudiantes de la sede


    /**
     * Constructor de la clase Sede.
     *
     * @param nombre El nombre de la sede al que pertenece el estudiante.
     */
    public Sede(String nombre){
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre de la sede
     *
     * @return El nombre de la sede.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Agrega un nuevo estudiante a la lista de estudiantes.
     *
     * @param nombre     El nombre del estudiante.
     * @param apellido   El apellido del estudiante.
     * @param email      La dirección de correo electrónico del estudiante.
     * @param unicode    El número de identificación único del estudiante.
     * @param birthDate  La fecha de nacimiento del estudiante.
     */
    public void addEstudiante(String nombre, String apellido, String email, int unicode, String birthDate){
        estudiantes.add(new Estudiante(nombre,apellido,email,unicode,birthDate));
    }

    /**
     * Imprime una descripción de cada estudiante en la lista de estudiantes, incluyendo su código, nombre y apellido.
     */
    public void describeEstudiante(){
        for(Estudiante estudiante : estudiantes){
            System.out.println("Codigo: " + estudiante.getCarne() + ", Nombre: " + estudiante.getNombre() + ", Apellido: " + estudiante.getApellido()); 
        } 
    }

    /**
     * Obtiene la lista de estudiantes.
     *
     * @return La lista de estudiantes.
     */
    public ArrayList<Estudiante> getEstudiantes(){
        return estudiantes;
    }

    
    /**
     * Calcula y muestra estadísticas relacionadas con las notas de los estudiantes en diversas materias.
     * Para cada materia, se calcula el promedio, la mediana, la moda, la desviación estándar, la cantidad de estudiantes,
     * el valor mínimo y el valor máximo de las notas de los estudiantes que han tomado ese examen.
     * Si no hay datos disponibles para una materia específica, se muestra un mensaje indicando que no hay datos.
     */
    public void Estadisticas() {
        String[] names = {"Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística"};

        for (String name : names) {
            int sumatoria = 0;
            double promedio;
            int cantidadEst = 0;
            List<Integer> notas = new ArrayList<>();

            for (Estudiante estudiante : estudiantes) {
                Examen examen = estudiante.getExamen(name);
                if (examen != null) {
                    int nota = examen.getNota();
                    if(nota!= -1){
                        sumatoria += nota;
                        notas.add(nota);
                        cantidadEst++;
                    }
                    
                }
            }

            if (cantidadEst > 0) {
                promedio = (double) sumatoria / cantidadEst;

                Collections.sort(notas);
                int mediana;
                if (cantidadEst % 2 == 0) {
                    int middle1 = notas.get(cantidadEst / 2 - 1);
                    int middle2 = notas.get(cantidadEst / 2);
                    mediana = (middle1 + middle2) / 2;
                } else {
                    mediana = notas.get(cantidadEst / 2);
                }

            
                Map<Integer, Integer> notaFrecuencia = new HashMap<>();
                int moda = -1;
                int maxFrecuencia = 0;
                for (int nota : notas) {
                    int frecuencia = notaFrecuencia.getOrDefault(nota, 0) + 1;
                    notaFrecuencia.put(nota, frecuencia);
                    if (frecuencia > maxFrecuencia) {
                        moda = nota;
                        maxFrecuencia = frecuencia;
                    }
                }

                
                double sumaDiferenciasCuadradas = 0;
                for (int nota : notas) {
                    sumaDiferenciasCuadradas += Math.pow(nota - promedio, 2);
                }
                double desvest = Math.sqrt(sumaDiferenciasCuadradas / cantidadEst);

                
                int minNota = Collections.min(notas);
                int maxNota = Collections.max(notas);

                
                System.out.println("Materia: " + name);
                System.out.println("Promedio: " + promedio);
                System.out.println("Mediana: " + mediana);
                System.out.println("Moda: " + moda);
                System.out.println("Desviación Estándar: " + desvest);
                System.out.println("Cantidad de Estudiantes: " + cantidadEst);
                System.out.println("Valor Mínimo: " + minNota);
                System.out.println("Valor Máximo: " + maxNota);
            } else {
                System.out.println("No hay datos para la materia: " + name);
            }
        }
    }

    
}
