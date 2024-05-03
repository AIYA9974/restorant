package kh.mini.restorant.model.dto;

public class RestorantCommonInfoDto {
	private String resCode;
	private String placeAlone;
	private String placeGroup;
	private String sitFloor;
	private String sitChair;
	private String standing;
	
	
	@Override
	public String toString() {
		return "RestorantInfoDto [resCode=" + resCode + ", placeAlone=" + placeAlone + ", placeGroup=" + placeGroup
				+ ", sitFloor=" + sitFloor + ", sitChair=" + sitChair + ", standing=" + standing + "]";
	}
	
	
	public RestorantCommonInfoDto(String resCode, String placeAlone, String placeGroup, String sitFloor, String sitChair,
			String standing) {
		super();
		this.resCode = resCode;
		this.placeAlone = placeAlone;
		this.placeGroup = placeGroup;
		this.sitFloor = sitFloor;
		this.sitChair = sitChair;
		this.standing = standing;
	}
	
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public String getPlaceAlone() {
		return placeAlone;
	}
	public void setPlaceAlone(String placeAlone) {
		this.placeAlone = placeAlone;
	}
	public String getPlaceGroup() {
		return placeGroup;
	}
	public void setPlaceGroup(String placeGroup) {
		this.placeGroup = placeGroup;
	}
	public String getSitFloor() {
		return sitFloor;
	}
	public void setSitFloor(String sitFloor) {
		this.sitFloor = sitFloor;
	}
	public String getSitChair() {
		return sitChair;
	}
	public void setSitChair(String sitChair) {
		this.sitChair = sitChair;
	}
	public String getStanding() {
		return standing;
	}
	public void setStanding(String standing) {
		this.standing = standing;
	}
	
	
	
		
}
//이름             널?       유형           
//-------------- -------- ------------ 
//RESTORANT_CODE NOT NULL VARCHAR2(20) 
//PLACE_ALONE             CHAR(1)      
//PLACE_GROUP             CHAR(1)      
//SIT_FLOOR               CHAR(1)      
//SIT_CHAIR               CHAR(1)      
//STANDING                CHAR(1)      
