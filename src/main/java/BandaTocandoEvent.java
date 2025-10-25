public class BandaTocandoEvent extends Event {
    private final String nombreBanda;
    private final String nombreCancion;
    private final int duracion;

    public BandaTocandoEvent(String nombreBanda, String nombreCancion, int duracion) {
        super();
        this.nombreBanda = nombreBanda;
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    @Override
    public String getEventType() {
        return "BandaTocando";
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {
        return "BandaTocandoEvent{" +
                "banda=" + nombreBanda +
                ", cancion=" + nombreCancion +
                ", duracion=" + duracion + "s" +
                '}';
    }
}