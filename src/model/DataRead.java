package model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataRead {
    private String imei;
    private Date date;
    private Time hour;
    private double latitude;
    private double longitude;

    public void CreateFromString(String data) {
        String[] parts = data.split(";");

        imei = parts[1];

        // Parse date and hour
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
            date = formatter.parse(parts[2]);
            hour = new Time(DateFormat.getTimeInstance().parse(parts[3]).getTime());
        } catch (ParseException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

        // Parse latitude and longitude
        latitude = Double.parseDouble(parts[4]);
        longitude = Double.parseDouble(parts[5]);
    }

    @Override
    public String toString() {
        return imei + ";" + date + ";" + hour + ";" + latitude + ";" + longitude;
    }
}
