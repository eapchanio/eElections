/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "TBL_CANDIDATE", catalog = "", schema = "ADMIN1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCandidate.findAll", query = "SELECT t FROM TblCandidate t"),
    @NamedQuery(name = "TblCandidate.findByPkCandidateId", query = "SELECT t FROM TblCandidate t WHERE t.pkCandidateId = :pkCandidateId"),
    @NamedQuery(name = "TblCandidate.findByFldSurname", query = "SELECT t FROM TblCandidate t WHERE t.fldSurname = :fldSurname"),
    @NamedQuery(name = "TblCandidate.findByFldName", query = "SELECT t FROM TblCandidate t WHERE t.fldName = :fldName")})
public class TblCandidate implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_CANDIDATE_ID")
    private Long pkCandidateId;
    @Basic(optional = false)
    @Column(name = "FLD_SURNAME")
    private String fldSurname;
    @Basic(optional = false)
    @Column(name = "FLD_NAME")
    private String fldName;
    @JoinColumn(name = "FK_ELECTORAL_PERIPHERY_ID", referencedColumnName = "PK_ELECTORAL_PERIPHERY_ID")
    @ManyToOne(optional = false)
    private TblElectoralPeriphery fkElectoralPeripheryId;
    @JoinColumn(name = "FK_POLITICAL_PARTY_ID", referencedColumnName = "PK_PARTY_ID")
    @ManyToOne(optional = false)
    private TblPoliticalParty fkPoliticalPartyId;
    @OneToMany(mappedBy = "fkCandidateId")
    private Collection<TblVote> tblVoteCollection;

    public TblCandidate() {
    }

    public TblCandidate(Long pkCandidateId) {
        this.pkCandidateId = pkCandidateId;
    }

    public TblCandidate(Long pkCandidateId, String fldSurname, String fldName) {
        this.pkCandidateId = pkCandidateId;
        this.fldSurname = fldSurname;
        this.fldName = fldName;
    }

    public Long getPkCandidateId() {
        return pkCandidateId;
    }

    public void setPkCandidateId(Long pkCandidateId) {
        Long oldPkCandidateId = this.pkCandidateId;
        this.pkCandidateId = pkCandidateId;
        changeSupport.firePropertyChange("pkCandidateId", oldPkCandidateId, pkCandidateId);
    }

    public String getFldSurname() {
        return fldSurname;
    }

    public void setFldSurname(String fldSurname) {
        String oldFldSurname = this.fldSurname;
        this.fldSurname = fldSurname;
        changeSupport.firePropertyChange("fldSurname", oldFldSurname, fldSurname);
    }

    public String getFldName() {
        return fldName;
    }

    public void setFldName(String fldName) {
        String oldFldName = this.fldName;
        this.fldName = fldName;
        changeSupport.firePropertyChange("fldName", oldFldName, fldName);
    }

    public TblElectoralPeriphery getFkElectoralPeripheryId() {
        return fkElectoralPeripheryId;
    }

    public void setFkElectoralPeripheryId(TblElectoralPeriphery fkElectoralPeripheryId) {
        TblElectoralPeriphery oldFkElectoralPeripheryId = this.fkElectoralPeripheryId;
        this.fkElectoralPeripheryId = fkElectoralPeripheryId;
        changeSupport.firePropertyChange("fkElectoralPeripheryId", oldFkElectoralPeripheryId, fkElectoralPeripheryId);
    }

    public TblPoliticalParty getFkPoliticalPartyId() {
        return fkPoliticalPartyId;
    }

    public void setFkPoliticalPartyId(TblPoliticalParty fkPoliticalPartyId) {
        TblPoliticalParty oldFkPoliticalPartyId = this.fkPoliticalPartyId;
        this.fkPoliticalPartyId = fkPoliticalPartyId;
        changeSupport.firePropertyChange("fkPoliticalPartyId", oldFkPoliticalPartyId, fkPoliticalPartyId);
    }

    @XmlTransient
    public Collection<TblVote> getTblVoteCollection() {
        return tblVoteCollection;
    }

    public void setTblVoteCollection(Collection<TblVote> tblVoteCollection) {
        this.tblVoteCollection = tblVoteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkCandidateId != null ? pkCandidateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCandidate)) {
            return false;
        }
        TblCandidate other = (TblCandidate) object;
        if ((this.pkCandidateId == null && other.pkCandidateId != null) || (this.pkCandidateId != null && !this.pkCandidateId.equals(other.pkCandidateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "evoting.model.TblCandidate[ pkCandidateId=" + pkCandidateId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
