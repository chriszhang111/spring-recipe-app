package chris.springframework.service;

import chris.springframework.domain.Recipe;
import chris.springframework.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipies() {

        Set<Recipe> result = new HashSet<>();

        for(Recipe recipe:recipeRepository.findAll()){

            result.add(recipe);

        }
        return result;
    }

    @Override
    public Optional<Recipe> getRecipeByDesciption(String s) {
        return recipeRepository.findByDescription(s);
    }
}
