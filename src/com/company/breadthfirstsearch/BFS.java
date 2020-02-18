package com.company.breadthfirstsearch;

import java.util.LinkedList;
import java.util.Queue;

public class BFS
{
		public void bfs(Vertex root){
			Queue<Vertex> queue = new LinkedList<>();
			root.setVisited(true);
			queue.add(root);
			while (! queue.isEmpty()){
				Vertex actual = queue.remove();
				System.out.println(actual.toString());

				for (Vertex vertex: actual.getNeighbours())
				{
					if (!vertex.isVisited()){
						vertex.setVisited(true);
						queue.add(vertex);
					}
				}
			}
		}
}
