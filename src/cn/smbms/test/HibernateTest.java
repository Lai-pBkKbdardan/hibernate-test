package cn.smbms.test;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.smbms.pojo.Emp;
import cn.smbms.pojo.User;
import cn.smbms.tools.HibernateUtil;

public class HibernateTest {

	/**
	 * 根据标识列查询用户
	 * */
	public User getUserById(Integer id){
		return (User) HibernateUtil.getSession().get(User.class, id);
	}
	
	/**
	 * 查询用户表所有信息
	 * @param name
	 * */
	public void getUserList(String name){
		//获取session
		Session session = HibernateUtil.getSession();
		//编写hql语句
		String hql = "from User where userName=:userName";
		//创建Query对象
		Query query = session.createQuery(hql);
		query.setParameter("userName", name);
		//执行操作
		List<User> users = query.list();
		//遍历对象集合
		for (User user : users) {
			System.out.println("==="+user.getUserCode());
		}
	}
	
	/**
	 * 根据对象属性值查询用户信息
	 * @param user
	 * */
	public void getUserList2(User user){
		//获取session
		Session session = HibernateUtil.getSession();
		//编写hql语句
		String hql = "from User where userName=:userName";
		//创建Query对象
		Query query = session.createQuery(hql);
		query.setProperties(user);
		//执行操作
		List<User> users = query.list();
		//遍历对象集合
		for (User user1 : users) {
			System.out.println("==="+user1.getUserCode());
		}
	}
	
	/**
	 * 根据对象属性值查询用户信息(分页)
	 * @param user
	 * */
	public void getUserListByIdPage(User user){
		//获取session
		Session session = HibernateUtil.getSession();
		//编写hql语句
		String hql = "from User where id>:id";
		//创建Query对象
		Query query = session.createQuery(hql);
		query.setProperties(user);
		query.setFirstResult(0);
		query.setMaxResults(4);
		//持久化操作
		List<User> userList = query.list();
		for (User user2 : userList) {
			System.out.println("===>"+user2.getId()+user2.getUserName());
		}
	}
	/**
	 * 总记录数
	 * */
	public void userListCount(User user){
		//获取session
		Session session = HibernateUtil.getSession();
		//编写hql
		String hql = "select count(id) from User where id>:id";
		//创建Query对象
		Query query = session.createQuery(hql);
		query.setProperties(user);
		//持久化操作
		Long result = (Long) query.uniqueResult();
		System.out.println("====>>>"+result);
	}
	/**
	 * 使用投影查询对象信息
	 * */
	public void getUserList(){
		//获取session
		Session session = HibernateUtil.getSession();
		//编写hql语句
		String hql = "select new User(id,userName) from User";
		//创建Query对象
		Query query = session.createQuery(hql);
		//持久化操作
		List<User> users = query.list();
		for (User user : users) {
			System.out.println("==="+user.getId()+"==="+user.getUserName());
		}
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		/**
		 * 根据标识列查询用户
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		User user = new HibernateTest().getUserById(8);
		tr.commit();
		System.out.println(user.getUserCode()+"=="+user.getUserName());*/
		
		/**
		 * 查询用户表所有信息
		 * @param name
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		test.getUserList("赵燕");
		tr.commit();*/
		
		/**
		 * 根据对象属性值查询用户信息
		 * @param user
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		User user = new User();
		user.setUserName("赵燕");
		test.getUserList2(user);
		tr.commit();*/
		
		/**
		 * 根据对象属性值查询用户信息(分页)
		 * @param user
		 * */
		/*Transaction tr = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		User user = new User();
		user.setId(1);
		test.getUserListByIdPage(user);
		tr.commit();*/
		
		/**
		 * 总记录数
		 * */
		/*Transaction tx = HibernateUtil.getSession().beginTransaction();
		HibernateTest test =new HibernateTest();
		User user = new User();
		user.setId(1);
		test.userListCount(user);*/
		
		/**
		 * 使用投影查询对象信息
		 * */
		Transaction tx = HibernateUtil.getSession().beginTransaction();
		HibernateTest test = new HibernateTest();
		test.getUserList();
		tx.commit();
		
	}
}
