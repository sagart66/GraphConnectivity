import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

class graph4{
    int vertices;
    LinkedList<Integer> graph[];
    graph4(int v){
        vertices=v;
        graph=new LinkedList[v];
        for(int i=0;i<v;i++)
            graph[i]=new LinkedList<Integer>();
    }
    void addEdge(int src,int des){
        graph[src].add(des);
        graph[des].add(src);
    }
    void Dfs(int u,boolean []visited){
        visited[u]=true;
        Iterator<Integer> it = graph[u].listIterator();
        while(it.hasNext()){
            int k=it.next();
            if(!visited[k])
                Dfs(k,visited);

        }

    }
    boolean isConnected(){
        boolean[] visited=new boolean[vertices];
        Arrays.fill(visited,false);
        int i;
        for(i=0;i<graph.length;i++)
            if(graph[i].size()>0)
                break;

        Dfs(i,visited);

        for(i=0;i<graph.length;i++)
            if(!visited[i] && graph[i].size()>0)
                return false;
        return true;
    }
    boolean hasEuclearianCycle(){
        int odd=oddDegreeVertices();
        if(isConnected() && odd==0)
            return true;
        return false;
    }
    boolean hasEuclearianPath(){
        int odd=oddDegreeVertices();
        if(isConnected() && odd==2 || odd==0)
            return true;
        return false;
    }
    int oddDegreeVertices(){
        int odd=0;
        for(int i=0;i<vertices;i++)
            if(graph[i].size()%2!=0)
                odd++;
        return odd;
    }
}













public class EuclerianpathAndEuclearianCycle {
    solverEuclearian solver;

    @Before
   public void setUp(){
        solver=new solverEuclearian();
    }


    @Test
    public void test1(){
        assertEquals("true\nfalse",solver.solve(5,new int[]{1,2,2,0,1,0,0,3,3,4}));
    }
    @Test
    public void test2(){
        assertEquals("true\ntrue",solver.solve(5,new int[]{0,4,1,2,2,0,1,0,0,3,3,4}));
    }
    @Test
    public void test3(){
        assertEquals("false\nfalse",solver.solve(5,new int[]{1,3,1,2,2,0,1,0,0,3,3,4}));
    }



}




























class solverEuclearian{
    String solve(int v,int a[]){
    graph4 graph=new graph4(v);
    for(int i=0;i<a.length-1;i=i+2)
        graph.addEdge(a[i],a[i+1]);
    StringBuilder output=new StringBuilder();

    output.append(graph.hasEuclearianPath());
    output.append("\n");
        output.append(graph.hasEuclearianCycle());
        return output.toString();
    }
}














