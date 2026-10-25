package calculadora.servidor;

import calculadora.comum.Calculadora;
import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImpl extends UnicastRemoteObject implements Calculadora {
    public CalculadoraImpl() throws RemoteException {
        super(1099);
    }

    @Override
    public int somar(int a, int b) throws RemoteException {
        try {
            // Captura o IP ou Hostname do calculadora.cliente que chamou este método
            String ipCliente = RemoteServer.getClientHost();
            System.out.println("[" + ipCliente + "] Pedido de soma recebido: " + a + " + " + b);
        } catch (ServerNotActiveException e) {
            // Caso o método seja chamado localmente (fora do RMI), cai aqui
            System.out.println("[Local] Pedido de soma recebido: " + a + " + " + b);
        }

        return a + b;
    }
    @Override
    public int subtrair(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiplicar(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double dividir(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new ArithmeticException("Divisão por zero não permitida.");
        }

        return (double) a / b;
    }
}
