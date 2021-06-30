package lv.venta.eib.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "UserRole")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserRole {

	@Column(name = "aid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	@Column(name = "roleTitle")
	private String roleTitle;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "aid"))
	private Collection<User> users = new ArrayList<>();
	public void addUser(User user)
	{
		users.add(user);
		System.out.println(user);
	}

	public UserRole(Collection<User> users) {
		super();
		this.users = users;
	}

	public UserRole(String authority, Collection<User> users) {
		super();
		this.roleTitle = authority;
		this.users = users;
	}

	public UserRole(String authority) {
		super();
		users = new ArrayList<User>();
		this.roleTitle = authority;
	}

	public void setUser(User user) {
		users.add(user);
	}

}
