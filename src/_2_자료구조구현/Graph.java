package _2_자료구조구현;

import java.util.LinkedList;
import java.util.List;

class Graph {
    private final List<List<Integer>> adjList;
    private final int numVertices;

    // 그래프 생성자: 정점의 개수를 기반으로 초기화합니다.
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new LinkedList<>();
        for(int i = 0 ; i < numVertices; i++){
            this.adjList.add(new LinkedList<>()); // 각 정점에 대한 인접리스트 초기화
        }
    }

    // 간선을 추가하는 메서드
    public void addEdge(int from, int to) {
        this.adjList.get(from).add(to);
    }

    // 그래프를 출력하는 메서드
    public void printGraph() {
        for(int i = 0 ; i < this.numVertices; i++){
            List<Integer> edges = this.adjList.get(i);

            System.out.println("정점 " + i );
            for(int edge : edges){
                System.out.println(edge + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5); // 5개의 정점을 가진 그래프 생성

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.printGraph();
    }
}
