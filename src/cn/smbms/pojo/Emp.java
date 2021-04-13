package cn.smbms.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Ô±¹¤
 * */
public class Emp {

	private int id;
	private String empName;
	private Set<Pro> pros = new HashSet<>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public Set<Pro> getPros() {
		return pros;
	}
	public void setPros(Set<Pro> pros) {
		this.pros = pros;
	}
	
}
