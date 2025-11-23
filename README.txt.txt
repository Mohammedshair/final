How to Generate QR Codes (Person 1 – QR Generator)

1. Install Java 8/11 or higher.
2. Download ZXing jars:
   - core-3.5.3.jar
   - javase-3.5.3.jar
3. Create folder structure:
   /QR-GENERATOR
      /libs
      QRGenerator.java

4. Place both jar files inside /libs folder.

5. Compile the program:
   javac -cp ".;libs/*" QRGenerator.java

6. Run the program:
   java -cp ".;libs/*" QRGenerator

7. Output:
   QR images will be stored in /qrcodes/ folder.