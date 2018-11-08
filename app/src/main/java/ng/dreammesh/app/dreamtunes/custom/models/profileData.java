package ng.dreammesh.app.dreamtunes.custom.models;


import java.util.List;


public class profileData {

    private int id;
   private String name;
    private String email;
   private String is_admin;
    private List<Object> preferences = null;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }

    public List<Object> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Object> preferences) {
        this.preferences = preferences;
    }
}
