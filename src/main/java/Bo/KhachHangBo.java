package Bo;

import java.util.ArrayList;

import Bean.KhachHangBean;
import Bean.MonAnBean;
import Dao.KhachHangDao;

public class KhachHangBo {
	KhachHangDao khdao = new KhachHangDao();
	ArrayList<KhachHangBean> ds;

	public KhachHangBean ktdn(String tendn, String mk) throws Exception {
		return khdao.ktdn(tendn, mk);
	}

	public Boolean ktdk(String hoten, String diachi, String sodt, String email, String tendn, String pass)
			throws Exception {
		return khdao.ktdk(hoten, diachi, sodt, email, tendn, pass);
	}

	public boolean checkTendangnhap(String tendangnhap) {
		return khdao.checkTendangnhap(tendangnhap);
	}

	public boolean ChangePassword(String tendn, String pass) {
		return khdao.ChangePassword(tendn, pass);
	}

	public boolean ChangeInfo(String tendn, String hoten, String email, String sdt) throws Exception {
		return khdao.ChangeInfo(tendn, hoten, email, sdt);
	}

	public KhachHangBean laythongtin(String tendn) throws Exception {
		return khdao.laythongtin(tendn);
	}

	public int deleteKhachHang(String makh) throws Exception {
		return khdao.deleteBook(makh);
	}

	public ArrayList<KhachHangBean> getKhachHang() {

		ds = khdao.getKhachHang();
		return ds;
	}
	


//	public String String (String str) {
//    String[] tu = str.split(" ");
//    for (String s : tu) {
//        if (!s.equals("") && !s.equals(null)) {
//            System.out.println(String.valueOf(s.charAt(0)));
//        }
//    }
//    return str;
//	}
}
