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
import javax.persistence.Lob;
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
@Table(name = "debate", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Debate.findAll", query = "SELECT d FROM Debate d WHERE d.isActive=1"),
    @NamedQuery(name = "Debate.findByDebateIDPK", query = "SELECT d FROM Debate d WHERE d.debateIDPK = :debateIDPK"),
    @NamedQuery(name = "Debate.findByDebateTitle", query = "SELECT d FROM Debate d WHERE d.debateTitle = :debateTitle"),
    @NamedQuery(name = "Debate.findByDeabteDescription", query = "SELECT d FROM Debate d WHERE d.deabteDescription = :deabteDescription"),
    @NamedQuery(name = "Debate.findByDebateStartDate", query = "SELECT d FROM Debate d WHERE d.debateStartDate = :debateStartDate"),
    @NamedQuery(name = "Debate.findByDebateEndDate", query = "SELECT d FROM Debate d WHERE d.debateEndDate = :debateEndDate"),
    @NamedQuery(name = "Debate.findByDebateStatus", query = "SELECT d FROM Debate d WHERE d.debateStatus = :debateStatus"),
    @NamedQuery(name = "Debate.findByIsActive", query = "SELECT d FROM Debate d WHERE d.isActive = :isActive")})
public class Debate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "debateIDPK", nullable = false)
    private Integer debateIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "debateTitle", nullable = false, length = 2000)
    private String debateTitle;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "deabteDescription", nullable = false, length = 16777215)
    private String deabteDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "debateStartDate", nullable = false, length = 2000)
    private String debateStartDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "debateEndDate", nullable = false, length = 2000)
    private String debateEndDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "debateStatus", nullable = false, length = 200)
    private String debateStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "debateImage", nullable = false, length = 2000)
    private String debateImage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "subCategoryIDFK", referencedColumnName = "subCategoryIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Subcategory subCategoryIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "debateIDFK")
    private Collection<Comment> commentCollection;

    public Debate() {
    }

    public Debate(Integer debateIDPK) {
        this.debateIDPK = debateIDPK;
    }

    public Debate(Integer debateIDPK, String debateTitle, String deabteDescription, String debateStartDate, String debateEndDate, String debateStatus, boolean isActive , String debateImage) {
        this.debateIDPK = debateIDPK;
        this.debateTitle = debateTitle;
        this.deabteDescription = deabteDescription;
        this.debateStartDate = debateStartDate;
        this.debateEndDate = debateEndDate;
        this.debateStatus = debateStatus;
        this.debateImage = debateImage;
        this.isActive = isActive;
    }

    public Integer getDebateIDPK() {
        return debateIDPK;
    }

    public void setDebateIDPK(Integer debateIDPK) {
        this.debateIDPK = debateIDPK;
    }

    public String getDebateTitle() {
        return debateTitle;
    }

    public void setDebateTitle(String debateTitle) {
        this.debateTitle = debateTitle;
    }

    public String getDeabteDescription() {
        return deabteDescription;
    }

    public void setDeabteDescription(String deabteDescription) {
        this.deabteDescription = deabteDescription;
    }

    public String getDebateStartDate() {
        return debateStartDate;
    }

    public void setDebateStartDate(String debateStartDate) {
        this.debateStartDate = debateStartDate;
    }

    public String getDebateEndDate() {
        return debateEndDate;
    }

    public void setDebateEndDate(String debateEndDate) {
        this.debateEndDate = debateEndDate;
    }

    public String getDebateStatus() {
        return debateStatus;
    }

    public void setDebateStatus(String debateStatus) {
        this.debateStatus = debateStatus;
    }
    
    public String getDebateImage() {
        return debateImage;
    }

    public void setDebateImage(String debateImage) {
        this.debateImage= debateImage;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Subcategory getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(Subcategory subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (debateIDPK != null ? debateIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Debate)) {
            return false;
        }
        Debate other = (Debate) object;
        if ((this.debateIDPK == null && other.debateIDPK != null) || (this.debateIDPK != null && !this.debateIDPK.equals(other.debateIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Debate[ debateIDPK=" + debateIDPK + " ]";
    }
    
}
