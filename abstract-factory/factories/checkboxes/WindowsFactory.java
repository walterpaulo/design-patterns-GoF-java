package factories.checkboxes;

import buttons.Button;
import buttons.WindowsButton;
import checkboxes.Checkbok;
import checkboxes.WindowsCheckbox;
import factories.GUIFactory;
import images.Image;
import images.WindowsImage;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbok createCheckbok() {
        return new WindowsCheckbox();
    }

    @Override
    public Image createImage() {
        return new WindowsImage();
    }
    
}
