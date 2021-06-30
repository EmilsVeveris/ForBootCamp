package lv.venta.eib.repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.eib.model.UserRole;

public interface IUserRoleRepo extends CrudRepository<UserRole, Integer>  {

	UserRole findByRoleTitle(String string);

}
