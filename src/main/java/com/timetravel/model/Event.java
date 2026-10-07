package com.timetravel.model;
import java.io.Serializable;
import java.util.List;
public record Event(String id, int year, String title, String description, int importance, Category category, List<String> possibleConsequences, boolean prevented) implements Serializable {
    public Event { possibleConsequences = List.copyOf(possibleConsequences); }
    public Event atYear(int newYear) { return new Event(id, newYear, title, description, importance, category, possibleConsequences, prevented); }
    public Event withImportance(int value) { return new Event(id, year, title, description, value, category, possibleConsequences, prevented); }
    public Event asPrevented() { return new Event(id, year, title, description, importance, category, possibleConsequences, true); }
}
