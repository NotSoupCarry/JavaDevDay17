package com.example.esercizio1.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.esercizio1.models.Vehicle;
import com.example.esercizio1.models.enums.VehicleStatuses;

@Service
public class VehicleService {
    private final List<Vehicle> vehiclesList = new ArrayList<>(List.of(
            new Vehicle(1, "Fiat", "Panda", "AB123CD", new Date(), VehicleStatuses.IN_ATTESA),
            new Vehicle(2, "Ford", "Focus", "XY456ZT", new Date(), VehicleStatuses.COMPLETATO),
            new Vehicle(3, "Tesla", "Model 3", "EV789JK", new Date(), VehicleStatuses.IN_LAVORAZIONE)));

    // GET per avere tutti i veicoli
    public List<Vehicle> getAllVehicles() {
        return vehiclesList;
    }

    // GET per cercare un veicolo con targa
    public Optional<Vehicle> findByTarga(String targa) {
        return vehiclesList.stream()
                .filter(veicolo -> veicolo.getTarga().equalsIgnoreCase(targa))
                .findFirst();
    }
    

    // PATCH per modificare lo stato di un veicolo
    public Vehicle patchVehicle(int id, VehicleStatuses newState) {
        for (Vehicle vehicle : vehiclesList) {
            if (vehicle.getId() == id) {
                vehicle.setStato(newState);
                return vehicle;
            }
        }
        return null;
    }

    // POST per aggiungere un veicolo
    public Vehicle addVehicle(Vehicle vehicle) {
        vehiclesList.add(vehicle);
        return vehicle;
    }

    // DELETE per eleminare un veicolo
    public boolean deleteVehicle(String targa) {
        return vehiclesList.removeIf(veicolo -> veicolo.getTarga().equalsIgnoreCase(targa));
    }
    

    // metodo per contare i veicoli per stato
     public Map<String, Long> countVehiclesByStatus() {
        return vehiclesList.stream()
            .collect(Collectors.groupingBy(Vehicle::getStato, Collectors.counting()));
    }
}
