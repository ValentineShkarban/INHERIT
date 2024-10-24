package todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean expected = true;
        boolean actual = task.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask task = new SimpleTask(1, "Позвонить домой");

        boolean expected = true;
        boolean actual = task.matches("Написать");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testEpicTaskMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Молоко");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testEpicTaskNotMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Сыр");

        Assertions.assertFalse(actual);
    }

    @Test
    public void testMeetingTaskMatches() {
        String[] subtasks = {"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда"};
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка 3й версии приложения");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskMatches1() {
        String[] subtasks = {"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда"};
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches("Приложение НетоБанка");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testMeetingTaskNotMatches() {
        String[] subtasks = {"Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда"};
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        boolean expected = true;
        boolean actual = meeting.matches("Купить кофе");

        Assertions.assertFalse(actual);
    }
}