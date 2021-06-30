package lv.venta.eib.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Table
@Entity(name = "Users")
@Getter @Setter @ToString @NoArgsConstructor
public class User {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name="Userid")
		@Setter(value = AccessLevel.NONE)
		private int userid;
		
		@Column(name="Name")
		@NotNull
		@NotEmpty
		@Size(min = 3, max = 30)
		@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
		private String name;
		@Column(name="Surname")
		@NotNull
		@NotEmpty
		@Size(min = 3, max = 30)
		@Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)")
		private String surname;
		
		@Column(name="Email")
		@NotNull
		@NotEmpty
		@Size(min = 3, max = 30)
		private String email;
		
		@Column(name="Username")
		@NotNull
		@NotEmpty
		@Size(min = 3, max = 30)
		private String username;
		
		@Column(name="Password")
		@NotNull
		@NotEmpty
		private String password;
		
	/*	@OneToMany(mappedBy = "user")
		@ToString.Exclude
		private Collection<ShoppingCart> shoppingCart;*/

		@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
		@ToString.Exclude
		private Collection<UserRole> userRole = new ArrayList<>();
		
		public void addUserRole(UserRole UserRole)
		{
			userRole.add(UserRole);
			System.out.println(UserRole);
		}
		private boolean isEnabled = true;
		
		public boolean isEnabled() {
			// TODO Auto-generated method stub
			return isEnabled;
		}

		public User(
				@NotNull @NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String name,
				@NotNull @NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String surname,
				@NotNull @NotEmpty @Size(min = 3, max = 30) String email,
				@NotNull @NotEmpty @Size(min = 3, max = 30) String username,
				@NotNull @NotEmpty String password) {
			super();
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.username = username;
			this.password = password;
		}

		public User(
				@NotNull @NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String name,
				@NotNull @NotEmpty @Size(min = 3, max = 30) @Pattern(regexp = "([A-ZĀČĒĢĪĶĻŅŠŪŽ]{1}[a-zāčēģīķļņšūž]*)") String surname,
				@NotNull @NotEmpty @Size(min = 3, max = 30) String email,
				@NotNull @NotEmpty @Size(min = 3, max = 30) String username, @NotNull @NotEmpty String password,
				Collection<UserRole> userRole) {
			super();
			this.name = name;
			this.surname = surname;
			this.email = email;
			this.username = username;
			this.password = password;
			this.userRole = userRole;
		}


		
		
		
}
