package Bo;

import java.util.ArrayList;
import java.util.List;

import Bean.ChiTietLichSuMuaHangBean;
import Dao.ChiTietLichSuMuaHangDao;

public class ChiTietLichSuMuaHangBo {
	ChiTietLichSuMuaHangDao lsdao = new ChiTietLichSuMuaHangDao();
	ArrayList<ChiTietLichSuMuaHangBean> ds;

	public ArrayList<ChiTietLichSuMuaHangBean> getLichSuMuaHang(long MaHoaDon) throws Exception {
		ds = lsdao.getChiTietLichSuMuaHang(MaHoaDon);
		return ds;
	}

	public ChiTietLichSuMuaHangBean laymothoadon(long mahd) throws Exception {
		return lsdao.motHoaDon(mahd);
	}

	public List<ChiTietLichSuMuaHangBean> getall() {
		return ds;
	}

	public int xacnhanchitiet(int mact) throws Exception {
		return lsdao.xacnhanchitiet(mact);
	}

}
