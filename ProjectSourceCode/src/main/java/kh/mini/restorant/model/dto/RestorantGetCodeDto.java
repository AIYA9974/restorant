package kh.mini.restorant.model.dto;

public class RestorantGetCodeDto {
	private String resName;
	private Long resPhone;
	
	
	@Override
	public String toString() {
		return "RestorantGetCodeFuntion [resName=" + resName + ", resPhone=" + resPhone + "]";
	}
	
	
	public RestorantGetCodeDto(String resName, Long resPhone) {
		super();
		this.resName = resName;
		this.resPhone = resPhone;
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
	
}
//RESTORANT_NAME      NOT NULL NVARCHAR2(20)  
//RESTORANT_PHONE     NOT NULL NUMBER         

//이름                  널?       유형             
//------------------- -------- -------------- 
//RESTORANT_CODE      NOT NULL VARCHAR2(20)   
//OWNER_CODE          NOT NULL VARCHAR2(20)   
//RESTORANT_SUB_PHONE          VARCHAR2(255)  
//RESTORANT_LOCAL     NOT NULL NVARCHAR2(50)  
//RESTORANT_EMAIL     NOT NULL VARCHAR2(30)   
//RESTORANT_MESSAGE            NVARCHAR2(300) 
//MEMBER_CODE         NOT NULL VARCHAR2(20)   
//RESTORANT_AREA      NOT NULL VARCHAR2(10)   
