import java.util.Scanner;
import java.util.Random;

public class Ahorcado {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Arreglo con 10 palabras
        String[] palabras = {"inteligencia", "emociones", "aptitudes", "aprendizaje", 
                             "desarrollo", "industrias", "deportes", "programacion", 
                             "JAVA", "Github"};

        // Seleccionar una palabra aleatoria del arreglo
        String palabrasecreta = palabras[random.nextInt(palabras.length)];

        int intentosPosibles = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabrasecreta.length()];

        // Inicializar el arreglo de letras adivinadas con guiones bajos
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        // Bucle principal del juego
        while (!palabraAdivinada && intentos < intentosPosibles) {
            System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));
            System.out.println("Introduce una letra:");
            char letra = scanner.next().charAt(0);

            boolean letraCorrecta = false;

            // Comprobar si la letra está en la palabra secreta
            for (int i = 0; i < palabrasecreta.length(); i++) {
                if (palabrasecreta.charAt(i) == letra) {
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }

            // Si la letra no es correcta, restar un intento
            if (!letraCorrecta) {
                intentos++;
                System.out.println("Te quedan " + (intentosPosibles - intentos) + " intentos.");
            }

            // Comprobar si se ha adivinado toda la palabra
            if (String.valueOf(letrasAdivinadas).equalsIgnoreCase(palabrasecreta)) {
                palabraAdivinada = true;
                System.out.println("¡Felicidades, has adivinado la palabra: " + palabrasecreta + "!");
            }
        }

        // Si se agotan los intentos y no se adivina la palabra
        if (!palabraAdivinada) {
            System.out.println("GAME OVER. La palabra era: " + palabrasecreta);
        }

        scanner.close();
    }
}
