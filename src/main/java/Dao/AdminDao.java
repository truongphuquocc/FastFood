package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Bean.AdminBean;

public class AdminDao {
	KetNoi kn = new KetNoi();

	public AdminBean ktdn(String tendn, String mk) throws Exception {
		// b1: ket noi vao csdl
		kn.KetNoi();
		// b2: Lay du lieu ve
		String sql = "Select * from DangNhap where TenDangNhap=? and MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// b3: Truyen tham so vao cau lenh sql
		cmd.setString(1, tendn);
		cmd.setString(2, mk);
		// b4: Thuc hien cau lieu
		ResultSet rs = cmd.executeQuery();
		AdminBean ds = null;
		if (rs.next()) {
			String TenDangNhap = rs.getString("TenDangNhap");
			String MatKhau = rs.getString("MatKhau");
			Boolean Quyen = rs.getBoolean("Quyen");
			ds = new AdminBean(TenDangNhap, MatKhau, Quyen);
		}
		// b6: Dong all
		rs.close();
		kn.cn.close();
		return ds;
	}
}
