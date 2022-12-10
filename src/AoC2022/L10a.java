package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L10a {
	private static List<String> code;

	public static void run(String ext) throws IOException {
		code = Files.readAllLines(Paths.get("./src/AoC2022/L10input" + ext + ".txt"));

		int s = 0;
		int x = 1;
		int c = 1;
		for (String instr : code) {
			String[] i = instr.split(" ");
			switch (i[0]) {
			case "noop":
				if (c == 20 || c == 60 || c == 100 || c == 140 || c == 180 || c == 220) {
					s += c * x;
				}
				c++;
				break;
			case "addx":
				if (c == 20 || c == 60 || c == 100 || c == 140 || c == 180 || c == 220) {
					s += c * x;
				}
				c++;
				if (c == 20 || c == 60 || c == 100 || c == 140 || c == 180 || c == 220) {
					s += c * x;
				}
				c++;
				x += Integer.valueOf(i[1]);
				break;
			}
		}
		System.out.println("Sum signal strength: " + s);
	}
}
