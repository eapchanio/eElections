package evoting.model;

import evoting.model.TblCandidate;
import evoting.model.TblElectoralPeriphery;
import evoting.model.TblPoliticalParty;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-06T01:38:24")
@StaticMetamodel(TblVote.class)
public class TblVote_ { 

    public static volatile SingularAttribute<TblVote, Long> pkVoteId;
    public static volatile SingularAttribute<TblVote, TblElectoralPeriphery> fkElectoralPeripheryId;
    public static volatile SingularAttribute<TblVote, TblPoliticalParty> fkPoliticalPartyId;
    public static volatile SingularAttribute<TblVote, Boolean> fldIsInvalid;
    public static volatile SingularAttribute<TblVote, TblCandidate> fkCandidateId;
    public static volatile SingularAttribute<TblVote, Boolean> fldIsBlank;

}