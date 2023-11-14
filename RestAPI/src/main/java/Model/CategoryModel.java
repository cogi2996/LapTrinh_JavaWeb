package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name= "CategoryModel")
@NamedQuery(name = "CategoryModel.findAll", query = "SELECT c FROM CategoryModel c")
public class CategoryModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String icon;
	public CategoryModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoryModel(int id, String name, String icon) {
		super();
		this.id = id;
		this.name = name;
		this.icon = icon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	
}
