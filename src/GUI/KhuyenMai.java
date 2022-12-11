/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import DAO.Doanhmuc_DAO;
import DAO.Khuyenmai_DAO;
import DAO.Sanphamchitiet_DAO;
import Models.DoanhMuc;
import Models.SanPhamChiTiet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Asus
 */
public class KhuyenMai extends javax.swing.JPanel {
String arrDanhSach[] = {"Sản phẩm", "Đen"};
    String arrHinhThucGiamGia[] = {"Theo giá tiền", "Theo %"};
    int tmp = -1;
    int index;
    boolean isOn = false;
    Doanhmuc_DAO doanhMuc_Dao = new Doanhmuc_DAO();
    Khuyenmai_DAO khuyenMai_Dao = new Khuyenmai_DAO();

    Sanphamchitiet_DAO sanPhamChiTiet_Dao = new Sanphamchitiet_DAO();
    ArrayList<DoanhMuc> arrayListDoanhMucs = new ArrayList<>();
    ArrayList<Models.KhuyenMai> arrayListKhuyenMais = new ArrayList<>();
    ArrayList<SanPhamChiTiet> arrayListSanPhamChiTiet = new ArrayList<>();

    DefaultComboBoxModel<DoanhMuc> comboBoxModelDoanhMuc = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> comboBoxModelDoanhSach = new DefaultComboBoxModel<>(arrDanhSach);
    DefaultComboBoxModel<String> comboBoxModelHinhThucGiamGia = new DefaultComboBoxModel<>(arrHinhThucGiamGia);
    DefaultTableModel tableModelDanhSach;
    DefaultTableModel tableModelKhuyenMai;
    /**
     * Creates new form KhuyenMai
     */
    public KhuyenMai() {
   
        initComponents();
 
        initData();
        initTable();
        setting();
        if (arrayListKhuyenMais.size() > 0) {
            tblKhuyenMai.setRowSelectionInterval(0, 0);
            index = tblKhuyenMai.getSelectedRow();
            fillToForm(index);
           
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtMucGiam = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnTaoMoi = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMaKm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        txtTenKM = new javax.swing.JTextField();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        rdoHuyApDung = new javax.swing.JRadioButton();
        rdoApDung = new javax.swing.JRadioButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblKhuyenMai = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(36, 54, 101));

        txtMucGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMucGiamActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên KM");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ngày BD");

        btnTaoMoi.setBackground(new java.awt.Color(255, 102, 102));
        btnTaoMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTaoMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-add-new-30.png"))); // NOI18N
        btnTaoMoi.setText("Thêm");
        btnTaoMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoMoiActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mức KM");

