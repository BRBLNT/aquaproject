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

    public int getTemp() {
        return temp;
    }

    public int getLenght() {
        return lenght;
    }

    public String getFood() {
        return food;
    }

    public int getMinimumPoolSize() {
        return minimumPoolSize;
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

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setMinimumPoolSize(int minimumPoolSize) {
        this.minimumPoolSize = minimumPoolSize;
    }
    private String name;
    private int age;
    private String species;
    private int health;
    private boolean sex;
    private int temp;
    private int lenght;
    private String food;
    private int minimumPoolSize;
    private int picsID;

    public int getPicsID() {
        return picsID;
    }
    
    public Fish(String name, int age, String species, int health, boolean sex, int temp, int lenght, String food, int minimumPoolSize,int picsID) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.health = health;
        this.sex = sex;
        this.temp = temp;
        this.lenght = lenght;
        this.food = food;
        this.minimumPoolSize = minimumPoolSize;
        this.picsID = picsID;
    }
    
     @Override
        public String toString() {
        String str = name+" "+age+" "+species+" "+health+" "+sex+" "+temp+" "+lenght+" "+food+" "+minimumPoolSize+" "+picsID;
        return str;
    }
    
    
    
}
