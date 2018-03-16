package chris.springframework.controller;


import chris.springframework.domain.Category;
import chris.springframework.domain.Recipe;
import chris.springframework.domain.UnitOfMeasure;
import chris.springframework.repositories.CategoryRepository;
import chris.springframework.repositories.UnitOfMeasureRepository;
import chris.springframework.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class TestController {

    private RecipeService recipeService;

    @Autowired
    public TestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"","/","/index"})
    public String getIndexPage(Model model){

       Optional<Recipe> optfind = recipeService.getRecipeByDesciption("Perfect Guacamole");
        System.out.println(optfind.get().getDirections());
        System.out.print("******************");

        model.addAttribute("recipes",recipeService.getRecipies());



        return "index";
    }




}
