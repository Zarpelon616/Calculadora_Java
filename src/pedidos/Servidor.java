package pedidos;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            String ipServidor = (args.length > 0) ? args[0] : "localhost";
            System.setProperty("java.rmi.server.hostname", ipServidor);

            Registry registry = LocateRegistry.createRegistry(1099);

            PedidoService servico = new PedidoServiceImpl();

            registry.rebind("ServicoPedidos", servico);

            System.out.println("Servidor de pedidos pronto em " + ipServidor);
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}