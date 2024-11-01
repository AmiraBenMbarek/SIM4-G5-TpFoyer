package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    private static final Logger logger = LogManager.getLogger(FoyerServiceImpl.class);

    FoyerRepository foyerRepository;

    public List<Foyer> retrieveAllFoyers() {
        logger.info("Retrieving all foyers");
        List<Foyer> foyers = foyerRepository.findAll();
        return foyers;
    }

    public Foyer retrieveFoyer(Long foyerId) {
        logger.info("Retrieving foyer with ID: {}", foyerId);
        Foyer foyer = foyerRepository.findById(foyerId).orElse(null);
        if (foyer != null) {
        } else {
        }
        return foyer;
    }

    public Foyer addFoyer(Foyer f) {
        logger.info("Adding new foyer: {}", f);
        Foyer addedFoyer = foyerRepository.save(f);
        return addedFoyer;
    }

    public Foyer modifyFoyer(Foyer foyer) {
        logger.info("Modifying foyer: {}", foyer);
        Foyer modifiedFoyer = foyerRepository.save(foyer);
        return modifiedFoyer;
    }

    public void removeFoyer(Long foyerId) {
        logger.info("Removing foyer with ID: {}", foyerId);
        foyerRepository.deleteById(foyerId);
    }
}