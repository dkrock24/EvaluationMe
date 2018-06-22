package com.focus.levelup.services;

import org.springframework.data.repository.CrudRepository;


import com.focus.levelup.model.Role;

public interface RoleServices extends CrudRepository<Role, Integer>{

//	@Query("SELECT r FROM Roles r ORDER BY r.idRole ASC")
//	public List<Role> findAllOrderedByIdAsc();
//
//	@Query("SELECT r FROM Roles r ORDER BY r.idRole DESC")
//	public List<Role> findAllOrderedByIdDesc();
//
//	@Query("SELECT r FROM Roles r WHERE r.status = :status")
//	public List<Role> findAllByStatus(@Param("status") int status);
}
