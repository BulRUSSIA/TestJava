package com.company.Service;

import com.company.FileSettings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//Сканирует все директории и записывает их в массив
public class AllScanner {

	private void listAll(String path, ArrayList<String> res)
			throws IOException {
		File dir = new File(path);
		File[] list = dir.listFiles();

		if (list != null) {

			for (File f : list) {
				if (f.isDirectory()) {
					res.add(f.getCanonicalPath());
					listAll(f.getCanonicalPath(), res);

				}
			}
		}
	}

	public void run() {
		final DirectoryScanner scanner = new DirectoryScanner();
		final String path = FileSettings.GetPath();
		ArrayList<String> res;
		res = new ArrayList<>();
		res.add(path);

		try {
			listAll(path, res);
		} catch (IOException e) {
			e.printStackTrace();
		}

		 System.out.println(res);

		for (String s : res) {
			scanner.scan(s);
			System.out.println(s);
		}
	}
}