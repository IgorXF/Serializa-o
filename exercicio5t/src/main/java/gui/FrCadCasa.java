package gui;

import classes.Casa;
import gerenciador.GerenciadorCasa;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author igorxf
 */
public class FrCadCasa extends javax.swing.JFrame {

    private boolean editando;
    private String idAntigo;
    private GerenciadorCasa gerenciador;

    public FrCadCasa() throws FileNotFoundException {
        this.editando = false;
        this.idAntigo = "";
        this.gerenciador = new GerenciadorCasa();
        initComponents();
        this.limparCampos();
        this.habilitarCampos(false);
        
        gerenciador.carregarDoArquivo("ListagemCasas.csv");
        edtListagem.setText(gerenciador.toString());
    }

    public void habilitarCampos(boolean flag) {
        edtId.setEnabled(flag);
        edtBanheiros.setEnabled(flag);
        edtTipo.setEnabled(flag);
        edtPreco.setEnabled(flag);
        edtQuartos.setEnabled(flag);
        edtArea.setEnabled(flag);
    }

    public void limparCampos() {
        edtId.setText("");
        edtBanheiros.setText("");
        edtTipo.setText("");
        edtPreco.setText("");
        edtQuartos.setText("");
        edtArea.setText("");
    }

    public void objetoParaCampos(Casa a) {
        edtId.setText(a.getId());
        edtTipo.setText(a.getTipo());
        edtQuartos.setText(a.getQuartos() + "");
        edtBanheiros.setText(a.getBanheiros() + "");
        edtPreco.setText(a.getPreco() + "");
        edtArea.setText(a.getArea() + "");
    }

    public Casa camposParaObjeto() {
        Casa a = new Casa();
        a.setId(edtId.getText());
        a.setTipo(edtTipo.getText());
        
        String banheiro = edtBanheiros.getText();
        int b = 0;
        if (!banheiro.isEmpty()) {
            b = Integer.parseInt(banheiro);
        }
        a.setBanheiros(b);
        
        String quartos = edtQuartos.getText();
        int c = 0;
        if (!quartos.isEmpty()) {
            c = Integer.parseInt(quartos);
        }
        a.setQuartos(c);
        
        String area = edtArea.getText();
        double e = 0.0;
        if (!area.isEmpty()) {
            e = Double.parseDouble(area);
        }
        a.setArea(e);
        
        String preco = edtPreco.getText();
        double d = 0.0;
        if (!preco.isEmpty()) {
            d = Double.parseDouble(preco);
        }
        a.setPreco(d);
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        penBotoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        bntSalvar = new javax.swing.JButton();
        penAtributos = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblBanheiros = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblQuartos = new javax.swing.JLabel();
        edtId = new javax.swing.JTextField();
        edtBanheiros = new javax.swing.JTextField();
        edtPreco = new javax.swing.JTextField();
        edtQuartos = new javax.swing.JTextField();
        edtTipo = new javax.swing.JTextField();
        lblArea = new javax.swing.JLabel();
        edtArea = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        edtListagem = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Noto Sans Light", 1, 24)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Cadastro de Carro");

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/novo_32x32.png"))); // NOI18N
        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        penBotoes.add(btnNovo);

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit3_32x32.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        penBotoes.add(btnEditar);

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel_32x32.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        penBotoes.add(btnCancelar);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/del_32x32.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        penBotoes.add(btnExcluir);

        bntSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_32x32.png"))); // NOI18N
        bntSalvar.setText("Salvar");
        bntSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntSalvarActionPerformed(evt);
            }
        });
        penBotoes.add(bntSalvar);

        lblId.setText("Id:");

        lblBanheiros.setText("Banheiros:");

        lblTipo.setText("Tipo:");

        lblPreco.setText("Preço:");

        lblQuartos.setText("Quartos:");

        edtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtIdActionPerformed(evt);
            }
        });

        edtPreco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtPrecoActionPerformed(evt);
            }
        });

        edtQuartos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edtQuartosActionPerformed(evt);
            }
        });

        lblArea.setText("Área:");

        javax.swing.GroupLayout penAtributosLayout = new javax.swing.GroupLayout(penAtributos);
        penAtributos.setLayout(penAtributosLayout);
        penAtributosLayout.setHorizontalGroup(
            penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penAtributosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penAtributosLayout.createSequentialGroup()
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtId)
                        .addGap(13, 13, 13))
                    .addGroup(penAtributosLayout.createSequentialGroup()
                        .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblQuartos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(penAtributosLayout.createSequentialGroup()
                                .addComponent(edtTipo)
                                .addGap(3, 3, 3))
                            .addComponent(edtQuartos))))
                .addGap(144, 144, 144)
                .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(penAtributosLayout.createSequentialGroup()
                        .addComponent(lblArea)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(edtArea)
                        .addGap(145, 145, 145))
                    .addGroup(penAtributosLayout.createSequentialGroup()
                        .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBanheiros, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(penAtributosLayout.createSequentialGroup()
                                .addComponent(edtPreco)
                                .addGap(145, 145, 145))
                            .addGroup(penAtributosLayout.createSequentialGroup()
                                .addComponent(edtBanheiros)
                                .addContainerGap())))))
        );
        penAtributosLayout.setVerticalGroup(
            penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(penAtributosLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(lblBanheiros)
                    .addComponent(edtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edtBanheiros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipo)
                    .addComponent(edtTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblArea)
                    .addComponent(edtArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(penAtributosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuartos)
                    .addComponent(edtQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco)
                    .addComponent(edtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        edtListagem.setColumns(20);
        edtListagem.setRows(5);
        jScrollPane1.setViewportView(edtListagem);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(penBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(penAtributos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(penBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(penAtributos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void edtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtIdActionPerformed

    private void edtPrecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtPrecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtPrecoActionPerformed

    private void edtQuartosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edtQuartosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edtQuartosActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.habilitarCampos(true);
        this.limparCampos();
        this.editando = false;

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String idEscolhido = JOptionPane.showInputDialog("Informe o Id da Casa que deseja EDITAR:", "");

        Casa casaEditando = gerenciador.buscarCasa(idEscolhido);

        if (casaEditando == null) {
            JOptionPane.showMessageDialog(this, "Não existe este casa.");
            this.editando = false;
        } else {
            this.limparCampos();
            this.habilitarCampos(true);

            this.objetoParaCampos(casaEditando);
            this.editando = true;
            this.idAntigo = casaEditando.getId();
        }

    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String idEscolhido = JOptionPane.showInputDialog("Informe o Id da casa que deseja excluir:", "");

        Casa a = gerenciador.buscarCasa(idEscolhido);

        if (a == null) {
            JOptionPane.showMessageDialog(this, "Não existe esta Casa.");
        } else {
            gerenciador.removerCasa(idEscolhido);
            JOptionPane.showMessageDialog(this, "Exclusão feita com sucesso!");
        }
        
        String listagem = gerenciador.toString();
        edtListagem.setText(listagem);

    }//GEN-LAST:event_btnExcluirActionPerformed

    private void bntSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntSalvarActionPerformed
        Casa a = this.camposParaObjeto();


        if(this.editando){
            gerenciador.atualizarCasa(idAntigo, a);
        }else{
            gerenciador.adicionarCasa(a);
        }

        
        //No final reset a tela
        this.limparCampos();
        this.habilitarCampos(false);
        this.editando = false;

        String listagem = gerenciador.toString();
        edtListagem.setText(listagem);
        
        try {
            gerenciador.salvarNoArquivo("ListagemCasas.csv");
        } catch (IOException ex) {
            Logger.getLogger(FrCadCasa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.limparCampos();
        this.habilitarCampos(false);
        this.editando = false;

    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntSalvar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JTextField edtArea;
    private javax.swing.JTextField edtBanheiros;
    private javax.swing.JTextField edtId;
    private javax.swing.JTextArea edtListagem;
    private javax.swing.JTextField edtPreco;
    private javax.swing.JTextField edtQuartos;
    private javax.swing.JTextField edtTipo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblBanheiros;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQuartos;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel penAtributos;
    private javax.swing.JPanel penBotoes;
    // End of variables declaration//GEN-END:variables

}