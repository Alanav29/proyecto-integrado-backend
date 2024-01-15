package org.generation.app.service;

import java.util.List;

import org.generation.app.entity.Privilege;

public interface PrivilegeService {
	
	Privilege getPrivilegeById(Long id);
	Privilege createPrivilege(Privilege privilege);
	List<Privilege> getAllPrivileges();
	Privilege updatePrivilege(Privilege privilege, Long id);
	void deletePrivilege(Long id);

}
