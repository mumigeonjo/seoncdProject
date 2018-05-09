package mumi.model.dto;

public class QADTO {
	private int bIndexNo;
	private String memberID;
	private int bCategory;
	private String bContent;
	private String bTitle;
	private String bDate;
	private int bHasDate;

	public QADTO() {
	}
	
	
	public QADTO(String memberID, int categoryNo, String bContent, String bTitle) {
		this.memberID = memberID;
		this.bCategory = categoryNo;
		this.bContent = bContent;
		this.bTitle = bTitle;
	}
	public QADTO(int bIndexNo, String memberID, int categoryNo, String bContent, String bTitle) {
		
		this(memberID,categoryNo,bContent,bTitle);
		this.bIndexNo = bIndexNo;
		
		
	}
	
	public QADTO(int bIndexNo, String memberID, int bCategory, String bContent, String bTitle, String bDate,int bHasDate) {
		this(bIndexNo,memberID,bCategory,bContent,bTitle);
		this.bDate = bDate;
		this.bHasDate=bHasDate;
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

	public int getbCategory() {
		return bCategory;
	}

	public void setbCategory(int bCategory) {
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


	public int getbHasDate() {
		return bHasDate;
	}


	public void setbHasDate(int bHasDate) {
		this.bHasDate = bHasDate;
	}
}