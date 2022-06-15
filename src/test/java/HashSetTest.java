import com.tcs.edu.LogException;
import com.tcs.edu.MessageService;
import com.tcs.edu.decorator.*;
import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.HashMapMessageRepository;
import org.junit.jupiter.api.*;

import java.util.Collection;

import static com.tcs.edu.decorator.Doubling.*;
import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.Severity.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

/**
 * TestCase
 */
public class HashSetTest {
    private static MessageService service;

    @BeforeAll
    static void setUp() {
        HashMapMessageRepository hashRepository = new HashMapMessageRepository();
        service = new OrderedDistinctedMessageService(new TimestampMessageDecorator(), hashRepository);
    }

    /**
     * Test
     */
    @Test
    @DisplayName("Save ordinary message")
    public void saveOrdinaryMessage() {
        Message message = new Message("Hi");
        Message[] messages = {
                new Message("Hi")
        };
        Collection<Message> collectionMessages = service.findAll();
        service.log(message, messages);
        assertThat(collectionMessages).contains(message).contains(messages);
        assertThat(2).isEqualTo(collectionMessages.size());
    }

    @Test
    @DisplayName("Save decorated message")
    public void saveDecoratedMessage() {
        Message message = new Message("Hi");
        Message[] messages = new Message[0];
        Collection<Message> collectionMessages = service.findAll();
        service.log(DESC, DISTINCT, message, messages);
        assertThat(1).isEqualTo(collectionMessages.size());
    }

    @Test
    @DisplayName("Exception if message is Null")
    public void showExceptionIfMessageNull() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                () -> service.log(null));
    }

    @Test
    @DisplayName("Exception if all messages are Null")
    public void showExceptionIfAllMessagesNull() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                () -> service.log(DESC, DISTINCT, null, null));
    }

    @Test
    @DisplayName("Exception if value of order is Null")
    public void showExceptionIfMessageOrderNull() {
        Message message = new Message("Hi");
        Throwable exceptMessage = assertThrows(LogException.class,
                () -> service.log(null, DISTINCT, message));
        assertEquals("notValidArgMessage", exceptMessage.getMessage());
    }

    @Test
    @DisplayName("Exception if value of doubling is Null")
    public void showExceptionIfDoublingNull() {
        Message message = new Message("Hi");
        Throwable exceptMessage = assertThrows(LogException.class,
                () -> service.log(ASC, (Doubling) null, message));
        assertEquals("notValidArgMessage", exceptMessage.getMessage());
    }
}
