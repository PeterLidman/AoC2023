package AoC2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class L11b {
	public static void run(String ext) {
		ArrayList<Long> m0 = new ArrayList<>(Arrays.asList(93l, 54l, 69l, 66l, 71l));
		ArrayList<Long> m1 = new ArrayList<>(Arrays.asList(89l, 51l, 80l, 66l));
		ArrayList<Long> m2 = new ArrayList<>(Arrays.asList(90l, 92l, 63l, 91l, 96l, 63l, 64l));
		ArrayList<Long> m3 = new ArrayList<>(Arrays.asList(65l, 77l));
		ArrayList<Long> m4 = new ArrayList<>(Arrays.asList(76l, 68l, 94l));
		ArrayList<Long> m5 = new ArrayList<>(Arrays.asList(86l, 65l, 66l, 97l, 73l, 83l));
		ArrayList<Long> m6 = new ArrayList<>(Arrays.asList(78l));
		ArrayList<Long> m7 = new ArrayList<>(Arrays.asList(89l, 57l, 59l, 61l, 87l, 55l, 55l, 88l));
		long iv = 0l;
		Long[] ii = new Long[8];
		long ridiculous = 7l * 19l * 13l * 3l * 2l * 11l * 17l * 5l;
		// to low 161055081
		// to low 161297588
		// to low 16182703813

		for (int i = 0; i < ii.length; i++) {
			ii[i] = 0l;
		}

		for (int i = 0; i < 10_000; i++) {
			while (m0.size() > 0) {
				iv = 3 * m0.remove(0);
				iv %= ridiculous;
				ii[0]++;
				if (iv % 7 == 0) {
					m7.add(iv);
				} else {
					m1.add(iv);
				}
			}
			while (m1.size() > 0) {
				iv = 17 * m1.remove(0);
				iv %= ridiculous;
				ii[1]++;
				if (iv % 19 == 0) {
					m5.add(iv);
				} else {
					m7.add(iv);
				}
			}
			while (m2.size() > 0) {
				iv = 1 + m2.remove(0);
				iv %= ridiculous;
				ii[2]++;
				if (iv % 13 == 0) {
					m4.add(iv);
				} else {
					m3.add(iv);
				}
			}
			while (m3.size() > 0) {
				iv = 2 + m3.remove(0);
				iv %= ridiculous;
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
				iv %= ridiculous;
				ii[4]++;
				if (iv % 2 == 0) {
					m0.add(iv);
				} else {
					m6.add(iv);
				}
			}
			while (m5.size() > 0) {
				iv = 8 + m5.remove(0);
				iv %= ridiculous;
				ii[5]++;
				if (iv % 11 == 0) {
					m2.add(iv);
				} else {
					m3.add(iv);
				}
			}
			while (m6.size() > 0) {
				iv = 6 + m6.remove(0);
				iv %= ridiculous;
				ii[6]++;
				if (iv % 17 == 0) {
					m0.add(iv);
				} else {
					m1.add(iv);
				}
			}
			while (m7.size() > 0) {
				iv = 7 + m7.remove(0);
				iv %= ridiculous;
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
