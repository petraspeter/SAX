package sk.upjs.ics;

import java.util.*;

public class Internat {
    
    private char blok;
    private short rokZAR;
    private byte poschodie;
    
    private final List<Izba> izby = new ArrayList<>();
    
    public char getBlok() {
        return blok;
    }
    
    public void setBlok(char blok) {
        this.blok = blok;
    }
    
    public short getRokAR() {
        return rokZAR;
    }
    
    public void setRokAR(short rokAR) {
        this.rokZAR = rokAR;
    }
    
    public byte getPoschodie() {
        return poschodie;
    }
    
    public void setPoschodie(byte poschodie) {
        this.poschodie = poschodie;
    }
    
    public String getAkademickyRok() {
        return rokZAR + "/" + (rokZAR + 1);
    }
    
    public List<Izba> getIzby() {
        return izby;
    }
    
    public Internat(char blok, short rokAR, byte poschodie) {
        this.blok = blok;
        this.rokZAR = rokAR;
        this.poschodie = poschodie;
    }
    
    public void vypis() {
        StringBuilder sb = new StringBuilder();
        sb.append("Akademicky rok: "+getAkademickyRok()+", blok: "+getBlok()+", poschodie: "+getPoschodie()+"\n");
        for(Izba izba : izby) {
            sb.append(izba.vypis());
        }
        System.out.println(sb.toString());
    }
    
    
}