package Bo;

import java.util.ArrayList;
import java.util.List;

import Bean.GioHangBean;

public class GioHangBo {
	  public ArrayList<GioHangBean> ds = new ArrayList<GioHangBean>();

	  public void Them(String MaMonAn, String TenMonAn, String Anh, long Gia, long SoLuong) {
	    for (GioHangBean h : ds)
	      if (h.getMaMonAn() .equals(MaMonAn)) {
	        h.setSoLuong(h.getSoLuong() + SoLuong);
	        return;
	      }

	    ds.add(new GioHangBean(MaMonAn, TenMonAn, Anh, Gia, SoLuong));
	  }

	  public long Tongtien() {
	    long s = 0;
	    for (GioHangBean h : ds)
	      s = s + h.getThanhTien();
	    return s;
	  }

	  public void Sua(String maSach, long sl) {
	    for (GioHangBean g : ds) {
	      if (g.getMaMonAn().equals(maSach)) {
	        g.setSoLuong(sl);
	        return;
	      }
	    }
	  }

	  public void Xoa(String maSach) {
	    for (GioHangBean g : ds) {
	      if (g.getMaMonAn().equals(maSach)) {
	        ds.remove(g);
	        return;
	      }
	    }
	  }

	  public void XoaALL() {
	    ds.clear();
	  }

	  public List<GioHangBean> getall() {
	    return ds;
	  }

}
