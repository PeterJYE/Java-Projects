package Structures;

import java.util.Arrays;

public class HashTable {
	public int size;
	public String[] HashTable;
	public int o;

	public HashTable(int s) {
		size = s;
		HashTable = new String[s];
		o = 0;
	}

	public int hashFunction(String s) {
		int h = 0;
		for (int i = 0; i < s.length(); i++) {
			h *= 37;
			h += s.charAt(i);
		}
		if (h < 0) {
			return h * -1;
		}

		return h;
	}

	public void add(String str) {
		if ((double) o / HashTable.length >= 0.75) {
			expand();
		}
		int position = hashFunction(str);
		if (HashTable[position % size] == null) {
			HashTable[position % size] = str;
		} else {
			while (HashTable[position % size] != null) {
				position++;
			}
			HashTable[position % size] = str;
		}
		o++;
	}

	public void expand() {
		String[] newTable = new String[size + 1000];
		for (String str : HashTable) {
			if (str != null) {
				int position = hashFunction(str);
				if (newTable[position % size] == null) {
					newTable[position % size] = str;
				} 
				else {
					while (newTable[position % size] != null) {
						position++;
					}
					newTable[position % size] = str;
				}
			}
		}
		size = size + 1000;
		HashTable = newTable;
	}

	public boolean lookup(String str) {
		int position = hashFunction(str);
		if (HashTable[position % size]!= null && HashTable[position % size].equals(str)) {
			return true;
		}
		int init = position % size;
		position++;
		while (position % size != init) {
			if (HashTable[position % size]!= null && HashTable[position % size].equals(str)) {
				return true;
			}
			position++;
		}
		return false;

	}

	public void remove(String str) {
		if (lookup(str) == false) {
			return;
		}
		int position = hashFunction(str);
		if (HashTable[position % size] == str) {
			HashTable[position] = null;
		}
		while (HashTable[position % size] == str) {
			position++;
			if (HashTable[position % size] == str) {
				HashTable[position] = null;
			}
		}

	}
}
