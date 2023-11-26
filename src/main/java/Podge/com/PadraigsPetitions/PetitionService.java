package Podge.com.PadraigsPetitions;

import java.util.List;

public interface PetitionService {

    List<Petition> getAllPetitions();
    Petition getPetitionById(Long id);
    Petition createPetition(Petition petition);

    Petition searchPetitions(String query);
}
