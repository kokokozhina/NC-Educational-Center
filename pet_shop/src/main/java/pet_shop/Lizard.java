package pet_shop;

import static pet_shop.CONSTANTS.R;
import static pet_shop.CONSTANTS.CHARACTERS;
import static pet_shop.CONSTANTS.LIZARD_BREEDS;

public class Lizard extends WildAnimal {
    public Lizard() {
        breed = LIZARD_BREEDS.values()[R.nextInt(LIZARD_BREEDS.values().length)].toString();
        name = generateName();
        cost = R.nextInt(5000);
        character = CHARACTERS.values()[R.nextInt(CHARACTERS.values().length)].toString();
    }
}
