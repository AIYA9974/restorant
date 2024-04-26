package kh.mini.restorant.model.dto;

public class RestorantDeleteDto {
	private String resCode;

	@Override
	public String toString() {
		return "RestorantDeleteDto [resCode=" + resCode + "]";
	}

	public RestorantDeleteDto(String resCode) {
		super();
		this.resCode = resCode;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
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
