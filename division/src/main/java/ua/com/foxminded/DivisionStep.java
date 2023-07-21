package ua.com.foxminded;

public class DivisionStep {
    
    Integer reminder;
    Integer multiple;
    Integer pointer = 1;

    public DivisionStep(Integer reminder, Integer multiple, Integer pointer) {
        this.multiple = multiple;
        this.pointer = pointer;
        this.reminder = reminder;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DivisionStep other = (DivisionStep) obj;
        return reminder.equals(other.reminder) && 
                multiple.equals(other.multiple) && 
                pointer.equals(other.pointer);

    }
}
