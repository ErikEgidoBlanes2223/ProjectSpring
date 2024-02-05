package com.project.springproject.services;

import com.project.springproject.dto.ExhibitDTO;
import com.project.springproject.dto.ZooDTO;
import com.project.springproject.model.Zoo;
import com.project.springproject.repositories.ZooRepository;
import com.project.springproject.services.servicesInterfaces.ExhibitService;
import com.project.springproject.services.servicesInterfaces.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ZooServiceImpl implements ZooService {

    @Autowired
    private ZooRepository zooRepository;

    @Autowired
    private ExhibitService exhibitService;  // Assuming you have an ExhibitService for managing exhibits

    @Override
    public ZooDTO saveZoo(ZooDTO zooDTO) {
        try {
            Zoo zoo = new Zoo();
            zoo.setName(zooDTO.getName());
            zoo.setLocation(zooDTO.getLocation());
            zoo.setCapacity(zooDTO.getCapacity());
            zoo.setOpeningHours(zooDTO.getOpeningHours());
            zoo.setExhibits(exhibitService.convertToEntityList(zooDTO.getExhibits()));

            Zoo savedZoo = zooRepository.save(zoo);
            return convertToDTO(savedZoo);
        } catch (Exception e) {
            throw new RuntimeException("Error saving zoo: " + e.getMessage());
        }
    }

    @Override
    public ZooDTO getZooById(Long id) {
        try {
            Optional<Zoo> zoo = zooRepository.findById(id);
            return zoo.map(this::convertToDTO).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error getting zoo: " + e.getMessage());
        }
    }

    @Override
    public List<ZooDTO> getAllZoos() {
        try {
            List<Zoo> zoos = zooRepository.findAll();
            List<ZooDTO> zooDTOList = new ArrayList<>();
            for (Zoo zoo : zoos) {
                zooDTOList.add(convertToDTO(zoo));
            }
            return zooDTOList;
        } catch (Exception e) {
            throw new RuntimeException("Error getting all zoos: " + e.getMessage());
        }
    }

    @Override
    public void deleteZooById(Long id) {
        try {
            zooRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting zoo: " + e.getMessage());
        }
    }

    @Override
    public ZooDTO addExhibitToZoo(Long zooId, ExhibitDTO exhibitDTO) {
        ZooDTO zooDTO = getZooById(zooId);
        if (zooDTO != null) {
            zooDTO.getExhibits().add(exhibitService.saveExhibit(exhibitDTO));
            return saveZoo(zooDTO);
        }
        return null;
    }

    @Override
    public boolean removeExhibitFromZoo(Long zooId, Long exhibitId) {
        ZooDTO zooDTO = getZooById(zooId);
        if (zooDTO != null) {
            zooDTO.getExhibits().removeIf(exhibit -> exhibit.getId().equals(exhibitId));
            saveZoo(zooDTO);
            return true;
        }
        return false;
    }

    private ZooDTO convertToDTO(Zoo zoo) {
        ZooDTO zooDTO = new ZooDTO();
        zooDTO.setId(zoo.getId());
        zooDTO.setName(zoo.getName());
        zooDTO.setLocation(zoo.getLocation());
        zooDTO.setCapacity(zoo.getCapacity());
        zooDTO.setOpeningHours(zoo.getOpeningHours());
        zooDTO.setExhibits(exhibitService.convertToDTOList(zoo.getExhibits()));
        return zooDTO;
    }
}
