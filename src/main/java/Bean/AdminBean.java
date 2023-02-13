package Bean;

public class AdminBean {
	 private String TenDangNhap;
	  private String MatKhau;
	  private Boolean Quyen;
	public AdminBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminBean(String tenDangNhap, String matKhau, Boolean quyen) {
		super();
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		Quyen = quyen;
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
	public Boolean getQuyen() {
		return Quyen;
	}
	public void setQuyen(Boolean quyen) {
		Quyen = quyen;
	}
	
}
