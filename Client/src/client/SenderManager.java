package client;

import Server.JsonProcessing;
import client.commands.*;
import data.Color;
import data.Dragon;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import java.util.Date;
import java.util.Scanner;

import static client.ClientAuthorization.ClientLogin;

public class SenderManager {
    @FXML
    private MenuItem yellowFilter;

    @FXML
    private MenuItem blackFilter;

    @FXML
    private MenuItem blueFilter;

    @FXML
    private TextArea textArea;

    @FXML
    private Button InsertButton;

    @FXML
    private Button InsertMaxButton;

    @FXML
    private AnchorPane anchorRoot;

    @FXML
    private Button clearButton;

    @FXML
    private Button exitButton;

    @FXML
    private MenuButton filterByColorButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button infoButton;

    @FXML
    private StackPane parentContainer;

    @FXML
    private Button printAscendingButton;

    @FXML
    private Button removeByGreaterKeyButton;

    @FXML
    private Button removeByKeyButton;

    @FXML
    private Button removeByLowerKeyButton;

    @FXML
    private Button showButton;

    @FXML
    private Button updateByIdButton;

    @FXML
    private MenuButton ColorMenuButton;

    @FXML
    private TextField ageField;

    @FXML
    private MenuButton characterMenuButton;

    @FXML
    private TextField coordinateXField;

    @FXML
    private TextField coordinateYField;

    @FXML
    private Button createObjField;

    @FXML
    private TextField eyesField;

    @FXML
    private TextField nameField;


    @FXML
    private TextField teethField;

    @FXML
    private MenuButton typeMenuButton;
    private String fullText = "";
    private Asker asker = new Asker(new Scanner(System.in));
    private SendCmd sender = new SendCmd();

    public void printer(AbstractCommand command) {
        fullText += sender.Sender(command) +
                "\n-------------------------------------" +
                "----------------------------------------" +
                "-----------------------------------------" +
                "-------------------------------------------" +
                "--------------------------------------------" +
                "\n";
        textArea.setText(fullText);
    }

    public void createAndSend(String[] finalCommand) {
        try {
            switch (finalCommand[0]) {
                case "show":
                    Show show = new Show();
                    sender.Sender(show);
                    break;
                case "help":
                    Help help = new Help();
                    sender.Sender(help);
                    break;
                case "info":
                    Info info = new Info();
                    sender.Sender(info);
                    break;
                case "clear":
                    Clear clear = new Clear();
                    sender.Sender(clear);
                    break;
                case "history":
                    //
                    break;
                case "insert":
                    InsertNull insert = new InsertNull();
                    insert.setDragon(new Dragon(ClientLogin(), asker.askName(), asker.askCoordinates(), new Date(), asker.askAge(), asker.askColor(), asker.askDragonType(), asker.askDragonCharacter(), asker.askDragonHead()));
                    insert.setKey(Integer.parseInt(finalCommand[1]));
                    sender.Sender(insert);
                    break;
                case "update":
                    UpdateID updateid = new UpdateID();
                    updateid.setId(Integer.parseInt(finalCommand[1]));
                    updateid.setDragon(new Dragon(ClientLogin(), asker.askName(), asker.askCoordinates(), new Date(), asker.askAge(), asker.askColor(), asker.askDragonType(), asker.askDragonCharacter(), asker.askDragonHead()));
                    sender.Sender(updateid);
                    break;
                case "remove":
                    RemoveKey remove = new RemoveKey();
                    remove.setKey(Integer.parseInt(finalCommand[1]));
                    sender.Sender(remove);
                    break;
                case "rmv_greater":
                    RemoveGreaterKey removegr = new RemoveGreaterKey();
                    removegr.setKey(Integer.parseInt(finalCommand[1]));
                    sender.Sender(removegr);
                    break;
                case "rmv_lower":
                    RemoveLowerKey removelw = new RemoveLowerKey();
                    removelw.setKey(Integer.parseInt(finalCommand[1]));
                    sender.Sender(removelw);
                    break;
                case "filter_color":
                    FilteredByColor filterbycolor = new FilteredByColor();
                    filterbycolor.setColor(Color.valueOf(finalCommand[1]));
                    sender.Sender(filterbycolor);
                    break;
                case "max_date":
                    MaxByCreationDate maxbydate = new MaxByCreationDate();
                    sender.Sender(maxbydate);
                    break;
                case "exit":
                    Exit exit = new Exit();
                    sender.Sender(exit);
                    System.out.println("Have a nice day)");
                    break;
                case "execute_script":
                    ExecuteScript execute_script = new ExecuteScript();
                    execute_script.setFileName(finalCommand[1]);
                    sender.Sender(execute_script);
                    break;
                case "print_ascending":
                    PrintAscending printAscending = new PrintAscending();
                    sender.Sender(printAscending);
                    break;
                default:
                    System.out.println("Comannd not found. Enter \"help\". ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            JsonProcessing.log.warning("ArrayIndexOutOfBoundsException");
            System.out.println("Need a numeric argument!");

        }

    }

    @FXML
    private void exitButton() {
        System.exit(228);
    }

    @FXML
    private void printAscendingButton() {
        PrintAscending printAscending = new PrintAscending();
        printer(printAscending);

    }


    @FXML
    private void removeByKeyButton() {

    }

    @FXML
    private void removeByLowerKeyButton() {
    }

    @FXML
    private void removeByGreaterKeyButton() {
    }

    @FXML
    private void updateByIdButton() {
    }

    @FXML
    private void InsertButton() {
    }

    @FXML
    private void InsertMaxButton() {
    }

    @FXML
    private void clearButton() {
    }

    @FXML
    private void helpButton() {
    }

    @FXML
    private void infoButton() {
    }

    @FXML
    private void showButton() {
    }

    @FXML
    private void blackFilter() {
        FilteredByColor filterbycolor = new FilteredByColor();
        filterbycolor.setColor(Color.valueOf("BLACK"));
        printer(filterbycolor);

    }

    @FXML
    private void yellowFilter() {
        FilteredByColor filterbycolor = new FilteredByColor();
        filterbycolor.setColor(Color.valueOf("YELLOW"));
        printer(filterbycolor);
    }

    @FXML
    private void blueFilter() {
        FilteredByColor filterbycolor = new FilteredByColor();
        filterbycolor.setColor(Color.valueOf("BLUE"));
        printer(filterbycolor);
    }
}
