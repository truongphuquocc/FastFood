package Bean;

public class KhachHangBean {
  public long MaKhachHang;
  public String HoTen;
  public String DiaChi;
  public String SoDienThoai;
  public String Email;

  public long getMaKhachHang() {
    return MaKhachHang;
  }

  public void setMaKhachHang(long maKhachHang) {
    MaKhachHang = maKhachHang;
  }

  public String getHoTen() {
    return HoTen;
  }

  public void setHoTen(String hoTen) {
    HoTen = hoTen;
  }

  public String getDiaChi() {
    return DiaChi;
  }

  public void setDiaChi(String diaChi) {
    DiaChi = diaChi;
  }

  public String getSoDienThoai() {
    return SoDienThoai;
  }

  public void setSoDienThoai(String soDienThoai) {
    SoDienThoai = soDienThoai;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String email) {
    Email = email;
  }

  public String getTenDangNhap() {
    return TenDangNhap;
  }

  public void setTenDangNhap(String tenDangNhap) {
    TenDangNhap = tenDangNhap;
  }

  public String getMatKhau() {
    return MatKhau;
  }

  public void setMatKhau(String matKhau) {
    MatKhau = matKhau;
  }

  public String TenDangNhap;

  public KhachHangBean(long maKhachHang, String hoTen, String diaChi, String soDienThoai,
      String email, String tenDangNhap, String matKhau) {
    super();
    MaKhachHang = maKhachHang;
    HoTen = hoTen;
    DiaChi = diaChi;
    SoDienThoai = soDienThoai;
    Email = email;
    TenDangNhap = tenDangNhap;
    MatKhau = matKhau;
  }

  public String MatKhau;

  public KhachHangBean() {
    super();
    // TODO Auto-generated constructor stub
  }
}
