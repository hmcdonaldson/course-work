import java.io.IOException;
import java.util.ArrayList;

import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.gui2.*;

class AsciiArt {
	public static void main(String[] args) {
		DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
		Screen screen = null;

		try {
			screen = terminalFactory.createScreen();
			screen.startScreen();
		
			final WindowBasedTextGUI textGUI = new MultiWindowTextGUI(screen);			
			final Window window = new GUIAppWindow();
	
			textGUI.addWindowAndWait(window);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
    			if(screen != null) {
        			try {
            				screen.stopScreen();
        			} 
				catch(IOException e) {
            				e.printStackTrace();
        			}
    			}
		} 		
	}

	private static class GUIAppWindow extends BasicWindow {
		GUIAppWindow() {
			ArrayList<Window.Hint> hints = new ArrayList<>();
			hints.add(Window.Hint.CENTERED);
			setHints(hints);		

			Panel contentPanel = new Panel(new GridLayout(1));
			
			String art = "\r\n                       ,())))),\r\n                     ,()))))))),.       >>huh-huh<<         ,---,,,_\r\n                     ()))))))//((\\     check it out,       (         ))\r\n                    (\\\\( \\))( \\(/)    Beavis...we're,     (            )\r\n                    /(          \\\\  like, in \"ASS-kee.\"   (            )\r\n                    //       _   \\    >>huh-huh-huh<<     (_(_((((     )\r\n                    //   \\  /    \\   /                     (    , \\    )\r\n                    \\   (.  .    \\  /                      |   /   )   )\r\n                    (,     |    ,)     yeah. >>heh-heh<<   |\\ /    (   )\r\n                     \\   ^\\/^   /      that's COOL! hey,   (.(.)    S  )\r\n                     \\          /     Butt-Head...you're    /_       \\ )\r\n                      \\ (-<>-) /         an \"ASS-kee.\"  \\  /__)   ^   \\/\r\n                       \\  --  /           >>heh-heh<<       /____/    |\r\n                        \\ __ /                             )______    |\r\n                         |  |       //\\/\\\\/\\//\\/\\//\\/\\\\\\/\\        \\   |\r\n                      __-|__|-__   \\                      /     __-\\__|-__\r\n                     (          )  > BEAVIS AND BUTT-HEAD <    (          )\r\n                     |_|AC//DC|_|  /                      \\    |_|METALL|_|\r\n                     | |      | |   \\/\\//\\/\\\\/\\\\/\\//\\//\\/\\ TM  | |      | |";
	
			contentPanel.addComponent(new Label(art));
			this.setComponent(contentPanel);
		}
	}
}
