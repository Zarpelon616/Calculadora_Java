package pedidos;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PedidoService extends Remote {
    Pedido realizarPedido(Pedido pedido) throws RemoteException;
    Pedido consultarPedido(int numero) throws RemoteException;
}