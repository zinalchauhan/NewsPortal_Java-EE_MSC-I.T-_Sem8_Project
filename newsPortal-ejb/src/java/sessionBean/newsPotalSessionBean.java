/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author maafia_fury
 */
@Stateless
public class newsPotalSessionBean implements newsPotalSessionBeanLocal {
    
    @PersistenceContext(unitName = "newsPortal-ejbPU")
    private EntityManager em;

    //=============================COUNTRY===================
    
    @Override
    public String insertCountry(Country country) {
            
          try {
            em.persist(country);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
            
    }

    @Override
    public String updateCountry(Country country) {

         try {
            Country updatecountry=em.find(Country.class, country.getCountryIDPK());
            updatecountry.setCountryIDPK(country.getCountryIDPK());
             updatecountry.setCountryName(country.getCountryName());
               em.merge(updatecountry);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    @Override
    public String deleteCountry(int countryID) {

        
        try {
              Country updateCountry=em.find(Country.class, countryID);
              updateCountry.setIsActive(false);
              
              em.persist(updateCountry);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }

    }

    @Override
    public Country searchCountry(int countryID) {
        try {
             Country country=em.find(Country.class,countryID);
           return country;
        } catch (Exception e) {
            return null;
        }
       
    }

    @Override
    public List<Country> showall_Country() {

        List<Country> countrylist=em.createNamedQuery("Country.findAll").getResultList();
       return countrylist;

    }
    
    
    //===================================STATE

    @Override
    public String insertState(State state) {

             try {
            em.persist(state);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }


    }

    @Override
    public String updateState(State state) {

           try {
            State updatestate=em.find(State.class, state.getStateIDPK());
            Country m=em.find(Country.class,state.getCountryIDFK().getCountryIDPK());
            updatestate.setStateIDPK(state.getStateIDPK());
             updatestate.setStateName(state.getStateName());
              updatestate.setCountryIDFK(m);
              updatestate.setIsActive(state.getIsActive());
     
               em.persist(updatestate);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String deleteState(int stateID) {
        
          try {
              State deleteState=em.find(State.class, stateID);
              deleteState.setIsActive(false);
              
              em.persist(deleteState);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }

    }

    @Override
    public State searchState(int stateID) {

               try {
             State state=em.find(State.class,stateID);
           return state;
        } catch (Exception e) {
            return null;
        }


    }

      @Override
    public List<State> showall_State() {

           try {
             List<State> statelist=em.createNamedQuery("State.findAll").getResultList();
       return statelist;
        } catch (Exception e) {
            return null;
        }


    }
    
    
    //==================================CITY

    @Override
    public String insertCity(City city) {
        
             try {
            em.persist(city);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String updateCity(City city) {

             try {
            City updatecity=em.find(City.class, city.getCityIDPK());
            State m=em.find(State.class,city.getStateIDFK().getStateIDPK());
            updatecity.setCityIDPK(city.getCityIDPK());
             updatecity.setCityName(city.getCityName());
              updatecity.setStateIDFK(m);
              updatecity.setIsActive(city.getIsActive());
               em.persist(updatecity);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }


    }

    @Override
    public String deleteCity(int cityID) {
        
         try {
              City deleteCity=em.find(City.class, cityID);
              deleteCity.setIsActive(false);
              
              em.persist(deleteCity);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }


    }

    @Override
    public City searchCity(int cityID) {

          try {
             City city=em.find(City.class,cityID);
           return city;
        } catch (Exception e) {
            return null;
        }


    }

    @Override
    public List<City> showall_City() {

          try {
             List<City> citylist=em.createNamedQuery("City.findAll").getResultList();
       return citylist;
        } catch (Exception e) {
            return null;
        }

    }
    
     @Override
    public List<City> showall_CityByState(int id) {
        try {
             List<City> citylist=em.createNamedQuery("City.findCityByState").setParameter("stateIDFK", id).getResultList();
             return citylist;
        } catch (Exception e) {
            return null;
        }
    }
    
    
    //========================================ADS

    @Override
   public String insertAds(Ads ads) {
          try {
            em.persist(ads);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String updateAds(Ads ads) {
        
         try {
            Ads updateads=em.find(Ads.class, ads.getAdsIDPK());
            updateads.setAdsIDPK(ads.getAdsIDPK());
            updateads.setAdsTitle(ads.getAdsTitle());
            updateads.setAdsDescription(ads.getAdsDescription());
            updateads.setAdsDate(ads.getAdsDate());
            updateads.setAdsImage(ads.getAdsImage());
            updateads.setAdsStatus(ads.getAdsStatus());
            
             
               em.merge(updateads);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    @Override
    public String deleteAds(int adsID) {
        
         try {
              Ads updateAds=em.find(Ads.class, adsID);
              updateAds.setIsActive(false);
              
              em.persist(updateAds);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
        
        
    }

    @Override
    public Ads searchAds(int adsID) {
        
         try {
             Ads ads=em.find(Ads.class, adsID);
           return ads;
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public List<Ads> showall_Ads() {
        
          List<Ads> countrylist=em.createNamedQuery("Ads.findAll").getResultList();
       return countrylist;

    } 
    
//===================================BLOG

    @Override
    public String insertBlog(Blog blog) {
        
             try {
            em.persist(blog);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateBlog(Blog blog) {

         try {
            Blog updateBlog=em.find(Blog.class, blog.getBlogIDPK());
            Subcategory s=em.find(Subcategory.class,blog.getSubCategoryIDFK().getSubCategoryIDPK());
            User u=em.find(User.class,blog.getUserIDFK().getUserIDPK());
            
            updateBlog.setBlogIDPK(blog.getBlogIDPK());
            updateBlog.setBlogTitle(blog.getBlogTitle());
             updateBlog.setBlogDescription(blog.getBlogDescription());
             updateBlog.setBlogDate(blog.getBlogDate());
             updateBlog.setBlogStatus(blog.getBlogStatus());
               updateBlog.setBlogImage(blog.getBlogImage());
             updateBlog.setSubCategoryIDFK(s);
             updateBlog.setUserIDFK(u);
             updateBlog.setBlogAuthor(blog.getBlogAuthor());
             
              
           
     
               em.persist(updateBlog);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

        
    }

    @Override
    public String deleteBlog(int blogID) {
        
        try {
              Blog deleteBlog=em.find(Blog.class, blogID);
              deleteBlog.setIsActive(false);
              
              em.persist(deleteBlog);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }

    }

    @Override
    public Blog searchBlog(int blogID) {

          try {
             Blog searchBlog=em.find(Blog.class,blogID);
           return searchBlog;
        } catch (Exception e) {
            return null;
        }
        
    }

    @Override
    public List<Blog> showall_Blog() {

         try {
             List<Blog> bloglist=em.createNamedQuery("Blog.findAll").getResultList();
       return bloglist;
        } catch (Exception e) {
            return null;
        }

        
    }
    
    
    //================================CATEGORY
    @Override
    public String insertCategory(Category category) {
         try {
            em.persist(category);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateCategory(Category category) {
        try {
            Category updateCategory=em.find(Category.class, category.getCategoryIDPK());
            updateCategory.setCategoryIDPK(category.getCategoryIDPK());
             updateCategory.setCategoryName(category.getCategoryName());
             updateCategory.setCategoryIcon(category.getCategoryIcon());
               em.merge(updateCategory);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteCategory(int categoryID) {
        try {
              Category updateCategory=em.find(Category.class, categoryID);
              updateCategory.setIsActive(false);
              em.persist(updateCategory);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public Category searchCategory(int categoryID) {
         try {
             Category category=em.find(Category.class,categoryID);
           return category;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Category> showall_Category() {
         List<Category> categorylist=em.createNamedQuery("Category.findAll").getResultList();
       return categorylist;
    }

    
    //================================SUBCATEGORY
    @Override
    public String insertSubcategory(Subcategory subcategory) {
        try {
            em.persist(subcategory);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateSubcategory(Subcategory subcategory) {
        try {
            Subcategory updatesubcategory=em.find(Subcategory.class, subcategory.getSubCategoryIDPK());
            Category c=em.find(Category.class,subcategory.getCategoryIDFK().getCategoryIDPK());
            updatesubcategory.setSubCategoryIDPK(subcategory.getSubCategoryIDPK());
             updatesubcategory.setSubCategoryName(subcategory.getSubCategoryName());
              updatesubcategory.setCategoryIDFK(c);
               em.persist(updatesubcategory);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteSubcategory(int subCategoryID) {
        try {
              Subcategory deletesubcategory=em.find(Subcategory.class, subCategoryID);
              deletesubcategory.setIsActive(false);
              
              em.persist(deletesubcategory);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public Subcategory searchSubcategory(int subCategoryID) {
        try {
             Subcategory subcategory=em.find(Subcategory.class,subCategoryID);
           return subcategory;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Subcategory> showall_Subcategory() {
        try {
             List<Subcategory> subcategorylist=em.createNamedQuery("Subcategory.findAll").getResultList();
       return subcategorylist;
        } catch (Exception e) {
            return null;
        }
    }
    
     @Override
    public List<Subcategory> showall_SubcategoryByCategory(int id) {
        try {
             List<Subcategory> subcategorylist=em.createNamedQuery("Subcategory.findSubcategoryByCategory").setParameter("categoryIDFK", id).getResultList();
             return subcategorylist;
        } catch (Exception e) {
            return null;
        }
    }

    
    //====================================JOB
    @Override
    public String insertJob(Job job) {
         try {
            em.persist(job);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateJob(Job job) {
        try {
            Job updatejob=em.find(Job.class, job.getJobIDPK());
             updatejob.setJobIDPK(job.getJobIDPK());
             updatejob.setJobTitle(job.getJobTitle());
             updatejob.setJobDescription(job.getJobDescription());
             updatejob.setJobDate(job.getJobDate());
             updatejob.setJobStatus(job.getJobStatus());
               em.merge(updatejob);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteJob(int jobID) {
        try {
              Job updatejob=em.find(Job.class, jobID);
              updatejob.setIsActive(false);
              em.persist(updatejob);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public Job searchJob(int jobID) {
        try {
             Job job=em.find(Job.class,jobID);
           return job;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Job> showall_Job() {
        List<Job> joblist=em.createNamedQuery("Job.findAll").getResultList();
       return joblist;
    }

    
    //=========================================NEWS
    @Override
    public int insertNews(News news) {
        try {
            
            em.persist(news);
            em.flush();
            return news.getNewsIDPK();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public String updateNews(News news) {
        try {
            News updatenews=em.find(News.class, news.getNewsIDPK());
            Subcategory s=em.find(Subcategory.class,news.getSubCategoryIDFK().getSubCategoryIDPK());
               City c=em.find(City.class,news.getCityIDFK().getCityIDPK());
             updatenews.setNewsIDPK(news.getNewsIDPK());
             updatenews.setNewsTitle(news.getNewsTitle());
             updatenews.setNewsSubtitle(news.getNewsSubtitle());
             updatenews.setNewsDescription(news.getNewsDescription());
             updatenews.setNewsDate(news.getNewsDate());
             updatenews.setNewsStatus(news.getNewsStatus());
              updatenews.setSubCategoryIDFK(s);
              updatenews.setCityIDFK(c);
              updatenews.setNewsType(news.getNewsType());
               em.persist(updatenews);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteNews(int newsID) {
        try {
              News deletenews=em.find(News.class, newsID);
              deletenews.setIsActive(false);
              
              em.persist(deletenews);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
    }

    @Override
    public News searchNews(int newsID) {
        try {
             News news=  em.find(News.class,newsID);
           return news;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<News> showall_News() {
        try {
             List<News> newslist=em.createNamedQuery("News.findAll").getResultList();
       return newslist;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<News> showall_NewsByCity(int id) {
        try {
             List<News> nlist=em.createNamedQuery("News.findNewsByCity").setParameter("cityIDFK", id).getResultList();
             return nlist;
        } catch (Exception e) {
            return null;
        }
    }
    
    //===============================COMMENT

    @Override
    public String insertComment(Comment comment) {
        
         try {
            em.persist(comment);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String updateComment(Comment comment) {

        try {
            Comment updateComment=em.find(Comment.class, comment.getCommentIDPK());
            User u=em.find(User.class,comment.getUserIDFK().getUserIDPK());
            Debate d=em.find(Debate.class,comment.getDebateIDFK().getDebateIDPK());
             updateComment.setCommentIDPK(comment.getCommentIDPK());
             updateComment.setCommentDescription(comment.getCommentDescription());
             updateComment.setCommentDate(comment.getCommentDate());
             updateComment.setUserIDFK(u);
             updateComment.setDebateIDFK(d);
             
           
               em.persist(updateComment);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String deleteComment(int commentID) {

        try {
              Comment deleteComment=em.find(Comment.class, commentID);
              deleteComment.setIsActive(false);
              
              em.persist(deleteComment);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }

    }

    @Override
    public Comment searchComment(int commentID) {
        
            try {
             Comment searchComment=  em.find(Comment.class,commentID);
           return searchComment;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Comment> showall_Comment() {

        try {
             List<Comment> commentlist=em.createNamedQuery("Comment.findAll").getResultList();
       return commentlist;
        } catch (Exception e) {
            return null;
        }

    }
    
     @Override
    public List<Comment> showCommentByDebateIDFK(int debateIDFK) {
    List<Comment> commentbydebatelist=em.createNamedQuery("Comment.findByCommentByDebateIDPK").setParameter("debateIDFK", debateIDFK).getResultList();
          return commentbydebatelist;
    }
    
    
    //======================================DEBATE

    @Override
    public String insertDebate(Debate debate) {

         try {
            em.persist(debate);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateDebate(Debate debate) {
        
         try {
            Debate updateDebate=em.find(Debate.class, debate.getDebateIDPK());
            Subcategory s=em.find(Subcategory.class,debate.getSubCategoryIDFK().getSubCategoryIDPK());
             updateDebate.setDebateIDPK(debate.getDebateIDPK());
             updateDebate.setDebateTitle(debate.getDebateTitle());
             updateDebate.setDeabteDescription(debate.getDeabteDescription());
             updateDebate.setDebateStartDate(debate.getDebateStartDate());
              updateDebate.setDebateEndDate(debate.getDebateEndDate());
              updateDebate.setDebateImage(debate.getDebateImage());
          updateDebate.setSubCategoryIDFK(s);
          updateDebate.setDebateStatus(debate.getDebateStatus());
          
               em.persist(updateDebate);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }


    }

    @Override
    public String deleteDebate(int debateID) {
        
         try {
              Debate deleteDebate=em.find(Debate.class, debateID);
              deleteDebate.setIsActive(false);
              
              em.persist(deleteDebate);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }

    }

    @Override
    public Debate searchDebate(int debateID) {
        
        
            try {
             Debate searchDebate=  em.find(Debate.class,debateID);
           return searchDebate;
        } catch (Exception e) {
            return null;
        }
        

    }

    @Override
    public List<Debate> showall_Debate() {
        
         try {
             List<Debate> deabatelist=em.createNamedQuery("Debate.findAll").getResultList();
       return deabatelist;
        } catch (Exception e) {
            return null;
        }
         
         
         //==================================DEBATE

    }

    @Override
    public String insertPodcast(Podcast podcast) {

          try {
            em.persist(podcast);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String updatePodcast(Podcast podcast) {

        try {
            Podcast updatePodcast=em.find(Podcast.class, podcast.getPodcastIDPK());
            User u=em.find(User.class,podcast.getUserIDFK().getUserIDPK());
            Subcategory s=em.find(Subcategory.class,podcast.getSubCategoryIDFK().getSubCategoryIDPK());
             updatePodcast.setPodcastIDPK(podcast.getPodcastIDPK());
             updatePodcast.setPodcastTitle(podcast.getPodcastTitle());
             updatePodcast.setPodcastDescription(podcast.getPodcastDescription());
             updatePodcast.setPodcastDate(podcast.getPodcastDate());
              updatePodcast.setPodcastAudio(podcast.getPodcastAudio());
              updatePodcast.setUserIDFK(u);
          updatePodcast.setSubCategoryIDFK(s);
               em.persist(updatePodcast);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String deletePodcast(int podcastID) {

         try {
              Podcast deletePodcast=em.find(Podcast.class, podcastID);
              deletePodcast.setIsActive(false);
              
              em.persist(deletePodcast);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }

    }

    @Override
    public Podcast searchPodcast(int podcastID) {

            try {
             Podcast searchPodcast=  em.find(Podcast.class,podcastID);
           return searchPodcast;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<Podcast> showall_Podcast() {

          try {
             List<Podcast> podcastlist=em.createNamedQuery("Podcast.findAll").getResultList();
       return podcastlist;
        } catch (Exception e) {
            return null;
        }
         

    }
    
    //================================NEWSIMAGE

    @Override
    public String insertNewsImage(Newsimage newsimage) {

         try {
            em.persist(newsimage);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }

        
    }

    @Override
    public String updateNewsImage(Newsimage newsimage) {
        
         try {
           Newsimage  updatenewsimage=em.find(Newsimage.class, newsimage.getImageIDPK());
            News n=em.find(News.class,newsimage.getNewsIDFK().getNewsIDPK());
             updatenewsimage.setImageIDPK(newsimage.getImageIDPK());
             updatenewsimage.setImage(newsimage.getImage());
             updatenewsimage.setNewsIDFK(n);
          
          
               em.persist(updatenewsimage);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String deleteNewsImage(int imageID) {

        try {
              Newsimage deleteNewsImage=em.find(Newsimage.class, imageID);
              deleteNewsImage.setIsActive(false);
              
              em.persist(deleteNewsImage);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
        
    }

    @Override
    public Newsimage searchNewsImage(int imageID) {

          try {
             Newsimage searchNewsImage=  em.find(Newsimage.class,imageID);
           return searchNewsImage;
        } catch (Exception e) {
            return null;
        }

        
    }

    @Override
    public List<Newsimage> showall_NewsImage() {
        
         try {
             List<Newsimage> newsImagelist=em.createNamedQuery("Newsimage.findAll").getResultList();
       return newsImagelist;
        } catch (Exception e) {
            return null;
        }

    }
    
    @Override
    public List<Newsimage> showImageByNews(int newsID) {
    List<Newsimage> imagelist=em.createNamedQuery("Newsimage.findByNewsIDFK").setParameter("newsIDFK", newsID).getResultList();
          return imagelist;
    }
    
    
    //============================NEWSVIDEO

     //============================VIDEO-NEWS

    @Override
    public String insertVideoNews(Videonews videoNews) {

        try {
            em.persist(videoNews);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }

    }

    @Override
    public String updateVideoNews(Videonews videoNews) {

         try {
           Videonews  updatenewsvideo=em.find(Videonews.class, videoNews.getVideoNewsIDPK());
            Subcategory n=em.find(Subcategory.class,videoNews.getSubCategoryIDFK().getSubCategoryIDPK());
             City c=em.find(City.class,videoNews.getCityIDFK().getCityIDPK());
             updatenewsvideo.setVideoNewsIDPK(videoNews.getVideoNewsIDPK());
             updatenewsvideo.setVideoNewsTitle(videoNews.getVideoNewsTitle());
             updatenewsvideo.setVideoNewsDescription(videoNews.getVideoNewsDescription());
             updatenewsvideo.setVideo(videoNews.getVideo());
             updatenewsvideo.setCityIDFK(c);
             updatenewsvideo.setVideoNewsDate(videoNews.getVideoNewsDate());
             updatenewsvideo.setVideoNewsStatus(videoNews.getVideoNewsStatus());
             updatenewsvideo.setSubCategoryIDFK(n);
               em.persist(updatenewsvideo);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

        
    }

    @Override
    public String deleteVideoNews(int videoID) {

         try {
              Videonews deleteNewsVideo=em.find(Videonews.class, videoID);
              deleteNewsVideo.setIsActive(false);
              em.persist(deleteNewsVideo);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
        
    }

    @Override
    public Videonews searchVideoNews(int videoID) {

          try {
             Videonews searchNewsVideo=  em.find(Videonews.class,videoID);
           return searchNewsVideo;
        } catch (Exception e) {
            return null;
        }

        
        
    }

    @Override
    public List<Videonews> showall_VideoNews() {
         try {
             List<Videonews> newsVideolist=em.createNamedQuery("Videonews.findAll").getResultList();
       return newsVideolist;
        } catch (Exception e) {
            return null;
        }

    }
    //==========================USER

    @Override
    public String insertUser(User user) {

        try {
            em.persist(user);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    @Override
    public String updateUser(User user) {
        
       try {
           User  updateUser=em.find(User.class, user.getUserIDPK());
            City c=em.find(City.class,user.getCityIDFK().getCityIDPK());
            updateUser.setUserName(user.getUserName());
            updateUser.setUserPassword(user.getUserPassword());
            updateUser.setUserImage(user.getUserImage());
            updateUser.setUserEmail(user.getUserEmail());
            updateUser.setUserMobile(user.getUserMobile());
            updateUser.setUserStatus(user.getUserStatus());
            updateUser.setUserAddress(user.getUserAddress());
            updateUser.setUserGender(user.getUserGender());
            updateUser.setIsActive(user.getIsActive());
            updateUser.setCityIDFK(c);
            updateUser.setUserType(user.getUserType());
             
             
          
          
               em.persist(updateUser);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }


    }

    @Override
    public String deleteUser(int userID) {

        try {
              User deleteUser=em.find(User.class, userID);
              deleteUser.setIsActive(false);
              
              em.persist(deleteUser);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
        
    }

    @Override
    public User searchUser(int userID) {
        
         try {
             User searchUser=  em.find(User.class,userID);
           return searchUser;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public List<User> showall_User() {
        
        try {
             List<User> userlist=em.createNamedQuery("User.findAll").getResultList();
       return userlist;
        } catch (Exception e) {
            return null;
        }

    }
    
    @Override
    public User searchUserByEmail(String userEmail) {
         try {
             User searchUserEmail=  em.find(User.class,userEmail);
           return searchUserEmail;
        } catch (Exception e) {
            return null;
        }
    }

    
    @Override
    public User findmail(String userEmail) {
        try {
            User us = (User) em.createNamedQuery("User.findByUserEmail").setParameter("userEmail", userEmail).getSingleResult();
            return us;
        } catch (Exception e) {
            return null;
        }
    }
    
    @Override
    public List<User> showUserByType() {
        try {
             List<User> userlist=em.createNamedQuery("User.findUserByType").getResultList();
       return userlist;
        } catch (Exception e) {
            return null;
        }

    }
    
    
    //===================================NOTIFICATION

    @Override
    public String insertNotification(Notification notification) {

         try {
            em.persist(notification);
            return "insert";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }

    @Override
    public String updateNotification(Notification notification) {

          try {
          
              Notification  updateNotification=em.find(Notification.class, notification.getNotificationIDPK());
            User u=em.find(User.class,notification.getUserIDFK().getUserIDPK());
             News n=em.find(News.class,notification.getNewsIDFK().getNewsIDPK());
            updateNotification.setNotificationStatus(notification.getNotificationStatus());
            
            updateNotification.setUserIDFK(u);
              updateNotification.setNewsIDFK(n);
             
             
          
          
               em.persist(updateNotification);
               return "update";
        } catch (Exception e) {
            return e.getMessage();
        }

        
    }

    @Override
    public String deleteNotification(int notificationID) {

         try {
              Notification deleteNotification=em.find(Notification.class, notificationID);
              deleteNotification.setIsActive(false);
              
              em.persist(deleteNotification);
              return "deleted";
        } catch (Exception e) {
             return e.getMessage();
        }
        
        
        
    }

    @Override
    public Notification searchNotification(int notificationID) {

         try {
             Notification searchnotification=  em.find(Notification.class,notificationID);
           return searchnotification;
        } catch (Exception e) {
            return null;
        }

        
    }

    @Override
    public List<Notification> showall_Notification() {

        
         
        try {
             List<Notification> notificationlist=em.createNamedQuery("Notification.findAll").getResultList();
       return notificationlist;
        } catch (Exception e) {
            return null;
        }

        
    }
    
    //==========================USER-LOGIN
    
//    @Override
//    public String insertUserLogin(Userlogin userLogin) {
//        try {
//            em.persist(userLogin);
//            return "insert";
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//    
//    @Override
//    public String deleteUserLogin(int userLoginID) {
//        try {
//              Userlogin deleteUserLogin=em.find(Userlogin.class, userLoginID);
//              deleteUserLogin.setIsActive(false);
//              
//              em.persist(deleteUserLogin);
//              return "deleted";
//        } catch (Exception e) {
//             return e.getMessage();
//        }
//    }
//
//    @Override
//    public Userlogin searchUserLogin(int userLoginID) {
//           try {
//             Userlogin searchUserLogin=  em.find(Userlogin.class,userLoginID);
//           return searchUserLogin;
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//    @Override
//    public List<Userlogin> showall_UserLogin() {
//        try {
//             List<Userlogin> userloginlist=em.createNamedQuery("Userlogin.findAll").getResultList();
//       return userloginlist;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    
    @Override
     public User Login(String userEmail,String userPassword) {
    
                User um = (User) em.createNamedQuery("User.findByUser").setParameter("userEmail", userEmail).setParameter("userPassword", userPassword).getSingleResult();
                return um;
    }

     
     //available status
    @Override
    public String isAvailableStatus(int newsIDPK, String newsStatus) {
        try {
            News property = em.find(News.class, newsIDPK);
            
            property.setNewsStatus(newsStatus);
            em.persist(property);
            return "Status Changed!!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }


     

    
    
    
}
