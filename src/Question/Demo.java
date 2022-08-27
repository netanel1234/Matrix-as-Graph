package Question;

import java.util.Set;

public class Demo {

    public static void main(String[] args) {

        int[][] matrix = {  {1, 1, 0},
                            {0, 1, 1},
                            {0, 1, 1}  };

        MatrixAdapter matrixAsGraph = new MatrixAdapter(new Matrix(matrix));
        System.out.println(matrixAsGraph.getMatrix());
        matrixAsGraph.getSource(new Index(0, 0));
        DfsVisit<Index> algorithm = new DfsVisit<>();
        Set<Index> connectedComponent = algorithm.traverse(matrixAsGraph);
        System.out.println(connectedComponent);

    }
}
