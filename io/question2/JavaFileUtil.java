import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.ConcatenateJavaFiles;

import java.io.*;

public class JavaFileUtil implements ConcatenateJavaFiles {
  @Override
  public void concatenateJavaFiles(String dirName, String fileName) throws IOException {
    File directory = new File(dirName);
    if (!directory.isDirectory()) {
      throw new IllegalArgumentException("The provided path is not a directory: " + dirName);
    }

    File outputFile = new File(directory, fileName);
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
      File[] files =
          directory.listFiles(
                  (dir, name) -> name.endsWith(".java"));

      if (files != null) {
        for (File file : files) {
          try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
              writer.write(line);
              writer.newLine();
            }
          }
        }
      }
    }
  }
}
