package cn.smbms.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * ��ɫ��ʵ����
 * */
public class Role {

	private Integer id;//
	private String roleCode;//��ɫ����
	private String roleName;//��ɫ����
	private Set<User> users = new HashSet<User>();//��ɫ�û�����
	
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
