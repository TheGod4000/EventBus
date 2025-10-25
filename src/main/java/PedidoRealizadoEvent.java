import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PedidoRealizadoEvent extends Event {
    private final String mesaId;
    private final String pedidoId;
    private final List<String> items;

    public PedidoRealizadoEvent(String mesaId, String pedidoId, List<String> items) {
        super();
        this.mesaId = mesaId;
        this.pedidoId = pedidoId;
        this.items = new ArrayList<>(items); // Copia defensiva
    }

    @Override
    public String getEventType() {
        return "PedidoRealizado";
    }

    public String getMesaId() {
        return mesaId;
    }

    public String getPedidoId() {
        return pedidoId;
    }

    public List<String> getItems() {
        return Collections.unmodifiableList(items);
    }

    @Override
    public String toString() {
        return "PedidoRealizadoEvent{" +
                "mesa=" + mesaId +
                ", pedido=" + pedidoId +
                ", items=" + items +
                '}';
    }
}