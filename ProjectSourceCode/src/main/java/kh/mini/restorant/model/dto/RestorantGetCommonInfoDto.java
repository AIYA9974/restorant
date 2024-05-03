package kh.mini.restorant.model.dto;

public class RestorantGetCommonInfoDto {
	private String placeAlone;
	private String placeGroup;
	private String sitFloor;
	private String sitChair;
	private String standing;
	
	@Override
	public String toString() {
		return "RestorantGetCommonInfoDto [placeAlone=" + placeAlone + ", placeGroup=" + placeGroup + ", sitFloor="
				+ sitFloor + ", sitChair=" + sitChair + ", standing=" + standing + "]";
	}
	
	public RestorantGetCommonInfoDto(String placeAlone, String placeGroup, String sitFloor, String sitChair,
			String standing) {
		super();
		this.placeAlone = placeAlone;
		this.placeGroup = placeGroup;
		this.sitFloor = sitFloor;
		this.sitChair = sitChair;
		this.standing = standing;
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

