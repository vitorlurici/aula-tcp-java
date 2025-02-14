import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Logger logger = Logger.getLogger(Servidor.class.getName());

        logger.info("Iniciando o servidor!");
        ServerSocket servidor = new ServerSocket(40000);
        logger.info("Servidor iniciado com sucesso!");

        logger.info("Aceitando conexões!");
        Socket conexao = servidor.accept();
        logger.info("Conexão aceita com sucesso!");

        logger.info("Criando o fluxo de saída");
        ObjectOutputStream saida =
                new ObjectOutputStream(conexao.getOutputStream());
        logger.info("Fluxo de saída criado com sucesso!");

        logger.info("Criando o fluxo de entrada");
        ObjectInputStream entrada =
                new ObjectInputStream(conexao.getInputStream());
        logger.info("Fluxo de entrada criado com sucesso!");

        logger.info("Recebendo uma requisição!");
        String requisicao = (String) entrada.readObject();
        logger.info("Requisição recebida com sucesso: " + requisicao + "!");
    }
}
