
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s133781
 */
//-----8<----- cut line -----8<-----
public class IntRelationListOfSetsIterable extends IntRelationListOfSets implements Iterable<IntPair> {

    public IntRelationListOfSetsIterable(int n) {
        super(n);
    }

    @Override
    public Iterator<IntPair> iterator() {
        return new listOfSetsIterator();
    }

    private class listOfSetsIterator implements Iterator {

        private int index; // next row element (if any)
        //private int column; // next column element (if any)
        //private int Max; //max relation
        private Iterator iter;

        listOfSetsIterator() {
            index = 0;
            //column = 0;
            //Max = relation.size();
            if (!relation.isEmpty()) {
                iter = relation.get(index).iterator();
            } else {
                iter = null;
            }

        }

        @Override
        public boolean hasNext() {
            if (iter == null) {
                return false;
            }
            if (!iter.hasNext()) {
                int i = index;
                while (i < relation.size()) {
                    if (iter.hasNext()) {
                        return true;
                    }
                    i++;
                }
                return false;
            }
            //loop door alle arraylist heen om te kijken of er een next is
            return true;
        }

        @Override
        public Object next() {
            //roep super.hasnext aan en anders throw exception
            if (!this.hasNext()) {
                throw new NoSuchElementException("listOfSetsIterator.next");
            } else if (iter.hasNext()) {
                return new IntPair(index, (int) iter.next());
            } else {
                while (index < relation.size()) {
                    if (iter.hasNext()) {
                        return new IntPair(index, (int) iter.next());
                    }
                    index++;
                }
            }

            return new IntPair(index, (int) iter.next());

            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
