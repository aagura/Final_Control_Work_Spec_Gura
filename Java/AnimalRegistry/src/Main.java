import Model.AnimalRegistryModel;
import Presenter.AnimalRegistryPresenter;
import View.AnimalRegistryView;
import View.ConsoleAnimalRegistryView;

public class Main {

    public static void main(String[] args) {
       // FileHandler.createFileIfNotExists();
        AnimalRegistryView view = new ConsoleAnimalRegistryView();
        AnimalRegistryModel model = new AnimalRegistryModel();
        AnimalRegistryPresenter presenter = new AnimalRegistryPresenter(view, model);

         presenter.start();
    }
}
