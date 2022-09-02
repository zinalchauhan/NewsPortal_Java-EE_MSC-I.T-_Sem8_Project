/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.News;
import Entity.Notification;
import Entity.User;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;

/**
 *
 * @author maafia_fury
 */
@Named(value = "notificationBean")
@ApplicationScoped
public class notificationManagedBean {
    
      @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
     

      int notificationIDPK,newsIDFK,userIDFK;
      String notificationStatus;
      Notification notification = new Notification();
      List<News> newsList; 
      List<User> userList; 

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
      

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getNotificationIDPK() {
        return notificationIDPK;
    }

    public void setNotificationIDPK(int notificationIDPK) {
        this.notificationIDPK = notificationIDPK;
    }

    public int getNewsIDFK() {
        return newsIDFK;
    }

    public void setNewsIDFK(int newsIDFK) {
        this.newsIDFK = newsIDFK;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public String getNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(String notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

   

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    
    
    public void init(){
       userList = newsPotalSessionBean.showall_User();
       newsList = newsPotalSessionBean.showall_News();
       
   }
    
     public List<Notification> show_notificationList() {
        try {
            return newsPotalSessionBean.showall_Notification();
        } catch (Exception e) {
            return null;
        }
    }
      
     
      public void insert_click()
    {
        try {
            User user = newsPotalSessionBean.searchUser(userIDFK);
           News news = newsPotalSessionBean.searchNews(newsIDFK);
            notification.setNotificationIDPK(0);
            notification.setNotificationStatus(notificationStatus);
            notification.setNewsIDFK(news);
            notification.setUserIDFK(user);
            newsPotalSessionBean.insertNotification(notification);
        } catch (Exception e) {
            e.getMessage();
        }
    }
      
      
       public void update_click()
    {
        try {
           User user = newsPotalSessionBean.searchUser(userIDFK);
           News news = newsPotalSessionBean.searchNews(newsIDFK);
              notification.setNotificationIDPK(notificationIDPK);
            notification.setNotificationStatus(notificationStatus);
            notification.setNewsIDFK(news);
            notification.setUserIDFK(user);
            newsPotalSessionBean.updateNotification(notification);
        } catch (Exception e) {
            e.getMessage();
        }
    }
      
       
         public void delete_click(int notificationIDPK)
    {
        try {
            newsPotalSessionBean.deleteNotification(notificationIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
       
        public void search_click(int id)
    {
        try {
            notification = newsPotalSessionBean.searchNotification(id);
            notificationIDPK = notification.getNotificationIDPK();
            notificationStatus = notification.getNotificationStatus();
            newsIDFK=notification.getNewsIDFK().getNewsIDPK();
            userIDFK=notification.getUserIDFK().getUserIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
        
        public void clear(){
        notificationIDPK = 0;
        notificationStatus = "";
        newsIDFK = 0;
        userIDFK = 0;
    }
      
      
      
      
      
      
      
      
      
      
      
      
      
   
      
      
      
      
      
    /**
     * Creates a new instance of notificationManagedBean
     */
    public notificationManagedBean() {
    }
    
}
