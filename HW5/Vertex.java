import java.util.List;
import java.util.LinkedList;

/**
    @author Christopher M. Summa
*/

class Vertex<AnyType extends Comparable > implements Comparable<Vertex<AnyType>> {

    private AnyType name;
    private List< Vertex<AnyType> > myAdjacentVertices;
    private List< Double >          myEdgeCosts;

/**
    @param  name is the "name" of the Vertex, typically a string - should be unique within a given graph
*/
    public Vertex(AnyType name) {
        this.name = name;
        this.myAdjacentVertices = new LinkedList();
        this.myEdgeCosts = new LinkedList();
    }
    
    public void addAdjacentVertex( Vertex<AnyType> another, Double cost) {
        myAdjacentVertices.add(another);
        myEdgeCosts.add(cost);
    }

    public void removeAdjacentVertex( Vertex<AnyType> another) {
        int index = myAdjacentVertices.indexOf(another);
        if (index >=0) {
            myAdjacentVertices.remove(index);
            myEdgeCosts.remove(index);
        }
    }

    public List< Vertex<AnyType> > getAdjacencyList() {
        return myAdjacentVertices;
    }

    public List< Double > getAdjacencyEdgeCosts() {
        return myEdgeCosts;
    }

    public AnyType getName() {
        return name;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Vertex) {
            if ( ((Vertex)other).getName().equals(this.name) )
                return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public int compareTo( Vertex<AnyType> other) {

        return this.name.compareTo(other.getName());
    }

}  // end class Vertex;
