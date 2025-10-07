

import org.example.Estudiantes;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiantes> estudiantes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String comando;

        System.out.println("Bienvenido al sistema de gestión de estudiantes.");
        System.out.println("Escribe un comando: añadir, listar, buscar, media, mejor, salir");

        do {
            System.out.print("\n Introduce el comando a realizar: Añadir,Listar,Buscar,Media,Mejor o Salir ");
            comando = scanner.nextLine().trim().toLowerCase();

            switch (comando) {
                case "añadir":
                    añadirEstudiante(estudiantes, scanner);
                    break;
                case "listar":
                    listarEstudiantes(estudiantes);
                    break;
                case "buscar":
                    buscarEstudiante(estudiantes, scanner);
                    break;
                case "media":
                    calcularMedia(estudiantes);
                    break;
                case "mejor":
                    mostrarMejor(estudiantes);
                    break;
                case "salir":
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Comando no reconocido. Intenta otra vez.");
            }
        } while (!comando.equals("salir"));

        scanner.close();
    }

    public static void añadirEstudiante(ArrayList<Estudiantes> lista, Scanner scanner) {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(scanner.nextLine());
        System.out.print("Nota media: ");
        double media = Double.parseDouble(scanner.nextLine());
        System.out.print("¿Está matriculado? (true/false): ");
        boolean matricula = Boolean.parseBoolean(scanner.nextLine());

        lista.add(new Estudiantes(nombre, edad, media, matricula));
        System.out.println("Estudiante añadido.");
    }

    public static void listarEstudiantes(ArrayList<Estudiantes> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay ningun estudiante registrado.");
            return;
        }
        for (Estudiantes e : lista) {
            System.out.println("Nombre: " + e.getNombre() +
                    ", Edad: " + e.getEdad() +
                    ", Media: " + e.getMedia() +
                    ", Matrícula: " + (e.getMatricula() ? "Sí" : "No"));
        }
    }

    public static void buscarEstudiante(ArrayList<Estudiantes> lista, Scanner scanner) {
        System.out.print("Nombre a buscar: ");
        String nombre = scanner.nextLine();
        boolean encontrado = false;

        for (Estudiantes e : lista) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Encontrado: " + e.getNombre() +
                        ", Edad: " + e.getEdad() +
                        ", Media: " + e.getMedia());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public static void calcularMedia(ArrayList<Estudiantes> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        double suma = 0;
        for (Estudiantes e : lista) {
            suma += e.getMedia();
        }
        System.out.println("Media general: " + (suma / lista.size()));
    }

    public static void mostrarMejor(ArrayList<Estudiantes> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
            return;
        }

        Estudiantes mejor = lista.get(0);
        for (Estudiantes e : lista) {
            if (e.getMedia() > mejor.getMedia()) {
                mejor = e;
            }
        }

        System.out.println("El Mejor estudiante es: " + mejor.getNombre() +
                " con una media de " + mejor.getMedia());
    }
}
