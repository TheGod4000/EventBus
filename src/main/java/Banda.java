import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Banda {
    private final EventBus eventBus;
    private final String nombreBanda;
    private final List<String> repertorio;
    private final Random random;

    public Banda(EventBus eventBus, String nombreBanda) {
        this.eventBus = eventBus;
        this.nombreBanda = nombreBanda;
        this.random = new Random();
        this.repertorio = Arrays.asList(
                "El Algoritmo del Amor",
                "Binary Serenade",
                "Recursión Infinita",
                "Through the Fire and Flames",
                "Stack Overflow Blues"
        );
    }

    public void tocarCancion() {
        String cancion = repertorio.get(random.nextInt(repertorio.size()));
        int duracion = 120 + random.nextInt(120); // 120-240 segundos

        System.out.println("\n[Banda] 🎸 " + nombreBanda + " está tocando: " + cancion);

        BandaTocandoEvent evento = new BandaTocandoEvent(nombreBanda, cancion, duracion);
        eventBus.publicar(evento);
    }

    public void iniciarConcierto(int numeroCanciones, int intervaloSegundos) {
        Thread conciertoThread = new Thread(() -> {
            for (int i = 0; i < numeroCanciones; i++) {
                tocarCancion();
                try {
                    Thread.sleep(intervaloSegundos * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        conciertoThread.start();
    }
}