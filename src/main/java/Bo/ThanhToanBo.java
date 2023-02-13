package Bo;

import Dao.ThanhToanDao;

public class ThanhToanBo {
	ThanhToanDao ttdao = new ThanhToanDao();

	public int ThemHoaDon(Long makh, String ghichu) throws Exception {
		return ttdao.themHoaDondao(makh, ghichu);
	}

	public long GetHoaDon() throws Exception {
		return ttdao.maHDVuaTao();
	}

	public int ThemCTHD(String MaMonAn, long SoLuongMua, long MaHoaDon) {
		try {
			return ttdao.themCTHDdao(MaMonAn, SoLuongMua, MaHoaDon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
}
