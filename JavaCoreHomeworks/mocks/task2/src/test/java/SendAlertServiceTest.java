import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import ru.netology.patient.service.alert.SendAlertService;

public class SendAlertServiceTest {
    @Test
    public void checkingTheSendMessageValue() {
        String testMessage = "Hello, teacher, thanks for checking my task :)";
        SendAlertService sendAlertService = Mockito.mock(SendAlertService.class);
        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
        sendAlertService.send(testMessage);
        Mockito.verify(sendAlertService).send(argumentCaptor.capture());
        Assertions.assertEquals(testMessage, argumentCaptor.getValue());
    }
}
