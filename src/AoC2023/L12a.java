package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

public class L12a {
	private static List<String> hill;
	private static Character[][] h;
	private static boolean[][] v;
	private static int lenght;
	private static int height;

	record Node(int x, int y, int d) {
	}

	public static void run(String ext) throws IOException {
		hill = Files.readAllLines(Paths.get("./src/AoC2022/L12input" + ext + ".txt"));
		lenght = hill.get(0).length();
		height = hill.size();
		h = new Character[lenght][height];
		v = new boolean[lenght][height];
		PriorityQueue<Node> nodes = new PriorityQueue<>((n1, n2) -> n1.d < n2.d ? -1 : 1);
		int stopX = 0, stopY = 0;

		for (int i = 0; i < height; i++) {
			String r = hill.get(i);
			for (int j = 0; j < lenght; j++) {
				char c = r.charAt(j);
				if (c == 'E') {
					stopX = j;
					stopY = i;
					c = 'z';
				}
				h[j][i] = c;
			}
		}

		nodes.add(new Node(stopX, stopY, 1));
		Node n;
		while (true) {
			n = nodes.poll();
			if (v[n.x][n.y]) {
				continue;
			}
			v[n.x][n.y] = true;
			Character c = h[n.x][n.y];
			Character nc;
			if (n.x > 0) {
				nc = h[n.x - 1][n.y];
				if (nc == 'S') {
					break;
				}
				if (nc >= (char) c - 1) {
					nodes.add(new Node(n.x - 1, n.y, n.d + 1));
				}
			}
			if (n.y > 0) {
				nc = h[n.x][n.y - 1];
				if (nc == 'S') {
					break;
				}
				if (nc >= (char) c - 1) {
					nodes.add(new Node(n.x, n.y - 1, n.d + 1));
				}
			}
			if (n.x < lenght - 1) {
				nc = h[n.x + 1][n.y];
				if (nc == 'S') {
					break;
				}
				if (nc >= (char) c - 1) {
					nodes.add(new Node(n.x + 1, n.y, n.d + 1));
				}
			}
			if (n.y < height - 1) {
				nc = h[n.x][n.y + 1];
				if (nc == 'S') {
					break;
				}
				if (nc >= (char) c - 1) {
					nodes.add(new Node(n.x, n.y + 1, n.d + 1));
				}
			}
		}
		System.out.println("Shortest path: " + n.d);
	}
}
