
public abstract class User {
    private int id;
    private String name;

    public User (){
    }

    public User (int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getIndex() {
        return -1;
    }

//    public String getFullName (){
//        return "";
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public abstract int getIndex(int id);

    //public abstract String getFullName(int index);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}