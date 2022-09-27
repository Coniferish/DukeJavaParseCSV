
/**
 * CSV files have three column headers labeled Country, Exports, and Value.
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.util.ArrayList;

public class ParseExportData {
    void tester(){
        FileResource fr = new FileResource();

        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));

        parser = fr.getCSVParser();
        System.out.println(listExportersTwoProducts(parser, "fish", "nuts"));       
        
        parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "sugar"));
    }

    String countryInfo(CSVParser parser, String country){
        for (CSVRecord record : parser){
            String currCountry = record.get("Country");
            if (currCountry.contains(country)){
                return country + ": " + record.get("Exports") + ": " + record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";
    }

    String listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2){
        ArrayList<String> lst = new ArrayList<String>();
        for (CSVRecord record: parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                lst.add(record.get("Country"));
            }
        }
        return lst.toString();
    }

    int numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser){
            String exports = record.get("Exports");
            if (exports.contains(exportItem)) {
                count += 1;
            }
        }
        return count;
    }
    
    
}
