package encomendas.servidor;

import encomendas.comum.Rastreamento;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            String ipServidor = (args.length > 0) ? args[0] : "localhost";
            System.setProperty("java.rmi.server.hostname", ipServidor);

            Registry registry = LocateRegistry.createRegistry(1099);

            Rastreamento servico = new RastreamentoImpl();
            registry.rebind("ServicoRastreamento", servico);

            System.out.println("Servidor de rastreamento pronto em "+ ipServidor);
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}