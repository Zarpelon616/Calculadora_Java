package pedidos;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PedidoServiceImpl extends UnicastRemoteObject implements PedidoService {
    private final Map<Integer, Pedido> pedidos;
    private final AtomicInteger proximoNumero;

    public PedidoServiceImpl() throws RemoteException {
        super();

        pedidos = new HashMap<>();
        proximoNumero = new AtomicInteger(1000);
    }

    @Override
    public Pedido realizarPedido(Pedido pedido) throws RemoteException {
        int numero = proximoNumero.incrementAndGet();

        pedido.setNumero(numero);
        pedido.setStatus("RECEBIDO");

        pedidos.put(numero, pedido);

        registrarCliente("Novo pedido recebido: " + numero);
        System.out.println(pedido);

        return pedido;
    }

    @Override
    public Pedido consultarPedido(int numero) throws RemoteException {
        registrarCliente("Consulta do pedido " + numero);

        return pedidos.get(numero);
    }

    private void registrarCliente(String operacao) {
        try {
            String ipCliente = RemoteServer.getClientHost();
            System.out.println("[" + ipCliente + "] " + operacao);
        } catch (ServerNotActiveException e) {
            System.out.println("[Local] " + operacao);
        }
    }
}