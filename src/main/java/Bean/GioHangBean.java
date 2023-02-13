package Bean;

public class GioHangBean {
	private String MaMonAn;
	private String TenMonAn;
	private String Anh;
	private long Gia;
	private long SoLuong;
	private long ThanhTien;
	public GioHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GioHangBean(String maMonAn, String tenMonAn, String anh, long gia, long soLuong) {
		super();
		MaMonAn = maMonAn;
		TenMonAn = tenMonAn;
		Anh = anh;
		Gia = gia;
		SoLuong = soLuong;
		ThanhTien = soLuong * gia;
	}
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
	public String getAnh() {
		return Anh;
	}
	public void setAnh(String anh) {
		Anh = anh;
	}
	public long getGia() {
		return Gia;
	}
	public void setGia(long gia) {
		Gia = gia;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	public long getThanhTien() {
		return SoLuong * Gia;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	
}
