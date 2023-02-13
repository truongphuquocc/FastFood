package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import Bean.ChiTietLichSuMuaHangBean;
import Bean.KhachHangBean;

public class ChiTietLichSuMuaHangDao {
	KetNoi kn = new KetNoi();

	public ArrayList<ChiTietLichSuMuaHangBean> getChiTietLichSuMuaHang(long mahd) throws Exception {
		ArrayList<ChiTietLichSuMuaHangBean> list = new ArrayList<ChiTietLichSuMuaHangBean>();
		String sql = "select * from VChiTietLichSu where MaHoaDon = ?";
		kn.KetNoi();
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, mahd);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			long MaChiTietHoaDon = rs.getLong("MaChiTietHoaDon");
			long SoLuongMua = rs.getLong("SoLuongMua");
			boolean DaMua = rs.getBoolean("DaMua");
			long MaHoaDon = rs.getLong("MaHoaDon");
			String HoTen = rs.getString("HoTen");
			long Gia = rs.getLong("Gia");
			String TenMonAn = rs.getString("TenMonAn");
			Date NgayMua = rs.getDate("NgayMua");
			String Anh = rs.getString("Anh");
			long ThanhTien = rs.getLong("ThanhTien");
			list.add(new ChiTietLichSuMuaHangBean(MaChiTietHoaDon, SoLuongMua, DaMua, MaHoaDon, HoTen, Gia, TenMonAn,
					NgayMua, Anh, ThanhTien));
		}
		rs.close();
		kn.cn.close();
		return list;
	}

	public ChiTietLichSuMuaHangBean motHoaDon(long mahd) throws Exception {
		// String PassMD5 = getMd5Hash(mk);

		KetNoi kn = new KetNoi();
		kn.KetNoi();

		String sql = "select * from VChiTietLichSu where MaHoaDon = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// String PassMD5 = getMd5Hash(mk);
		cmd.setLong(1, mahd);

		ResultSet rs = cmd.executeQuery();

		ChiTietLichSuMuaHangBean kh = null;
		if (rs.next()) {
			long MaChiTietHoaDon = rs.getLong("MaChiTietHoaDon");
			long SoLuongMua = rs.getLong("SoLuongMua");
			boolean DaMua = rs.getBoolean("DaMua");
			long MaHoaDon = rs.getLong("MaHoaDon");
			String HoTen = rs.getString("HoTen");
			long Gia = rs.getLong("Gia");
			String TenMonAn = rs.getString("TenMonAn");
			Date NgayMua = rs.getDate("NgayMua");
			String Anh = rs.getString("Anh");
			long ThanhTien = rs.getLong("ThanhTien");
			kh = new ChiTietLichSuMuaHangBean(MaChiTietHoaDon, SoLuongMua, DaMua, MaHoaDon, HoTen, Gia, TenMonAn,
					NgayMua, Anh, ThanhTien);
		}
		// b6: Dong all
		rs.close();
		kn.cn.close();
		return kh;
	}

	public int xacnhanchitiet(int mact) {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update VChiTietLichSu set DaMua = 'true' where MaChiTietHoaDon = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, mact);

			return cmd.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
