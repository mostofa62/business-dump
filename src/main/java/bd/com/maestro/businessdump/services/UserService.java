package bd.com.maestro.businessdump.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

import bd.com.maestro.businessdump.models.Area;
import bd.com.maestro.businessdump.models.Role;
import bd.com.maestro.businessdump.models.User;
import bd.com.maestro.businessdump.repositories.AreaRepository;
import bd.com.maestro.businessdump.repositories.RoleRepository;
import bd.com.maestro.businessdump.repositories.UserRepository;

@Service
public class UserService {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private AreaRepository areaRepository;
	
	
	@Autowired
	public UserService(RoleRepository roleRepository,
			UserRepository userRepository,
			AreaRepository areaRepository
			) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
		this.areaRepository = areaRepository;
	}
	
	
	public void RoleSaveOrUpdate(Role role) {
		roleRepository.save(role);
	}
	
	public void UserSaveOrUpdate(User user) {
		userRepository.save(user);
	}
	
	
	
	
	public Role getRoleById(Long id) {
		Role role = roleRepository.findById(id).orElseThrow(
   				()-> new IllegalArgumentException("Not Found with this ID: "+id));
		return role;
	}
	
	public User getUserById(Long id) {
		User user = userRepository.findById(id).orElseThrow(
   				()-> new IllegalArgumentException("Not Found with this ID: "+id));
		return user;
	}
	
	public User getUserByName(String name) {
		User user = userRepository.findFirst1ByUserName(name);
		return user;
	}
	
	public DataTablesOutput<Role> getRole(DataTablesInput input){
		return roleRepository.findAll(input);
	}
	
	public DataTablesOutput<User> getUser(DataTablesInput input){
		return userRepository.findAll(input);
	}
	/*
	public Collection<Role> getRolesIdAndNameOnly(){
		return roleRepository.getIdAndNameOnly();
	}*/
	public Collection<Role> getRolesIdAndNameOnly(User user){
		Long maxId = user.getRole().getId() + user.getrLevel();
		System.out.println(maxId);
		return roleRepository.getIdAndNameOnly(user.getRole().getId(), maxId);
	}
	
	public void AreaSaveOrUpdate(Area area) {
		areaRepository.save(area);
	}
	
	public DataTablesOutput<Area> getArea(DataTablesInput input){
		return areaRepository.findAll(input);
	}
	
	public Collection<Area> getAreaIdAndNameOnly(){
		return areaRepository.getIdAndNameOnly();
	}
	
	public Area getAreaById(Long id) {
		Area area = areaRepository.findById(id).orElseThrow(
   				()-> new IllegalArgumentException("Not Found with this ID: "+id));
		return area;
	}
	
}
