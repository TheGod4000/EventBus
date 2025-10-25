public class SistemaDeSonido implements EventSubscriber {

    public SistemaDeSonido() {
    }

    @Override
    public void onEvent(Event evento) {
        if (evento instanceof BandaTocandoEvent) {
            ajustarEcualizador((BandaTocandoEvent) evento);
        }
    }

    private void ajustarEcualizador(BandaTocandoEvent evento) {
        System.out.println("[SistemaDeSonido] 🔊 Ajustando ecualizador para: " + evento.getNombreCancion());
        System.out.println("  Banda: " + evento.getNombreBanda());
        System.out.println("  Duración: " + evento.getDuracion() + " segundos");
    }
}