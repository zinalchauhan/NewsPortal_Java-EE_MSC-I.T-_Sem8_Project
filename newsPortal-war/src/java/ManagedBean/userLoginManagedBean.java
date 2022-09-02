/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.City;
import Entity.User;
import java.io.IOException;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;
import java.util.Random;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Properties;



/**
 *
 * @author maafia_fury
 */
@Named(value = "userLoginBean")
@ApplicationScoped
public class userLoginManagedBean {

    @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;

    int userloginIDPK,userIDPK,cityIDFK;
    String userEmail,userMobile, userPassword, userType, userID, userName,comment,emailmessage,userImage  , email , userAddress , cityid , stateid , userGender;
    List<User> userList;

   // Userlogin userLogin = new Userlogin();
    
     User user = new User();

    public int getCityIDFK() {
        return cityIDFK;
    }

    public void setCityIDFK(int cityIDFK) {
        this.cityIDFK = cityIDFK;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getStateid() {
        return stateid;
    }

    public void setStateid(String stateid) {
        this.stateid = stateid;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
     
     

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }
     
     
     

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
     
     

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmailmessage() {
        return emailmessage;
    }

    public void setEmailmessage(String emailmessage) {
        this.emailmessage = emailmessage;
    }
    
    
    

    public userLoginManagedBean() {
    }

    public newsPotalSessionBeanLocal getNewsPortalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPortalSessionBean(newsPotalSessionBeanLocal newsPortalSessionBean) {
        this.newsPotalSessionBean = newsPortalSessionBean;
    }

    public int getUserloginIDPK() {
        return userloginIDPK;
    }

    public void setUserloginIDPK(int userloginIDPK) {
        this.userloginIDPK = userloginIDPK;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

//    public Userlogin getUserLogin() {
//        return userLogin;
//    }
//
//    public void setUserLogin(Userlogin userLogin) {
//        this.userLogin = userLogin;
//    }

//    public void insert_click() {
//        try {
//            User user = newsPotalSessionBean.searchUserByEmail(userEmail);
//            userLogin.setUserloginIDPK(0);
//            userLogin.setUserEmail(user);
//            userLogin.setUserPassword(user);
//            userLogin.setUserType(userType);
//            newsPotalSessionBean.insertUserLogin(userLogin);
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
//
//    public void delete_click(int userloginIDPK) {
//        try {
//            newsPotalSessionBean.deleteUserLogin(userloginIDPK);
//        } catch (Exception e) {
//            e.getMessage();
//        }
//    }
//
//    public void search_click(int id) {
//        try {
//            userLogin = newsPotalSessionBean.searchUserLogin(id);
//            userloginIDPK = userLogin.getUserloginIDPK();
//            userType = userLogin.getUserType();
//            userEmail = userLogin.getUserEmail().getUserEmail();
//            userPassword = userLogin.getUserPassword().getUserPassword();
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//    }

    public String login() {
        
        try {
            
            User um = newsPotalSessionBean.Login(userEmail, userPassword);

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession();
        
        

        if (um.getUserType().equals( "reporter") || um.getUserType().equals( "admin") || um.getUserType().equals( "editor")  ) {
         userID = um.getUserIDPK().toString();
            userName = um.getUserName();
            userType = um.getUserType();
            email = um.getUserEmail();
            userMobile = um.getUserMobile();
            userImage = um.getUserImage();
            userAddress = um.getUserAddress();
            cityid = um.getCityIDFK().getCityName();
            stateid = um.getCityIDFK().getStateIDFK().getStateName();
            userGender = um.getUserGender();
            userSession.setAttribute("userID", userID);
            userSession.setAttribute("userName", userName);
            userSession.setAttribute("userEmail", email);
            userSession.setAttribute("userType", userType);
            userSession.setAttribute("userAddress", userAddress);
            userSession.setAttribute("userGender", userGender);
            userSession.setAttribute("city", cityid);
            userSession.setAttribute("state", stateid);
            userSession.setAttribute("userMobile", userMobile);
            userSession.setAttribute("userImage", userImage);
            clear();
            return "/Admin/index.xhtml?faces-redirect=true";
            
        }else if(um.getUserType().equals( "user")){
             userID = um.getUserIDPK().toString();
            userName = um.getUserName();
            userType = um.getUserType();
            userSession.setAttribute("userID", userID);
            userSession.setAttribute("userName", userName);
            userSession.setAttribute("userType", userType);
            return "/User/index.xhtml?faces-redirect=true";
            
        }else{
            return "./login.xhtml?faces-redirect=true";
        }
            
        } catch (Exception e) {
            
              return "./login.xhtml?faces-redirect=true";
            
        }
        
        
    }
    
    
    
    public String logout(){
        
      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession();
        
        
        
        //userSession.removeAttribute("userID");
        userSession.invalidate();
        
         return "/login.xhtml?faces-redirect=true";
  }
    
     
    public String logoutUser(){
        
      HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        HttpSession userSession = request.getSession();
        
        
        
        //userSession.removeAttribute("userID");
        userSession.invalidate();
        
         return "./login.xhtml?faces-redirect=true";
  }
    
     public void sendEmail(String email, String desc, String sub) throws IOException, MessagingException  {
        String[] to
                = {
                    email
                };
        
// list of recipient email addresses
        String subject = "Change Password:" + sub;
      String comment;
        comment = "Your Description :" + desc;
        String result = intiSendEmail(to, subject, comment);
        System.err.println("Email ++ "+result);
    }

    
    
    
   public String intiSendEmail(String[] to, String subject, String body) throws IOException, MessagingException {
        String status;
        String USER_NAME = "komalpatel@metanoiainfotech.com", PASSWORD = "komal@2022";
        Properties props = System.getProperties();
        String host = "mail.metanoiainfotech.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", USER_NAME);
        props.put("mail.smtp.password", PASSWORD);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(USER_NAME,"newsPortal"));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (InternetAddress toAddres : toAddress) {
                message.addRecipient(Message.RecipientType.TO, toAddres);
            }

            message.setSubject(subject);
            message.setText(body);
            message.setContent(body, "text/html;charset=utf-8");
            Transport transport = session.getTransport("smtp");
            transport.connect(host, USER_NAME, PASSWORD);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            System.out.println("managedBean.loginManagedBean.intiSendEmail()"+ae);
            return status = "Cannot send Message!";
        } catch (MessagingException me) {
            System.out.println("managedBean.loginManagedBean.intiSendEmail()"+me);
            return status = "Cannot send Message!";
        }

