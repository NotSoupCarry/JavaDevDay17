package com.example.esercizio1.models;

import java.util.Date;

import com.example.esercizio1.models.enums.VehicleStatuses;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Vehicle {
    @NotNull(message = "L'id non può essere nullo")
    private int id;

    @NotBlank(message = "La marca del veicolo non può essere vuota")
    private String marca;

    @NotBlank(message = "il modello del veicolo non può essere vuoto")
    private String modello;

    @NotBlank(message = "La targa non può essere vuota")
    @Size(min = 5, max = 10, message = "La targa deve essere tra i 5 e i 10 caratteri")
    @Pattern(regexp = "^[A-Za-z]{2}\\d{3}[A-Za-z]{2}$", message = "La targa deve seguire il formato: XX - 123 - XX")
    private String targa;

    @JsonFormat(pattern = "yyyy-MM-dd")

    private Date dataIngresso;

    @NotNull(message = "Lo stato non può essere nullo")
    private VehicleStatuses stato;

    public Vehicle(int id, String marca, String modello, String targa, Date dataIngresso, VehicleStatuses stato) {
        this.id = id;
        this.marca = marca;
        this.modello = modello;
        this.targa = targa;
        this.dataIngresso = dataIngresso;
        this.stato = stato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public String getStato() {
        return stato.getDescrizione();
    }

    public void setStato(VehicleStatuses stato) {
        this.stato = stato;
    }

}
