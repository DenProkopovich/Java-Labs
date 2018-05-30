import java.io.Serializable;

public class Mark implements Serializable  {
    private int value;
    private Course course;
    private Teacher teacher;

    public Mark(){
    }

    public Mark(int value, Course course) {
        this.value = value;
        this.course = course;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
