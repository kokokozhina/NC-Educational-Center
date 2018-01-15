package pet_shop;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum SearchService {
    INSTANCE;

    public static Animal searchByBreed(String q) {
        Collection<Animal> c = pet_shop.PetShopStorage.getInstance().getStorage();
        Object[] aux = c.stream().filter(s -> s.getBreed().equals(q)).limit(1).toArray();
        return aux.length > 0 ? (Animal) aux[0] : null;
    }

    public static Animal searchByName(String q) {
        Collection<Animal> c = PetShopStorage.getInstance().getStorage();
        Object[] aux = c.stream().filter(s -> s.getName().equals(q)).limit(1).toArray();
        return aux.length > 0 ? (Animal) aux[0] : null;
    }

    public static Animal searchByCost(String q) {
        Collection<Animal> c = PetShopStorage.getInstance().getStorage();
        Object[] aux = c.stream().filter(s -> s.getCost() <= Integer.valueOf(q)).limit(1)
                .toArray();
        return aux.length > 0 ? (Animal) aux[0] : null;
    }

    public static Animal searchByCharacter(String q) {
        Collection<Animal> c = PetShopStorage.getInstance().getStorage();
        Object[] aux = c.stream().filter(s -> s.getCharacter().equals(q)).limit(1).toArray();
        return aux.length > 0 ? (Animal) aux[0] : null;
    }
}
