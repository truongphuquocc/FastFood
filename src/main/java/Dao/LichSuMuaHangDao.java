package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Bean.LichSuMuaHangBean;

public class LichSuMuaHangDao {
	KetNoi kn = new KetNoi();

	public ArrayList<LichSuMuaHangBean> getLichSuMuaHang(long makh, boolean Damua) throws Exception {
		ArrayList<LichSuMuaHangBean> list = new ArrayList<LichSuMuaHangBean>();
		String sql = "select * from VLichSu where MaKhachHang = ? and DaMua = ? ORDER BY MaHoaDon  desc";
		kn.KetNoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		cmd.setBoolean(2, Damua);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long MaHoaDon = rs.getLong("MaHoaDon");
			Date NgayMua = rs.getDate("NgayMua");
			String GhiChu = rs.getString("GhiChu");
			String HoTen = rs.getString("HoTen");
			boolean DaMua = rs.getBoolean("Damua");
			long ThanhTien = rs.getLong("ThanhTien");
			long MaKhachHang = rs.getLong("MaKhachHang");
			String DiaChi = rs.getString("DiaChi");
			list.add(new LichSuMuaHangBean(MaHoaDon, NgayMua, GhiChu, HoTen, DaMua, ThanhTien, MaKhachHang, DiaChi));
		}
		rs.close();
		kn.cn.close();
		return list;
	}

	public ArrayList<LichSuMuaHangBean> getDanhSachChuyenTien(boolean DaMua) throws Exception {
		ArrayList<LichSuMuaHangBean> list = new ArrayList<LichSuMuaHangBean>();
		kn.KetNoi();

		String sql = "select * from VLichSu Where DaMua = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setBoolean(1, DaMua);

		// PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long MaHoaDon = rs.getLong("MaHoaDon");
			Date NgayMua = rs.getDate("NgayMua");
			String GhiChu = rs.getString("GhiChu");
			String HoTen = rs.getString("HoTen");
			long ThanhTien = rs.getLong("ThanhTien");
			long MaKhachHang = rs.getLong("MaKhachHang");
			String DiaChi = rs.getString("DiaChi");
			list.add(new LichSuMuaHangBean(MaHoaDon, NgayMua, GhiChu, HoTen, DaMua, ThanhTien, MaKhachHang, DiaChi));
		}
		rs.close();
		kn.cn.close();
		return list;
	}

	public int xacnhanHD(long mahoadon) throws Exception {
		try {
			// b1: ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "update HoaDon set DaMua = 'true' where MaHoaDon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahoadon);
			int rs = cmd.executeUpdate();

			// b4: dong ket noi
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	public int countCTHD(long mahoadon) throws Exception {
		try {
			// b1: ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select COUNT(DaMua) from ChiTietHoaDon where Damua = 0 and MaHoaDon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahoadon);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// b4: dong ket noi
			kn.cn.close();
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return -1;
	}

	public int xacnhanCTHD(long mahoadon) throws Exception {
		try {
			// b1: ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "update ChiTietHoaDon set Damua = 1 where MaHoaDon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setLong(1, mahoadon);
			int rs = cmd.executeUpdate();

			// b4: dong ket noi
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}


}
