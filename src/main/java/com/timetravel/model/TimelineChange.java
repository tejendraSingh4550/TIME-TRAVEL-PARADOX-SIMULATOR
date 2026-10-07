package com.timetravel.model;
import java.io.Serializable;
import java.time.Instant;
public record TimelineChange(String eventId, String eventTitle, ModificationType type, String details, Instant timestamp) implements Serializable { }
