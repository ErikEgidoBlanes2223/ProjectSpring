package com.project.springproject.services;

import com.project.springproject.dto.ExhibitDTO;
import com.project.springproject.model.Exhibit;
import com.project.springproject.repositories.ExhibitRepository;
import com.project.springproject.services.servicesInterfaces.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExhibitServiceImpl implements ExhibitService {

    @Autowired
    private ExhibitRepository exhibitRepository;

    @Override
    public ExhibitDTO saveExhibit(ExhibitDTO exhibitDTO) {
        try {
            Exhibit exhibit = new Exhibit();
            exhibit.setName(exhibitDTO.getName());
            exhibit.setCategory(exhibitDTO.getCategory());
            exhibit.setDescription(exhibitDTO.getDescription());

            Exhibit savedExhibit = exhibitRepository.save(exhibit);
            return convertToDTO(savedExhibit);
        } catch (Exception e) {
            throw new RuntimeException("Error saving exhibit: " + e.getMessage());
        }
    }

    @Override
    public ExhibitDTO getExhibitById(Long id) {
        try {
            Optional<Exhibit> exhibit = exhibitRepository.findById(id);
            return exhibit.map(this::convertToDTO).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error getting exhibit: " + e.getMessage());
        }
    }

    @Override
    public List<ExhibitDTO> getAllExhibits() {
        try {
            List<Exhibit> exhibits = exhibitRepository.findAll();
            return convertToDTOList(exhibits);
        } catch (Exception e) {
            throw new RuntimeException("Error getting all exhibits: " + e.getMessage());
        }
    }

    @Override
    public void deleteExhibitById(Long id) {
        try {
            exhibitRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting exhibit: " + e.getMessage());
        }
    }

    // Métodos convertToEntityList y convertToDTOList implementados

    @Override
    public List<Exhibit> convertToEntityList(List<ExhibitDTO> exhibitDTOList) {
        return exhibitDTOList.stream()
                .map(this::convertToEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExhibitDTO> convertToDTOList(List<Exhibit> exhibitList) {
        return exhibitList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ExhibitDTO convertToDTO(Exhibit exhibit) {
        ExhibitDTO exhibitDTO = new ExhibitDTO();
        exhibitDTO.setId(exhibit.getId());
        exhibitDTO.setName(exhibit.getName());
        exhibitDTO.setCategory(exhibit.getCategory());
        exhibitDTO.setDescription(exhibit.getDescription());
        return exhibitDTO;
    }

    private Exhibit convertToEntity(ExhibitDTO exhibitDTO) {
        Exhibit exhibit = new Exhibit();
        exhibit.setId(exhibitDTO.getId());
        exhibit.setName(exhibitDTO.getName());
        exhibit.setCategory(exhibitDTO.getCategory());
        exhibit.setDescription(exhibitDTO.getDescription());
        return exhibit;
    }
}
