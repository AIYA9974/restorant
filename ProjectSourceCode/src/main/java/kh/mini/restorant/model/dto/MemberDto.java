package kh.mini.restorant.model.dto;

public class MemberDto {
	private String memCode;
	private String memId;
	private String memPassword;
	private int memPhone;
	private String memEmail;

	@Override
	public String toString() {
		return "MemberDto [memCode=" + memCode + ", memId=" + memId + ", memPassword=" + memPassword + ", memPhone="
				+ memPhone + ", memEmail=" + memEmail + "]";
	}

	public MemberDto(String memId, String memPassword, int memPhone, String memEmail) {
		super();
		this.memId = memId;
		this.memPassword = memPassword;
		this.memPhone = memPhone;
		this.memEmail = memEmail;
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

	public int getMemPhone() {
		return memPhone;
	}

	public void setMemPhone(int memPhone) {
		this.memPhone = memPhone;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

}
//이름          널?       유형           
//----------- -------- ------------ 
//MEMBER_CODE NOT NULL VARCHAR2(20) 
//ID          NOT NULL VARCHAR2(30) 
//PASSWORD    NOT NULL VARCHAR2(30) 
//PHONE                NUMBER       
//EMAIL                VARCHAR2(30) 
