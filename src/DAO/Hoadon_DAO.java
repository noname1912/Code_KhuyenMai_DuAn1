/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JDBC_Helper;
import Iservices.IHoaDon;
import Models.HoaDon;
import Models.KhachHang_model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Hoadon_DAO implements IHoaDon {

    Khachhang_DAO khachHang_Dao = new Khachhang_DAO();

    @Override
    public ArrayList<HoaDon> getAll() {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT * FROM HOADON";
        try {
            ResultSet rs = JDBC_Helper.query(query);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang_model kh = khachHang_Dao.selectByID(maKH);
                System.out.println("demo");

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"));
                arrayList.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    @Override
    public int addHoaDon(HoaDon hoaDon) {
        String query = "insert into HOADON(MAHOADON,MANHANVIEN,MAKHACHHANG,NGAYTAO,NGAYTHANHTOAN,TONGTIEN,TIENLAI,HINHTHUCTHANHTOAN,GHICHU,TRANGTHAI,DANGXULY) values (?,?,?,?,?,?,?,?,?,?,?)";
        if (hoaDon.getMaKH().trim().isEmpty()) {
            hoaDon.setMaKH(null);
        }
        hoaDon.setMaHD("HD" + (getIDHoaDon() + 1));
        int isSuccess = JDBC_Helper.update(query, hoaDon.getMaHD(), hoaDon.getMaNV(), hoaDon.getMaKH(), hoaDon.getNgayTao(), hoaDon.getNgayThanhToan(), hoaDon.getTongTien(), hoaDon.getTienLai(), hoaDon.isHinhThucThanhToan(), hoaDon.getGhiChu(), hoaDon.isTrangThai(), hoaDon.isDangXuLy());
        return isSuccess;
    }

    @Override
    public int updatHoaDon(HoaDon hoaDon) {
        if (hoaDon.getMaKH().trim().isEmpty()) {
            hoaDon.setMaKH(null);
        }
        String query = "update HOADON set MAKHACHHANG = ?,PHISHIP = ? , NGAYTHANHTOAN = ? , TONGTIEN = ? , TIENLAI = ? , HINHTHUCTHANHTOAN = ? ,GHICHU = ? , TRANGTHAI = ? , DANGXULY = ?,DANGGIAOHANG = ?,DIACHI=?,SODT=? where MAHOADON = ?";
        return JDBC_Helper.update(query, hoaDon.getMaKH(), hoaDon.getPhiShip(), hoaDon.getNgayThanhToan(), hoaDon.getTongTien(), hoaDon.getTienLai(), hoaDon.isHinhThucThanhToan(), hoaDon.getGhiChu(), hoaDon.isTrangThai(), hoaDon.isDangXuLy(), hoaDon.isDangGiaoHang(), hoaDon.getDChi(), hoaDon.getSDT(), hoaDon.getMaHD());
    }

    @Override
    public int getIDHoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HoaDon getHoaDon(String maHD) {
        String query = "select * from HOADON where MAHOADON = ?";
        HoaDon hoaDon = null;
        try {
            ResultSet rs = JDBC_Helper.query(query, maHD);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang_model kh = khachHang_Dao.getByMaKH(maKH);
                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                Date date = rs.getDate("NGAYTHANHTOAN") != null ? new Date(rs.getTimestamp("NGAYTHANHTOAN").getTime()) : null;
                hoaDon = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), new Date(rs.getTimestamp("NGAYTAO").getTime()), date,
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hoaDon;
    }

    @Override
    public ArrayList<HoaDon> getHoaDonsDangXyLy() {
        ArrayList arrayList = new ArrayList();
        String query = "SELECT * FROM HOADON where DANGXULY = 1 and TRANGTHAI = 1";
        try {
            ResultSet rs = JDBC_Helper.query(query);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang_model kh = khachHang_Dao.selectByID(maKH);
                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                Date date = rs.getDate("NGAYTHANHTOAN") != null ? new Date(rs.getTimestamp("NGAYTHANHTOAN").getTime()) : null;
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), new Date(rs.getTimestamp("NGAYTAO").getTime()), date,
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                hd.setPhiShip(rs.getDouble("PHISHIP"));
                arrayList.add(hd);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public ArrayList<HoaDon> TimKiem(String maHd) {
        ArrayList<HoaDon> listHd = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select * from HOADON where MAHOADON LIKE ?", "%" + maHd + "%");

            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang_model kh = khachHang_Dao.selectByID(maKH);

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                listHd.add(hd);

            }
        } catch (SQLException sQLException) {
        }
        return listHd;
    }

    public ArrayList<HoaDon> select(int trangThai, int hinhthucthanhtoan, int hinhThucBanHang, Date BatDau, Date KetThuc) {
        ArrayList<HoaDon> listhd = new ArrayList<>();

        try {

            ResultSet rs = JDBC_Helper.query("SELECT * FROM HOADON WHERE TRANGTHAI != ? AND HINHTHUCTHANHTOAN != ? AND DANGGIAOHANG != ? AND NGAYTHANHTOAN BETWEEN ? AND ?", trangThai, hinhthucthanhtoan, hinhThucBanHang, BatDau, KetThuc);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang_model kh = khachHang_Dao.selectByID(maKH);

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                listhd.add(hd);

            }
        } catch (Exception e) {
        }
        return listhd;
    }

    public ArrayList<HoaDon> selectNoDate(int trangThai, int hinhthucthanhtoan, int hinhThucBanHang) {
        ArrayList<HoaDon> listhd = new ArrayList<>();

        try {

            ResultSet rs = JDBC_Helper.query("SELECT * FROM HOADON WHERE TRANGTHAI != ? AND HINHTHUCTHANHTOAN != ? AND DANGGIAOHANG != ?", trangThai, hinhthucthanhtoan, hinhThucBanHang);
            while (rs.next()) {
                String maKH = rs.getString("MAKHACHHANG");
                String tenKH = "";
                KhachHang_model kh = khachHang_Dao.selectByID(maKH);

                if (kh != null) {
                    tenKH = kh.getTenKH();
                }
                HoaDon hd = new HoaDon(rs.getString("MAHOADON"), rs.getString("MANHANVIEN"),
                        maKH, rs.getString("GHICHU"), tenKH, rs.getString("SODT"), rs.getString("DIACHI"), rs.getDate("NGAYTAO"), rs.getDate("NGAYTHANHTOAN"),
                        rs.getDouble("TONGTIEN"), rs.getDouble("TIENLAI"), rs.getBoolean("HINHTHUCTHANHTOAN"),
                        rs.getBoolean("TRANGTHAI"), rs.getBoolean("DANGXULY"), rs.getBoolean("DANGGIAOHANG"));
                listhd.add(hd);

            }
        } catch (Exception e) {
        }
        return listhd;
    }
}
