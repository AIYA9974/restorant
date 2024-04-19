package kh.mini.restorant.model.dto;

public class OwnerDto {
	private String ownerCode;
	private String memCode;
	
	
	@Override
	public String toString() {
		return "OwnerDto [ownerCode=" + ownerCode + ", memCode=" + memCode + "]";
	}
	
	
	public OwnerDto(String ownerCode, String memCode) {
		super();
		this.ownerCode = ownerCode;
		this.memCode = memCode;
	}
	
	
	public String getOwnerCode() {
		return ownerCode;
	}
	public void setOwnerCode(String ownerCode) {
		this.ownerCode = ownerCode;
	}
	public String getMemCode() {
		return memCode;
	}
	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
	
	
}
