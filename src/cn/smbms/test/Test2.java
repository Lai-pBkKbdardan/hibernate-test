package cn.smbms.test;

import java.util.List;

import cn.smbms.pojo.Role;
import cn.smbms.pojo.User;
import cn.smbms.service.RoleService;
import cn.smbms.service.UserService;

public class Test2 {

	UserService userService = new UserService();
	RoleService roleService = new RoleService();
	
	/**
	 * get���������������ض���
	 * */
	public void findUserById(){
		User user = userService.findUserById(8);
		System.out.println("===="+user.getUserName());
	}
	
	/**
	 * ���ݶ�������ֵ��ѯ�û���Ϣ
	 * @param user
	 * */
	public void findByUser(){
		User user = new User();
		user.setUserName("���");
		List<User> userList = userService.findByUser(user);
		for (User user2 : userList) {
			System.out.println("===>"+user2.getUserCode());
		}
	}
	
	/**
	 * �����û����Բ�ѯ�û���Ϣ(��ҳ)
	 * @param user
	 * */
	public void getUserListPage(){
		User user = new User();
		user.setId(1);
		Integer pageIndex = 0;
		Integer pageSize = 4;
		List<User> userList = userService.getUserListPage(user, pageIndex, pageSize);
			for (User user2 : userList) {
				System.out.println("=="+user2.getUserName());
			}
	}
	
	/**
	 * ��ѯָ����ɫ�û�
	 * @param id
	 * */
	/*public void getRoleList(){
		Role role = new Role();
		role.setId(1);
		List<Role> roleList = roleService.getRoleList(role);
		for (Role role2 : roleList) {
			System.out.println(""+role2.getRoleName()+role2.getUsers());
		}
	}*/
	
	/**
	 * ���ݽ�ɫ��ѯ�û�
	 * */
	public void getUserListById(){
		User user = new User();
		user.setUserRole(2);
		List<User> userList = roleService.getUserListById(user.getId());
		for (User user2 : userList) {
			System.out.println("userName====="+user2.getUserName());
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		Test2 test = new Test2();
		//test.findUserById();
		//test.findByUser();
		//test.getUserListPage();
		test.getUserListById();
		System.out.println("ssss");
	}
}
