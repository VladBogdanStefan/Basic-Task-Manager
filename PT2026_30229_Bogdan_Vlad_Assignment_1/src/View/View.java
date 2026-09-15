package View;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame{
    private JPanel mainPanel;
    private JPanel header;
    private JPanel mainButtons;
    private JLabel taskManagerLabel;
    private JButton utilityButton;
    private JButton modifyButton;
    private JButton viewButton;
    private JPanel mainCardLayout;
    private JPanel emptyMainCardLayout;
    private JPanel modifyMainCardLayout;
    private JPanel modifyButtons;
    private JButton employeeButton;
    private JButton taskButton;
    private JButton assignToEmployeeButton;
    private JButton assignToComplexTaskButton;
    private JPanel modifyCardLayout;
    private JPanel emptyModifyCardLayout;
    private JPanel employeeMain;
    private JTextField employeeIdField;
    private JTextField employeeNameField;
    private JLabel employeeIdLabel;
    private JLabel employeeNameLabel;
    private JButton employeeAddButton;
    private JPanel taskMain;
    private JPanel selectedTaskComboBox;
    private JPanel selectedTaskMain;
    private JComboBox<String> simpleOrComplexComboBox;
    private JPanel simpleMain;
    private JPanel complexMain;
    private JTextField simpleMainTaskIdField;
    private JComboBox<String> simpleMainStatuscomboBox;
    private JTextField startHourField;
    private JTextField endHourField;
    private JLabel simpleMainId;
    private JLabel startHour;
    private JLabel endHour;
    private JButton simpleMainAddButton;
    private JPanel assignToEmployeeMain;
    private JTextField complexMainTaskIdField;
    private JButton complexMainAddButton;
    private JComboBox<String> complexMainStatusComboBox;
    private JLabel complexMainTaskIdLabel;
    private JLabel complexMainStatusComboBoxLabel;
    private JComboBox<Integer> assignToEmployeeEmployeeComboBox;
    private JComboBox<Integer> assignToEmployeeTaskComboBox;
    private JButton assignToEmployeeAddButton;
    private JLabel assignToEmployeeEmployeeLabel;
    private JLabel assignToEmployeeTaskLabel;
    private JPanel assignToComplexMain;
    private JComboBox<Integer> assignToComplexDestinationComboBox;
    private JComboBox<Integer> assignToComplexSourceComboBox;
    private JButton assignToComplexAddButton;
    private JLabel assignToComplexDestinationLabel;
    private JLabel assignToComplexSourceLabel;
    private JPanel viewMainCardLayout;
    private JTable viewTable;
    private JButton modifyTaskStatusButton;
    private JPanel modifyTaskStatusMain;
    private JComboBox<Integer> modifyTaskStatuscomboBox1;
    private JButton modifyTaskButton;
    private JPanel utilityMainCardLayout;
    private JButton filterButton;
    private JButton computeButton;
    private JPanel filterOrComputeCardLayout;
    private JPanel filtermain;
    private JPanel computemain;
    private JTable computeTable;
    private JTable filterTable;
    private JComboBox<Integer> modifyTaskStatuscomboBox2;
    private JLabel mployeeModifyLabel;
    private JLabel taskModifyLabel;
    private JPanel assignToComplexTaskMain;

    public View()
    {
        this.setContentPane(this.mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        setUp();


    }
    public void setUp()
    {
        this.changeCardLayout(mainCardLayout,"Card1");
        this.changeCardLayout(modifyCardLayout,"Card1");
        changeCardLayout(selectedTaskMain,"Card1");

    }

    public void  changeCardLayout(JPanel cardPack,String card)
    {
        CardLayout aux=(CardLayout)cardPack.getLayout();
        aux.show(cardPack,card);

    }

    public void showError(String message,String title)
    {
        JOptionPane.showMessageDialog(
                this.getMainPanel(),
                message,
                title,
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void clearFields(JTextField  f)
    {
        f.setText("");
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public JPanel getHeader() {
        return header;
    }

    public void setHeader(JPanel header) {
        this.header = header;
    }

    public JPanel getMainButtons() {
        return mainButtons;
    }

    public void setMainButtons(JPanel mainButtons) {
        this.mainButtons = mainButtons;
    }

    public JLabel getTaskManagerLabel() {
        return taskManagerLabel;
    }

    public void setTaskManagerLabel(JLabel taskManagerLabel) {
        this.taskManagerLabel = taskManagerLabel;
    }

    public JButton getUtilityButton() {
        return utilityButton;
    }

    public void setUtilityButton(JButton utilityButton) {
        this.utilityButton = utilityButton;
    }

    public JButton getModifyButton() {
        return modifyButton;
    }

    public void setModifyButton(JButton modifyButton) {
        this.modifyButton = modifyButton;
    }

    public JButton getViewButton() {
        return viewButton;
    }

    public void setViewButton(JButton viewButton) {
        this.viewButton = viewButton;
    }

    public JPanel getMainCardLayout() {
        return mainCardLayout;
    }

    public void setMainCardLayout(JPanel mainCardLayout) {
        this.mainCardLayout = mainCardLayout;
    }

    public JPanel getEmptyMainCardLayout() {
        return emptyMainCardLayout;
    }

    public void setEmptyMainCardLayout(JPanel emptyMainCardLayout) {
        this.emptyMainCardLayout = emptyMainCardLayout;
    }

    public JPanel getModifyMainCardLayout() {
        return modifyMainCardLayout;
    }

    public void setModifyMainCardLayout(JPanel modifyMainCardLayout) {
        this.modifyMainCardLayout = modifyMainCardLayout;
    }

    public JPanel getModifyButtons() {
        return modifyButtons;
    }

    public void setModifyButtons(JPanel modifyButtons) {
        this.modifyButtons = modifyButtons;
    }

    public JButton getEmployeeButton() {
        return employeeButton;
    }

    public void setEmployeeButton(JButton employeeButton) {
        this.employeeButton = employeeButton;
    }

    public JButton getTaskButton() {
        return taskButton;
    }

    public void setTaskButton(JButton taskButton) {
        this.taskButton = taskButton;
    }

    public JButton getAssignToEmployeeButton() {
        return assignToEmployeeButton;
    }

    public void setAssignToEmployeeButton(JButton assignToEmployeeButton) {
        this.assignToEmployeeButton = assignToEmployeeButton;
    }

    public JButton getAssignToComplexTaskButton() {
        return assignToComplexTaskButton;
    }

    public void setAssignToComplexTaskButton(JButton assignToComplexTaskButton) {
        this.assignToComplexTaskButton = assignToComplexTaskButton;
    }

    public JPanel getModifyCardLayout() {
        return modifyCardLayout;
    }

    public void setModifyCardLayout(JPanel modifyCardLayout) {
        this.modifyCardLayout = modifyCardLayout;
    }

    public JPanel getEmptyModifyCardLayout() {
        return emptyModifyCardLayout;
    }

    public void setEmptyModifyCardLayout(JPanel emptyModifyCardLayout) {
        this.emptyModifyCardLayout = emptyModifyCardLayout;
    }

    public JPanel getEmployeeMain() {
        return employeeMain;
    }

    public void setEmployeeMain(JPanel employeeMain) {
        this.employeeMain = employeeMain;
    }

    public JTextField getEmployeeIdField() {
        return employeeIdField;
    }

    public void setEmployeeIdField(JTextField employeeIdField) {
        this.employeeIdField = employeeIdField;
    }

    public JTextField getEmployeeNameField() {
        return employeeNameField;
    }

    public void setEmployeeNameField(JTextField employeeNameField) {
        this.employeeNameField = employeeNameField;
    }

    public JLabel getEmployeeIdLabel() {
        return employeeIdLabel;
    }

    public void setEmployeeIdLabel(JLabel employeeIdLabel) {
        this.employeeIdLabel = employeeIdLabel;
    }

    public JLabel getEmployeeNameLabel() {
        return employeeNameLabel;
    }

    public void setEmployeeNameLabel(JLabel employeeNameLabel) {
        this.employeeNameLabel = employeeNameLabel;
    }

    public JButton getEmployeeAddButton() {
        return employeeAddButton;
    }

    public void setEmployeeAddButton(JButton employeeAddButton) {
        this.employeeAddButton = employeeAddButton;
    }

    public JPanel getTaskMain() {
        return taskMain;
    }

    public void setTaskMain(JPanel taskMain) {
        this.taskMain = taskMain;
    }

    public JPanel getSelectedTaskComboBox() {
        return selectedTaskComboBox;
    }

    public void setSelectedTaskComboBox(JPanel selectedTaskComboBox) {
        this.selectedTaskComboBox = selectedTaskComboBox;
    }

    public JPanel getSelectedTaskMain() {
        return selectedTaskMain;
    }

    public void setSelectedTaskMain(JPanel selectedTaskMain) {
        this.selectedTaskMain = selectedTaskMain;
    }

    public JComboBox<String> getSimpleOrComplexComboBox() {
        return simpleOrComplexComboBox;
    }

    public void setSimpleOrComplexComboBox(JComboBox<String> simpleOrComplexComboBox) {
        this.simpleOrComplexComboBox = simpleOrComplexComboBox;
    }

    public JPanel getSimpleMain() {
        return simpleMain;
    }

    public void setSimpleMain(JPanel simpleMain) {
        this.simpleMain = simpleMain;
    }

    public JPanel getComplexMain() {
        return complexMain;
    }

    public void setComplexMain(JPanel complexMain) {
        this.complexMain = complexMain;
    }

    public JTextField getSimpleMainTaskIdField() {
        return simpleMainTaskIdField;
    }

    public void setSimpleMainTaskIdField(JTextField simpleMainTaskIdField) {
        this.simpleMainTaskIdField = simpleMainTaskIdField;
    }

    public JComboBox<String> getSimpleMainStatuscomboBox() {
        return simpleMainStatuscomboBox;
    }

    public void setSimpleMainStatuscomboBox(JComboBox<String> simpleMainStatuscomboBox) {
        this.simpleMainStatuscomboBox = simpleMainStatuscomboBox;
    }

    public JTextField getStartHourField() {
        return startHourField;
    }

    public void setStartHourField(JTextField startHourField) {
        this.startHourField = startHourField;
    }

    public JTextField getEndHourField() {
        return endHourField;
    }

    public void setEndHourField(JTextField endHourField) {
        this.endHourField = endHourField;
    }

    public JLabel getSimpleMainId() {
        return simpleMainId;
    }

    public void setSimpleMainId(JLabel simpleMainId) {
        this.simpleMainId = simpleMainId;
    }

    public JLabel getStartHour() {
        return startHour;
    }

    public void setStartHour(JLabel startHour) {
        this.startHour = startHour;
    }

    public JLabel getEndHour() {
        return endHour;
    }

    public void setEndHour(JLabel endHour) {
        this.endHour = endHour;
    }

    public JButton getSimpleMainAddButton() {
        return simpleMainAddButton;
    }

    public void setSimpleMainAddButton(JButton simpleMainAddButton) {
        this.simpleMainAddButton = simpleMainAddButton;
    }

    public JPanel getAssignToEmployeeMain() {
        return assignToEmployeeMain;
    }

    public void setAssignToEmployeeMain(JPanel assignToEmployeeMain) {
        this.assignToEmployeeMain = assignToEmployeeMain;
    }

    public JTextField getComplexMainTaskIdField() {
        return complexMainTaskIdField;
    }

    public void setComplexMainTaskIdField(JTextField complexMainTaskIdField) {
        this.complexMainTaskIdField = complexMainTaskIdField;
    }

    public JButton getComplexMainAddButton() {
        return complexMainAddButton;
    }

    public void setComplexMainAddButton(JButton complexMainAddButton) {
        this.complexMainAddButton = complexMainAddButton;
    }

    public JComboBox<String> getComplexMainStatusComboBox() {
        return complexMainStatusComboBox;
    }

    public void setComplexMainStatusComboBox(JComboBox<String> complexMainStatusComboBox) {
        this.complexMainStatusComboBox = complexMainStatusComboBox;
    }

    public JLabel getComplexMainTaskIdLabel() {
        return complexMainTaskIdLabel;
    }

    public void setComplexMainTaskIdLabel(JLabel complexMainTaskIdLabel) {
        this.complexMainTaskIdLabel = complexMainTaskIdLabel;
    }

    public JLabel getComplexMainStatusComboBoxLabel() {
        return complexMainStatusComboBoxLabel;
    }

    public void setComplexMainStatusComboBoxLabel(JLabel complexMainStatusComboBoxLabel) {
        this.complexMainStatusComboBoxLabel = complexMainStatusComboBoxLabel;
    }

    public JComboBox<Integer> getAssignToEmployeeEmployeeComboBox() {
        return assignToEmployeeEmployeeComboBox;
    }

    public void setAssignToEmployeeEmployeeComboBox(JComboBox<Integer> assignToEmployeeEmployeeComboBox) {
        this.assignToEmployeeEmployeeComboBox = assignToEmployeeEmployeeComboBox;
    }

    public JComboBox<Integer> getAssignToEmployeeTaskComboBox() {
        return assignToEmployeeTaskComboBox;
    }

    public void setAssignToEmployeeTaskComboBox(JComboBox<Integer> assignToEmployeeTaskComboBox) {
        this.assignToEmployeeTaskComboBox = assignToEmployeeTaskComboBox;
    }

    public JButton getAssignToEmployeeAddButton() {
        return assignToEmployeeAddButton;
    }

    public void setAssignToEmployeeAddButton(JButton assignToEmployeeAddButton) {
        this.assignToEmployeeAddButton = assignToEmployeeAddButton;
    }

    public JLabel getAssignToEmployeeEmployeeLabel() {
        return assignToEmployeeEmployeeLabel;
    }

    public void setAssignToEmployeeEmployeeLabel(JLabel assignToEmployeeEmployeeLabel) {
        this.assignToEmployeeEmployeeLabel = assignToEmployeeEmployeeLabel;
    }

    public JLabel getAssignToEmployeeTaskLabel() {
        return assignToEmployeeTaskLabel;
    }

    public void setAssignToEmployeeTaskLabel(JLabel assignToEmployeeTaskLabel) {
        this.assignToEmployeeTaskLabel = assignToEmployeeTaskLabel;
    }

    public JPanel getAssignToComplexMain() {
        return assignToComplexMain;
    }

    public void setAssignToComplexMain(JPanel assignToComplexMain) {
        this.assignToComplexMain = assignToComplexMain;
    }

    public JComboBox<Integer> getAssignToComplexDestinationComboBox() {
        return assignToComplexDestinationComboBox;
    }

    public void setAssignToComplexDestinationComboBox(JComboBox<Integer> assignToComplexDestinationComboBox) {
        this.assignToComplexDestinationComboBox = assignToComplexDestinationComboBox;
    }

    public JComboBox<Integer> getAssignToComplexSourceComboBox() {
        return assignToComplexSourceComboBox;
    }

    public void setAssignToComplexSourceComboBox(JComboBox<Integer> assignToComplexSourceComboBox) {
        this.assignToComplexSourceComboBox = assignToComplexSourceComboBox;
    }

    public JButton getAssignToComplexAddButton() {
        return assignToComplexAddButton;
    }

    public void setAssignToComplexAddButton(JButton assignToComplexAddButton) {
        this.assignToComplexAddButton = assignToComplexAddButton;
    }

    public JLabel getAssignToComplexDestinationLabel() {
        return assignToComplexDestinationLabel;
    }

    public void setAssignToComplexDestinationLabel(JLabel assignToComplexDestinationLabel) {
        this.assignToComplexDestinationLabel = assignToComplexDestinationLabel;
    }

    public JLabel getAssignToComplexSourceLabel() {
        return assignToComplexSourceLabel;
    }

    public void setAssignToComplexSourceLabel(JLabel assignToComplexSourceLabel) {
        this.assignToComplexSourceLabel = assignToComplexSourceLabel;
    }

    public JPanel getViewMainCardLayout() {
        return viewMainCardLayout;
    }

    public void setViewMainCardLayout(JPanel viewMainCardLayout) {
        this.viewMainCardLayout = viewMainCardLayout;
    }

    public JTable getViewTable() {
        return viewTable;
    }

    public void setViewTable(JTable viewTable) {
        this.viewTable = viewTable;
    }

    public JButton getModifyTaskStatusButton() {
        return modifyTaskStatusButton;
    }

    public void setModifyTaskStatusButton(JButton modifyTaskStatusButton) {
        this.modifyTaskStatusButton = modifyTaskStatusButton;
    }

    public JPanel getModifyTaskStatusMain() {
        return modifyTaskStatusMain;
    }

    public void setModifyTaskStatusMain(JPanel modifyTaskStatusMain) {
        this.modifyTaskStatusMain = modifyTaskStatusMain;
    }

    public JComboBox<Integer> getModifyTaskStatuscomboBox1() {
        return modifyTaskStatuscomboBox1;
    }



    public JButton getModifyTaskButton() {
        return modifyTaskButton;
    }

    public void setModifyTaskButton(JButton modifyTaskButton) {
        this.modifyTaskButton = modifyTaskButton;
    }

    public void setModifyTaskStatuscomboBox1(JComboBox<Integer> modifyTaskStatuscomboBox1) {
        this.modifyTaskStatuscomboBox1 = modifyTaskStatuscomboBox1;
    }

    public JPanel getUtilityMainCardLayout() {
        return utilityMainCardLayout;
    }

    public void setUtilityMainCardLayout(JPanel utilityMainCardLayout) {
        this.utilityMainCardLayout = utilityMainCardLayout;
    }

    public JButton getFilterButton() {
        return filterButton;
    }

    public void setFilterButton(JButton filterButton) {
        this.filterButton = filterButton;
    }

    public JButton getComputeButton() {
        return computeButton;
    }

    public void setComputeButton(JButton computeButton) {
        this.computeButton = computeButton;
    }

    public JPanel getFilterOrComputeCardLayout() {
        return filterOrComputeCardLayout;
    }

    public void setFilterOrComputeCardLayout(JPanel filterOrComputeCardLayout) {
        this.filterOrComputeCardLayout = filterOrComputeCardLayout;
    }

    public JPanel getFiltermain() {
        return filtermain;
    }

    public void setFiltermain(JPanel filtermain) {
        this.filtermain = filtermain;
    }

    public JPanel getComputemain() {
        return computemain;
    }

    public void setComputemain(JPanel computemain) {
        this.computemain = computemain;
    }

    public JTable getComputeTable() {
        return computeTable;
    }

    public void setComputeTable(JTable computeTable) {
        this.computeTable = computeTable;
    }

    public JTable getFilterTable() {
        return filterTable;
    }

    public void setFilterTable(JTable filterTable) {
        this.filterTable = filterTable;
    }

    public JComboBox<Integer> getModifyTaskStatuscomboBox2() {
        return modifyTaskStatuscomboBox2;
    }

    public void setModifyTaskStatuscomboBox2(JComboBox<Integer> modifyTaskStatuscomboBox2) {
        this.modifyTaskStatuscomboBox2 = modifyTaskStatuscomboBox2;
    }

    public JLabel getMployeeModifyLabel() {
        return mployeeModifyLabel;
    }

    public void setMployeeModifyLabel(JLabel mployeeModifyLabel) {
        this.mployeeModifyLabel = mployeeModifyLabel;
    }

    public JLabel getTaskModifyLabel() {
        return taskModifyLabel;
    }

    public void setTaskModifyLabel(JLabel taskModifyLabel) {
        this.taskModifyLabel = taskModifyLabel;
    }
}