package Model;

import TextUI.TextUI;

public class Main {
    public static void main(String args[]) {
        LensManager manager = new LensManager();
        TextUI ui = new TextUI(manager);
        ui.show();
    }
}
