package sk.upjs.ics;

import java.util.*;

public class Izba {
    
    private short cisloIzby;
    
    private final List<Student> studenti = new ArrayList<>();
    
    public List<Student> getStudenti() {
        return studenti;
    }
    
    public short getCisloIzby() {
        return cisloIzby;
    }
    
    public void setCisloIzby(short cisloIzby) {
        this.cisloIzby = cisloIzby;
    }
    
    
    
    public String vypis() {
        StringBuilder sb = new StringBuilder();
        sb.append("\tIzba: "+cisloIzby);
        for (Student student : studenti) {
            sb.append(student.vypis());
        }
        return sb.toString();
    }
    
}
