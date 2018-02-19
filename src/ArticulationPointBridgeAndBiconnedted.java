//This program is for undirected graphs
//in this program we have low[v] which indicates earliest visited vertex visited in a tree routed by  v
//In this program we have disc[v] which indicates time of visiting vertex v
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class ArticulationPointBridgeAndBiconnedted {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of vertices in graph");
        graph3 graph = new graph3(input.nextInt());
        System.out.println("Enter number of edges in graph");
        int n = input.nextInt();
        System.out.println("Enter starting vertex and ending vertex space seperated and enter each edge on newline");
        for (int i = 0; i < n; i++)
            graph.addEdge(input.nextInt(), input.nextInt());
        LinkedList l = graph.ArticulationPoints();
        if (l.size() == 0)
            System.out.println("There are no articulation points and no Bridges in this graph. This graph is Biconneted");
        else {
            System.out.println("These are the articulation points of this graph " + l + " \nBridges are:");
            graph.printBridges();
        }
    }
}
class graph3{
     int vertices;
    int time=0;
    final LinkedList<Integer>graph[];
    final LinkedList<Integer> bridge=new LinkedList<>();
    graph3(int v){
        vertices=v;
        graph=new LinkedList[v];
        for(int i=0;i<vertices;i++)
            graph[i]=new LinkedList<Integer>();
    }
    void addEdge(int src, int des){
        //undirected graph
        graph[src].add(des);
        graph[des].add(src);
    }

    LinkedList<Integer> ArticulationPoints(){
        boolean visited[]=new boolean[vertices];
        int parent[]=new int[vertices];
        int disc[]=new int[vertices];
        int low[]=new int[vertices];
        LinkedList<Integer> ap=new LinkedList<>();

        Arrays.fill(visited,false);
        Arrays.fill(parent,-1);
        for(int i=0;i<visited.length;i++)
            if(!visited[i])
                Ap(i,parent,visited,disc,low,ap);
        return ap;
    }
    void Ap(int u,int parent[],boolean[] visited, int[] disc, int[] low, LinkedList<Integer>ap){
        int children=0;
        low[u]=disc[u]=time++;
        visited[u]=true;
        Iterator<Integer> it = graph[u].listIterator();
        while(it.hasNext()){
            int k=it.next();
            if(!visited[k]){
                children++;
                parent[k]=u;
                Ap(k,parent,visited,disc,low,ap);

                low[u]=Math.min(low[u],low[k]);

                //if root with two or more children is articulation point
                if(parent[u]==-1 && children>1 && !ap.contains(u))
                    ap.add(u);

                //if node u is not a root and
                //and it has child v such that no child of v in v rooted DfS tree has back edge to u's ancestor
                if(parent[u]!=-1 && low[k]>=disc[u] && !ap.contains(u))    //here k is child of u
                    ap.add(u);
                if(low[k]>disc[u]) {
                    bridge.add(u);
                    bridge.add(k);
                }

            }
            else if(k!=parent[u]){
                low[u]=Math.min(low[u],disc[k]);
            }
        }
    }
    public void printBridges(){
        if(!bridge.isEmpty()){
            Iterator<Integer> it=bridge.listIterator();
            System.out.println("Following are the bridges in given graph");
            while(it.hasNext()){
                System.out.println(it.next()+"----"+it.next());
            }
        }
    }
}
class Solver{
    LinkedList<Integer> solve(int v,int e,int a[]){
        graph3 graph=new graph3(v);
        for(int i=0;i<a.length-1;i=i+2)
            graph.addEdge(a[i],a[i+1]);
        return graph.ArticulationPoints();
    }
    LinkedList<Integer>solve1(int v,int e,int a[]){
        graph3 graph=new graph3(v);
        for(int i=0;i<a.length-1;i=i+2)
            graph.addEdge(a[i],a[i+1]);
        graph.ArticulationPoints();
        return graph.bridge;
    }

}



