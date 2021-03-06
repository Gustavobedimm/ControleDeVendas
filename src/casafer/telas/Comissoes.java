/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casafer.telas;

import casafer.DaoNotasVendas;
import casafer.GraficoDeBarra;
import casafer.Pedidos;
import casafer.Vendedores;
import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bedim
 */
public final class Comissoes extends javax.swing.JFrame {

    ArrayList<Pedidos> listaPedidos = new ArrayList();
    ArrayList<Vendedores> listaVendedores = new ArrayList();
    GraficoDeBarra graficoDeBarra = new GraficoDeBarra();
    
    
    public Comissoes() {
        
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/final.png")).getImage());
    }
    public Comissoes(String dataI,String dataF) {
        
        initComponents();
        setaDatas();
        atualizaTela(dataI,dataF);
        
        
        this.setIconImage(new ImageIcon(getClass().getResource("/imagens/final.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComissoes = new javax.swing.JTable();
        jPanelGrafico = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jToolBar1 = new javax.swing.JToolBar();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldDataInicio = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDataFim = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CASAFER - Pedidos Faturados v1.0");
        setMinimumSize(new java.awt.Dimension(575, 446));

        jTableComissoes.setAutoCreateRowSorter(true);
        jTableComissoes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableComissoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vendedor", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableComissoes);
        if (jTableComissoes.getColumnModel().getColumnCount() > 0) {
            jTableComissoes.getColumnModel().getColumn(0).setResizable(false);
            jTableComissoes.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanelGraficoLayout = new javax.swing.GroupLayout(jPanelGrafico);
        jPanelGrafico.setLayout(jPanelGraficoLayout);
        jPanelGraficoLayout.setHorizontalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 508, Short.MAX_VALUE)
        );
        jPanelGraficoLayout.setVerticalGroup(
            jPanelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setRollover(true);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Data inicio :  ");
        jToolBar1.add(jLabel2);

        jTextFieldDataInicio.setEditable(false);
        try {
            jTextFieldDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldDataInicio.setEnabled(false);
        jTextFieldDataInicio.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldDataInicio.setMinimumSize(new java.awt.Dimension(100, 20));
        jTextFieldDataInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataInicioActionPerformed(evt);
            }
        });
        jToolBar1.add(jTextFieldDataInicio);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("  Data fim :  ");
        jToolBar1.add(jLabel3);

        jTextFieldDataFim.setEditable(false);
        try {
            jTextFieldDataFim.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jTextFieldDataFim.setEnabled(false);
        jTextFieldDataFim.setMaximumSize(new java.awt.Dimension(100, 20));
        jTextFieldDataFim.setMinimumSize(new java.awt.Dimension(100, 20));
        jTextFieldDataFim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDataFimActionPerformed(evt);
            }
        });
        jToolBar1.add(jTextFieldDataFim);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/36026_error_pending_warning_hazard_icon.png"))); // NOI18N
        jLabel1.setText("Apenas pedidos que ja foram faturados!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDataInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataInicioActionPerformed

    private void jTextFieldDataFimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDataFimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDataFimActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Comissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comissoes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Comissoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelGrafico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableComissoes;
    private javax.swing.JFormattedTextField jTextFieldDataFim;
    private javax.swing.JFormattedTextField jTextFieldDataInicio;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
    
    public final void atualizaTela(String temp1,String temp2){
        jTextFieldDataInicio.setText(temp1);
        jTextFieldDataFim.setText(temp2);
        DefaultTableModel model = (DefaultTableModel) jTableComissoes.getModel();
        while(model.getRowCount() > 0){
            model.removeRow(0);
        }
        DaoNotasVendas daoNotasVendas = new DaoNotasVendas();
        
        String dataInicio = "";
        String dataFim = "";
        dataInicio = dataInicio + temp1.substring(6, 10);
        dataInicio = dataInicio + temp1.substring(3, 5);
        dataInicio = dataInicio + temp1.substring(0, 2);
        dataFim = dataFim + temp2.substring(6, 10);
        dataFim = dataFim + temp2.substring(3, 5);
        dataFim = dataFim + temp2.substring(0, 2);

        
        //BUSCA VENDEDORES
        try {
            listaVendedores = daoNotasVendas.vendedores();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Comissoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        //BUSCA PEDIDOS
        
        try {
            listaPedidos = daoNotasVendas.todosPedidos(dataInicio, dataFim);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Comissoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Double totalVendedor = 0.0;        
        for(Vendedores vendedor: listaVendedores){
            for(Pedidos pedido: listaPedidos){
                if(vendedor.getVen_Codigo().equals(pedido.getPed_Vendedores())){
                    totalVendedor = totalVendedor + pedido.getPed_Valor();
                }
            }
            String total = formtarDecimal(totalVendedor);
            vendedor.setTotalVendasPeriodo(totalVendedor);
            model.addRow(new Object[]{vendedor.getVen_Nome(),total});        
            total = "";
            totalVendedor = 0.0;
         }
        montaGrafico();
    }
    public final void setaDatas(){
        jTextFieldDataInicio.setText(getDate());
        jTextFieldDataFim.setText(getDate());
    }
    public String getDate() { 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = new Date();
        return sdf.format(date); 
    }
    public static String formtarDecimal(double saldo) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setMaximumFractionDigits(2);
        String teste = df.format(saldo);
        return teste;
    }
    public void montaGrafico(){
        jPanelGrafico.setLayout(new BorderLayout());
        jPanelGrafico.add(graficoDeBarra.criarGrafico(listaVendedores));
        
    }
    }


