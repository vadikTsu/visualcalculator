package ua.com.foxminded;

public class DivisionStep {

    private int reminder;
    private int multiple;
    private int pointer;

    public DivisionStep(int reminder, int multiple, int pointer) {
        this.multiple = multiple;
        this.pointer = pointer;
        this.reminder = reminder;
    }

    public int getReminder() {
        return reminder;
    }

    public int getMultiple() {
        return multiple;
    }

    public int getPointer() {
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
