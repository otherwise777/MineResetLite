
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of {@link IntRelation} using a {@link Map} of {@link Sets}.
 *
 * <!--//# BEGIN TODO Name, student id, and date-->
 * <p>
 * <font color="green"><b>Ligtenberg Wouter 0864271 24-02-2014</b></font></p>
 * <!--//# END TODO-->
 * 
 *
 * @author Ligtenberg Wouter
 */
// -----8<----- cut line -----8<-----
public class IntRelationMapOfSets extends IntRelation {

    /**
     * Representation of the relation.
     */
    private Map<Integer, Set<Integer>> relation;
    // could be declared final

//    public IntRelationMapOfSets(int n) {
//        super(n);
//    }

    /*
     * Representation invariants
     *
     * NotNull: relation != null
     * SetsNotNull: (\forall i; relation.has(i); relation.get(i) != null),
     *     where List.has(i) == 0 <= i < List.size()
     * SetsInExtent: (\forall i; relation.has(i);
     *     relation.get(i) subset of [0 .. relation.size()))
     *
     * Abstraction function: set of (a, b) such that
     *     relation.get(a).contains(b) holds
     */
    public IntRelationMapOfSets(final int n) {
        super(n);
        relation = new HashMap<Integer, Set<Integer>>();
        /* Java 7, but this upsets Checkstyle
         relation = new ArrayList<>();
         */
        for (int i = 0; i != n; ++i) {
            relation.put(i, new HashSet<Integer>());
        }
    }
    //
    @Override
    public boolean isRepOk() {
        // NotNull
        if (relation == null) {
            throw new IllegalStateException("relation == null");
        }
        for (int i = 0; i != extent(); ++ i) {
            final Set<Integer> set = relation.get(i);
            // SetsNotNull
            if (set == null) {
                throw new IllegalStateException(
                        "relation.get(" + i + ") == null");
            }
            // SetsInExtent
            for (int j : set) {
                if (! (0 <= j && j < extent())) {
                    throw new IllegalStateException(
                            "relation.get(" + i + ") contains " + j);
                }
            }
        }
        return true;
    }
    
    /**
     * Alternative form of {@code isrepok}, commented because i\'m unsure what is needed.
     * @return 
     */
//    @Override
//    public boolean isRepOk() {
//        // NotNull
//        if (relation == null) {
//            throw new IllegalStateException("relation == null");
//        }
//        Iterator it = relation.entrySet().iterator();
//        while (it.hasNext()) {
//            //final Set<Integer> set = relation.get(i);
//            Map.Entry pairs = (Map.Entry) it.next();
//            final Set<Integer> set = relation.get(pairs);
//            if (set == null) {
//                throw new IllegalStateException(
//                        "relation.get(" + set + ") == null");
//            }
//            // SetsInExtent
//            for (int j : set) {
//                if (!(0 <= j && j < extent())) {
//                    throw new IllegalStateException(
//                            "relation.get(" + set + ") contains " + j);
//                }
//            }
//        }
//        return true;
//    }

    @Override
    public int extent() {
        return relation.size();
    }

    @Override
    public boolean areRelated(int a, int b) {
        return relation.get(a).contains(b);
    }

    @Override
    public void add(int a, int b) {
        relation.get(a).add(b);
    }

    @Override
    public void remove(int a, int b) {
        relation.get(a).remove(b);
    }

}
