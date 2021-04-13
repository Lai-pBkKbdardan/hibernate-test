package cn.smbms.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * ÏîÄ¿
 * */
public class Pro {

	private int id;
	private String proName;
	private Set<Emp> emps = new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Set<Emp> getEmps() {
		return emps;
	}
	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}
	
}
