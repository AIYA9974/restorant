package kh.mini.restorant.model.dto;

public class MemberLoginDto {
	private String memCode;
	private String memId;
	private String memPassword;
	
	
	@Override
	public String toString() {
		return "MemberLoginDto [memCode=" + memCode + ", memId=" + memId + ", memPassword=" + memPassword + "]";
	}
	
	
	public MemberLoginDto(String memId, String memPassword) {
		super();
		
		this.memId = memId;
		this.memPassword = memPassword;
	}
	
	
	public String getMemCode() {
		return memCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	
	
}
//이름          널?       유형           
//----------- -------- ------------ 
//MEMBER_CODE NOT NULL VARCHAR2(20) 
//ID          NOT NULL VARCHAR2(30) 
//PASSWORD    NOT NULL VARCHAR2(30) 
//PHONE                NUMBER       
//EMAIL                VARCHAR2(30) 
