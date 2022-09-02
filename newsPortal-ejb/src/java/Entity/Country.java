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
@Table(name = "country", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c WHERE c.isActive=1"),
    @NamedQuery(name = "Country.findByCountryIDPK", query = "SELECT c FROM Country c WHERE c.countryIDPK = :countryIDPK"),
    @NamedQuery(name = "Country.findByCountryName", query = "SELECT c FROM Country c WHERE c.countryName = :countryName"),
    @NamedQuery(name = "Country.findByIsActive", query = "SELECT c FROM Country c WHERE c.isActive = :isActive")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "countryIDPK", nullable = false)
    private Integer countryIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "countryName", nullable = false, length = 2000)
    private String countryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countryIDFK")
    private Collection<State> stateCollection;

    public Country() {
    }

    public Country(Integer countryIDPK) {
        this.countryIDPK = countryIDPK;
    }

    public Country(Integer countryIDPK, String countryName, boolean isActive) {
        this.countryIDPK = countryIDPK;
        this.countryName = countryName;
        this.isActive = isActive;
    }

    public Integer getCountryIDPK() {
        return countryIDPK;
    }

    public void setCountryIDPK(Integer countryIDPK) {
        this.countryIDPK = countryIDPK;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<State> getStateCollection() {
        return stateCollection;
    }

    public void setStateCollection(Collection<State> stateCollection) {
        this.stateCollection = stateCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryIDPK != null ? countryIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.countryIDPK == null && other.countryIDPK != null) || (this.countryIDPK != null && !this.countryIDPK.equals(other.countryIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Country[ countryIDPK=" + countryIDPK + " ]";
    }
    
}
