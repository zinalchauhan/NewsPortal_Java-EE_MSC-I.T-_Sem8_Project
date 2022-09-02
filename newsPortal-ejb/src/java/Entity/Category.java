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
@Table(name = "category", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c  WHERE c.isActive=1"),
    @NamedQuery(name = "Category.findByCategoryIDPK", query = "SELECT c FROM Category c WHERE c.categoryIDPK = :categoryIDPK"),
    @NamedQuery(name = "Category.findByCategoryName", query = "SELECT c FROM Category c WHERE c.categoryName = :categoryName"),
    @NamedQuery(name = "Category.findByIsActive", query = "SELECT c FROM Category c WHERE c.isActive = :isActive"),
    @NamedQuery(name = "Category.findByCategoryIcon", query = "SELECT c FROM Category c WHERE c.categoryIcon = :categoryIcon")})
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoryIDPK", nullable = false)
    private Integer categoryIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "categoryName", nullable = false, length = 2000)
    private String categoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "categoryIcon", nullable = false, length = 255)
    private String categoryIcon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryIDFK")
    private Collection<Subcategory> subcategoryCollection;

    public Category() {
    }

    public Category(Integer categoryIDPK) {
        this.categoryIDPK = categoryIDPK;
    }

    public Category(Integer categoryIDPK, String categoryName, boolean isActive, String categoryIcon) {
        this.categoryIDPK = categoryIDPK;
        this.categoryName = categoryName;
        this.isActive = isActive;
        this.categoryIcon = categoryIcon;
    }

    public Integer getCategoryIDPK() {
        return categoryIDPK;
    }

    public void setCategoryIDPK(Integer categoryIDPK) {
        this.categoryIDPK = categoryIDPK;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    @XmlTransient
    public Collection<Subcategory> getSubcategoryCollection() {
        return subcategoryCollection;
    }

    public void setSubcategoryCollection(Collection<Subcategory> subcategoryCollection) {
        this.subcategoryCollection = subcategoryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryIDPK != null ? categoryIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoryIDPK == null && other.categoryIDPK != null) || (this.categoryIDPK != null && !this.categoryIDPK.equals(other.categoryIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Category[ categoryIDPK=" + categoryIDPK + " ]";
    }
    
}
