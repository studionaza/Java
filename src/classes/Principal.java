package classes;

import Interface.Inicial;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JFrame;

public class Principal {

    public static String md5(String senha) {
        String sen = "";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
        sen = hash.toString(16);
        return sen;
    }

    public static void main(String[] args) {
        //Instacia o Formulário Inicial
        Inicial alvo = new Inicial();
        //abrir maximizado
        alvo.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //abrir centralizado
        alvo.setLocationRelativeTo(null);
        //exibe Tela Principal
        alvo.setVisible(true);

        /*  String senha = JOptionPane.showInputDialog("Digite uma senha:");
        String saida = "Entrada: " + senha + "\nSenha com MD5: " + md5(senha);
        JOptionPane.showConfirmDialog(null, saida, "Resultado", JOptionPane.CLOSED_OPTION);
         */
    }
}
