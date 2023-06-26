import java.util.Scanner;
public class JuegoDeRolEjecutor {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Personaje guerrero = new Guerrero("Guerri", 100, 1, 10);
            Personaje mago = new Mago("Maggi", 80, 1, 20);
            Personaje arquero = new Arquero("Arqui", 90, 1, 15);

            int opcion = 0;

            while (opcion != 4) {
                System.out.println("¡Bienvenido al juego de rol!");
                System.out.println("Selecciona una opción:");
                System.out.println("1. Mostrar información de los personajes");
                System.out.println("2. Realizar una batalla");
                System.out.println("3. Ganar una batalla y subir de nivel");
                System.out.println("4. Salir");

                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("-- Información de los personajes --");
                        guerrero.mostrarInformacion();
                        mago.mostrarInformacion();
                        arquero.mostrarInformacion();
                        break;
                    case 2:
                        System.out.println("-- Realizar una batalla --");
                        System.out.println("Selecciona el atacante:");
                        System.out.println("1. Guerri (Guerrero)");
                        System.out.println("2. Maggi (Mago)");
                        System.out.println("3. Arqui (Arquero)");
                        int atacante = scanner.nextInt();

                        System.out.println("Selecciona el objetivo:");
                        System.out.println("1. Guerri (Guerrero)");
                        System.out.println("2. Maggi (Mago)");
                        System.out.println("3. Arqui (Arquero)");
                        int objetivo = scanner.nextInt();

                        Personaje personajeAtacante = seleccionarPersonaje(atacante, guerrero, mago, arquero);
                        Personaje personajeObjetivo = seleccionarPersonaje(objetivo, guerrero, mago, arquero);

                        if (personajeAtacante != null && personajeObjetivo != null) {
                            personajeAtacante.atacar(personajeObjetivo);
                            personajeObjetivo.defender();
                        } else {
                            System.out.println("Selección inválida");
                        }
                        break;
                    case 3:
                        System.out.println("-- Ganar una batalla y subir de nivel --");
                        System.out.println("Selecciona el personaje para ganar la batalla y subir de nivel:");
                        System.out.println("1. Guerri (Guerrero)");
                        System.out.println("2. Maggi (Mago)");
                        System.out.println("3. Arqui (Arquero)");
                        int ganador = scanner.nextInt();

                        Personaje personajeGanador = seleccionarPersonaje(ganador, guerrero, mago, arquero);

                        if (personajeGanador != null) {
                            personajeGanador.ganarBatalla();
                            personajeGanador.mostrarInformacion();
                        } else {
                            System.out.println("Selección inválida");
                        }
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }

                System.out.println();
            }
        }
        public static Personaje seleccionarPersonaje(int opcion, Personaje guerrero, Personaje mago, Personaje arquero) {
            switch (opcion) {
                case 1:
                    return guerrero;
                case 2:
                    return mago;
                case 3:
                    return arquero;
                default:
                    return null;
            }
        }
    }

