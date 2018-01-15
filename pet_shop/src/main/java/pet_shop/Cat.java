package pet_shop;

import static pet_shop.CONSTANTS.R;
import static pet_shop.CONSTANTS.CHARACTERS;
import static pet_shop.CONSTANTS.CAT_BREEDS;

public class Cat extends DomesticAnimal {
    public Cat() {
        breed = CAT_BREEDS.values()[R.nextInt(CAT_BREEDS.values().length)].toString();
        name = generateName();
        cost = R.nextInt(15000);
        character = CHARACTERS.values()[R.nextInt(CHARACTERS.values().length)].toString();
    }
}
