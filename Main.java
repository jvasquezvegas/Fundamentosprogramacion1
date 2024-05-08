import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void mostrarOpciones() {
        System.out.println("Bienvenido al menu de comidas criollas");
        System.out.println("Por favor, seleccione una opcion de comida:");
        System.out.println("1. Arroz con pollo          35 S/.");
        System.out.println("2. Aji de gallina           25 S/.");
        System.out.println("3. Sopa seca con carapulcra 30 S/.");
        System.out.println("4. Rocoto relleno           40 S/.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elecciones = new ArrayList<>();
        boolean continuar = true;

        do {
            int opcion;
            // Mostrar opciones de comida al usuario con precios
            mostrarOpciones();
            // Leer la opcion seleccionada por el usuario
            do {
                System.out.print("Ingrese el numero de su opcion: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un numero valido.");
                    scanner.next(); // Consumir el token no valido
                }
                opcion = scanner.nextInt();

                // Procesar la opcion seleccionada
                switch (opcion) {
                    case 1:
                        elecciones.add("Arroz con pollo");
                        break;
                    case 2:
                        elecciones.add("Aji de gallina");
                        break;
                    case 3:
                        elecciones.add("Sopa seca con carapulcra");
                        break;
                    case 4:
                        elecciones.add("Rocoto relleno");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, seleccione una opcion valida.");
                }
            } while (opcion < 1 || opcion > 4);

            // Preguntar al usuario si desea seguir eligiendo (si/no)
            String respuesta;
            do {
                System.out.print("Desea seguir eligiendo? (si/no): ");
                respuesta = scanner.next();
            } while (!respuesta.equalsIgnoreCase("si") && !respuesta.equalsIgnoreCase("no"));

            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            }
        } while (continuar);

        // Preguntar al usuario si desea mostrar las elecciones o volver al menu principal
        System.out.println("Desea imprimir su boleta?");
        System.out.print("Escriba 'si' o 'no': ");
        String opcionMostrar = scanner.next();
        if (opcionMostrar.equalsIgnoreCase("si")) {
            System.out.println("---------------------------------------------------------");
            System.out.println("               BOLETA DE ELECCIONES");
            System.out.println("---------------------------------------------------------");
            System.out.println("Usted ha seleccionado las siguientes comidas:");
            System.out.println("---------------------------------------------------------");
            double totalSinIGV = 0.0;
            for (String eleccion : elecciones) {
                double precio = 0.0;
                switch (eleccion) {
                    case "Arroz con pollo":
                        precio = 35.0;
                        break;
                    case "Aji de gallina":
                        precio = 25.0;
                        break;
                    case "Sopa seca con carapulcra":
                        precio = 30.0;
                        break;
                    case "Rocoto relleno":
                        precio = 40.0;
                        break;
                }
                double precioConIGV = precio; // Calcula el precio con el IGV incluido
                System.out.println("- " + eleccion + " - Precio: " + precioConIGV); // Imprime el nombre y el precio de la comida
                totalSinIGV += precio; // Agrega el precio al total sin IGV
            }
            double totalConIGV = totalSinIGV * 1.18; // Calcula el total con el IGV incluido
            System.out.println("---------------------------------------------------------");
            System.out.println("Total a pagar (incluido IGV): " + totalConIGV + " S/."); // Imprime el total a pagar con el IGV incluido
            System.out.println("---------------------------------------------------------");

            String respuestaencuesta = " ";


            System.out.println(realizarencuesta(respuestaencuesta));
        }
    }


    //Encuesta de satisfaccion
    public static String realizarencuesta (String respuestaencuesta){

        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Desea completar una encuesta de satisfacción? (si/no): ");
        String respuestaEncuesta = scanner.next();

        if (respuestaEncuesta.equalsIgnoreCase("si")) {
            // Arreglo para almacenar las opciones de calificación
            String[] opciones = {"Muy insatisfecho", "Insatisfecho", "Neutral", "Satisfecho", "Muy satisfecho"};

            // Pedir al usuario que califique su experiencia
            System.out.println("Por favor, califique su experiencia de la comida:");
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }

            int calificacion;

            do {
                System.out.println("Ingrese su calificación (1-5): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Por favor, ingrese un número válido");
                    scanner.next();
                }
                calificacion = scanner.nextInt();
            } while (calificacion < 1 || calificacion > opciones.length);

            // Guardar la calificación elegida por el cliente
            String calificacionElegida = opciones[calificacion - 1];
            System.out.println("Usted eligió: " + calificacionElegida);
            System.out.println("Gracias por completar la encuesta!!");

        }

        return respuestaencuesta;
    }

}