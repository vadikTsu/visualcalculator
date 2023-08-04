package ua.com.foxminded;

public class DivisionStep {

    private int reminder;
    private int multiple;
    private int pointer;

    public DivisionStep(Integer reminder, Integer multiple, Integer pointer) {
        this.multiple = multiple;
        this.pointer = pointer;
        this.reminder = reminder;
    }

    public Integer getReminder() {
        return reminder;
    }

    public Integer getMultiple() {
        return multiple;
    }

    public Integer getPointer() {
        return pointer;
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
        return reminder == other.reminder && multiple == other.multiple && pointer == other.pointer;

    }
}
