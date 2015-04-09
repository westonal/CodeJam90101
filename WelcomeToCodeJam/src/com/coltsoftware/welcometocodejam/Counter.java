package com.coltsoftware.welcometocodejam;

import java.util.HashMap;

public class Counter {

	public static class VArray {

		private final char[] array;

		private VArray(char[] array, int offset) {
			this.array = array;
		}

		public VArray(String string) {
			this(string.toCharArray(), 0);
		}

		public char get(int i) {
			return array[i];
		}

		public char first() {
			return array[0];
		}

		public int size() {
			return array.length;
		}

		public String toString(int offset) {
			return new String(array, offset, array.length - offset);
		}
	}

	private final HashMap<String, Integer> cache = new HashMap<String, Integer>();

	public int countString(String searchFor, String inString) {
		// check cache
		String key = searchFor + '|' + inString;
		Integer value = cache.get(key);
		if (value != null)
			return value;

		VArray searchArray = new VArray(searchFor);
		VArray inArray = new VArray(inString);
		int count = count(searchArray, inArray) % 10000;
		cache.put(key, count);
		return count;
	}

	private int count(VArray searchArray, VArray inArray) {
		int found = 0;
		char first = searchArray.first();
		for (int i = 0; i < inArray.size(); i++) {
			if (first != inArray.get(i))
				continue;
			if (searchArray.size() == 1) {
				found++;
			} else {
				found += countString(searchArray.toString(1),
						inArray.toString(i));
			}
		}
		return found;
	}

}
