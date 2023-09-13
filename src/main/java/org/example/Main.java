package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[][] plantas = new String[100][6];
        String password = "admin123";
        while (!login(password,plantas)){
        }
    }

    public static void menu(String[][] plantas) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Que desea hacer: ");
        System.out.println("[1] Agregar planta");
        System.out.println("[2] Eliminar planta");
        System.out.println("[3] Buscar plantas");
        System.out.println("[4] Mostrar plantas");
        System.out.println("[5] Salir");
        llamarMetodos(teclado.nextInt(),plantas);
        menu(plantas);
    }
    public static void llamarMetodos(int opcion, String[][] plantas) {

        Scanner teclado = new Scanner(System.in);
        switch (opcion) {
            case 1:
                agregarPlanta(plantas);
                break;
            case 2:
                eliminarPlanta(plantas);
                break;
            case 3:
                buscarPlanta(plantas);
                break;
            case 4:
                mostrarPlantas(plantas);
                break;
            case 5:
                System.out.println("Adios");
                System.exit(0);
            default:
                System.out.println("Opcion incorrecta");
                break;
        }
    }

    private static String[][] eliminarPlanta(String[][] plantas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el ID de la planta que desea eliminar");
        int id = teclado.nextInt();
        if (plantas[id-1][0]!= null && plantas[id-1][5].equals(String.valueOf(id))) {
            for (int j = 0; j < plantas[id-1].length; j++) {
                plantas[id - 1][j] = null;
            }
            System.out.println("Planta "+id+" eliminada");
        }else {
            System.out.println("No existe planta con ese ID");
        }
        return plantas;
    }

    public static String[][] agregarPlanta(String[][] plantas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la planta");
        String nombre = teclado.nextLine();
        System.out.println("Ingrese la clasificacion");
        String clasificacion = teclado.nextLine();
        System.out.println("Ingrese el tamano");
        String tamano = teclado.next();
        System.out.println("Ingrese el ambiente");
        String ambiente = teclado.next();
        System.out.println("Ingrese el precio");
        int precio = teclado.nextInt();
        int fila = filaVacia(plantas);
        String[] datos = {nombre, clasificacion, tamano, ambiente, String.valueOf(precio), String.valueOf(fila+1)};
        if (fila!=-1){
            for (int j = 0; j <plantas[fila].length ; j++) {
                    plantas[fila][j] = datos[j];
            }
        }else{
            System.out.println("La colección esta llena");
        }
        return plantas;

    }
    public static void mostrarPlantas(String[][] plantas) {
        for (int i = 0; i <plantas.length ; i++) {
            if (plantas[i][0]!= null){
                for (int j = 0; j <plantas[i].length ; j++) {
                    switch (j) {

                        case 0:
                            System.out.print("Nombre: ");
                            break;
                        case 1:
                            System.out.print("Clasificación: ");
                            break;
                        case 2:
                            System.out.print("Tamaño: ");
                            break;
                        case 3:
                            System.out.print("Ambiente: ");
                            break;
                        case 4:
                            System.out.print("Precio: ");
                            break;
                        case 5:
                            System.out.print("ID: ");
                            break;
                        default:
                    }
                    System.out.print(plantas[i][j]+", ");
                }
                System.out.println();
            }
        }
    }
    public static void buscarPlanta(String[][] plantas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la planta que desea buscar");
        String nombre = teclado.nextLine();
        for (int i = 0; i <plantas.length ; i++) {
            if (plantas[i][0]!= null && plantas[i][0].equals(nombre)){
                for (int j = 0; j <plantas[i].length ; j++) {
                    switch (j) {

                        case 0:
                            System.out.print("Nombre: ");
                            break;
                        case 1:
                            System.out.print("Clasificación: ");
                            break;
                        case 2:
                            System.out.print("Tamaño: ");
                            break;
                        case 3:
                            System.out.print("Ambiente: ");
                            break;
                        case 4:
                            System.out.print("Precio: ");
                            break;
                        case 5:
                            System.out.print("ID: ");
                            break;
                        default:
                    }
                    System.out.print(plantas[i][j]+", ");
                }
                System.out.println();
                return;
            }
        }
        System.out.println("Planta no encontrada");
    }
    public static int filaVacia(String[][] plantas){
        for (int i = 0; i <plantas.length ; i++) {
            for (int j = 0; j <plantas[i].length ; j++) {
                if (plantas[i][j] == null){
                    return i;
                }
            }
        }
        return -1;
    }
    public static boolean login(String password, String[][] plantas) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese contraseña / [x] Salir");
        String ans = teclado.nextLine();
        if (ans.equals(password)) {
            System.out.println("Bienvenido");
            menu(plantas);
        } else if (ans.equals("x")) {
            System.out.println("Saliendo...");
            System.exit(0);
        }else{
            System.out.println("Contraseña incorrecta");
            return false;
        }
        return true;
    }


}