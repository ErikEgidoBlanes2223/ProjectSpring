package com.project.springproject.controllers;

import com.project.springproject.model.Exhibit;
import com.project.springproject.repositories.ExhibitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exhibits")
public class ExhibitController {

    @Autowired
    private ExhibitRepository exhibitRepository;

    @GetMapping
    public List<Exhibit> getAllExhibits() {
        return exhibitRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exhibit> getExhibitById(@PathVariable Long id) {
        return exhibitRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Exhibit createExhibit(@RequestBody Exhibit exhibit) {
        return exhibitRepository.save(exhibit);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exhibit> updateExhibit(@PathVariable Long id, @RequestBody Exhibit updatedExhibit) {
        return exhibitRepository.findById(id)
                .map(existingExhibit -> {
                    existingExhibit.setName(updatedExhibit.getName());
                    existingExhibit.setCategory(updatedExhibit.getCategory());
                    existingExhibit.setDescription(updatedExhibit.getDescription());
                    existingExhibit.setZoo(updatedExhibit.getZoo()); // Actualiza la referencia al zoo si es necesario
                    return ResponseEntity.ok(exhibitRepository.save(existingExhibit));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExhibit(@PathVariable Long id) {
        return exhibitRepository.findById(id)
                .map(existingExhibit -> {
                    exhibitRepository.delete(existingExhibit);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
