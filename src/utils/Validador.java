package utils;
import java.util.Scanner;


public class Validador {
    public static int leerEntero(Scanner sc){
        while (!sc.hasNextInt()){
            System.out.print("Ingresa un numero entero válido: ");
            sc.next();
        }
        return sc.nextInt();
    }
    public static double leerDouble(Scanner sc){
        while (!sc.hasNextDouble()){
            System.out.print("Ingresa un numero válido: ");
            sc.next();
        }
        return sc.nextDouble();
    }
}
