import java.io.*;
import java.nio.file.*;

public class FileUtility {

    // Read the contents of a file
    public static String readFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    // Write text to a file (overwrites if exists)
    public static String writeFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            return "File written successfully.";
        } catch (IOException e) {
            return "Error writing to file: " + e.getMessage();
        }
    }

    // Append text to a file
    public static String appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            return "Content appended successfully.";
        } catch (IOException e) {
            return "Error appending to file: " + e.getMessage();
        }
    }

    // Delete a file
    public static String deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
            return "File deleted successfully.";
        } catch (IOException e) {
            return "Error deleting file: " + e.getMessage();
        }
    }

    // Check if file exists
    public static boolean fileExists(String filePath) {
        return Files.exists(Paths.get(filePath));
    }

    // Create a new empty file
    public static String createFile(String filePath) {
        try {
            Files.createFile(Paths.get(filePath));
            return "File created successfully.";
        } catch (IOException e) {
            return "Error creating file: " + e.getMessage();
        }
    }

    // Copy a file
    public static String copyFile(String sourcePath, String destPath) {
        try {
            Files.copy(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            return "File copied successfully.";
        } catch (IOException e) {
            return "Error copying file: " + e.getMessage();
        }
    }

    // Move a file
    public static String moveFile(String sourcePath, String destPath) {
        try {
            Files.move(Paths.get(sourcePath), Paths.get(destPath), StandardCopyOption.REPLACE_EXISTING);
            return "File moved successfully.";
        } catch (IOException e) {
            return "Error moving file: " + e.getMessage();
        }
    }
}

