package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the club database table.
 * 
 */
@Entity
@NamedQuery(name="Club.findAll", query="SELECT c FROM Club c")
public class Club implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int clubId;

	private String city;

	private String contactEmail;

	private String contactName;

	private String county;
	
	private String email;
	
	private String name;

	private String street;

	private String town;

	//bi-directional many-to-one association to Injury
	@OneToMany(mappedBy="club")
	private List<Injury> injuries;

	//bi-directional many-to-one association to Player
	@OneToMany(mappedBy="club")
	private List<Player> players;

	public Club() {
	}

	public int getClubId() {
		return this.clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getContactEmail() {
		return this.contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactName() {
		return this.contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getTown() {
		return this.town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public List<Injury> getInjuries() {
		return this.injuries;
	}

	public void setInjuries(List<Injury> injuries) {
		this.injuries = injuries;
	}

	public Injury addInjury(Injury injury) {
		getInjuries().add(injury);
		injury.setClub(this);

		return injury;
	}

	public Injury removeInjury(Injury injury) {
		getInjuries().remove(injury);
		injury.setClub(null);

		return injury;
	}

	public List<Player> getPlayers() {
		return this.players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Player addPlayer(Player player) {
		getPlayers().add(player);
		player.setClub(this);

		return player;
	}

	public Player removePlayer(Player player) {
		getPlayers().remove(player);
		player.setClub(null);

		return player;
	}

}