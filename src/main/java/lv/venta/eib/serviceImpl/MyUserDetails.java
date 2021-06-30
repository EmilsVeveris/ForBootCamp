package lv.venta.eib.serviceImpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lv.venta.eib.model.User;
public class MyUserDetails implements UserDetails
{
	private User user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getUserRole().iterator().next().getRoleTitle());
		return Arrays.asList(authority);
	}
	
	

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public MyUserDetails(User user) {
		super();
		this.user = user;
	}
	
	
}

/*
public class MyUserDetails implements org.springframework.security.core.userdetails.UserDetails {
	private String email;
	private String password;
	private List<GrantedAuthority> roles;
	private boolean isEnabled;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public MyUserDetails(User user) {
		super();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.roles = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		this.isEnabled = user.isEnabled();
	}

	@Override
	public boolean isEnabled() {
// TODO Auto-generated method stub
		return isEnabled;
	}


}
*/