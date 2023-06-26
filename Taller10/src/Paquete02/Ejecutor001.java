import java.util.Scanner;

public class Ejecutor001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menú principal
        int opcion = 0;
        do {
            System.out.println("RESTAURANTE");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearCuenta(scanner);
                    break;
                case 2:
                    System.out.println("¡Gracias por visitarnos!");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 2);

        scanner.close();
    }

    public static void crearCuenta(Scanner scanner) {
        // Crear los menús
        Menu[] menus = new Menu[5];
        menus[0] = new MenuNinos("Hamburguesa", 8.5, 10.0, 2.0, 1.5);
        menus[1] = new MenuNinos("Pizza", 9.0, 10.5, 1.5, 2.0);
        menus[2] = new MenuEconomico("Menú económico", 6.0, 8.0, 20.0);
        menus[3] = new MenuDia("Menú del día", 10.0, 12.0, 1.5, 2.0);
        menus[4] = new MenuCarta("Pasta", 15.0, 18.0, 3.0, 2.5, 10.0);

        // Crear la cuenta
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        System.out.print("Ingrese el valor del IVA: ");
        double iva = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea
        Cuenta cuenta = new Cuenta(nombreCliente, iva, menus);

        // Imprimir información de la cuenta
        System.out.println("\n--- Cuenta ---");
        System.out.println(cuenta.toString());
        System.out.println("--------------");
    }
}

