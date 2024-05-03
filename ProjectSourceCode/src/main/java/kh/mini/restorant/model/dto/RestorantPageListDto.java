package kh.mini.restorant.model.dto;

public class RestorantPageListDto {
	private String resCode;
	private String resName;
	private String resPhone;
	private String resLoc;
	
	@Override
	public String toString() {
		return "RestorantPageListDto [resCode=" + resCode + ", resName=" + resName + ", resPhone=" + resPhone
				+ ", resLoc=" + resLoc + "]";
	}
	
	public RestorantPageListDto(String resCode, String resName, String resPhone, String resLoc) {
		super();
		this.resCode = resCode;
		this.resName = resName;
		this.resPhone = resPhone;
		this.resLoc = resLoc;
	}
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResPhone() {
		return resPhone;
	}
	public void setResPhone(String resPhone) {
		this.resPhone = resPhone;
	}
	public String getResLoc() {
		return resLoc;
	}
	public void setResLoc(String resLoc) {
		this.resLoc = resLoc;
	}
	
	
}
//RESTORANT_CODE      NOT NULL VARCHAR2(20)   
//OWNER_CODE          NOT NULL VARCHAR2(20)   
//RESTORANT_NAME      NOT NULL NVARCHAR2(20)  
//RESTORANT_PHONE     NOT NULL NUMBER         
//RESTORANT_SUB_PHONE          NUMBER         
//RESTORANT_EMAIL     NOT NULL VARCHAR2(30)   
//RESTORANT_LOCAL     NOT NULL NVARCHAR2(50)  
//RESTORANT_MESSAGE            NVARCHAR2(300) 
//RESTORANT_KIND      NOT NULL VARCHAR2(10)  