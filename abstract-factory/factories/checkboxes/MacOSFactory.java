package factories.checkboxes;

import javax.swing.ImageIcon;

import buttons.Button;
import buttons.MacOButton;
import checkboxes.Checkbok;
import checkboxes.MacOSCheckbox;
import factories.GUIFactory;
import images.Image;
import images.MacOSImage;

public class MacOSFactory implements GUIFactory{

    @Override
    public Button createButton() {
        return new MacOButton();
    }

    @Override
    public Checkbok createCheckbok() {
        return new MacOSCheckbox();
    }

    @Override
    public Image createImage() {
        return new MacOSImage();
    }
    
}
