package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L10b {
	private static List<String> code;

	public static void run(String ext) throws IOException {
		code = Files.readAllLines(Paths.get("./src/AoC2022/L10input" + ext + ".txt"));

		int x = 1;
		int c = 0;
		Map<Integer, Character> crt = new HashMap<>();
		for (String instr : code) {
			String[] i = instr.split(" ");
			switch (i[0]) {
			case "noop":
				if (c % 40 < x - 1 || c % 40 > x + 1) {
					crt.put(c, '.');
				} else {
					crt.put(c, '#');
				}
				c++;
				break;
			case "addx":
				if (c % 40 < x - 1 || c % 40 > x + 1) {
					crt.put(c, '.');
				} else {
					crt.put(c, '#');
				}
				c++;
				if (c % 40 < x - 1 || c % 40 > x + 1) {
					crt.put(c, '.');
				} else {
					crt.put(c, '#');
				}
				c++;
				x += Integer.valueOf(i[1]);
				break;
			}
		}
		for (int i = 0; i < 240; i++) {
			System.out.print(crt.get(i));
			if ((i + 1) % 40 == 0) {
				System.out.println();
			}
		}
	}
}
