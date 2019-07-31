package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dataTrains {

    //String[][] data = new String[][]{};

    String[] split;
    String stations;
    String regions;
    int i = 0;
    String test;
    String line;

    public void dataAboutTrains() throws IOException {

        /*data = new String[][]{
                {"Pardubický Kraj"}, {"Pardubice Hlavní nádraží", "Choceň"},
                {"Královehradecký Kraj"}, {"Hradec Králové"}
        };

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.println(data[i][j]);
            }
        }*/
        List<Data> dataList = new ArrayList<Data>();


        BufferedReader reader = new BufferedReader(new FileReader("stations.txt"));
        String nextLine;

            while ((nextLine = reader.readLine()) != null) {
                try{
                    split = nextLine.split(", ");
                    regions = split[1];
                    stations = split[2];
                    System.out.println(stations);

                    Data data = new Data();
                    data.setStations(stations);
                    data.setRegions(regions);
                    dataList.add(data);
                }catch(Exception e){
                    e.printStackTrace();;
                }

            }
            reader.close();




    }

}

class Data{
    private String stations;
    private String regions;

    public void setStations(String stations) {
        this.stations = stations;
    }

    public String getStations() {
        return stations;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public String getRegions() {
        return regions;
    }
}
