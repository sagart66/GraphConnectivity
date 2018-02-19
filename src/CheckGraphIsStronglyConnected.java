import java.util.*;

public class CheckGraphIsStronglyConnected {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of vertices in graph");
        graph2 graph=new graph2(input.nextInt());
        System.out.println("Enter number of edges in graph");
        int n=input.nextInt();
        System.out.println("Enter starting vertex and ending vertex space seperated and enter each edge on newline");
        for(int i=0;i<n;i++)
            graph.addEdge(input.nextInt(),input.nextInt());
        System.out.println("Strongly conneted status "+graph.Dfs());


    }
}
class graph2{
    int vertices;
    LinkedList<Integer> graph[];
    graph2(int v){
        vertices=v;
        graph=new LinkedList[v];
        for(int i=0;i<v;i++)
            graph[i]=new LinkedList<Integer>();
    }
    void addEdge(int src, int des){
        graph[src].add(des);
    }
    boolean checkAllVisited(boolean[] visited){
    for(boolean i:visited)
        if(i==false)
            return false;
        return true;
    }
    boolean Dfs(){
        boolean visited[]=new boolean[vertices];
        Arrays.fill(visited,false);
        LinkedList<Integer>Stack=new LinkedList<Integer>();
        Dfs1(0,visited);
        if(checkAllVisited(visited)) {
            Arrays.fill(visited,false);
            graph2 gr = reverseEdges();
            gr.Dfs1(0, visited);
            return gr.checkAllVisited(visited);
        }
        return false;

    }
   void Dfs1(int u,boolean visited[]){
       visited[u]=true;
       Iterator<Integer> it=graph[u].listIterator();
       while(it.hasNext()){
           int k=it.next();
          if(!visited[k])
           Dfs1(k,visited);
       }
    }
    graph2 reverseEdges(){
        graph2 g=new graph2(vertices);
        for(int i=0;i<graph.length;i++){
            Iterator<Integer>it=graph[i].listIterator();
            while(it.hasNext()){
                g.graph[it.next()].add(i);

            }

        }
        return g;
    }
}