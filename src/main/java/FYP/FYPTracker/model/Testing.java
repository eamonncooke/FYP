package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the testing database table.
 * 
 */
@Entity
@NamedQuery(name="Testing.findAll", query="SELECT t FROM Testing t")
public class Testing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int testId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private int time;

	//bi-directional many-to-one association to Player
	@ManyToOne
	@JoinColumn(name="playerID")
	private Player player;

	public Testing() {
	}

	public int getTestId() {
		return this.testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}