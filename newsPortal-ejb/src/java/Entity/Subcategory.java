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
@Table(name = "subcategory", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subcategory.findAll", query = "SELECT s FROM Subcategory s WHERE s.isActive=1"),
    @NamedQuery(name = "Subcategory.findSubcategoryByCategory", query = "SELECT s FROM Subcategory s WHERE s.isActive=1 and s.categoryIDFK.categoryIDPK=:categoryIDFK"),
    @NamedQuery(name = "Subcategory.findBySubCategoryIDPK", query = "SELECT s FROM Subcategory s WHERE s.subCategoryIDPK = :subCategoryIDPK"),
    @NamedQuery(name = "Subcategory.findBySubCategoryName", query = "SELECT s FROM Subcategory s WHERE s.subCategoryName = :subCategoryName"),
    @NamedQuery(name = "Subcategory.findByIsActive", query = "SELECT s FROM Subcategory s WHERE s.isActive = :isActive")})
public class Subcategory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "subCategoryIDPK", nullable = false)
    private Integer subCategoryIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "subCategoryName", nullable = false, length = 2000)
    private String subCategoryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoryIDFK")
    private Collection<News> newsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoryIDFK")
    private Collection<Blog> blogCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoryIDFK")
    private Collection<Debate> debateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoryIDFK")
    private Collection<Videonews> videonewsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subCategoryIDFK")
    private Collection<Podcast> podcastCollection;
    @JoinColumn(name = "categoryIDFK", referencedColumnName = "categoryIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Category categoryIDFK;

    public Subcategory() {
    }

    public Subcategory(Integer subCategoryIDPK) {
        this.subCategoryIDPK = subCategoryIDPK;
    }

    public Subcategory(Integer subCategoryIDPK, String subCategoryName, boolean isActive) {
        this.subCategoryIDPK = subCategoryIDPK;
        this.subCategoryName = subCategoryName;
        this.isActive = isActive;
    }

    public Integer getSubCategoryIDPK() {
        return subCategoryIDPK;
    }

    public void setSubCategoryIDPK(Integer subCategoryIDPK) {
        this.subCategoryIDPK = subCategoryIDPK;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @XmlTransient
    public Collection<News> getNewsCollection() {
        return newsCollection;
    }

    public void setNewsCollection(Collection<News> newsCollection) {
        this.newsCollection = newsCollection;
    }

    @XmlTransient
    public Collection<Blog> getBlogCollection() {
        return blogCollection;
    }

    public void setBlogCollection(Collection<Blog> blogCollection) {
        this.blogCollection = blogCollection;
    }

    @XmlTransient
    public Collection<Debate> getDebateCollection() {
        return debateCollection;
    }

    public void setDebateCollection(Collection<Debate> debateCollection) {
        this.debateCollection = debateCollection;
    }

    @XmlTransient
    public Collection<Videonews> getVideonewsCollection() {
        return videonewsCollection;
    }

    public void setVideonewsCollection(Collection<Videonews> videonewsCollection) {
        this.videonewsCollection = videonewsCollection;
    }

    @XmlTransient
    public Collection<Podcast> getPodcastCollection() {
        return podcastCollection;
    }

    public void setPodcastCollection(Collection<Podcast> podcastCollection) {
        this.podcastCollection = podcastCollection;
    }

    public Category getCategoryIDFK() {
        return categoryIDFK;
    }

    public void setCategoryIDFK(Category categoryIDFK) {
        this.categoryIDFK = categoryIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subCategoryIDPK != null ? subCategoryIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subcategory)) {
            return false;
        }
        Subcategory other = (Subcategory) object;
        if ((this.subCategoryIDPK == null && other.subCategoryIDPK != null) || (this.subCategoryIDPK != null && !this.subCategoryIDPK.equals(other.subCategoryIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Subcategory[ subCategoryIDPK=" + subCategoryIDPK + " ]";
    }
    
}
