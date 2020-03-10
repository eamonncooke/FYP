package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the training database table.
 * 
 */
@Entity
@NamedQuery(name="Training.findAll", query="SELECT t FROM Training t")
public class Training implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int trainingId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private String geoLocation;


	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="playerID")
	private Player player;

	public Training() {
	}

	public int getTrainingId() {
		return this.trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getGeoLocation() {
		return this.geoLocation;
	}

	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}