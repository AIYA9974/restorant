package kh.mini.restorant.model.dto;

public class RestorantDto {
	private String resCode;
	private String ownerCode;
	private String resName;
	private Long resPhone;
	private Long resSubPhone;
	private String resEmail;
	private String resLoc;
	private String resMsg;
	private String memCode;
	private String resKind;
	
	
	@Override
	public String toString() {
		return "RestorantDto [resCode=" + resCode + ", ownerCode=" + ownerCode + ", resName=" + resName + ", resPhone="
				+ resPhone + ", resSubPhone=" + resSubPhone + ", resEmail=" + resEmail + ", resLoc=" + resLoc
				+ ", resMsg=" + resMsg + ", memCode=" + memCode + ", resKind=" + resKind + "]";
	}
	public RestorantDto(String ownerCode, String resName, Long resPhone, Long resSubPhone, String resEmail, String resLoc,
			String resMsg, String resKind) {
		super();
		this.ownerCode = ownerCode;
		this.resName = resName;
		this.resPhone = resPhone;
		this.resSubPhone = resSubPhone;
		this.resEmail = resEmail;
		this.resLoc = resLoc;
		this.resMsg = resMsg;
		this.resKind = resKind;
	}
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public Long getResPhone() {
		return resPhone;
	}
	public void setResPhone(Long resPhone) {
		this.resPhone = resPhone;
	}
	public Long getResSubPhone() {
		return resSubPhone;
	}
	public void setResSubPhone(Long resSubPhone) {
		this.resSubPhone = resSubPhone;
	}
	public String getResEmail() {
		return resEmail;
	}
	public void setResEmail(String resEmail) {
		this.resEmail = resEmail;
	}
	public String getResLoc() {
		return resLoc;
	}
	public void setResLoc(String resLoc) {
		this.resLoc = resLoc;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	public String getMemCode() {
		return memCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	public String getResKind() {
		return resKind;
	}
	public void setResKind(String resKind) {
		this.resKind = resKind;
	}
	
	
	
}

//이름                  널?       유형             
//------------------- -------- -------------- 
//RESTORANT_CODE      NOT NULL VARCHAR2(20)   
//OWNER_CODE          NOT NULL VARCHAR2(20)   
//RESTORANT_NAME      NOT NULL NVARCHAR2(20)  
//RESTORANT_PHONE     NOT NULL NUMBER         
//RESTORANT_SUB_PHONE          VARCHAR2(255)  
//RESTORANT_EMAIL     NOT NULL VARCHAR2(30)   
//RESTORANT_LOCAL     NOT NULL NVARCHAR2(50)  
//RESTORANT_MESSAGE            NVARCHAR2(300) 
//MEMBER_CODE         NOT NULL VARCHAR2(20)   
//RESTORANT_AREA      NOT NULL VARCHAR2(10)   

