import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import unit.hw4.given.Book;
import unit.hw4.given.BookRepository;
import unit.hw4.given.BookService;

import java.util.*;

public class ServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    Map<String, Book> books;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        books = new HashMap<>();
        books.put("1", new Book("1", "Book1", "Author1"));
        books.put("2", new Book("2", "Book2", "Author2"));
    }

    @Test
    void findById_test_correctInput() {
        // given
        Book expectedBook = books.get("1");
        Mockito.when(bookRepository.findById("1"))
                .thenReturn(expectedBook);

        // when
        Book actualBook = bookService.findBookById("1");

        // then
        Assertions.assertEquals(expectedBook, actualBook);
        Mockito.verify(bookRepository, Mockito.times(1)).findById("1");
    }

    @Test
    void findById_test_incorrectInput() {
        //given
        Mockito.when(bookRepository.findById("5"))
                .thenThrow(NoSuchElementException.class);

        //when
        //then
        Assertions.assertThrows(NoSuchElementException.class, () -> bookRepository.findById("5"));
    }

    @Test
    void findAll_test_correct() {
        //given
        List<Book> expectedList = new ArrayList<>(books.values());

        Mockito.when(bookRepository.findAll())
                .thenReturn(expectedList);

        //when
        List<Book> actualList = bookService.findAllBooks();

        //then
        Assertions.assertEquals(expectedList, actualList);
        Mockito.verify(bookRepository, Mockito.times(1)).findAll();
    }

    @Test
    void findAll_test_emptyBooks() {
        //given
        List<Book> expected = Collections.emptyList();

        Mockito.when(bookRepository.findAll())
                .thenReturn(expected);

        //when
        List<Book> actualList = bookService.findAllBooks();

        //then
        Assertions.assertTrue(actualList.isEmpty());
        Mockito.verify(bookRepository, Mockito.times(1)).findAll();
    }
}