package model;

import java.io.Serializable;
import java.util.Objects;

public class Bill implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maHD;
	private String ten;
	private int SDT;
	private String email;
	private String ngayDat;
	private double tongTien;
	
	public static int n = 1;

	public Bill() {
	}

	public Bill(int maHD, String ten, int sDT, String email, String ngayDat, double tongTien) {
		this.maHD = maHD + n;
		this.ten = ten;
		SDT = sDT;
		this.email = email;
		this.ngayDat = ngayDat;
		this.tongTien = tongTien;
		 n++ ;
	}

	public int getMaHD() {
		return maHD;
	}

	public String getTen() {
		return ten;
	}

	public int getSDT() {
		return SDT;
	}

	public String getEmail() {
		return email;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public double getTongTien() {
		return tongTien;
	}

	public static int getN() {
		return n;
	}

	public void setMaHD(int maHD) {
		this.maHD = maHD;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public void setSDT(int sDT) {
		SDT = sDT;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}


	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ten=" + ten + ", SDT=" + SDT + ", email=" + email + ", ngayDat=" + ngayDat
				+ ", tongTien=" + tongTien + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(SDT, email, maHD, ngayDat, ten, tongTien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bill other = (Bill) obj;
		return SDT == other.SDT && Objects.equals(email, other.email) && maHD == other.maHD
				&& Objects.equals(ngayDat, other.ngayDat) && Objects.equals(ten, other.ten)
				&& Double.doubleToLongBits(tongTien) == Double.doubleToLongBits(other.tongTien);
	} 
	
}
