package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThanhToanDao {
	public int themHoaDondao(long makh, String ghichu) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "INSERT dbo.HoaDon (MaKhachHang, NgayMua, GhiChu, Damua) VALUES (?, GETDATE(), ?, 0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setLong(1, makh);
		cmd.setString(2, ghichu);
		return cmd.executeUpdate();
	}

	public int themCTHDdao(String MaMonAn, long SoLuongMua, long MaHoaDon) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = " INSERT dbo.ChiTietHoaDon (MaMonAn, SoLuongMua, MaHoaDon, Damua)  VALUES (?,?,?, 0)";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaMonAn);
		cmd.setLong(2, SoLuongMua);
		cmd.setLong(3, MaHoaDon);
		return cmd.executeUpdate();
	}

	public int maHDVuaTao() throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		int maHDVuaTao = 0;
		String sql = "SELECT MAX(MaHoaDon) MaHoaDon FROM dbo.HoaDon";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			maHDVuaTao = rs.getInt("MaHoaDon");
		}
		rs.close();
		kn.cn.close();
		return maHDVuaTao;
	}
	
	
}
