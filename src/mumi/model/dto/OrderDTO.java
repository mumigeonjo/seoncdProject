package mumi.model.dto;

public class OrderDTO {
	private int oIndexNo;
	private String pCode;
	private String memberID;
	private int oEA;
	private String oDate;
	private int oStatus;
	private String oAddr;
	private String oPhone;
	
	public OrderDTO() {}

	public OrderDTO(int oIndexNo, String pCode, String memberID, int oEA, String oDate, int oStatus, String oAddr, String oPhone) {
		super();
		this.oIndexNo = oIndexNo;
		this.pCode = pCode;
		this.memberID = memberID;
		this.oEA = oEA;
		this.oDate = oDate;
		this.oStatus = oStatus;
		this.oAddr = oAddr;
		this.oPhone = oPhone;
	}

	public int getoIndexNo() {
		return oIndexNo;
	}

	public void setoIndexNo(int oIndexNo) {
		this.oIndexNo = oIndexNo;
	}

	public String getpCode() {
		return pCode;
	}

	public void setpCode(String pCode) {
		this.pCode = pCode;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public int getoEA() {
		return oEA;
	}

	public void setoEA(int oEA) {
		this.oEA = oEA;
	}

	public String getoDate() {
		return oDate;
	}

	public void setoDate(String oDate) {
		this.oDate = oDate;
	}

	public String getoAddr() {
		return oAddr;
	}

	public void setoAddr(String oAddr) {
		this.oAddr = oAddr;
	}

	public String getoPhone() {
		return oPhone;
	}

	public void setoPhone(String oPhone) {
		this.oPhone = oPhone;
	}

	public int getoStatus() {
		return oStatus;
	}

	public void setoStatus(int oStatus) {
		this.oStatus = oStatus;
	}
	
}
