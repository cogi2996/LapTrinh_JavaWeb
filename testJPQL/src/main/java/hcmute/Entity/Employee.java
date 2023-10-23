package hcmute.Entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

import hcmute.JPAConfig.JpaConfig;


@Entity
@Table(name = "employee")
@NamedQuery(query ="select e from Employee e where e.Eid = :id",name = "find employee by id")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private int Eid;
	private String Ename;
	private int Salary;
	private String Deg;

	@Override
	public String toString() {
		return "Employee [Eid=" + Eid + ", Ename=" + Ename + ", Salary=" + Salary + ", Deg=" + Deg + "]";
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int eid, String ename, int salary, String deg) {
		super();
		Eid = eid;
		Ename = ename;
		Salary = salary;
		Deg = deg;
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getDeg() {
		return Deg;
	}

	public void setDeg(String deg) {
		Deg = deg;
	}

	 public static void main( String[ ] args ) {
		EntityManager entityManager = JpaConfig.getEntityManager();
		// Scarlar function	
		Query query = entityManager.createQuery("select e from Employee e");
		List<Employee> list = (List<Employee>)query.getResultList();
		for (Employee employee : list) {
			System.out.println(employee);
		}
		// aggregate function
		Query query1 = entityManager.createQuery("select Max(e.Salary) from Employee e");
		int maxSalary = (int)query1.getSingleResult();
		System.out.println("max salary: "+maxSalary);
		
		// Between
		Query query3 = entityManager.createQuery("select e from Employee e where e.Salary between 30000 and 40000");
		List<Employee> list3 = query3.getResultList();
		System.out.println("Các nhân viên có lương nằm trong khoản từ 30000 đến 40000");
		for(Employee e: list3) {
			System.out.println(e);
		}
		
		// Like
		Query query4 = entityManager.createQuery("select e from Employee e where e.Ename like 'Mas%'");
		List<Employee> list4 = query4.getResultList();
		// Các nhân viên có tên bắt đầu bằng M
		for(Employee e:list4) {
			System.out.println(e);
		}
		
		// Order 
		Query query5 = entityManager.createQuery("select e.Ename from Employee e order by e.Ename DESC");
		List<String> list5 = (List<String>)query5.getResultList();
		//Tên employee theo thứ tự từ nhỏ đến lớn
		for(String e: list5) {
			System.out.println(e);
		}
		
		//Name Queries 
		Query query6 = entityManager.createNamedQuery("find employee by id");
		query6.setParameter("id", 1204);
		Employee em =(Employee) query6.getSingleResult();
		System.out.println("Nhân viên có mã 1204: "+em);
	}

}
