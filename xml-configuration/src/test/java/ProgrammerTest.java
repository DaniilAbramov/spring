import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.itsjava.Computer;
import ru.itsjava.Programmer;

@DisplayName("Class Programmer должен:")
public class ProgrammerTest {

    @DisplayName("Должен корректно создавать объект")
    @Test
    public void shouldCorrectWorkingMethodHelloWorld(){
        Computer computer = Mockito.mock(Computer.class);
        
        Programmer programmer = new Programmer(computer);


    }
}
