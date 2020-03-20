/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FYP.FYPTracker.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cooke
 */
@Entity
@Table(name = "club")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Club.findAll", query = "SELECT c FROM Club c"),
    @NamedQuery(name = "Club.findByClubId", query = "SELECT c FROM Club c WHERE c.clubId = :clubId"),
    @NamedQuery(name = "Club.findByName", query = "SELECT c FROM Club c WHERE c.name = :name"),
    @NamedQuery(name = "Club.findByStreet", query = "SELECT c FROM Club c WHERE c.street = :street"),
    @NamedQuery(name = "Club.findByTown", query = "SELECT c FROM Club c WHERE c.town = :town"),
    @NamedQuery(name = "Club.findByCounty", query = "SELECT c FROM Club c WHERE c.county = :county"),
    @NamedQuery(name = "Club.findByContactName", query = "SELECT c FROM Club c WHERE c.contactName = :contactName"),
    @NamedQuery(name = "Club.findByContactEmail", query = "SELECT c FROM Club c WHERE c.contactEmail = :contactEmail")})
public class Club implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "clubId")
    private Integer clubId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 22)
    @Column(name = "town")
    private String town;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "county")
    private String county;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contactName")
    private String contactName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "contactEmail")
    private String contactEmail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubId")
    private Collection<Coach> coachCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clubId")
    private Collection<Player> playerCollection;

    public Club() {
    }

    public Club(Integer clubId) {
        this.clubId = clubId;
    }

    public Club(Integer clubId, String name, String street, String town, String county, String contactName, String contactEmail) {
        this.clubId = clubId;
        this.name = name;
        this.street = street;
        this.town = town;
        this.county = county;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    public Integer getClubId() {
        return clubId;
    }

    public void setClubId(Integer clubId) {
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    @XmlTransient
    public Collection<Coach> getCoachCollection() {
        return coachCollection;
    }

    public void setCoachCollection(Collection<Coach> coachCollection) {
        this.coachCollection = coachCollection;
    }

    @XmlTransient
    public Collection<Player> getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(Collection<Player> playerCollection) {
        this.playerCollection = playerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clubId != null ? clubId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Club)) {
            return false;
        }
        Club other = (Club) object;
        if ((this.clubId == null && other.clubId != null) || (this.clubId != null && !this.clubId.equals(other.clubId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FYP.FYPTracker.model.Club[ clubId=" + clubId + " ]";
    }
    
}
