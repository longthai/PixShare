/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")
    , @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id")
    , @NamedQuery(name = "Post.findByDescription", query = "SELECT p FROM Post p WHERE p.description = :description")
    , @NamedQuery(name = "Post.findByName", query = "SELECT p FROM Post p WHERE p.name = :name")
    , @NamedQuery(name = "Post.findByPath", query = "SELECT p FROM Post p WHERE p.path = :path")
    , @NamedQuery(name = "Post.findByTime", query = "SELECT p FROM Post p WHERE p.time = :time")
    , @NamedQuery(name = "Post.findByLocation", query = "SELECT p FROM Post p WHERE p.location = :location")
    , @NamedQuery(name = "Post.findByMediatype", query = "SELECT p FROM Post p WHERE p.mediatype = :mediatype")
    , @NamedQuery(name = "Post.findByUserID", query = "SELECT p FROM Post p WHERE p.userID = :userID")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    //@ManyToOne(fetch=FetchType.LAZY)
    //@JoinColumn(name="UserID")
    @Column(name = "ID")
    private Integer id;
    @Size(max = 64)
    @Column(name = "Description")
    private String description;
    @Size(max = 16)
    @Column(name = "Name")
    private String name;
    @Size(max = 64)
    @Column(name = "Path")
    private String path;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Size(max = 20)
    @Column(name = "Location")
    private String location;
    @Size(max = 8)
    @Column(name = "Mediatype")
    private String mediatype;
    @Column(name = "UserID")
    private Integer userID;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(String description, String title, String path, Date resultdate, String helsinki, String png, int userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Post[ id=" + id + " ]";
    }
    
}
