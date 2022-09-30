
/**
 * CSV files have three column headers: Country, Exports, and Value.
 */

// import edu.duke.*;
package DukeJavaParseCSV;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;
// import org.apache.commons.csv.*;
import java.util.ArrayList;

public class ParseExportData {
    public static void main(String[] args) throws IOException{
        // CSVReader reader = new CSVReader(new FileReader("D://sample.csv"));
        // StringBuffer buffer = new StringBuffer();
        FileReader fr = new FileReader("exportdata.csv");
        CSVReader csvReader = new CSVReader(fr);

        // CSVreader reader = fr.getCSVParser();
        System.out.println(countryInfo(csvReader, "Nauru"));

        fr = new FileReader("exportdata.csv");
        csvReader = new CSVReader(fr);
        System.out.println(listExportersTwoProducts(csvReader, "fish", "nuts"));       
        
        fr = new FileReader("exportdata.csv");
        csvReader = new CSVReader(fr);
        System.out.println(numberOfExporters(csvReader, "sugar"));
    }

    static String countryInfo(CSVReader reader, String country) throws IOException{
        String[] record = null;
        while ((record = reader.readNext()) != null){
            String currCountry = record[0]; // Country
            if (currCountry.contains(country)){
                return country + ": " + record[1] + ": " + record[2];
            }
        }
        return "NOT FOUND";
    }

    static String listExportersTwoProducts(CSVReader reader, String exportItem1, String exportItem2) throws IOException{
        ArrayList<String> lst = new ArrayList<String>();
        String[] record = null;
        while ((record = reader.readNext()) != null){
            String exports = record[1]; // Exports
            if (exports.contains(exportItem1) && exports.contains(exportItem2)){
                lst.add(record[0]); // Country
            }
        }
        return lst.toString();
    }

    static int numberOfExporters(CSVReader reader, String exportItem) throws IOException{
        int count = 0;
        String[] record = null;
        while ((record = reader.readNext()) != null){
            String exports = record[1]; // Exports
            if (exports.contains(exportItem)) {
                count += 1;
            }
        }
        return count;
    }
    
    
}
