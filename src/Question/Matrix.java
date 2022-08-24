package Question;

import java.util.*;

public class Matrix {

    int[][] primitiveMAtrix;

    public Matrix(int[][] oArray) {
        List<int[]> list = new ArrayList<>();
        for (int[] row : oArray) {
            int[] clone = row.clone();
            list.add(clone);
        }
        primitiveMAtrix = list.toArray(new int[0][]);
    }

    public Matrix(int numOfRows, int numOfColumns) {
        Random r = new Random();
        primitiveMAtrix = new int[numOfRows][numOfColumns];
        for (int i = 0; i < numOfRows; i++) {
            for (int j = 0; j < numOfColumns; j++) {
                primitiveMAtrix[i][j] = r.nextInt(2);
            }
        }
    }

    public Collection<Index> getNeighbors(final Index index) {

        Collection<Index> list = new ArrayList<>();
        int extracted = -1;

        try {
            extracted = primitiveMAtrix[index.row + 1][index.column];
            list.add(new Index(index.row + 1, index.column));
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            extracted = primitiveMAtrix[index.row][index.column + 1];
            list.add(new Index(index.row, index.column + 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            extracted = primitiveMAtrix[index.row - 1][index.column];
            list.add(new Index(index.row - 1, index.column));
        } catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            extracted = primitiveMAtrix[index.row][index.column - 1];
            list.add(new Index(index.row, index.column - 1));
        } catch (ArrayIndexOutOfBoundsException ignored) {}

        return list;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : primitiveMAtrix) {
            stringBuilder.append(Arrays.toString(row));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public int getValue(final Index index) {
        return primitiveMAtrix[index.row][index.column];
    }

    public void printMatrix() {
        for (int[] row : primitiveMAtrix) {
            String s = Arrays.toString(row);
            System.out.println(s);
        }
    }

    public final int[][] getPrimitiveMAtrix() {
        return primitiveMAtrix;
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix(3, 3);
        System.out.println(matrix);
        Index index1 = new Index(0, 0);
        Index index2 = new Index(1, 1);
        System.out.println(matrix.getNeighbors(index1));
        System.out.println(matrix.getNeighbors(index2));
    }
}