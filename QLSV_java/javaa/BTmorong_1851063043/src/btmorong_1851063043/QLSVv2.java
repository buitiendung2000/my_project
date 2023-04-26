/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btmorong_1851063043;

import connect.ConnectData;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLSVv2 extends javax.swing.JFrame {
    int flag =0;
    DefaultTableModel defaultTableModel;
    ConnectData db;
     String tt="";
       String st="";
  
    int rowselected =-1;
     void  begin(){
        btnthem.setEnabled(true);
        btnsua.setEnabled(false);
        btnluu.setEnabled(false);
        txtmasv.setText("");
        txttensv.setText("");
        txtnam.setText("");
        txtnote.setText("");
        cbgt.setSelectedIndex(0);
        cbngay.setSelectedIndex(0);
        cbthang.setSelectedIndex(0);
        
        chbboiloi.setSelected(false);
        chbcahat.setSelected(false);
        chbdabanh.setSelected(false);
        
        btng.clearSelection();
        }

    /**
     * Creates new form QLSVv2+++
     */
    public QLSVv2() {
        initComponents();
        defaultTableModel =(DefaultTableModel)jTable1.getModel();
        setTitle("QLSV v2.0");
        
        
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
        
            },
            new String [] {
                "Mã","Tên","Giới tính","Ngày Sinh","Sở thích","Tình trạng","Ghi chú"
            }
        ));
        
      
        btnthem.setEnabled(true);
        btnsua.setEnabled(false);
        btnluu.setEnabled(false);
        btnxoa.setEnabled(false);
         showData();
       
    }
    private void showData(){
        try {
        
            String sql="select * from sinhvien";
             db=new ConnectData();
            ResultSet rs=  db.excuteQuerydata(sql);
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                    new Object [][] {                       
                    },
                    new String [] {
                        "Mã","Tên","Giới tính","Ngày Sinh","Sở thích","Tình trạng","Ghi chú"
                    }
            ));
            while (rs.next()) {
             //   list.add(new Student(rs.getString(1),  rs.getString(2), rs.getString(3), rs.getString(4)));
               String a[]=new String[]{
                    rs.getString("masv"),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)
                };
                System.out.println(""+a);
                ((DefaultTableModel)jTable1.getModel()).addRow(a);
            }
            } catch (SQLException ex) {
                System.out.println("lỗi");
       }
   }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btng = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbngay = new javax.swing.JComboBox<>();
        cbthang = new javax.swing.JComboBox<>();
        txtnam = new javax.swing.JTextField();
        txtmasv = new javax.swing.JTextField();
        txttensv = new javax.swing.JTextField();
        cbgt = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtnote = new javax.swing.JTextField();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnluu = new javax.swing.JButton();
        btnlamlai = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        chbboiloi = new javax.swing.JCheckBox();
        chbdabanh = new javax.swing.JCheckBox();
        chbcahat = new javax.swing.JCheckBox();
        rbcodon = new javax.swing.JRadioButton();
        rbconguoiyeu = new javax.swing.JRadioButton();
        btnthem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Thông tin Sinh Viên");

        jLabel2.setText("Mã sinh viên:");

        jLabel3.setText("Tên sinh viên:");

        jLabel4.setText("Giới tính:");

        jLabel51.setText("Ngày sinh:");

        jLabel8.setText("Tình trạng:");

        jLabel9.setText("Ghi chú:");

        jLabel5.setText("Sở thích");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel51))
                        .addGap(0, 13, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(jLabel3)
                .addGap(47, 47, 47)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(jLabel51)
                .addGap(49, 49, 49)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(jLabel9)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        cbngay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cbthang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        txtnam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamActionPerformed(evt);
            }
        });

        txtmasv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmasvActionPerformed(evt);
            }
        });

        cbgt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        txtnote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnoteActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnxoaMouseClicked(evt);
            }
        });
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsuaMouseClicked(evt);
            }
        });

        btnluu.setText("Lưu");
        btnluu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnluuMouseClicked(evt);
            }
        });

        btnlamlai.setText("Làm lại");
        btnlamlai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlamlaiMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Danh sách sinh viên");

        chbboiloi.setText("Bơi lội");
        chbboiloi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chbboiloiActionPerformed(evt);
            }
        });

        chbdabanh.setText("Đá banh");

        chbcahat.setText("Ca hát");

        btng.add(rbcodon);
        rbcodon.setText("Cô đơn");
        rbcodon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbcodonActionPerformed(evt);
            }
        });

        btng.add(rbconguoiyeu);
        rbconguoiyeu.setText("Có người yêu");

        btnthem.setText("Thêm");
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbcodon, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbconguoiyeu))
                            .addComponent(txttensv, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbngay, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbthang, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnluu, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chbboiloi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(chbdabanh, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(btnlamlai, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(chbcahat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnote, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbgt, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 556, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtmasv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txttensv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(cbgt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbthang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtnam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chbboiloi)
                                    .addComponent(chbdabanh)
                                    .addComponent(chbcahat))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbcodon)
                                    .addComponent(rbconguoiyeu))
                                .addGap(18, 18, 18)
                                .addComponent(txtnote, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnxoa)
                            .addComponent(btnsua)
                            .addComponent(btnluu)
                            .addComponent(btnlamlai)
                            .addComponent(btnthem))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    int index;
    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP){
             btnthem.setEnabled(false);
        btnsua.setEnabled(true);
        btnluu.setEnabled(false);
        btnxoa.setEnabled(true);
        int row = jTable1.getSelectedRow();  //lấy dòng mình chọn
        rowselected=row;
        String masv = jTable1.getModel().getValueAt(row, 0).toString();
        String tensv = jTable1.getModel().getValueAt(row, 1).toString();
        String gt = jTable1.getModel().getValueAt(row, 2).toString();
        String ns = jTable1.getModel().getValueAt(row, 3).toString();
        String st = jTable1.getModel().getValueAt(row, 4).toString();
        String tt = jTable1.getModel().getValueAt(row, 5).toString();
        String nt = jTable1.getModel().getValueAt(row, 6).toString();
        String ar[]=ns.split("/");
        
        txtmasv.setText(masv);
        txttensv.setText(tensv);
        txtnote.setText(nt);
        cbgt.setSelectedItem(gt);
        cbngay.setSelectedItem(ar[0]);
        cbthang.setSelectedItem(ar[1]);
        txtnam.setText(ar[2]);
        if(tt.equals("Cô đơn")){
            rbcodon.setSelected(true);
        }
        else{
            rbconguoiyeu.setSelected(true);
        }
        switch(st){
            case"Bơi lội":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(false);
                break;
            case"Ca hát":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(false);
                break;
            case"Đá banh":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(true);
                break;
            case"Bơi lội, Đá banh":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(true);
                break;
            case"Bơi lội, Ca hát":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(false);
                break;
            case"Đá banh, Ca hát":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(true);
                break;
            default:
                chbboiloi.setSelected(true);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(true);
                break;
            
        }
        }
    }//GEN-LAST:event_jTable1KeyPressed

    private void txtmasvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmasvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmasvActionPerformed

    private void txtnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamActionPerformed

    private void txtnoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnoteActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtnoteActionPerformed

    private void rbcodonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbcodonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbcodonActionPerformed

    private void btnthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseClicked
        // TODO add your handling code here:
        flag=1;
        btnthem.setEnabled(false);
        btnsua.setEnabled(false);
        btnluu.setEnabled(true);
        btnxoa.setEnabled(false);
        
    }//GEN-LAST:event_btnthemMouseClicked

    private void btnsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseClicked
        // TODO add your handling code here:
        btnthem.setEnabled(false);
        btnsua.setEnabled(false);
        btnluu.setEnabled(true);
        btnxoa.setEnabled(false);
        flag=2;
    }//GEN-LAST:event_btnsuaMouseClicked

    private void btnlamlaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlamlaiMouseClicked
        // TODO add your handling code here:
        flag=0;
        begin();
    }//GEN-LAST:event_btnlamlaiMouseClicked

    private void btnluuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnluuMouseClicked
        // TODO add your handling code here:
       
      
         String masv=txtmasv.getText();
        String tensv=txttensv.getText();
        String gt=cbgt.getSelectedItem().toString();
        String ns=cbngay.getSelectedItem()+"/"+cbthang.getSelectedItem()+"/"+txtnam.getText();
       
         if(rbcodon.isSelected()){
            tt="Cô đơn";
        }
        else{
            tt="Có người yêu";
        }
         st="Không có sở thích";
        if(chbboiloi.isSelected())
            st="Bơi lội";
        if(chbcahat.isSelected())
            st="Ca hát";
         if(chbdabanh.isSelected())
            st="Đá banh";
         if(chbboiloi.isSelected()&&chbcahat.isSelected())
            st="Bơi lội, Ca hát";
         if(chbboiloi.isSelected()&&chbdabanh.isSelected())
            st="Bơi lội, Đá banh";
        if(chbdabanh.isSelected()&&chbcahat.isSelected())
            st="Đá banh, Ca hát";
        if(chbboiloi.isSelected()&&chbcahat.isSelected()&&chbdabanh.isSelected())
            st="Bơi lội, Ca hát, Đá banh";
        
        
        
        
            
     
        
         String nt=txtnote.getText();
        
            
        
       
        if(flag==1){
            if(masv.equals("")){
                txtmasv.requestFocus(true);
                JOptionPane.showMessageDialog(null, "Mã SV khác rỗng");
            }else if(tensv.equals("")){
                 txttensv.requestFocus(true);
                JOptionPane.showMessageDialog(null, "Tên SV khác rỗng");
            }else if(txtnam.getText().equals(""))
            {
                txtnam.requestFocus(true);
                JOptionPane.showMessageDialog(null, "Năm khác rỗng");
                
            }else{
         String sqlinsert="INSERT INTO sinhvien (masv, tensv, gioitinh,ngaysinh,sothich,tinhtrang,note) VALUES('"+masv+"','"+tensv+"','"+gt+"','"+ns+"','"+st+"' ,'"+tt+"','"+nt+"'   ) "; 
      int kq= db.excuteInsertQuerydata(sqlinsert);
      if(kq==0){
          JOptionPane.showMessageDialog(null, "Insert không thành công");
      }else if(kq==1){
           JOptionPane.showMessageDialog(null, "Insert  thành công");
            String a[]=new String[]{
            txtmasv.getText(), txttensv.getText(),cbgt.getSelectedItem().toString(),ns,st.toString(),tt.toString(),txtnote.getText()
             };
       ((DefaultTableModel)jTable1.getModel()).addRow(a);
      }else{
           JOptionPane.showMessageDialog(null, "Trùng khóa");
      }
            }
            
       
     
      

          
        }else if(flag==2){
            if(masv.equals("")){
                txtmasv.requestFocus(true);
                JOptionPane.showMessageDialog(null, "Mã SV khác rỗng");
            }else if(tensv.equals("")){
                 txttensv.requestFocus(true);
                JOptionPane.showMessageDialog(null, "Tên SV khác rỗng");
            }else if(txtnam.getText().equals(""))
            {
                txtnam.requestFocus(true);
                JOptionPane.showMessageDialog(null, "Năm khác rỗng");
            }
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
               
            },
            new String [] {
                "Mã","Tên","Giới tính","Ngày Sinh","Sở thích","Tâm trạng","Ghi chú"
            }
        ));
            String sql="update sinhvien set tensv='"+tensv+"',gioitinh='"+gt+"',ngaysinh='"+ns+"',ngaysinh='"+st+"',ngaysinh='"+tt+"',ngaysinh='"+nt+"' where masv='"+masv+"'";
             boolean kq=db.excuteUpdateQuerydata(sql);
             if(kq){
               //  JOptionPane.showMessageDialog(null, "Update thành công");
               showData();
             }else{
                 JOptionPane.showMessageDialog(null, "Update không thành công");
             }
            
               
         
            
      

        }else{
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn thao tác");
        }
    }//GEN-LAST:event_btnluuMouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
       
      
        
        
        
        
        btnthem.setEnabled(false);
        btnsua.setEnabled(true);
        btnluu.setEnabled(false);
        btnxoa.setEnabled(true);
        int row = jTable1.getSelectedRow();  //lấy dòng mình chọn
        rowselected=row;
        String masv = jTable1.getModel().getValueAt(row, 0).toString();
        String tensv = jTable1.getModel().getValueAt(row, 1).toString();
        String gt = jTable1.getModel().getValueAt(row, 2).toString();
        String ns = jTable1.getModel().getValueAt(row, 3).toString();
        String st = jTable1.getModel().getValueAt(row, 4).toString();
        String tt = jTable1.getModel().getValueAt(row, 5).toString();
        String nt = jTable1.getModel().getValueAt(row, 6).toString();
        String ar[]=ns.split("/");
        
        txtmasv.setText(masv);
        txttensv.setText(tensv);
        txtnote.setText(nt);
        cbgt.setSelectedItem(gt);
        cbngay.setSelectedItem(ar[0]);
        cbthang.setSelectedItem(ar[1]);
        txtnam.setText(ar[2]);
        if(tt.equals("Cô đơn")){
            rbcodon.setSelected(true);
        }
        else{
            rbconguoiyeu.setSelected(true);
        }
        switch(st){
            case"Bơi lội":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(false);
                break;
            case"Ca hát":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(false);
                break;
            case"Đá banh":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(true);
                break;
            case"Bơi lội, Đá banh":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(true);
                break;
            case"Bơi lội, Ca hát":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(false);
                break;
            case"Đá banh, Ca hát":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(true);
                break;
            default:
                chbboiloi.setSelected(true);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(true);
                break;
            
        }
        
        

    }//GEN-LAST:event_jTable1MouseClicked

    private void chbboiloiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chbboiloiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chbboiloiActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_DOWN||evt.getKeyCode()==KeyEvent.VK_UP){
             btnthem.setEnabled(false);
        btnsua.setEnabled(true);
        btnluu.setEnabled(false);
        btnxoa.setEnabled(true);
        int row = jTable1.getSelectedRow();  //lấy dòng mình chọn
        rowselected=row;
        String masv = jTable1.getModel().getValueAt(row, 0).toString();
        String tensv = jTable1.getModel().getValueAt(row, 1).toString();
        String gt = jTable1.getModel().getValueAt(row, 2).toString();
        String ns = jTable1.getModel().getValueAt(row, 3).toString();
        String st = jTable1.getModel().getValueAt(row, 4).toString();
        String tt = jTable1.getModel().getValueAt(row, 5).toString();
        String nt = jTable1.getModel().getValueAt(row, 6).toString();
        String ar[]=ns.split("/");
        
        txtmasv.setText(masv);
        txttensv.setText(tensv);
        txtnote.setText(nt);
        cbgt.setSelectedItem(gt);
        cbngay.setSelectedItem(ar[0]);
        cbthang.setSelectedItem(ar[1]);
        txtnam.setText(ar[2]);
        if(tt.equals("Cô đơn")){
            rbcodon.setSelected(true);
        }
        else{
            rbconguoiyeu.setSelected(true);
        }
        switch(st){
            case"Bơi lội":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(false);
                break;
            case"Ca hát":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(false);
                break;
            case"Đá banh":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(true);
                break;
            case"Bơi lội, Đá banh":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(false);
                chbdabanh.setSelected(true);
                break;
            case"Bơi lội, Ca hát":
                chbboiloi.setSelected(true);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(false);
                break;
            case"Đá banh, Ca hát":
                chbboiloi.setSelected(false);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(true);
                break;
            default:
                chbboiloi.setSelected(true);
                chbcahat.setSelected(true);
                chbdabanh.setSelected(true);
                break;
            
        }
        }
     
    }//GEN-LAST:event_jTable1KeyReleased

    private void btnxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnxoaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnxoaMouseClicked

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        // TODO add your handling code here:
        
        String masv=txtmasv.getText();
        String sql="delete from sinhvien where masv='"+masv+"'";
        boolean kq=db.excuteDeleteQuerydata(sql);
         if(kq){
               //  JOptionPane.showMessageDialog(null, "Update thành công");
               showData();
               begin();
             }else{
                 JOptionPane.showMessageDialog(null, "Delete không thành công");
             }
      
    }//GEN-LAST:event_btnxoaActionPerformed

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
            java.util.logging.Logger.getLogger(QLSVv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLSVv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLSVv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLSVv2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLSVv2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btng;
    private javax.swing.JButton btnlamlai;
    private javax.swing.JButton btnluu;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JComboBox<String> cbgt;
    private javax.swing.JComboBox<String> cbngay;
    private javax.swing.JComboBox<String> cbthang;
    private javax.swing.JCheckBox chbboiloi;
    private javax.swing.JCheckBox chbcahat;
    private javax.swing.JCheckBox chbdabanh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton rbcodon;
    private javax.swing.JRadioButton rbconguoiyeu;
    private javax.swing.JTextField txtmasv;
    private javax.swing.JTextField txtnam;
    private javax.swing.JTextField txtnote;
    private javax.swing.JTextField txttensv;
    // End of variables declaration//GEN-END:variables
}