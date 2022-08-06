import java.io.*;
import java.util.*;

//The Virtual Key for Your Repositories
public class VirtualKey {
	public static final String path = "C:\\Users\\Admin\\eclipse-workspace\\Phase1Final\\New Folder";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n                                                          \n\t\t\tWelcome");
		System.out.println("\t\t\t" + "  To");
		System.out.println("\tThe Virtual Key for Your Repositories");
		System.out.println("                 Developed By Rajnish");

		System.out.println("                                                              ");
		File file = new File("New Folder");

		// If file doesn't exist, create the New Folder.
		if (!file.exists()) {
			file.mkdirs();
		}
		mainMenu();

	}

	// Main Menu Method
	private static void mainMenu() {
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		do {
			System.out.println("         Choose what you want to do");
			System.out.println(" 1.Retrive Current File Name from \"New Folder\" In Ascending Order.");
			System.out.println(" 2.Business Level Operation Menu.");
			System.out.println(" 0.Exit From The Application.");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sortCurrentFiles();
				break;
			case 2:
				bLOMenu();
				break;
			}
		} while (choice != 0);
	}

	// Sorting the Current File/Folder
	private static void sortCurrentFiles() {
		String path = "New Folder";
		File file = new File(path);
		if (file.isDirectory()) {
			List listFile = Arrays.asList(file.list());

			Collections.sort(listFile);
			System.out.println("Current File Name In Ascending Order of \"New Folder\" .");
			System.out.println("------------******-------------\n");
			for (Object o : listFile) {
				String s = o.toString();
				System.out.println(s);
			}
		}

		System.out.println("------------******-------------\n");

	}

	// BLO Menu Method
	private static void bLOMenu() {
		int choice = -1;
		do {
			System.out.println("*********Business Level Operation Menu*************");
			System.out.println(" 1.Add File and its Content in the \"New Folder\".");
			System.out.println(" 2.Delete a file from \"New Folder\".");
			System.out.println(" 3.Searching a file and showing its Contets in \"New Folder\".");
			System.out.println(" 0.Exit From Business Level Operation Menu.");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				createFile();
				break;
			case 2:
				deleteFile();
				bLOMenu();
				break;
			case 3:
				try {
					searchFileAndContent();
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Error! .. File not found. Enter the Corect File name with path");
					bLOMenu();
				}
				break;
			}
		} while (choice != 0);

	}

	// Add the file
	private static void createFile() {

		try {
			Scanner sc = new Scanner(System.in); // object of Scanner class
			System.out.println("Enter the file name with location path: ");// E.g -> \Test.txt "or" \Folder1\Test.txt
			String fileName = sc.nextLine();
			String filename1 = path.concat(fileName);
			FileOutputStream fos = new FileOutputStream(filename1, true); // true for append mode
//			System.out.println("Would you like to add some content to created new file : (Y/N)");
//			String choice = sc.next().toLowerCase();
//			if(choice.equals("y")){
			System.out.println("Write the content and Press Enter to save : ");
			String content = sc.nextLine();
			byte b[] = content.getBytes();
			fos.write(b);
			fos.close();
			// }
			System.out.println("File is saved on the given location path");

		} catch (Exception e) {
			System.out.println("Some exception is coming....");
			bLOMenu();
		}
	}

	// Search the file
	private static void searchFileAndContent() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the file name which you want to search and show its contents :");
		// its case sensitive please enter as \Folder name \ file name with type
		String Str = sc.nextLine();
		String str1 = path.concat(Str);
		FileReader reader = new FileReader(str1);
		int data;
		System.out.println("Your file " + Str + " is found and Its contents are :---");
		while ((data = reader.read()) != -1) {
			System.out.print((char) data);
		}
		System.out.println();

	}

	// Delete the File
	private static void deleteFile() {
		String st;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the Name of File to Delete : ");// E.g -> \FolderName\File name with type.
		st = sc.nextLine();
		String str = path.concat(st);
		File myfile = new File(str);
		if (myfile.delete())
			System.out.println("\nThe file " + st + " is deleted successfully");
		else
			System.out.println("\nSomething went wrong, Enter file name correctly");

	}

}
