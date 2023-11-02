public class Epic extends Task {

    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // заполнение своих полей
    }

    public String getSubtasks() {
        return subtasks[0];
    }

    @Override
    public boolean matches(String query) {
        for (String subtasks : subtasks) {
            if (subtasks.contains(query)) {
                return true;
            }
        }
        return false;
    }

}
