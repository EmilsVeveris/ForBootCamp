package lv.venta.eib.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.User;

public interface IUserRepo extends CrudRepository<User, Integer> {

	User findByEmail(String email);

	User findByUsername(String Username);

}
