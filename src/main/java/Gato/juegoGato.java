package Gato;

import java.util.Scanner;

public class juegoGato {
    Scanner sc = new Scanner(System.in);

    //se crea el tablero
    private char[][] tablero = new char[3][3];
    private char jugador = 'X';
    private int fila, columna;

    //se crea el constructor
    public juegoGato(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                tablero[i][j] = ' ';
            }
        }
    }

    //se crea el metodo para imprimir el tablero
    public void imprimirTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j] + " | ");
            }
            System.out.println("\n----------");
        }
    }

    //se crea el metodo para cambiar de jugador
    public void cambiarJugador(){
        if(jugador == 'X'){
            jugador = 'O';
        }else{
            jugador = 'X';
        }
    }

    //se crea el metodo para jugar
    public void jugar(){
        System.out.println("Jugador " + jugador + " es tu turno");
        System.out.println("Ingresa la fila y la columna");
        fila = sc.nextInt();
        columna = sc.nextInt();

        //se valida si la fila y la columna estan dentro del rango
        if(!validar(fila, columna)){
            System.out.println("Fila o columna invalida");
            jugar();
        }

        if(tablero[fila][columna] == ' '){
            tablero[fila][columna] = jugador;
        }else{
            System.out.println("Casilla ocupada");
            jugar();
        }
    }

    //se crea el metodo para verificar si hay un ganador
    public boolean hayGanador(){
        // Verificar filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] != ' ' && tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2]) {
                return true;
            }
        }

        // Verificar columnas
        for (int i = 0; i < 3; i++) {
            if (tablero[0][i] != ' ' && tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i]) {
                return true;
            }
        }

        // Verificar diagonales
        if (tablero[0][0] != ' ' && tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2]) {
            return true;
        }

        if (tablero[0][2] != ' ' && tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0]) {
            return true;
        }

        // Si no se cumple ninguna de las condiciones de ganancia, se retorna false
        return false;
    }

    //se crea el metodo para verificar si hay empate
    public boolean hayEmpate(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(tablero[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    //se crea el metodo para jugar
    public void jugarGato(){
        while(true){
            imprimirTablero();
            jugar();
            if(hayGanador()){
                imprimirTablero();
                System.out.println("Jugador " + jugador + " ha ganado");
                break;
            }
            if(hayEmpate()){
                imprimirTablero();
                System.out.println("Empate");
                break;
            }
            cambiarJugador();
        }
    }

    //se crea metodo para validar
    public boolean validar(int fila, int columna){
        if(fila >= 0 && fila < 3 && columna >= 0 && columna < 3){
            return true;
        }
        return false;
    }

    //se crea el metodo main
    public static void main(String[] args) {
        juegoGato gato = new juegoGato();
        gato.jugarGato();
    }
}
