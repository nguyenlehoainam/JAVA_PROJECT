package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
	private int maSP;
	private String tenSP;
	private String dacTrung;
	private double gia;
	public Product() {
			}
	public Product(int maSP, String tenSP, String dacTrung, double gia) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.dacTrung = dacTrung;
		this.gia = gia;
	}
	public Product(String tenSP) {
		this.tenSP = tenSP;
	}
	public int getMaSP() {
		return maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public String getDacTrung() {
		return dacTrung;
	}
	public double getGia() {
		return gia;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public void setDacTrung(String dacTrung) {
		this.dacTrung = dacTrung;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP + ", DacTrung=" + dacTrung + ", gia=" + gia + "]";
	}

}
