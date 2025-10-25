import java.util.List;

public class SistemaDePedidos {
    private final EventBus eventBus;
    private int contadorPedidos = 0;

    public SistemaDePedidos(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void realizarPedido(String mesaId, List<String> items) {
        contadorPedidos++;
        String pedidoId = "pedido_" + contadorPedidos;

        System.out.println("\n[SistemaDePedidos] 📝 Nuevo pedido recibido:");
        System.out.println("  Mesa: " + mesaId);
        System.out.println("  Pedido: " + pedidoId);
        System.out.println("  Items: " + items);

        PedidoRealizadoEvent evento = new PedidoRealizadoEvent(mesaId, pedidoId, items);
        eventBus.publicar(evento);
    }
}