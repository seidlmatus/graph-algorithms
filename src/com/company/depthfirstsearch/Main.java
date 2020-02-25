package com.company.depthfirstsearch;

import java.util.Arrays;

public class Main
{

	public static void main (String[] args)
	{
		DFS dfs = new DFS();
		Vertex v1 = new Vertex(1);
		Vertex v2 = new Vertex(2);
		Vertex v3 = new Vertex(3);
		Vertex v4 = new Vertex(4);
		Vertex v5 = new Vertex(5);

		v1.addNeighbour(v2);
		v1.addNeighbour(v4);
		v4.addNeighbour(v5);
		v2.addNeighbour(v3);

		dfs.dfs(Arrays.asList(v1, v2, v3, v4, v5));
	}
}
