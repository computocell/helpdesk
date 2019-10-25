package br.com.computocell.helpdesk.api.security.enums;

public enum StatusEnum {
    New,
    Assigned,
    Resolved,
    Approved,
    Disaproved,
    Closed;

    public static StatusEnum getStatus(String status) {
        switch (status) {
            case "New": return New;
            case "Resolved": return Resolved;
            case "Approved": return Approved;
            case "Disaproved": return Disaproved;
            case "Assigned": return Assigned;
            case "Closed": return Closed;
            default: return New;

        }
    }

    }
