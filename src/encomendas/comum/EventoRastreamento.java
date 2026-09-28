package encomendas.comum;

import java.io.Serializable;
import java.time.LocalDateTime;

public class EventoRastreamento implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDateTime dataHora;
    private String local;
    private String status;

    public EventoRastreamento(
            LocalDateTime dataHora,
            String local,
            String status) {

        this.dataHora = dataHora;
        this.local = local;
        this.status = status;
    }

    public LocalDateTime getDataHora() { return dataHora; }
    public String getLocal() { return local; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return dataHora + " - " + local + " - " + status;
    }
}