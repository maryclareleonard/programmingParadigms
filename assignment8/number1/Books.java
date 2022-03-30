import java.util.*;
public class Books {
    LinkedList<String> bookList;
    double subtotal;

    public Books(LinkedList<String> bookList){
        this.bookList = bookList;
        subtotal = 0; 
    }

    public LinkedList<String> discountCalc (LinkedList<String> passedBookList) {
        int uniqueBookCount = 0;
        double price = 0;
        int removeIndex;
        LinkedList<String> bookListUpdated = passedBookList;
        //check for each book 
        if (this.bookList.contains("1st")) {
            uniqueBookCount++;
            removeIndex = bookList.indexOf("1st");
            bookListUpdated.remove("1st");
        }
        if (this.bookList.contains("2nd")) {
            uniqueBookCount++;
            removeIndex = bookList.indexOf("2nd");
            bookListUpdated.remove("2nd");
        }
        if (this.bookList.contains("3rd")) {
            uniqueBookCount++;
            removeIndex = bookList.indexOf("3rd");
            bookListUpdated.remove(removeIndex);
        }
        if (this.bookList.contains("4th")) {
            uniqueBookCount++;
            removeIndex = bookList.indexOf("4th");
            bookListUpdated.remove(removeIndex);
        }
        if (this.bookList.contains("5th")) {
            uniqueBookCount++;
            removeIndex = bookList.indexOf("5th");
            bookListUpdated.remove(removeIndex);
        }
        //calc discount
        if (uniqueBookCount == 5) { price = 8 * 5 * 0.75; }
        if (uniqueBookCount == 4) { price = 8 * 4 * 0.8; }
        if (uniqueBookCount == 3) { price = 8 * 3 * 0.9; }
        if (uniqueBookCount == 2) { price = 8 * 2 * 0.95; }
        if (uniqueBookCount == 1) { price = 8; }
        //add to subtotal
        this.subtotal += price;
        return bookListUpdated;
    }

    public double findSubtotal() {
        if (bookList.size() == 0) { return subtotal;}
        LinkedList<String> bookListUpdated = discountCalc(bookList);
        while (bookListUpdated.size() > 0 ){
            bookListUpdated = discountCalc(bookListUpdated);
        }
        return subtotal; //to indicate error
    }
}