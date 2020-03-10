package FYP.FYPTracker.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int playerId;

	private int authId;

	@Temporal(TemporalType.DATE)
	private Date dob;

	private int height;

	private String postion;

	private int weight;

	//bi-directional many-to-one association to Injury
	@OneToMany(mappedBy="player")
	private List<Injury> injuries;

	//bi-directional many-to-one association to AuthUser
	@ManyToOne
	@JoinColumn(name="authUserId")
	private AuthUser authUser;

	//bi-directional many-to-one association to Club
	@ManyToOne
	@JoinColumn(name="clubId")
	private Club club;

	//bi-directional many-to-one association to Testing
	@OneToMany(mappedBy="player")
	private List<Testing> testings;

	//bi-directional many-to-one association to Training
	@OneToMany(mappedBy="player")
	private List<Training> trainings;

	public Player() {
	}

	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getAuthId() {
		return this.authId;
	}

	public void setAuthId(int authId) {
		this.authId = authId;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPostion() {
		return this.postion;
	}

	public int getWeight() {
		return this.weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Injury> getInjuries() {
		return this.injuries;
	}

	public void setInjuries(List<Injury> injuries) {
		this.injuries = injuries;
	}

	public Injury addInjury(Injury injury) {
		getInjuries().add(injury);
		injury.setPlayer(this);

		return injury;
	}

	public Injury removeInjury(Injury injury) {
		getInjuries().remove(injury);
		injury.setPlayer(null);

		return injury;
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

	public List<Testing> getTestings() {
		return this.testings;
	}

	public void setTestings(List<Testing> testings) {
		this.testings = testings;
	}

	public Testing addTesting(Testing testing) {
		getTestings().add(testing);
		testing.setPlayer(this);

		return testing;
	}

	public Testing removeTesting(Testing testing) {
		getTestings().remove(testing);
		testing.setPlayer(null);

		return testing;
	}

	public List<Training> getTrainings() {
		return this.trainings;
	}

	public void setTrainings(List<Training> trainings) {
		this.trainings = trainings;
	}

	public Training addTraining(Training training) {
		getTrainings().add(training);
		training.setPlayer(this);

		return training;
	}

	public Training removeTraining(Training training) {
		getTrainings().remove(training);
		training.setPlayer(null);

		return training;
	}

}