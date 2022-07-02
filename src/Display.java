import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Display extends Application {

	private ArrayList<Pane> paneArray = new ArrayList<Pane>();
	private ArrayList<Text> educationArray = new ArrayList<Text>();
	private ArrayList<Text> experienceArray = new ArrayList<Text>();
	private ArrayList<Text> awardsArray = new ArrayList<Text>();
	private ArrayList<Text> volunteerArray = new ArrayList<Text>();
	private ArrayList<Button> buttonArray = new ArrayList<Button>();
	private ArrayList<Pane> newPanes = new ArrayList<Pane>();
	private ArrayList<Text> newItems = new ArrayList<Text>();
	private ArrayList<Button> newButtons = new ArrayList<Button>();

	private String name;
	private int edY = 110;
	private int exY = 110;
	private int awY = 110;
	private int volY = 110;
	private Button education;
	private Button experience;
	private Button awards;
	private Button volunteer;
	private Button buildResume;
	private Button backToMain;
	private Text main;
	private Pane mainPage;
	private TextField nameField = new TextField();
	private TextField addSection = new TextField();

	private Timer timer;
	private ComboBox classOf;

	private class Timer extends AnimationTimer {

		@Override
		public void handle(long now) {

			for (Button button: buttonArray) {
				button.setOnMouseEntered((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						button.setStyle("-fx-background-color: #c9e7f2; -fx-text-fill: black; -fx-border-color: black");
					}
				});

				button.setOnMouseExited((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
					public void handle(MouseEvent event) {
						button.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");
					}
				});
			}
			
			for (int i = 0; i < newButtons.size(); i++) {
				int j = i;
				newButtons.get(i).setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						buildResume.setVisible(false);
						mainPage.setVisible(false);
						newPanes.get(j).setVisible(true);
						backToMain.setVisible(true);
					}
				});
			}
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage = new Stage();
		Group root = new Group();
		Scene scene = new Scene(root, 500, 500);
		stage.setResizable(false);
		scene.setFill(Paint.valueOf("#d8edea"));

		// ---------- SETTING UP MAIN PAGE ---------- //
		mainPage = new Pane();
		setUpMainPage();
		mainPage.getChildren().addAll(main, nameField, classOf, education, experience, awards, volunteer, buildResume, addSection);
		root.getChildren().addAll(mainPage, backToMain);



		// ------- EDUCATION PANE ------- //
		Pane educationPage = new Pane();
		Text edLabel = new Text("Education");
		edLabel.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
		edLabel.setLayoutX(20);
		edLabel.setLayoutY(40);
		TextField addEducation = new TextField();
		addEducation.setPromptText("Add education...");
		addEducation.setLayoutX(20);
		addEducation.setLayoutY(60);
		addEducation.setEditable(true);
		backToMain.setLayoutX(scene.getWidth()/2 - backToMain.getWidth()/2);
		backToMain.setLayoutY(60);
		addEducation.setStyle("-fx-border-color: black");
		educationPage.getChildren().addAll(addEducation, edLabel);
		educationPage.setVisible(false);
		root.getChildren().add(educationPage);
		paneArray.add(educationPage);

		Pane experiencePage = new Pane();
		Text exLabel = new Text("Experience");
		exLabel.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
		exLabel.setLayoutX(20);
		exLabel.setLayoutY(40);
		TextField addExperience = new TextField();
		addExperience.setPromptText("Add experience...");
		addExperience.setLayoutX(20);
		addExperience.setLayoutY(60);
		addExperience.setEditable(true);
		addExperience.setStyle("-fx-border-color: black");
		experiencePage.getChildren().addAll(addExperience, exLabel);
		experiencePage.setVisible(false);
		root.getChildren().add(experiencePage);
		paneArray.add(experiencePage);

		Pane awardsPage = new Pane();
		Text awLabel = new Text("Awards/Honors");
		awLabel.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
		awLabel.setLayoutX(20);
		awLabel.setLayoutY(40);
		TextField addAward = new TextField();
		addAward.setPromptText("Add award...");
		addAward.setLayoutX(20);
		addAward.setLayoutY(60);
		addAward.setEditable(true);
		addAward.setStyle("-fx-border-color: black");
		awardsPage.getChildren().addAll(addAward, awLabel);
		awardsPage.setVisible(false);
		root.getChildren().add(awardsPage);
		paneArray.add(awardsPage);

		Pane volunteerPage = new Pane();
		Text volLabel = new Text("Volunteer Service");
		volLabel.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 30));
		volLabel.setLayoutX(20);
		volLabel.setLayoutY(40);
		TextField addVolunteer = new TextField();
		addVolunteer.setPromptText("Add volunteer experience...");
		addVolunteer.setLayoutX(20);
		addVolunteer.setLayoutY(60);
		addVolunteer.setEditable(true);
		addVolunteer.setStyle("-fx-border-color: black");
		volunteerPage.getChildren().addAll(addVolunteer, volLabel);
		volunteerPage.setVisible(false);
		root.getChildren().add(volunteerPage);
		paneArray.add(volunteerPage);

		buttonArray.add(education);
		buttonArray.add(experience);
		buttonArray.add(awards);
		buttonArray.add(volunteer);
		buttonArray.add(backToMain);
		buttonArray.add(buildResume);

		timer = new Timer();
		timer.start();

		stage.setScene(scene);
		stage.show();

		nameField.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				name = nameField.getText();
				Button text = new Button("Hello " + name + "!");
				text.setLayoutX(nameField.getLayoutX());
				text.setLayoutY(nameField.getLayoutY());
				text.setStyle("-fx-background-color: #c9e7f2; -fx-text-fill: black; -fx-border-color: black");
				mainPage.getChildren().add(text);
				nameField.setVisible(false);
			}
		});

		education.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				buildResume.setVisible(false);
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
					education1.setStyle("-fx-background-color: #c9e7f2; -fx-text-fill: black; -fx-border-color: black");
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
					exp1.setStyle("-fx-background-color: #c9e7f2; -fx-text-fill: black; -fx-border-color: black");
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
				for (Text text: awardsArray) if (text != null && text.getText().equals(item)) has = true;

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
					vol1.setStyle("-fx-background-color: #c9e7f2; -fx-text-fill: black; -fx-border-color: black");
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
				buildResume.setVisible(false);
				mainPage.setVisible(false);
				experiencePage.setVisible(true);
				backToMain.setVisible(true);
			}
		});

		awards.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				buildResume.setVisible(false);
				mainPage.setVisible(false);
				awardsPage.setVisible(true);
				backToMain.setVisible(true);
			}
		});

		volunteer.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				buildResume.setVisible(false);
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
				buildResume.setVisible(true);
			}
		});

		addSection.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				if (addSection.getText() != null) {
					Button newButton = new Button(addSection.getText());
					newButton.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");
					newButton.setLayoutX(15);
					newButton.setLayoutY(addSection.getLayoutY());
					newButtons.add(newButton);
					mainPage.getChildren().add(newButton);
					
					Pane newPane = new Pane();
					newPanes.add(newPane);
					paneArray.add(newPane);
					addSection.clear();
					addSection.setLayoutY(addSection.getLayoutY() + 35);
					buttonArray.add(newButton);
				}
			}
		});

		buildResume.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("build resume clicked");
				try {
					if (name != null) {
						String classYear = "";
						if (classOf.getAccessibleText() != null) classYear = ", CLASS OF " + classOf.getAccessibleText();
						FileWriter fw = new FileWriter(new File("/Users/macbookpro/Desktop/BuildR/resume.txt"));
						fw.write("RESUME FOR " + name.toUpperCase() + classYear + "\n\nEDUCATION\n");
						for (Text text: educationArray) fw.write("-" + text.getText() + "\n");
						fw.write("\nEXPERIENCE\n");
						for (Text text: experienceArray) fw.write("-" + text.getText() + "\n");
						fw.write("\nAWARDS/HONORS\n");
						for (Text text: awardsArray) fw.write("-" + text.getText() + "\n");
						fw.write("\nVOLUNTEER EXPERIENCE\n");
						for (Text text: volunteerArray) fw.write("-" + text.getText() + "\n");
						fw.write("\nCreated with BuildR");
						fw.close();
					}

				} catch (IOException i) {
					System.out.println("Error writing to file!");
				}
			}

		});

	}



	public void setUpMainPage() {

		main = new Text("BuildR");
		main.setFont(Font.font("calibri", FontWeight.BOLD, FontPosture.REGULAR, 35));
		main.setStyle("-fx-background-color: #c9e7f2; -fx-text-fill: black; -fx-border-color: black");
		main.setX(15);
		main.setY(38);

		nameField = new TextField();
		nameField.setText("What is your name?");
		nameField.setLayoutX(15);
		nameField.setLayoutY(50);
		nameField.setEditable(true);
		nameField.setStyle("-fx-border-color: black");

		ObservableList<String> options = 
				FXCollections.observableArrayList(
						"2022",
						"2023",
						"2024", 
						"2025", 
						"2026"
						);

		classOf = new ComboBox(options);
		classOf.setPromptText("Class of...");
		classOf.setLayoutX(15);
		classOf.setLayoutY(nameField.getLayoutY()+35);
		classOf.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");

		education = new Button("Education");
		education.setLayoutX(15);
		education.setLayoutY(classOf.getLayoutY()+35);
		education.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");

		experience = new Button("Experience");
		experience.setLayoutX(15);
		experience.setLayoutY(education.getLayoutY() + 35);
		experience.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");

		awards = new Button("Awards/Honors");
		awards.setLayoutX(15);
		awards.setLayoutY(experience.getLayoutY()+35);
		awards.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");

		volunteer = new Button("Volunteer Service");
		volunteer.setLayoutX(15);
		volunteer.setLayoutY(awards.getLayoutY()+35);
		volunteer.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");

		addSection = new TextField();
		addSection.setPromptText("Add section...");
		addSection.setLayoutX(15);
		addSection.setLayoutY(volunteer.getLayoutY()+35);
		addSection.setEditable(true);
		addSection.setStyle("-fx-border-color: black");

		buildResume = new Button("Finish Resume!");
		buildResume.setLayoutX(15);
		buildResume.setLayoutY(460);
		buildResume.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");

		backToMain = new Button("Back to main page");
		backToMain.setVisible(false);
		backToMain.setStyle("-fx-background-color: #ffffff; -fx-text-fill: black; -fx-border-color: black");



	}


}
