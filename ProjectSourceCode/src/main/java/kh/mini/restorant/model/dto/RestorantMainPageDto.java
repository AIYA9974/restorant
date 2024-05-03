package kh.mini.restorant.model.dto;

public class RestorantMainPageDto {
	private String resName;
	private Long resPhone;
	private Long resSubPhone;
	private String resEmail;
	private String resLoc;
	private String resMsg;
	@Override
	public String toString() {
		return "RestorantMainDto [resName=" + resName + ", resPhone=" + resPhone + ", resSubPhone=" + resSubPhone
				+ ", resEmail=" + resEmail + ", resLoc=" + resLoc + ", resMsg=" + resMsg + "]";
	}
	
	public RestorantMainPageDto(String resName, Long resPhone, Long resSubPhone, String resEmail, String resLoc,
			String resMsg) {
		super();
		this.resName = resName;
		this.resPhone = resPhone;
		this.resSubPhone = resSubPhone;
		this.resEmail = resEmail;
		this.resLoc = resLoc;
		this.resMsg = resMsg;
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
	

}
//RESTORANT_NAME      NOT NULL NVARCHAR2(20)  
//RESTORANT_PHONE     NOT NULL NUMBER         
//RESTORANT_SUB_PHONE          VARCHAR2(255)  
//RESTORANT_EMAIL     NOT NULL VARCHAR2(30)   
//RESTORANT_LOCAL     NOT NULL NVARCHAR2(50)  
//RESTORANT_MESSAGE            NVARCHAR2(300) 
//이름                  널?       유형             
//------------------- -------- -------------- 
//RESTORANT_CODE      NOT NULL VARCHAR2(20)   
//OWNER_CODE          NOT NULL VARCHAR2(20)   
//RESTORANT_KIND    NOT NULL VARCHAR2(10)   
