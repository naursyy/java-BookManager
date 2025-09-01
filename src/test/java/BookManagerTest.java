import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setup() {
        bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book buku = new Book("Pemrograman", "Andi", 2020);
        bookManager.addBook(buku);
        assertEquals(1, bookManager.getBookCount());
        assertTrue(bookManager.containsBook("Pemrograman"));
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book buku = new Book("Basis Data", "ErLangga", 2021);
        bookManager.addBook(buku);

        boolean removed = bookManager.removeBook("Basis Data");
        assertTrue(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Lengkapi Unit Test dibawah untuk buku yang memang tidak terdapat pada list
    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        boolean removed = bookManager.removeBook("Struktur Data");
        assertFalse(removed);
        assertEquals(0, bookManager.getBookCount());
    }

    // Lengkapi Unit Test dibawah untuk mencari buku berdasarkan penulis
    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBooksByAuthor() {
        bookManager.addBook(new Book("Java OOP", "Eka", 2019));
        bookManager.addBook(new Book("Python OOP", "Eka", 2020));
        bookManager.addBook(new Book("Jaringan Komputer", "Fajar", 2021));

        List<Book> hasil = bookManager.findBooksByAuthor("Eka");
        assertNotNull(hasil);
        assertEquals(2, hasil.size());
        assertTrue(hasil.stream().allMatch(b -> b.getPenulis().equals("Eka")));
    }

    // Lengkapi Unit Test dibawah untuk seluruh buku yang ada di dalam list
    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        bookManager.addBook(new Book("Kalkulus", "Dian", 2018));
        bookManager.addBook(new Book("Statistika", "Dian", 2019));
        bookManager.addBook(new Book("Machine Learning", "Rudi", 2022));

        List<Book> semua = bookManager.getAllBooks();
        assertEquals(3, semua.size());
        assertTrue(semua.stream().anyMatch(b -> b.getJudul_Buku().equals("Kalkulus")));
    }

    @Test
    @DisplayName("Test menghapus semua buku")
    void testClearAllBooks() {
        bookManager.addBook(new Book("AI", "Rina", 2022));
        bookManager.addBook(new Book("ML", "Rina", 2023));

        assertEquals(2, bookManager.getBookCount());

        bookManager.clearAllBooks();

        assertEquals(0, bookManager.getBookCount());
        assertTrue(bookManager.getAllBooks().isEmpty());
    }

    @Test
    @DisplayName("Test membuat buku dengan data invalid")
    void testInvalidBook() {

        Book invalidBook = new Book("Sejarah", "Anonim", 1990);

        assertNotNull(invalidBook);
    }


    @Test
    @DisplayName("Test memeriksa keberadaan buku")
    void testContainsBook() {
        Book b1 = new Book("Spring Framework", "Dewi", 2021);
        bookManager.addBook(b1);

        assertTrue(bookManager.containsBook("Django Framework"));
    }

    @Test
    @DisplayName("Test mencari buku berdasarkan tahun")
    void testFindBooksByYear() {
        Book b1 = new Book("Java OOP", "Alice", 2020);
        Book b2 = new Book("Python OOP", "Bob", 2021);
        Book b3 = new Book("NodeJS", "Charlie", 2022);

        bookManager.addBook(b1);
        bookManager.addBook(b2);
        bookManager.addBook(b3);

        var hasil = bookManager.findBooksByYear(2020);

        assertEquals(2, hasil.size());
    }
}
