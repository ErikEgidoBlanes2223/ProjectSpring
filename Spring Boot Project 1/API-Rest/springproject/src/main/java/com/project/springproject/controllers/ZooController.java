package com.project.springproject.controllers;

import com.project.springproject.model.Zoo;
import com.project.springproject.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zoos")
public class ZooController {

    @Autowired
    private ZooRepository zooRepository;

    @GetMapping
    public List<Zoo> getAllZoos() {
        return zooRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zoo> getZooById(@PathVariable Long id) {
        return zooRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Zoo createZoo(@RequestBody Zoo zoo) {
        return zooRepository.save(zoo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Zoo> updateZoo(@PathVariable Long id, @RequestBody Zoo updatedZoo) {
        return zooRepository.findById(id)
                .map(existingZoo -> {
                    existingZoo.setName(updatedZoo.getName());
                    existingZoo.setLocation(updatedZoo.getLocation());
                    existingZoo.setCapacity(updatedZoo.getCapacity());
                    existingZoo.setOpeningHours(updatedZoo.getOpeningHours());
                    existingZoo.setExhibits(updatedZoo.getExhibits()); // Actualiza la lista de exhibits si es necesario
                    return ResponseEntity.ok(zooRepository.save(existingZoo));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZoo(@PathVariable Long id) {
        return zooRepository.findById(id)
                .map(existingZoo -> {
                    zooRepository.delete(existingZoo);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
