//Table.java
package assignment1;
import java.io.FileNotFoundException;
public interface Table<T>{
    public void populateFromCSVFile(String csvFilename) throws FileNotFoundException, InvalidCSVException;
    public int height();
    public int width();
    public T[] getRow(int rowNum);
    public T[] getCol(int colNum);
    public T[][] getFullTable();
    public void set(int row, int col, T data);
}
