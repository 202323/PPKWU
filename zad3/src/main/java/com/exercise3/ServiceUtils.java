package com.exercise3;

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.CalScale;
import net.fortuna.ical4j.model.property.ProdId;
import net.fortuna.ical4j.model.property.Version;
import net.fortuna.ical4j.util.RandomUidGenerator;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.TreeMap;

public class ServiceUtils {
    private static VEvent populateWithVEvent(java.util.Calendar calendar, String event){
        VEvent anEvent = new VEvent(new Date(calendar.getTime()), event);
        anEvent.getProperties().add(new RandomUidGenerator().generateUid());
        return anEvent;
    }

    public static void populateCalendarWithEvents(@org.jetbrains.annotations.NotNull Map<String, String> eventsMap, String month, String year, Calendar calendar) {
        java.util.Calendar instance;
        for (Map.Entry<String, String> entry : eventsMap.entrySet()) {
            try {
                instance = java.util.Calendar.getInstance();
                instance.setTime(new SimpleDateFormat("yyyy-mm-dd").parse(year+"-"+month+"-"+entry.getKey()));
                calendar.getComponents().add(ServiceUtils.populateWithVEvent(instance, entry.getValue()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void generateICSFromCalendar(String year, String month, Calendar calendar) {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream("GeneratedCalendar-"+year+"-"+month+".ics");
            CalendarOutputter calendarOutputter = new CalendarOutputter();
            calendarOutputter.output(calendar, fileOutputStream);
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }

    @NotNull
    public static Calendar createCalendar() {
        Calendar calendar = new Calendar();
        calendar.getProperties().add(new ProdId("-//wEEIiACalendar"));
        calendar.getProperties().add(Version.VERSION_2_0);
        calendar.getProperties().add(CalScale.GREGORIAN);
        return calendar;
    }

    public static Map<String, String> getEvents(String year, String month) {
        URL endpoint = createURLQueryForGivenYearAndMonth(year, month);
        Map<String, String> eventsMap = new TreeMap<String, String>();
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) endpoint.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {

                if (inputLine.contains("<a class='active'")) {
                    inputLine = inputLine.replace("</tr><tr class='dzien'>", "");

                    while (inputLine.length() != 0) {
                        String dzien = inputLine.substring(inputLine.indexOf("<td"), inputLine.indexOf("</td>") + 5);

                        if (dzien.contains("InnerBox")) {
                            String day = dzien.substring(dzien.indexOf("void();\">") + 9, dzien.indexOf("</a>"));
                            String event = dzien.substring(dzien.indexOf("<p>") + 3, dzien.indexOf("</p>"));
                            eventsMap.put(day, event);
                        }
                        inputLine = inputLine.replace(dzien, "");
                    }
                }
            }
            in.close();
            return eventsMap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static URL createURLQueryForGivenYearAndMonth(String year, String month) {
        try {
            return new URL("http://www.weeia.p.lodz.pl/pliki_strony_kontroler/kalendarz.php?rok=" + year + "&miesiac=" + month + "&lang=1");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
