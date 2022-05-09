import java.io.EOFException;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class randomAccessFile2 {
    public static void main(String[] args) throws IOException {
        File students = new File("d:\\students.txt");
        RandomAccessFile std_file = null;

        //display the info of kim blue

        try {
            std_file = new RandomAccessFile(students, "rw");
            boolean found = false;

            byte[] id = new byte[4];
            byte[] rec = new byte[55];
            String idno = null;
            String std_rec = null;

            while (std_file.getFilePointer()<=std_file.length()-2){
                std_file.read(id,0,4);
                idno = new String(id);

                if (idno.equals("6235")){
                    std_file.seek(std_file.getFilePointer()-4);
                    std_file.read(rec,0,5);
                    std_rec = new String(rec);
                    found = true;
                }
                if (found)
                    break;

                std_file.seek(std_file.getFilePointer()+51);
            }
            System.out.println(std_rec);
        } catch (EOFException | FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            std_file.close();
        }
    }
}
