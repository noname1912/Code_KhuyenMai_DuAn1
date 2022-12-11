/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JDBC_Helper;
import Iservices.IKhachHang;
import Models.KhachHang_model;
import Utils.MsgBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Khachhang_DAO implements IKhachHang<KhachHang_model, Object> {

    @Override
    public void insert(KhachHang_model entity) {
        String maKH = entity.getMaKH();
        entity.setMaKH("KH" + (getIDKH() + 1));
        try {
            String sql = "select * from KHACHHANG";
            ResultSet rs = JDBC_Helper.query(sql);
            while (rs.next()) {
                if (rs.getString(1).equals(maKH)) {
                    MsgBox.alert(null, "Đã trùng mã khách hàng! Mời nhập mã khác :) ");
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBC_Helper.update("insert into KHACHHANG (MAKHACHHANG,HOTEN,SODT,DIACHI,EMAIL) values (?,?,?,?,?)", entity.getMaKH(), entity.getTenKH(), entity.getSdt(), entity.getEmail(), entity.getDiaChi());
        MsgBox.alert(null, "Thêm khách hàng thành công :) ");
    }

    public int getIDKH() {
        String query = "select MAX(ID) from KHACHHANG";
        try {
            ResultSet rs = JDBC_Helper.query(query);
            if (rs.next()) {
                return rs.getInt(1);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(Khachhang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    @Override
    public void update(KhachHang_model entity) {
        JDBC_Helper.update("update KHACHHANG set HOTEN=?,SODT=?,DIACHI=?,EMAIL=? where MAKHACHHANG = ?", entity.getTenKH(), entity.getSdt(), entity.getEmail(), entity.getDiaChi(), entity.getMaKH());
    }

    @Override
    public List<KhachHang_model> selectALL() {
        return this.selectBySQL("select * from KHACHHANG");
    }

    @Override
    public KhachHang_model selectByID(Object key) {
        List<KhachHang_model> list = this.selectBySQL("select * from KHACHHANG WHERE MAKHACHHANG = ?", key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<KhachHang_model> selectBySQL(String sql, Object... args) {
        List<KhachHang_model> listKH = new ArrayList<KhachHang_model>();
        try {
            ResultSet rs = JDBC_Helper.query(sql, args);
            while (rs.next()) {
                KhachHang_model kh = new KhachHang_model();
                kh.setMaKH(rs.getString("MAKHACHHANG"));
                kh.setTenKH(rs.getString("HOTEN"));
                kh.setSdt(rs.getString("SODT"));
                kh.setDiaChi(rs.getString("DIACHI"));
                kh.setEmail(rs.getString("EMAIL"));
                listKH.add(kh);
            }
            rs.getStatement().getConnection().close();
            return listKH;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<KhachHang_model> selectByKeyword(String key) {
        String sql = "select * from KHACHHANG where HOTEN like ?";
        return this.selectBySQL(sql, "%" + key + "%");
    }

    static boolean checkTrungMa(String key) {

        try {
            String sql = "select * from KHACHHANG";
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

    public KhachHang_model getByMaKH(String maKH) {
        String query = "select * from KHACHHANG where MAKHACHHANG = ?";

        try {
            ResultSet rs = JDBC_Helper.query(query, maKH);
            if (rs.next()) {
                return new KhachHang_model(rs.getString("MAKHACHHANG"), rs.getString("HOTEN"), rs.getString("SODT"), rs.getString("EMAIL"), rs.getString("DIACHI"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Khachhang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public ArrayList<KhachHang_model> getAll() {
        String query = "SELECT*FROM KHACHHANG";
        ArrayList<KhachHang_model> khachHangs = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.query(query);
            while (rs.next()) {
                KhachHang_model kh = new KhachHang_model(rs.getString("MAKHACHHANG"), rs.getString("HOTEN"), rs.getString("SODT"), rs.getString("DIACHI"), rs.getString("EMAIL"));
                khachHangs.add(kh);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(Khachhang_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHangs;
    }

}
