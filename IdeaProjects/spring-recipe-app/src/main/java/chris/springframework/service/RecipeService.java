package chris.springframework.service;

import chris.springframework.domain.Recipe;

import java.util.Optional;
import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipies();
    Optional<Recipe> getRecipeByDesciption(String s);

}
