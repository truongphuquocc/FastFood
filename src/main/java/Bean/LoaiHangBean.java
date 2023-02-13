package Bean;

public class LoaiHangBean {
  private String MaLoai;
  private String TenLoai;
  private String AnhLoai;

  public String getAnhLoai() {
    return AnhLoai;
  }

  public void setAnhLoai(String anhLoai) {
    AnhLoai = anhLoai;
  }

  public LoaiHangBean(String maLoai, String tenLoai, String anhLoai) {
    super();
    MaLoai = maLoai;
    TenLoai = tenLoai;
    AnhLoai = anhLoai;
  }

  public LoaiHangBean(String maLoai, String tenLoai) {
    super();
    MaLoai = maLoai;
    TenLoai = tenLoai;
  }

  public String getMaLoai() {
    return MaLoai;
  }

  public void setMaLoai(String maLoai) {
    MaLoai = maLoai;
  }

  public String getTenLoai() {
    return TenLoai;
  }

  public void setTenLoai(String tenLoai) {
    TenLoai = tenLoai;
  }

  public LoaiHangBean() {
    super();
    // TODO Auto-generated constructor stub
  }
}
