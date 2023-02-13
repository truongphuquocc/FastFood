package Bean;

import java.util.Date;

public class MonAnBean {
  private String MaMonAn;
  private String TenMonAn;
  private long SoLuong;
  private long Gia;
  private String MaLoai;
  private String Anh;

  public String getMaMonAn() {
    return MaMonAn;
  }

  public void setMaMonAn(String maMonAn) {
    MaMonAn = maMonAn;
  }

  public String getTenMonAn() {
    return TenMonAn;
  }

  public void setTenMonAn(String tenMonAn) {
    TenMonAn = tenMonAn;
  }

  public long getSoLuong() {
    return SoLuong;
  }

  public void setSoLuong(long soLuong) {
    SoLuong = soLuong;
  }

  public long getGia() {
    return Gia;
  }

  public void setGia(long gia) {
    Gia = gia;
  }

  public String getMaLoai() {
    return MaLoai;
  }

  public void setMaLoai(String maLoai) {
    MaLoai = maLoai;
  }

  public String getAnh() {
    return Anh;
  }

  public void setAnh(String anh) {
    Anh = anh;
  }

  public Date getNgayNhap() {
    return NgayNhap;
  }

  public void setNgayNhap(Date ngayNhap) {
    NgayNhap = ngayNhap;
  }

  public MonAnBean(String maMonAn, String tenMonAn, long soLuong, long gia, String maLoai,
      String anh, Date ngayNhap) {
    super();
    MaMonAn = maMonAn;
    TenMonAn = tenMonAn;
    SoLuong = soLuong;
    Gia = gia;
    MaLoai = maLoai;
    Anh = anh;
    NgayNhap = ngayNhap;
  }

  private Date NgayNhap;

  public MonAnBean() {
    super();
    // TODO Auto-generated constructor stub
  }
}
