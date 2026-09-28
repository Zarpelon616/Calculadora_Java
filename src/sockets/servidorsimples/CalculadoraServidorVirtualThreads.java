package sockets.servidorsimples;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CalculadoraServidorVirtualThreads {
    private static final int PORTA = 9000;

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
             ServerSocket servidor = new ServerSocket(PORTA)) {

            System.out.println("Servidor rodando na porta " + PORTA);

            while (true) {
                System.out.println("Aguardando conexão...");
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado: " + cliente.getRemoteSocketAddress());

                executor.execute(() -> processarCliente(cliente));
            }
        } catch (IOException e) {
            System.err.println("Erro no servidor: " + e.getMessage());
        }
    }

    private static void processarCliente(Socket cliente) {
        try (Socket socket = cliente;
             DataInputStream entrada = new DataInputStream(socket.getInputStream());
             DataOutputStream saida = new DataOutputStream(socket.getOutputStream())) {

            int num1 = entrada.readInt();
            int num2 = entrada.readInt();
            int resultado = num1 + num2;

            System.out.println("Recebido de " + socket.getRemoteSocketAddress() + ": " + num1 + " + " + num2);
            saida.writeInt(resultado);
            saida.flush();
            System.out.println("Resultado enviado: " + resultado);
        } catch (IOException e) {
            System.err.println("Erro ao processar cliente: " + e.getMessage());
        }
    }
}