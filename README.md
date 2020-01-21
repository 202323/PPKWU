# Mobile Calendar WEEIA

This program generates a Calendar containing events from WEEIA calendar (www.weeia.p.lodz.pl) for selected (but not future) month and year in .ICS format 

How to use:
1. Launch the application
2. Enter the query in browser: http://localhost:8080//generateMobileCalendar/{year}/{month}
      *Note! Replace '{year}' with year, and '{month}' with month that you desire 
3. The program will generate the ICS file with the events in Your project folder as 'GeneratedCalendar-{year}-{month}.ics'

CLASSES:

StartService.java - SpringBoot Java class, starts the service;

ICSGenerator.java - A Java class that generates an .ics file from CalendarData class;

ServiceController.java - Service controller Java class. It gets the value from the endpoint and notifies the user when the file is generated; 

ServiceUtils - A Java class containing all program logic.

CalendarData - A Calendar class that contains all the events for given year and month;

FUNCTIONS:

VEvent populateWithVEvent(java.util.Calendar calendar, String event) - populates the Calendar with a single event;

void populateCalendarWithEvents(Map<String, String> eventsMap, String month, String year, Calendar) - populates calendar with all events (uses populateWithEVent method);

void generateICSFromCalendar(String year, String month, Calendar calendar) - generates .ics file from the Calendar for given year and month;

Calendar createCalendar() - instantiates calendar object with default properties;

Map<String, String> getEvents (String year, String month) - populates the map with (key) dates of (value) events; 

URL createURLQueryForGivenYearAndMonth - creates an URL for WEEIA endpoint to retrieve data for calendar;