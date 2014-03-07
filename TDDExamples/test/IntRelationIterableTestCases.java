//# BEGIN SKELETON

import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Abstract test cases for an {@link IntRelation} that implements
 * {@link Iterable<IntPair>}. This class is to be extended to obtain concrete
 * test cases for an extension of {@link IntRelation} that implements
 * {@link Iterable<IntPair>}.
 *
 /*
 * <!--//# BEGIN TODO Name, student id, and date-->
 * Name: Ivo van Heck ID: 0775551 date: 06/03/2014
 * <!--//# END TODO-->
 */
// -----8<----- cut line -----8<-----

public abstract class IntRelationIterableTestCases
        extends IntRelationTestCases {

    /**
     * Additional test fixture: {@code instance} viewed as iterable.
     */
    protected Iterable<IntPair> iterable;

    /**
     * Sets {@code instance} and {@code iterable} to a newly constructed
     * iterable relation of given extent. In test cases for iterators, only
     * {@code setIterable} must be called, and not {@code setInstance}.
     * Afterwards, the constructed object can be used through {@code instance}
     * as an {@code IntRelation}, and through {@code iterable} as an
     * {@code Iterable<IntPair>}.
     *
     * @param n extent
     * @post {@code instance} and {@code iterable} have been assigned the same
     * object of an appropriate subtype of
     * {@code IntRelation implements Iterable<IntPair>}, with extent {@code n}
     */
    protected void setIterable(final int n) {
        setInstance(n);
        iterable = ((Iterable<IntPair>) instance);
    }

//# BEGIN TODO Test cases for the iterator
    /**
     * Checks the iterator() method for correct behavior. Namely that each element
     * in the intpair array in the argument is found exactly once in the iterator,
     * and that each element in the iterator is also in expected.
     * 
     * @param expected The list of expected {@code IntPair}s.
     * @pre {@code expected != null && iterable != null}
     */
    protected void checkIterator(IntPair[] expected) {
        int[] count = new int[expected.length]; //count how many times each of the expected
        //results gets returned by the iterator.
        for (int i = 0; i != count.length; i++) {//initial value of 0 for each result.
            count[i] = 0;
        }
        for (IntPair intPair : iterable) {
            boolean check; //checks whether intPair is in expected.
            check = false; //initaly intPair has not been found in expected
            for (int exp = 0; exp != expected.length; exp++) {
                if (expected[exp].toString().equals(intPair.toString())) {
                    check = true; //intPair has been found in expected.
                    count[exp]++; //The exp'd element in expected has been found
                       //in iterable
                }
            }
            assertEquals(check, true); //Make sure that intPair is in expected.
        }
        for (int i = 0; i != count.length; i++) {
            assertEquals(count[i], 1); //Make sure that every elt. in expected
                //was returned exactly once by the iterator.
        }
    }

    @Test
    public void testIterator() {
        IntPair[] expected; //Use as argument for the checkIterator function
        expected = new IntPair[0]; //initialise for the first test
        setIterable(0); //initialise iterable.
        checkIterator(expected); //run tests
        //case: empty set
        expected = new IntPair[1]; //initialse for the 2nd test
        setIterable(1); //initialise iterable for the 2nd test
        instance.add(0, 0); //add a pair to the instance
        expected[0] = new IntPair(0, 0); //add the same pair to expected
        checkIterator(expected); //run tests (repeat for the rest of this method)
        //case: relation with single entry
        expected = new IntPair[4];
        setIterable(2);
        instance.add(0, 1);
        instance.add(0, 0);
        instance.add(1, 0);
        instance.add(1, 1);
        expected[0] = new IntPair(0, 0);
        expected[1] = new IntPair(1, 1);
        expected[2] = new IntPair(1, 0);
        expected[3] = new IntPair(0, 1);
        checkIterator(expected);
        //case: full relation, different order.
        expected = new IntPair[3];
        setIterable(2);
        instance.add(0, 1);
        instance.add(1, 1);
        instance.add(0, 0);
        expected[0] = new IntPair(0, 0);
        expected[1] = new IntPair(1, 1);
        expected[2] = new IntPair(0, 1);
        checkIterator(expected);
        //case: non-full relation, (0, 1) in relation, reverse not in relation.
        expected = new IntPair[2];
        setIterable(8);
        instance.add(2, 6);
        instance.add(6, 2);
        expected[0] = new IntPair(2, 6);
        expected[1] = new IntPair(6, 2);
        checkIterator(expected);
        //case: sparse relation with only reverse pair.
    }

    /**
     * Gets an iterator for iterable, and checks if the correct exception is thrown
     * if next() is called while it has no next element.
     * @param expected the expected exception to be thrown.
     */
    protected void checkExceptionIteratorNext(Class expected) {
        System.out.println("intRelationsIterable.iterator(),"
                + " for exception");
        try {
            Iterator iter = iterable.iterator();
            while (iter.hasNext()) {
                iter.next();
            }//!iter.hasNext()
            iter.next();
            fail("should have thrown " + expected);
        } catch (Exception e) {
            assertTrue("type: " + e.getClass().getName()
                    + " should be instance of " + expected,
                    expected.isInstance(e));
            assertNotNull("message should not be null",
                    e.getMessage());
        }
    }

    @Test
    public void testExceptionIteratorNext() {
        Class expected = NoSuchElementException.class;
        setIterable(0);
        checkExceptionIteratorNext(expected);
        //empty relation
        setIterable(2);
        instance.add(0, 0);
        instance.add(0, 1);
        instance.add(1, 0);
        instance.add(1, 1);
        checkExceptionIteratorNext(expected);
        //full relation
    }

//# END TODO
}
//# END SKELETON
