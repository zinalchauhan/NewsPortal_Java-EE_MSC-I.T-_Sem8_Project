/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author maafia_fury
 */
@Entity
@Table(name = "city", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c WHERE c.isActive=1"),
    @NamedQuery(name = "City.findCityByState", query = "SELECT c FROM City c WHERE c.isActive=1 and c.stateIDFK.stateIDPK=:stateIDFK"),
    @NamedQuery(name = "City.findByCityIDPK", query = "SELECT c FROM City c WHERE c.cityIDPK = :cityIDPK"),
    @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName"),
    @NamedQuery(name = "City.findByIsActive", query = "SELECT c FROM City c WHERE c.isActive = :isActive")})
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cityIDPK", nullable = false)
    private Integer cityIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "cityName", nullable = false, length = 2000)
    private String cityName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "stateIDFK", referencedColumnName = "stateIDPK", nullable = false)
    @ManyToOne(optional = false)
    private State stateIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityIDFK")
    private Collection<User> userCollection;

    public City() {
    }

    public City(Integer cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public City(Integer cityIDPK, String cityName, boolean isActive) {
        this.cityIDPK = cityIDPK;
        this.cityName = cityName;
        this.isActive = isActive;
    }

    public Integer getCityIDPK() {
        return cityIDPK;
    }

    public void setCityIDPK(Integer cityIDPK) {
        this.cityIDPK = cityIDPK;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public State getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(State stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityIDPK != null ? cityIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityIDPK == null && other.cityIDPK != null) || (this.cityIDPK != null && !this.cityIDPK.equals(other.cityIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.City[ cityIDPK=" + cityIDPK + " ]";
    }
    
}
