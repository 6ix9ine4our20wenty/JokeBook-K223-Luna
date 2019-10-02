package ch.liluna.jokebook.dto;

import javax.persistence.ManyToOne;

import ch.liluna.jokebook.domain.Role;
import ch.liluna.jokebook.domain.User;

public class UsersDTO {
	
	private long userId;

	@ManyToOne(optional = false)
	private long roleIDFS;

	private String username;

	public UsersDTO(long userId, long roleIDFS, String username) {
		this.userId = userId;
		this.roleIDFS = roleIDFS;
		this.username = username;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getRoleIDFS() {
		return roleIDFS;
	}

	public void setRoleIDFS(long roleIDFS) {
		this.roleIDFS = roleIDFS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static UsersDTO toDTO(User user, long roleIDFS, String username) {
		UsersDTO usersdto = new UsersDTO(user.getUserId(), user.getRoleIDFS().getRoleId(), user.getUsername());	
		return usersdto;
	}

}
