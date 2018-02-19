    import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class CheckGraphIsTree {
    TreeSOlver g;

    @Before
    public void setUp() {
        g = new TreeSOlver();
    }

    @Test
    public void Test1() {
        assertEquals(true, g.solve(5, new int[]{1, 0, 2, 0, 0, 3, 3, 4}));
    }

    @Test
    public void Test2() {
        assertEquals(false, g.solve(5, new int[]{1, 0, 2, 0, 0, 3, 3, 4, 1, 2}));
    }
}

class graph6 {
    int vertices;
    LinkedList<Integer> graph[];

    graph6(int v) {
        vertices = v;
        graph = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            graph[i] = new LinkedList<>();
    }

    void addEdge(int src, int des) {
        graph[src].add(des);
        graph[des].add(src);
    }

    boolean checkCycle(int u, boolean visited[], int parent) {
        visited[u] = true;
        Iterator<Integer> it = graph[u].listIterator();
        while (it.hasNext()) {
            int k = it.next();
            if (!visited[k]){
                if (checkCycle(k, visited, u))
                    return true;
            }
            else if (k != parent)
                    return true;

        }
        return false;
    }

    boolean isTree() {
        boolean visited[] = new boolean[vertices];
        Arrays.fill(visited, false);
        if (checkCycle(0, visited, -1))
            return false;
        for (boolean i : visited)
            if (!i)
                return false;
        return true;


    }
}
class TreeSOlver{
    boolean solve(int v,int a[]){
        graph6 graph=new graph6(v);
        for(int i=0;i<a.length;i=i+2)
            graph.addEdge(a[i],a[i+1]);
        return graph.isTree();
    }

}