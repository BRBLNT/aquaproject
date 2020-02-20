package aquariumproject;

public class Fish {

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public int getHealth() {
        return health;
    }

    public boolean isSex() {
        return sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    private String name;
    private int age;
    private String species;
    private int health;
    private boolean sex;
    
    
    public Fish(String name, int age, String species, int health, boolean sex) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.health = health;
        this.sex = sex;
    }
    
    
    
    
}
