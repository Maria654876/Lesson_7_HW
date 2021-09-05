package writeFile;

import java.io.*;
import java.util.Scanner;


/**
 * * A program for reading information from an input file
 * * The program should check the document numbers for validity.
 * Valid document numbers should be recorded in a single report file.
 * Invalid document numbers should be written to another report file, but after the document numbers, you should add an information about why this document is invalid.
 */
public class FileTest {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            System.out.println("Enter the path to the file");
            Scanner console = new Scanner(System.in);
            String documentPath = console.nextLine();

            InputStream fileDoc = new FileInputStream(documentPath);
            FileReader fileReader = new FileReader(String.valueOf(fileDoc));
            BufferedReader reader = new BufferedReader(fileReader);

            InputStream fileValid = new FileInputStream("C:\\Users\\Мария\\Desktop\\TMS\\Lesson7\\src\\file\\fileValid");
            FileWriter fileWriterValid = new FileWriter(String.valueOf(fileValid));
            BufferedWriter writerValid = new BufferedWriter(fileWriterValid);

            InputStream fileNotValid = new FileInputStream("C:\\Users\\Мария\\Desktop\\TMS\\Lesson7\\src\\file\\fileNotValid");
            FileWriter fileWriterNotValid = new FileWriter(String.valueOf(fileValid));
            BufferedWriter writerNotValid = new BufferedWriter(fileWriterNotValid);

            String doc = null;
            while ((doc = reader.readLine()) != null) {
                if (doc.startsWith("docnum") || doc.startsWith("kontract") && doc.length() == 15) {
                    System.out.println("The string was added to fileVaid");
                    writerValid.write(doc);
                } else if (!doc.startsWith("docnum")){
                    System.out.println("The line was added to the fileNotValid because it does not start with the docnum");
                    writerNotValid.write(doc);
                }else if (!doc.startsWith("kontract")){
                    System.out.println("The line was added to the fileNotValid because it does not start with the kontract");
                    writerNotValid.write(doc);
                }else if (doc.length()!=15){
                    System.out.println("The line was added to the fileNotValid because line!=15");
                    writerNotValid.write(doc);
                }
            }
            writerNotValid.close();
            writerValid.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

