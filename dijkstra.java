import java.util.*;

public class dijkstra {

  public static void dijkstraa(int[][] graph, int source) 
  {
    int count = graph.length;
    boolean[] visitedVertex = new boolean[count];
    int[] distance = new int[count];
    for (int i = 0; i < count; i++) {
      visitedVertex[i] = false;
      distance[i] = Integer.MAX_VALUE;
    }
    distance[source] = 0;
    for (int i = 0; i < count; i++) 
    {
      int u = findMinDistance(distance, visitedVertex);
      visitedVertex[u] = true;
      for (int v = 0; v < count; v++) 
      {
        if (!visitedVertex[v] && graph[u][v] != 0 && (distance[u] + graph[u][v] < distance[v])) 
        { 
          distance[v] = distance[u] + graph[u][v];
        }
      }
    }
    for (int i = 0; i < distance.length; i++) {
      System.out.println(String.format("Distance from %s to %s is %s", source, i, distance[i]));
    }

  }
  public static int findMinDistance(int[] distance, boolean[] visitedVertex) {
    int minDistance = Integer.MAX_VALUE;
    int minDistanceVertex = -1;
    for (int i = 0; i < distance.length; i++) {
      if (!visitedVertex[i] && distance[i] < minDistance) {
        minDistance = distance[i];
        minDistanceVertex = i;
      }
    }
    return minDistanceVertex;
  }

  public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     System.out.println("Enter No. of vertices: ");
     int v=sc.nextInt();
     int graph[][] = new int[v][v];
     for(int i=0;i<v;i++){
           for(int j=0;j<v;j++){
                  graph[i][j]=sc.nextInt();
            }
     }
    //dijkstra T = new dijkstra();
   System.out.println("Enter the source: ");
   int src=sc.nextInt();
    dijkstraa(graph, src);
  }
}
