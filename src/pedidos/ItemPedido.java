package pedidos;

import java.io.Serializable;

public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;

    private String produto;
    private int quantidade;
    private double valorUnitario;

    public ItemPedido(String produto, int quantidade, double valorUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public String getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }

    public double getValorUnitario() { return valorUnitario; }

    public double getSubtotal() {
        return quantidade * valorUnitario;
    }

    @Override
    public String toString() {
        return produto + " - " + quantidade + " x R$ " + valorUnitario + " = R$ " + getSubtotal();
    }
}