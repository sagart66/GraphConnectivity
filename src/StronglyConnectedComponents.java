//There is some string output format problem

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class StronglyConnectedComponents {
    SCCsolver g;
    @Before
    public void setUp(){
        g=new SCCsolver();
    }
    @Test
    public  void test1(){
        assertEquals("012\n3\n4\n",g.solve(5,new int[]{3,4,0,3,1,0,2,1,0,2}));
    }

}
class graph5{
    int vertices;
    LinkedList<Integer> graph[];
    graph5(int v){
        vertices=v;
        graph=new LinkedList[v];
        for(int i=0;i<vertices;i++)
            graph[i]=new LinkedList<>();
    }
    void addEdge(int src, int des){
        graph[src].add(des);
    }
    String ConnectedComponents(){
        StringBuilder output=new StringBuilder();
        boolean visited[]=new boolean[vertices];
        Arrays.fill(visited,false);
        LinkedList<Integer>stack=new LinkedList<>();
        for(int i=0;i<visited.length;i++)
            if(!visited[i])
                fillOrder(i,visited,stack);

        graph=GraphTranspose();

        Arrays.fill(visited,false);

        while(!stack.isEmpty()){
            int v=stack.removeLast();
            if(!visited[v]){
                dfs(v,visited,output);
               output.append("\n");
            }
        }
        return output.toString();
    }

    public void dfs(int v, boolean[] visited,StringBuilder a) {
        visited[v]=true;
          a.append(v);
        Iterator<Integer> it=graph[v].listIterator();
        while(it.hasNext()){
            int k=it.next();
            if(!visited[k])
                dfs(k,visited,a);
        }
    }
    LinkedList<Integer>[] GraphTranspose() {
        graph5 graph1=new graph5(vertices);
        for(int i=0;i<vertices;i++){
            Iterator<Integer> it=graph[i].listIterator();
            while(it.hasNext()){
                graph1.graph[it.next()].add(i);
            }
        }
        return graph1.graph;
    }

    private void fillOrder(int i, boolean[] visited, LinkedList<Integer> stack) {

        visited[i]=true;
        Iterator<Integer> it=graph[i].listIterator();
        while(it.hasNext()){
            int k=it.next();
            if(!visited[k])
                fillOrder(k,visited,stack);
        }
        stack.addLast(i);
    }


}




















class SCCsolver{
        String solve(int v,int a[]){
             graph5 graph=new graph5(v);
             for(int i=0;i<a.length-1;i=i+2)
                 graph.addEdge(a[i],a[i+1]);
            return graph.ConnectedComponents();
        }

}












