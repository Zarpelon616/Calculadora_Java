package pedidos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private int numero;
    private String cliente;
    private String status;

    private List<ItemPedido> itens;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.status = "NOVO";
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getCliente() { return cliente; }
    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }
    public List<ItemPedido> getItens() { return itens; }

    public double calcularTotal() {
        double total = 0;

        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Pedido nº ")
          .append(numero)
          .append("\n");

        sb.append("Cliente: ")
          .append(cliente)
          .append("\n");

        sb.append("Status: ")
          .append(status)
          .append("\n");

        sb.append("Itens:\n");

        for (ItemPedido item : itens) {
            sb.append("  ")
              .append(item)
              .append("\n");
        }

        sb.append("Total: R$ ")
          .append(calcularTotal());

        return sb.toString();
    }
}