package com.company.iddfs;

import java.util.ArrayList;
import java.util.List;

public class Node
{
	private String name;
	private int deptLever = 0;
	private List<Node> adjececiesList;

	public Node (String name)
	{
		this.name = name;
		this.adjececiesList = new ArrayList<>();
	}

	public void addNeighbour (Node node){
		this.adjececiesList.add(node);
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public int getDeptLever ()
	{
		return deptLever;
	}

	public void setDeptLever (int deptLever)
	{
		this.deptLever = deptLever;
	}

	public List<Node> getAdjececiesList ()
	{
		return adjececiesList;
	}

	public void setAdjececiesList (List<Node> adjececiesList)
	{
		this.adjececiesList = adjececiesList;
	}

	@Override
	public String toString ()
	{
		return name.toUpperCase();
	}
}
