package models;

public class Vaccancy {
    int id;
    int employee_id;
    long starting_date;
    long end_date;

    public Vaccancy() {
    }

    public Vaccancy(int id, int employee_id, long starting_date, int days) {
        this.id = id;
        this.employee_id = employee_id;
        this.starting_date = starting_date;
    }

    public Vaccancy(int id, int employee_id, long starting_date, long end_date) {
        this.id = id;
        this.employee_id = employee_id;
        this.starting_date = starting_date;
        this.end_date = end_date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public long getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(long starting_date) {
        this.starting_date = starting_date;
    }

    public long getEnd_date() {
        return end_date;
    }

    public void setEnd_date(long end_date) {
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "Vaccancy{" +
                "id=" + id +
                ", employee_id=" + employee_id +
                ", starting_date=" + starting_date +
                ", end_date=" + end_date +
                '}';
    }
}
