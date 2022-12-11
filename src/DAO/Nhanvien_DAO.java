/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Models.NhanVien_model;
import Utils.MsgBox;
import Helper.JDBC_Helper;
import Iservices.INhanVien;
import Iservices.INhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class Nhanvien_DAO implements INhanVien<NhanVien_model, String> {

    Connection cn;

    @Override
    public void insert(NhanVien_model entity) {
        String maNV = entity.getMaNhanVien();
        try {
            String sql = "select * from nhanvien";
            ResultSet rs = JDBC_Helper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(maNV)) {
                    MsgBox.alert(null, "Đã trùng mã nhân viên! Mời nhập mã khác :) ");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBC_Helper.update("INSERT INTO NHANVIEN\n"
                + "(MANHANVIEN, HOTEN, DIACHI, NGAYSINH, MATKHAU, SODT, VAITRO, TRANGTHAI)\n"
                + "VALUES (?,?,?,?,?,?,?,?)", entity.getMaNhanVien(), entity.getHoTen(), entity.getDiaChi(), entity.getNgaySinh(), entity.getMatKhau(), entity.getSDT(), entity.isVaiTro(), entity.isTrangThai());
        MsgBox.alert(null, "Thêm nhân viên thành công :) ");
    }

    @Override
    public void update(NhanVien_model entity) {
        JDBC_Helper.update("UPDATE NHANVIEN\n"
                + "SET    HOTEN = ?, NGAYSINH = ?, DIACHI = ?, MATKHAU = ?, VAITRO = ?, SODT = ?, TRANGTHAI = ?\n"
                + "WHERE  MANHANVIEN = ?", entity.getHoTen(), entity.getNgaySinh(), entity.getDiaChi(), entity.getMatKhau(), entity.isVaiTro(), entity.getSDT(), entity.isTrangThai(), entity.getMaNhanVien());
    }

    @Override
    public void delete(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NhanVien_model> selectALL() {
        return this.selectBySQL("SELECT NhanVien.* FROM NhanVien");
    }

    @Override
    public NhanVien_model selectByID(String key) {
        List<NhanVien_model> list = this.selectBySQL("SELECT NhanVien.* FROM NhanVien WHERE MANHANVIEN = ?", key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NhanVien_model> selectBySQL(String sql, Object... args) {
        List<NhanVien_model> lstNhanVien = new ArrayList<NhanVien_model>();
        try {
            ResultSet rs = JDBC_Helper.query(sql, args);
            while (rs.next()) {
                NhanVien_model nv = new NhanVien_model();
                nv.setMaNhanVien(rs.getString("MANHANVIEN"));
                nv.setHoTen(rs.getString("HOTEN"));
                nv.setNgaySinh(rs.getDate("NGAYSINH"));
                nv.setDiaChi(rs.getString("DIACHI"));
                nv.setMatKhau(rs.getString("MATKHAU"));
                nv.setVaiTro(rs.getBoolean("VAITRO"));
                nv.setSDT(rs.getString("SODT"));
                nv.setTrangThai(rs.getBoolean("TRANGTHAI"));
                lstNhanVien.add(nv);
            }
            rs.getStatement().getConnection().close();
            return lstNhanVien;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<NhanVien_model> selectByKeyword(String key) { // Tra ve 1 list nhan vien theo key (ma nhan vien)
        String sql = "select * from nhanvien where HoTen LIKE ?";
        return this.selectBySQL(sql, "%" + key + "%");
    }

    static boolean checkTrungMa(String key) {

        try {
            String sql = "select * from nhanvien";
            ResultSet rs = JDBC_Helper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(key)) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
