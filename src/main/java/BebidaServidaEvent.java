public class BebidaServidaEvent extends Event {
    private final String mesaId;
    private final String bebida;

    public BebidaServidaEvent(String mesaId, String bebida) {
        super();
        this.mesaId = mesaId;
        this.bebida = bebida;
    }

    @Override
    public String getEventType() {
        return "BebidaServida";
    }

    public String getMesaId() {
        return mesaId;
    }

    public String getBebida() {
        return bebida;
    }

    @Override
    public String toString() {
        return "BebidaServidaEvent{" +
                "mesa=" + mesaId +
                ", bebida=" + bebida +
                '}';
    }
}