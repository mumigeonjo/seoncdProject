package mumi.model.dto;

public class QADTO {
	private int bIndexNo;
	private String memberID;
	private String bCategory;
	private String bContent;
	private String bTitle;
	private String bDate;
	
	public QADTO() {}

	public QADTO(int bIndexNo, String memberID, String bCategory, String bContent, String bTitle, String bDate) {
		super();
		this.bIndexNo = bIndexNo;
		this.memberID = memberID;
		this.bCategory = bCategory;
		this.bContent = bContent;
		this.bTitle = bTitle;
		this.bDate = bDate;
	}

	public int getbIndexNo() {
		return bIndexNo;
	}

	public void setbIndexNo(int bIndexNo) {
		this.bIndexNo = bIndexNo;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getbCategory() {
		return bCategory;
	}

	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}
	
}
