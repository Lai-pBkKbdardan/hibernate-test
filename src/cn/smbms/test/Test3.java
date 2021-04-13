package cn.smbms.test;

import cn.smbms.service.EmpProService;

public class Test3 {

	
	public static void main(String[] args) {
		EmpProService empPro = new EmpProService();
		//根据员工查询项目
		empPro.getProByEmp(1);
	}
	
	
}
