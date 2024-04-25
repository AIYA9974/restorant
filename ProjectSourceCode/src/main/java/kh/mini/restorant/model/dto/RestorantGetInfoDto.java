package kh.mini.restorant.model.dto;

public class RestorantGetInfoDto {
	private String resCode;
	private String resName;
	private Long resPhone;
	private Long resSubPhone;
	private String resEmail;
	private String resLocal;
	private String resMsg;
	
	
	@Override
	public String toString() {
		return "RestorantGetInfoDto [resCode=" + resCode + ", resName=" + resName + ", resPhone=" + resPhone
				+ ", resSubPhone=" + resSubPhone + ", resEmail=" + resEmail + ", resLocal=" + resLocal + ", resMsg="
				+ resMsg + "]";
	}
	
	
	public RestorantGetInfoDto(String resName, Long resPhone, Long resSubPhone, String resEmail, String resLocal,
			String resMsg) {
		super();
		this.resName = resName;
		this.resPhone = resPhone;
		this.resSubPhone = resSubPhone;
		this.resEmail = resEmail;
		this.resLocal = resLocal;
		this.resMsg = resMsg;
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
	public String getResLocal() {
		return resLocal;
	}
	public void setResLocal(String resLocal) {
		this.resLocal = resLocal;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}
	
	
	
	
}
//RESTORANT_CODE      NOT NULL VARCHAR2(20)   
//RESTORANT_NAME      NOT NULL NVARCHAR2(20)  
//RESTORANT_PHONE     NOT NULL NUMBER         
//RESTORANT_SUB_PHONE          VARCHAR2(255)  
//RESTORANT_EMAIL     NOT NULL VARCHAR2(30)   
//RESTORANT_LOCAL     NOT NULL NVARCHAR2(50)  
//RESTORANT_MESSAGE            NVARCHAR2(300) 


//이름                  널?       유형             
//------------------- -------- -------------- 
//OWNER_CODE          NOT NULL VARCHAR2(20)   
//RESTORANT_Kind      NOT NULL VARCHAR2(10)   
