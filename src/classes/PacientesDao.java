package classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacientesDao {

    private final String INSERT = "INSERT INTO pacientes (paciente, celular, email) VALUES (?,?,?)";
    private final String UPDATE = "UPDATE pacientes SET paciente=?, celular=?, email=? WHERE codigo=?";
    private final String DELETE = "DELETE FROM pacientes WHERE codigo =?";
    private final String LIST = "SELECT * FROM pacientes";
    private final String LISTBYID = "SELECT * FROM pacientes WHERE codigo=?";

    public void atualizar(Pacientes pacientes) {
        if (pacientes != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm;
                pstm = conn.prepareStatement(UPDATE);
                // pstm = conn.prepareStatement("UPDATE pacientes SET operador='PAULO MARCOS', celular='(85) 8888.6666', email='emaildopaouleo@hotm.com' WHERE codigo=2");

                pstm.setString(1, pacientes.getPaciente());
                pstm.setString(2, pacientes.getCpf());
                pstm.setString(3, pacientes.getEmail());
                pstm.setInt(4, pacientes.getCodigo());

                pstm.execute();
                JOptionPane.showMessageDialog(null, "Contato alterado com sucesso");
                FabricaConexao.fechaConexao(conn);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar pacientes no banco de "
                        + "dados " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "O pacientes enviado por parâmetro está vazio");
        }

    }

    public void inserir(Pacientes Pacientes) {
        if (Pacientes != null) {
            Connection conn = null;
            try {
                conn = FabricaConexao.getConexao();
                PreparedStatement pstm;

                pstm = conn.prepareStatement(INSERT);

                pstm.setString(1, Pacientes.getPaciente());
                pstm.setString(2, Pacientes.getCpf());
                pstm.setString(3, Pacientes.getEmail());

                pstm.execute();
                JOptionPane.showMessageDialog(null, "Contato cadastrado com sucesso");
                FabricaConexao.fechaConexao(conn, pstm);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir pacientes no banco de"
                        + "dados " + e.getMessage());
            }
        } else {
            System.out.println("O pacientes enviado por parâmetro está vazio");
        }
    }

    public void remover(int codigo) {
        Connection conn = null;
        try {
            conn = FabricaConexao.getConexao();
            PreparedStatement pstm;
            pstm = conn.prepareStatement(DELETE);

            pstm.setInt(1, codigo);

            pstm.execute();
            FabricaConexao.fechaConexao(conn, pstm);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir paciente do banco de"
                    + "dados " + e.getMessage());
        }
    }

    public List<Pacientes> getContatos() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Pacientes> contatos = new ArrayList<Pacientes>();
        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pacientes Pacientes = new Pacientes();

                Pacientes.setCodigo(rs.getInt("codigo"));
                Pacientes.setPaciente(rs.getString("paciente"));
                Pacientes.setCelular(rs.getString("cpf"));
                Pacientes.setEmail(rs.getString("email"));
                contatos.add(Pacientes);
            }
            FabricaConexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro3 ao listar pacientes" + e.getMessage());
        }
        return contatos;
    }

    public Pacientes getContatoById(int id) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Pacientes Pacientes = new Pacientes();
        try {
            conn = FabricaConexao.getConexao();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Pacientes.setCodigo(rs.getInt("codigo"));
                Pacientes.setPaciente(rs.getString("paciente"));
                Pacientes.setCelular(rs.getString("celular"));
                Pacientes.setEmail(rs.getString("email"));
            }
            FabricaConexao.fechaConexao(conn, pstm, rs);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro4 ao listar contatos" + e.getMessage());
        }
        return Pacientes;
    }
}
