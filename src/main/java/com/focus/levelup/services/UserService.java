package com.focus.levelup.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.focus.levelup.model.User;

public interface UserService extends CrudRepository<User, Integer> {
	
	User findByEmail(String email);

//	// Get all users ascending ordered
//	@Query("SELECT u FROM Users u ORDER BY u.idUser ASC")
//	List<User> findAllOrderedByIdAsc();
//
//	// Get all users descending ordered
//	@Query("SELECT u FROM Users u ORDER BY u.idUser DESC")
//	List<User> findAllOrderedByIdDesc();
//
//	// Get all users by status passed
//	@Query("SELECT u FROM Users u WHERE u.status = :status")
//	List<User> findAllByStatus(@Param("status") int status);
//
//	// Get all users by name or last name
//	@Query("SELECT u FROM Users u WHERE u.firstName LIKE CONCAT('%',:name,'%') OR u.lastName LIKE CONCAT('%',:name,'%')")
//	List<User> findAllByName(@Param("name") String name);
//
//	// Get all users by email
//	@Query("SELECT u FROM Users u WHERE u.email LIKE CONCAT('%',:email,'%')")
//	List<User> findAllByEmail(@Param("email") String email);
//
//	//Get all users by RoleId
//	@Query("SELECT u FROM Users u WHERE u.roles.idRole = :roleId")
//	List<User> findAllByRoleId(@Param("roleId") int roleId);
}
