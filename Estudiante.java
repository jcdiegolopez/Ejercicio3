/**
 * La clase Estudiante representa a un estudiante con información personal y una lista de exámenes.
 */
public class Estudiante {
    private String nombre;        // El nombre del estudiante.
    private String apellido;      // El apellido del estudiante.
    private int unicode;          // El número de identificación único del estudiante.
    private String birthDate;     // La fecha de nacimiento del estudiante.
    private String email;         // La dirección de correo electrónico del estudiante.
    private Examen[] examenes;    // La lista de exámenes del estudiante.

    /**
     * Constructor de la clase Estudiante.
     *
     * @param nombre     El nombre del estudiante.
     * @param apellido   El apellido del estudiante.
     * @param email      La dirección de correo electrónico del estudiante.
     * @param unicode    El número de identificación único del estudiante.
     * @param birthDate  La fecha de nacimiento del estudiante.
     */
    public Estudiante(String nombre, String apellido, String email, int unicode, String birthDate){
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.unicode = unicode;
        this.birthDate = birthDate;
        this.examenes = new Examen[6];
        String[] names = {"Matemática", "Lenguaje", "Química", "Física", "Comprensión Lectora", "Estadística"};
        for(int i = 0; i < examenes.length; i++){
            examenes[i] = new Examen(names[i]);
        }
    }

    /**
     * Obtiene el nombre del estudiante.
     *
     * @return El nombre del estudiante.
     */
    public String getNombre(){
        return this.nombre;
    }

    /**
     * Obtiene el apellido del estudiante.
     *
     * @return El apellido del estudiante.
     */
    public String getApellido(){
        return this.apellido;
    }

    /**
     * Obtiene la dirección de correo electrónico del estudiante.
     *
     * @return La dirección de correo electrónico del estudiante.
     */
    public String getEmail(){
        return this.email;
    }

    /**
     * Obtiene el número de identificación único del estudiante.
     *
     * @return El número de identificación único del estudiante.
     */
    public int getCarne(){
        return this.unicode;
    }

    /**
     * Obtiene la fecha de nacimiento del estudiante.
     *
     * @return La fecha de nacimiento del estudiante.
     */
    public String getFecha(){
        return this.birthDate;
    }

    /**
     * Obtiene la lista de exámenes del estudiante.
     *
     * @return La lista de exámenes del estudiante.
     */
    public Examen[] getExamenes(){
        return this.examenes;
    }

    /**
     * Obtiene un examen específico del estudiante por nombre del curso.
     *
     * @param Curso El nombre del curso del examen que se desea obtener.
     * @return El examen correspondiente al curso especificado, o null si no se encuentra.
     */
    public Examen getExamen(String Curso){
        for(int i = 0; i < examenes.length; i++){
            if(examenes[i].getCurso().equals(Curso)){
                return examenes[i];
            }
        }
        return null;
    }
}

