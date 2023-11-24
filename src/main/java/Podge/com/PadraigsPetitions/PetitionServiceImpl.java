package Podge.com.PadraigsPetitions;


import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionServiceImpl implements PetitionService {

    // In-memory list to store petitions (replace this with a database later)
    private List<Petition> petitions = new ArrayList<>();

    @Override
    public List<Petition> getAllPetitions() {
        return petitions;
    }

    @Override
    public Petition getPetitionById(Long id) {
        // Implement logic to retrieve a petition by ID
        return petitions.stream()
                .filter(petition -> petition.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Petition createPetition(Petition petition) {
        // Assign a unique ID to the petition (replace with a more robust ID generation)
        petition.setId(System.currentTimeMillis());
        petitions.add(petition);
        return petition;
    }

    // Add other methods as needed
}
