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

 // -------------------------------------

    //Implémenter et tester les deux méthodes suivantes dans la classe Agenda

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        List<Event> sameTitle = new ArrayList<Event>();
        for(Event e : agenda){
            if(e.getTitle().equals(title)){
                sameTitle.add(e);
            }
        }
        return sameTitle;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean rep = true;
        for (Event f : agenda) {
            if (f.getStart().equals(e.getStart())) {
                rep = false;

            }
            else if(e.getStart().isBefore(f.getStart()) && e.getStart().plus(e.getDuration()).isBefore(f.getStart())) {
                rep = false;


            }
            else if (e.getStart().isAfter(f.getStart()) && e.getStart().plus(e.getDuration()).isAfter(f.getStart())){
                rep = false;

            }
        }
        return (rep);
    }



}
