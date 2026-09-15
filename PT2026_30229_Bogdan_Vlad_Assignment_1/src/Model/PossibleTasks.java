package Model;

import Serializable.DataStorage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PossibleTasks implements Serializable{
    private List<Task> unassignedTasks;

    public PossibleTasks() {
        this.unassignedTasks=new ArrayList<Task>();
    }

    public List<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void setUnassignedTasks(List<Task> unassignedTasks) {
        this.unassignedTasks = unassignedTasks;
    }

    public void addTask(Task t) throws Exception {
        if(verifyTaskIntegrity(t))
            this.unassignedTasks.add(t);
        else
            throw new Exception();
    }

    public boolean verifyTaskIntegrity(Task t)
    {
        for(Task a :this.unassignedTasks)
        {
            if(a.getIdTask()==t.getIdTask())
                return false;
        }
        return true;
    }

    public Task getTask(int id)
    {
        for(Task t:this.unassignedTasks)
        {
            if(t.getIdTask()==id)
                return t;
        }
        return null;
    }

    //interceptam 2 probleme:1.taskul sa fie deja asignat,2.sa nu avem bucla infinita
    public void assignToComplexTask(int ComplexTaskId, int normalTaskId) throws Exception {
        if(ComplexTaskId == normalTaskId) throw new Exception();

        ComplexTask complex = (ComplexTask) getTask(ComplexTaskId);
        Task normal = getTask(normalTaskId);


        if(!complex.searchTaskInOther(normal)) {


            if(normal instanceof ComplexTask) {
                if(((ComplexTask) normal).searchTaskInOther(complex)) {
                    throw new Exception();
                }
            }
            complex.addTask(normal);
        } else {
            throw new Exception();
        }
    }


}

