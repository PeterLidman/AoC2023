package AoC2022;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class L06b {

	private static String _in;

	public static void run(String ext) throws IOException {
		_in = Files.readString(Paths.get("./src/AoC2022/L06input" + ext + ".txt"));

		for (int i = 0; i < _in.length(); i++) {
			String a = _in.substring(i, i + 14);
			Boolean found = true;
			for (int j = 0; j < 14; j++) {
				if (a.substring(j + 1).contains(a.substring(j, j + 1))) {
					found = false;
					break;
				}
			}
			if (found) {
				System.out.println("Marker at: " + (i + 14));
				break;
			}
		}
	}
}
