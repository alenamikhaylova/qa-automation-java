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
    private Message[] messages;
    private Message message;
    private MessageService service;
    private Collection<Message> collectionMessages;

    @BeforeEach
    public void setUp() {
        Severity severity = REGULAR;
        HashMapMessageRepository hashRepository = new HashMapMessageRepository();
        message = new Message(severity, "Hi");
        messages = new Message[]{
                new Message(severity, "Hi")
        };
        service = new OrderedDistinctedMessageService(new TimestampMessageDecorator(), hashRepository);
        collectionMessages = service.findAll();
    }

    /**
     * Test
     */
    @Test
    @DisplayName("Save ordinary message")
    public void saveOrdinaryMessage() {
        service.log(message, messages);

        assertThat(collectionMessages).contains(message).contains(messages);
        assertThat(1).isEqualTo(collectionMessages.size());
    }

    @Test
    @DisplayName("Save decorated message")
    public void saveDecoratedMessage() {
        service.log(DESC, DISTINCT, message, messages);

        assertThat(1).isEqualTo(collectionMessages.size());
    }

    @Test
    @DisplayName("Exception if message is Null")
    public void showExceptionIfMessageNull() {
        service.log(ASC, DISTINCT, message, messages);

        assertThatExceptionOfType(NullPointerException.class).isThrownBy(
                () -> service.log(null));
    }

    @Test
    @DisplayName("Exception if order is Null")
    public void showExceptionIfMessageOrderNull() {
        Throwable exceptMessage = assertThrows(LogException.class,
                () -> service.log(null, DISTINCT, message));
        assertEquals("notValidArgMessage", exceptMessage.getMessage());
    }
}
