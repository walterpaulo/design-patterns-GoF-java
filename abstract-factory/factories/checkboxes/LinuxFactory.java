package factories.checkboxes;

import buttons.Button;
import buttons.LinuxButton;
import checkboxes.Checkbok;
import checkboxes.LinuxCheckbox;
import factories.GUIFactory;
import images.Image;
import images.LinuxImage;

public class LinuxFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new LinuxButton();
    }

    @Override
    public Checkbok createCheckbok() {
        return new LinuxCheckbox();
    }

    @Override
    public Image createImage() {
        return new LinuxImage();
    }
    
}
