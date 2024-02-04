package com.project.springproject.services.servicesInterfaces;

import com.project.springproject.dto.ExhibitDTO;
import com.project.springproject.model.Exhibit;

import java.util.List;

/**
 * The ExhibitService interface provides methods to manage exhibits.
 */
public interface ExhibitService {

    /**
     * Saves an exhibit.
     *
     * @param exhibitDTO The exhibit to be saved.
     * @return The saved exhibit.
     */
    ExhibitDTO saveExhibit(ExhibitDTO exhibitDTO);

    /**
     * Retrieves an exhibit by its ID.
     *
     * @param id The ID of the exhibit.
     * @return The exhibit with the specified ID.
     */
    ExhibitDTO getExhibitById(Long id);

    /**
     * Retrieves all exhibits.
     *
     * @return A list of all exhibits.
     */
    List<ExhibitDTO> getAllExhibits();

    /**
     * Deletes an exhibit by its ID.
     *
     * @param id The ID of the exhibit to be deleted.
     */
    void deleteExhibitById(Long id);

    /**
     * Converts a list of ExhibitDTOs to a list of Exhibit entities.
     *
     * @param exhibitDTOList The list of ExhibitDTOs to convert.
     * @return The converted list of Exhibit entities.
     */
    List<Exhibit> convertToEntityList(List<ExhibitDTO> exhibitDTOList);

    /**
     * Converts a list of Exhibit entities to a list of ExhibitDTOs.
     *
     * @param exhibitList The list of Exhibit entities to convert.
     * @return The converted list of ExhibitDTOs.
     */
    List<ExhibitDTO> convertToDTOList(List<Exhibit> exhibitList);
}
