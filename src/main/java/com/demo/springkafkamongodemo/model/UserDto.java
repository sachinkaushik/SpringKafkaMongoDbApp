package com.demo.springkafkamongodemo.model;

public class UserDto {

	private Long id;
    private String name;
    private String dept;
    private Long salary;

    public UserDto() {
		super();
	}

	public UserDto(Long id,String name, String dept, Long salary) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.salary = salary;
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
