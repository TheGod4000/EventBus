import java.util.Arrays;
import java.util.List;

public class Barra implements EventSubscriber {
    private final EventBus eventBus;
    private final List<String> bebidas = Arrays.asList("cerveza", "vino", "agua", "refresco", "café");

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public void onEvent(Event evento) {
        if (evento instanceof PedidoRealizadoEvent) {
            procesarPedido((PedidoRealizadoEvent) evento);
        }
    }

    private void procesarPedido(PedidoRealizadoEvent evento) {
        List<String> items = evento.getItems();

        for (String item : items) {
            if (esBebida(item)) {
                System.out.println("[Barra] 🍺 Preparando bebida: " + item + " para mesa " + evento.getMesaId());

                // Simular tiempo de preparación
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("[Barra] ✅ Bebida lista: " + item);

                BebidaServidaEvent bebidaEvento = new BebidaServidaEvent(evento.getMesaId(), item);
                eventBus.publicar(bebidaEvento);
            }
        }
    }

    private boolean esBebida(String item) {
        return bebidas.stream().anyMatch(b -> item.toLowerCase().contains(b));
    }
}