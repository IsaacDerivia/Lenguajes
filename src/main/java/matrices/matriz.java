package matrices;


import java.util.InputMismatchException;
import java.util.Scanner;

public class matriz {
  static   Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        matriz matriz = new matriz();
        matriz.crearMatriz();//llama al metodo para crear la matriz

    }

    private void crearMatriz() {
        int filas = solicitarDimension("Ingrese el numero de filas");
        int columnas = solicitarDimension("Ingrese el numero de columnas");
        int[][] matriz = new int[filas][columnas];
        // Aquí puedes continuar con el manejo de la matriz
        ingresarValores(matriz);
    }

    private int solicitarDimension(String mensaje) {
        System.out.println(mensaje);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // descarta la entrada incorrecta
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }

    //metodo para ingresar los valores de la matriz
    private void ingresarValores(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = solicitarValor("Ingrese el valor de la fila " + i +1+ " y columna " + j+1);
            }
        }
        ImpresionMatriz(matriz); //llama al metodo para imprimir la matriz

    }


    //metodo para validacion de entrada
    private int solicitarValor(String mensaje) {
        System.out.println(mensaje);
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next(); // descarta la entrada incorrecta
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }

    private void ImpresionMatriz(int[][] matriz){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }




}

