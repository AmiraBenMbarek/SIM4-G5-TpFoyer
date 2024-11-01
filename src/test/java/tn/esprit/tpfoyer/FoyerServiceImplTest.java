package tn.esprit.tpfoyer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;
import tn.esprit.tpfoyer.service.FoyerServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FoyerServiceImplTest {

    @InjectMocks
    private FoyerServiceImpl foyerService;

    @Mock
    private FoyerRepository foyerRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRetrieveAllFoyers() {
        List<Foyer> mockFoyers = new ArrayList<>();
        mockFoyers.add(new Foyer()); // Add a mock Foyer

        when(foyerRepository.findAll()).thenReturn(mockFoyers);

        List<Foyer> foyers = foyerService.retrieveAllFoyers();

        assertNotNull(foyers);
        assertEquals(1, foyers.size());
        verify(foyerRepository, times(1)).findAll();
    }

    @Test
    public void testRetrieveFoyer() {
        Long foyerId = 1L;
        Foyer mockFoyer = new Foyer();
        when(foyerRepository.findById(foyerId)).thenReturn(Optional.of(mockFoyer));

        Foyer foyer = foyerService.retrieveFoyer(foyerId);

        assertNotNull(foyer);
        verify(foyerRepository, times(1)).findById(foyerId);
    }

    @Test
    public void testAddFoyer() {
        Foyer mockFoyer = new Foyer();
        when(foyerRepository.save(mockFoyer)).thenReturn(mockFoyer);

        Foyer addedFoyer = foyerService.addFoyer(mockFoyer);

        assertNotNull(addedFoyer);
        verify(foyerRepository, times(1)).save(mockFoyer);
    }

    @Test
    public void testModifyFoyer() {
        Foyer mockFoyer = new Foyer();
        when(foyerRepository.save(mockFoyer)).thenReturn(mockFoyer);

        Foyer modifiedFoyer = foyerService.modifyFoyer(mockFoyer);

        assertNotNull(modifiedFoyer);
        verify(foyerRepository, times(1)).save(mockFoyer);
    }

    @Test
    public void testRemoveFoyer() {
        Long foyerId = 1L;
        doNothing().when(foyerRepository).deleteById(foyerId);

        foyerService.removeFoyer(foyerId);

        verify(foyerRepository, times(1)).deleteById(foyerId);
    }
}