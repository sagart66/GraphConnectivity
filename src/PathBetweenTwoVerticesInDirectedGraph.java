//I modified the question question was to find whether there is path between two given vertices in directed graph
//I calculated whether there is path between two vertices and printed all the possible paths between given two vertices
//this is O(n) solution
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
public class PathBetweenTwoVerticesInDirectedGraph {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of vertices in graph");
        graph1 graph=new graph1(input.nextInt());
        System.out.println("Enter number of edges in graph");
        int n=input.nextInt();
        System.out.println("Enter starting vertex and ending vertex space seperated and enter each edge on newline");
        for(int i=0;i<n;i++)
            graph.addEdge(input.nextInt(),input.nextInt());
        System.out.println("Enter starting and ending vertex");
        int u=input.nextInt();
        int v=input.nextInt();
        System.out.println("All paths between given vertices :");
        graph.findPath(u,v);
    }
}
class graph1 {
    final private int vertices;
    int count;
    final private LinkedList<Integer> graph[];
    int getVertices(){return vertices;}

    graph1(int v) {
        vertices = v;
        count=0;
        graph = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            graph[i] = new LinkedList<Integer>();
        }
    }
    void addEdge(int src, int des) {
        graph[src].add(des);
    }

    void findPath(int u, int v) {
        boolean visited[] = new boolean[vertices];
        LinkedList<Integer> path = new LinkedList<Integer>();
        Arrays.fill(visited, false);
        path.add(u);
        path(u, v, visited, path,u);
        if (count==0)
            System.out.println("No path from " + u + " to " + v);
    }

    void path(int u, int v, boolean[] visited, LinkedList<Integer> path,int initial) {
        if (v == u)
            return;
        visited[u] = true;


        Iterator<Integer> it = graph[u].listIterator();

        while (it.hasNext()) {
            //
            if(u==initial) {
                path.clear();
                path.add(initial);
                //Arrays.fill(visited,false);  O(n) this will make O(n^2) of this whole problem
                visited=new boolean[vertices];
                visited[initial]=true;
            }
            int k = it.next();
            if(k==v) {
                path.add(k);
                 count++;
                 System.out.println(path);
                return;
            }
            if (!visited[k]) {
                path.add(k);
                path(k, v, visited, path,initial);

            }

            }
        }
    }







