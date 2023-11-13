package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private ArrayList<Event> agenda;

    public Agenda() {
        this.agenda = new ArrayList<Event>();
    }

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        agenda.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> newAgenda = new ArrayList<Event>();
        for (Event e : agenda) {
            if (e.isInDay(day)) {
                newAgenda.add(e);
            }
        }
        return newAgenda;
    }

}
