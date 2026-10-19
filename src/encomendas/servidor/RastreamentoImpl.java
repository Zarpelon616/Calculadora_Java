package encomendas.servidor;

import encomendas.comum.Encomenda;
import encomendas.comum.EventoRastreamento;
import encomendas.comum.Rastreamento;

import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;

public class RastreamentoImpl extends UnicastRemoteObject implements Rastreamento {
    private final Map<String, Encomenda> encomendas;

    public RastreamentoImpl() throws RemoteException {
        super();

        encomendas = new HashMap<>();
        carregarDadosIniciais();
    }

    private void carregarDadosIniciais() {
        Encomenda e1 = new Encomenda(
                "BR123456789",
                "Florianópolis/SC",
                "Videira/SC",
                "EM TRÂNSITO"
        );

        e1.adicionarEvento(
                new EventoRastreamento(
                        LocalDateTime.now().minusDays(2),
                        "Florianópolis/SC",
                        "Objeto postado"
                )
        );

        e1.adicionarEvento(
                new EventoRastreamento(
                        LocalDateTime.now().minusDays(1),
                        "Curitibanos/SC",
                        "Objeto em trânsito"
                )
        );

        encomendas.put(e1.getCodigo(), e1);
    }

    @Override
    public Encomenda rastrear(String codigo) throws RemoteException {
        registrarCliente("Consulta da encomenda " + codigo);

        return encomendas.get(codigo);
    }

    @Override
    public boolean atualizarStatus(String codigo, String novoStatus, String local) throws RemoteException {
        registrarCliente("Atualização da encomenda " + codigo);

        Encomenda encomenda = encomendas.get(codigo);
        if (encomenda == null) {
            return false;
        }

        encomenda.setStatus(novoStatus);

        encomenda.adicionarEvento(
                new EventoRastreamento(
                        LocalDateTime.now(),
                        local,
                        novoStatus
                )
        );

        return true;
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