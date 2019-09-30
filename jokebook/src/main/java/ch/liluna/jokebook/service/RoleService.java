package ch.liluna.jokebook.service;

import java.util.List;
import java.util.Optional;

import ch.liluna.jokebook.domain.Role;
import ch.liluna.jokebook.repository.RoleRepository;

public class RoleService {
	 private RoleRepository roleRepository;

	    public RoleService(RoleRepository roleRepository) {
	        this.roleRepository = roleRepository;
	    }

	    public List<Role> findAll() {
	        return roleRepository.findAll();
	    }

	    public Optional<Role> findUserById(long id) {
	        return roleRepository.findById(id);
	    }

	    public Role createRole(Role role) {
	        return roleRepository.saveAndFlush(role);
	    }

	    public void deleteRoleById(long id) {
	        if (roleRepository.existsById(id)) {
	            roleRepository.deleteById(id);
	        }
	    }

	

}
