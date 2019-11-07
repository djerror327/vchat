/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vchat.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author tjayasekara
 */
@Entity
@Table(name = "msg")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Msg.findAll", query = "SELECT m FROM Msg m"),
    @NamedQuery(name = "Msg.findById", query = "SELECT m FROM Msg m WHERE m.id = :id"),
    @NamedQuery(name = "Msg.findByDate", query = "SELECT m FROM Msg m WHERE m.date = :date"),
    @NamedQuery(name = "Msg.findByTime", query = "SELECT m FROM Msg m WHERE m.time = :time")})
public class Msg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Lob
    @Column(name = "message")
    private String message;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @JoinColumn(name = "m_thread_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MThread mThreadId;

    public Msg() {
    }

    public Msg(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public MThread getMThreadId() {
        return mThreadId;
    }

    public void setMThreadId(MThread mThreadId) {
        this.mThreadId = mThreadId;
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
        if (!(object instanceof Msg)) {
            return false;
        }
        Msg other = (Msg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Msg[ id=" + id + " ]";
    }
    
}
