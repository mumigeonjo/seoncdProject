package mumi.model.dto;

public class ReviewDTO {
	private int rIndexNo;
	private String pCode;
	private String memberId;
	private String rDate;
	private String rContent;
	private String rPhoto;
	private int rRate;
	
	public ReviewDTO() {}

	public ReviewDTO(int rIndexNo, String pCode, String memberId, String rDate, String rContent, String rPhoto,
			int rRate) {
		super();
		this.rIndexNo = rIndexNo;
		this.pCode = pCode;
		this.memberId = memberId;
		this.rDate = rDate;
		this.rContent = rContent;
		this.rPhoto = rPhoto;
		this.rRate = rRate;
	}

	public int getrIndexNo() {
		return rIndexNo;
	}

	public void setrIndexNo(int rIndexNo) {
		this.rIndexNo = rIndexNo;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getMemberID() {
		return memberId;
	}

	public void setMemberID(String memberID) {
		this.memberId = memberID;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrPhoto() {
		return rPhoto;
	}

	public void setrPhoto(String rPhoto) {
		this.rPhoto = rPhoto;
	}

	public int getrRate() {
		return rRate;
	}

	public void setrRate(int rRate) {
		this.rRate = rRate;
	}
	
}