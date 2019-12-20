package ua.khpi.oop.mishchenko08;
import java.io.File;

public class Files {

		public static File[] getListOfFiles(String path) {
			File f = new File(path); 
			File[] list =  f.listFiles();
			return list;
			
		}
		
		
		public static void printListOfFiles(File[] list) {
			for (int i = 0; i < list.length; i++) { 
                System.out.println(i+1 + ") " +list[i].getName()); 
            } 
		}
		
		
		
		public static String chooseFile(File[] list) {
			 printListOfFiles(list);
			 System.out.println("Выберите подкаталог или файл:");
			 int index = Interface.inInt();
			 try {
				 return new String(list[index-1].getAbsolutePath());
			 }catch(ArrayIndexOutOfBoundsException e) {
				 System.out.println("Значение вне массива!");
				 return "C:\\Users\\dimek\\eclipse-workspace\\mishchenko-dmitry";
			 }
			
		}
		
		public static String createFile(String path) {
			String newPath = path + File.separator + Interface.inStr();
			return new File(newPath).getAbsolutePath();
			
		}
		
		public static String moveHigher(String path) {
			return new StringBuilder(path).delete(path.lastIndexOf(File.separator),path.length()).toString();
		}
		
}
