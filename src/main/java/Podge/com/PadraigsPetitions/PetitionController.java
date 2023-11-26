// src/main/java/Podge/com/PadraigsPetitions/PetitionController.java
package Podge.com.PadraigsPetitions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PetitionController {

    private final PetitionService petitionService;

    @Autowired
    public PetitionController(PetitionService petitionService) {
        this.petitionService = petitionService;
    }

    @GetMapping("/")
    public String home() {
        // Return the name of the default landing page Thymeleaf template
        return "index"; // Replace "index" with the actual name of your default landing page
    }

    @GetMapping("/petitions")
    public String viewAllPetitions(Model model) {
        // Retrieve and pass the list of petitions to the view
        model.addAttribute("petitions", petitionService.getAllPetitions());
        return "petitions";
    }

    @GetMapping("/petitions/{id}")
    public String viewPetition(@PathVariable Long id, Model model) {
        // Retrieve the petition by ID and pass it to the view
        Petition petition = petitionService.getPetitionById(id);
        model.addAttribute("petition", petition);
        return "view-petition";
    }

    @GetMapping("/petitions/create")
    public String showCreateForm(Model model) {
        model.addAttribute("newPetition", new Petition());
        return "create-petition";
    }


    @PostMapping("/petitions/create")
    public String createPetition(@ModelAttribute Petition petition) {
        // Implement logic to create a new petition
        petitionService.createPetition(petition);
        return "redirect:/petitions";
    }


    @GetMapping("/petitions/search")
    public String showSearchForm() {
        // Implement logic to show the form for searching petitions
        // This can include a Thymeleaf template with a search form
        return "search-petition";
    }

    @PostMapping("/petitions/search")
    public String searchPetitions(@RequestParam String query, Model model) {
        // Implement logic to search for petitions based on the query
        // Pass the search results to the view
        // This can include a Thymeleaf template with search results
        return "search-results";
    }

    @GetMapping("/thank-you")
    public String thankYou() {
        return "thank-you";
    }


    @PostMapping("/submit-support")
    public String submitSupport(@RequestParam String name, @RequestParam String email) {
        // Redirect to the thank-you page
        return "redirect:/thank-you";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        // Log the exception
        e.printStackTrace();

        // Error message
        model.addAttribute("error", "An unexpected error occurred");

        // Return the name of the error Thymeleaf template
        return "error";
    }
}
