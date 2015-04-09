package com.coltsoftware.welcometocodejam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("user.dir"));

		List<String> readAllLines = Files.readAllLines(new File(
				"C-large-practice.in").toPath(), StandardCharsets.UTF_8);

		int size = Integer.parseInt(readAllLines.get(0));

		System.out.println(size);

		List<String> results = new ArrayList<String>();

		Counter shared = new Counter();
		for (int i = 1; i <= size; i++) {
			String result = String.format(
					"Case #%d: %04d",
					i,
					shared.countString("welcome to code jam",
							readAllLines.get(i)));
			results.add(result);
			System.out.println(result);
		}

		OutputStream s = new FileOutputStream(new File(new File(
				System.getProperty("user.dir")), "C-large-practice.out"));
		OutputStreamWriter writer = new OutputStreamWriter(s);
		for (String result : results)
			writer.write(result + "\n");
		writer.flush();
		s.close();

		System.out.println(System.getProperty("user.dir"));
	}

}
