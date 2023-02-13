package Bean;

import java.util.Date;

public class ChiTietLichSuMuaHangBean {

	private long MaChiTietHoaDon;
	private long SoLuongMua;
	private boolean DaMua;
	private long MaHoaDon;
	private String HoTen;
	private long Gia;
	private String TenMonAn;
	private Date NgayMua;
	private String Anh;
	private long ThanhTien;

	public ChiTietLichSuMuaHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietLichSuMuaHangBean(long maChiTietHoaDon, long soLuongMua, boolean daMua, long maHoaDon, String hoTen,
			long gia, String tenMonAn, Date ngayMua, String anh, long thanhTien) {
		super();
		MaChiTietHoaDon = maChiTietHoaDon;
		SoLuongMua = soLuongMua;
		DaMua = daMua;
		MaHoaDon = maHoaDon;
		HoTen = hoTen;
		Gia = gia;
		TenMonAn = tenMonAn;
		NgayMua = ngayMua;
		Anh = anh;
		ThanhTien = thanhTien;
	}

	public Date getNgayMua() {
		return NgayMua;
	}

	public void setNgayMua(Date ngayMua) {
		NgayMua = ngayMua;
	}

	public String getAnh() {
		return Anh;
	}

	public void setAnh(String anh) {
		Anh = anh;
	}

	public long getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(long thanhTien) {
		ThanhTien = thanhTien;
	}

	public long getMaChiTietHoaDon() {
		return MaChiTietHoaDon;
	}

	public void setMaChiTietHoaDon(long maChiTietHoaDon) {
		MaChiTietHoaDon = maChiTietHoaDon;
	}

	public long getSoLuongMua() {
		return SoLuongMua;
	}

	public void setSoLuongMua(long soLuongMua) {
		SoLuongMua = soLuongMua;
	}

	public boolean isDaMua() {
		return DaMua;
	}

	public void setDaMua(boolean daMua) {
		DaMua = daMua;
	}

	public long getMaHoaDon() {
		return MaHoaDon;
	}

	public void setMaHoaDon(long maHoaDon) {
		MaHoaDon = maHoaDon;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public long getGia() {
		return Gia;
	}

	public void setGia(long gia) {
		Gia = gia;
	}

	public String getTenMonAn() {
		return TenMonAn;
	}

	public void setTenMonAn(String tenMonAn) {
		TenMonAn = tenMonAn;
	}

}
