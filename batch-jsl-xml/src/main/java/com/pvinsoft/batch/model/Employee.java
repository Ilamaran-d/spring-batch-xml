package com.pvinsoft.batch.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "T_EMPINFO")
public class Employee {
	
	    private int id;
	    private BigDecimal salary;
	    private int age;
	    private String staffName;
	    private Date dob;

	    @XmlAttribute(name = "id")
	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    @XmlElement(name = "salary")
	    public BigDecimal getSalary() {
	        return salary;
	    }

	    public void setSalary(BigDecimal salary) {
	        this.salary = salary;
	    }

	    @XmlElement(name = "age")
	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	    @XmlElement(name = "staffName")
	    public String getStaffName() {
	        return staffName;
	    }

	    public void setStaffName(String staffName) {
	        this.staffName = staffName;
	    }

	    @XmlElement(name = "dob")
	    public Date getDateOfBirth() {
	        return dob;
	    }

	    public void setDateOfBirth(Date dob) {
	        this.dob = dob;
	    }

	    @Override
	    public String toString() {
	        return "Employee [id=" + id + ", sales=" + salary 
	                    + ", qty=" + age + ", staffName=" + staffName + "]";
	    }
}