        btnSua.setBackground(new java.awt.Color(255, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-available-updates-30.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ngày KT");

        btnLamMoi.setBackground(new java.awt.Color(255, 102, 102));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-broom-30.png"))); // NOI18N
        btnLamMoi.setText("Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Trạng thái");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã KM");

        txtMaKm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKmActionPerformed(evt);
            }
        });

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã loại", "Tên loại", "Select"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDanhSachMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSach);

        txtTenKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKMActionPerformed(evt);
            }
        });

        rdoHuyApDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoHuyApDung.setText("Hủy Áp Dụng");

        rdoApDung.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoApDung.setText("Áp Dụng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKm, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rdoApDung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdoHuyApDung)
                                .addGap(10, 10, 10)))))
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTaoMoi)
                        .addGap(30, 30, 30)
                        .addComponent(btnSua)
                        .addGap(35, 35, 35)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtMaKm, txtMucGiam, txtNgayBD, txtNgayKT, txtTenKM});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnLamMoi, btnSua, btnTaoMoi});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaKm, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(60, 60, 60))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4)))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMucGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(rdoApDung)
                            .addComponent(rdoHuyApDung)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnTaoMoi)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtMaKm, txtMucGiam, txtNgayBD, txtNgayKT, txtTenKM});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnLamMoi, btnSua, btnTaoMoi});

        jTabbedPane1.setBackground(new java.awt.Color(36, 54, 101));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel6.setBackground(new java.awt.Color(36, 54, 101));

        tblKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhuyenMaiMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblKhuyenMai);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1261, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Dánh sách khuyến mại", jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMucGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMucGiamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMucGiamActionPerformed

    private void txtMaKmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKmActionPerformed

    private void txtTenKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKMActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
           if (tblKhuyenMai.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa có dữ liệu ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if (tblKhuyenMai.getSelectedRow() != -1) {
            if (checkInput()) {
                int option = JOptionPane.showConfirmDialog(null, "Chỉnh sửa khuyến mại chứ", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Models.KhuyenMai km = getForm();
                    int isSuccess = khuyenMai_Dao.updateKhuyenMai(km);
                    if (isSuccess > 0) {
                        JOptionPane.showMessageDialog(this, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        arrayListKhuyenMais.get(tblKhuyenMai.getSelectedRow()).setMucGiam(km.getMucGiam());
                        tableModelKhuyenMai.setValueAt(km.getMaKM(), index, 0);
                        tableModelKhuyenMai.setValueAt(km.getTenKM(), index, 1);
                        tableModelKhuyenMai.setValueAt(km.isLoaiKM() ? km.getMucGiam() + " %" : km.getMucGiam() + " VNĐ", index, 2);
                        tableModelKhuyenMai.setValueAt(sdf.format(km.getNgayBD()), index, 3);
                        tableModelKhuyenMai.setValueAt(sdf.format(km.getNgayKT()), index, 4);
                        tableModelKhuyenMai.setValueAt(km.getTrangThai() ? "áp dụng" : "hủy áp dụng", index, 5);
                 
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTaoMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoMoiActionPerformed
        // TODO add your handling code here:
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (checkInput()) {
            int option = JOptionPane.showConfirmDialog(null, "Tạo khuyến mại chứ", "Thông báo", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {

                Models.KhuyenMai km = getForm();
                int isSuccess = khuyenMai_Dao.addKhuyenMai(km);
                if (isSuccess > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm khuyến mại thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    arrayListKhuyenMais.add(km);
                    tableModelKhuyenMai.addRow(new Object[]{
                        km.getMaKM(), km.getTenKM(), km.isLoaiKM() ? km.getMucGiam() + " %" : km.getMucGiam() + " VNĐ", sdf.format(km.getNgayBD()), sdf.format(km.getNgayKT()), km.getTrangThai() ? "áp dụng" : "hủy áp dụng"
                    });
                    index = arrayListKhuyenMais.size() - 1;
                    tblKhuyenMai.setRowSelectionInterval(index, index);
                    isOn = !isOn;
                    btnLamMoi.setText("Làm mới");
                    disableComponent(btnTaoMoi, txtMaKm);
                    enableComponent(btnSua, tblKhuyenMai);
                    tmp = -1;
                    tblKhuyenMaiMousePressed(null);

                } else {
                    JOptionPane.showMessageDialog(this, "Thêm khuyến mại thất bại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

                }
            }

        }

    }//GEN-LAST:event_btnTaoMoiActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void tblDanhSachMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachMousePressed

    private void tblDanhSachMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseReleased
        // TODO add your handling code here:
//           if (cbDanhSach.getSelectedIndex() == 0) {
//            if (evt.isPopupTrigger() && tblDanhSach.getSelectedRow() != -1) {
//                popupMenu.setText("Di chuyển vào danh sách đen");
//                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
//
//            }
//        } else {
//            if (evt.isPopupTrigger() && tblDanhSach.getSelectedRow() != -1) {
//                popupMenu.setText("Loại bỏ khỏi danh sách đen");
//                jPopupMenu1.show(evt.getComponent(), evt.getX(), evt.getY());
//
//            }
//        }
    }//GEN-LAST:event_tblDanhSachMouseReleased

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
             if (tblKhuyenMai.getRowCount() == 0) {
            if (!isOn) {
                clear();
                btnLamMoi.setText("Hủy");
                isOn = !isOn;
                enableComponent(btnTaoMoi);
                disableComponent(btnSua, tblKhuyenMai);
                tableModelDanhSach.setRowCount(0);
                txtMaKm.setText("KM" + (khuyenMai_Dao.getIDKhuyenMai() + 1));

            } else {
                tmp = -1;
                btnLamMoi.setText("Làm mới");
                isOn = !isOn;
                clear();
                disableComponent(btnTaoMoi);
                enableComponent(btnSua, tblKhuyenMai);
                tblKhuyenMaiMousePressed(null);
            }
        } else {
            if (!isOn) {
                tmp = index;
                System.out.println(tmp);
                clear();
                btnLamMoi.setText("Hủy");
                isOn = !isOn;
                tblKhuyenMai.getSelectionModel().clearSelection();
                enableComponent(btnTaoMoi);
                disableComponent(btnSua, tblKhuyenMai);
                tableModelDanhSach.setRowCount(0);
                txtMaKm.setText("KM" + (khuyenMai_Dao.getIDKhuyenMai() + 1));

            } else {
                index = tmp;
                tmp = -1;
                btnLamMoi.setText("Làm mới");
                tblKhuyenMai.setRowSelectionInterval(index, index);
                isOn = !isOn;
                fillToForm(index);
                disableComponent(btnTaoMoi);
                enableComponent(btnSua, tblKhuyenMai);
                tblKhuyenMaiMousePressed(null);

            }
        }
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblKhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhuyenMaiMousePressed
        // TODO add your handling code here:
               if (tmp == -1) {
            index = tblKhuyenMai.getSelectedRow();
            try {
                fillToForm(index);

            } catch (Exception e) {
            }
           
        }
    }//GEN-LAST:event_tblKhuyenMaiMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnTaoMoi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoApDung;
    private javax.swing.JRadioButton rdoHuyApDung;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTable tblKhuyenMai;
    private javax.swing.JTextField txtMaKm;
    private javax.swing.JTextField txtMucGiam;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtTenKM;
    // End of variables declaration//GEN-END:variables
    private void disableComponent(JComponent... components) {
        for (JComponent jComponent : components) {
            jComponent.setEnabled(false);
        }
    }

    private void enableComponent(JComponent... components) {
        for (JComponent jComponent : components) {
            jComponent.setEnabled(true);
        }
    }

    private void initData() {
        arrayListDoanhMucs = doanhMuc_Dao.getAll();
        fillToComboBox(arrayListDoanhMucs, comboBoxModelDoanhMuc);
    }

    private void fillToComboBox(List list, DefaultComboBoxModel comboBoxModel) {
        for (Object object : list) {
            comboBoxModel.addElement(object);
        }
    }

//    private void initComboBox() {
//        cbDanhSach.setModel((ComboBoxModel) comboBoxModelDoanhSach);
//        cbDoanhMuc.setModel((ComboBoxModel) comboBoxModelDoanhMuc);
//        cbHinhThuc.setModel(comboBoxModelHinhThucGiamGia);
//    }

    private void initTable() {
        String headerKhuyenMai[] = {"Mã KM", "Tên KM", "Mức giảm", "Bắt đầu", "Kết thúc", "Trạng thái"};
        String headerDanhSach[] = {"Mã SPCT", "Tên SPCT", "Giá nhập", "Giá bán", "Giá sau khuyến mại", "Số lượng"};
        tableModelKhuyenMai = new DefaultTableModel(headerKhuyenMai, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
        tableModelDanhSach = new DefaultTableModel(headerDanhSach, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }

        };
   
        tblKhuyenMai.setModel(tableModelKhuyenMai);
        fillDataToTableKhuyenMai();
        tblKhuyenMai.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private void fillDataToTableKhuyenMai() {
        arrayListKhuyenMais = khuyenMai_Dao.getAll();
        tableModelKhuyenMai.setRowCount(0);
        for (Models.KhuyenMai km : arrayListKhuyenMais) {
            tableModelKhuyenMai.addRow(new Object[]{
                km.getMaKM(), km.getTenKM(), km.isLoaiKM() ? km.getMucGiam() + " %" : km.getMucGiam() + " VNĐ", km.getNgayBD(), km.getNgayKT(), km.getTrangThai() ? "áp dụng" : "hủy áp dụng"
            });
        }

    }

    private void fillDataToTableDanhSach(ArrayList<SanPhamChiTiet> list) {
        Models.KhuyenMai khuyenMai = arrayListKhuyenMais.get(tblKhuyenMai.getSelectedRow());
        tableModelDanhSach.setRowCount(0);
        for (SanPhamChiTiet km : list) {
            tableModelDanhSach.addRow(new Object[]{
                km.getMaSPCT(), km.getTenSPCT(), km.getGiaNhap(), km.getGiaBan(), khuyenMai.isLoaiKM() ? km.getGiaBan() - (km.getGiaBan() * (khuyenMai.getMucGiam() / 100)) : km.getGiaBan() - khuyenMai.getMucGiam(), km.getSoLuong()
            });
        }

    }

    private void fillToForm(int index) {
        Models.KhuyenMai km = arrayListKhuyenMais.get(index);
        txtMaKm.setText(km.getMaKM());
        txtTenKM.setText(km.getTenKM());
        txtMucGiam.setText(km.getMucGiam() + "");
      
        txtNgayBD.setDate(km.getNgayBD());
        txtNgayKT.setDate(km.getNgayKT());
        if (km.getTrangThai()) {
            rdoApDung.setSelected(true);
        } else {
            rdoHuyApDung.setSelected(true);

        }

    }

    private void setting() {
        disableComponent(txtMaKm, btnTaoMoi);
        String formatDate = "dd-MM-yyyy";
        txtNgayBD.setDateFormatString(formatDate);
        txtNgayKT.setDateFormatString(formatDate);

    }

    private void clear() {
        txtMaKm.setText("");
        txtTenKM.setText("");
        txtMucGiam.setText("");
 
        txtNgayBD.setDate(new Date());
        txtNgayKT.setDate(new Date(new Date().getTime() + 7 * 60 * 60 * 24 * 1000));
    }

    private Models.KhuyenMai getForm() {
        Models.KhuyenMai km = new Models.KhuyenMai();
        km.setMaKM(txtMaKm.getText());
        km.setTenKM(txtTenKM.getText().trim());
        km.setMucGiam(Double.parseDouble(txtMucGiam.getText().trim()));
        km.setNgayBD(txtNgayBD.getDate());
        km.setNgayKT(txtNgayKT.getDate());
 
        km.setTrangThai(rdoApDung.isSelected());
        return km;
    }

    private boolean checkInput() {
        if (txtTenKM.getText().trim().isEmpty() || txtMucGiam.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nhập đủ thông tin", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        } else if (txtNgayBD.getDate().after(txtNgayKT.getDate())) {
            JOptionPane.showMessageDialog(this, "Ngày diễn ra khuyến mại không hợp lệ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        String muc = txtMucGiam.getText().trim();

        return true;
    }

    public void changeCard() {
        if (arrayListKhuyenMais.size() > 0) {
            tblKhuyenMai.setRowSelectionInterval(0, 0);
            index = tblKhuyenMai.getSelectedRow();
            fillToForm(index);
        }
    }
}