package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@NamedQuery(name="Coach.findAll", query="SELECT c FROM Coach c")
public class Coach implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int coachId;

	private String role;

	//bi-directional many-to-one association to AuthUser
	@ManyToOne
	@JoinColumn(name="authUserId")
	private AuthUser authUser;

	//bi-directional many-to-one association to Club
	@ManyToOne
	@JoinColumn(name="clubId")
	private Club club;

	public Coach() {
	}

	public int getCoachId() {
		return this.coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AuthUser getAuthUser() {
		return this.authUser;
	}

	public void setAuthUser(AuthUser authUser) {
		this.authUser = authUser;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

	

}