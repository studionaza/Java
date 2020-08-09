package Interface;

import classes.PacientesDao;
import javax.swing.table.DefaultTableModel;

public class AtualizarPaciente extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    classes.Pacientes Pacientes;
    private int linhaSelecionada;
    classes.Pacientes pacientes;
//    private int codigo;
    //  private int linha;

    public AtualizarPaciente(DefaultTableModel md, int id, int linha) {

        initComponents();
        // DefaultTableModel md = new DefaultTableModel();

        modelo = md;

        PacientesDao dao = new PacientesDao();
        Pacientes = dao.getContatoById(id);

        txId.setText(Integer.toString(Pacientes.getCodigo()));
        txNome.setText(Pacientes.getPaciente());
        txTelefone.setText(Pacientes.getCpf());
        txEmail.setText(Pacientes.getEmail());
        linhaSelecionada = linha;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btSalvar = new javax.swing.JButton();
        txNome = new javax.swing.JTextField();
        txTelefone = new javax.swing.JTextField();
        txEmail = new javax.swing.JTextField();
        txId = new javax.swing.JTextField();

        getContentPane().setLayout(null);

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btSalvar);
        btSalvar.setBounds(191, 228, 63, 23);
        getContentPane().add(txNome);
        txNome.setBounds(147, 66, 185, 20);
        getContentPane().add(txTelefone);
        txTelefone.setBounds(147, 117, 185, 20);
        getContentPane().add(txEmail);
        txEmail.setBounds(147, 171, 185, 20);
        getContentPane().add(txId);
        txId.setBounds(147, 15, 185, 20);

        setBounds(0, 0, 470, 369);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        classes.Pacientes c = new classes.Pacientes();
        c.setCodigo(Integer.parseInt(txId.getText()));
        c.setPaciente(txNome.getText());
        c.setCelular(txTelefone.getText());
        c.setEmail(txEmail.getText());

        PacientesDao dao = new PacientesDao();
        dao.atualizar(c);
        modelo.removeRow(linhaSelecionada);
        modelo.addRow(new Object[]{c.getCodigo(), c.getPaciente(), c.getCpf(), c.getEmail()});
        setVisible(false);
    }//GEN-LAST:event_btSalvarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField txEmail;
    private javax.swing.JTextField txId;
    private javax.swing.JTextField txNome;
    private javax.swing.JTextField txTelefone;
    // End of variables declaration//GEN-END:variables
}
