package sk.upjs.ics;

public class Student {
    
    private String meno;
    private String priezvisko;
    private String email;
    
    public String getMeno() {
        return meno;
    }
    
    public void setMeno(String meno) {
        this.meno = meno;
    }
    
    public String getPriezvisko() {
        return priezvisko;
    }
    
    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String vypis() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\tMeno: "+meno+" Priezvisko: "+priezvisko+" E-mail: "+email+"\n");
        return sb.toString();
    }
    
}
