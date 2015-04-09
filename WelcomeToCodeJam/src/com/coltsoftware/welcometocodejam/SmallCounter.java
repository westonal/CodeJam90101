package com.coltsoftware.welcometocodejam;

public class SmallCounter {

	public static class VArray {

		private final char[] array;
		private int offset;

		private VArray(char[] array, int offset) {
			this.array = array;
			this.offset = offset;
		}

		public VArray(String string) {
			this(string.toCharArray(), 0);
		}

		public char get(int i) {
			return array[i + offset];
		}

		public char first() {
			return array[offset];
		}

		public int size() {
			return array.length - offset;
		}

		public void incOffset(int offset){
			this.offset+=offset;
		}
	}

	public static int countString(String searchFor, String inString) {
		VArray searchArray = new VArray(searchFor);
		VArray inArray = new VArray(inString);
		return count(searchArray, inArray);
	}

	private static int count(VArray searchArray, VArray inArray) {
		int found = 0;
		char first = searchArray.first();
		for (int i = 0; i < inArray.size(); i++) {
			if (first == inArray.get(i)) {
				// character hit
				if (searchArray.size() == 1) {
					// last character
					found++;
				} else {
					// search from here
					searchArray.incOffset(1);
					inArray.incOffset(i);
					found += count(searchArray, inArray);
					inArray.incOffset(-i);
					searchArray.incOffset(-1);
				}
			}
		}

		return found;
	}

}
