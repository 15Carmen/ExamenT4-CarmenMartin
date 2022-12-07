package examen;

public class Funciones {
    //Declaramos las constantes globales
    static final int TAMCIRCUITO = 11;
    //Declaramos las variables globales
    static int minDado, maxDado;    //Variable donde se guardará el mínimo y el máximo que puede sacar el dado
    static int fichaJ1, fichaJ2;    //Variable que guardará donde se encuentra cada jugador en el tablero

    /**
     * Metodo que devuelve
     * @return un valor cualquiera entre los valores de las variables globales
     * minDado y maxDado
     */
    static int tiraDados() {
        return (int) (Math.random() * (maxDado - minDado) + minDado);
    }

    /**
     * Metodo que imprimirá el tablero de juego  u las posiciones en las que se encuentran los jugadores
     */
    static void pintaPista() {
        //Imprimimos el tablero
        for (int i = 1; i <= TAMCIRCUITO; i++) {
            System.out.print("\t " + i);
        }

        //Hacemos un salto de linea para separar el tablero del jugador 1
        System.out.println();

        //Usamos un bucle for para situar la fichaJ1 donde le corresponda en el tablero
        for (int i = 1; i <= fichaJ1; i++) {
            System.out.print("\t");
        }
        System.out.print("J1");

        //Hacemos un salto de linea para separar el jugador 1 del jugador 2
        System.out.println();

        //Usamos un bucle for para situar la fichaJ2 donde le corresponda en el tablero
        for (int i = 1; i <= fichaJ2; i++) {
            System.out.print("\t");
        }
        System.out.print("J2");
        //Hacemos un salto de linea para separar el jugador 2 del resto del programa
        System.out.println();
    }

    /**
     * Método al que se le pasará por parámetros
     * @param tirada1  y
     * @param tirada2, sumará ambos numeros y segun di si resultado es primo o no
     * @return verdadero o falso respectivamente
     */
    static boolean sumaDeNumerosEsPrimo(int tirada1, int tirada2) {

        //Declaramos las varaibles
        int suma = tirada1 + tirada2;   //Variable que guarda la suma de los dos parametros
        boolean primo = true;           //Variable booleana donde guardaremos si un numero es primo o no

        for (int i = 2; i < suma; i++) {    //Inicializamos el bucle en 2, lo acabamos en la suma y lo incrementamos en 1
            if (suma % i == 0) {            //Si la suma modulo de i es igual a cero
                primo = false;              //Entonces el resultado de la suma no es primo
                break;                      //Nos salimos del bucle
            }
        }
        return primo;                       //Devolvemos la variable primo
    }

    /**
     * Método que imprimirá quien va ganando la carrera si
     * @param nombreJ1 o bien el
     * @param nombreJ2, o si ambos estan igualados imprimirá que van empate
     */
    void imprimeComoVaLaCarrera(String nombreJ1, String nombreJ2) {

        if (fichaJ1 > fichaJ2) {                                //Si la ficha del jugador1 se encuentra por delante de la del jugador2
            System.out.println("Va ganando " + nombreJ1);       //Imprimimos que va ganando el jugador1
        } else if (fichaJ2 > fichaJ1) {                         //Si la ficha del jugador2 se encuentra por delante de la del jugador1
            System.out.println("Va ganando " + nombreJ2);       //Imprimimos que va ganando el jugador2
        } else {                                                //Si no es ninguno de estos casos
            System.out.println("Los jugadores van empatados");  //Imprimimos que los jugadores van empatados
        }
    }

    /**
     * Método que imprimirá
     * @param nombreJ1 o bien
     * @param nombreJ2 que haya llegado al final del tablero o lo haya sobrepasado primero y
     * @return una cadena vacía hasta entonces
     */
    String esGanador(String nombreJ1, String nombreJ2) {

        //Declaramos una variable cadena vacia
        String ganador = " ";

        if (fichaJ1 >= TAMCIRCUITO) {           //Si la ficha del jugador1 es igual o ha sobrepasado el final del circuito
            ganador = nombreJ1;                 //Indicamos que el ganador es el jugador1
        } else if (fichaJ2 >= TAMCIRCUITO) {    //Si la ficha del jugador2 es igual o ha sobrepasado el final del circuito
            ganador = nombreJ2;                 //Indicamos que el ganador es el jugador2
        }
        return ganador;                         //Devolvemos la variable ganador
    }

}
