package factories;

import buttons.Button;
import checkboxes.Checkbok;
import images.Image;

public interface GUIFactory {
    Button createButton();
    Checkbok createCheckbok();
    Image createImage();
}
