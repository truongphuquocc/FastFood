package Bean;

import java.util.Date;

public class LichSuMuaHangBean {
	private long MaHoaDon;
	private Date NgayMua;
	private String GhiChu;
	private String HoTen;
	private boolean Damua;
	private long ThanhTien;
	private long MaKhachHang;
	private String DiaChi;
	public LichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichSuMuaHangBean(long maHoaDon, Date ngayMua, String ghiChu, String hoTen, boolean damua, long thanhTien,
			long maKhachHang, String diaChi) {
		super();
		MaHoaDon = maHoaDon;
		NgayMua = ngayMua;
		GhiChu = ghiChu;
		HoTen = hoTen;
		Damua = damua;
		ThanhTien = thanhTien;
		MaKhachHang = maKhachHang;
		DiaChi = diaChi;
	}
	public long getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public Date getNgayMua() {
		return NgayMua;
	}
	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public boolean isDamua() {
		return Damua;
	}
	public void setDamua(boolean damua) {
		Damua = damua;
	}
	public long getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}
	public long getMaKhachHang() {
		return MaKhachHang;
	}
	public void setMaKhachHang(long maKhachHang) {
		MaKhachHang = maKhachHang;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
}
