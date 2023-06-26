
public abstract class Personaje {
    protected String nombre;
    protected int puntosVida;
    protected int nivelExperiencia;
    public Personaje(String nombre, int puntosVida, int nivelExperiencia) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelExperiencia = nivelExperiencia;
    }
    public abstract void atacar(Personaje objetivo);
    public abstract void defender();
    public abstract void mostrarInformacion();
    public abstract void recibirDanio(int danio);
    public void ganarBatalla() {
        nivelExperiencia++;
        System.out.println(nombre + " ha ganado la batalla y subido de nivel.");
    }
}

class Guerrero extends Personaje {
    private int fuerza;
    public Guerrero(String nombre, int puntosVida, int nivelExperiencia, int fuerza) {
        super(nombre, puntosVida, nivelExperiencia);
        this.fuerza = fuerza;
    }
    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " ataca con una espada a " + objetivo.nombre);

        int danio = fuerza * nivelExperiencia;
        objetivo.recibirDanio(danio);
    }
    @Override
    public void defender() {
        System.out.println(nombre + " se coloca en posición defensiva");

    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Guerrero: " + nombre + ", PV: " + puntosVida + ", Nivel: " + nivelExperiencia + ", Fuerza: " + fuerza);
    }
    @Override
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }
}

class Mago extends Personaje {
    private int poderMagico;
    public Mago(String nombre, int puntosVida, int nivelExperiencia, int poderMagico) {
        super(nombre, puntosVida, nivelExperiencia);
        this.poderMagico = poderMagico;
    }
    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " lanza un hechizo a " + objetivo.nombre);
        // Lógica de ataque específica para los magos
        int danio = poderMagico * nivelExperiencia;
        objetivo.recibirDanio(danio);
    }
    @Override
    public void defender() {
        System.out.println(nombre + " conjura un escudo protector");

    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Mago: " + nombre + ", PV: " + puntosVida + ", Nivel: " + nivelExperiencia + ", Poder Mágico: " + poderMagico);
    }
    @Override
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }
}
class Arquero extends Personaje {
    private int precision;
    public Arquero(String nombre, int puntosVida, int nivelExperiencia, int precision) {
        super(nombre, puntosVida, nivelExperiencia);
        this.precision = precision;
    }
    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(nombre + " dispara una flecha a " + objetivo.nombre);
        int danio = precision * nivelExperiencia;
        objetivo.recibirDanio(danio);
    }
    @Override
    public void defender() {
        System.out.println(nombre + " se mueve rápidamente para evitar ataques");
    }
    @Override
    public void mostrarInformacion() {
        System.out.println("Arquero: " + nombre + ", PV: " + puntosVida + ", Nivel: " + nivelExperiencia + ", Precisión: " + precision);
    }
    @Override
    public void recibirDanio(int danio) {
        puntosVida -= danio;
        if (puntosVida <= 0) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }
}