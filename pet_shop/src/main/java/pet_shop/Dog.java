package pet_shop;

import static pet_shop.CONSTANTS.R;
import static pet_shop.CONSTANTS.CHARACTERS;
import static pet_shop.CONSTANTS.DOG_BREEDS;

public class Dog extends DomesticAnimal {
    public Dog() {
        breed = DOG_BREEDS.values()[R.nextInt(DOG_BREEDS.values().length)].toString();
        name = generateName();
        cost = R.nextInt(10000);
        character = CHARACTERS.values()[R.nextInt(CHARACTERS.values().length)].toString();
    }
}
