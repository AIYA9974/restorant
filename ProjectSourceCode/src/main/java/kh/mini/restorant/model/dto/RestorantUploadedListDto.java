package kh.mini.restorant.model.dto;

public class RestorantUploadedListDto {
	private String resCode;
	private String resName;
	private String resLoc;
	private String resKind;
	
	@Override
	public String toString() {
		return "RestorantUploadedListDto [resCode=" + resCode + ", resName=" + resName + ", resLoc=" + resLoc
				+ ", resKind=" + resKind + "]";
	}
	
	public RestorantUploadedListDto(String resCode, String resName, String resLoc, String resKind) {
		super();
		this.resCode = resCode;
		this.resName = resName;
		this.resLoc = resLoc;
		this.resKind = resKind;
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
	public String getResLoc() {
		return resLoc;
	}
	public void setResLoc(String resLoc) {
		this.resLoc = resLoc;
	}
	public String getResKind() {
		return resKind;
	}
	public void setResKind(String resKind) {
		this.resKind = resKind;
	}
	
}


//RESTORANT_CODE      NOT NULL VARCHAR2(20) 
//RESTORANT_NAME      NOT NULL NVARCHAR2(20)  
//RESTORANT_LOCAL     NOT NULL NVARCHAR2(50)  
//RESTORANT_AREA      NOT NULL VARCHAR2(10)  


//이름                  널?       유형             
//------------------- -------- -------------- 
  
//OWNER_CODE          NOT NULL VARCHAR2(20)   

//RESTORANT_PHONE     NOT NULL NUMBER         
//RESTORANT_SUB_PHONE          VARCHAR2(255)  
//RESTORANT_EMAIL     NOT NULL VARCHAR2(30)   

//RESTORANT_MESSAGE            NVARCHAR2(300) 
 
 