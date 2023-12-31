import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void metodSearch1() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить query");

        String[] subtasks = {"Молоко", "Яйца", "query"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии query",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {epic, meeting, simpleTask};
        Task[] actual = todos.search("query");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void metodSearch2() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {};
        Task[] actual = todos.search("query");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void metodSearch3() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить query");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("query");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void metodSearch4() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {meeting};
        Task[] actual = todos.search("версии");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void metodSearch5() {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(meeting);
        todos.add(simpleTask);

        Task[] expected = {epic};
        Task[] actual = todos.search("Хлеб");

        Assertions.assertArrayEquals(expected, actual);
    }
}
