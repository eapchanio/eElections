package evoting.model;

import evoting.model.TblCandidate;
import evoting.model.TblVote;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-22T11:51:35")
@StaticMetamodel(TblElectoralPeriphery.class)
public class TblElectoralPeriphery_ { 

    public static volatile SingularAttribute<TblElectoralPeriphery, Integer> pkElectoralPeripheryId;
    public static volatile SingularAttribute<TblElectoralPeriphery, String> fldName;
    public static volatile SingularAttribute<TblElectoralPeriphery, Integer> fldRegisteredCitizensCount;
    public static volatile CollectionAttribute<TblElectoralPeriphery, TblVote> tblVoteCollection;
    public static volatile CollectionAttribute<TblElectoralPeriphery, TblCandidate> tblCandidateCollection;
    public static volatile SingularAttribute<TblElectoralPeriphery, Integer> fldSeatsCount;

}