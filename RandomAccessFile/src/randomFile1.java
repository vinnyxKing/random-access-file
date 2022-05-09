import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randomFile1 {
    public static void main(String[] args) throws IOException {
        File newFile = new File("d:\\rand.dat");
        RandomAccessFile myfile = new RandomAccessFile(newFile, "rw");


        myfile.writeInt(120);
        myfile.writeDouble(375.50);
        myfile.writeInt('A' + 1);
        myfile.writeBoolean(true);
        myfile.writeChar('X');

        //set pointer to the beginning of the file and read m=next two items

        myfile.seek(0);
        System.out.println(myfile.readInt());
        System.out.println(myfile.readDouble());

        //set pointer to the 4th item and read
        myfile.seek(16);
        System.out.println(myfile.readBoolean());

         // set pointer to offset 17 and append a double 3.14
        myfile.seek(17);
        char c = myfile.readChar();
        myfile.seek(17);
        myfile.writeDouble(3.14);
        myfile.writeChar(c);

        // go to end and append an int 2020
        myfile.seek(myfile.length());
        myfile.writeInt(2020);

        myfile.seek(17);
        System.out.println(myfile.readDouble());
        System.out.println(myfile.readChar());
        System.out.println(myfile.readInt());
        System.out.println("File length: " + myfile.length());
        myfile.close();

    }
}
