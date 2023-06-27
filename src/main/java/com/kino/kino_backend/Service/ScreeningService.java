package com.kino.kino_backend.Service;

import com.kino.kino_backend.Entities.Screening;
import com.kino.kino_backend.Exceptions.ResourceNotFoundException;
import com.kino.kino_backend.Repositories.ScreeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreeningService {

    @Autowired
    private ScreeningRepository screeningRepository;

    public List<Screening> getScreeningByMovieId(Integer movieId) {
        // Perform any additional business logic if needed
        // e.g., filtering or sorting the screenings
        return screeningRepository.findByMovieId(movieId);
    }

    public Screening createScreening(Screening screening) {
        return screeningRepository.save(screening);
    }

}
