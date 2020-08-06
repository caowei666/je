package generator.pojo;

import java.util.Date;

public class Employee {
    private Integer id;

    private String name;

    private String job;

    private Integer dept;

    private Long salary;

    private Date diredate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Date getDiredate() {
        return diredate;
    }

    public void setDiredate(Date diredate) {
        this.diredate = diredate;
    }
}