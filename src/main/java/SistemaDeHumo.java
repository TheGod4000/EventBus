public class SistemaDeHumo implements EventSubscriber {

    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public SistemaDeHumo() {
    }

    @Override
    public void onEvent(Event evento) {
        if (evento instanceof BandaTocandoEvent) {
            BandaTocandoEvent bandaEvento = (BandaTocandoEvent) evento;

            // Activar efectos especiales para canciones épicas
            if (bandaEvento.getNombreCancion().equalsIgnoreCase("Through the Fire and Flames")) {
                activarEfectosEpicos(bandaEvento);
            }
        }
    }

    private void activarEfectosEpicos(BandaTocandoEvent evento) {
        System.out.println(RED + "[SistemaDeHumo] 🔥💨 ¡¡¡EFECTOS ÉPICOS ACTIVADOS!!!" + RESET);
        System.out.println(RED + "[SistemaDeHumo] 🔥 Dispensando humo y pirotecnia para: " + evento.getNombreCancion() + RESET);
        System.out.println(RED + "[SistemaDeHumo] 💥 ¡LA TABERNA SE ENCIENDE! 💥" + RESET);
    }
}