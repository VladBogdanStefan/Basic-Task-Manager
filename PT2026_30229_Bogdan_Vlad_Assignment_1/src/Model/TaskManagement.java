package Model;


import java.io.*;
import java.util.*;

import Serializable.DataStorage;

public class TaskManagement implements Serializable{

    private Map<Employee, List<Task>> map ;
    private PossibleTasks p;
    private DataStorage ser;

    public TaskManagement()  {
        map=new HashMap<>();
        p=new PossibleTasks();
        ser=new DataStorage(p,map);
        try{
        ser.loadData();
        map=ser.getM();
        p=ser.getP();
        }
        catch (Exception e) {

        }

    }

    public void loadData() throws Exception {
            ser.loadData();
    }

    public Map<Employee, List<Task>> getMap() {
        return map;
    }

    public void setMap(Map<Employee, List<Task>> map) {
        this.map = map;
    }

    public void addEmployee(Employee emp) throws Exception {
        if(verifyEmployee(emp))
            map.put(emp,new ArrayList<Task>());
        else
            throw new Exception();
    }
    public boolean verifyEmployee(Employee emp)
    {
        for(Employee aux:this.map.keySet())
            if(aux.getIdEmployee()==emp.getIdEmployee())
                return false;

        return true;

    }

    public DataStorage getSer() {
        return ser;
    }

    public void setSer(DataStorage ser) {
        this.ser = ser;
    }

    public PossibleTasks getP() {
        return p;
    }

    public void setP(PossibleTasks p) {
        this.p = p;
    }

    public void assignTaskToEmployee(int idEmployee, Task task)throws Exception
    {
        for (Map.Entry<Employee, List<Task>> entry:this.map.entrySet())
        {
            if(entry.getKey().getIdEmployee()==idEmployee)
            {
                if(entry.getValue()==null)
                    entry.setValue(new ArrayList<Task>());
                if(verifyTaskForEmploye(entry.getValue(),task.getIdTask()))
                    entry.getValue().add(task);
                else
                    throw new Exception();
                break;
            }
        }
    }

    public boolean verifyTaskForEmploye(List<Task> source, int TaskId)
    {
        for(Task t:source)
            if(t.getIdTask()==TaskId)
                return false;
        return true;
    }

    public int calculateEmployeeWorkDuration(int employeeId)
    {

        for(Map.Entry<Employee,List<Task>> entry:this.map.entrySet())
        {
            if(entry.getKey().getIdEmployee()==employeeId)
            {
                List<Task> aux=new ArrayList<Task>();
                aux.addAll(getTasksForEmployee(employeeId));
                int sum=0;
                for(Task t :aux)
                {
                    if(t.getStatusTask().equals("Completed"))
                    {
                        sum+=t.estimateDuration();
                    }
                }
                return sum;
            }
        }
        return 0;
    }

    public void modifyTaskStatus(int idEmployee, int idTask) throws Exception {
        for(Map.Entry<Employee,List<Task>> entry : this.map.entrySet()) {
            if(entry.getKey().getIdEmployee() == idEmployee) {

                Task targetTask = findTask(entry.getValue(), idTask);

                if(targetTask != null) {
                    String status;
                    if(targetTask.getStatusTask().equals("Completed")) {
                        status = "Uncompleted";
                    } else {
                        status = "Completed";
                    }
                    targetTask.setStatusTask(status);

                    if(targetTask instanceof ComplexTask && status.equals("Completed")) {
                        recursiveChangeStatus((ComplexTask)targetTask, status);
                    }
                    return;
                }
            }
        }
        throw new Exception();
    }


    private Task findTask(List<Task> tasks, int idTask) {
        for(Task t : tasks) {
            if(t.getIdTask() == idTask) {
                return t;
            }
            if(t instanceof ComplexTask) {
                Task found = findTask(((ComplexTask) t).getTaskCollection(), idTask);
                if(found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    public void recursiveChangeStatus(ComplexTask t,String status)
    {
        for(Task aux:t.getTaskCollection())
        {
            aux.setStatusTask(status);
            if(aux instanceof ComplexTask)
            {
                recursiveChangeStatus((ComplexTask) aux,status);
            }
        }
    }

    public ArrayList<Employee> getEmployees()
    {
        ArrayList<Employee> aux=new ArrayList<Employee>();
        for(Employee emp:this.map.keySet())
            aux.add(emp);
        return aux;
    }

    public List<Task> getTasksForEmployee(int idEmployee)
    {
        List<Task>result=new ArrayList<Task>();
        for(Map.Entry<Employee,List<Task>> aux:map.entrySet())
        {
            if(aux.getKey().getIdEmployee()==idEmployee)
            {
                for(Task a:aux.getValue())
                {
                    result.add(a);
                    if(a instanceof ComplexTask)
                    {
                        result.addAll(((ComplexTask) a).getAllTasksOfATask());
                    }
                }
                return result;
            }
        }
        return result;
    }


}

