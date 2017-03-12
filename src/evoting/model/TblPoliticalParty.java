/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "TBL_POLITICAL_PARTY", catalog = "", schema = "ADMIN1")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPoliticalParty.findAll", query = "SELECT t FROM TblPoliticalParty t"),
    @NamedQuery(name = "TblPoliticalParty.findByPkPartyId", query = "SELECT t FROM TblPoliticalParty t WHERE t.pkPartyId = :pkPartyId"),
    @NamedQuery(name = "TblPoliticalParty.findByFldTitle", query = "SELECT t FROM TblPoliticalParty t WHERE t.fldTitle = :fldTitle"),
    @NamedQuery(name = "TblPoliticalParty.findByFldLeaderfullname", query = "SELECT t FROM TblPoliticalParty t WHERE t.fldLeaderfullname = :fldLeaderfullname")})
public class TblPoliticalParty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PK_PARTY_ID")
    private Integer pkPartyId;
    @Basic(optional = false)
    @Column(name = "FLD_TITLE")
    private String fldTitle;
    @Basic(optional = false)
    @Column(name = "FLD_LEADERFULLNAME")
    private String fldLeaderfullname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkPoliticalPartyId")
    private Collection<TblCandidate> tblCandidateCollection;
    @OneToMany(mappedBy = "fkPoliticalPartyId")
    private Collection<TblVote> tblVoteCollection;

    public TblPoliticalParty() {
    }

    public TblPoliticalParty(Integer pkPartyId) {
        this.pkPartyId = pkPartyId;
    }

    public TblPoliticalParty(Integer pkPartyId, String fldTitle, String fldLeaderfullname) {
        this.pkPartyId = pkPartyId;
        this.fldTitle = fldTitle;
        this.fldLeaderfullname = fldLeaderfullname;
    }

    public Integer getPkPartyId() {
        return pkPartyId;
    }

    public void setPkPartyId(Integer pkPartyId) {
        this.pkPartyId = pkPartyId;
    }

    public String getFldTitle() {
        return fldTitle;
    }

    public void setFldTitle(String fldTitle) {
        this.fldTitle = fldTitle;
    }

    public String getFldLeaderfullname() {
        return fldLeaderfullname;
    }

    public void setFldLeaderfullname(String fldLeaderfullname) {
        this.fldLeaderfullname = fldLeaderfullname;
    }

    @XmlTransient
    public Collection<TblCandidate> getTblCandidateCollection() {
        return tblCandidateCollection;
    }

    public void setTblCandidateCollection(Collection<TblCandidate> tblCandidateCollection) {
        this.tblCandidateCollection = tblCandidateCollection;
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
        hash += (pkPartyId != null ? pkPartyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPoliticalParty)) {
            return false;
        }
        TblPoliticalParty other = (TblPoliticalParty) object;
        if ((this.pkPartyId == null && other.pkPartyId != null) || (this.pkPartyId != null && !this.pkPartyId.equals(other.pkPartyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "evoting.model.TblPoliticalParty[ pkPartyId=" + pkPartyId + " ]";
    }
    
}
