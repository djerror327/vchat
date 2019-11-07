/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vchat.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author tjayasekara
 */
@Entity
@Table(name = "m_thread")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MThread.findAll", query = "SELECT m FROM MThread m"),
    @NamedQuery(name = "MThread.findById", query = "SELECT m FROM MThread m WHERE m.id = :id"),
    @NamedQuery(name = "MThread.findByName", query = "SELECT m FROM MThread m WHERE m.name = :name")})
public class MThread implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @JoinTable(name = "user_msg", joinColumns = {
        @JoinColumn(name = "m_thread_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")})
    @ManyToMany
    private Collection<User> userCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mThreadId")
    private Collection<Msg> msgCollection;

    public MThread() {
    }

    public MThread(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @XmlTransient
    public Collection<Msg> getMsgCollection() {
        return msgCollection;
    }

    public void setMsgCollection(Collection<Msg> msgCollection) {
        this.msgCollection = msgCollection;
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
        if (!(object instanceof MThread)) {
            return false;
        }
        MThread other = (MThread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.MThread[ id=" + id + " ]";
    }
    
}
