package chucnang;

import java.math.BigDecimal;
import java.sql.Date;

public class hoadondata {

	private Integer mahoadon;
	private BigDecimal giatien;
	private Integer soluongban;
	private Date ngayxuathoadon;
	private String sodienthoai;
	private String manhanvien;
	private String phuongthuc;
	private String mahanghoa;
	private String tenhanghoa;
	private String tenkhachhang;
	
	public hoadondata(Integer mahoadon, BigDecimal giatien, Integer soluongban, Date ngayxuathoadon, String sodienthoai,
			String manhanvien,String phuongthuc,String mahanghoa,String tenhanghoa) {
		
		this.mahoadon = mahoadon;
		this.giatien = giatien;
		this.soluongban = soluongban;
		this.ngayxuathoadon = ngayxuathoadon;
		this.sodienthoai = sodienthoai;
		this.manhanvien = manhanvien;
		this.phuongthuc=phuongthuc;
		this.mahanghoa=mahanghoa;
		this.tenhanghoa=tenhanghoa;
	}

	public hoadondata(BigDecimal giatien, Integer soluongban, Date ngayxuathoadon, String sodienthoai, String manhanvien, String phuongthuc) {
        this.giatien = giatien;
        this.soluongban = soluongban;
        this.ngayxuathoadon = ngayxuathoadon;
        this.sodienthoai = sodienthoai;
        this.manhanvien = manhanvien;
        this.phuongthuc = phuongthuc;
    }
	
	
	public String getPhuongthuc() {
		return phuongthuc;
		
	}
	public String getMahanghoa() {
		return mahanghoa;
	}
	public String getTenhanghoa() {
		return tenhanghoa;
	}
	
	 public Integer getMahoadon() {
	        return mahoadon;
	    }


    public BigDecimal getGiatien() {
        return giatien;
    }

    public int getSoluongban() {
        return soluongban;
    }

    public Date getNgayxuathoadon() {
        return ngayxuathoadon;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public String getManhanvien() {
        return manhanvien;
    }
        
	
}
