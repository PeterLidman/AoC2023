package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L05b {
	private static List<String> _moves;

	public static void run(String ext) throws IOException {
		_moves = Files.readAllLines(Paths.get("./src/AoC2022/L05input" + ext + ".txt"));
		int skip;
		List<Deque<String>> c = new ArrayList<>(10);

		if (ext.equals("0")) {
			skip = 10;
			c.add(new LinkedList<String>(Arrays.asList("RWFHTS".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("WQDGS".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("WTB".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("JZQNTWRD".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("ZTVLGHBF".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("GSBVCTPL".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("PGWTRBZ".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("RJCTMGN".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("WBGL".split(""))));
		} else {
			skip = 5;
			c.add(new LinkedList<String>(Arrays.asList("NZ".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("DCM".split(""))));
			c.add(new LinkedList<String>(Arrays.asList("P".split(""))));
		}

		for (int a = skip; a < _moves.size(); a++) {
			String[] m = _moves.get(a).split(" ");
			String[] tmp = new String[40];
			for (int i = 0; i < Integer.valueOf(m[1]); i++) {
				tmp[Integer.valueOf(m[1]) - i - 1] = c.get(Integer.valueOf(m[3]) - 1).pollFirst();
			}
			for (int i = 0; i < Integer.valueOf(m[1]); i++) {
				c.get(Integer.valueOf(m[5]) - 1).addFirst(tmp[i]);
			}
		}

		String m = "";
		for (int i = 0; i < (ext.equals("0") ? 9 : 3); i++) {
			m += c.get(i).peek();
		}
		System.out.println("Message: " + m);
	}
}