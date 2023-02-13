package Bo;

import java.util.ArrayList;
import Bean.LoaiHangBean;
import Dao.LoaiHangDao;


public class LoaiHangBo {
  LoaiHangDao ldao = new LoaiHangDao();
  ArrayList<LoaiHangBean> ds;

  public ArrayList<LoaiHangBean> getloai() {
    ds = ldao.getloai();
    return ds;
  }

  public ArrayList<LoaiHangBean> Tim(String key) throws Exception {
    ArrayList<LoaiHangBean> tam = new ArrayList<LoaiHangBean>();
    ArrayList<LoaiHangBean> ds = getloai();
    for (LoaiHangBean s : ds)
      if (s.getTenLoai().toLowerCase().trim().contains(key.toLowerCase().trim()))
        tam.add(s);
    return tam;
  }

  public int getTongLoai() {
    ldao.getloai();
    return ldao.getTongLoai();
  }
  
  public LoaiHangBean getCategory(String maloai) throws Exception {
	  return ldao.getCategory(maloai);
  }
  
  public int addCategory(String maloai, String tenloai, String anh) throws Exception {
	  return ldao.addCategory(maloai, tenloai, anh);
  }
  
  public int deleteCategory(String maloai) throws Exception {
	  return ldao.deleteCategory(maloai);
  }
  
  public int editcategory(String maloai, String tenloai, String anh) throws Exception {
	  return ldao.editcategory(maloai, tenloai, anh);
  }
  
	public boolean checkDeleteCategory(String maloai) throws Exception {
		return ldao.checkDeleteCategory(maloai);
	}
	
}
