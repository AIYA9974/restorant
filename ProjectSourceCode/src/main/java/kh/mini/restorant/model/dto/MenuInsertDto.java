package kh.mini.restorant.model.dto;

public class MenuInsertDto {
	private String resCode;
	private String menuName;
	private String menuInfo;
	
	public MenuInsertDto() {
		super();
	}

	public MenuInsertDto(String resCode, String menuName, String menuInfo) {
		super();
		this.resCode = resCode;
		this.menuName = menuName;
		this.menuInfo = menuInfo;
	}

	@Override
	public String toString() {
		return "MenuInsertDto [resCode=" + resCode + ", menuName=" + menuName + ", menuInfo=" + menuInfo + "]";
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
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
