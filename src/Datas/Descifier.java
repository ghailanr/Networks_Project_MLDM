package Datas;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;


//Generates .desc files (text files).
//In a real case, can be stored on a webserver named share-all-the-book.me

public class Descifier {

    private final String bookName;
    private final int bookSize;
    private final int pageSize;
    private final String address;
    private final Book book;


    public Descifier(String address, String bookName, int bookSize, int pageSize){
        this.address = address;
        this.bookName = bookName;
        this.bookSize = bookSize;
        this.pageSize = pageSize;
        this.book = getBook(bookName);
        ArrayList<String> pagesSHA1 = new ArrayList<>();
        for (int i = 0; i < bookSize/pageSize + 1; i++){
            //pagesSHA1.add(bytesToSHA1(this.book.getPage(i))); TODO make it so a Page is a byte[] object
        }
    }

    // inspired by: http://www.mkyong.com/java/how-to-generate-a-file-checksum-value-in-java/
    public static String bytesToSHA1(byte[] bytes) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            byte[] digestedBytes = messageDigest.digest(bytes);

            // convert the digestedBytes to hexadecimal format to reduce the size of the ouput
            StringBuilder result = new StringBuilder();
            for (byte digestedByte : digestedBytes) {
                result.append(Integer.toString((digestedByte & 0xff) + 0x100, 16).substring(1));
            }
            return result.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Book getBook(String bookName){
        //TODO get book using FileInputStream / FileOutputStream
        return book;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getBookSize() {
        return bookSize;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAddress() {
        return address;
    }


}
