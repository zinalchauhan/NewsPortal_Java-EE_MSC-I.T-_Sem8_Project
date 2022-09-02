/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Category;
import Entity.Comment;
import Entity.Debate;
import Entity.Subcategory;
import Entity.User;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author maafia_fury
 */
@Named(value = "debateBean")
@ApplicationScoped
public class debateManagedBean {

    @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;

    int commentIDPK, userIDFK, debateIDFK;
    String commentDescription, commentDate;

    int debateIDPK, subCategoryIDFK, categoryIDFK;
    String debateTitle, debateDescription, debateStartDate, debateEndDate, debateStatus , debateImage ;
    List<Subcategory> subCategoryList;
    List<Category> categoryList;
    Part file;

    Debate debate = new Debate();
    Comment comment = new Comment();

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getDebateImage() {
        return debateImage;
    }

    public void setDebateImage(String debateImage) {
        this.debateImage = debateImage;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
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

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getCategoryIDFK() {
        return categoryIDFK;
    }

    public void setCategoryIDFK(int categoryIDFK) {
        this.categoryIDFK = categoryIDFK;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public debateManagedBean() {
    }

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getDebateIDPK() {
        return debateIDPK;
    }

    public void setDebateIDPK(int debateIDPK) {
        this.debateIDPK = debateIDPK;
    }

    public int getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(int subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
    }

    public String getDebateTitle() {
        return debateTitle;
    }

    public void setDebateTitle(String debateTitle) {
        this.debateTitle = debateTitle;
    }

    public String getDebateDescription() {
        return debateDescription;
    }

    public void setDebateDescription(String debateDescription) {
        this.debateDescription = debateDescription;
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

    public List<Subcategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Subcategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public Debate getDebate() {
        return debate;
    }

    public void setDebate(Debate debate) {
        this.debate = debate;
    }

    public String getToday() {
        Calendar cal = Calendar.getInstance();
            SimpleDateFormat simpleformat = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:s");

        Format f = new SimpleDateFormat("dd MMM, yyyy");
        String strDate = f.format(new Date());

        return strDate;

    }

    public boolean checkDate(String debateStartDate, String debateEndDate, String type) throws ParseException {
        
        System.err.println("Type : "+type);
        SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
       
        String currentDate = simpleformat.format(new Date());
        Date today = simpleformat.parse(currentDate);
        Date startDate = simpleformat.parse(debateStartDate);
        Date endDate = simpleformat.parse(debateEndDate);
        System.err.println("Start Date : "+debateStartDate);
        System.err.println("End Date : "+debateEndDate);
        System.err.println("Today Date : "+today.toString());
        if (type.equals("current")) { 
                        if(startDate.compareTo(today) < 0  && endDate.compareTo(today) > 0 ){

                        return true;
                        }else{
                            return false;
                        }
        }
        else if (type.equals("previous") ) {
                        if(endDate.compareTo(today) < 0  ){

                        return true;
                        }else{
                            return false;
                        }
        }
        else if (type.equals("upcoming")) {
                        if(startDate.compareTo(today) > 0){

                        return true;
                        }else{
                            return false;
                        }
        } else {
            return false;
        }
    }

    @PostConstruct
    public void init() {
        categoryList = newsPotalSessionBean.showall_Category();
    }

    public void fillSubCategory() {
        subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
    }

    public List<Debate> showall() {
        try {
            return newsPotalSessionBean.showall_Debate();
        } catch (Exception e) {
            return null;
        }
    }

    public String insert_click() {
        
        try {
                                   InputStream input = file.getInputStream();
                                               String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\debateImage\\";
                                               Random random = new Random();
                                               StringBuilder sb = new StringBuilder();

                                               sb.append(random.nextInt(9) + 1);
                                               for (int i = 0; i < 11; i++) {
                                                   sb.append(random.nextInt(10));
                                               }

                                               String temp = sb.toString();

                                               debateImage = "IMG_"+ temp + file.getSubmittedFileName();
                                               Files.copy(input, new File(path, debateImage).toPath());


                                           Subcategory subCategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
                                    debate.setDebateIDPK(0);
                                    debate.setDebateTitle(debateTitle);
                                    debate.setDeabteDescription(debateDescription);
                                    debate.setDebateImage(debateImage);
                                    debate.setDebateStartDate(debateStartDate);
                                    debate.setDebateEndDate(debateEndDate);
                                    debate.setSubCategoryIDFK(subCategory);
                                    debate.setDebateStatus("1");
                                    debate.setIsActive(true);
                                    newsPotalSessionBean.insertDebate(debate);
                                    clear();
                                    return "/Admin/displayDebate.xhtml?faces-redirect=true";
            
                                       } catch (Exception e) {
                                            return e.getMessage();
                                       }
        
    }

    public String update_click() {
        
         try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\debateImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                debateImage = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, debateImage).toPath());
                
            }
                
                Subcategory subCategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
            debate.setDebateIDPK(debateIDPK);
            debate.setDebateTitle(debateTitle);
            debate.setDeabteDescription(debateDescription);
            debate.setDebateStartDate(debateStartDate);
            debate.setDebateEndDate(debateEndDate);
            debate.setDebateImage(debateImage);
            debate.setSubCategoryIDFK(subCategory);
            debate.setDebateStatus("1");
            newsPotalSessionBean.updateDebate(debate);
            clear();
            return "/Admin/displayDebate.xhtml?faces-redirect=true";

            
        } catch (IOException e) {
            return e.getMessage();
        }
        
       
    }

    public String delete_click(int debateIDPK) {
        try {
            newsPotalSessionBean.deleteDebate(debateIDPK);
            clear();
            return "/Admin/displayDebate.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String search_click(int id) {
        try {
            debate = newsPotalSessionBean.searchDebate(id);
            debateIDPK = debate.getDebateIDPK();
            debateTitle = debate.getDebateTitle();
            debateDescription = debate.getDeabteDescription();
            debateStartDate = debate.getDebateStartDate();
            debateEndDate = debate.getDebateEndDate();
            subCategoryIDFK = debate.getSubCategoryIDFK().getSubCategoryIDPK();
            categoryIDFK = debate.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            debateStatus = debate.getDebateStatus();
            debateImage = debate.getDebateImage();
            subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
            return "/Admin/insertDebate.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String search_singleDebate(int id) {
        try {
            debate = newsPotalSessionBean.searchDebate(id);
            debateIDPK = debate.getDebateIDPK();
            debateTitle = debate.getDebateTitle();
            debateDescription = debate.getDeabteDescription();
            debateStartDate = debate.getDebateStartDate();
            debateEndDate = debate.getDebateEndDate();
            debateImage = debate.getDebateImage();
            subCategoryIDFK = debate.getSubCategoryIDFK().getSubCategoryIDPK();
            debateStatus = debate.getDebateStatus();
            return "./debate.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void insert_comment() {
        try {
            
            SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
              Date today = simpleformat.parse(currentDate);
              
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
            User user = newsPotalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userID").toString()));
            Debate debate = newsPotalSessionBean.searchDebate(debateIDPK);
            comment.setCommentIDPK(0);
            comment.setCommentDescription(commentDescription);
            comment.setCommentDate(currentDate);
            comment.setUserIDFK(user);
            comment.setDebateIDFK(debate);
            comment.setIsActive(true);
            newsPotalSessionBean.insertComment(comment);
            clearcomm();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void clear() {
        debateIDPK = 0;
        debateTitle = "";
        debateDescription = "";
        debateStartDate = "";
        debateEndDate = "";
        subCategoryIDFK = 0;
        categoryIDFK = 0;
        debateImage="";
        debateStatus = "";
    }
    
     public void clearcomm() {
         commentDescription = "";
    }

}
