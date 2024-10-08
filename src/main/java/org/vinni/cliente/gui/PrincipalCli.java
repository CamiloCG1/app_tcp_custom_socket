package org.vinni.cliente.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * author: Vinni 2024
 */
public class PrincipalCli extends javax.swing.JFrame {

    private final int PORT = 12345;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private List<String> comboBoxItems = new ArrayList<>();

    /**
     * Creates new form Principal1
     */
    public PrincipalCli() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        this.setTitle("Cliente ");
        bConectar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensajesTxt = new javax.swing.JTextArea();
        mensajeTxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btEnviar = new javax.swing.JButton();
        nickname = new javax.swing.JTextField();
        checkBox1 = new JCheckBox();
        checkBox2 = new JCheckBox();
        comboBox = new JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        bConectar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bConectar.setText("Conectar Server");
        bConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConectarActionPerformed(evt);
            }
        });
        getContentPane().add(bConectar);
        bConectar.setBounds(250, 40, 190, 35);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("CLIENTE: No Connection");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 10, 250, 17);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 410, 110);

        mensajeTxt.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(mensajeTxt);
        mensajeTxt.setBounds(20, 120, 350, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Nickname:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 40, 120, 30);

        nickname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nickname.setBounds(100, 40, 120, 35);
        getContentPane().add(nickname);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Mensaje:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 90, 120, 30);

        checkBox1.setText("Enviar a todos");
        checkBox1.setBounds(20, 170, 125, 30);
        checkBox1.setSelected(true);
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                handleCheckBoxSelection(checkBox1, checkBox2);
            }
        });
        getContentPane().add(checkBox1);

        checkBox2.setText("Enviar a: ");
        checkBox2.setBounds(145, 170, 100, 30);
        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleCheckBoxSelection(checkBox2, checkBox1);
            }
        });
        getContentPane().add(checkBox2);

        comboBox.setModel(new DefaultComboBoxModel<>(comboBoxItems.toArray(new String[0])));
        comboBox.setBounds(230, 170, 150, 30);
        comboBox.setEnabled(false);
        getContentPane().add(comboBox);

        btEnviar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btEnviar);
        btEnviar.setBounds(180, 220, 120, 27);
        btEnviar.setEnabled(false);

        mensajesTxt.setColumns(20);
        mensajesTxt.setRows(5);
        mensajesTxt.setEnabled(false);

        jScrollPane1.setViewportView(mensajesTxt);
        jScrollPane1.setBounds(20, 270, 450, 200);

        setSize(new java.awt.Dimension(491, 550));
        setLocationRelativeTo(null);
        handleCheckBoxChange();
    }// </editor-fold>

    private void bConectarActionPerformed(java.awt.event.ActionEvent evt) {
        conectar();
    }
    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {
        this.enviarMensaje();
    }
    private void handleCheckBoxSelection(JCheckBox selected, JCheckBox other) {
        if (selected.isSelected()) {
            other.setSelected(false);
        }
        handleCheckBoxChange();
    }
    private void handleCheckBoxChange() {
        if (checkBox2.isSelected()) {
            comboBox.setEnabled(true);
        } else {
            comboBox.setEnabled(false);
        }
    }
    private void updateComboBox(String[] clients) {
        comboBox.removeAllItems();
        for (String item : clients) {
            comboBox.addItem(item);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton bConectar;
    private javax.swing.JButton btEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mensajesTxt;
    private JTextField mensajeTxt;
    private JTextField nickname;
    private JCheckBox checkBox1;
    private JCheckBox checkBox2;
    private JComboBox<String> comboBox;
    // End of variables declaration

    private void conectar() {
        try {
            if (nickname.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Se requiere un nickname.");
                return;
            }
            if (socket == null || socket.isClosed()) {
                socket = new Socket("localhost", PORT);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            }
            jLabel1.setText("CLIENTE: " + nickname.getText());
            nickname.setEnabled(false);
            btEnviar.setEnabled(true);
            bConectar.setEnabled(false);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        String fromServer;
                        while ((fromServer = in.readLine()) != null) {
                            String[] parts = fromServer.split("\\&");
                            if (parts.length > 0) {
                                switch (parts[0]) {
                                    case "clients":
                                        String[] socketsClients = parts[1].split("\\,");
                                        updateComboBox(socketsClients);
                                        break;
                                    default:
                                        mensajesTxt.append(fromServer + "\n");
                                }
                            }
                        }
                    } catch (IOException ex) {
                        System.err.println("Conexión cerrada o error de IO: " + ex.getMessage());
                    } finally {
                        jLabel1.setText("CLIENTE: " + nickname.getText() + " (No Connection)");
                        bConectar.setEnabled(true);
                        btEnviar.setEnabled(false);
                        comboBox.removeAllItems();
                        checkBox1.setSelected(true);
                        checkBox2.setSelected(false);
                        handleCheckBoxChange();

                        cerrar();
                    }
                }
            }).start();
            out.println(nickname.getText());
            out.println("clients");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this, "Error. Intente nuevamente.");
            ex.printStackTrace();
        }
    }
    private void enviarMensaje() {
        if (mensajeTxt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un mensaje");
            return;
        }
        if (validateClientsToNotify().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecciona a quien enviar el mensaje");
            return;
        }
        out.println(validateClientsToNotify() + "&" + mensajeTxt.getText());
        mensajeTxt.setText("");
    }

    private String validateClientsToNotify() {
        if (checkBox1.isSelected()) {
            return "all";
        }

        if (checkBox2.isSelected()) {
            Object selectedItem = comboBox.getSelectedItem();
            String value = selectedItem != null ? (String) selectedItem : "";
            return "custom&"+ value;
        }

        return "";
    }

    private void cerrar() {
        try {
            if (in != null) {
                in.close();
            }
            if (out != null) {
                out.close();
            }
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
