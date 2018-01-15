package pet_shop;

import static pet_shop.CONSTANTS.R;
import static pet_shop.CONSTANTS.CHARACTERS;
import static pet_shop.CONSTANTS.SPIDER_BREEDS;

public class Spider extends WildAnimal {

    /**
     * Example of member inner class.
     */
    public class SpiderEggs {

        private Integer eggsInLaying;

        public Integer getEggsInLaying() {
            eggsInLaying = breed.length();
            return eggsInLaying;
        }

    }

    public Spider() {
        breed = SPIDER_BREEDS.values()[R.nextInt(SPIDER_BREEDS.values().length)].toString();
        name = generateName();
        cost = R.nextInt(5000);
        character = CHARACTERS.values()[R.nextInt(CHARACTERS.values().length)].toString();
    }

}
