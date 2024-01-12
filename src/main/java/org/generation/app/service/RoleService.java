package org.generation.app.service;

import java.util.List;

import org.generation.app.entity.Role;

public interface RoleService {
	
	Role getRoleById(Long id);
	Role createRole(Role role);
	List<Role> getAllRoles();
	Role updateRole(Role user, Long id);
	void deleteRole(Long id);

}
