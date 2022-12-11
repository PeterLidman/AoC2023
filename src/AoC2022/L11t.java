package AoC2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L11t {
	public static void run(String ext) {
		ArrayList<Integer> m0 = new ArrayList<>(Arrays.asList(79, 98));
		ArrayList<Integer> m1 = new ArrayList<>(Arrays.asList(54, 65, 75, 74));
		ArrayList<Integer> m2 = new ArrayList<>(Arrays.asList(79, 60, 97));
		ArrayList<Integer> m3 = new ArrayList<>(Arrays.asList(74));
		int iv = 0;
		Integer[] ii = new Integer[4];

		for (int i = 0; i < ii.length; i++) {
			ii[i] = 0;
		}

		for (int i = 0; i < 20; i++) {
			while (m0.size() > 0) {
				iv = 19 * m0.remove(0);
				iv /= 3;
				ii[0]++;
				if (iv % 23 == 0) {
					m2.add(iv);
				} else {
					m3.add(iv);
				}
			}
			while (m1.size() > 0) {
				iv = 6 + m1.remove(0);
				iv /= 3;
				ii[1]++;
				if (iv % 19 == 0) {
					m2.add(iv);
				} else {
					m0.add(iv);
				}
			}
			while (m2.size() > 0) {
				iv = m2.remove(0);
				iv = iv * iv;
				iv /= 3;
				ii[2]++;
				if (iv % 13 == 0) {
					m1.add(iv);
				} else {
					m3.add(iv);
				}
			}
			while (m3.size() > 0) {
				iv = 3 + m3.remove(0);
				iv /= 3;
				ii[3]++;
				if (iv % 17 == 0) {
					m0.add(iv);
				} else {
					m1.add(iv);
				}
			}
		}
		Arrays.sort(ii, Collections.reverseOrder());
		System.out.println("Monkey Business: " + (ii[0] * ii[1]));
	}
}
