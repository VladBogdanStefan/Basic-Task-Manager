package Controller;

import Model.*;
import Serializable.DataStorage;
import View.View;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {
    private View v;
    private TaskManagement t;
    private Utility u;

    public Controller(View v,TaskManagement t,Utility u) {
        this.v = v;
        this.t=t;
        this.u=u;
        listenLogic();

    }

    public void listenLogic()
    {
        navigateLogic();
        backLogic();
    }

    public void navigateLogic()
    {

        v.getModifyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                v.changeCardLayout(v.getMainCardLayout(),"Card2");

            }
        });

        v.getViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getMainCardLayout(),"Card3");

            }
        });
        v.getUtilityButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getMainCardLayout(),"Card4");
            }
        });

        v.getUtilityButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        v.getEmployeeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getModifyCardLayout(),"Card2");

            }
        });
        v.getTaskButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getModifyCardLayout(),"Card3");

            }
        });
        v.getAssignToEmployeeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getModifyCardLayout(),"Card4");

            }
        });
        v.getAssignToComplexTaskButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getModifyCardLayout(),"Card5");

            }
        });
        v.getModifyTaskStatusButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getModifyCardLayout(),"Card6");

            }
        });
        v.getSimpleOrComplexComboBox().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(v.getSimpleOrComplexComboBox().getSelectedItem() != null) {
                    if(((String)v.getSimpleOrComplexComboBox().getSelectedItem()).equals("simple"))
                        v.changeCardLayout(v.getSelectedTaskMain(),"Card1");
                    else
                        v.changeCardLayout(v.getSelectedTaskMain(),"Card2");
                }
            }
        });

        v.getFilterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getFilterOrComputeCardLayout(),"Card1");
            }
        });

        v.getComputeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.changeCardLayout(v.getFilterOrComputeCardLayout(),"Card2");
            }
        });

    }

    public void backLogic()
    {
        modifyLogic();
        viewLogic();
    }

    public void modifyLogic()
    {
        v.getEmployeeAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int id=Integer.parseInt(v.getEmployeeIdField().getText());
                    String name=v.getEmployeeNameField().getText();
                    Employee emp=new Employee(id,name);

                    t.addEmployee(emp);
                    v.clearFields(v.getEmployeeIdField());
                    v.clearFields(v.getEmployeeNameField());
                    t.getSer().saveData();
                }
                catch(NumberFormatException ex)
                {
                    v.showError("Employee id should be an integer","Invalid data");
                }
                catch(Exception ex)
                {
                    v.showError("Employee id already used","Invalid data");
                }
            }
        });

        v.getSimpleMainAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int id=Integer.parseInt(v.getSimpleMainTaskIdField().getText());
                    String status=(String)v.getSimpleMainStatuscomboBox().getSelectedItem();
                    int startHour=Integer.parseInt(v.getStartHourField().getText());
                    int endHour=Integer.parseInt(v.getEndHourField().getText());
                    SimpleTask aux=new SimpleTask(id,status,startHour,endHour);
                    t.getP().addTask(aux);
                    v.clearFields(v.getSimpleMainTaskIdField());
                    v.clearFields(v.getStartHourField());
                    v.clearFields(v.getEndHourField());
                    t.getSer().saveData();
                }
                catch (NumberFormatException ex)
                {
                    v.showError("Task id,start hour and end hour must be an Integer","Invalid Data");
                }
                catch (Exception ex)
                {
                    v.showError("Task id already used","Invalid Data");
                }
            }
        });

        v.getComplexMainAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int id=Integer.parseInt(v.getComplexMainTaskIdField().getText());
                    String status=(String)v.getComplexMainStatusComboBox().getSelectedItem();
                    ComplexTask aux=new ComplexTask(id,status);
                    t.getP().addTask(aux);
                    v.clearFields(v.getComplexMainTaskIdField());
                    t.getSer().saveData();
                }
                catch (NumberFormatException ex)
                {
                    v.showError("Task id must be an Integer","Invalid Data");
                }
                catch (Exception ex)
                {
                    v.showError("Task id already used","Invalid Data");
                }

            }
        });
        v.getAssignToEmployeeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                v.getAssignToEmployeeTaskComboBox().removeAllItems();
                v.getAssignToEmployeeEmployeeComboBox().removeAllItems();

                List<Task> a=t.getP().getUnassignedTasks();

                for(Task aux:a)
                    v.getAssignToEmployeeTaskComboBox().addItem(aux.getIdTask());
                List<Employee> b=t.getEmployees();
                for(Employee aux:b)
                    v.getAssignToEmployeeEmployeeComboBox().addItem(aux.getIdEmployee());
            }
        });
        v.getAssignToEmployeeAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    int emp;
                    Task task;
                    if(v.getAssignToEmployeeTaskComboBox().getSelectedItem()!=null&&
                            v.getAssignToEmployeeEmployeeComboBox().getSelectedItem()!=null) {
                        emp = Integer.parseInt( v.getAssignToEmployeeEmployeeComboBox().getSelectedItem().toString());
                        task = t.getP().getTask(Integer.parseInt( v.getAssignToEmployeeTaskComboBox().getSelectedItem().toString()));
                        t.assignTaskToEmployee(emp,task);
                    }
                    t.getSer().saveData();

                } catch (Exception ex) {
                    v.showError("Task already assigned for this employee","Already used");
                }
            }
        });
        v.getAssignToComplexTaskButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getAssignToComplexDestinationComboBox().removeAllItems();
                v.getAssignToComplexSourceComboBox().removeAllItems();
                for(Task task:t.getP().getUnassignedTasks())
                {
                    if(task instanceof ComplexTask)
                        v.getAssignToComplexDestinationComboBox().addItem(task.getIdTask());
                    v.getAssignToComplexSourceComboBox().addItem(task.getIdTask());
                }
            }
        });
        v.getAssignToComplexAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(v.getAssignToComplexDestinationComboBox().getSelectedItem() != null &&
                            v.getAssignToComplexSourceComboBox().getSelectedItem() != null) {

                        int destId = Integer.parseInt(v.getAssignToComplexDestinationComboBox().getSelectedItem().toString());
                        int sourceId = Integer.parseInt(v.getAssignToComplexSourceComboBox().getSelectedItem().toString());


                        t.getP().assignToComplexTask(destId, sourceId);


                        Task sourceTask = t.getP().getTask(sourceId);

                        //updatam si in task manager noul model de taskuri

                        for (Employee emp : t.getEmployees()) {

                            List<Task> employeeTasks = t.getTasksForEmployee(emp.getIdEmployee());

                            for (Task empTask : employeeTasks) {

                                if (empTask.getIdTask() == destId && empTask instanceof ComplexTask) {
                                    ((ComplexTask) empTask).addTask(sourceTask);
                                }
                            }
                        }

                        t.getSer().saveData();
                    }
                }
                catch (Exception ex)
                {
                    v.showError("Assignation not possible","Cycle or Already Assigned");
                }
            }
        });
        v.getModifyTaskStatusButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getModifyTaskStatuscomboBox2().removeAllItems();
                ArrayList<Employee> emps=t.getEmployees();
                for(Employee emp:emps)
                    v.getModifyTaskStatuscomboBox2().addItem(emp.getIdEmployee());

            }
        });
        v.getModifyTaskStatuscomboBox2().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(v.getModifyTaskStatuscomboBox2().getSelectedItem() != null) {
                    int idemp=Integer.parseInt(v.getModifyTaskStatuscomboBox2().getSelectedItem().toString());
                    List<Task> aux=t.getTasksForEmployee(idemp);
                    v.getModifyTaskStatuscomboBox1().removeAllItems();
                    for(Task tas:aux)
                        v.getModifyTaskStatuscomboBox1().addItem(tas.getIdTask());
                }
            }
        });
        v.getModifyTaskButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (v.getModifyTaskStatuscomboBox2().getSelectedItem() != null &&
                            v.getModifyTaskStatuscomboBox1().getSelectedItem() != null) {

                        int idemp = Integer.parseInt(v.getModifyTaskStatuscomboBox2().getSelectedItem().toString());
                        int idtask = Integer.parseInt(v.getModifyTaskStatuscomboBox1().getSelectedItem().toString());

                        t.modifyTaskStatus(idemp, idtask);
                        t.getSer().saveData();
                    }
                } catch (Exception ex) {
                    v.showError("Eroare"," ");
                }
            }
        });
    }

    public void viewLogic()
    {
        v.getViewButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTable();

            }
        });
        v.getFilterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                u=new Utility(t);
                updateFilterTable();
            }
        });

        v.getComputeButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                u=new Utility(t);
                updateComputeTable();
            }
        });
    }

    public void updateTable() {
        String[] coloane = {"EMPLOYEE_ID", "EMPLOYEE_NAME", "TASK_ID", "STATUS", "DURATION"};
        DefaultTableModel next = new DefaultTableModel(coloane, 0);

        for (Map.Entry<Employee, List<Task>> e : t.getMap().entrySet()) {
            Employee emp = e.getKey();
            List<Task> tasks = new ArrayList<Task>();
            tasks.addAll(t.getTasksForEmployee(emp.getIdEmployee()));
            if (tasks == null || tasks.isEmpty()) {
                Object[] o = {emp.getIdEmployee(), emp.getName(), "-", "-", "-"};
                next.addRow(o);
            } else {
                for (Task task : tasks) {
                    Object[] o = {emp.getIdEmployee(), emp.getName(), task.getIdTask(), task.getStatusTask(), task.estimateDuration()};
                    next.addRow(o);

                }
            }
        }
        v.getViewTable().setModel(next);
    }

    public void searchInTable(ComplexTask t, Employee e, DefaultTableModel next) {
        for (Task aux : t.getTaskCollection()) {
            Object[] o = {e.getIdEmployee(), e.getName(), aux.getIdTask(), aux.getStatusTask(), aux.estimateDuration()};
            next.addRow(o);
            if (aux instanceof ComplexTask) {
                searchInTable((ComplexTask) aux, e, next);
            }
        }
    }

    public void updateFilterTable()
    {
        String[] cols = { "EMPLOYEE NAME", "DURATION"};
        DefaultTableModel tab=new DefaultTableModel(cols,0);
        Map<String,Integer> aux=u.filterEmployees();
        for(Map.Entry<String,Integer> entr:aux.entrySet())
        {
            Object[] o= {entr.getKey(),entr.getValue()};
            tab.addRow(o);
        }
        v.getFilterTable().setModel(tab);
    }

    public void updateComputeTable()
    {
        String[] cols={"EMPLOYEE NAME","TASK TYPE","NUMBER"};
        DefaultTableModel tab=new DefaultTableModel(cols,0);
        Map<String,Map<String,Integer>> aux=u.compute();
        for(Map.Entry<String,Map<String,Integer>> ent:aux.entrySet())
        {
            Object[] o={ent.getKey()," "," "};
            tab.addRow(o);
            Map<String,Integer> map2=ent.getValue();

            for(Map.Entry<String,Integer> ent2:map2.entrySet())
            {
                Object[] o2 = new Object[]{" ", ent2.getKey(), ent2.getValue()};
                tab.addRow(o2);
            }
        }
        v.getComputeTable().setModel(tab);
    }
}