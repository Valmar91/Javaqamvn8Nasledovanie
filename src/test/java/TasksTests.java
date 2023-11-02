import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTests {

    @Test
    public void TestMatchesSimpleTaskTrue() {
        SimpleTask simpleTask = new SimpleTask(5, "query");

        boolean expected = true;
        boolean actual = simpleTask.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesSimpleTaskTrue2() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить query");

        boolean expected = true;
        boolean actual = simpleTask.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesSimpleTaskFalse() {
        SimpleTask simpleTask = new SimpleTask(5, "Не квери");

        boolean expected = false;
        boolean actual = simpleTask.matches("query");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting1() {
        Meeting meeting = new Meeting(
                555,
                "query",
                "query",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting2() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "query",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting3() {
        Meeting meeting = new Meeting(
                555,
                "query",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting4() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting5() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии query",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting6() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение query",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestMatchesMeeting7() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после query"
        );

        boolean expected = false;
        boolean actual = meeting.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestEpic1() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestEpic2() {
        String[] subtasks = {"query", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestEpic3() {
        String[] subtasks = {"Молоко", "query", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("query");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void TestEpic4() {
        String[] subtasks = {"Молоко", "Яйца", "query"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("query");
        Assertions.assertEquals(expected, actual);
    }
}
