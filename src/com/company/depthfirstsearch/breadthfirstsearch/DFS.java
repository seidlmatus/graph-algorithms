package com.company.depthfirstsearch.breadthfirstsearch;

import java.util.List;
import java.util.Stack;

public class DFS
{

	private Stack<Vertex> stack;

	public DFS ()
	{
		this.stack = new Stack<>();
	}

	public void dfs (List<Vertex> vertexs)
	{
		for (Vertex v : vertexs)
		{
			if (!v.isVisited())
			{
				dfsWithStack(v);
			}
		}
	}

	private void dfsRecursive (Vertex vertex)
	{
		System.out.println(vertex.toString());
		for (Vertex v : vertex.getNeighbours())
		{
			if (!v.isVisited())
			{
				v.setVisited(true);
				dfsRecursive(v);
			}
		}
	}

	private void dfsWithStack (Vertex vertex)
	{
		this.stack.add(vertex);
		vertex.setVisited(true);
		while (!stack.isEmpty())
		{
			Vertex actual = this.stack.pop();
			System.out.println(actual.toString());
			for (Vertex v : actual.getNeighbours())
			{
				if (!v.isVisited())
				{
					v.setVisited(true);
					this.stack.push(v);
				}
			}
		}
	}
}
