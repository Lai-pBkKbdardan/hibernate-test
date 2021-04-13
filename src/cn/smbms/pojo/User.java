package cn.smbms.pojo;

/**
 * 用户实体类
 * */
public class User {

	private Integer id;
	private String userCode;
	private String userName;
	private Integer userRole;
	
	public Integer getUserRole() {
		return userRole;
	}
	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}
	public User(){}
	public User(Integer id,String userName){
		this.id = id;
		this.userName = userName;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
