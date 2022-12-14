/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Helper.JDBC_Helper;
import Models.HoaDon;
import Models.KhachHang_model;
import Models.ThongKe;
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
public class Thongke_DAO {

    public ArrayList<ThongKe> getAll() {
        ArrayList arrayList = new ArrayList();
        String query = "select HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET, SUM(HOADON_CHITIET.SOLUONG) as N'Số Lượng',SANPHAM_CHITIET.GIATIEN,Sum(HOADON_CHITIET.GIATIEN) as 'Doanh Thu' from HOADON_CHITIET inner join SANPHAM_CHITIET on HOADON_CHITIET.MASANPHAM_CHITIET = SANPHAM_CHITIET.MASANPHAM_CHITIET inner join HOADON on HOADON.MAHOADON = HOADON_CHITIET.MAHOADON\n"
                + "where HOADON.TRANGTHAI = 1\n"
                + "group by HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET,SANPHAM_CHITIET.GIATIEN";
        try {
            ResultSet rs = JDBC_Helper.query(query);
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                arrayList.add(tk);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception ex) {
            Logger.getLogger(Hoadon_DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arrayList;
    }

    public ArrayList<ThongKe> TimKiem(String tenSp) {
        ArrayList<ThongKe> listTk = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET, SUM(HOADON_CHITIET.SOLUONG) as N'Số Lượng',SANPHAM_CHITIET.GIATIEN,Sum(HOADON_CHITIET.GIATIEN) as 'Doanh Thu' from HOADON_CHITIET inner join SANPHAM_CHITIET on HOADON_CHITIET.MASANPHAM_CHITIET = SANPHAM_CHITIET.MASANPHAM_CHITIET inner join HOADON on HOADON.MAHOADON = HOADON_CHITIET.MAHOADON\n"
                    + "where HOADON.TRANGTHAI = 1 and TENSANPHAM_CHITIET Like ?\n"
                    + "group by HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET,SANPHAM_CHITIET.GIATIEN", "%" + tenSp + "%");

            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> Loc(String danhMuc, String nam, String nam2) {
        ArrayList<ThongKe> listTk = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET, SUM(HOADON_CHITIET.SOLUONG) as N'Số Lượng',SANPHAM_CHITIET.GIATIEN,Sum(HOADON_CHITIET.GIATIEN) as 'Doanh Thu' from HOADON_CHITIET inner join SANPHAM_CHITIET on HOADON_CHITIET.MASANPHAM_CHITIET = SANPHAM_CHITIET.MASANPHAM_CHITIET inner join HOADON on HOADON.MAHOADON = HOADON_CHITIET.MAHOADON inner join SANPHAM on SANPHAM.MASANPHAM = SANPHAM_CHITIET.MASANPHAM\n"
                    + "where HOADON.TRANGTHAI = 1 and SANPHAM.TENDANHMUC = ? and NGAYTHANHTOAN betWeen ? +'-01-01' and ? +'-12-30'\n"
                    + "group by HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET,SANPHAM_CHITIET.GIATIEN,SANPHAM.TENDANHMUC", danhMuc, nam, nam2);

            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> LocDanhMuc(String nam, String nam2) {
        ArrayList<ThongKe> listTk = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET, SUM(HOADON_CHITIET.SOLUONG) as N'Số Lượng',SANPHAM_CHITIET.GIATIEN,Sum(HOADON_CHITIET.GIATIEN) as 'Doanh Thu' from HOADON_CHITIET inner join SANPHAM_CHITIET on HOADON_CHITIET.MASANPHAM_CHITIET = SANPHAM_CHITIET.MASANPHAM_CHITIET inner join HOADON on HOADON.MAHOADON = HOADON_CHITIET.MAHOADON inner join SANPHAM on SANPHAM.MASANPHAM = SANPHAM_CHITIET.MASANPHAM\n"
                    + "where HOADON.TRANGTHAI = 1 and NGAYTHANHTOAN betWeen ? +'-01-01' and ? +'-12-30'\n"
                    + "group by HOADON_CHITIET.MASANPHAM_CHITIET,SANPHAM_CHITIET.TENSANPHAM_CHITIET,SANPHAM_CHITIET.GIATIEN,SANPHAM.TENDANHMUC", nam, nam2);

            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> doanhThuTatCa() {
        ArrayList<ThongKe> listTk = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.query("select SUM(HOADON_CHITIET.SOLUONG) as N'Số Lượng',Sum(HOADON_CHITIET.GIATIEN) as 'Doanh Thu' from HOADON_CHITIET inner join HOADON on HOADON.MAHOADON = HOADON_CHITIET.MAHOADON\n"
                    + "where HOADON.TRANGTHAI = 1 ");

            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1), rs.getInt(2));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> tongHoaDon() {
        ArrayList<ThongKe> listTk = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select COUNT(MAHOADON) from HOADON where TRANGTHAI = 1");
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> tongHoaDonHuy() {
        ArrayList<ThongKe> listTk = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.query("select COUNT(MAHOADON) from HOADON\n"
                    + "where TRANGTHAI = 0 ");
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> tongKhachHang() {
        ArrayList<ThongKe> listTk = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.query("select COUNT(MAKHACHHANG) from KHACHHANG");
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }
//theo thang nam

    public ArrayList<ThongKe> doanhThuTatCaTheoThangNam(Date batDau, Date ketThuc) {
        ArrayList<ThongKe> listTk = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select SUM(HOADON_CHITIET.SOLUONG) as N'Số Lượng',Sum(HOADON_CHITIET.GIATIEN) as 'Doanh Thu' from HOADON_CHITIET inner join HOADON on HOADON.MAHOADON = HOADON_CHITIET.MAHOADON\n"
                    + "where HOADON.TRANGTHAI = 1 and NGAYTAO between ? and ? ", batDau, ketThuc);

            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1), rs.getInt(2));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> tongHoaDonThangNam(Date batDau, Date ketThuc) {
        ArrayList<ThongKe> listTk = new ArrayList<>();

        try {
            ResultSet rs = JDBC_Helper.query("select COUNT(MAHOADON) from HOADON where TRANGTHAI = 1 and NGAYTAO between ? and ?", batDau, ketThuc);
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> tongHoaDonHuyThangNam(Date batDau, Date ketThuc) {
        ArrayList<ThongKe> listTk = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.query("select COUNT(MAHOADON) from HOADON\n"
                    + "where TRANGTHAI = 0 and NGAYTAO between ? and ?", batDau, ketThuc);
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }

    public ArrayList<ThongKe> tongKhachHangThangNam(Date batDau, Date ketThuc) {
        ArrayList<ThongKe> listTk = new ArrayList<>();
        try {
            ResultSet rs = JDBC_Helper.query("select COUNT(KHACHHANG.MAKHACHHANG) from KHACHHANG inner join HOADON on KHACHHANG.MAKHACHHANG = HOADON.MAKHACHHANG\n"
                    + "where NGAYTAO between ? and ?", batDau, ketThuc);
            while (rs.next()) {
                ThongKe tk = new ThongKe(rs.getInt(1));
                listTk.add(tk);
            }
        } catch (SQLException sQLException) {
        }
        return listTk;
    }
}
