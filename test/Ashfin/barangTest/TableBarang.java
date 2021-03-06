/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ashfin.barangTest;

import java.text.SimpleDateFormat ;
import java.util.* ;
import javax.swing.JOptionPane ;
import javax.swing.table.DefaultTableModel ;
import Ashfin.barang.* ;
import javax.swing.DefaultComboBoxModel ;

public class TableBarang extends javax.swing.JFrame {
//untuk kode transaksi
    private int id = 0 ;
    //untuk kode transaksi
    private String code ;
    // Jtable
    private DefaultTableModel tbModel ;
    // Jcombobox
    private DefaultComboBoxModel cbModel ;
    //untuk menampilkan transaksi item
    private ArrayList<Item> belanja = new ArrayList<>() ;
    
    
    public TableBarang() {
        Barang comboModel = new Barang () ;
        this.cbModel = new DefaultComboBoxModel<>(comboModel.getNames().toArray()) ; 
        
        TableItems tableModel = new TableItems () ;
         //tabel kolom nama
        this.tbModel = new DefaultTableModel (tableModel.getKolomNama() , 0)  ;
        
        initComponents();
    }
    
    //untuk menambahkan id
    private void tmbhId(){
        this.id += 1;
    }
    
    //pengurangan id
    private void krgId(){
        this.id -= 1;
    }
    
    //fungsi code
    private String setKode(){
        this.tmbhId();
        //untuk waktunya
        String kd = new SimpleDateFormat ("yyMMdd").format(new Date());
        this.code = String.format(kd + "%02d",this.id);
        return code;
    }
    
    private Object[] addItem(String name, int jumlah){
        float harga= 0;
        Barang items = new Barang();
        for(int i = 0; i<items.getPrices().size();
                i++){
            if(name.equalsIgnoreCase(items.getNames().get(i))){
                harga = items.getPrices().get(i);
            }
        }
        Object[] obj = {
            name,
            harga,
            jumlah
        };
        return obj;
    }
    
    
    //update jumlah barang
    private void updateJumlah(String name, int add){
        ArrayList<String> item = new ArrayList<>();
        
        for(int i = 0; i < tbModel.getRowCount();
                i++){
            item.add(tbModel.getValueAt(i, 0).toString());
        }
        
        for(int i=0; i<item.size();
                i++){
            if(item.get(i).equals(name)){
                int jumlah = new Integer(tbModel.getValueAt(i, 2).toString());
                tbModel.setValueAt(jumlah+add, i, 2);
            }
        }
    }
    
    //mengecek apabila membeli 2 item yang sama
    private boolean doble(String name){
        boolean result = false;
        ArrayList<String>item = new ArrayList<>();
        for(int i = 0; i<tbModel.getRowCount();
                i++){
            item.add (tbModel.getValueAt(i,0).toString());
        }
        for(String i : item){
            if(i.equals(name)){
                result = true;
            }
        }
        return result;
    }
    
    //mengecek apabila tabel masih kosong
    private boolean isEmpty(){
        if(jTable1.getRowCount()<0){
            return true;
        }else{
            return false;
        }
        
    }
    
    //setEnable/disable untuk button remove dan save apabila tabel blm terisi
    private void belanja(){
        if(isEmpty()){
            this.buttonSave.setEnabled(false);
            this.buttonRemove.setEnabled(false);
        }else{
            this.buttonSave.setEnabled(true);
            this.buttonRemove.setEnabled(true);
        }
    }
    
