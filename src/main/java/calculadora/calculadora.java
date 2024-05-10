package calculadora;


import java.util.Scanner;

public class calculadora {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //crea un objeto de la clase calculos
        calculos calculos = new calculos();

        //realiza las operaciones
        try {
            System.out.println("Ingrese el primer numero");
            Integer a = scanner.nextInt();
            System.out.println("Ingrese el segundo numero");
            Integer b = scanner.nextInt();

            System.out.println("La suma es: " + calculos.sumar(a, b));
            System.out.println("La resta es: " + calculos.restar(a, b));
            System.out.println("La multiplicacion es: " + calculos.multiplicar(a, b));
            System.out.println("La division es: " + calculos.dividir(a, b));
        } catch (CalculadoraException e) {
            System.out.println(e.getMessage());
        }
    }
}
