import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClienteSomar {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de A: "));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor de B: "));

        String requisicao = "somar;" + a + ";" + b;

        Socket conexao = new Socket("localhost", 40000);

        ObjectOutputStream saida = new ObjectOutputStream(conexao.getOutputStream());
        ObjectInputStream entrada = new ObjectInputStream(conexao.getInputStream());

        saida.writeObject(requisicao);
        String resposta = (String) entrada.readObject();

        conexao.close();

        String[] parametros = resposta.split(";");
        if(parametros[0].equals("200")){
            JOptionPane.showMessageDialog(null, "Resultado: " + parametros[1]);
        }
        else{
            JOptionPane.showMessageDialog(
                    null,
                    parametros[1],
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

}
