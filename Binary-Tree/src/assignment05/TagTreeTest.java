/**
 * Author: Ryan Lukas
 * Date: Firday, October 27, 2017
 */
package assignment05;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class TagTreeTest {

	@Test
	public void getHeightfirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getHeight();
		assertEquals(x, 5);
	}
	
	@Test
	public void getHeightSecondTag() throws FileNotFoundException {
		File file = new File("tags2.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getHeight();
		assertEquals(x, 5);
	}
	
	@Test
	public void getHeightFourthTag() throws FileNotFoundException {
		File file = new File("tags4.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getHeight();
		assertEquals(x, 4);
	}
	
	@Test
	public void getHeightFifthTag() throws FileNotFoundException {
		File file = new File("tags5.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getHeight();
		assertEquals(x, 3);
	}
	
	@Test
	public void getHeightSixthTag() throws FileNotFoundException {
		File file = new File("tags6.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getHeight();
		assertEquals(x, 2);
	}
	
	@Test
	public void getMaxDegreeFirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getMaxDegree();
		assertEquals(x, 2);
	}
	
	@Test
	public void getMaxDegreeTag08() throws FileNotFoundException {
		File file = new File("tags8.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getMaxDegree();
		assertEquals(x, 1);
	}
	
	@Test
	public void getMaxDegreeTag09() throws FileNotFoundException {
		File file = new File("tags9.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.getMaxDegree();
		assertEquals(x, 4);
	}
	
	@Test
	public void prefixfirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		String x = m.outputPrefix();
		assertEquals(x, "E N A L K J H I F G O B C D M ");
	}
	
	@Test
	public void postfixfirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		String x = m.outputPostfix();
		assertEquals(x, "K L A H I J N B O D M C G F E ");
	}
	
	@Test
	public void isBinaryTreeFirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isBinaryTree();
		assertEquals(x, true);
	}
	
	@Test
	public void isBinaryTreeSecondTag() throws FileNotFoundException {
		File file = new File("tags2.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isBinaryTree();
		assertEquals(x, true);
	}
	
	@Test
	public void isBinaryTreeThirdTag() throws FileNotFoundException {
		File file = new File("tags3.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isBinaryTree();
		assertEquals(x, false);
	}
	
	@Test
	public void isTwoTreeFirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isTwoTree();
		assertEquals(x, false);
	}
	
	@Test
	public void isTwoTreeFourthTag() throws FileNotFoundException {
		File file = new File("tags4.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isTwoTree();
		assertEquals(x, false);
	}
	
	@Test
	public void isFullBinaryTreeFirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isTwoTree();
		assertEquals(x, false);
	}
	
	@Test
	public void isFullBinaryTreeSixTag() throws FileNotFoundException {
		File file = new File("tags6.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		boolean x = m.isTwoTree();
		assertEquals(x, true);
	}
	
	@Test
	public void DepthfirstTag() throws FileNotFoundException {
		File file = new File("tags.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.findDepth("K");
		assertEquals(x, 4);
	}
	
	@Test
	public void DepthsecondTag() throws FileNotFoundException {
		File file = new File("tags2.txt");
		Scanner in = new Scanner(file);
		TagTree m = new TagTree(in);
		in.close();
		
		int x = m.findDepth("H");
		assertEquals(x, 3);
	}
	
	
	

}
