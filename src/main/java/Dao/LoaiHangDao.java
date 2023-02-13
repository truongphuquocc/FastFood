package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import Bean.LoaiHangBean;

public class LoaiHangDao {
	public ArrayList<LoaiHangBean> getloai() {
		ArrayList<LoaiHangBean> ds = new ArrayList<LoaiHangBean>();
		try {
			// b1: kety noi vao csdl
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			// b2: lay du lieu ve
			String sql = "select * from LoaiHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();

			while (rs.next()) {
				String MaLoai = rs.getString("MaLoai");
				String TenLoai = rs.getString("TenLoai");
				String AnhLoai = rs.getString("AnhLoai");
				ds.add(new LoaiHangBean(MaLoai, TenLoai, AnhLoai));
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

	public int getTongLoai() {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select count(*)from LoaiHang";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				int total = rs.getInt(1);
				return total;
			}
			rs.close();
			kn.cn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public LoaiHangBean getCategory(String maloai) throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			LoaiHangBean loai = null;
			String sql = "select * from LoaiHang where MaLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			ResultSet rs = cmd.executeQuery();
			while (rs.next()) {
				String tenloai = rs.getString("TenLoai");
				String anhloai = rs.getString("AnhLoai");
				loai = new LoaiHangBean(maloai, tenloai, anhloai);
			}
			rs.close();
			kn.cn.close();
			return loai;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int addCategory(String maloai, String tenloai, String anh) throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "select * from LoaiHang where MaLoai = ?";
			PreparedStatement check = kn.cn.prepareStatement(sql);
			check.setString(1, maloai);
			ResultSet c = check.executeQuery();
			int rs;
			if (c.next() != false) {
				return -1;
			} else if (c.next() == false) {
				String sql2 = "insert into LoaiHang (MaLoai, TenLoai, AnhLoai) values (?, ?, ?)";
				PreparedStatement cmd = kn.cn.prepareStatement(sql2);
				cmd.setString(1, maloai);
				cmd.setString(2, tenloai);
				cmd.setString(3, anh);
				rs = cmd.executeUpdate();
			} else
				return 0;
			c.close();
			kn.cn.close();
			return rs;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int deleteCategory(String maloai) throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			int rs;
			String sql = "delete LoaiHang where MaLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, maloai);
			rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int editcategory(String maloai, String tenloai, String anh) throws Exception {
		try {
			KetNoi kn = new KetNoi();
			kn.KetNoi();
			String sql = "update LoaiHang set TenLoai = ?, AnhLoai = ? where MaLoai = ?";
			PreparedStatement cmd = kn.cn.prepareStatement(sql);
			cmd.setString(1, tenloai);
			cmd.setString(2, anh);
			cmd.setString(3, maloai);
			int rs = cmd.executeUpdate();
			kn.cn.close();
			return rs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public boolean checkDeleteCategory(String maloai) throws Exception {
		KetNoi kn = new KetNoi();
		kn.KetNoi();
		String sql = "select * from MonAn where MaLoai = ?";
		boolean checkDeleteCategory = false;
		PreparedStatement cmd = kn.cn.prepareStatement(sql);
		cmd.setString(1, maloai);
		ResultSet rs = cmd.executeQuery();
		if(rs.next()==false) {
			checkDeleteCategory = true;
		}
		
		return checkDeleteCategory;
	}

}
