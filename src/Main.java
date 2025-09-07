import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String,Set<String>> equipos = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("Menu:");
            System.out.println("1. Registrar Equipo");
            System.out.println("2. Registrar Jugadores en un equipo");
            System.out.println("3. Eliminar equipos de futbol");
            System.out.println("4. Mostrar equipos de futbol");
            System.out.println("5. Mostrar jugadores de un equipo");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    System.out.println("Ingresa el nombre del equipo");
                    String nombreequipo = sc.nextLine();
                    if(equipos.containsKey(nombreequipo)){
                        System.out.println("El equipo ya existe");
                    }else{
                        equipos.put(nombreequipo,new HashSet<>());
                        System.out.println("Equipo registrado: "+ nombreequipo);
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del equipo: ");
                    nombreequipo = sc.nextLine();
                    if (equipos.containsKey(nombreequipo)) {
                        System.out.print("Ingrese el nombre del jugador: ");
                        String nombreJugador = sc.nextLine();
                        equipos.get(nombreequipo).add(nombreJugador);
                        System.out.println("Jugador registrado en " + nombreequipo);
                    } else {
                        System.out.println("El equipo no existe.");
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del equipo a eliminar: ");
                    nombreequipo = sc.nextLine();
                    if (equipos.containsKey(nombreequipo)){
                        equipos.remove(nombreequipo);
                        System.out.println("Equipo eliminado");
                    }else{
                        System.out.println("El equipo no existe.");
                    }
                    break;
                case 4:
                    System.out.println("Equipos registrados: ");
                    for(String equipo : equipos.keySet()){
                        System.out.println(equipo);
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del equipo:");
                    nombreequipo = sc.nextLine();
                    if (equipos.containsKey(nombreequipo)){
                        System.out.println("Jugadores del equipo "+ nombreequipo + ": ");
                        for(String jugador : equipos.get(nombreequipo)){
                            System.out.println(jugador);
                        }
                    }else{
                        System.out.println("El equipo no existe");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }while(opcion != 6);
        sc.close();
    }
}