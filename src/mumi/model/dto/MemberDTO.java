package mumi.model.dto;

public class MemberDTO {
	private String memberID;
	private String pwd;
	private String name;
	private String phone;
	private String Addr;
	private int isMGR;
	
	public MemberDTO() {}
	
	public MemberDTO(String memberID, String pwd, String name, String phone, String addr, int isMGR) {
		super();
		this.memberID = memberID;
		this.pwd = pwd;
		this.name = name;
		this.phone = phone;
		Addr = addr;
		this.isMGR = isMGR;
	}
	
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return Addr;
	}
	public void setAddr(String addr) {
		Addr = addr;
	}
	public int getIsMGR() {
		return isMGR;
	}
	public void setIsMGR(int isMGR) {
		this.isMGR = isMGR;
	}
	
<<<<<<< HEAD
}
=======
}
>>>>>>> branch 'master' of https://github.com/mumigeonjo/seoncdProject.git
