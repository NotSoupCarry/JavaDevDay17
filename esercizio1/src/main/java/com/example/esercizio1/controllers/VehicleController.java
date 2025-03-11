package com.example.esercizio1.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.esercizio1.models.Vehicle;
import com.example.esercizio1.models.enums.VehicleStatuses;
import com.example.esercizio1.services.VehicleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // Ricerca per tutti i veicoli
    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    // Ricerca per la targa
    @GetMapping("/{targa}")
    public ResponseEntity<Vehicle> findByTarga(@PathVariable String targa) {
        Optional<Vehicle> veicolo = vehicleService.findByTarga(targa);
        return veicolo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // cambiare lo stato di un veicolo con un id
    @PatchMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicleState(@PathVariable int id,
            @RequestBody Map<String, String> requestBody) {
        String newStateStr = requestBody.get("stato");
        VehicleStatuses newState = VehicleStatuses.valueOf(newStateStr); // Converte la stringa in enum

        Vehicle updatedVehicle = vehicleService.patchVehicle(id, newState);
        if (updatedVehicle != null) {
            URI location = URI.create(String.format("api/vehicles/%s", updatedVehicle.getTarga()));
            return ResponseEntity.created(location).body(updatedVehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // inserire un nuovo veicolo
    @PostMapping
    public ResponseEntity<Vehicle> aggiungiVeicolo(@Valid @RequestBody Vehicle veicolo) {
        Vehicle nuovoVeicolo = vehicleService.addVehicle(veicolo);
        URI location = URI.create(String.format("api/vehicles/%s", nuovoVeicolo.getTarga()));
        return ResponseEntity.created(location).body(nuovoVeicolo);
    }

    // eliminare un veicolo
    @DeleteMapping("/{targa}")
    public ResponseEntity<Void> deleteVeicolo(@PathVariable String targa) {
        boolean deleted = vehicleService.deleteVehicle(targa);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // GET per contare i veicoli per stato
    @GetMapping("/count-by-status")
    public ResponseEntity<Map<String, Long>> countByStatus() {
        return ResponseEntity.ok(vehicleService.countVehiclesByStatus());
    }
}
