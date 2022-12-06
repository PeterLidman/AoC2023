package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class L06a {
	private static String _in;

	public static void run(String ext) throws IOException {
		_in = Files.readString(Paths.get("./src/AoC2022/L06input" + ext + ".txt"));

		Character a, b, c, d;

		for (int i = 0; i < _in.length(); i++) {
			a = _in.charAt(i);
			b = _in.charAt(i + 1);
			c = _in.charAt(i + 2);
			d = _in.charAt(i + 3);

			if (!(a == b || a == c || a == d || b == c || b == d || c == d)) {
				System.out.println("Marker at: " + (i+4));
				break;
			}
		}
	}
}
