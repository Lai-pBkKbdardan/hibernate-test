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
	 * get方法按照主键加载对象
	 * */
	public void findUserById(){
		User user = userService.findUserById(8);
		System.out.println("===="+user.getUserName());
	}
	
	/**
	 * 根据对象属性值查询用户信息
	 * @param user
	 * */
	public void findByUser(){
		User user = new User();
		user.setUserName("杨过");
		List<User> userList = userService.findByUser(user);
		for (User user2 : userList) {
			System.out.println("===>"+user2.getUserCode());
		}
	}
	
	/**
	 * 根据用户属性查询用户信息(分页)
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
	 * 查询指定角色用户
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
	 * 根据角色查询用户
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
