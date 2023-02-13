package Bo;

import java.util.ArrayList;
import Bean.MonAnBean;
import Dao.MonAnDao;

public class MonAnBo {
	MonAnDao madao = new MonAnDao();
	ArrayList<MonAnBean> ds;

	public ArrayList<MonAnBean> GetMonAn() {
		ds = madao.getMonAn();
		return ds;
	}

	public MonAnBean getMotMon(String masach) throws Exception {
		return madao.getMotMon(masach);
	}

	public int editMon(String maMon, String tenMon, Long gia, Long soluong, String anh, String maloai)
			throws Exception {
		return madao.editMon(maMon, tenMon, gia, soluong, anh, maloai);
	}

	public int addMon(String maMonAn, String tenMonAn, long soLuong, long gia, String maLoai, String anh)
			throws Exception {
		return madao.addMon(maMonAn, tenMonAn, soLuong, gia, maLoai, anh);
	}

	public int deleteMonAn(String maMon) throws Exception {
		return madao.deleteMonAn(maMon);
	}

	public boolean checkXoaMonAn(String mahoadon) {
		return madao.checkXoaMonAn(mahoadon);
	}

	public int xoaChiTietHoaDon(String MaMonAn) throws Exception {
		return madao.xoaChiTietHoaDon(MaMonAn);
	}

	// Phan trang total
	public ArrayList<MonAnBean> getPaging(int index) {
		ds = madao.getPaging(index);
		return ds;
	}

	// Phan trang theo tim kiem sach
	public ArrayList<MonAnBean> getPagingSearch(String key, int index) {
		ds = madao.getPagingSearch(key, index);
		return ds;
	}

	// Phan trang theo loai sach
	public ArrayList<MonAnBean> getPagingCategories(String key, int index) {
		ds = madao.getPagingCategories(key, index);
		return ds;
	}

	public ArrayList<MonAnBean> TimMa(String maloai) {
		ArrayList<MonAnBean> tam = new ArrayList<MonAnBean>();
		for (MonAnBean s : ds)
			if (s.getMaLoai().equals(maloai))
				tam.add(s);
		return tam;
	}

	public ArrayList<MonAnBean> Tim(String key) {
		ArrayList<MonAnBean> tam = new ArrayList<MonAnBean>();
		for (MonAnBean s : ds)
			if (s.getTenMonAn().toLowerCase().contains(key.toLowerCase())
					|| s.getMaLoai().toLowerCase().contains(key.toLowerCase()))
				tam.add(s);
		return tam;
	}

	public int getPageNumber() {
		return madao.getPageNumber();
	}

	public int getPageNumberSearch(String maloai) {
		return madao.getPageNumberSearch(maloai);
	}

	public int getPageNumberCategories(String key) {
		return madao.getPageNumberCategories(key);
	}

}
