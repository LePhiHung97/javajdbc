package entity;

public class Student {
	private byte masv;
	private String hoten;
	private int namsinh;
	private String lop;
	private Double diem;

	public byte getMasv() {
		return masv;
	}

	public void setMasv(byte masv) {
		this.masv = masv;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public int getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(int namsinh) {
		this.namsinh = namsinh;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public Double getDiem() {
		return diem;
	}

	public void setDiem(Double diem) {
		this.diem = diem;
	}

	@Override
	public String toString() {
		return this.masv + " - " + this.hoten + " - " + this.namsinh + " - " + this.lop + " - " + this.diem;
	}

}
