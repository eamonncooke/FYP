package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Set;


/**
 * The persistent class for the auth_user database table.
 * 
 */
@Entity
@Table(name="auth_user")
@NamedQuery(name="AuthUser.findAll", query="SELECT a FROM AuthUser a")
public class AuthUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int authUserId;

	private String email;
	
	private String firstName;

	private String password;

	private String status;

	private String surname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn(name = "auth_role_id"))
	private Set<AuthRole> roles;

	//bi-directional many-to-one association to Player
	@OneToMany(mappedBy="authUser")
	private List<Player> players;

	public AuthUser() {
	}

	public int getAuthUserId() {
		return this.authUserId;
	}

	public void setAuthUserId(int authUserId) {
		this.authUserId = authUserId;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Set<AuthRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<AuthRole> roles) {
		this.roles = roles;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player addPlayer(Player player) {
		getPlayers().add(player);
		player.setAuthUser(this);

		return player;
	}

	public Player removePlayer(Player player) {
		getPlayers().remove(player);
		player.setAuthUser(null);

		return player;
	}

}