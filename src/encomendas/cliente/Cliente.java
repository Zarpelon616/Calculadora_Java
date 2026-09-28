package encomendas.cliente;

import encomendas.comum.Encomenda;
import encomendas.comum.Rastreamento;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            String ipServidor = (args.length > 0) ? args[0] : "localhost";

            Registry registry = LocateRegistry.getRegistry(ipServidor,1099);
            Rastreamento servico = (Rastreamento) registry.lookup("ServicoRastreamento");

            String codigo = "BR123456789";
            Encomenda encomenda = servico.rastrear(codigo);

            if (encomenda != null) {
                System.out.println("Encomenda encontrada:");
                System.out.println(encomenda);
            } else {
                System.out.println("Encomenda não encontrada.");
            }
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}