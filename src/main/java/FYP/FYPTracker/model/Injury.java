package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the injury database table.
 * 
 */
@Entity
@NamedQuery(name="Injury.findAll", query="SELECT i FROM Injury i")
public class Injury implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int injuryId;

	private String bodyLocation;
	
	@Temporal(TemporalType.DATE)
	private Date dateOccured;

	private String description;

	@Temporal(TemporalType.DATE)
	private Date returnDate;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="playerID")
	private Player player;

	//bi-directional many-to-one association to Club
	@ManyToOne
	@JoinColumn(name="clubID")
	private Club club;

	public Injury() {
	}

	public int getInjuryId() {
		return this.injuryId;
	}

	public void setInjuryId(int injuryId) {
		this.injuryId = injuryId;
	}

	public String getBodyLocation() {
		return this.bodyLocation;
	}

	public void setBodyLocation(String bodyLocation) {
		this.bodyLocation = bodyLocation;
	}

	public Date getDateOccured() {
		return this.dateOccured;
	}

	public void setDateOccured(Date dateOccured) {
		this.dateOccured = dateOccured;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Club getClub() {
		return this.club;
	}

	public void setClub(Club club) {
		this.club = club;
	}

}