package kh.mini.restorant.model.dto;

public class CreateMenuDto {
	private String resCode;
	private int menuNum;
	private String menuName;
	private String menuImage;
	private String menuComment;
	
	
	@Override
	public String toString() {
		return "CreateMenuDto [resCode=" + resCode + ", menuNum=" + menuNum + ", menuName=" + menuName + ", menuImage="
				+ menuImage + ", menuComment=" + menuComment + "]";
	}
	
	
	public CreateMenuDto(String resCode, int menuNum, String menuName, String menuImage, String menuComment) {
		super();
		this.resCode = resCode;
		this.menuNum = menuNum;
		this.menuName = menuName;
		this.menuImage = menuImage;
		this.menuComment = menuComment;
	}
	
	
	public String getResCode() {
		return resCode;
	}
	public void setResCode(String resCode) {
		this.resCode = resCode;
	}
	public int getMenuNum() {
		return menuNum;
	}
	public void setMenuNum(int menuNum) {
		this.menuNum = menuNum;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getMenuComment() {
		return menuComment;
	}
	public void setMenuComment(String menuComment) {
		this.menuComment = menuComment;
	}
	
	
}

//CREATE TABLE "MENU" (
//		"RESTORANT_CODE"	VARCHAR2(20)		NOT NULL,
//		"MENU_NUM"	        NUMBER		        NOT NULL,
//		"MENU_NAME"     	VARCHAR2(10)		NOT NULL,
//		"MENU_IMAGE"	    VARCHAR2(10)		NULL,
//		"MENU_COMMENT"	    VARCHAR2(50)		NULL
//	);