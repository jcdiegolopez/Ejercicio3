/**
 * La clase Examen representa un examen en un curso con una nota asociada.
 */
public class Examen {
    private String curso; // El nombre del curso al que pertenece el examen.
    private int nota;     // La nota obtenida en el examen.

    /**
     * Constructor de la clase Examen.
     *
     * @param nombre El nombre del curso al que pertenece el examen.
     */
    public Examen(String nombre) {
        this.curso = nombre;
        this.nota = -1; // Inicializamos la nota como -1 para indicar que aún no se ha calificado.
    }

    /**
     * Obtiene la nota obtenida en el examen.
     *
     * @return La nota del examen.
     */
    public int getNota(){
        return this.nota;
    }

    /**
     * Obtiene el nombre del curso al que pertenece el examen.
     *
     * @return El nombre del curso.
     */
    public String getCurso(){
        return this.curso;
    }

    /**
     * Establece la nota obtenida en el examen.
     *
     * @param nota La nota a establecer.
     */
    public void setNota(int nota) {
        this.nota = nota;
    }
}
