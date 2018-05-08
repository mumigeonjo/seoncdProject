package mumi.model.dto;

/**
 * ��ٱ��� DTO
 */

public class CartDTO extends OrderDTO{
	private String pName;
	private int pPrice;
	
	public CartDTO() {}

	//for insert
	public CartDTO(int oIndexNo, String pCode, String memberID, int oEA, String oDate, int oStatus, String oAddr,
			String oPhone, String pName, int pPrice) {
		super(oIndexNo, pCode, memberID, oEA, oDate, oStatus, oAddr, oPhone);
		this.pName=pName;
		this.pPrice=pPrice;
	}
	
	//for read
	public CartDTO(int oIndexNo, String pName, int pPrice) {
		super.setoIndexNo(oIndexNo);
		this.pName=pName;
		this.pPrice=pPrice;
	}
	
	//���� ���� ��¿�
	public CartDTO(String oDate, String pNname, int oEA, int pPrice, String oAddr) {
		super.setoDate(oDate);
		this.pName=pName;
		super.setoEA(oEA);
		this.pPrice=pPrice;
		super.setoAddr(oAddr);
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
}
