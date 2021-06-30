package lv.venta.eib.service;

import java.util.ArrayList;

import lv.venta.eib.model.User;

public interface ICRUDUserService {
	
	public boolean addUser(User user);
	
	public ArrayList<User> showAllUsers();
	
	public User selectById(int id);

}
