package apiPetStore;

public class Pet {
    public int id;
    public Category category;
    public String name;
    public String[] photoUrls;
    public Tag[] tags;
    public String status;

public static class Category {
    public int id;
    public String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

public static class Tag {
    public int id;
    public String name;
    public Tag(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
}

