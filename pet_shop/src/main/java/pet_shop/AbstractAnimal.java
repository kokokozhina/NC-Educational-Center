package pet_shop;

import static pet_shop.CONSTANTS.R;

abstract public class AbstractAnimal implements Animal {
    protected String breed;
    protected String name;
    protected Integer cost;
    protected String character;

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Integer getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    /**
     * Return name in "[A-Z][A-Z]\d\d\d\d" style
     */
    protected static String generateName() {
        char ans[] = new char[]{
                (char) ('A' + R.nextInt(26)),
                (char) ('A' + R.nextInt(26)),
                (char) ('0' + R.nextInt(10)),
                (char) ('0' + R.nextInt(10)),
                (char) ('0' + R.nextInt(10)),
                (char) ('0' + R.nextInt(10))
        };

        return String.valueOf(ans);
    }

}
