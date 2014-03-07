
import java.util.Iterator;
import java.util.NoSuchElementException;

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
public class IntRelationArraysIterable extends IntRelationArrays implements Iterable<IntPair> {

    public IntRelationArraysIterable(int n) {
        super(n);
    }

    @Override
    public Iterator<IntPair> iterator() {
        return new arraysIterator();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    private class arraysIterator implements Iterator {

        private int row; // next row element (if any)
        private int column; // next column element (if any)
        private int max; //max relation

        arraysIterator() {
            row = 0; //initialize rows
            column = 0; //initialize columns
            max = relation.length; //initialize max
        }

        @Override
        public boolean hasNext() {
            int rowNext;
            int columnNext;
            rowNext = row;
            columnNext = column;
            System.out.println("hasnext started" + max);
            if (max == 0) {
                return false;
            } else {
                while (rowNext <= max) {
                    // System.out.println("TEST" + row + column + max);
                    while (columnNext <= max) {
                        // System.out.println("TEST" + row + column + max);
                        if (relation[rowNext][columnNext]) {
                            return true;
                        }
                        columnNext++;
//System.out.println("TEST" + row + column + max);
                    }
                    rowNext++;
                    columnNext = 0;
                }
                return false;
            }

        }

        @Override
        public Object next() {
            //throw new NoSuchElementException("IntRelationArraysIterable.next");
            if (!this.hasNext()) {
                throw new NoSuchElementException("IntRelationArraysIterable.next");
            } else {
                while (row <= max) {
                    while (column <= max) {
                        
                        System.out.println("row column " + row + column + max );
                        System.out.println("row column boolean " + relation[row][column]);
                        if (relation[row][column]) {
                            column++;
                            return new IntPair(row, column - 1);
                        }
                        System.out.println("row column still working");
                        column++;
                    }
                    row++;
                    column = 0;
                }
            }
            throw new NoSuchElementException("IntRelationArraysIterable.next");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }
}
