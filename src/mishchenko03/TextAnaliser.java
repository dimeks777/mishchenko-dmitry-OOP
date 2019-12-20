package ua.khpi.oop.mishchenko03;
import java.util.Iterator;
import java.util.LinkedList;

public class TextAnaliser {
	
      static LinkedList<String> sentences_splitter(String text) {
          LinkedList<String> c = new LinkedList<String>();
          int begin = 0;
    	  for(int i = 0; i < text.length(); i++) {
    		  if(text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') {
    			if((text.length() - i) > 2) {
    			  if(text.substring(i,i+3).equals("...")) 
    			  {
    				  String temp = text.substring(begin, i);
    				  temp = temp.trim();
    				  c.add(temp);
    				  begin = i+3;    
    				  i+=3;
    			  }
    			  else 
    			  {
    			  String temp = text.substring(begin,i);	
    			  temp = temp.trim();
    			  c.add(temp);
    			  begin = i+1;
    		      }
    			}else {
    			  String temp = text.substring(begin,i);
    			  temp = temp.trim();
       			  c.add(temp);
    			}
    			
    		  }
    	  }
    	  return c;	 
      }
      
      static LinkedList<String> word_splitter(LinkedList<String> text) {
    	  LinkedList<String> words = new LinkedList<String>();
    	  Iterator<String> it = text.iterator();
    	  int[] words_in_sentence = new int[text.size()];
    	  int counter = 0;
    	  while(it.hasNext()) {
    		  
    			String value = it.next();
    			int begin = 0;
    			 for(int i = 0; i < value.length(); i++) {
    				 if(i > 0) {
    				 if((value.charAt(i) == ' ' || value.charAt(i) == ',' || value.charAt(i) == '-' || value.charAt(i) == ':') && (value.charAt(i-1) != ' ' && (value.charAt(i-1) != ',' && value.charAt(i-1) != '-' && value.charAt(i-1) != ':' ))) {
    					 String temp = value.substring(begin,i);
    					 temp = temp.trim();
    					 words.add(temp);
    					 begin = i+1;
    					 words_in_sentence[counter]++;
    				 }
    				 
    				 if(i == value.length()-1) {
    					 String temp = value.substring(begin,i+1);
    					 temp = temp.trim();
    					 words.add(temp);
    					 words_in_sentence[counter]++;
    					 break;
    				 }
    				 }
    				
    			 }
    			 counter++;
    	  
    	 
    	  	}
    	  max_and_min_length_find(words_in_sentence, words);
    	  return words;
      	}
      
      static void max_and_min_length_find(int[] arr, LinkedList<String> words) {
    	  int[] word_min_length_arr = new int[arr.length];
    	  int[] word_max_length_arr = new int[arr.length];
    	  Iterator<String> it = words.iterator();
    	 
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
    		  word_min_length_arr[i] = min_length_word;
    		  word_max_length_arr[i] = max_length_word;
    	  }
    	 
    	  int[] min_count_arr = new int[arr.length];
    	  int[] max_count_arr = new int[arr.length];
		  LinkedList<String> min_length_words = new LinkedList<String>();
		  LinkedList<String> max_length_words = new LinkedList<String>();
    	  it = words.iterator();
    	  for(int i = 0; i < arr.length; i++) {

    		  for(int j = 0; j < arr[i]; j++) {
    			  String value = it.next();
    			  if(value.length() == word_min_length_arr[i]) {
    				  min_count_arr[i]++;
    				  min_length_words.add(value);
    			  }else if(value.length() == word_max_length_arr[i]) {
    				  max_count_arr[i]++;
    				  max_length_words.add(value);
    			  }
    	  }
    	  }
    
    	  System.out.println("------------------------------------------");
    	  System.out.println("| Sentence |       Min length words      |");
    	  System.out.println("------------------------------------------");
              Iterator<String> iter = min_length_words.iterator();
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
                  iter = max_length_words.iterator();
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
      
      
	

	

