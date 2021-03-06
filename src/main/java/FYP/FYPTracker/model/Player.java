/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.FYPTracker.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cooke
 */
@Entity
@Table(name = "player")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
    @NamedQuery(name = "Player.findByPlayerId", query = "SELECT p FROM Player p WHERE p.playerId = :playerId"),
    @NamedQuery(name = "Player.findByPostion", query = "SELECT p FROM Player p WHERE p.postion = :postion"),
    @NamedQuery(name = "Player.findByDob", query = "SELECT p FROM Player p WHERE p.dob = :dob"),
    @NamedQuery(name = "Player.findByHeight", query = "SELECT p FROM Player p WHERE p.height = :height"),
    @NamedQuery(name = "Player.findByWeight", query = "SELECT p FROM Player p WHERE p.weight = :weight"),
    @NamedQuery(name = "Player.findByAuthId", query = "SELECT p FROM Player p WHERE p.authId = :authId")})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "playerId")
    private Integer playerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "postion")
    private String postion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private int height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private float weight;
    @Column(name = "authId")
    private Integer authId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerID")
    private Collection<Testing> testingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "playerID")
    private Collection<Training> trainingCollection;
    @JoinColumn(name = "authUserId", referencedColumnName = "authUserId")
    @ManyToOne(optional = false)
    private AuthUser authUserId;
    @JoinColumn(name = "clubId", referencedColumnName = "clubId")
    @ManyToOne(optional = false)
    private Club clubId;

    public Player() {
    }

    public Player(Integer playerId) {
        this.playerId = playerId;
    }

    public Player(Integer playerId, String postion, Date dob, int height, int weight) {
        this.playerId = playerId;
        this.postion = postion;
        this.dob = dob;
        this.height = height;
        this.weight = weight;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    @XmlTransient
    public Collection<Testing> getTestingCollection() {
        return testingCollection;
    }

    public void setTestingCollection(Collection<Testing> testingCollection) {
        this.testingCollection = testingCollection;
    }

    @XmlTransient
    public Collection<Training> getTrainingCollection() {
        return trainingCollection;
    }

    public void setTrainingCollection(Collection<Training> trainingCollection) {
        this.trainingCollection = trainingCollection;
    }

    public AuthUser getAuthUserId() {
        return authUserId;
    }

    public void setAuthUserId(AuthUser authUserId) {
        this.authUserId = authUserId;
    }

    public Club getClubId() {
        return clubId;
    }

    public void setClubId(Club clubId) {
        this.clubId = clubId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (playerId != null ? playerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Player)) {
            return false;
        }
        Player other = (Player) object;
        if ((this.playerId == null && other.playerId != null) || (this.playerId != null && !this.playerId.equals(other.playerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FYP.FYPTracker.model.Player[ playerId=" + playerId + " ]";
    }
    
}
