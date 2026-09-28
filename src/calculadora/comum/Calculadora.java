package calculadora.comum;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Deve estender Remote
public interface Calculadora extends Remote {
    // Todo método remoto deve lançar RemoteException
    int somar(int a, int b) throws RemoteException;
}