package mumi.model.dto;

public class QAReplyDTO {
	private int qIndexNo;
	private int bIndexNo;
	private String qDate;
	private String qContent;
	
	public QAReplyDTO() {}

	public QAReplyDTO(int qIndexNo, int bIndexNo, String qDate, String qContent) {
		super();
		this.qIndexNo = qIndexNo;
		this.bIndexNo = bIndexNo;
		this.qContent = qContent;
		this.qDate = qDate;
	}

	public int getqIndexNo() {
		return qIndexNo;
	}

	public void setqIndexNo(int qIndexNo) {
		this.qIndexNo = qIndexNo;
	}

	public int getbIndexNo() {
		return bIndexNo;
	}

	public void setbIndexNo(int bIndexNo) {
		this.bIndexNo = bIndexNo;
	}

	public String getqContent() {
		return qContent;
	}

	public void setqContent(String qContent) {
		this.qContent = qContent;
	}

	public String getqDate() {
		return qDate;
	}

	public void setqDate(String qDate) {
		this.qDate = qDate;
	}
	
}