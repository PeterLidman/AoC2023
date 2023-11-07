package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class L16b {
	private static List<String> in;

	public static void run(String ext) throws IOException {
		in = Files.readAllLines(Paths.get("./src/AoC2022/L16input" + ext + ".txt"));
		System.out.println("Sum version numbers: ");
	}
}