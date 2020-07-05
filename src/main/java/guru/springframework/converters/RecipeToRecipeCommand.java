/**
 * 
 */
package guru.springframework.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;
import lombok.Synchronized;

/**
 * @author Octavian Santau
 *
 */
@Component
public class RecipeToRecipeCommand implements Converter<Recipe, RecipeCommand> {

	@Synchronized
	@Nullable
	@Override
	public RecipeCommand convert(Recipe source) {
		// TODO Auto-generated method stub
		return null;
	}
}
