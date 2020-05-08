import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;

public class Matrix implements Iterable<Integer>{
	int[][] array;
	int rows;
	int columns;
	public Matrix(int m, int n){
		rows = m;
		columns = n;
		array = new int[m][n];
	}
	public void set(int[]...args){
		int rowCount = 0;
		for(int[] a: args){
			if(a.length != columns){
				throw new IllegalArgumentException();
			}
			for(int i = 0; i < columns; i++){
				array[rowCount][i] = a[i];
			}
			rowCount++;
		}
		if(rowCount != rows){
			throw new IllegalArgumentException();
		}
	}

	public Iterator<Integer> getDiagonal(){
		return new DiagonalIterator();
	}

	public Iterator<Integer> iterator(){
		return new MatrixIterator();
	}
	
	public class MatrixIterator implements Iterator<Integer>{
		private int nextRow = 0;
		private int nextColumn = 0;
		public boolean hasNext(){
			if(nextRow >= rows || nextColumn >= columns){
				return false;
			}
			return true;
		}
		public Integer next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			if(nextColumn == (columns -1)){
				int rowTemp = nextRow;
				int columnTemp = nextColumn;
				nextRow++;
				nextColumn = 0;
				return array[rowTemp][columnTemp];
			}else{
				nextColumn++;
				return array[nextRow][(nextColumn-1)];
			}
			//return array[nextRow][nextColumn];
		}
	}

	public class DiagonalIterator implements Iterator<Integer>{
		private int nextRow = 0;
		private int nextColumn = 0;
		public boolean hasNext(){
			if(nextRow >= rows || nextColumn >= columns){
				return false;
			}
			return true;
		}
		public Integer next(){
			if(!hasNext()){
				throw new NoSuchElementException();
			}
			return array[nextRow++][nextColumn++];
		}
	}			
		
}
