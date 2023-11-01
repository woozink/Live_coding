package _0_기본알고구조;
import java.util.*;
/*
생성잔는 객체가 생성될 때 호출되어 객체의 초기 상태를 설정하는 특별한 메서드이다.
위에서  graph 클래스에 정의된 생성자는 그래프 객체를 생성하고 초기화 하는 역할을한다.
 */

public class Bfs {

    private int V; // 정점의 개수
    private List<Integer>[] adj; // 인접리스트를 사용하여 그래프 표현

    public Bfs( int V ){
        this.V = V; // 정점의 개수를 설정
        adj = new LinkedList[V]; // 리스트 배열 초기화
        for(int i = 0 ; i < V; i++){
            adj[i] = new LinkedList<>(); // 각 정점에 대한 인접리스트 초기화
        }
    }

    // 간선 추가 메서드 : v 에서 w로 가는 간선을 그래프에 추가
    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void BFS(int s){
        // 방문 여부를 추적하는 배얄
        boolean[] visited =  new boolean[V];
        // bfs를 수행하기 위한 큐
        Queue<Integer> q = new LinkedList<>();

        // 시작 정점은 방문처리하기
        visited[s] =true;
        System.out.println(s +" ");

        // 빠진 정점과 인접한 모든 정점을 반복
        for(int n : adj[s]){
            if(!visited[n]){
                visited[n] = true;
                q.add(n); // 큐에 추가
            }
        }

    }



    public static void main(String[] args) {
        Bfs g = new Bfs(6); // 0부터 5까지 6개의 정점

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        System.out.println("너비 우선 탐색 (시작 정점: 0):");
        g.BFS(0);
    }
}
