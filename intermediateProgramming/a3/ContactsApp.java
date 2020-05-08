import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.lang.Thread;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.terminal.*;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.*;
import com.googlecode.lanterna.input.*;

import a2.Contact;
import a3.BusinessContact;

class ContactsApp {
	static WindowBasedTextGUI textGUI; 
	static Panel contactPanel;

	static ArrayList<BusinessContact> contactList = new ArrayList<>();;

	/*** DO NOT MODIFY MAIN ***/
	public static void main(String[] args) {

		DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
		Screen screen = null;

		try {
			screen = terminalFactory.createScreen();
			screen.startScreen();
		
			textGUI = new MultiWindowTextGUI(screen);			
			Window window = new GUIAppWindow();
	
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
		String fileName = "contacts.txt";

		GUIAppWindow() {
			setTitle("Contacts");
			ArrayList<Window.Hint> hints = new ArrayList<>();
			hints.add(Window.Hint.CENTERED);
			setHints(hints);		

			Panel mainPanel = new Panel(new LinearLayout(Direction.VERTICAL));
		
                        mainPanel.addComponent(new EmptySpace()); 

			contactPanel = new Panel(new GridLayout(2));
                        contactPanel.addComponent(new EmptySpace(), GridLayout.createHorizontallyFilledLayoutData(2));

			/*** Contact Panel ***/
			contactPanel.addComponent(new Label("First Name"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30, 1)));
			contactPanel.addComponent(new EmptySpace());		
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Last Name"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30, 1)));
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Mobile Phone"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30, 1)));	
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Personal Email"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30, 1)));
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Home Page"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30,1)));
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Company Name"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30,1)));
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Work Phone"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30,1)));
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new EmptySpace());
			contactPanel.addComponent(new Label("Fax Number"));
			contactPanel.addComponent(new TextBox(new TerminalSize(30,1)));
			/**************************************************
			 * Add Labels and TextBoxes for other fields here * 
			 **************************************************/







			mainPanel.addComponent(contactPanel);
                        mainPanel.addComponent(new EmptySpace()); 

			Panel buttonPanel = new Panel(new LinearLayout(Direction.HORIZONTAL));

			Button saveButton = new Button("Queue Contact");
			saveButton.addListener(new SaveButtonHandler());
			buttonPanel.addComponent(saveButton);

			Button writeButton = new Button("Write To File");
			writeButton.addListener(new WriteButtonHandler());
			buttonPanel.addComponent(writeButton);

			buttonPanel.addComponent(new Button("Exit", new Runnable() {
				@Override
				public void run() {
					GUIAppWindow.this.close();
				}
			}));

			mainPanel.addComponent(buttonPanel, LinearLayout.createLayoutData(LinearLayout.Alignment.Center));
		
			this.setComponent(mainPanel);
		}

		private class SaveButtonHandler implements Button.Listener {

				
				String firstName;
				String lastName;
				String mobileNumber;
				String personalEmail;
				String homePage;
				String companyName;
				String workPhone;
				String faxNumber;

			public void onTriggered(Button button) {

				int componentNum = 1;
				for (Component c : contactPanel.getChildren()) {
					if (componentNum == 3) {
						TextBox nameTextBox = (TextBox) c;
						firstName = nameTextBox.getText();
					}else if(componentNum == 7) {
							TextBox lastNameTextBox = (TextBox) c;
							lastName = lastNameTextBox.getText();
					}else if(componentNum == 11) {
							TextBox mobileNumberTextBox = (TextBox) c;
							mobileNumber = mobileNumberTextBox.getText();
					}else if(componentNum == 15) {
							TextBox personalEmailTextBox = (TextBox) c;
							personalEmail = personalEmailTextBox.getText();
					}else if(componentNum == 19) {
							TextBox homePageTextBox = (TextBox) c;
							homePage = homePageTextBox.getText();
					}else if(componentNum == 23) {
							TextBox companyNameTextBox = (TextBox) c;
							companyName = companyNameTextBox.getText();
					}else if(componentNum == 27) {
							TextBox workPhoneTextBox = (TextBox) c;
							workPhone = workPhoneTextBox.getText();
					}else if(componentNum == 31) {
							TextBox faxNumberTextBox = (TextBox) c;
							faxNumber = faxNumberTextBox.getText();
						
					}
				
					/***************************************************************
					 * Get data from the other GUI fields and set it in newContact *
					 ***************************************************************/






					/*** Increment the component number ***/
					componentNum++;
				}
				BusinessContact newContact;
				String empty = "";
				if (companyName.equals(empty)) {
					newContact = new BusinessContact(firstName, lastName);
					newContact.setCompanyName("N/A");
					newContact.setWorkPhone("N/A");
				}else if(workPhone.equals(empty)) {
					newContact = new BusinessContact(firstName, lastName, companyName);
					newContact.setWorkPhone("N/A");
				}else {
					newContact = new BusinessContact(firstName, lastName, companyName, workPhone);
				}
					newContact.setMobilePhone(mobileNumber);
					newContact.setPersonalEmail(personalEmail);
					newContact.setHomePage(homePage);
					newContact.setFaxNumber(faxNumber);	
				/*** Save newContact in contactList ***/
				contactList.add(newContact);
                                MessageDialog.showMessageDialog(textGUI, "Success", "Contact saved");
			}
		}

		private class WriteButtonHandler implements Button.Listener {
			public void onTriggered(Button button) {
 				try (PrintWriter pw = new PrintWriter(new FileOutputStream(fileName))) {
					
					/* Iterate through the ArrayList and write each Contact to file */ 
					for (BusinessContact contact: contactList) {
						pw.write(contact.getFirstName() + ":");	
						pw.write(contact.getLastName() + ":");
						pw.write(contact.getMobilePhone() + ":");
						pw.write(contact.getPersonalEmail() + ":");
						pw.write(contact.getHomePage() + ":");
						pw.write(contact.getCompanyName() + ":");
						pw.write(contact.getWorkPhone() + ":");
						pw.write(contact.getFaxNumber() + ":");	
					        /********************************************* 
						 * Write other fields in Contact to file * 
					         *********************   TextBox lastNameTextBox = (TextBox) c;
                                                   ************************/ 






						/*** Write newline character to separate contacts ***/
						pw.write("\n");
					} 

                                        MessageDialog.showMessageDialog(textGUI, "Success", "Contacts written to file");
                                } catch (FileNotFoundException e) {
                                        MessageDialog.showMessageDialog(textGUI, "Error", "File not found");
                                        return;
                                }
			}
		}
	}
}
			
