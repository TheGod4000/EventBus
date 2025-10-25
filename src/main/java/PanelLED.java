public class PanelLED implements EventSubscriber {

    // Códigos ANSI para colores
    private static final String RESET = "\u001B[0m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";
    private static final String BLUE = "\u001B[34m";
    private static final String MAGENTA = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";

    public PanelLED() {
    }

    @Override
    public void onEvent(Event evento) {
        if (evento instanceof PedidoRealizadoEvent) {
            mostrarPedidoRealizado((PedidoRealizadoEvent) evento);
        } else if (evento instanceof BebidaServidaEvent) {
            mostrarBebidaServida((BebidaServidaEvent) evento);
        } else if (evento instanceof ComidaPreparadaEvent) {
            mostrarComidaPreparada((ComidaPreparadaEvent) evento);
        } else if (evento instanceof BandaTocandoEvent) {
            mostrarBandaTocando((BandaTocandoEvent) evento);
        }
    }

    private void mostrarPedidoRealizado(PedidoRealizadoEvent evento) {
        System.out.println(YELLOW + "[PANEL LED] 📋 ¡Nuevo pedido en " + evento.getMesaId() + "!" + RESET);
    }

    private void mostrarBebidaServida(BebidaServidaEvent evento) {
        System.out.println(GREEN + "[PANEL LED] 🍹 ¡Nueva bebida servida en la " + evento.getMesaId() + "! (" + evento.getBebida() + ")" + RESET);
    }

    private void mostrarComidaPreparada(ComidaPreparadaEvent evento) {
        System.out.println(CYAN + "[PANEL LED] 🍽️ ¡Comida lista para " + evento.getPedidoId() + "! (" + evento.getPlato() + ")" + RESET);
    }

    private void mostrarBandaTocando(BandaTocandoEvent evento) {
        System.out.println(MAGENTA + "[PANEL LED] 🎵 ♫ Ahora suena: " + evento.getNombreCancion() + " - " + evento.getNombreBanda() + " ♫" + RESET);
    }
}