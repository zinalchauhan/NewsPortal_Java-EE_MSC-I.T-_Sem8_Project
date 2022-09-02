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
@Table(name = "job", catalog = "newsportel", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j WHERE j.isActive=1"),
    @NamedQuery(name = "Job.findByJobIDPK", query = "SELECT j FROM Job j WHERE j.jobIDPK = :jobIDPK"),
    @NamedQuery(name = "Job.findByJobTitle", query = "SELECT j FROM Job j WHERE j.jobTitle = :jobTitle"),
    @NamedQuery(name = "Job.findByJobDescription", query = "SELECT j FROM Job j WHERE j.jobDescription = :jobDescription"),
    @NamedQuery(name = "Job.findByJobDate", query = "SELECT j FROM Job j WHERE j.jobDate = :jobDate"),
    @NamedQuery(name = "Job.findByJobStatus", query = "SELECT j FROM Job j WHERE j.jobStatus = :jobStatus"),
    @NamedQuery(name = "Job.findByIsActive", query = "SELECT j FROM Job j WHERE j.isActive = :isActive")})
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "jobIDPK", nullable = false)
    private Integer jobIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "jobTitle", nullable = false, length = 255)
    private String jobTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "jobDescription", nullable = false, length = 2000)
    private String jobDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "jobDate", nullable = false, length = 2000)
    private String jobDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "jobStatus", nullable = false, length = 200)
    private String jobStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isActive", nullable = false)
    private boolean isActive;

    public Job() {
    }

    public Job(Integer jobIDPK) {
        this.jobIDPK = jobIDPK;
    }

    public Job(Integer jobIDPK, String jobTitle, String jobDescription, String jobDate, String jobStatus, boolean isActive) {
        this.jobIDPK = jobIDPK;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobDate = jobDate;
        this.jobStatus = jobStatus;
        this.isActive = isActive;
    }

    public Integer getJobIDPK() {
        return jobIDPK;
    }

    public void setJobIDPK(Integer jobIDPK) {
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

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobIDPK != null ? jobIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobIDPK == null && other.jobIDPK != null) || (this.jobIDPK != null && !this.jobIDPK.equals(other.jobIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Job[ jobIDPK=" + jobIDPK + " ]";
    }
    
}
