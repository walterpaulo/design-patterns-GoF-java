package app;

import factories.GUIFactory;
import factories.checkboxes.LinuxFactory;
import factories.checkboxes.MacOSFactory;
import factories.checkboxes.WindowsFactory;

public class Demo {

    private static Application configureApplication() {
        Application app;
        GUIFactory factory;
        
        String osName = System.getProperty("os.name").toLowerCase();
        switch(osName) {
            case "windows 10":
              factory = new WindowsFactory();
              break;
            case "Mac":
                factory = new MacOSFactory();
                break;
            case "Linux":
                factory = new LinuxFactory();
                break;
            default:
                factory = new LinuxFactory();
          }
      
        app = new Application(factory);
        return app;
    }


    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
        
    }
}
