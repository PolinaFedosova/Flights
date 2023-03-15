package PolinaF;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws IOException, ParseException {

        int avg = 0;
        JSONParser parser = new JSONParser();

        JSONObject jsonTickets;
        //название файла изменилось из-за того, что была изменена кодировка
        jsonTickets = (JSONObject) parser.parse(new FileReader("tickets2.json"));
        ArrayList<Integer> timePol = new ArrayList<>();
        Object listArray = jsonTickets.get("tickets");

        for (Object o : (JSONArray) listArray) {
            JSONObject ticket = (JSONObject) o;

            DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd.MM.yy");
            LocalDate departureDate = LocalDate.parse(ticket.get("departure_date").toString(), formatterDate);
            LocalDate arrivalDate = LocalDate.parse(ticket.get("arrival_date").toString(), formatterDate);
            Period period = Period.between(departureDate, arrivalDate);

            String[] departureTime = ticket.get("departure_time").toString().split(":");
            String[] arrivalTime = ticket.get("arrival_time").toString().split(":");

            int timePoleta = 60 * 24 * period.getDays() - 60 * Integer.parseInt(departureTime[0]) - Integer.parseInt(departureTime[1])
                    + 60 * Integer.parseInt(arrivalTime[0]) + Integer.parseInt(arrivalTime[1]);
            timePol.add(timePoleta);
            avg += timePoleta;
        }
        avg = avg / timePol.size();
        System.out.println("Среднее время в пути: " + avg / 60 + ":" + avg % 60);
        Collections.sort(timePol);
        int percentil = timePol.size() * 90 / 100;
        System.out.printf("Больше или равно чем 90-й процентиль: %d:%02d\n", timePol.get(percentil - 1) / 60, timePol.get(percentil - 1) % 60);
        System.out.printf("Больше чем 90-й процентиль: %d:%02d", timePol.get(percentil) / 60, timePol.get(percentil) % 60);
    }
}
