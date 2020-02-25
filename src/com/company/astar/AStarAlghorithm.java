package com.company.astar;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class AStarAlghorithm
{
	//all the nodes/states on the grid
	private Node[][] searchSpace;
	//where we start
	private Node startNode;
	//this is what we are after
	private Node finalNode;
	//the set of nodes that are already evaluated
	private List<Node> closedSet;
	// not yet evaluated
	private Queue<Node> openSet;

	public AStarAlghorithm ()
	{
		this.searchSpace = new Node[Constants.NUM_ROWS][Constants.NUM_COLS];
		this.openSet = new PriorityQueue<>(new NodeComparator());
		this.closedSet = new ArrayList<>();
		initializeSearchSpace();
	}

	private void initializeSearchSpace ()
	{
		for (int rowIndex = 0; rowIndex< Constants.NUM_ROWS; rowIndex++){
			for (int colIndex = 0; colIndex< Constants.NUM_COLS; colIndex++){
				Node node = new Node(rowIndex,colIndex);
				this.searchSpace[rowIndex][colIndex] = node;
			}
		}
		// set obstacles or blocks
		this.searchSpace[1][7].setBlock(true);
		this.searchSpace[2][3].setBlock(true);
		this.searchSpace[2][4].setBlock(true);
		this.searchSpace[2][5].setBlock(true);
		this.searchSpace[2][6].setBlock(true);
		this.searchSpace[2][7].setBlock(true);

		// start node and final node
		this.startNode = this.searchSpace[3][3];
		this.finalNode = this.searchSpace[1][6];
	}

	private List<Node> getAllNeighbours(Node node){
		List<Node> neighbours = new ArrayList<>();
		int row = node.getRowIndex();
		int col =node.getColIndex();

		//block above
		if (row-1 >= 0 && this.searchSpace[row-1][col].isBlock() ){
			this.searchSpace[row-1][col].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			this.searchSpace[row-1][col].setH(manhattanHeuristic(this.searchSpace[row-1][col],finalNode));
			neighbours.add(this.searchSpace[row-1][col]);
		}
		//block below
		if (row+1 < Constants.NUM_ROWS && !this.searchSpace[row+1][col].isBlock() ){
			this.searchSpace[row+1][col].setH(manhattanHeuristic(this.searchSpace[row+1][col],finalNode));
			this.searchSpace[row+1][col].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			neighbours.add(this.searchSpace[row+1][col]);
		}
		//block to the left
		if (col-1 >= 0 && this.searchSpace[row][col-1].isBlock() ){
			this.searchSpace[row][col-1].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			this.searchSpace[row][col-1].setH(manhattanHeuristic(this.searchSpace[row][col-1],finalNode));
			neighbours.add(this.searchSpace[row][col-1]);
		}

		//block to the right
		if (col+1 < Constants.NUM_ROWS && !this.searchSpace[row][col+1].isBlock() ){
			this.searchSpace[row][col+1].setH(manhattanHeuristic(this.searchSpace[row][col+1],finalNode));
			this.searchSpace[row][col+1].setG(node.getG()+Constants.HORIZONTAL_VERTICAL_COST);
			neighbours.add(this.searchSpace[row][col+1]);
		}
		return neighbours;
	}

	public void search(){
		startNode.setH(manhattanHeuristic(startNode,finalNode));
		openSet.add(startNode);
		while (!openSet.isEmpty()){
			//poll: return node with the smallest f = h+g value
			Node currentNode = openSet.poll();
			System.out.println(currentNode+" Predecessor is: "+currentNode.getPredecessor());

			//if we find the terminal state we've don
			if(currentNode.equals(finalNode)) return;

			openSet.remove(currentNode);
			closedSet.add(currentNode);

			//visit all the neighors of the actual node
			for(Node neighbour: getAllNeighbours(currentNode)){
				//we have already consider that state so go on
				if(closedSet.contains(neighbour)) continue;
				// we conseider the state so we've done with that one
				if(!openSet.contains(neighbour)) openSet.add(neighbour);
				//set the predecessor to bye able to track she shortest path;
				neighbour.setPredecessor(currentNode);

			}
		}
	}

	//manhattan distance
	public int manhattanHeuristic (Node node1, Node node2){
		return (Math.abs(node1.getRowIndex() - node2.getRowIndex()) +  Math.abs(node1.getColIndex() - node2.getColIndex()))*10;
	}

	public void showPath(){
		System.out.println("SHORTEST PATCH WITCH A* SEARCH: ");
		Node node = this.finalNode;
		while (node != null){
			System.out.println(node);
			node = node.getPredecessor();
		}

	}
}
