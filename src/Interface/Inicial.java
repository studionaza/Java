package Interface;

import classes.Pacientes;
import java.awt.Color;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class Inicial extends JFrame {

    static String OperadorAtual;
    static Pacientes Pacientes;
    static CadastroPacientes CadastroPacientes;
    static InserirPaciente InserirPaciente;
    static AtualizarPaciente AtualizarPaciente;

    //hora certa e hora atual do sistema
    public class Relogio extends TimerTask {

        JLabel label;
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy 'Hora Certa' HH:mm:ss");

        public Relogio(JLabel label) {
            this.label = label;
        }

        public void run() {
            label.setText(sdf.format(new Date()));

        }
    }

    static void LancaOperador() {

        OperadorAtual = jlOperador.getText();
    }

    static void verificaTelas() {

        jPainel_Principal.setVisible(false);
        jPainel_Principal.removeAll();
        jPainel_Principal.setVisible(true);

        if (CadastroPacientes != null) {
            CadastroPacientes.setVisible(false);
            jPainel_Principal.remove(CadastroPacientes);
            CadastroPacientes.dispose();
            CadastroPacientes = null;
        }

        if (InserirPaciente != null) {
            InserirPaciente.setVisible(false);
            jPainel_Principal.remove(InserirPaciente);
            InserirPaciente.dispose();
            InserirPaciente = null;
        }

        if (AtualizarPaciente != null) {
            AtualizarPaciente.setVisible(false);
            jPainel_Principal.remove(AtualizarPaciente);
            AtualizarPaciente.dispose();
            AtualizarPaciente = null;
        }

    }

    public Inicial() {
        initComponents();
        //inicia Maximizado

        Timer t = new Timer();

        t.scheduleAtFixedRate(new Relogio(jlHora), 0, 1000);

        //  this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //VERMELHO
        UIManager.put("nimbusBase", new Color(140, 42, 42));
        UIManager.put("nimbusBlueGrey", new Color(190, 167, 167));
        UIManager.put("control", new Color(223, 215, 214));

//        jbt1.setBackground(new Color(140, 42, 42));
        //LARANJA
        /*UIManager.put( "nimbusBase", new Color( 140, 103, 59 ) );
        UIManager.put( "nimbusBlueGrey", new Color( 190, 189, 170 ) );
        UIManager.put( "control", new Color( 221, 223, 212 ) );
         */
        //CINZA
        /*UIManager.put( "nimbusBase", new Color( 81, 81, 81 ) );
        UIManager.put( "nimbusBlueGrey", new Color( 190, 190, 190 ) );
        UIManager.put( "control", new Color( 223, 223, 223 ) );
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainel_Principal = new javax.swing.JDesktopPane();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btCadastro = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jlHora = new javax.swing.JLabel();
        jlOperador = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("WeDoAll");
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setName("frmPrincipal"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPainel_Principal.setAlignmentX(0.0F);
        jPainel_Principal.setAlignmentY(0.0F);
        jPainel_Principal.setMaximumSize(new java.awt.Dimension(1360, 760));
        jPainel_Principal.setPreferredSize(new java.awt.Dimension(1360, 760));

        javax.swing.GroupLayout jPainel_PrincipalLayout = new javax.swing.GroupLayout(jPainel_Principal);
        jPainel_Principal.setLayout(jPainel_PrincipalLayout);
        jPainel_PrincipalLayout.setHorizontalGroup(
            jPainel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        jPainel_PrincipalLayout.setVerticalGroup(
            jPainel_PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.add(jSeparator1);

        btCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/relatorio.png"))); // NOI18N
        btCadastro.setText("SQL");
        btCadastro.setFocusable(false);
        btCadastro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btCadastro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastroActionPerformed(evt);
            }
        });
        jToolBar1.add(btCadastro);

        jlHora.setText("segunda-feira, 26 de junho de 2017 - Hora: 00:00:00");

        jlOperador.setText("ELIANE COSTA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlHora, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlOperador))
                .addContainerGap(919, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlHora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlOperador)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jToolBar1.add(jPanel1);

        jMenu4.setText("Arquivo");

        jMenuItem12.setText("Sair");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem12);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPainel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPainel_Principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(1342, 572));
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        this.setTitle("Teste SQL");

    }//GEN-LAST:event_formWindowOpened

    private void btCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastroActionPerformed

        verificaTelas();
        if (CadastroPacientes == null) {
            CadastroPacientes = new CadastroPacientes();
            try {

                jPainel_Principal.add(CadastroPacientes);
                CadastroPacientes.setSelected(true);
                CadastroPacientes.setFrameIcon(new ImageIcon(this.getClass().getResource("/imagens/OperadoresIcone.png")));
                CadastroPacientes.setTitle("Cadastro de Pacientes SQL - ");
                CadastroPacientes.setPosicao();
                CadastroPacientes.setVisible(true);

                // Maximizar jInternalFrame
                try {
                    CadastroPacientes.setMaximum(true);
                } catch (PropertyVetoException ex) {
                    Logger.getLogger(Inicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                //fim da Maximização

            } catch (java.beans.PropertyVetoException e) {
            }
        }

    }//GEN-LAST:event_btCadastroActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        System.exit(0);

    }//GEN-LAST:event_jMenuItem12ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Inicial().setVisible(true);

            }

        }
        );

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastro;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem12;
    public static javax.swing.JDesktopPane jPainel_Principal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private static javax.swing.JLabel jlHora;
    public static javax.swing.JLabel jlOperador;
    // End of variables declaration//GEN-END:variables
}
