package Question;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 * This class uses the Adapter pattern, a.k.a Wrapper/Decorator,
 * adapts a Matrix object to the functionality of a Graph-like type.
 */
public class MatrixAdapter implements Graph<Index> {

    private Matrix matrix;
    private Index source;

    public MatrixAdapter(@NotNull Matrix matrix) {
        this.matrix = matrix;
        this.source = new Index(0, 0);
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    public Index getSource() {
        return source;
    }

    public void setSource(@NotNull Index source) {
        if ((source.row >= 0 && source.row < matrix.primitiveMatrix.length) &&
                (source.column >= 0 && source.column < matrix.primitiveMatrix[0].length))
        {
            this.source = source;
        }
    }

    @Override
    public Node<Index> getRoot() {
        return new Node<>(source);
    }

    @Override
    public Collection<Node<Index>> getReachableNodes(Node<Index> node) {
        return null;
    }
}
