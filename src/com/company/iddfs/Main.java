package com.company.iddfs;

import com.company.depthfirstsearch.DFS;
import com.company.depthfirstsearch.Vertex;

import java.util.Arrays;

public class Main
{

	public static void main (String[] args)
	{

		Node v1 = new Node("A");
		Node v2 = new Node("B");
		Node v3 = new Node("C");
		Node v4 = new Node("D");
		Node v5 = new Node("E");

		v1.addNeighbour(v2);
		v1.addNeighbour(v3);
		v2.addNeighbour(v4);
		v4.addNeighbour(v5);

		Algorithm algorithm = new Algorithm(v5);
		algorithm.runDeepingSearch(v1);
	}
}
