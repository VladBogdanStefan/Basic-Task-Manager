import Controller.Controller;
import Model.PossibleTasks;
import Model.TaskManagement;
import Model.Utility;
import Serializable.DataStorage;
import View.View;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        TaskManagement task = new TaskManagement();
        Utility u=new Utility(task);
        Controller controller = new Controller(view, task,u);
    }
}
