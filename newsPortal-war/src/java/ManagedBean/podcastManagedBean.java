/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Category;
import Entity.Podcast;
import Entity.Subcategory;
import Entity.User;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import sessionBean.newsPotalSessionBeanLocal;

/**
 *
 * @author maafia_fury
 */
@Named(value = "podcastBean")
@ApplicationScoped
public class podcastManagedBean {
    
       @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
    
    int podcastIDPK , userIDFk ,subCategoryIDFK , categoryIDFK;
    String podcastTitle,userName,subCategoryName , podcastDescription , podcastDate , podcastAudio , grfile ;
    List<User> userList;
    List<Subcategory> subCategoryList;
    List<Category> categoryList;
    Part file;
    
    Podcast podcast = new Podcast();
    
    public podcastManagedBean() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    
    
    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getSubCategoryIDFK() {
        return subCategoryIDFK;
    }

    public void setSubCategoryIDFK(int subCategoryIDFK) {
        this.subCategoryIDFK = subCategoryIDFK;
    }

    public int getCategoryIDFK() {
        return categoryIDFK;
    }

    public void setCategoryIDFK(int categoryIDFK) {
        this.categoryIDFK = categoryIDFK;
    }

    public List<Subcategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Subcategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categpryList) {
        this.categoryList = categpryList;
    }
    
    

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getPodcastIDPK() {
        return podcastIDPK;
    }

    public void setPodcastIDPK(int podcastIDPK) {
        this.podcastIDPK = podcastIDPK;
    }

    public int getUserIDFk() {
        return userIDFk;
    }

    public void setUserIDFk(int userIDFk) {
        this.userIDFk = userIDFk;
    }

    public String getPodcastTitle() {
        return podcastTitle;
    }

    public void setPodcastTitle(String podcastTitle) {
        this.podcastTitle = podcastTitle;
    }

    public String getPodcastDescription() {
        return podcastDescription;
    }

    public void setPodcastDescription(String podcastDescription) {
        this.podcastDescription = podcastDescription;
    }

    public String getPodcastDate() {
        return podcastDate;
    }

    public void setPodcastDate(String podcastDate) {
        this.podcastDate = podcastDate;
    }

    public String getPodcastAudio() {
        return podcastAudio;
    }

    public void setPodcastAudio(String podcastAudio) {
        this.podcastAudio = podcastAudio;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public Podcast getPodcast() {
        return podcast;
    }

    public void setPodcast(Podcast podcast) {
        this.podcast = podcast;
    }
    
    @PostConstruct
    public void init() {
        userList = newsPotalSessionBean.showall_User();
        categoryList = newsPotalSessionBean.showall_Category();
    }
    
    public void fillSubCategory() {
        subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
    }
    
    public List<Podcast> showall() {
        try {
            return newsPotalSessionBean.showall_Podcast();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insert_click()
    {
        try {
            
             SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
              
              HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession userSession = request.getSession();
            
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\podcastAudio\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                
                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                
                String temp = sb.toString();
                
                grfile = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, grfile).toPath());
            
                User user = newsPotalSessionBean.searchUser(Integer.parseInt(userSession.getAttribute("userID").toString()));
                Subcategory subCategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
                podcast.setPodcastIDPK(0);
                podcast.setPodcastTitle(podcastTitle);
                podcast.setPodcastDescription(podcastDescription);
                podcast.setPodcastDate(currentDate);
                podcast.setPodcastAudio(grfile);
                podcast.setUserIDFK(user);
                podcast.setSubCategoryIDFK(subCategory);
                podcast.setIsActive(true);
                newsPotalSessionBean.insertPodcast(podcast);
                clear();
                return "/Admin/displayPodcast.xhtml?faces-redirect=true";
                
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String update_click()
    {
        try {
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\podcastAudio\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                grfile = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, grfile).toPath());

            }
            
                User user = newsPotalSessionBean.searchUser(userIDFk);
                Subcategory subCategory = newsPotalSessionBean.searchSubcategory(subCategoryIDFK);
                podcast.setPodcastIDPK(podcastIDPK);
                podcast.setPodcastTitle(podcastTitle);
                podcast.setPodcastDescription(podcastDescription);
                podcast.setPodcastDate(podcastDate);
                podcast.setSubCategoryIDFK(subCategory);
                podcast.setPodcastAudio(grfile);
                podcast.setUserIDFK(user);
                podcast.setIsActive(true);
                newsPotalSessionBean.updatePodcast(podcast);
                   clear();
                 return "/Admin/displayPodcast.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String delete_click(int podcastID)
    {
        try {
            newsPotalSessionBean.deletePodcast(podcastID);
               clear();
                return "/Admin/displayPodcast.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String search_click(int id)
    {
        try {
           podcast = newsPotalSessionBean.searchPodcast(id);
            podcastIDPK = podcast.getPodcastIDPK();
            podcastTitle = podcast.getPodcastTitle();
            podcastDescription = podcast.getPodcastDescription();
            podcastDate = podcast.getPodcastDate();
            podcastAudio = podcast.getPodcastAudio();
            subCategoryIDFK = podcast.getSubCategoryIDFK().getSubCategoryIDPK();
            categoryIDFK = podcast.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
                return "/Admin/insertPodcast.xhtml?faces-redirect=true";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
     public String singleSearch_click(int id)
    {
        try {
           podcast = newsPotalSessionBean.searchPodcast(id);
            podcastIDPK = podcast.getPodcastIDPK();
            podcastTitle = podcast.getPodcastTitle();
            podcastDescription = podcast.getPodcastDescription();
            podcastDate = podcast.getPodcastDate();
            podcastAudio = podcast.getPodcastAudio();
            subCategoryIDFK = podcast.getSubCategoryIDFK().getSubCategoryIDPK();
            categoryIDFK = podcast.getSubCategoryIDFK().getCategoryIDFK().getCategoryIDPK();
            subCategoryName = podcast.getSubCategoryIDFK().getSubCategoryName();
            userName = podcast.getUserIDFK().getUserName();
            subCategoryList = newsPotalSessionBean.showall_SubcategoryByCategory(categoryIDFK);
            
                return "./podcast.xhtml";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public void clear(){
        podcastIDPK = 0;
        podcastTitle = "";
        podcastDescription = "";
        podcastDate = "";
        podcastAudio = "";
        subCategoryIDFK =0;
        userIDFk = 0;
    }
    
}
