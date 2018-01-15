package pet_shop;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public enum BuySellService {
    INSTANCE;

    public static void buy(pet_shop.Animal animal) {
        PetShopStorage.getInstance().addAnimal(animal);

        PrintingService.printBuy(animal);
    }

    public static void sell(Animal animal) {
        boolean f = false;
        if (animal != null) {
            ArrayList<Animal> c = PetShopStorage.getInstance().getStorage();
            for (int i = 0; i < c.size(); i++) {
                if (c.get(i).getName().equals(animal.getName())
                        && c.get(i).getCharacter().equals(animal.getCharacter())
                        && c.get(i).getBreed().equals(animal.getBreed())
                        && c.get(i).getCost().equals(animal.getCost())) {
                    PetShopStorage.getInstance().deleteAnimal(i);
                    f = true;
                    break;
                }
            }
        }

        if (f) {
            PrintingService.printSellSuccessfully(animal);
        } else {
            PrintingService.printSellFailed();
        }
    }

    public static void sell(String params[]) {
        Animal animal = null;
        boolean f = true;
        String feature = params[0];

        if (feature.equals("BREED")) {
            animal = SearchService.searchByBreed(params[1]);
        } else if (feature.equals("NAME")) {
            animal = SearchService.searchByName(params[1]);
        } else if (feature.equals("COST")) {
            animal = SearchService.searchByCost(params[1]);
        } else if (feature.equals("CHARACTER")) {
            animal = SearchService.searchByCharacter(params[1]);
        } else {
            f = false;
        }

        if (f) {
            sell(animal);
        } else {
            PrintingService.printSellFailed();
        }
    }
}
