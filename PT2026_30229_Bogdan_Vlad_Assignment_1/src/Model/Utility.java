package Model;

import java.io.Serializable;
import java.util.*;

public class Utility implements Serializable {
    private TaskManagement data;

    public Utility(TaskManagement data) {
        this.data = data;
    }

    public TaskManagement getData() {
        return data;
    }

    public void setData(TaskManagement data) {
        this.data = data;
    }

    public Map<String, Integer> filterEmployees() {


        List<Employee> lis = new ArrayList<>();

        for (Employee emp : this.data.getMap().keySet()) {
            if (this.data.calculateEmployeeWorkDuration(emp.getIdEmployee()) >= 40) {
                lis.add(emp);
            }
        }


        Collections.sort(lis,new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                int hour1 = data.calculateEmployeeWorkDuration(e1.getIdEmployee());
                int hour2 = data.calculateEmployeeWorkDuration(e2.getIdEmployee());
                return hour1 - hour2;
            }
        });

        //pastreaza ordinea
        Map<String, Integer> rezultatSortat = new LinkedHashMap<>();

        for (Employee emp : lis) {
            int hour = this.data.calculateEmployeeWorkDuration(emp.getIdEmployee());
            rezultatSortat.put(emp.getName(), hour);
        }

        return rezultatSortat;
    }

    public Map<String,Map<String,Integer>> compute()
    {
        Map<String,Map<String,Integer>> result=new HashMap<String,Map<String,Integer>>();
        for(Map.Entry<Employee,List<Task>> entry:this.data.getMap().entrySet())
        {
            int completed=0;
            int uncompleted=0;
            Map <String,Integer> aux=new HashMap<String,Integer>();
            for(Task t:entry.getValue())
            {

                if(t instanceof ComplexTask)
                   for(Task tf:((ComplexTask) t).getAllTasksOfATask())
                       if(tf.getStatusTask().equals("Completed"))
                       {
                           completed++;
                       }
                       else
                           uncompleted++;

                if(t.getStatusTask().equals("Completed"))
                {
                    completed++;
                }
                else
                    uncompleted++;
            }
            aux.put("Completed",completed);
            aux.put("Uncompleted",uncompleted);
            result.put(entry.getKey().getName(),aux);
        }
        return result;
    }






}

