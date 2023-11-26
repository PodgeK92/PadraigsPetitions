package Podge.com.PadraigsPetitions;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetitionServiceImpl implements PetitionService {

    // In-memory list to store petitions (replace this with a database later)
    private List<Petition> petitions = new ArrayList<>();

    // Constructor to initialize pre-populated petitions
    public PetitionServiceImpl() {
        initializePrePopulatedPetitions();
    }

    // Method to initialize pre-populated petitions
    private void initializePrePopulatedPetitions() {
        Petition petition1 = new Petition();
        petition1.setId(1L);
        petition1.setTitle("Save the Environment");
        petition1.setDescription("Support initiatives to save our planet.");

        Petition petition2 = new Petition();
        petition2.setId(2L);
        petition2.setTitle("Education for All");
        petition2.setDescription("Ensure access to quality education for everyone.");

        Petition petition3 = new Petition();
        petition3.setId(3L);
        petition3.setTitle("Equal Rights");
        petition3.setDescription("Advocate for equal rights and opportunities for all.");

        Petition petition4 = new Petition();
        petition4.setId(4L);
        petition4.setTitle("Healthcare Access");
        petition4.setDescription("Ensure affordable and accessible healthcare for everyone.");

        // Add pre-populated petitions to the list
        petitions.add(petition1);
        petitions.add(petition2);
        petitions.add(petition3);
        petitions.add(petition4);
    }

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

}
