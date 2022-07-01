import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application {
	
	private ArrayList<Pane> paneArray = new ArrayList<Pane>();
	private ArrayList<Text> educationArray = new ArrayList<Text>();
	private ArrayList<Text> experienceArray = new ArrayList<Text>();
	private ArrayList<Text> awardsArray = new ArrayList<Text>();
	private ArrayList<Text> volunteerArray = new ArrayList<Text>();
	private int edY = 70;
	private int exY = 70;
	private int awY = 70;
	private int volY = 70;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
		stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		stage.setResizable(false);
		
		Pane mainPage = new Pane();
		Button education = new Button("Education");
		education.setLayoutX(200);
		education.setLayoutY(50);
		
		Button experience = new Button("Experience");
		experience.setLayoutX(scene.getWidth()/2.5);
		experience.setLayoutY(80);
		
		Button awards = new Button("Awards/Honors");
		awards.setLayoutX(scene.getWidth()/2.5);
		awards.setLayoutY(110);
		
		Button volunteer = new Button("Volunteer Service");
		volunteer.setLayoutX(scene.getWidth()/2.5);
		volunteer.setLayoutY(140);
		
		Text main = new Text("BuildR");
		main.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		main.setX(scene.getWidth()/2.5);
		main.setY(40);
		mainPage.getChildren().addAll(main, education, experience, awards, volunteer);
		root.getChildren().add(mainPage);
		
		Button backToMain = new Button("Back to main page");
		backToMain.setVisible(false);
		root.getChildren().add(backToMain);
		
		// ------- EDUCATION PANE ------ //
		Pane educationPage = new Pane();
		TextField addEducation = new TextField();
		addEducation.setPromptText("Add education...");
		addEducation.setLayoutX(20);
		addEducation.setLayoutY(20);
		addEducation.setEditable(true);
		backToMain.setLayoutX(scene.getWidth()/2);
		backToMain.setLayoutY(20);
		
		educationPage.getChildren().addAll(addEducation);
		educationPage.setVisible(false);
		root.getChildren().add(educationPage);
		paneArray.add(educationPage);
		
		Pane experiencePage = new Pane();
		TextField addExperience = new TextField();
		addExperience.setPromptText("Add experience...");
		addExperience.setLayoutX(20);
		addExperience.setLayoutY(20);
		addExperience.setEditable(true);
		experiencePage.getChildren().addAll(addExperience);
		experiencePage.setVisible(false);
		root.getChildren().add(experiencePage);
		paneArray.add(experiencePage);
		
		Pane awardsPage = new Pane();
		TextField addAward = new TextField();
		addAward.setPromptText("Add award...");
		addAward.setLayoutX(20);
		addAward.setLayoutY(20);
		addAward.setEditable(true);
		awardsPage.getChildren().addAll(addAward);
		awardsPage.setVisible(false);
		root.getChildren().add(awardsPage);
		paneArray.add(awardsPage);
		
		Pane volunteerPage = new Pane();
		TextField addVolunteer = new TextField();
		addVolunteer.setPromptText("Add volunteer experience...");
		addVolunteer.setLayoutX(20);
		addVolunteer.setLayoutY(20);
		addVolunteer.setEditable(true);
		volunteerPage.getChildren().addAll(addVolunteer);
		volunteerPage.setVisible(false);
		root.getChildren().add(volunteerPage);
		paneArray.add(volunteerPage);
		
		stage.setScene(scene);
		stage.show();
		
		education.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainPage.setVisible(false);
		    	educationPage.setVisible(true);
		    	backToMain.setVisible(true);
			}
		});
		
		addEducation.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	String item = addEducation.getText();
		    	boolean has = false;
		    	for (Text text: educationArray) if (text.getText().equals(item)) has = true;
		    	
		    	if (!has) {
		    		addEducation.clear();
		    		Text education1 = new Text(item);
		    		educationArray.add(education1);
			    	educationPage.getChildren().add(education1);
			    	education1.setLayoutX(20);
			    	education1.setLayoutY(edY);
			    	edY += 20;
		    	}
			}
		});
		
		addExperience.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	String item = addExperience.getText();
		    	boolean has = false;
		    	for (Text text: experienceArray) if (text.getText().equals(item)) has = true;
		    	
		    	if (!has) {
		    		addExperience.clear();
		    		Text exp1 = new Text(item);
		    		experienceArray.add(exp1);
			    	experiencePage.getChildren().add(exp1);
			    	exp1.setLayoutX(20);
			    	exp1.setLayoutY(exY);
			    	exY += 20;
		    	}
			}
		});
		
		addAward.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	String item = addAward.getText();
		    	boolean has = false;
		    	for (Text text: awardsArray) if (text.getText().equals(item)) has = true;
		    	
		    	if (!has) {
		    		addAward.clear();
		    		Text aw1 = new Text(item);
		    		awardsArray.add(aw1);
			    	awardsPage.getChildren().add(aw1);
			    	aw1.setLayoutX(20);
			    	aw1.setLayoutY(awY);
			    	awY += 20;
		    	}
			}
		});
		
		addVolunteer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	String item = addVolunteer.getText();
		    	boolean has = false;
		    	for (Text text: volunteerArray) if (text.getText().equals(item)) has = true;
		    	
		    	if (!has) {
		    		addVolunteer.clear();
		    		Text vol1 = new Text(item);
		    		volunteerArray.add(vol1);
			    	volunteerPage.getChildren().add(vol1);
			    	vol1.setLayoutX(20);
			    	vol1.setLayoutY(volY);
			    	volY += 20;
		    	}
			}
		});
		
		experience.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainPage.setVisible(false);
		    	experiencePage.setVisible(true);
		    	backToMain.setVisible(true);
			}
		});
		
		awards.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainPage.setVisible(false);
		    	awardsPage.setVisible(true);
		    	backToMain.setVisible(true);
			}
		});
		
		volunteer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainPage.setVisible(false);
		    	volunteerPage.setVisible(true);
		    	backToMain.setVisible(true);
			}
		});
		
		backToMain.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	for (Pane pane: paneArray) pane.setVisible(false);
		    	mainPage.setVisible(true);
		    	backToMain.setVisible(false);
		    }
		});
		
		
	}
	
	

}
