package com.sismacontab.inventory.models;

import java.io.Serializable;
import java.util.Objects;

public class TicketBuyLinesId implements Serializable {
    
    private String ticket;
    private Double line;

    // Constructors
    public TicketBuyLinesId() {}

    public TicketBuyLinesId(String ticket, Double line) {
        this.ticket = ticket;
        this.line = line;
    }

    // Getters and Setters
    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Double getLine() {
        return line;
    }

    public void setLine(Double line) {
        this.line = line;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketBuyLinesId that = (TicketBuyLinesId) o;
        return Objects.equals(ticket, that.ticket) &&
               Objects.equals(line, that.line);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticket, line);
    }

    @Override
    public String toString() {
        return "TicketBuyLinesId{" +
                "ticket='" + ticket + '\'' +
                ", line=" + line +
                '}';
    }
}