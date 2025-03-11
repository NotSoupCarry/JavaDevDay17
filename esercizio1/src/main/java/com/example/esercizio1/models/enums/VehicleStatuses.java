package com.example.esercizio1.models.enums;

public enum VehicleStatuses {   
    IN_ATTESA("In attesa"),
    COMPLETATO("Compleatato"),
    IN_LAVORAZIONE("In lavorazione");

    private final String descrizione;

    VehicleStatuses(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getDescrizione() {
        return descrizione;
    }
}
