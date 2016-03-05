package jp.mzw.vtr.example;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

public class FileUtilsTest {

	@Test
	public void testGrepText() {
		File file = new File("src/test/resources", "alice.txt");
		try {
			ArrayList<String> lines = FileUtils.grep(file, "it's no use going back to yesterday");
			assertTrue(lines.get(0).contains("because I was a different person then"));
		} catch (IOException e) {
			fail("File do not exist");
		}
	}

	@Test
	public void testNotFoundText() {
		File file = new File("src/test/resources", "alice.txt");
		try {
			ArrayList<String> lines = FileUtils.grep(file, "I was the same person");
			assertEquals(0, lines.size());
		} catch (IOException e) {
			fail("File do not exist");
		}
	}
	
	@Test
	public void testNonExistFile() {
		File file = new File("src/test/resources", "wonderland.txt");
		try {
			FileUtils.grep(file, "it's no use going back to yesterday");
			fail("Unexpectedly file exist");
		} catch (IOException e) {
			// expected
		}
	}
	
}
