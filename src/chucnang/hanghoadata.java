package chucnang;

import java.math.BigDecimal;
import java.sql.Date;
public class hanghoadata {
	private String mahanghoa;
	private String tenhanghoa;
	private Integer soluongtrongkho;
	private BigDecimal giaban;
	//private Date ngayhethan;
	private Date ngaynhap;
	//private Integer soluongnhap;
	//private BigDecimal gianhap;
	//private Date ngaysanxuat;
	private String manhacungcap;
	
	private String donvi;
	private String image;

    public hanghoadata(String mahanghoa, String tenhanghoa, Integer soluongtrongkho, BigDecimal giaban/*, Date ngayhethan*/, Date ngaynhap /*, Integer soluongnhap, BigDecimal gianhap, Date ngaysanxuat*/, String manhacungcap, String donvi, String image) {
        this.mahanghoa = mahanghoa;
        this.tenhanghoa = tenhanghoa;
        this.soluongtrongkho = soluongtrongkho;
        this.giaban = giaban;
        //this.ngayhethan = ngayhethan;
        this.ngaynhap = ngaynhap;
        //this.soluongnhap = soluongnhap;
        //this.gianhap = gianhap;
        //this.ngaysanxuat = ngaysanxuat;
        this.manhacungcap = manhacungcap;
        this.donvi = donvi;
        this.image = image;
    }
    public hanghoadata(String mahanghoa, String tenhanghoa, Integer soluongtrongkho, BigDecimal giaban, String donvi, String image, Date ngaynhap) {
        this.mahanghoa = mahanghoa;
        this.tenhanghoa = tenhanghoa;
        this.soluongtrongkho = soluongtrongkho;
        this.giaban = giaban;
        this.donvi = donvi;
        this.image = image;
        this.ngaynhap=ngaynhap;
    }

    public String getMahanghoa() {
        return mahanghoa;
    }

    public String getTenhanghoa() {
        return tenhanghoa;
    }

    public Integer getSoluongtrongkho() {
        return soluongtrongkho;
    }

    public BigDecimal getGiaban() {
        return giaban;
    }

//    public Date getNgayhethan() {
//        return ngayhethan;
//    }

    public Date getNgaynhap() {
        return ngaynhap;
    }

//    public Integer getSoluongnhap() {
//        return soluongnhap;
//    }

//    public BigDecimal getGianhap() {
//        return gianhap;
//    }
//
//    public Date getNgaysanxuat() {
//        return ngaysanxuat;
//    }

    public String getManhacungcap() {
        return manhacungcap;
    }

    public String getDonvi() {
        return donvi;
    }

    public String getImage() {
        return image;
    }
	
	

}