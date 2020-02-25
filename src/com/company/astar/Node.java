package com.company.astar;


import java.util.Objects;

public class Node
{
	// how far away that node is from the starting point
	private int g;
	//how far away that node is from the end node;
	private int h;
	private int rowIndex;
	private int colIndex;
	//previous node (this is how we track the shortest path)
	private Node predecessor;

	//the node may be an obstacle/block
	private boolean isBlock;

	@Override
	public boolean equals (Object node2)
	{
		Node node = (Node) node2;
		return rowIndex == node.rowIndex && colIndex == node.colIndex;
	}

	public int getRowIndex ()
	{
		return rowIndex;
	}

	public void setRowIndex (int rowIndex)
	{
		this.rowIndex = rowIndex;
	}

	public int getColIndex ()
	{
		return colIndex;
	}

	public void setColIndex (int colIndex)
	{
		this.colIndex = colIndex;
	}

	@Override
	public int hashCode ()
	{
		return Objects.hash(rowIndex, colIndex);
	}

	public Node getPredecessor ()
	{
		return predecessor;
	}

	public void setPredecessor (Node predecessor)
	{
		this.predecessor = predecessor;
	}

	public void setBlock (boolean block)
	{
		isBlock = block;
	}

	@Override
	public String toString ()
	{
		return "Node("+rowIndex + "," + colIndex + ")";
	}

	public Node (int rowIndex, int colIndex)
	{
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
	}

	public boolean isBlock(){
		return isBlock;
	}

	public  int getF(){
		return this.g+this.h;
	}

	public int getG ()
	{
		return g;
	}

	public void setG (int g)
	{
		this.g = g;
	}

	public int getH ()
	{
		return h;
	}

	public void setH (int h)
	{
		this.h = h;
	}
}
