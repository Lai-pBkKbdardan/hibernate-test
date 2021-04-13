package cn.smbms.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色表实体类
 * */
public class Role {

	private Integer id;//
	private String roleCode;//角色编码
	private String roleName;//角色名称
	private Set<User> users = new HashSet<User>();//角色用户集合
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
