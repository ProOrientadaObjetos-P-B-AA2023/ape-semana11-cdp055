abstract class Menu {
    protected String nombrePlato;
    protected double valorMenu;
    protected double valorInicialMenu;

    public Menu(String nombrePlato, double valorMenu, double valorInicialMenu) {
        this.nombrePlato = nombrePlato;
        this.valorMenu = valorMenu;
        this.valorInicialMenu = valorInicialMenu;
    }

    public abstract double calcularSubtotal();

    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getValorMenu() {
        return valorMenu;
    }

    public double getValorInicialMenu() {
        return valorInicialMenu;
    }

    @Override
    public String toString() {
        return "Nombre del plato: " + nombrePlato +
                "\nValor del menú: " + valorMenu +
                "\nValor inicial del menú: " + valorInicialMenu;
    }
}


class MenuCarta extends Menu {
    private double valorPorcionGuarnicion;
    private double valorBebida;
    private double porcentajeServicio;

    public MenuCarta(String nombrePlato, double valorMenu, double valorInicialMenu,
                     double valorPorcionGuarnicion, double valorBebida, double porcentajeServicio) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.valorPorcionGuarnicion = valorPorcionGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
    }

    @Override
    public double calcularSubtotal() {
        return valorMenu + valorPorcionGuarnicion + valorBebida + (valorInicialMenu * porcentajeServicio);
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nValor porción de guarnición: " + valorPorcionGuarnicion +
                "\nValor de bebida: " + valorBebida +
                "\nPorcentaje adicional por servicio: " + porcentajeServicio;
    }
}


class MenuDia extends Menu {
    private double valorPostre;
    private double valorBebida;

    public MenuDia(String nombrePlato, double valorMenu, double valorInicialMenu,
                   double valorPostre, double valorBebida) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
    }

    @Override
    public double calcularSubtotal() {
        return valorMenu + valorPostre + valorBebida;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nValor de postre: " + valorPostre +
                "\nValor de bebida: " + valorBebida;
    }
}


class MenuNinos extends Menu {
    private double valorPorcionHelado;
    private double valorPorcionPastel;

    public MenuNinos(String nombrePlato, double valorMenu, double valorInicialMenu,
                     double valorPorcionHelado, double valorPorcionPastel) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.valorPorcionHelado = valorPorcionHelado;
        this.valorPorcionPastel = valorPorcionPastel;
    }

    @Override
    public double calcularSubtotal() {
        return valorMenu + valorPorcionHelado + valorPorcionPastel;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nValor porción de helado: " + valorPorcionHelado +
                "\nValor porción de pastel: " + valorPorcionPastel;
    }
}


class MenuEconomico extends Menu {
    private double porcentajeDescuento;

    public MenuEconomico(String nombrePlato, double valorMenu, double valorInicialMenu,
                         double porcentajeDescuento) {
        super(nombrePlato, valorMenu, valorInicialMenu);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularSubtotal() {
        double descuento = valorInicialMenu * porcentajeDescuento / 100;
        return valorMenu - descuento;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPorcentaje de descuento: " + porcentajeDescuento;
    }
}


class Cuenta {
    private String nombreCliente;
    private double iva;
    private Menu[] menus;
    private double valorTotal;

    public Cuenta(String nombreCliente, double iva, Menu[] menus) {
        this.nombreCliente = nombreCliente;
        this.iva = iva;
        this.menus = menus;
        this.valorTotal = calcularValorTotal();
    }

    private double calcularValorTotal() {
        double subtotal = 0.0;
        for (Menu menu : menus) {
            subtotal += menu.calcularSubtotal();
        }
        return subtotal + (subtotal * iva / 100);
    }

    @Override
    public String toString() {
        StringBuilder menuStr = new StringBuilder();
        for (Menu menu : menus) {
            menuStr.append("\n").append(menu.toString());
        }

        return "Nombre del cliente: " + nombreCliente +
                "\nSubtotal: " + calcularSubtotal() +
                "\nIVA: " + iva +
                "\nListado de menús:" + menuStr.toString() +
                "\nValor a cancelar total: " + valorTotal;
    }

    private double calcularSubtotal() {
        double subtotal = 0.0;
        for (Menu menu : menus) {
            subtotal += menu.calcularSubtotal();
        }
        return subtotal;
    }
}