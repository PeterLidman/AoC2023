package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class L20a {

	public static void run(String ext) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("./src/AoC2022/L20input" + ext + ".txt")).stream()
				.collect(Collectors.toList());

	}

	public static int stringValue(String in) {
		int ut = 0, vp = 512;
		for (int i = 0; i < 10; i++) {
			if (in.charAt(i) == '#') {
				ut += vp;
			}
			vp /= 2;
		}
		return ut;
	}
}