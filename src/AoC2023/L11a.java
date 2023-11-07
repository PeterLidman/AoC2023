package AoC2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L11a {
	public static void run(String ext) {
		ArrayList<Integer> m0 = new ArrayList<>(Arrays.asList(93, 54, 69, 66, 71));
		ArrayList<Integer> m1 = new ArrayList<>(Arrays.asList(89, 51, 80, 66));
		ArrayList<Integer> m2 = new ArrayList<>(Arrays.asList(90, 92, 63, 91, 96, 63, 64));
		ArrayList<Integer> m3 = new ArrayList<>(Arrays.asList(65, 77));
		ArrayList<Integer> m4 = new ArrayList<>(Arrays.asList(76, 68, 94));
		ArrayList<Integer> m5 = new ArrayList<>(Arrays.asList(86, 65, 66, 97, 73, 83));
		ArrayList<Integer> m6 = new ArrayList<>(Arrays.asList(78));
		ArrayList<Integer> m7 = new ArrayList<>(Arrays.asList(89, 57, 59, 61, 87, 55, 55, 88));
		int iv = 0;
		Integer[] ii = new Integer[8];

		for (int i = 0; i < ii.length; i++) {
			ii[i] = 0;
		}

		for (int i = 0; i < 20; i++) {
			while (m0.size() > 0) {
				iv = 3 * m0.remove(0);
				iv /= 3;
				ii[0]++;
				if (iv % 7 == 0) {
					m7.add(iv);
				} else {
					m1.add(iv);
				}
			}
			while (m1.size() > 0) {
				iv = 17 * m1.remove(0);
				iv /= 3;
				ii[1]++;
				if (iv % 19 == 0) {
					m5.add(iv);
				} else {
					m7.add(iv);
				}
			}
			while (m2.size() > 0) {
				iv = 1 + m2.remove(0);
				iv /= 3;
				ii[2]++;
				if (iv % 13 == 0) {
					m4.add(iv);
				} else {
					m3.add(iv);
				}
			}
			while (m3.size() > 0) {
				iv = 2 + m3.remove(0);
				iv /= 3;
				ii[3]++;
				if (iv % 3 == 0) {
					m4.add(iv);
				} else {
					m6.add(iv);
				}
			}
			while (m4.size() > 0) {
				iv = m4.remove(0);
				iv = iv * iv;
				iv /= 3;
				ii[4]++;
				if (iv % 2 == 0) {
					m0.add(iv);
				} else {
					m6.add(iv);
				}
			}
			while (m5.size() > 0) {
				iv = 8 + m5.remove(0);
				iv /= 3;
				ii[5]++;
				if (iv % 11 == 0) {
					m2.add(iv);
				} else {
					m3.add(iv);
				}
			}
			while (m6.size() > 0) {
				iv = 6 + m6.remove(0);
				iv /= 3;
				ii[6]++;
				if (iv % 17 == 0) {
					m0.add(iv);
				} else {
					m1.add(iv);
				}
			}
			while (m7.size() > 0) {
				iv = 7 + m7.remove(0);
				iv /= 3;
				ii[7]++;
				if (iv % 5 == 0) {
					m2.add(iv);
				} else {
					m5.add(iv);
				}
			}
		}
		Arrays.sort(ii, Collections.reverseOrder());
		System.out.println("Monkey Business: " + (ii[0] * ii[1]));
	}
}
