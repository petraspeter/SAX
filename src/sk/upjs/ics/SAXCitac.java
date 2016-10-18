package sk.upjs.ics;

import java.io.File;
import javax.xml.parsers.*;

public class SAXCitac {
    
    public Internat citajXml(File xmlSubor) {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser parser;
        try {
            parser = spf.newSAXParser();
        } catch (Exception e) {
            throw new RuntimeException("Neviem vytvorit pozadovany parser.", e);
        }
        try {
            SAXHandler handler = new SAXHandler();
            parser.parse(xmlSubor, handler);
            return handler.vratVyslednyInternat();
        } catch (Exception e) {
            throw new RuntimeException("Nevhodny XML dokument!", e);
        }
    }
    
    public static void main(String[] args) {
        SAXCitac citac = new SAXCitac();
        Internat internat = citac.citajXml(new File("internat.xml"));
        internat.vypis();
    }
    
}
