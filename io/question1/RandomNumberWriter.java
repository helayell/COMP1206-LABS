import uk.ac.soton.ecs.comp1206.labtestlibrary.interfaces.io.RandomIO;

import java.io.*;
import java.util.Random;

public class RandomNumberWriter implements RandomIO {

  private Random randomGenerator;

  public RandomNumberWriter(long seed) {

    this.randomGenerator = new Random(seed);
  }

  @Override
  public void writeRandomChars(String s) throws IOException {

    File f = new File(s);

    try (Writer out = new FileWriter(f)) {

      for (int i = 0; i < 10000; i++) {

        int randomInt = randomGenerator.nextInt(100000);

        out.write(randomInt + "\n");
      }
    }
  }

  @Override
  public void writeRandomByte(String s) throws IOException {
    File f = new File(s);

    try (DataOutputStream out = new DataOutputStream(new FileOutputStream(f))) {
      for (int i = 0; i < 10000; i++) {
        int randomInt = randomGenerator.nextInt(100000);
        out.writeInt(randomInt);
      }
    }
  }
}
