package encomendas.comum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Encomenda implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String origem;
    private String destino;
    private String status;

    private List<EventoRastreamento> historico;

    public Encomenda(String codigo, String origem, String destino, String status) {
        this.codigo = codigo;
        this.origem = origem;
        this.destino = destino;
        this.status = status;
        this.historico = new ArrayList<>();
    }

    public String getCodigo() { return codigo; }
    public String getOrigem() { return origem; }
    public String getDestino() { return destino; }
    public String getStatus() { return status; }
    public List<EventoRastreamento> getHistorico() { return historico; }

    public void setStatus(String status) { this.status = status; }

    public void adicionarEvento(EventoRastreamento evento) {
        historico.add(evento);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Código: ")
                .append(codigo)
                .append("\n");

        sb.append("Origem: ")
                .append(origem)
                .append("\n");

        sb.append("Destino: ")
                .append(destino)
                .append("\n");

        sb.append("Status atual: ")
                .append(status)
                .append("\n");

        sb.append("Histórico:\n");

        for (EventoRastreamento evento : historico) {
            sb.append("  ")
                    .append(evento)
                    .append("\n");
        }

        return sb.toString();
    }
}