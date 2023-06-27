package com.kino.kino_backend.Service;

import com.kino.kino_backend.Entities.Screening;
import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
import com.kino.kino_backend.Repositories.ScreeningRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ScreeningServiceTest {

    @Mock
    private ScreeningRepository screeningRepository;

    @InjectMocks
    private ScreeningService screeningService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetScreeningByMovieId() {
        // Arrange
        Integer movieId = 1;
        List<Screening> expectedScreenings = new ArrayList<>();
        expectedScreenings.add(new Screening());
        expectedScreenings.add(new Screening());
        when(screeningRepository.findByMovieId(movieId)).thenReturn(expectedScreenings);

        // Act
        List<Screening> actualScreenings = screeningService.getScreeningByMovieId(movieId);

        // Assert
        assertEquals(expectedScreenings, actualScreenings);
        verify(screeningRepository, times(1)).findByMovieId(movieId);
    }

    @Test
    void testCreateScreening() {
        // Arrange
        Screening screening = new Screening();
        when(screeningRepository.save(screening)).thenReturn(screening);

        // Act
        Screening createdScreening = screeningService.createScreening(screening);

        // Assert
        assertEquals(screening, createdScreening);
        verify(screeningRepository, times(1)).save(screening);
    }
}
