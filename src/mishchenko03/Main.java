package ua.khpi.oop.mishchenko03;

import java.util.LinkedList;

public class Main {
public static void main(String[] args) {
	//String text = IOClass.str_input();
	
	
	String text = "Every story has a beginning and an end. "
			+ "Each story has its own outline, synopsis, content, key points, prologues and epilogues. "
			+ "And there is no such book in which with each new reading things, that had not been paid attention to before,"
			+ "would not be revealed. "
			+ "Every story has a beginning and an end. "
			+ "Almost every ...";
			
  LinkedList<String> text_splitted_in_sentences = TextAnaliser.sentences_splitter(text);
  TextAnaliser.word_splitter(text_splitted_in_sentences);
  
  StringBuilder str = new StringBuilder("StringBuilder is being used");
  str.delete(str.indexOf("is"),str.indexOf("is")+3);
  str.insert(str.indexOf(" "), " is not");
  System.out.println(str);
}
}
