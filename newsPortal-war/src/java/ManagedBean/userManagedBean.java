/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.City;
import Entity.State;
import Entity.User;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import java.util.Random;
import javax.annotation.PostConstruct;
import javax.servlet.http.Part;

/**
 *
 * @author maafia_fury
 */
@Named(value = "userBean")
@ApplicationScoped
public class userManagedBean {
    
     @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;

     
      int userIDPK , userStatus , cityIDFK,stateIDFK;
    String userName , userPassword,cityName,stateName,userGender,userAddress , userImage , grfile , userEmail , userMobile,userType;
    List<City> cityList;
    Part file;
     List<State> stateList;
    User user = new User();
    
    
    
    public userManagedBean() {
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    
    
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

  
    
    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }
    
    

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getStateIDFK() {
        return stateIDFK;
    }

    public void setStateIDFK(int stateIDFK) {
        this.stateIDFK = stateIDFK;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

 
    

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getGrfile() {
        return grfile;
    }

    public void setGrfile(String grfile) {
        this.grfile = grfile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    @PostConstruct
    public void init() {
          stateList = newsPotalSessionBean.showall_State();
    }
    
     
    public void fillCity() {
        cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
    }
    
    public List<User> showall() {
        try {
            return newsPotalSessionBean.showall_User();
        } catch (Exception e) {
            return null;
        }
    }
    
    
    public List<User> showallUser() {
        try {
            return newsPotalSessionBean.showUserByType();
        } catch (Exception e) {
            return null;
        }
    }
    
    public String insert_user()
    {
        try {
            
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\userImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                
                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                
                String temp = sb.toString();
                
                userImage = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, userImage).toPath());
            
                City city = newsPotalSessionBean.searchCity(cityIDFK);
                user.setUserIDPK(0);
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setUserEmail(userEmail);
                user.setUserMobile(userMobile);
                user.setUserImage(userImage);
                user.setUserStatus(1);
                user.setCityIDFK(city);
                user.setUserAddress(userAddress);
                user.setUserGender(userGender);
                user.setUserType(userType);
                user.setIsActive(true);
                
                newsPotalSessionBean.insertUser(user);
            
                clear();
            return "/Admin/displayUser.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String insert_click()
    {
        try {
            
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\userImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();
                
                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                
                String temp = sb.toString();
                
                userImage = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, userImage).toPath());
            
                City city = newsPotalSessionBean.searchCity(cityIDFK);
                user.setUserIDPK(0);
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setUserEmail(userEmail);
                user.setUserMobile(userMobile);
                user.setUserImage(userImage);
                user.setUserStatus(1);
                user.setCityIDFK(city);
                user.setUserAddress(userAddress);
                user.setUserGender(userGender);
                user.setUserType("user");
                user.setIsActive(true);
                
                newsPotalSessionBean.insertUser(user);
            
                clear();
            return "/login.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    public String update_click()
    {
        try {
            
            
            if(file != null) {
        
                InputStream input = file.getInputStream();
                String path = "F:\\project_sem8\\newsportal\\newsPortal\\newsPortal-war\\web\\upload\\userImage\\";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();

                userImage = "IMG_"+ temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, userImage).toPath());

            }
          
            
            System.err.println("Image : "+ userImage);
                City city = newsPotalSessionBean.searchCity(cityIDFK);
                User updateUser = newsPotalSessionBean.searchUser(userIDPK);
                updateUser.setUserName(userName);
                updateUser.setUserEmail(userEmail);
                updateUser.setUserMobile(userMobile);
                updateUser.setUserImage(userImage);
                updateUser.setCityIDFK(city);
                newsPotalSessionBean.updateUser(updateUser);
                
                 return "./userProfile.xhtml?faces-redirect=true";
                
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    public String updateProfile(){
        
        try {
            
        City city = newsPotalSessionBean.searchCity(cityIDFK);
        User updateu = newsPotalSessionBean.searchUser(userIDPK);
        updateu.setUserName(userName);
        updateu.setUserEmail(userEmail);
        updateu.setUserMobile(userMobile);
        updateu.setCityIDFK(city);
        newsPotalSessionBean.updateUser(updateu);
        
        
        
           return "./userProfile.xhtml?faces-redirect=true";
            
            
        } catch (Exception e) {
            
            return e.getMessage();
        }
        
        
        
    }
    
    
    public void delete_click(int userIDPK)
    {
        try {
            newsPotalSessionBean.deleteUser(userIDPK);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    public void search_click(int id)
    {
        try {
            user = newsPotalSessionBean.searchUser(id);
            userIDPK = user.getUserIDPK();
            userName = user.getUserName();
            userPassword = user.getUserPassword();
            userImage = user.getUserImage();
            userEmail = user.getUserEmail();
            userMobile = user.getUserMobile();
            userStatus = user.getUserStatus();
            cityIDFK = user.getCityIDFK().getCityIDPK();
        } catch (Exception e) {
            e.getMessage();
        }
    }
    
    
    
    public String search_singleUser(int id) {
        try {
            user = newsPotalSessionBean.searchUser(id);
            userIDPK = user.getUserIDPK();
            userName = user.getUserName();
            userPassword = user.getUserPassword();
            userImage = user.getUserImage();
            userEmail =  user.getUserEmail();
            userMobile = user.getUserMobile();
            cityIDFK = user.getCityIDFK().getCityIDPK();
            cityName = user.getCityIDFK().getCityName();
            stateName = user.getCityIDFK().getStateIDFK().getStateName();
            stateIDFK = user.getCityIDFK().getStateIDFK().getStateIDPK();
            
             cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
           
            return "./updateProfile.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
        public String search_singleUserProfile(int id) {
        try {
            user = newsPotalSessionBean.searchUser(id);
            userIDPK = user.getUserIDPK();
            userName = user.getUserName();
            userPassword = user.getUserPassword();
            userImage = user.getUserImage();
            userEmail =  user.getUserEmail();
            userMobile = user.getUserMobile();
            cityIDFK = user.getCityIDFK().getCityIDPK();
             stateIDFK = user.getCityIDFK().getStateIDFK().getStateIDPK();
               cityName = user.getCityIDFK().getCityName();
            stateName = user.getCityIDFK().getStateIDFK().getStateName();
            
             cityList = newsPotalSessionBean.showall_CityByState(stateIDFK);
           
           
            return "./userProfile.xhtml?faces-redirect=true";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    
    
    




    
    public void clear(){
        userIDPK = 0;
        userName = "";
        userPassword = "";
        userImage = "";
        userEmail = "";
        userMobile = "";
        userStatus = 0;
        cityIDFK = 0;
    }
   
     
     
  
    
}
