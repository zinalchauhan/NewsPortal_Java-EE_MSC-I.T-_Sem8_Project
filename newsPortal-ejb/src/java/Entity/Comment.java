/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author maafia_fury
 */
@Entity
@Table(name = "comment", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c"),
    @NamedQuery(name = "Comment.findByCommentByDebateIDPK", query = "SELECT c FROM Comment c WHERE c.isActive=1 and c.debateIDFK.debateIDPK = :debateIDFK"),
    @NamedQuery(name = "Comment.findByCommentIDPK", query = "SELECT c FROM Comment c WHERE c.commentIDPK = :commentIDPK"),
    @NamedQuery(name = "Comment.findByCommentDescription", query = "SELECT c FROM Comment c WHERE c.commentDescription = :commentDescription"),
    @NamedQuery(name = "Comment.findByCommentDate", query = "SELECT c FROM Comment c WHERE c.commentDate = :commentDate"),
    @NamedQuery(name = "Comment.findByIsActive", query = "SELECT c FROM Comment c WHERE c.isActive = :isActive")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "commentIDPK", nullable = false)
    private Integer commentIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "commentDescription", nullable = false, length = 2000)
    private String commentDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "commentDate", nullable = false, length = 2000)
    private String commentDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK", nullable = false)
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "debateIDFK", referencedColumnName = "debateIDPK", nullable = false)
    @ManyToOne(optional = false)
    private Debate debateIDFK;

    public Comment() {
    }

    public Comment(Integer commentIDPK) {
        this.commentIDPK = commentIDPK;
    }

    public Comment(Integer commentIDPK, String commentDescription, String commentDate, boolean isActive) {
        this.commentIDPK = commentIDPK;
        this.commentDescription = commentDescription;
        this.commentDate = commentDate;
        this.isActive = isActive;
    }

    public Integer getCommentIDPK() {
        return commentIDPK;
    }

    public void setCommentIDPK(Integer commentIDPK) {
        this.commentIDPK = commentIDPK;
    }

    public String getCommentDescription() {
        return commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    public Debate getDebateIDFK() {
        return debateIDFK;
    }

    public void setDebateIDFK(Debate debateIDFK) {
        this.debateIDFK = debateIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (commentIDPK != null ? commentIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.commentIDPK == null && other.commentIDPK != null) || (this.commentIDPK != null && !this.commentIDPK.equals(other.commentIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Comment[ commentIDPK=" + commentIDPK + " ]";
    }
    
}
