package Serializable;

import Model.Employee;
import Model.Task;
import Model.TaskManagement;
import Model.PossibleTasks;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {
    private PossibleTasks p;
    private Map<Employee,List<Task>> m;


    public DataStorage (PossibleTasks p,Map<Employee,List<Task>> m) {
        this.p=new PossibleTasks();
        this.m=new HashMap<>();
    }

    public void loadData() throws Exception {
        try
        {
            ObjectInputStream ob = new ObjectInputStream(new FileInputStream("Map.txt"));
            this.m=(Map<Employee, List<Task>>)ob.readObject();
            ob = new ObjectInputStream(new FileInputStream("PossibleTasks.txt"));
            this.p= (PossibleTasks) ob.readObject();
            ob.close();
        } catch (FileNotFoundException e) {
            throw new Exception();
        } catch (IOException e) {
            throw new Exception();
        } catch (ClassNotFoundException e) {
            throw new Exception();
        }

    }

    public void saveData() {

        try {

            ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream("Map.txt"));
            ob.writeObject(m);
            ob.close();

            ob = new ObjectOutputStream(new FileOutputStream("PossibleTasks.txt"));
            ob.writeObject(p);
            ob.close();

        } catch (IOException e) {
            System.out.println("data loading error");//afisez asa intentionat sa nu am un pop up pentru asta
        }
    }

    public PossibleTasks getP() {
        return p;
    }

    public void setP(PossibleTasks p) {
        this.p = p;
    }

    public Map<Employee, List<Task>> getM() {
        return m;
    }

    public void setM(Map<Employee, List<Task>> m) {
        this.m = m;
    }
}
