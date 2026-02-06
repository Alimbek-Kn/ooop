package assignment;

public class Nurse extends Staff {
    private boolean nightShift;

    public Nurse(int id, String name, int experience, boolean nightShift) {
        super(id, name, experience);
        this.nightShift = nightShift;
    }

    @Override
    public void work() {
        System.out.println("Nurse " + name + " is assisting patients");
    }

    @Override
    public String getRole() {
        return "Nurse";
    }

    public boolean isNightShift() {
        return nightShift;
    }
}
