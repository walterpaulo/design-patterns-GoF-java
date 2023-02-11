package app;

import buttons.Button;
import checkboxes.Checkbok;
import factories.GUIFactory;
import images.Image;

public class Application {
    private Button button;
    private Checkbok checkbok;
    private Image image;

    public Application(GUIFactory factory){
        button = factory.createButton();
        checkbok = factory.createCheckbok();
        image = factory.createImage();
    }

    public void paint(){
        button.paint();
        checkbok.paint();
        image.paint();
    }
}
