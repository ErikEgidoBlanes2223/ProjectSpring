package com.project.springproject.services.servicesInterfaces;

import com.project.springproject.dto.ExhibitDTO;
import com.project.springproject.dto.ZooDTO;

import java.util.List;

/**
 * The ZooService interface provides methods to manage zoos and their exhibits.
 */
public interface ZooService {

    /**
     * Saves a zoo.
     *
     * @param zooDTO The zoo to be saved.
     * @return The saved zoo.
     */
    ZooDTO saveZoo(ZooDTO zooDTO);

    /**
     * Retrieves a zoo by its ID.
     *
     * @param id The ID of the zoo.
     * @return The zoo with the specified ID.
     */
    ZooDTO getZooById(Long id);

    /**
     * Retrieves all zoos.
     *
     * @return A list of all zoos.
     */
    List<ZooDTO> getAllZoos();

    /**
     * Deletes a zoo by its ID.
     *
     * @param id The ID of the zoo to be deleted.
     */
    void deleteZooById(Long id);

    /**
     * Adds an exhibit to a zoo.
     *
     * @param zooId      The ID of the zoo.
     * @param exhibitDTO The exhibit to be added.
     * @return The updated zoo.
     */
    ZooDTO addExhibitToZoo(Long zooId, ExhibitDTO exhibitDTO);

    /**
     * Removes an exhibit from a zoo.
     *
     * @param zooId    The ID of the zoo.
     * @param exhibitId The ID of the exhibit to be removed.
     * @return True if the exhibit was successfully removed, false otherwise.
     */
    boolean removeExhibitFromZoo(Long zooId, Long exhibitId);
}
