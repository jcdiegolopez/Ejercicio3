import java.util.ArrayList;
import java.util.Scanner;

/**
 * La clase Driver es la clase principal que inicia y gestiona el programa de gestión de sedes y estudiantes.
 * Permite al usuario crear sedes, seleccionar sedes, agregar estudiantes, asignar notas y mostrar estadísticas.
 */
public class Driver {

    public static void main(String[] args){
        ArrayList<Sede> sedes = new ArrayList<Sede>();
        Scanner myScan = new Scanner(System.in);
        sedes.add(new Sede("Central"));
        sedes.add(new Sede("Sur"));
        sedes.add(new Sede("Antiplano"));

        boolean ciclo = true;

        while(ciclo){
            System.out.println("Ingrese que desea hacer: ");
            System.out.println("1. Crear campus: ");
            System.out.println("2. Elegir campus: ");
            System.out.println("3. Salir: ");

            int opt = myScan.nextInt();

            switch(opt){
                case 1:{
                    System.out.println("Ingrese el nombre del nuevo campus: ");
                    String name = myScan.next();
                    System.out.println("Campus creado: ");
                    sedes.add(new Sede(name));

                    break;
                }
                case 2:{
                    System.out.println("Ingrese el indice del campus deseado: ");
                    for(int i = 0; i < sedes.size(); i++){
                        System.out.println(i + ". " + sedes.get(i).getNombre());
                    }

                    int select = myScan.nextInt();
                    Sede mySede;
                    try {
                        mySede = sedes.get(select);
                        System.out.println("Sede seleccionada con exito");
                    } catch (Exception e) {
                        System.out.println(e);
                        break;
                    }

                    boolean menu = true;
                    while(menu){
                        System.out.println("Ingrese que desea hacer: ");
                        System.out.println("1. Añadir estudiante: ");
                        System.out.println("2. Mostrar Estudiantes: ");
                        System.out.println("3. Añadir notas: ");
                        System.out.println("4. Mostrar estadisticas: ");
                        System.out.println("5. Salir de la sede: ");

                        int menuOpt = myScan.nextInt();

                        switch(menuOpt){
                            case 1:{
                                System.out.println("Ingrese el nombre del estudiante: ");
                                String name1 = myScan.next();
                                System.out.println("Ingrese el apellido del estudiante: ");
                                String ape1 = myScan.next();
                                System.out.println("Ingrese el correo del estudiante: ");
                                String email1 = myScan.next();
                                System.out.println("Ingrese el codigo unico del estudiante: ");
                                int unicode1 = myScan.nextInt();
                                System.out.println("Ingrese la fecha de nacimiento del estudiante: ");
                                String date1 = myScan.next();
                                try {
                                    mySede.addEstudiante(name1, ape1, email1, unicode1, date1);
                                    System.out.println("Estudiante creado");
                                } catch (Exception e) {
                                    System.out.println(e);
                                    break;
                                }
                                break;
                            }
                            case 2: {
                                mySede.describeEstudiante();
                                break;
                            }
                            case 3: {
                                System.out.println("Ingrese el codigo unico del estudiante: ");
                                int myCode = myScan.nextInt();
                                Estudiante myEstudiante = null;
                                try {
                                    for(Estudiante estud: mySede.getEstudiantes()){
                                        if(estud.getCarne() == myCode){
                                            myEstudiante = estud;
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println(e);
                                    break;
                                }
                                if(myEstudiante != null){
                                    for (Examen exa : myEstudiante.getExamenes()) {
                                        System.out.println("¿Ha realizado el examen de " + exa.getCurso() +"? (si/no)" );
                                        String yesno = myScan.next();
                                        System.out.println(yesno);
                                        if(yesno.equals("si") || yesno.equals("Si") || yesno.equals("sí") || yesno.equals("Sí") ){
                                            System.out.println("Ingrese la nota de su examen: ");
                                            int note = myScan.nextInt();
                                            exa.setNota(note);
                                        }
                                    }

                                    System.out.println("Notas ingresadas con exito");
                                }else{
                                    System.out.println("No existe un estudiante con este codigo");
                                }
                                

                                break;
                            }
                            case 4:{
                                mySede.Estadisticas();
                                break;
                            }
                            case 5: {
                                System.out.println("Saliendo de la sede");
                                menu = false;
                                break;
                            }
                            default : {
                                System.out.println("No es una opcion valida");
                                break;
                            }
                        }   
                    }
                    break;
                    

                }
                case 3:{
                    System.out.println("Saliendo del programa");
                    ciclo = false;
                    break;
                }
                default:{
                    System.out.println("No es una opcion valida");
                    break;
                }
            }
        }
        


        myScan.close();
    }
}