    //bisa melakukan transaski baru apabila sebelumnya sdh ber transaksi
    private void TransaksiBaru () {
        this.jmlhItem.setText(" ") ;
        this.kode.setText(" ") ;
        this.buttonNew.setEnabled(true) ;
        this.buttonSave.setEnabled(false) ;
        this.buttonCancel.setEnabled(false) ;
        this.buttonAdd.setEnabled(false) ;
        this.buttonRemove.setEnabled(false) ;
        this.buttonRemove.setEnabled(false) ;
        this.jmlhItem.setEnabled(false) ;
        this.pilihItem.setEnabled(false) ;
        this.tbModel.setRowCount(0) ;
        this.belanja.clear() ;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
        pilihItem = new javax.swing.JComboBox<>();
        buttonNew = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonRemove = new javax.swing.JButton();
        jmlhItem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        buttonSave = new javax.swing.JButton();
        buttonCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Code");

        jLabel2.setText("Items");

        kode.setText(" ");

        pilihItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gula", "Kopi", "Susu" }));
        pilihItem.setSelectedIndex(-1);

        buttonNew.setText("New");
        buttonNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewActionPerformed(evt);
            }
        });

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonRemove.setText("Remove");
        buttonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoveActionPerformed(evt);
            }
        });

        jmlhItem.setText(" ");

        jTable1.setModel(this.tbModel);
        jScrollPane1.setViewportView(jTable1);

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonCancel.setText("Cancel");
        buttonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(pilihItem, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jmlhItem))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                            .addComponent(kode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(buttonRemove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonNew, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCancel)
                        .addGap(0, 402, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNew))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pilihItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonAdd)
                    .addComponent(jmlhItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(buttonRemove))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSave)
                    .addComponent(buttonCancel))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
       TransaksiBaru() ;
        this.krgId() ;
    }//GEN-LAST:event_buttonCancelActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try{
            //looping untuk setiap tabel
            for(int i = 0; i<tbModel.getRowCount();
                    i++){
                 // menyimpan nama barang dan jumlahnya menjadi variable
                String name = tbModel.getValueAt (i , 0).toString () ;
                float harga = new Float (tbModel.getValueAt(i , 1).toString()) ;
                int jumlah = new Integer (tbModel.getValueAt (i , 2).toString());
                this.belanja.add (new Item(name, jumlah, harga ));
            }   
             // instansiasi kelas Transaksi dengan kode dan committed belanja
            Transaksi ts = new Transaksi (this.code , this.belanja) ;
            // Stringbuilder untuk menangani output Transaksi
            StringBuilder sb = new StringBuilder() ;
            // menambahkan hasil transaksi
            sb.append(ts.Pembayaran()) ;
            // memanggil dialog dengan StringBuilder
            JOptionPane.showMessageDialog(this , sb , "Transaksi" , JOptionPane.INFORMATION_MESSAGE) ;
            
            // melakukan transaksi baru
            TransaksiBaru () ;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        //item yg dipilih
        String name = this.pilihItem.getSelectedItem().toString();
        //JTextField jmlhItem di jadikan integer
        int jumlah = new Integer (this.jmlhItem.getText());


//mengecek apakah membeli 2 barang yg sama
        if(doble(name)){
            updateJumlah(name,jumlah);
        }else{
         tbModel.addRow(addItem(name,jumlah));
           }
        this.belanja();
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewActionPerformed
        this.jmlhItem.setText ("1") ;
        this.buttonNew.setEnabled (false) ;
        this.buttonCancel.setEnabled (true) ;
        this.buttonAdd.setEnabled (true) ;
        this.jmlhItem.setEnabled (true) ;
        this.pilihItem.setEnabled (true) ;
        this.kode.setText (this.setKode()) ;
    }//GEN-LAST:event_buttonNewActionPerformed

    private void buttonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoveActionPerformed
       //mengecek apakah ada baris yg sdh dipilih
       if(jTable1.getSelectedRow()<0){
           //jika tidak ada, akan muncul perintah
           String sb = "pilihlah item yang akan di hapus";
           JOptionPane.showMessageDialog(this,sb,"Information",JOptionPane.INFORMATION_MESSAGE);
       }else{
           //kalau ada, maka akan di hapus
           int count = jTable1.getSelectedRows().length;
           for(int i = 0;i<count; i++){
               tbModel.removeRow(jTable1.getSelectedRow());
           }
       }
       this.belanja();
    }//GEN-LAST:event_buttonRemoveActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(TableBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TableBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TableBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TableBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TableBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonCancel;
    private javax.swing.JButton buttonNew;
    private javax.swing.JButton buttonRemove;
    private javax.swing.JButton buttonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jmlhItem;
    private javax.swing.JTextField kode;
    private javax.swing.JComboBox<String> pilihItem;
    // End of variables declaration//GEN-END:variables
}
