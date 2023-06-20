package chucnang;

public class nhanviendata {

	private String manhanvien;
	private String hovaten;
	private String sodienthoai;
	private String gioitinh;
	private String diachi;
	private String password;
	
	public nhanviendata(String manhanvien, String hovaten, String sodienthoai, String gioitinh, String diachi, String password) {
        this.manhanvien = manhanvien;
        this.hovaten = hovaten;
        this.sodienthoai = sodienthoai;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.password = password;
    }

    public String getManhanvien() {
        return manhanvien;
    }

    public String getHovaten() {
        return hovaten;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getPassword() {
        return password;
    }
}
