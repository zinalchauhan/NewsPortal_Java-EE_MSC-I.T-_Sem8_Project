/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package sessionBean;

import Entity.Ads;
import Entity.Blog;
import Entity.Category;
import Entity.City;
import Entity.Comment;
import Entity.Country;
import Entity.Debate;
import Entity.Job;
import Entity.News;
import Entity.Newsimage;

import Entity.Notification;
import Entity.Podcast;
import Entity.State;
import Entity.Subcategory;
import Entity.User;

import Entity.Videonews;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maafia_fury
 */
@Local
public interface newsPotalSessionBeanLocal {
    
    
       //===================================COUNTRY
      public String insertCountry(Country country);
    public String updateCountry(Country country);
    public String deleteCountry(int countryID);
    public Country searchCountry(int countryID);
    public List<Country> showall_Country();
    
       //===================================STATE
    
     public String insertState(State state);
    public String updateState(State state);
    public String deleteState(int stateID);
    public State searchState(int stateID);
      public List<State> showall_State();
      
      //==================================CITY
      
      public String insertCity(City city);
    public String updateCity(City city);
    public String deleteCity(int cityID);
    public City searchCity(int cityID);
     public List<City> showall_City();
     public List<City> showall_CityByState(int id);
     
     
     //========================================ADS
     
       public String insertAds(Ads ads);
    public String updateAds(Ads ads);
    public String deleteAds(int adsID);
    public Ads searchAds(int adsID);
    public List<Ads> showall_Ads();
    
    //===================================BLOG
    
      public String insertBlog(Blog blog);
    public String updateBlog(Blog blog);
    public String deleteBlog(int blogID);
    public Blog searchBlog(int blogID);
     public List<Blog> showall_Blog();
     
     
     //==================================CATEGORY
    public String insertCategory(Category category);
    public String updateCategory(Category category);
    public String deleteCategory(int categoryID);
    public Category searchCategory(int categoryID);
    public List<Category> showall_Category();
    
    //==================================SUBCATEGORY
    public String insertSubcategory(Subcategory subcategory);
    public String updateSubcategory(Subcategory subcategory);
    public String deleteSubcategory(int subCategoryID);
    public Subcategory searchSubcategory(int subCategoryID);
     public List<Subcategory> showall_Subcategory();
     public List<Subcategory> showall_SubcategoryByCategory(int id);
    
    //======================================JOB
     public String insertJob(Job job);
    public String updateJob(Job job);
    public String deleteJob(int jobID);
    public Job searchJob(int jobID);
    public List<Job> showall_Job();
    
    //=========================================NEWS
    public int insertNews(News news);
    public String updateNews(News news);
    public String deleteNews(int newsID);
    public News searchNews(int newsID);
    public List<News> showall_News();
    public List<News> showall_NewsByCity(int id);
     
     
     //==========================================COMMENT
    
    public String insertComment(Comment comment);
    public String updateComment(Comment comment);
    public String deleteComment(int commentID);
    public Comment searchComment(int commentID);
    public List<Comment> showall_Comment();
     public List<Comment> showCommentByDebateIDFK(int debateIDFK);
    
    
        //======================================DEBATE
    
    
    public String insertDebate(Debate debate);
    public String updateDebate(Debate debate);
    public String deleteDebate(int debateID);
    public Debate searchDebate(int debateID);
    public List<Debate> showall_Debate();
    
    
    //===================================PODCAST
    
    
       
    public String insertPodcast(Podcast podcast);
    public String updatePodcast(Podcast podcast);
    public String deletePodcast(int podcastID);
    public Podcast searchPodcast(int podcastID);
    public List<Podcast> showall_Podcast();
    
    //===========================NEWSIMAGE
    
    
     public String insertNewsImage(Newsimage newsimage);
    public String updateNewsImage(Newsimage newsimage);
    public String deleteNewsImage(int imageID);
    public Newsimage searchNewsImage(int imageID);
    public List<Newsimage> showall_NewsImage();
    public List<Newsimage> showImageByNews(int newsID);
    
//===========================VIDEO-NEWS
    
      public String insertVideoNews(Videonews videoNews);
    public String updateVideoNews(Videonews videoNews);
    public String deleteVideoNews(int videoID);
    public Videonews searchVideoNews(int videoID);
    public List<Videonews> showall_VideoNews();
    
    //==================================USER
    
         public String insertUser(User user);
    public String updateUser(User user);
    public String deleteUser(int userID);
    public User searchUser(int userID);
    public List<User> showall_User();
    public User searchUserByEmail(String userEmail);
    public User findmail(String userEmail);
    public List<User> showUserByType();
    
    
    
   //====================================NOTIFICATION 
    
    public String insertNotification(Notification notification);
    public String updateNotification(Notification notification);
    public String deleteNotification(int notificationID);
    public Notification searchNotification(int notificationID);
    public List<Notification> showall_Notification();
    
    //==================================USER-LOGIN
    
//        public String insertUserLogin(Userlogin userLogin);
//    public String deleteUserLogin(int userLoginID);
//    public Userlogin searchUserLogin(int userLoginID);
//    public List<Userlogin> showall_UserLogin();
    
    
    public User Login(String userEmail,String userPassword);
    
    
    
    
    public String isAvailableStatus(int newsIDPK, String newsStatus);
    
    
    
    
    
    
}
