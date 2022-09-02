/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package ManagedBean;

import Entity.Job;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import sessionBean.newsPotalSessionBeanLocal;
import java.util.List;

/**
 *
 * @author maafia_fury
 */
@Named(value = "jobBean")
@ApplicationScoped
public class jobManagedBean {
    
    
     @EJB
    private newsPotalSessionBeanLocal newsPotalSessionBean;
     
     int jobIDPK;
     String jobTitle,jobDescription,jobDate,jobStatus;
     Job job = new Job();

    public newsPotalSessionBeanLocal getNewsPotalSessionBean() {
        return newsPotalSessionBean;
    }

    public void setNewsPotalSessionBean(newsPotalSessionBeanLocal newsPotalSessionBean) {
        this.newsPotalSessionBean = newsPotalSessionBean;
    }

    public int getJobIDPK() {
        return jobIDPK;
    }

    public void setJobIDPK(int jobIDPK) {
        this.jobIDPK = jobIDPK;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobDate() {
        return jobDate;
    }

    public void setJobDate(String jobDate) {
        this.jobDate = jobDate;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
     
     
     
      public List<Job> show_jobList() {
        try {
            return newsPotalSessionBean.showall_Job();
        } catch (Exception e) {
            return null;
        }
    }
      
      
      public String insert_click()
    {
        try {
            
            SimpleDateFormat simpleformat = new SimpleDateFormat("MM/dd/yyyy");
              String currentDate = simpleformat.format(new Date());
              Date today = simpleformat.parse(currentDate);
            
            job.setJobIDPK(0);
            job.setJobTitle(jobTitle);
            job.setJobDescription(jobDescription);
            job.setJobDate(currentDate);
            job.setJobStatus("1");
            job.setIsActive(true);
            newsPotalSessionBean.insertJob(job);
            clear();
            return "/Admin/displayJob.xhtml?faces-redirect=true";
            
        } catch (Exception e) {
           return e.getMessage();
        }
    }
      
       public String update_click()
    {
        try {
           job.setJobIDPK(jobIDPK);
            job.setJobTitle(jobTitle);
            job.setJobDescription(jobDescription);
            job.setJobDate(jobDate);
            job.setJobStatus("1");
            newsPotalSessionBean.updateJob(job);
            clear();
            return "/Admin/displayJob.xhtml?faces-redirect=true";
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }
       
        public String delete_click(int jobIDPK)
    {
        try {
            newsPotalSessionBean.deleteJob(jobIDPK);
            
            return "/Admin/displayJob.xhtml?faces-redirect=true";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
        
         public String search_click(int id)
    {
        try {
            job = newsPotalSessionBean.searchJob(id);
            jobIDPK = job.getJobIDPK();
            jobTitle = job.getJobTitle();
            jobDescription = job.getJobDescription();
            jobDate = job.getJobDate();
            jobStatus = job.getJobStatus();
            return "/Admin/insertJob.xhtml?faces-redirect=true";
           
        } catch (Exception e) {
            return e.getMessage();
        }
    }
         
     public void clear(){
         
        jobIDPK = 0;
         jobTitle = "";
         jobDescription = "";
         jobDate = "";
         jobStatus = "";
         
         
         
    }
    
       
     
     
    
     
     
     

    /**
     * Creates a new instance of jobManagedBean
     */
    public jobManagedBean() {
    }
    
}
