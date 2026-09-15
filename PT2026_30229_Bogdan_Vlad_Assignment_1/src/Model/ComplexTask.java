package Model;

import java.util.ArrayList;
import java.util.List;

final public class ComplexTask extends Task {

    private List<Task> taskCollection;

    public ComplexTask(int idTask, String statusTask) {
        super(idTask, statusTask);
        this.taskCollection=new ArrayList<Task>();
    }

    public List<Task> getTaskCollection() {
        return taskCollection;
    }

    public void addTask(Task task) {this.taskCollection.add(task);}

    public void deleteTask(Task task)
    {
        this.taskCollection.remove(task);
    }


    @Override
    public int estimateDuration() {
        int sum=0;
        for(Task aux:this.taskCollection)
        {
            sum+=aux.estimateDuration();
        }
        return sum;
    }

    //cautam un task in adancime pe un complextask
    public boolean searchTaskInOther(Task task) {
        for (Task aux : this.taskCollection) {
            if (aux.getIdTask() == task.getIdTask()) {
                return true;
            }
            if (aux instanceof ComplexTask) {
                if (((ComplexTask) aux).searchTaskInOther(task)) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Task> getAllTasksOfATask()
    {
        List<Task> result=new ArrayList<Task>();
        for(Task t:taskCollection)
        {
            result.add(t);
            List<Task>aux=new ArrayList<Task>();
            if(t instanceof ComplexTask)
            {
                aux=((ComplexTask) t).getAllTasksOfATask();
            }
                result.addAll(aux);
        }
        return result;
    }
}

