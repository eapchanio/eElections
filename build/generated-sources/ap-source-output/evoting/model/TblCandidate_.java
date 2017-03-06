package evoting.model;

import evoting.model.TblElectoralPeriphery;
import evoting.model.TblPoliticalParty;
import evoting.model.TblVote;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-06T01:38:24")
@StaticMetamodel(TblCandidate.class)
public class TblCandidate_ { 

    public static volatile SingularAttribute<TblCandidate, String> fldSurname;
    public static volatile SingularAttribute<TblCandidate, TblElectoralPeriphery> fkElectoralPeripheryId;
    public static volatile SingularAttribute<TblCandidate, String> fldName;
    public static volatile CollectionAttribute<TblCandidate, TblVote> tblVoteCollection;
    public static volatile SingularAttribute<TblCandidate, TblPoliticalParty> fkPoliticalPartyId;
    public static volatile SingularAttribute<TblCandidate, Long> pkCandidateId;

}