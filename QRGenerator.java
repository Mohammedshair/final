import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class QRGenerator {

    public static void generateQR(String usn) {
        try {
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix matrix = writer.encode(usn, BarcodeFormat.QR_CODE, 300, 300);
            Path path = Paths.get("qrcodes/" + usn + ".png");
            Files.createDirectories(path.getParent());
            MatrixToImageWriter.writeToPath(matrix, "PNG", path);
            System.out.println("QR generated: " + usn);
        } catch (WriterException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> usnList = new ArrayList<>();

        while (true) {
            System.out.print("Enter USN (or type 'done'): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("DONE")) break;
            if (!input.isEmpty()) usnList.add(input);
        }

        for (String usn : usnList) {
            generateQR(usn);
        }

        System.out.println("QR Generation Completed!");
        scanner.close();
    }
}
