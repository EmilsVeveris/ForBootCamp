package lv.venta.eib.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lv.venta.eib.model.User;
import lv.venta.eib.repo.IUserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
@Autowired
IUserRepo userRepo;
@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	User user = userRepo.findByUsername(email);
	if(user == null) {
		System.out.println("notfound");
		throw new UsernameNotFoundException(email);
	} else {
	System.out.println("found");
	}
	return new MyUserDetails(user);
	}
}
