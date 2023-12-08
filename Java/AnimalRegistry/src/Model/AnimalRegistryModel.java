package Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnimalRegistryModel {
    private final List<HumanFriends> animals;

    public AnimalRegistryModel() {
        this.animals = new ArrayList<>();
    }

    public HumanFriends createAnimal(String name, Date birthDate, List<String> commands) {
        Cat cat = new Cat(1, name, birthDate, commands);
        animals.add(cat);
        return cat;
    }

    public List<String> getAnimalList(String category) {
        List<String> animalList = new ArrayList<>();
        for (HumanFriends animal : animals) {
            if (category.equals("All") || animal.getClass().getSimpleName().equals(category)) {
                animalList.add(animal.getName());
            }
        }
        return animalList;
    }

    public List<String> getAnimalCommands() {
        // Логика получения списка команд для выбранного животного
        // ...
        return new ArrayList<>();
    }
}
