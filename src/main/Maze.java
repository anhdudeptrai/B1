package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.*;

public class Maze {
	
	public static double norm2(int x1, int y1, int x2, int y2) {
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}
	
	public static void main(String[] args) {
		//
		JFrame frame = new JFrame();
		frame.setSize(650, 470);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MazePanel mp = new MazePanel();
		frame.add(mp);
		frame.setVisible(true);
	}

	public static class MazePanel extends JPanel {
		private static final long serialVersionUID = -566807999447681130L;
		private int[][] maze = { // khởi tạo ma trận mảng 2 chiều
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 2, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1 },
				{ 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
		private int sizeh, sizew, start, end;
		
		private Point2 pEnd = new Point2(10, 15);
		ArrayList<Point2> kq = new ArrayList<Point2>();
		private boolean endgame = false;
		
		public MazePanel() {
			// Kích thước ma trận
			sizeh = 21;
			sizew = 31;
			start = 10;
			end = 0;
			solve();
			repaint(); // vẽ ma trận và lời giải
		}

		/**
		 * Implement một phương pháp tìm đường nào đó.
		 * <p>
		 * Yêu cầu : Vẽ đường đi từ điểm bắt đầu đến điểm kết thúc. Không hiện
		 * các phần thừa - là các phần đường cụt hoặc đường đi bị sai. Chỉ vẽ
		 * tuyến đường chính đi từ điểm đầu (màu vàng) đến màu đỏ.
		 * <p>
		 * Đường đi từ điểm đầu đến điểm cuối được tô màu xanh dương, để tô màu
		 * xanh dương hãy set giá trị của điểm trên ma trận sang một số > 2
		 */
		public boolean kt(Point2 p, ArrayList<Point2> kq) {
			for (Point2 q: kq) if (p.equals(q)) 
				return true;
			return false;
		}
		
		public void DFS(Point2 p) {
			if (!endgame) {
				kq.add(p);
				if (p.equals(pEnd)) {
					for (Point2 pkq : kq) maze[pkq.x][pkq.y] = 3;
					endgame = true;
					return;
				}
				Point2 pi[] = new Point2[5];
				pi[1] = new Point2(p.x+1, p.y);
				pi[2] = new Point2(p.x-1, p.y);
				pi[3] = new Point2(p.x, p.y+1);
				pi[4] = new Point2(p.x, p.y-1);
				ArrayList<Point2> list = hf(pi);
				for (Point2 q: list) 
					if (!kt(q,kq)) DFS(q);
				kq.remove(kq.size()-1);
			}
		}

		public void solve() {
			maze[10][15] = 0;
			// maze[][]			start = 10		end = 0		diem ket thuc maze[10][15]
			DFS(new Point2(start, end));
			maze[10][15] = 2;
			//for (Point2 pkq: kq) maze[pkq.x][pkq.y]=3;
		}

		private ArrayList<Point2> hf(Point2[] pi) {
			ArrayList<Point2> list = new ArrayList<Point2>();
 			ArrayList<Double> h = new ArrayList<Double>();
			for (int i=1; i<=4; i++) 
				if (pi[i].x>=0 && pi[i].y>=0 && pi[i].x<=20 && pi[i].y<=30 && maze[pi[i].x][pi[i].y] == 0) {
					if (list.size()==0) {
						list.add(pi[i]);
						h.add(norm2(pi[i].x, pi[i].y, 10, 15));
					}
					else {
						double h1 = norm2(pi[i].x, pi[i].y, 10, 15);
						int pos=0;
						while (pos<h.size()) {
							if (h.get(pos)>h1) break;
							pos++;
						}
						h.add(pos, h1);
						list.add(pos, pi[i]);
					}
				}
			return list;						
		}

		public void paintComponent(Graphics g) // vẽ ma trận + lời giải
		{
			super.paintComponent(g);
			for (int j = 0; j < sizew; j++)
				for (int i = 0; i < sizeh; i++) {
					if (i == start && j == end)
						g.setColor(Color.yellow);
					else if (maze[i][j] == 0)
						g.setColor(Color.white);
					else if (maze[i][j] == 1)
						g.setColor(Color.black);
					else if (maze[i][j] == 2)
						g.setColor(Color.red);
					else
						g.setColor(Color.blue); // blue là màu của lời giải
					g.fillRect(j * 20, i * 20, 20, 20);
				}
		}
	}
}