import java.util.Arrays;
import java.util.List;

public class Cocina implements EventSubscriber {
    private final EventBus eventBus;
    private final List<String> comidas = Arrays.asList("hamburguesa", "pizza", "pasta", "ensalada", "tacos");

    public Cocina(EventBus eventBus) {
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
            if (esComida(item)) {
                System.out.println("[Cocina] 🍳 Cocinando: " + item + " para pedido " + evento.getPedidoId());

                // Simular tiempo de cocción
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println("[Cocina] ✅ Plato listo: " + item);

                ComidaPreparadaEvent comidaEvento = new ComidaPreparadaEvent(evento.getPedidoId(), item);
                eventBus.publicar(comidaEvento);
            }
        }
    }

    private boolean esComida(String item) {
        return comidas.stream().anyMatch(c -> item.toLowerCase().contains(c));
    }
}