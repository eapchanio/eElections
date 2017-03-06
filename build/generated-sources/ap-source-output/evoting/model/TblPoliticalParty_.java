package evoting.model;

import evoting.model.TblCandidate;
import evoting.model.TblVote;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-06T01:38:24")
@StaticMetamodel(TblPoliticalParty.class)
public class TblPoliticalParty_ { 

    public static volatile SingularAttribute<TblPoliticalParty, String> fldLeaderfullname;
    public static volatile SingularAttribute<TblPoliticalParty, String> fldTitle;
    public static volatile CollectionAttribute<TblPoliticalParty, TblVote> tblVoteCollection;
    public static volatile SingularAttribute<TblPoliticalParty, Integer> pkPartyId;
    public static volatile CollectionAttribute<TblPoliticalParty, TblCandidate> tblCandidateCollection;

}