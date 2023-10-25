package main;

import java.util.ArrayList;
import java.util.Arrays;

import Support.LinkedStack;
import Support.LinkQueue;
import Support.Point;
import Support.QueueUnderflowException;
import Support.StackUnderflowException;

public class MainwithPoint {

	public static void main(String[] args) throws QueueUnderflowException, StackUnderflowException {
		// TODO Auto-generated method stub
		int[][] example = { { 2, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1 }, 
							{ 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1 },
							{ 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, 
							{ 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1 },
							{ 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 }, 
							{ 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1 },
							{ 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1 }, 
							{ 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1 },
							{ 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1 }, 
							{ 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1 },
							{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, 
							{ 1, 1, 1, 1, 9, 0, 0, 1, 1, 1, 1 }, };
		PrintMaze(example);
		SolveMazeStack(example);
	}
	public static void PrintMaze(int[][] ex) {
		for (int[] row : ex) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("---------");

	}
	public static void SolveMazeStack(int[][] ex) throws StackUnderflowException {
		LinkedStack<Point> m = new LinkedStack<Point>();
		ArrayList<Point> n = new ArrayList<Point>();
		int c=2;
		Point o= new Point(0,0);
		m.push(o);
		n.add(o);
		while(c!=9) {
			Point curr=m.pop();
			int x=curr.x;
			int y=curr.y;
			ex[x][y]=3;
			PrintMaze(ex);
			ex[x][y]=0;
			if(CheckR(curr,ex)==0 && !(CheckE(n, new Point(x+1,y)))) {
				m.push(new Point(x+1,y));
				n.add(new Point(x+1,y));
				}
			if(CheckL(curr,ex)==0 && !(CheckE(n, new Point(x-1,y)))) {
				m.push(new Point(x-1,y));
				n.add(new Point(x-1,y));
			}
			if(CheckB(curr,ex)==0 && !(CheckE(n, new Point(x,y+1)))) {
				m.push(new Point(x,y+1));
				n.add(new Point(x,y+1));
			}
			if(CheckT(curr,ex)==0 && !(CheckE(n, new Point(x,y-1)))) {
				m.push(new Point(x,y-1));
				n.add(new Point(x,y-1));
			}
			if(CheckR(curr,ex)==1||CheckL(curr,ex)==1 ||CheckB(curr,ex)==1||CheckT(curr,ex)==1) {
				ex[x][y]=3;
				System.out.println("end");
				break;
			}
			ex[x][y]=0;
		}
	}
	public static void SolveMazeQueue(int[][] ex) throws QueueUnderflowException {
		LinkQueue<Point> m = new LinkQueue<Point>();
		ArrayList<Point> n = new ArrayList<Point>();
		int c=2;
		Point o= new Point(0,0);
		m.enqueue(o);
		n.add(o);
		while(c!=9) {
			Point curr=m.dequeue();
			int x=curr.x;
			int y=curr.y;
			ex[x][y]=3;
			PrintMaze(ex);
			ex[x][y]=0;
			if(CheckR(curr,ex)==0 && !(CheckE(n, new Point(x+1,y)))) {
				m.enqueue(new Point(x+1,y));
				n.add(new Point(x+1,y));
				}
			if(CheckL(curr,ex)==0 && !(CheckE(n, new Point(x-1,y)))) {
				m.enqueue(new Point(x-1,y));
				n.add(new Point(x-1,y));
			}
			if(CheckB(curr,ex)==0 && !(CheckE(n, new Point(x,y+1)))) {
				m.enqueue(new Point(x,y+1));
				n.add(new Point(x,y+1));
			}
			if(CheckT(curr,ex)==0 && !(CheckE(n, new Point(x,y-1)))) {
				m.enqueue(new Point(x,y-1));
				n.add(new Point(x,y-1));
			}
			if(CheckR(curr,ex)==1||CheckL(curr,ex)==1 ||CheckB(curr,ex)==1||CheckT(curr,ex)==1) {
				ex[x][y]=3;
				System.out.println("end");
				break;
			}
			ex[x][y]=0;
		}
	}
	public static int CheckR(Point curr, int[][] ex) {
		int i =curr.x;
		int j=curr.y;
		if(i < ex[0].length) {
			i++;
			if (ex[i][j] == 0) {
				return 0;
			}
			else if (ex[i][j] == 9) {
				return 1;
			}
			else {
				return -1;
			}
	}
		else {
			return -1;
		}
	}
	public static int CheckL(Point curr, int[][] ex) {
		int i =curr.x;
		int j=curr.y;
		if(i > 0) {
			i--;
			if (ex[i][j] == 0) {
				return 0;
			}
			else if (ex[i][j] == 9) {
				return 1;
			}
			else {
				return -1;
			}
	}
		else {
			return -1;
		}
	}
	public static int CheckB(Point curr, int[][] ex) {
		int i =curr.x;
		int j=curr.y;
		if(j < ex.length) {
			j++;
			if (ex[i][j] == 0) {
				return 0;
			}
			else if (ex[i][j] == 9) {
				return 1;
			}
			else {
				return -1;
			}
	}
		else {
			return -1;
		}
	}
	public static int CheckT(Point curr, int[][] ex) {
		int i =curr.x;
		int j=curr.y;
		if(j > 0) {
			j--;
			if (ex[i][j] == 0) {
				return 0;
			}
			else if (ex[i][j] == 9) {
				return 1;
			}
			else {
				return -1;
			}
	}
		else {
			return -1;
		}
	}
	
	public static boolean CheckE(ArrayList<Point> n, Point curr) {
		for(Point p: n) {
			if(curr.equals(p)) {
				return true;
			}
		}
		return false;
		
	}
}
	


