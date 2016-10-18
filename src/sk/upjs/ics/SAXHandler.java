package sk.upjs.ics;

import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
    
    private StringBuilder sb;
    private Stack<Object> stack;
    private Internat internat;
    
    
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        String name = localName.isEmpty() ? qName : localName;
        sb.setLength(0);
        if ("InternatMedicka".equals(name)) {
            String rok = attributes.getValue("rok");
            short rokZAR = Short.parseShort(rok.substring(0, rok.indexOf('/')));
            char blok = attributes.getValue("blok").charAt(0);
            byte poschodie = Byte.parseByte(attributes.getValue("poschodie"));
            this.internat = new Internat(blok, rokZAR, poschodie);
            stack.push(this.internat);
            return;
        }
        if ("izba".equals(name)) {
            Izba izba = new Izba();
            short cislo = Short.parseShort(attributes.getValue("cislo"));
            izba.setCisloIzby(cislo);
            stack.push(izba);
            return;
        }
        if ("Student".equals(name)) {
            Student student = new Student();
            String meno = attributes.getValue("Meno");
            String priezvisko = attributes.getValue("Priezvisko");
            String email = attributes.getValue("Email");
            student.setMeno(meno);
            student.setPriezvisko(priezvisko);
            student.setEmail(email);
            stack.push(student);
            return;
        }
    }
    
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        String name = localName.isEmpty() ? qName : localName;
        
        if ("InternatMedicka".equals(name) || "izba".equals(name)
                || "Student".equals(name)) {
            stack.pop();
            return;
        }
        
        Object peekObject = stack.peek();
        /*
        if(peekObject instanceof Izba) {
        Izba izba = (Izba) peekObject;
        switch(name) {
        case "cislo":
        short a = Short.parseShort(sb.toString());
        System.out.println(a);
        izba.setCisloIzby(a);
        break;
        }
        }
        */
        if(peekObject instanceof Student) {
            Student student = (Student) peekObject;
            switch (name) {
                case "Meno":
                    student.setMeno(sb.toString());
                    break;
                case "Priezvisko":
                    student.setPriezvisko(sb.toString());
                    break;
                case "EMail":
                    student.setEmail(sb.toString());
                    break;
            }            
            sb.setLength(0);
        }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length);
    }
    
    public SAXHandler() {
        sb = new StringBuilder();
        stack = new Stack<>();
    }
    
    public Internat vratVyslednyInternat() {
        return internat;
    }
    
}
