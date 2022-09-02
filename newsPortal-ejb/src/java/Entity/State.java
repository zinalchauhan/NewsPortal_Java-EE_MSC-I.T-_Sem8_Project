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
@Table(name = "state", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT s FROM State s WHERE s.isActive=1"),
    @NamedQuery(name = "State.findByStateIDPK", query = "SELECT s FROM State s WHERE s.stateIDPK = :stateIDPK"),
    @NamedQuery(name = "State.findByStateName", query = "SELECT s FROM State s WHERE s.stateName = :stateName"),
    @NamedQuery(name = "State.findByIsActive", query = "SELECT s FROM State s WHERE s.isActive = :isActive")})
public class State implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateIDPK", nullable = false)
    private Integer stateIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "stateName", nullable = false, length = 2000)
    private String stateName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stateIDFK")
    private Collection<City> cityCollection;
    @JoinColumn(name = "countryIDFK", referencedColumnName = "countryIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Country countryIDFK;

    public State() {
    }

    public State(Integer stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public State(Integer stateIDPK, String stateName, boolean isActive) {
        this.stateIDPK = stateIDPK;
        this.stateName = stateName;
        this.isActive = isActive;
    }

    public Integer getStateIDPK() {
        return stateIDPK;
    }

    public void setStateIDPK(Integer stateIDPK) {
        this.stateIDPK = stateIDPK;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    public Country getCountryIDFK() {
        return countryIDFK;
    }

    public void setCountryIDFK(Country countryIDFK) {
        this.countryIDFK = countryIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateIDPK != null ? stateIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        if ((this.stateIDPK == null && other.stateIDPK != null) || (this.stateIDPK != null && !this.stateIDPK.equals(other.stateIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.State[ stateIDPK=" + stateIDPK + " ]";
    }
    
}
