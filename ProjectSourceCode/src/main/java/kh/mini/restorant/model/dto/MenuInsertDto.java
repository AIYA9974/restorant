package kh.mini.restorant.model.dto;

public class MenuInsertDto {
	private String menuNum;
	private String menuName;
	private String menuInfo;
	
	public MenuInsertDto() {
		super();
	}
	public MenuInsertDto(String menuNum, String menuName, String menuInfo) {
		super();
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
	}
	@Override
	public String toString() {
		return "MenuInsertDto [menuNum=" + menuNum + ", menuName=" + menuName + ", menuInfo=" + menuInfo + "]";
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
