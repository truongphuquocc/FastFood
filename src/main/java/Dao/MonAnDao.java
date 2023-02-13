package Dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Bean.MonAnBean;

public class MonAnDao {
	public ArrayList<MonAnBean> getMonAn() {
		ArrayList<MonAnBean> ds = new ArrayList<MonAnBean>();
		try {
			// b1: ket noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from MonAn";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// b3: luu all du lieu vao mang ds
			while (rs.next()) {
				String MaMonAn = rs.getString("MaMonAn");
				String TenMonAn = rs.getString("TenMonAn");
				long SoLuong = rs.getLong("SoLuong");
				long Gia = rs.getLong("Gia");
				String MaLoai = rs.getString("MaLoai");
				String Anh = rs.getString("Anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				ds.add(new MonAnBean(MaMonAn, TenMonAn, SoLuong, Gia, MaLoai, Anh, NgayNhap));
			}
			// b4: dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public int getPageNumber() {
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select count(MaMonAn) as soluong from MonAn";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			// int soluong = 0;
			// Luu all du lie vao mang
			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int getPageNumberSearch(String maloai) {
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select count(MaMonAn) as soluong from MonAn where MaLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			ResultSet rs = cmd.executeQuery();
			// int soluong = 0;
			// Luu all du lie vao mang
			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int getPageNumberCategories(String key) {
		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select count(MaMonAn) as soluong from MonAn where MaLoai like ? or TenMonAn like ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");
			ResultSet rs = cmd.executeQuery();
			// int soluong = 0;
			// Luu all du lie vao mang
			while (rs.next()) {
				return (int) rs.getInt(1);
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<MonAnBean> getPaging(int index) {
		ArrayList<MonAnBean> ds = new ArrayList<MonAnBean>();

		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from MonAn order by MaMonAn OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setInt(1, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String MaMonAn = rs.getString("MaMonAn");
				String TenMonAn = rs.getString("TenMonAn");
				long SoLuong = rs.getLong("SoLuong");
				long Gia = rs.getLong("Gia");
				String MaLoai = rs.getString("MaLoai");
				String Anh = rs.getString("Anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				ds.add(new MonAnBean(MaMonAn, TenMonAn, SoLuong, Gia, MaLoai, Anh, NgayNhap));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<MonAnBean> getPagingSearch(String key, int index) {
		ArrayList<MonAnBean> ds = new ArrayList<MonAnBean>();

		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from MonAn where MaLoai like ? or TenMonAn like ? order by MaMonAn OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, "%" + key + "%");
			cmd.setString(2, "%" + key + "%");

			cmd.setInt(3, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String MaMonAn = rs.getString("MaMonAn");
				String TenMonAn = rs.getString("TenMonAn");
				long SoLuong = rs.getLong("SoLuong");
				long Gia = rs.getLong("Gia");
				String MaLoai = rs.getString("MaLoai");
				String Anh = rs.getString("Anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				ds.add(new MonAnBean(MaMonAn, TenMonAn, SoLuong, Gia, MaLoai, Anh, NgayNhap));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<MonAnBean> getPagingCategories(String key, int index) {
		ArrayList<MonAnBean> ds = new ArrayList<MonAnBean>();

		try {
			// B1: ket noi csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from MonAn where MaLoai = ? order by MaMonAn OFFSET ? ROWS FETCH NEXT 12 ROWS ONLY";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, key);

			cmd.setInt(2, (index - 1) * 12);
			ResultSet rs = cmd.executeQuery();
			// Luu all du lie vao mang
			while (rs.next()) {
				String MaMonAn = rs.getString("MaMonAn");
				String TenMonAn = rs.getString("TenMonAn");
				long SoLuong = rs.getLong("SoLuong");
				long Gia = rs.getLong("Gia");
				String MaLoai = rs.getString("MaLoai");
				String Anh = rs.getString("Anh");
				Date NgayNhap = rs.getDate("NgayNhap");
				ds.add(new MonAnBean(MaMonAn, TenMonAn, SoLuong, Gia, MaLoai, Anh, NgayNhap));
			}
			// Dong ket noi
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	public MonAnBean getMotMon(String masach) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		MonAnBean mabean = null;
		String sql = "select * from MonAn where MaMonAn = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, masach);
		ResultSet rs = cmd.executeQuery();
		while (rs.next()) {
			String MaMonAn = rs.getString("MaMonAn");
			String TenMonAn = rs.getString("TenMonAn");
			long SoLuong = rs.getLong("SoLuong");
			long Gia = rs.getLong("Gia");
			String MaLoai = rs.getString("MaLoai");
			String Anh = rs.getString("Anh");
			Date NgayNhap = rs.getDate("NgayNhap");
			mabean = new MonAnBean(MaMonAn, TenMonAn, SoLuong, Gia, MaLoai, Anh, NgayNhap);
		}
		rs.close();
		return mabean;
	}

	public int editMon(String maMon, String tenMon, Long gia, Long soluong, String anh, String maloai)
			throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "Update MonAn SET TenMonAn = ? ,SoLuong= ? , Gia= ?, MaLoai = ?, Anh = ?, NgayNhap = GETDATE() WHERE MaMonAn = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenMon);
			cmd.setLong(2, soluong);
			cmd.setLong(3, gia);
			cmd.setString(4, maloai);
			cmd.setString(5, anh);
			cmd.setString(6, maMon);
			int check = cmd.executeUpdate();
			kn.cn.close();
			return check;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	public int addMon(String maMonAn, String tenMonAn, long soLuong, long gia, String maLoai, String anh)
			throws Exception {
		// b1: ket noi vao csdl
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String ktra = "select * from MonAn where MaMonAn=?";
		PreparedStatement ktradk = kn.cn.prepareStatement(ktra);
		ktradk.setString(1, maMonAn);
		ResultSet ktdk = ktradk.executeQuery();
		int rs;
		if (ktdk.next() != false)
			return -1;
		else if (ktdk.next() == false) {
			String sql = "insert into MonAn (MaMonAn,TenMonAn,SoLuong,Gia,MaLoai,Anh,NgayNhap) values (?,?,?,?,?,?,GETDATE())";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maMonAn);
			cmd.setString(2, tenMonAn);
			cmd.setLong(3, soLuong);
			cmd.setLong(4, gia);
			cmd.setString(5, maLoai);
			cmd.setString(6, anh);
			// b4: Thuc hien cau lieu
			rs = cmd.executeUpdate();
		} else
			return 0;
		// b6: Dong all
		ktdk.close();
		kn.cn.close();
		return rs;
	}

	public int deleteMonAn(String maMonAn) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		int rs;
		String sql = "Delete MonAn where MaMonAn=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maMonAn);
		rs = cmd.executeUpdate();
		// b6: Dong all
		kn.cn.close();
		return rs;
	}

	public boolean checkXoaMonAn(String mamonan) {
		String sqlString = "select * from ChiTietHoaDon where MaMonAn = ? and DaMua = 0";

		boolean checkXoaMonAn = false;
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			PreparedStatement st = kn.cn.prepareStatement(sqlString);
			st.setString(1, mamonan);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next() == false) {
				checkXoaMonAn = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checkXoaMonAn;
	}

	public int xoaChiTietHoaDon(String MaMonAn) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "delete ChiTietHoaDon where MaMonAn = ?";

		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, MaMonAn);
		return cmd.executeUpdate();
	}

}
