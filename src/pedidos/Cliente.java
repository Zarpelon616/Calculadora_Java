package pedidos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            String ipServidor = (args.length > 0) ? args[0] : "localhost";

            Registry registry = LocateRegistry.getRegistry(ipServidor, 1099);
            PedidoService servico = (PedidoService) registry.lookup("ServicoPedidos");

            Pedido pedido = new Pedido("Mesa 12");

            pedido.adicionarItem(
                    new ItemPedido("X-Salada", 2, 25.00)
            );

            pedido.adicionarItem(
                    new ItemPedido("Refrigerante", 2, 6.00)
            );

            System.out.println("Enviando pedido ao servidor...");

            Pedido resposta = servico.realizarPedido(pedido);

            System.out.println();
            System.out.println("Resposta recebida:");

            System.out.println(resposta);
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}