package chucnang;

public class nhacungcapdata {
	private String manhacungcap;
	private String tennhacungcap;
	private String sodienthoainhacungcap;

	public nhacungcapdata(String manhacungcap, String tennhacungcap, String sodienthoainhacungcap) {
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

	public String getSodienthoainhacungcap() {
		return sodienthoainhacungcap;
	}
}
