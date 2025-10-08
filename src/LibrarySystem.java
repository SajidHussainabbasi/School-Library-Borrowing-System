import java.time.LocalDate;
import java.util.*;

public class LibrarySystem {
    private static Map<Member, List<Loan>> borrowings = new HashMap<>();

    public static void main(String[] args) {
        // Create sample data
        Book b1 = new Book("Java Programming", "James Gosling");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Data Structures", "Mark Allen Weiss");

        Student s1 = new Student("Ali", "S001");
        Teacher t1 = new Teacher("Mr. Ahmed", "T001");

        borrowBook(b1, s1);
        borrowBook(b2, t1);
        borrowBook(b3, s1);

        System.out.println("\n📚 Current Borrowings:");
        showAllBorrowings();

        System.out.println("\n🔁 Returning a book...");
        returnBook(b3, s1);

        System.out.println("\n📚 Updated Borrowings:");
        showAllBorrowings();

        System.out.println("\n⏰ Overdue Books:");
        showOverdueBooks();
    }

    // Method to borrow a book
    public static void borrowBook(Book book, Member member) {
        if (!book.isAvailable()) {
            System.out.println(book.getTitle() + " is already borrowed!");
            return;
        }

        book.borrowBook();
        Loan loan = new Loan(book, member, LocalDate.now(), LocalDate.now().plusDays(7));

        borrowings.computeIfAbsent(member, k -> new ArrayList<>()).add(loan);
        System.out.println(member.getName() + " borrowed \"" + book.getTitle() + "\"");
    }

    // Method to return a book
    public static void returnBook(Book book, Member member) {
        List<Loan> memberLoans = borrowings.get(member);
        if (memberLoans == null) {
            System.out.println(member.getName() + " has no borrowed books.");
            return;
        }

        Loan found = null;
        for (Loan loan : memberLoans) {
            if (loan.getBook().equals(book)) {
                found = loan;
                break;
            }
        }

        if (found != null) {
            memberLoans.remove(found);
            book.returnBook();
            System.out.println(member.getName() + " returned \"" + book.getTitle() + "\"");
        } else {
            System.out.println(member.getName() + " did not borrow \"" + book.getTitle() + "\"");
        }
    }

    // Show all borrowings
    public static void showAllBorrowings() {
        if (borrowings.isEmpty()) {
            System.out.println("No current borrowings.");
            return;
        }

        for (Map.Entry<Member, List<Loan>> entry : borrowings.entrySet()) {
            System.out.println(entry.getKey().getName() + " borrowed:");
            for (Loan loan : entry.getValue()) {
                System.out.println("  - " + loan);
            }
        }
    }

    // Show overdue books
    public static void showOverdueBooks() {
        boolean anyOverdue = false;
        for (List<Loan> loans : borrowings.values()) {
            for (Loan loan : loans) {
                if (loan.isOverdue()) {
                    System.out.println("⚠️ " + loan);
                    anyOverdue = true;
                }
            }
        }
        if (!anyOverdue) {
            System.out.println("No overdue books found.");
        }
    }
}
