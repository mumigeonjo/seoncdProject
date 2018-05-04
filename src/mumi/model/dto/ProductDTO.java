package mumi.model.dto;

public class ProductDTO {
	private int pCode;
	private String pName;
	private int pPrice;
	private String pSize;
	private String pDate;
	private int pEA;
	private String pImage;
	private String pDetailImage;
	
	public ProductDTO() {}

	public ProductDTO(int pCode, String pName, int pPrice, String pSize, String pDate, int pEA, String pImage,
			String pDetailImage) {
		super();
		this.pCode = pCode;
		this.pName = pName;
		this.pPrice = pPrice;
		this.pSize = pSize;
		this.pDate = pDate;
		this.pEA = pEA;
		this.pImage = pImage;
		this.pDetailImage = pDetailImage;
	}

	public int getpCode() {
		return pCode;
	}

	public void setpCode(int pCode) {
		this.pCode = pCode;
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

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getpDate() {
		return pDate;
	}

	public void setpDate(String pDate) {
		this.pDate = pDate;
	}

	public int getpEA() {
		return pEA;
	}

	public void setpEA(int pEA) {
		this.pEA = pEA;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public String getpDetailImage() {
		return pDetailImage;
	}

	public void setpDetailImage(String pDetailImage) {
		this.pDetailImage = pDetailImage;
	}
	
}