package examen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Declaramos las variables
        int tirada1, tirada2;   //Variables donde guardaremos las tiradas de cada jugador
        String nomJ1, nomJ2;    //Variables donde guardaremos los ombres de cada jugador

        //Declaramos el scanner para poder leer por consola
        Scanner sc = new Scanner(System.in);

        //Declaramos un objeto de la clase Funciones() para poder llamar a los métodos no estáticos de esta
        Funciones funciones = new Funciones();

        //Le damos la bienvenida al usuario
        System.out.println("BIENVENIDO A LA CARRERA DEL SIGLO!");

        //Le pedimos al usuario que introduzca el minimo y el maximo de caras que va a tener el dado y los guardamos en las variables correspondientes
        System.out.println("Introduzca el numero minimo del dado: ");
        Funciones.minDado = sc.nextInt();
        System.out.println("Introduzca el numero maximo del dado: ");
        Funciones.maxDado = sc.nextInt();

        //Le pedimos al usuario que introduzca el nombre de los jugadores y los guardamos en las varaibles correspondientes
        System.out.println("Introduzca el nombre del jugador 1: ");
        nomJ1 = sc.next();
        System.out.println("Introduzca el nombre del jugador 2: ");
        nomJ2 = sc.next();

        //Mientras que los dos nombres de lso jugadores sean iguales, se pedirá un nuevo nombre hasta que el nombre del jugador 2 sea distinto al del jugador 1
        while (nomJ1.equals(nomJ2)){
            System.out.println("Los dos jugadores no se pueden llamar igual");
            System.out.println("Introduzca el nombre del jugador 2: ");
            nomJ2 = sc.next();
        }

        //Hacemos un salto de linea estético (para que el programa quede más bonito)
        System.out.println();

        //Comenzamos el juego
        System.out.println("COMENCEMOS A JUGAR!");

        //Imprimimos el tablero inicial
        Funciones.pintaPista();
        //Hacemos un salto de linea estético (para que el programa quede más bonito)
        System.out.println();

        //Mientras que el metodo esGanador() devulva una cadena vacia
        while (funciones.esGanador(nomJ1, nomJ2).equals(" ")){

            //le pedimos al usuario que introduzca un caracter cualquiera. Esto lo usamos como forma de ir viendo el desarrollo del juego poco a poco
            System.out.println("Pulsa cualquier tecla para continuar: ");
            String espera = sc.next();
            //Hacemos un salto de linea estético (para que el programa quede más bonito)
            System.out.println();

            //Indicamos de quien es el turno
            System.out.println("Turno para el jugador 1 " + nomJ1);

            //Guardamos en las variables tiradas un numero aleatorio generado por la función tiraDados()
            tirada1 = Funciones.tiraDados();
            tirada2 = Funciones.tiraDados();

            //Imprimimos lo que ha sacado el jugador 1 en cada tirada
            System.out.println("Ha sacado un "+ tirada1 + " en la primera tirada");
            System.out.println("Ha sacado un "+ tirada2 + " en la segunda tirada");

            //Si el resultado de la suma de las tiradas no es un numero primo
            if (!Funciones.sumaDeNumerosEsPrimo(tirada1, tirada2)){
                //Imprimimos que la tirada no es válida
                System.out.println("TIRADA NO VALIDA!");
                System.out.println("No suma puntos ya que la tirada de los dos numeros NO ES PRIMO");
            }else { //Si el resultado de la suma de las tiradas es un numero primo
                //Imprimimos que la tirada es válida
                System.out.println("TIRADA VALIDA!");

                //Le añadimos a la ficha del jugador 1 la suma de las tiradas, pues ahí es donde se colocará en el tablero
                int sumaTiradas = tirada1+tirada2;
                Funciones.fichaJ1 += sumaTiradas;
            }

            //Hacemos un salto de linea estético (para que el programa quede más bonito)
            System.out.println();

            //Volvemos a mostrar el tablero y le mostramos al usuario como va la carrera
            Funciones.pintaPista();
            funciones.imprimeComoVaLaCarrera(nomJ1, nomJ2);

            //Hacemos un salto de linea estético (para que el programa quede más bonito)
            System.out.println();

            //Indicamos de quien es el turno
            System.out.println("Turno para el jugador 2 " + nomJ2);

            //Guardamos en las variables tiradas un numero aleatorio generado por la función tiraDados()
            tirada1 = Funciones.tiraDados();
            tirada2 = Funciones.tiraDados();

            //Imprimimos lo que ha sacado el jugador 1 en cada tirada
            System.out.println("Ha sacado un "+ tirada1 + " en la primera tirada");
            System.out.println("Ha sacado un "+ tirada2 + " en la segunda tirada");

            //Si el resultado de la suma de las tiradas no es un numero primo
            if (!Funciones.sumaDeNumerosEsPrimo(tirada1, tirada2)){
                //Imprimimos que la tirada no es válida
                System.out.println("TIRADA NO VALIDA!");
                System.out.println("No suma puntos ya que la tirada de los dos numeros NO ES PRIMO");
            }else { //Si el resultado de la suma de las tiradas es un numero primo
                //Imprimimos que la tirada es válida
                System.out.println("TIRADA VALIDA!");

                //Le añadimos a la ficha del jugador 2 la suma de las tiradas, pues ahí es donde se colocará en el tablero
                int sumaTiradas = tirada1+tirada2;
                Funciones.fichaJ2 += sumaTiradas;
            }

            //Hacemos un salto de linea estético (para que el programa quede más bonito)
            System.out.println();

            //Volvemos a mostrar el tablero y le mostramos al usuario como va la carrera
            Funciones.pintaPista();
            funciones.imprimeComoVaLaCarrera(nomJ1, nomJ2);

            //Hacemos un salto de linea estético (para que el programa quede más bonito)
            System.out.println();
        }

        //Imprimimos por pantalla el ganador de la carrera
        System.out.println("JUGADOR GANADOR: " + funciones.esGanador(nomJ1, nomJ2));

    }
}
