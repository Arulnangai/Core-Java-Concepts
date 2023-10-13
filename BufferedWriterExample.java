import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterExample {
    public static void main(String[] args) {
        try {
            // Create a BufferedWriter wrapped around a FileWriter
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

            // Write text to the BufferedWriter
            bufferedWriter.write("Hello, World!");
            bufferedWriter.newLine();  // Write a newline character
            bufferedWriter.write("This is a new line of text.");

            // Flush and close the BufferedWriter
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
