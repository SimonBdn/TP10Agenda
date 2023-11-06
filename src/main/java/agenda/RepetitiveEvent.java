package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {

    private ChronoUnit frequency;
    private ArrayList<LocalDate> exception;

    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency=frequency;
    }

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency, ArrayList<LocalDate> exception) {
        super(title, start, duration);
        this.frequency=frequency;
        this.exception= new ArrayList<LocalDate>();
    }

    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date) {
        if(exception.contains(date)){
            throw new IllegalArgumentException("Date déjà présente");
        }
        else{
        exception.add(date);}
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return this.frequency;
    }

@Override
    public boolean isInDay(LocalDate aDay){
        if(aDay.getDayOfYear()== this.getStart().getDayOfYear()) {
            return true;
        }
        else {return false;}
}

}
