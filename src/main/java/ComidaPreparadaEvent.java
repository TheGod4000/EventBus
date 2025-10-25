public class ComidaPreparadaEvent extends Event {
    private final String pedidoId;
    private final String plato;

    public ComidaPreparadaEvent(String pedidoId, String plato) {
        super();
        this.pedidoId = pedidoId;
        this.plato = plato;
    }

    @Override
    public String getEventType() {
        return "ComidaPreparada";
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public String getPlato() {
        return plato;
    }

    @Override
    public String toString() {
        return "ComidaPreparadaEvent{" +
                "pedido=" + pedidoId +
                ", plato=" + plato +
                '}';
    }
}