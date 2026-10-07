package com.timetravel.model;
import java.io.Serializable;
public record Consequence(String domain, int impact, String description, int depth) implements Serializable { }
