package ng.dreammesh.app.dreamtunes.custom.models;

public class UserResponse {


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MyData getData() {
        return data;
    }

    public void setData(MyData data) {
        this.data = data;
    }

    private String status;
   private MyData data;




}
