package Dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.KhachHangBean;
import Bean.LoaiHangBean;

public class KhachHangDao {
	public static String getMd5Hash(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public KhachHangBean ktdn(String tendn, String mk) throws Exception {
		// String PassMD5 = getMd5Hash(mk);

		KetNoi kn = new KetNoi();
		kn.KetNoi();

		String sql = "Select * from KhachHang where TenDangNhap=? and MatKhau=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// String PassMD5 = getMd5Hash(mk);
		cmd.setString(1, tendn);
		cmd.setString(2, mk);

		ResultSet rs = cmd.executeQuery();

		KhachHangBean kh = null;
		if (rs.next()) {
			long MaKhachHang = rs.getLong("MaKhachHang");
			String HoTen = rs.getString("HoTen");
			String DiaChi = rs.getString("DiaChi");
			String SoDienThoai = rs.getString("SoDienThoai");
			String Email = rs.getString("Email");
			String TenDangNhap = rs.getString("TenDangNhap");
			String MatKhau = rs.getString("MatKhau");
			kh = new KhachHangBean(MaKhachHang, HoTen, DiaChi, SoDienThoai, Email, TenDangNhap, MatKhau);
		}
		// b6: Dong all
		rs.close();
		kn.cn.close();
		return kh;
	}

	public KhachHangBean laythongtin(String tendn) throws Exception {
		// String PassMD5 = getMd5Hash(mk);

		KetNoi kn = new KetNoi();
		kn.KetNoi();

		String sql = "Select * from KhachHang where TenDangNhap=?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		// String PassMD5 = getMd5Hash(mk);
		cmd.setString(1, tendn);

		ResultSet rs = cmd.executeQuery();

		KhachHangBean kh = null;
		if (rs.next()) {
			long MaKhachHang = rs.getLong("MaKhachHang");
			String HoTen = rs.getString("HoTen");
			String DiaChi = rs.getString("DiaChi");
			String SoDienThoai = rs.getString("SoDienThoai");
			String Email = rs.getString("Email");
			String TenDangNhap = rs.getString("TenDangNhap");
			String MatKhau = rs.getString("MatKhau");
			kh = new KhachHangBean(MaKhachHang, HoTen, DiaChi, SoDienThoai, Email, TenDangNhap, MatKhau);
		}
		// b6: Dong all
		rs.close();
		kn.cn.close();
		return kh;
	}

	public boolean checkTendangnhap(String tendangnhap) {
		String sqlString = "Select * from KhachHang where TenDangNhap=?";

		boolean checktendangnhap = false;
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			PreparedStatement st = kn.cn.prepareStatement(sqlString);
			st.setString(1, tendangnhap);
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next() == false) {
				checktendangnhap = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return checktendangnhap;
	}

	public Boolean ktdk(String HoTen, String DiaChi, String SoDienThoai, String Email, String TenDangNhap,
			String MatKhau) throws Exception {

		KetNoi kn = new KetNoi();
		kn.KetNoi();
		try {
			String sql = "Insert into KhachHang Values (?,?,?,?,?,?)";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, HoTen);
			cmd.setString(2, DiaChi);
			cmd.setString(3, SoDienThoai);
			cmd.setString(4, Email);
			cmd.setString(5, TenDangNhap);
			cmd.setString(6, MatKhau);

			if (cmd.executeUpdate() == 1) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;

	}

	public boolean ChangePassword(String tendn, String pass) {
		String sqlString = "update KhachHang set MatKhau = ? where TenDangNhap = ?";

		KetNoi kn = new KetNoi();
		kn.KetNoi();
		try {

			PreparedStatement st = kn.cn.prepareStatement(sqlString);
			st.setString(1, pass);
			st.setString(2, tendn);

			st.executeUpdate();
			kn.cn.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean ChangeInfo(String tendn, String hoten, String email, String sdt) throws Exception {
		String sql = "update KhachHang set HoTen = ?, SoDienThoai = ?, Email = ?  where TenDangNhap = ?";
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		try {
			PreparedStatement st = kn.cn.prepareStatement(sql);
			st.setString(1, hoten);
			st.setString(2, sdt);
			st.setString(3, email);
			st.setString(4, tendn);

			st.executeUpdate();
			kn.cn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<KhachHangBean> getKhachHang() {
		ArrayList<KhachHangBean> ds = new ArrayList<KhachHangBean>();
		try {
			// b1: kety noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from KhachHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				long MaKhachHang = rs.getLong("MaKhachHang");
				String HoTen = rs.getString("HoTen");
				String DiaChi = rs.getString("DiaChi");
				String SoDienThoai = rs.getString("SoDienThoai");
				String Email = rs.getString("Email");
				String TenDangNhap = rs.getString("TenDangNhap");
				String MatKhau = rs.getString("MatKhau");
				ds.add(new KhachHangBean(MaKhachHang, HoTen, DiaChi, SoDienThoai, Email, TenDangNhap, MatKhau));
			}
			rs.close();
			kn.cn.close();
			return ds;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public int deleteBook(String makh) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		int rs;
		String sql = "Delete KhachHang where MaKhachHang = ?";
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, makh);
		rs = cmd.executeUpdate();
		// b6: Dong all
		kn.cn.close();
		return rs;
	}

}
