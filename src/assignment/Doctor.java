package assignment;

public class Doctor extends Staff {
    private String specialization;

    public Doctor(int id, String name, int experience, String specialization) {
        super(id, name, experience);
        setSpecialization(specialization);
    }

    @Override
    public void work() {
        System.out.println("Doctor " + name + " is treating patients");
    }

    @Override
    public String getRole() {
        return "Doctor";
    }

    public void setSpecialization(String specialization) {
        if (specialization == null || specialization.isEmpty())
            throw new IllegalArgumentException("Specialization cannot be empty");
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
