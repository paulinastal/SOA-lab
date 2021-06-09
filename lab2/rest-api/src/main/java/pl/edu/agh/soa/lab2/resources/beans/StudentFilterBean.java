package pl.edu.agh.soa.lab2.resources.beans;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class StudentFilterBean {

    private @DefaultValue ("") @QueryParam("name") String name;
    private @QueryParam("start") int start;
    private @QueryParam("size") int size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
