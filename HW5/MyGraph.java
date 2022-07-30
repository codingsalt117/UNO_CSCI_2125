import java.util.List;
import java.util.LinkedList;
import java.util.*;
// should anything else be imported?

/**

    AnyType will be whatever type the label or "name" of each vertex will take
    For example, if the vertices represent airports, you might give them names like
    "MSY" and "ATL" and AnyType will be String...

*/
public class MyGraph<AnyType extends Comparable> {

    // instance variables for the graph should definitely go here
    private Map<Integer, Vertex> myMap = new Map<Integer,Vertex>();

    /**
        constructor
    */
    public MyGraph(Map<Integer,Vertex> mapName) {
        // stubbed
        this. myMap = mapName;
    }

    /**
        add a vertex to the graph by "name"
    */
    public void addVertex( AnyType name) {
        // stubbed
        Vertex newVertex = new Vertex(name);
        myMap.put(newVertex.hashCode(), newVertex);

    }

    /**
        add a directed edge to the graph from vertex v to vertex w, with a cost "cost"
        @param  v   the first vertex specifying the edge
        @param  w   the second vertex specifying the edge
        @param  cost  the cost of traversing this edge from v to w
    */
    public void addEdge(Vertex<AnyType> v, Vertex<AnyType> w, Double cost) {
        // stubbed
        Vertex startVertex = v;
        Vertex endVertex = w;
        startVertex.addAdjacentVertex(endVertex, cost);
    }

    /**
        add a directed edge to the graph from the vertex with name nameOf_v to vertex 
        with the name nameOf_w, with a cost "cost"
        @param  v   the "name" of the first vertex specifying the edge
        @param  w   the "name" of the second vertex specifying the edge
        @param  cost  the cost of traversing this edge from v to w
    */
    public void addEdge(AnyType nameOf_v, AnyType nameOf_w, Double cost) {
        // stubbed
        Vertex startVertex = new Vertex(nameOf_v);
        Vertex endVertex = new Vertex(nameOf_w);
        startVertex.addAdjacentVertex(endVertex,cost);
    }

    /**
        retrieve a vertex from the graph by "name"
        @param  name  the "name" or label of the vertex being requested
        @return  the reference to the vertex in the graph with that name
    */
    public Vertex getVertex(AnyType name) {
        // stubbed
            Vertex returnVertex = new Vertex(name);
            returnVertex = this.myMap.get(returnVertex.hashCode());
            return returnVertex;
        }

    /**
        remove a referenced vertex from the graph 
        @param  v  a reference to the vertex to be removed
    */
    public void removeVertex( Vertex<AnyType> v ) {
        // stubbed
        // remember that if a vertex is removed all edges that either
        // begin or end at that vertex must also be removed



    }
//returnVertex.removeAdjacentVertex(this.getVertex(name));
    /**
        remove a vertex from the graph with a particular "name"
        @param  name  the "name" or label of the vertex to be removed
    */
    public void removeVertex( AnyType name) {

        // stubbed
        // remember that if a vertex is removed all edges that either
        // begin or end at that vertex must also be removed
        Vertex removingVertex = new Vertex(name);
        removingVertex = this.myMap.get(removingVertex.hashCode());       
        List<Vertex<AnyType>> garbageDay = removingVertex.getAdjacencyList();
        int currentSize = garbageDay.size();
        
        for ( int i = 0; i <= currentSize; i++){
            Vertex startVertex = garbageDay.get(i); 
            Vertex endVertex = garbageDay.get(i+1);
            this.myMap.removeEdge(startVertex.getName(), endVertex.getName());
        }   
        
    }

    /**
        remove a directed edge from the graph using vertex references
        @param  v  a reference to the first vertex of the edge to be removed
        @param  w  a reference to the second vertex of the edge to be removed
    */
    public void removeEdge(Vertex<AnyType> v, Vertex<AnyType> w) {

        // stubbed

    }

    /**
        remove a directed edge from the graph using vertex "names" or labels
        @param  nameOf_v  the name of the first vertex of the edge to be removed
        @param  nameOf_w  the name of the second vertex of the edge to be removed
    */
    public void removeEdge(AnyType nameOf_v, AnyType nameOf_w) {

        // stubbed

    }

} // end class MyGraph
