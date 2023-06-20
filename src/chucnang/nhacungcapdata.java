package chucnang;

public class nhacungcapdata {
	private String manhacungcap;
	private String tennhacungcap;
	private Integer sodienthoainhacungcap;

	public nhacungcapdata(String manhacungcap, String tennhacungcap, Integer sodienthoainhacungcap) {
		this.manhacungcap = manhacungcap;
		this.tennhacungcap = tennhacungcap;
		this.sodienthoainhacungcap = sodienthoainhacungcap;
	}

	public String getManhacungcap() {
		return manhacungcap;
	}

	public String getTennhacungcap() {
		return tennhacungcap;
	}

	public Integer getSodienthoainhacungcap() {
		return sodienthoainhacungcap;
	}
}
