package models;

public class Poste {
    private int id;
    private int upPosteId;
    private int downPosteId;
    private double salary;
    private String title;
    private int workTimeHoursByDay;

    public Poste() {
    }

    public Poste(int id, int upPosteId, int downPosteId, double salary, String title, int workTimeHoursByDay) {
        this.id = id;
        this.upPosteId = upPosteId;
        this.downPosteId = downPosteId;
        this.salary = salary;
        this.title = title;
        this.workTimeHoursByDay = workTimeHoursByDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUpPosteId() {
        return upPosteId;
    }

    public void setUpPosteId(int upPosteId) {
        this.upPosteId = upPosteId;
    }

    public int getDownPosteId() {
        return downPosteId;
    }

    public void setDownPosteId(int downPosteId) {
        this.downPosteId = downPosteId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getWorkTimeHoursByDay() {
        return workTimeHoursByDay;
    }

    public void setWorkTimeHoursByDay(int workTimeHoursByDay) {
        this.workTimeHoursByDay = workTimeHoursByDay;
    }

    @Override
    public String toString() {
        return "Poste{" +
                "id=" + id +
                ", upPosteId=" + upPosteId +
                ", downPosteId=" + downPosteId +
                ", salary=" + salary +
                ", title='" + title + '\'' +
                ", workTimeHoursByDay=" + workTimeHoursByDay +
                '}';
    }
}
