import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventBus {
    private final Map<String, List<EventSubscriber>> suscriptores;

    public EventBus() {
        this.suscriptores = new ConcurrentHashMap<>();
    }

    public void suscribir(String tipoDeEvento, EventSubscriber suscriptor) {
        suscriptores.computeIfAbsent(tipoDeEvento, k -> new CopyOnWriteArrayList<>())
                .add(suscriptor);
        System.out.println("[EventBus] Suscriptor registrado para: " + tipoDeEvento);
    }

    public void desuscribir(String tipoDeEvento, EventSubscriber suscriptor) {
        List<EventSubscriber> lista = suscriptores.get(tipoDeEvento);
        if (lista != null) {
            lista.remove(suscriptor);
            System.out.println("[EventBus] Suscriptor removido de: " + tipoDeEvento);
        }
    }

    public void publicar(Event evento) {
        String tipoDeEvento = evento.getEventType();
        System.out.println("\n[EventBus] 📢 Publicando evento: " + tipoDeEvento);

        List<EventSubscriber> lista = suscriptores.get(tipoDeEvento);
        if (lista != null && !lista.isEmpty()) {
            for (EventSubscriber suscriptor : lista) {
                try {
                    suscriptor.onEvent(evento);
                } catch (Exception e) {
                    System.err.println("[EventBus] Error al notificar suscriptor: " + e.getMessage());
                }
            }
        } else {
            System.out.println("[EventBus] No hay suscriptores para: " + tipoDeEvento);
        }
    }
}