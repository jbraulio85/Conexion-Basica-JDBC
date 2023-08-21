package org.braulioecheverria.system;
import org.braulioecheverria.view.MenuPrincipal;

/**
 *
 * @author Brau
 */
public class MainApp {
/**
 * 
 * @author Braulio Echeverria
     * @param args metodo de arranque del programa
 */
    public static void main(String[] args) {
        MenuPrincipal menu = MenuPrincipal.getInstance();
        menu.arranque();
    }

}
