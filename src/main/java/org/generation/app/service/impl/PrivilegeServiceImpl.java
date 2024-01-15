package org.generation.app.service.impl;

import java.util.List;

import org.generation.app.entity.Privilege;
import org.generation.app.repository.PrivilegeRepository;
import org.generation.app.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {
	
	@Autowired
	PrivilegeRepository privilegeRepository;

	@Override
	public Privilege getPrivilegeById(Long id) {
		return privilegeRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Privilege does not exist with id " + id));
	}

	@Override
	public Privilege createPrivilege(Privilege privilege) {
		return privilegeRepository.save(privilege);
	}

	@Override
	public List<Privilege> getAllPrivileges() {
		return (List<Privilege>) privilegeRepository.findAll();
	}

	@Override
	public Privilege updatePrivilege(Privilege privilege, Long id) {
		Privilege existingPrivilege = getPrivilegeById(id);
		existingPrivilege.setPrivilege( privilege.getPrivilege() );
		return privilegeRepository.save(existingPrivilege);
	}

	@Override
	public void deletePrivilege(Long id) {
		// No se crea borrado por seguridad de la base de datos	
	}

}
