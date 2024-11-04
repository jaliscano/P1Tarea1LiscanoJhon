/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.p1tarea1liscanojhonjava;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.json.JSONObject;

public class P1Tarea1LiscanoJhonJava {

    static float[] liscanoGrades = new float[3];
    static float liscanoAverage, liscanoTotal = 0;
    static int opMenu;

    public static void main(String[] args) {
        liscanoMenu();
    }

    public static void liscanoMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("INGRESO DE NOTAS PARA CALCULAR EL PROMEDIO Y GUARDAR EN ARCHIVOS");

        do {
            System.out.println("1. Ingreso de notas y calculo del promedio");
            System.out.println("2. Guardar en archivo .csv");
            System.out.println("3. Guardar en archivo .json");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opcion: ");
            opMenu = scanner.nextInt();

            switch (opMenu) {
                case 1:
                    liscanoGradesAndAverage(scanner);
                    break;
                case 2:
                    liscanoSaveToCSV();
                    break;
                case 3:
                    liscanoSaveToJSON();
                    break;
                case 4:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion erronea, intente de nuevo");
                    break;
            }
        } while (opMenu != 4);

        scanner.close();
    }

    public static void liscanoGradesAndAverage(Scanner scanner) {
        liscanoTotal = 0;
        System.out.println("Ingrese tres notas");
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese la nota " + (i + 1) + ": ");
            liscanoGrades[i] = scanner.nextFloat();
            while (liscanoGrades[i] < 0 || liscanoGrades[i] > 20) {
                System.out.print("Error, las notas deben ser de 0 a 20, vuelva a ingresar: ");
                liscanoGrades[i] = scanner.nextFloat();
            }
            liscanoTotal = liscanoTotal + liscanoGrades[i];
        }
        liscanoAverage = liscanoTotal / 3;
        System.out.println("Promedio: " + liscanoAverage);
        System.out.println(liscanoAverage >= 14 ? "Fue Aprobado" : "Fue Reprobado");
    }

    public static void liscanoSaveToCSV() {
        try (FileWriter file = new FileWriter("liscanoNotas.csv")) {
            file.write("Nota 1,Nota 2,Nota 3,Promedio,Estado\n");
            file.write(liscanoGrades[0] + "," + liscanoGrades[1] + "," + liscanoGrades[2] + "," + liscanoAverage + ",");
            file.write(liscanoAverage >= 14 ? "Aprobado" : "Reprobado");
            System.out.println("Datos guardados en 'liscanoNotas.csv'");
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo CSV");
        }
    }

    public static void liscanoSaveToJSON() {
        JSONObject json = new JSONObject();
        json.put("Nota 1", liscanoGrades[0]);
        json.put("Nota 2", liscanoGrades[1]);
        json.put("Nota 3", liscanoGrades[2]);
        json.put("Promedio", liscanoAverage);
        json.put("Estado", liscanoAverage >= 14 ? "Aprobado" : "Reprobado");

        try (FileWriter file = new FileWriter("liscanoNotas.json")) {
            file.write(json.toString(4));
            System.out.println("Datos guardados en 'liscanoNotas.json'");
        } catch (IOException e) {
            System.out.println("Error al guardar en archivo JSON");
        }
    }

}
