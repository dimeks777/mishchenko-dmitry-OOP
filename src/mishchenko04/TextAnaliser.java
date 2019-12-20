package ua.khpi.oop.mishchenko004;
import java.util.Iterator;
import java.util.ListIterator;

public class TextAnaliser {
	private String txt;
	 LinkedList<String> list_of_sentences;
	 LinkedList<String> list_of_words;
	 LinkedList<String> list_min_length_words;
	 LinkedList<String> list_max_length_words;
	


	TextAnaliser(String text){
		this.txt = text;
	}
	
	
      void sentences_splitter() {
    	 
    	  list_of_sentences = new LinkedList<String>();
          int begin = 0;
    	  for(int i = 0; i < txt.length(); i++) {
    		  if(txt.charAt(i) == '.' || txt.charAt(i) == '?' || txt.charAt(i) == '!') {
    			if((txt.length() - i) > 2) {
    			  if(txt.substring(i,i+3).equals("...")) 
    			  {
    				  String temp = txt.substring(begin, i);
    				  temp = temp.trim();
    				  list_of_sentences.add(temp);
    				  begin = i+3;    
    				  i+=3;
    			  }
    			  else 
    			  {
    			  String temp = txt.substring(begin,i);	
    			  temp = temp.trim();
    			  list_of_sentences.add(temp);
    			  begin = i+1;
    		      }
    			}else {
    			  String temp = txt.substring(begin,i);
    			  temp = temp.trim();
    			  list_of_sentences.add(temp);
    			}
    			
    		  }
    	  }
      }
      
     void word_splitter(boolean debug) {
    	  list_of_words = new LinkedList<String>();
    	  ListIterator<String> it = list_of_sentences.listIterator();
    	  int[] words_in_sentence = new int[list_of_sentences.size()];
    	  int counter = 0;
    	  while(it.hasNext()) {
    		  
    			String value = it.next();
    			int begin = 0;
    			 for(int i = 0; i < value.length(); i++) {
    				 if(i > 0) {
    				 if((value.charAt(i) == ' ' || value.charAt(i) == ',' || value.charAt(i) == '-' || value.charAt(i) == ':') && (value.charAt(i-1) != ' ' && (value.charAt(i-1) != ',' && value.charAt(i-1) != '-' && value.charAt(i-1) != ':' ))) {
    					 String temp = value.substring(begin,i);
    					 temp = temp.trim();
    					 list_of_words.add(temp);
    					 begin = i+1;
    					 words_in_sentence[counter]++;
    				 }
    				 
    				 if(i == value.length()-1) {
    					 String temp = value.substring(begin,i+1);
    					 temp = temp.trim();
    					 list_of_words.add(temp);
    					 words_in_sentence[counter]++;
    					 break;
    				 }
    				 }
    				
    			 }
    			 counter++;
    	  
    	 
    	  	}
    	  if(debug) {
    		  System.out.println("-----------------------------Sentences splitted into words-----------------------------\n\n");
    		  IOClass.list_printer(list_of_words);
    		  System.out.println("---------------------------------------------------------------------------------------\n\n");
    		  System.out.println("Press Any Key To Continue...");
              new java.util.Scanner(System.in).nextLine();
              System.out.println("-----------------------------Count of words in sentence-----------------------------\n\n");
              for(int i = 0; i < list_of_sentences.size(); i++) {
            	  System.out.println((i+1) + ". " + words_in_sentence[i]);
            	  
              }
              System.out.println("------------------------------------------------------------------------------------\n\n");
              System.out.println("Press Any Key To Continue...");
              new java.util.Scanner(System.in).nextLine();
    	  }
    	  max_and_min_length_find(words_in_sentence,debug);
      	}
      
     void max_and_min_length_find(int[] arr,boolean debug) {
    	  int[] word_min_length_arr = new int[arr.length];
    	  int[] word_max_length_arr = new int[arr.length];
    	  ListIterator<String> it = list_of_words.listIterator();
    	 
    	  for(int i = 0; i < arr.length; i++) {
    		  int min_length_word = 0;
        	  int max_length_word = 0;
    		  for(int j = 0; j < arr[i]; j++) {
    			  String value = it.next();
    			  if(j==0) {
    				  max_length_word = value.length();
    				  min_length_word = value.length();
    			  }else {
    			  if(value.length() > max_length_word) {
    				  max_length_word = value.length();
    			  }else if(value.length() <  min_length_word) {
    				  min_length_word = value.length();
    			  }
    			  }
    		  }
    		  if(debug) {
    			  System.out.println("Min length of word in sentence " + (i+1) + " is " + min_length_word);
    			  System.out.println("Max length of word in sentence " + (i+1) + " is " + max_length_word + "\n\n");
    		  }
    		  word_min_length_arr[i] = min_length_word;
    		  word_max_length_arr[i] = max_length_word;
    	  }
    	  if(debug) {
    	  System.out.println("Press Any Key To Continue...");
          new java.util.Scanner(System.in).nextLine();
    	  }
    	  int[] min_count_arr = new int[arr.length];
    	  int[] max_count_arr = new int[arr.length];
    	  list_min_length_words = new LinkedList<String>();
    	  list_max_length_words = new LinkedList<String>();
    	  it = list_of_words.listIterator();
    	  for(int i = 0; i < arr.length; i++) {

    		  for(int j = 0; j < arr[i]; j++) {
    			  String value = it.next();
    			  if(value.length() == word_min_length_arr[i]) {
    				  min_count_arr[i]++;
    				  list_min_length_words.add(value);
    			  }else if(value.length() == word_max_length_arr[i]) {
    				  max_count_arr[i]++;
    				  list_max_length_words.add(value);
    			  }
    	  }
    	  }
    
    	  System.out.println("------------------------------------------");
    	  System.out.println("| Sentence |       Min length words      |");
    	  System.out.println("------------------------------------------");
              Iterator<String> iter = list_min_length_words.listIterator();
              for(int i = 0; i < arr.length; i++) {
            	  System.out.print("|    "+(i+1)+"     |   ");
            	  for(int j = 0; j <  min_count_arr[i]; j++) {
            		  System.out.print(iter.next()+" ");
            	  }
            	  System.out.println();
              }
              System.out.println("------------------------------------------");
              
           
              System.out.println("------------------------------------------");
        	  System.out.println("| Sentence |       Max length words      |");
        	  System.out.println("------------------------------------------");
                  iter = list_max_length_words.listIterator();
                  for(int i = 0; i < arr.length; i++) {
                	  System.out.print("|    "+(i+1)+"     |   ");
                	  for(int j = 0; j <  max_count_arr[i]; j++) {
                		  System.out.print(iter.next()+" ");
                	  }
                	  System.out.println();
                  }
                  System.out.println("------------------------------------------");
                 
              
           
    	  }
      }
      
      
	

	

