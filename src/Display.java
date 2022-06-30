import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application {
	
	private ArrayList<Pane> paneArray = new ArrayList<Pane>();
	private ArrayList<Text> educationArray = new ArrayList<Text>();
	private ArrayList<Text> experienceArray = new ArrayList<Text>();
	private ArrayList<Text> awardsArray = new ArrayList<Text>();
	private ArrayList<Text> volunteerArray = new ArrayList<Text>();

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
		education.setLayoutX(10);
		education.setLayoutY(20);
		Button experience = new Button("Experience");
		experience.setLayoutX(10);
		experience.setLayoutY(50);
		Button awards = new Button("Awards/Honors");
		awards.setLayoutX(10);
		awards.setLayoutY(80);
		Button volunteer = new Button("Volunteer Service");
		volunteer.setLayoutX(10);
		volunteer.setLayoutY(110);
		Text main = new Text("Main Page");
		main.setX(10);
		main.setY(15);
		mainPage.getChildren().addAll(main, education, experience, awards, volunteer);
		root.getChildren().add(mainPage);
		
		Button backToMain = new Button("Back to main page");
		backToMain.setVisible(false);
		root.getChildren().add(backToMain);
		
		// ------- EDUCATION PANE ------ //
		Pane educationPage = new Pane();
		TextField addEducation = new TextField("Add education...");
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
		TextField addExperience = new TextField("Add experience...");
		addExperience.setLayoutX(20);
		addExperience.setLayoutY(20);
		addExperience.setEditable(true);
		experiencePage.getChildren().addAll(addExperience);
		experiencePage.setVisible(false);
		root.getChildren().add(experiencePage);
		paneArray.add(experiencePage);
		
		Pane awardsPage = new Pane();
		TextField addAward = new TextField("Add award...");
		addAward.setLayoutX(20);
		addAward.setLayoutY(20);
		addAward.setEditable(true);
		awardsPage.getChildren().addAll(addAward);
		awardsPage.setVisible(false);
		root.getChildren().add(awardsPage);
		paneArray.add(awardsPage);
		
		Pane volunteerPage = new Pane();
		TextField addVolunteer = new TextField("Add volunteer experience...");
		addVolunteer.setLayoutX(20);
		addVolunteer.setLayoutY(20);
		addVolunteer.setEditable(true);
		volunteerPage.getChildren().addAll(addVolunteer);
		volunteerPage.setVisible(false);
		root.getChildren().add(volunteerPage);
		paneArray.add(volunteerPage);
		
		stage.setScene(scene);
		stage.show();
		
	}
	
	

}
