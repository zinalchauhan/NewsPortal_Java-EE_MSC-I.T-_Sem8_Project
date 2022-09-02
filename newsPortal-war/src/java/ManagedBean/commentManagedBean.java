/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Comment;
import Entity.Debate;
import Entity.User;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;

/**
 *
 * @author maafia_fury
 */
@Named(value = "commentBean")
@ApplicationScoped
public class commentManagedBean {
    
     @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;

    int commentIDPK , userIDFK , debateIDFK,debateIDPK ;
    String commentDescription , commentDate;
    List<User> userList;
    List<Debate> debateList;
    
    Comment comment = new Comment();
    
    public commentManagedBean() {
    }

    public int getDebateIDPK() {
        return debateIDPK;
    }

    public void setDebateIDPK(int debateIDPK) {
        this.debateIDPK = debateIDPK;
    }

    
    
    
    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getCommentIDPK() {
        return commentIDPK;
    }

    public void setCommentIDPK(int commentIDPK) {
        this.commentIDPK = commentIDPK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public int getDebateIDFK() {
        return debateIDFK;
    }

    public void setDebateIDFK(int debateIDFK) {
        this.debateIDFK = debateIDFK;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Debate> getDebateList() {
        return debateList;
    }

    public void setDebateList(List<Debate> debateList) {
        this.debateList = debateList;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
    
    @PostConstruct
    public void init() {
        userList = newsPotalSessionBean.showall_User();
        debateList = newsPotalSessionBean.showall_Debate();
    }
    
    public List<Comment> showall() {
        try {
            return newsPotalSessionBean.showall_Comment();
        } catch (Exception e) {
            return null;
        }
    }
    
  
    
    public void insert_click()
    {
        try {
            User user = newsPotalSessionBean.searchUser(userIDFK);
            Debate debate = newsPotalSessionBean.searchDebate(debateIDFK);
            comment.setCommentIDPK(0);
            comment.setCommentDescription(commentDescription);
            comment.setCommentDate(commentDate);
            comment.setUserIDFK(user);
            comment.setDebateIDFK(debate);
            comment.setIsActive(true);
            newsPotalSessionBean.insertComment(comment);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void update_click()
    {
        try {
            User user = newsPotalSessionBean.searchUser(userIDFK);
            Debate debate = newsPotalSessionBean.searchDebate(debateIDFK);
            comment.setCommentIDPK(commentIDPK);
            comment.setCommentDescription(commentDescription);
            comment.setCommentDate(commentDate);
            comment.setUserIDFK(user);
            comment.setDebateIDFK(debate);
            newsPotalSessionBean.updateComment(comment);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void delete_click(int commentIDPK)
    {
        try {
            newsPotalSessionBean.deleteComment(commentIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void search_click(int id)
    {
        try {
            comment = newsPotalSessionBean.searchComment(id);
            commentIDPK = comment.getCommentIDPK();
            commentDescription = comment.getCommentDescription();
            commentDate = comment.getCommentDate();
            userIDFK = comment.getUserIDFK().getUserIDPK();
            debateIDFK = comment.getDebateIDFK().getDebateIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public List<Comment> showCommentByDebateID(int debateIDFK) {
        
        return newsPotalSessionBean.showCommentByDebateIDFK(debateIDFK);
        
    }
    
    public void clear(){
        commentIDPK = 0;
        commentDescription = "";
        commentDate = "";
        userIDFK = 0;
        debateIDFK = 0;
    }
    
}
