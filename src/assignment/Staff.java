package assignment;

public abstract class Staff {
    protected int id;
    protected String name;
    protected int experience;

    public Staff(int id, String name, int experience) {
        setId(id);
        setName(name);
        setExperience(experience);
    }

    public abstract void work();
    public abstract String getRole();

    public void setId(int id) {
        if (id <= 0)
            throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    public void setExperience(int experience) {
        if (experience < 0)
            throw new IllegalArgumentException("Experience cannot be negative");
        this.experience = experience;
    }
}
