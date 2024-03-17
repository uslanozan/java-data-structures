import java.util.ArrayList;

public class Graph<T extends Comparable> {
    Vertex<T> head;

    public Vertex<T> findVertex(T id){
        Vertex<T> iterator=head;
        while(iterator!=null){
            if(iterator.id.compareTo(id)==0){
                return iterator;
            }
            iterator=iterator.nextVertex;
        }
        return null;

    }
    public void addVertex(T id){
        if(findVertex(id)!=null)
        {
            System.out.println("IT ALREADY EXISTS");
            return;
        }
        Vertex<T> newVertex= new Vertex<>(id);
        if (head==null)
            head=newVertex;
        else{
            Vertex<T> iterator=head;
            while(iterator.nextVertex!=null)
                iterator=iterator.nextVertex;
            iterator.nextVertex=newVertex;
        }
    }
    public void addEdge(T startingId, T endId, int w){
        Vertex<T> current=findVertex(startingId);
        Edge<T> newEdge=new Edge<>(endId, w);
        Edge<T> iteratorEdge=current.edgeLink;
        if(iteratorEdge==null)
            current.edgeLink=newEdge;
        else{
            while(iteratorEdge.nextEdge!=null)
                iteratorEdge=iteratorEdge.nextEdge;
            iteratorEdge.nextEdge=newEdge;
        }
    }
    public int outDegree(T id){
        Vertex<T> current=findVertex(id);
        int count=0;
        Edge<T> iteratorEdge=current.edgeLink;
        while(iteratorEdge!=null)
        {
            iteratorEdge=iteratorEdge.nextEdge;
            count++;
        }
        return count;
    }

    public ArrayList<T> findNeighbours(T Id){
        Vertex<T> current=findVertex(Id);
        Edge<T> iteratorEdge=current.edgeLink;
        ArrayList<T> arrayList=new ArrayList<>();
        while (iteratorEdge!=null){
            arrayList.add(iteratorEdge.vertexId);
            iteratorEdge=iteratorEdge.nextEdge;
        }
        return arrayList;
    }


//    public void topologicalSort(){
//        Graph copy=this.copyGraph();
//        ArrayList<T> vertices=new ArrayList<>();
//        if(copy.checkCycle()==true){
//            System.out.println("this is not valid graph");
//        }
//        else {
//            Vertex<T> startingVertex;
//            while (count()>=1){
//                startingVertex=copy.findVertexIndegreeZero(); //we assumed that is delete the this vertex
//                vertices.add(startingVertex.id);
//            }
//        }
//        copy.restoreGraph();
//        System.out.println(vertices);
//    }

    public void display() {
        Vertex<T> iteratorVertex = head;
        while (iteratorVertex != null) {
            System.out.print(iteratorVertex.id + "->");
            Edge<T> iteratorEdge = iteratorVertex.edgeLink;
            while (iteratorEdge != null) {
                System.out.print(iteratorEdge.vertexId + " ");
                iteratorEdge = iteratorEdge.nextEdge;
            }
            System.out.println();
            iteratorVertex = iteratorVertex.nextVertex;
        }
    }
}