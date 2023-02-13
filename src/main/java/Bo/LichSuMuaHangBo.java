package Bo;

import Dao.LichSuMuaHangDao;

import java.util.ArrayList;

import Bean.LichSuMuaHangBean;

public class LichSuMuaHangBo {
	LichSuMuaHangDao lsdao = new LichSuMuaHangDao();
	ArrayList<LichSuMuaHangBean> ds;

	public ArrayList<LichSuMuaHangBean> getLichSuMuaHang(long MaKhachHang) throws Exception {
		ds = lsdao.getLichSuMuaHang(MaKhachHang, true);
		return ds;
	}
	
	public ArrayList<LichSuMuaHangBean> getDanhSachChoXacNhan(long MaKhachHang) throws Exception {
		ds = lsdao.getLichSuMuaHang(MaKhachHang, false);
		return ds;
	}
	
	public ArrayList<LichSuMuaHangBean> getDanhSachChuyenTien() throws Exception {
		ds = lsdao.getDanhSachChuyenTien(true);
		return ds;
	}
	
	public ArrayList<LichSuMuaHangBean> getDanhSachXacNhan() throws Exception {
		ds = lsdao.getDanhSachChuyenTien(false);
		return ds;
	}

	public int xacnhanHD(long mahoadon) throws Exception {
		lsdao.xacnhanCTHD(mahoadon);
		return lsdao.xacnhanHD(mahoadon);
	}

	public int countCTHD(long mahoadon) throws Exception {
		return lsdao.countCTHD(mahoadon);
	}

	public void autoXacNhan(long mahoadon) throws Exception {
		int count = countCTHD(mahoadon);
		if (count == 0) {
			lsdao.xacnhanHD(mahoadon);
		}
	}
}
