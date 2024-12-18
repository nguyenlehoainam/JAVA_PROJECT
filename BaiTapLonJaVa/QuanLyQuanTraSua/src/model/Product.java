package model;

import java.io.Serializable;

public class Product implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int maSP;
	private String tenSP;
	private double gia;
	public Product() {
			}
	public Product(int maSP, String tenSP, double gia) {
		this.maSP = maSP;
		this.tenSP = tenSP;
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
	
	public double getGia() {
		return gia;
	}
	public void setMaSP(int maSP) {
		this.maSP = maSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}
	@Override
	public String toString() {
		return "SanPham [maSP=" + maSP + ", tenSP=" + tenSP  + ", gia=" + gia + "]";
	}

}
