package calculadora.cliente;

import calculadora.comum.Calculadora; // <- Importa a interface
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            String ipServidor = (args.length > 0) ? args[0] : "localhost";
            System.out.println("Conectando ao calculadora.servidor em: " + ipServidor);

            Registry registry = LocateRegistry.getRegistry(ipServidor, 1099);
            Calculadora calc = (Calculadora) registry.lookup("ServicoCalculadora");

            System.out.println("Soma: " + calc.somar(15, 25));
            System.out.println("Subtração: " + calc.subtrair(25, 10));
            System.out.println("Multiplicação: " + calc.multiplicar(5, 6));
            System.out.println("Divisão: " + calc.dividir(5, 2));
        } catch (Exception e) {
            System.err.println("Erro no calculadora.cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