        return status = "Message is send!";
    }
   
   
   
   
    public String forgotPassword(){
        try {
            
            User us = newsPotalSessionBean.findmail(userEmail);
           
            System.out.println("ManagedBean.loginManagedBean.forgotPassword()"+userEmail);
            if (getUserEmail().equalsIgnoreCase(userEmail)) {
                System.out.println("ManagedBean.loginManagedBean.forgotPassword()"+userEmail);

               
                comment = "<h4>Change Your Password Through Below Link</h4>"
                        + "<a href='http://localhost:8080/newsPortal-war/forgetPassword.xhtml'>Click link to change password</a>";
                sendEmail(userEmail, comment, "Forgot Password");
                emailmessage="";
            } else {
                emailmessage = "Email is not valid";
                return "/forgetpassword.xhtml?faces-redirect=true";
            }
           
        } catch (Exception e) {
            return emailmessage="Email is not valid";
        }   
        return "./User/login.xhtml?faces-redirect=true";
    }
    
    
    
      public String updatepass_click()
    {
        try {
             User us = newsPotalSessionBean.findmail(userEmail);
            System.out.println("ManagedBean.loginManagedBean.updatepass_click()"+us);
          
          
             City city = newsPotalSessionBean.searchCity(cityIDFK);
                user.setUserIDPK(us.getUserIDPK());
                user.setUserName(us.getUserName());
                user.setUserPassword(userPassword);
                user.setUserImage(us.getUserImage());
                user.setUserEmail(us.getUserEmail());
                user.setUserMobile(us.getUserMobile());
                user.setUserStatus(us.getUserStatus());
                user.setIsActive(us.getIsActive());
                user.setCityIDFK(us.getCityIDFK());
                user.setUserType(us.getUserType());
                user.setUserAddress(us.getUserAddress());
                user.setUserGender(us.getUserGender());
                newsPotalSessionBean.updateUser(user);
   
         return "/login.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
        
    }
      
       public void clear(){
        userEmail="";
        userPassword="";
        userType="";
        userloginIDPK=0;
    }
    
    
   

}
