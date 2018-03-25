package EncodingPractice;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;

public class Encoding {

    private static String pathToPic = "src/EncodingPractice/pic.jpg";
    private static String pathToEnc = "src/EncodingPractice/enc";

    public static void encode() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(pathToPic));
        byte[] arr = new byte[50000];
        int l = inputStream.read(arr,0,50000);
        arr = Arrays.copyOfRange(arr,0, l);
        BASE64Encoder encoder = new BASE64Encoder();
        String st = encoder.encode(arr);

        FileOutputStream outputStream = new FileOutputStream(new File(pathToEnc));
        outputStream.write(st.getBytes(), 0, st.getBytes().length);
        inputStream.close();
        outputStream.close();
    }

    public static void decode() throws IOException {
        FileInputStream inputStream = new FileInputStream(new File(pathToEnc));
        FileOutputStream outputStream = new FileOutputStream(new File(pathToPic));

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] arr = decoder.decodeBuffer(inputStream);

        outputStream.write(arr, 0, arr.length);
        inputStream.close();
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        Encoding.decode();
    }

}
