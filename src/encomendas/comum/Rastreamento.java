package encomendas.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Rastreamento extends Remote {
    Encomenda rastrear(String codigo) throws RemoteException;

    boolean atualizarStatus(
            String codigo,
            String novoStatus,
            String local)
            throws RemoteException;
}