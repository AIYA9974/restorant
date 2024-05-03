package kh.mini.restorant.model.dto;

public class MenuSelectAllDto {
	private String menuNum;
	private String menuName;
	private String menuInfo;
	@Override
	public String toString() {
		return "MenuSelectAllDto [menuNum=" + menuNum + ", menuName=" + menuName + ", menuInfo=" + menuInfo + "]";
	}
	public MenuSelectAllDto(String menuNum, String menuName, String menuInfo) {
		super();
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
	}
	public String getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(String menuNum) {
		this.menuNum = menuNum;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuInfo() {
		return menuInfo;
	}
	public void setMenuInfo(String menuInfo) {
		this.menuInfo = menuInfo;
	}
	
	
}
