import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.Random;
import java.util.Scanner;

import javafx.scene.text.Text;


public class AreYouSmarterThanA260Student extends Application {
	
	//Declare buttons used in GUI 
	private Button play = new Button("Play");
	private Button playAgain = new Button("Play Again");
	private Button peek = new Button("Peek");
	private Button cheat = new Button("Cheat");
	private Button back = new Button("Back");
	private Button quit = new Button("Quit"); 
	private Button saveButton = new Button("Save");
	private Button continueCorrect = new Button("Continue"); 
	private Button continueCheatSave = new Button("Continue"); 
	private Button gameRules = new Button("Game Rules");  
	private Button useResponse = new Button("Use This Response");
	private Button differentAnswer = new Button("Choose different answer");
	private Button winContinue = new Button("Continue"); 
	private Button backStudent = new Button("Back"); 
	
	//Declare labels used in GUI 
	private Label splash = new Label("Are You Smarter Than a 260 Student?"); 
	private Label gameRulesTitle = new Label("Game Rules"); 
	private Label congratulations = new Label("Congratulations!"); 
	private Label youWon = new Label("You Won!"); 
	private Label drFodor = new Label("Dr. Fodor will be proud!"); 
	private Label haveFun = new Label("Have fun with your fake $1,000,000"); 
	private Label incorrect = new Label("Incorrect!"); 
	private Label useSave = new Label("Use save?"); 
	private Label noSaves = new Label("You have no more saves and have unfortunately lost the game!"); 
	private Label startStudying = new Label("Guess it's time for you to start studying!"); 
	private Label questionTitle = new Label("Select a Chapter To Answer a Question From"); 
	private Label peekTitle = new Label("Select a Student to Peek From");
	private Label cheatTitle = new Label("Select a Student to Cheat From");
	private Label saveTitle = new Label("Select a Student to Save You");
	private Label correct= new Label("Correct! "); 
	private Label questionWorth; 
	private Label currentEarningsTitle;
	private Label lily = new Label("This student has withdrawn and cannot answer the question, please select another student"); 
	private Label drFodorStudent = new Label("Dr. Fodor is not a student. Please select an actual student "); 

	//Declare text used in game 
	private Text gameRulesText = new Text("Object: Answer all ten questions \n correctly and win 1,000,000 (fake) dollars \n" + 
			"\n" + 
			"Directions: Answer one question from each \n selected chapter correctly. \n" + 
			"\n" + 
			"You are allowed one peek, cheat, and save each game. \n" + 
			"\n" + 
			"A peek can be used to see another student’s answer \n but you are not obligated to use that answer. \n" + 
			"\n" + 
			"A cheat forces you to directly copy another student's answer. \n" + 
			"\n" + 
			"A save is used when you answer a question incorrectly. \n If the student you chose answered the question \n correctly you can continue the game. "); 
	
	
	//Declare stack of integers for earnings 
	Stack <Integer> earnings = new Stack(); 
	
	private Integer totalWinnings; //Total player has one 
	private Integer  currentWinnings; //Amount question is worth 
	
	static Stack <Chapter> allChapters = new Stack(); //Stack of all chapters with questions and answers in them 
	
	//Declare buttons for Students 
	StudentButton buttonFarhan = new StudentButton("Farhan"); 
	StudentButton buttonHanna = new StudentButton("Hanna"); 
	StudentButton buttonGiorgian = new StudentButton("Giorgian");  
	StudentButton buttonTian = new StudentButton("Tian"); 
	StudentButton buttonJasmine = new StudentButton("Jasmine"); 
	StudentButton buttonJoeyC = new StudentButton("Joey C"); 
	StudentButton buttonDaniel = new StudentButton("Daniel"); 
	StudentButton buttonJeremy = new StudentButton("Jeremy"); 
	StudentButton buttonJoeyJ = new StudentButton("Joey J"); 
	StudentButton buttonEric = new StudentButton("Eric"); 
	StudentButton buttonDarren = new StudentButton("Darren"); 
	StudentButton buttonBrendan = new StudentButton("Brendan"); 
	StudentButton buttonJihu = new StudentButton("Jihu"); 
	StudentButton buttonChayenne = new StudentButton("Chayenne"); 
	StudentButton buttonTyler = new StudentButton("Tyler"); 
	StudentButton buttonSylvi = new StudentButton("Sylvi"); 
	StudentButton buttonRachel = new StudentButton("Rachel"); 
	StudentButton buttonJimmy = new StudentButton("Jimmy"); 
	StudentButton buttonYang = new StudentButton("Yang");  
	StudentButton buttonPeter = new StudentButton("Peter"); 
	StudentButton buttonOlga = new StudentButton("Olga"); 
	StudentButton buttonLillian = new StudentButton("Lillian"); 
	StudentButton buttonEverett = new StudentButton("Everett"); 
	StudentButton buttonDrFodor = new StudentButton("Dr. Fodor"); 
	
	
	//Declare answers for questions 
	Answer[] answersCH1Q1 = { new Answer(true, "Hardware"),  new Answer(false, "Software"), new Answer(false, "Operating system"), new Answer(false, "Application Program")};
	Answer[] answersCH2Q1 = { new Answer(false, "Java program"),  new Answer(false, "A Java Statement"), new Answer(true, "Pseudocode"), new Answer(false, "A flowchart diagram")};
	Answer[] answersCH3Q1 = { new Answer(false, "<"),  new Answer(true, "<="), new Answer(false, "=<"), new Answer(false, "<<")};
	Answer[] answersCH4Q1 = { new Answer(false, "3.0"),  new Answer(false, "3"), new Answer(true, "4"), new Answer(false, "4.0")};
	Answer[] answersCH5Q1 = { new Answer(false, "8"),  new Answer(false, "9"), new Answer(true, "10"), new Answer(false, "11")};
	Answer[] answersCH6Q1 = { new Answer(true, "void"),  new Answer(false, "int"), new Answer(false, "double"), new Answer(false, "public")};
	Answer[] answersCH7Q1 = { new Answer(true, "a[2]"),  new Answer(false, "a[3]"), new Answer(false, "a[4]"), new Answer(false, "a(3)")};
	Answer[] answersCH8Q1 = { new Answer(false, "char[][] charArray \n = {'a', 'b'};"),  new Answer(false, "char[2][2] charArray \n= {{'a', 'b'}, {'c', 'd'}};"), new Answer(false, "char[2][] charArray \n = {{'a', 'b'}, {'c', 'd'}};"), new Answer(true, "char[][] charArray \n = {{'a', 'b'}, {'c', 'd'}};")};
	Answer[] answersCH9Q1 = { new Answer(false, "A class"),  new Answer(true, "An object"), new Answer(false, "A method"), new Answer(false, "A data field")};
	Answer[] answersCH10Q1 = { new Answer(true, "An empty diamond"),  new Answer(false, "A solid diamond"), new Answer(false, "An empty oval"), new Answer(false, "A solid oval")};
	Answer[] answersCH11Q1 = { new Answer(false, "encapsulation"),  new Answer(true, "inheritance"), new Answer(false, "abstraction"), new Answer(false, "generalization")};
	Answer[] answersCH12Q1 = { new Answer(false, "RuntimeException"),  new Answer(false, "Exception"), new Answer(false, "Error"), new Answer(true, "Throwable")};
	Answer[] answersCH13Q1 = { new Answer(false, "class A { abstract \n void unfinished() { } }"),  new Answer(false, "class A { abstract \n void unfinished(); }"), new Answer(true, "abstract class A { abstract \n void unfinished(); }"), new Answer(false, "public class abstract \n A { abstract void unfinished(); }")};
	Answer[] answersCH14Q1 = { new Answer(true, "A Node can be \n placed in a Pane."),  new Answer(false, "A Node can be \n placed in a Scene."), new Answer(false, "A Pane can be \n placed in a Control."), new Answer(false, " A Shape can be placed \n  in a Control.")};
	Answer[] answersCH15Q1 = { new Answer(false, "ActionEvent"),  new Answer(false, "Action"), new Answer(false, "EventHandler"), new Answer(true, "EventHandler<ActionEvent>")};
	Answer[] answersCH16Q1 = { new Answer(false, " new Labelled();"),  new Answer(false, "new Label();"), new Answer(false, " new Labelled(text);"), new Answer(true, " new Label(text);")};
	Answer[] answersCH17Q1 = { new Answer(false, "length()"),  new Answer(true, "available()"), new Answer(false, "size()"), new Answer(false, "getSize()")};
	Answer[] answersCH18Q1 = { new Answer(false, " n > 0"),  new Answer(true, "n <= 0"), new Answer(false, "no base cases"), new Answer(false, "n < 0")};
	Answer[] answersCH19Q1 = { new Answer(false, " <String>"),  new Answer(false, "<?>"), new Answer(true, "<Date>"), new Answer(false, "<E>")};
	Answer[] answersCH20Q1 = { new Answer(false, "the Cloneable \n interface"),  new Answer(true, "the Serializable \n interfaces"), new Answer(false, "the Comparable \n interface"), new Answer(false, "the Comparator \n interface")};
	Answer[] answersCH21Q1 = { new Answer(true, "Set"),  new Answer(false, "List"), new Answer(false, "Vector"), new Answer(false, "Stack")};
	Answer[] answersCH22Q1 = { new Answer(false, "the whole list"),  new Answer(true, "half of the list"), new Answer(false, "just one element in the list"), new Answer(false, "one fourth of the list")};
	Answer[] answersCH23Q1 = { new Answer(false, "O(1)"),  new Answer(false, "O(logn)"), new Answer(true, "O(n)"), new Answer(false, "O(nlogn)")};
	Answer[] answersCH24Q1 = { new Answer(true,  "A list"),  new Answer(false, "A set"), new Answer(false, "A tree"), new Answer(false, "A stack")};
	Answer[] answersCH25Q1 = { new Answer(true, "length"),  new Answer(false, "depth"), new Answer(false, "height"), new Answer(false, "degree")};
	Answer[] answersCH26Q1 = { new Answer(true, "balance factor"),  new Answer(false, "depth"), new Answer(false, "length"), new Answer(false, "degree")};
	Answer[] answersCH27Q1 = { new Answer(false, "byte"),  new Answer(false, "short"), new Answer(true, "int"), new Answer(false, "long")};
	
	//Declare questions 
	Question questionCH1Q1 = new Question("_____ is the physical aspect of the computer.", answersCH1Q1); 
	Question questionCH2Q1 = new Question("_______ is the code with natural language mixed with Java code", answersCH2Q1); 
	Question questionCH3Q1 = new Question("The \"less than or equal to\" comparison operator in Java is __________.", answersCH3Q1); 
	Question questionCH4Q1 = new Question("What is Math.round(3.6)?", answersCH4Q1); 
	Question questionCH5Q1 = new Question("How many times will the following code print \"Welcome to Java\"?\n" + 
			"\n" + 
			"int count = 0;\n" + 
			"while (count < 10) {\n" + 
			"  System.out.println(\"Welcome to Java\");\n" + 
			"  count++;\n" + 
			"}.", answersCH5Q1); 
	Question questionCH6Q1 = new Question("Suppose your method does not return any value, which of the following keywords can be used as a return type?", answersCH6Q1); 
	Question questionCH7Q1 = new Question("What is the representation of the third element in an array called a?.", answersCH7Q1); 
	Question questionCH8Q1 = new Question("Which of the following statements are correct?", answersCH8Q1); 
	Question questionCH9Q1 = new Question(" __________ represents an entity in the real world that can be distinctly identified.", answersCH9Q1); 
	Question questionCH10Q1 = new Question(" ___________ is attached to the class of the composing class to denote the \n aggregation relationship with the composed object.", answersCH10Q1); 
	Question questionCH11Q1 = new Question("Object-oriented programming allows you to derive new classes from existing classes. This is called ____________.", answersCH11Q1); 
	Question questionCH12Q1 = new Question("A Java exception is an instance of __________", answersCH12Q1); 
	Question questionCH13Q1 = new Question("Which of the following class definitions defines a legal abstract class?", answersCH13Q1); 
	Question questionCH14Q1 = new Question("Which of the following statements are true", answersCH14Q1); 
	Question questionCH15Q1 = new Question("A JavaFX action event handler is an instance of _______", answersCH15Q1); 
	Question questionCH16Q1 = new Question("To create a label with the specified text, use __________", answersCH16Q1); 
	Question questionCH17Q1 = new Question("Which method can you use to find out the number of the bytes in a file using InputStream?", answersCH17Q1); 
	Question questionCH18Q1 = new Question("What are the base cases in the following recursive method? \n public static void xMethod(int n) {\n" + 
			"    if (n > 0) {\n" + 
			"      System.out.print(n % 10);\n" + 
			"      xMethod(n / 10);\n" + 
			"    }\n" + 
			"  }", answersCH18Q1); 
	Question questionCH19Q1 = new Question("Fill in the code in Comparable______ c = new Date();", answersCH19Q1); 
	Question questionCH20Q1 = new Question("All the concrete classes in the Java Collections Framework implement _____________", answersCH20Q1); 
	Question questionCH21Q1 = new Question("Which of the data types below does not allow duplicates?", answersCH21Q1); 
	Question questionCH22Q1 = new Question("On an average, linear search searches ", answersCH22Q1); 
	Question questionCH23Q1 = new Question("The best-time complexity for insertion sort is _____________", answersCH23Q1); 
	Question questionCH24Q1 = new Question("________ is a data structure to store data in sequential order", answersCH24Q1); 
	Question questionCH25Q1 = new Question("The ________ of a path is the number of the edges in the path", answersCH25Q1); 
	Question questionCH26Q1 = new Question("The _________ of a node is the height of its right subtree minus the height of its left subtree", answersCH26Q1); 
	Question questionCH27Q1 = new Question("What is the return type value for the hashCode() method?", answersCH27Q1); 
	
	//Define stakcs of questions 
	static Stack <Question> questionsCh1 = new Stack(); 
	Stack <Question> questionsCh2 = new Stack();  
	Stack <Question> questionsCh3 = new Stack();  
	Stack <Question> questionsCh4 = new Stack(); 
	Stack <Question> questionsCh5 = new Stack(); 
	Stack <Question> questionsCh6 = new Stack(); 
	Stack <Question> questionsCh7 = new Stack(); 
	Stack <Question> questionsCh8 = new Stack(); 
	Stack <Question> questionsCh9 = new Stack(); 
	Stack <Question> questionsCh10 = new Stack(); 
	Stack <Question> questionsCh11 = new Stack(); 
	Stack <Question> questionsCh12 = new Stack(); 
	Stack <Question> questionsCh13 = new Stack(); 
	Stack <Question> questionsCh14 = new Stack(); 
	Stack <Question> questionsCh15 = new Stack(); 
	Stack <Question> questionsCh16 = new Stack(); 
	Stack <Question> questionsCh17 = new Stack(); 
	Stack <Question> questionsCh18 = new Stack(); 
	Stack <Question> questionsCh19 = new Stack(); 
	Stack <Question> questionsCh20 = new Stack(); 
	Stack <Question> questionsCh21 = new Stack(); 
	Stack <Question> questionsCh22 = new Stack(); 
	Stack <Question> questionsCh23 = new Stack(); 
	Stack <Question> questionsCh24 = new Stack(); 
	Stack <Question> questionsCh25 = new Stack(); 
	Stack <Question> questionsCh26 = new Stack(); 
	Stack <Question> questionsCh27= new Stack(); 
	
	//Add stacks of questions to Chapters 
	Chapter chapter1 = new Chapter("Chapter 1", false, questionsCh1); 
	Chapter chapter2 = new Chapter("Chapter 2", false, questionsCh2); 
	Chapter chapter3 = new Chapter("Chapter 3", false, questionsCh3); 
	Chapter chapter4 = new Chapter("Chapter 4", false, questionsCh4); 
	Chapter chapter5 = new Chapter("Chapter 5", false, questionsCh5); 
	Chapter chapter6 = new Chapter("Chapter 6", false, questionsCh6); 
	Chapter chapter7 = new Chapter("Chapter 7", false, questionsCh7); 
	Chapter chapter8 = new Chapter("Chapter 8", false, questionsCh8); 
	Chapter chapter9 = new Chapter("Chapter 9", false, questionsCh9); 
	Chapter chapter10 = new Chapter("Chapter 10", false, questionsCh10); 
	Chapter chapter11 = new Chapter("Chapter 11", false, questionsCh11); 
	Chapter chapter12 = new Chapter("Chapter 12", false, questionsCh12); 
	Chapter chapter13 = new Chapter("Chapter 13", false, questionsCh13); 
	Chapter chapter14 = new Chapter("Chapter 14", false, questionsCh14); 
	Chapter chapter15 = new Chapter("Chapter 15", false, questionsCh15); 
	Chapter chapter16 = new Chapter("Chapter 16", false, questionsCh16); 
	Chapter chapter17 = new Chapter("Chapter 17", false, questionsCh17); 
	Chapter chapter18 = new Chapter("Chapter 18", false, questionsCh18); 
	Chapter chapter19 = new Chapter("Chapter 19", false, questionsCh19); 
	Chapter chapter20 = new Chapter("Chapter 20", false, questionsCh20); 
	Chapter chapter21 = new Chapter("Chapter 21", false, questionsCh21); 
	Chapter chapter22 = new Chapter("Chapter 22", false, questionsCh22); 
	Chapter chapter23 = new Chapter("Chapter 23", false, questionsCh23); 
	Chapter chapter24 = new Chapter("Chapter 24", false, questionsCh24); 
	Chapter chapter25 = new Chapter("Chapter 25", false, questionsCh25); 
	Chapter chapter26 = new Chapter("Chapter 26", false, questionsCh26); 
	Chapter chapter27 = new Chapter("Chapter 27", false, questionsCh27); 
	
	//Declare random chapters 
	Chapter chapterA; 
	Chapter chapterB; 
	Chapter chapterC; 
	Chapter chapterD;
	Chapter chapterE;
	Chapter chapterF;
	Chapter chapterG; 
	Chapter chapterH;
	Chapter chapterI;
	Chapter chapterJ; 
	
	//Create a current question 
	CurrentQuestion currentQuestion = new CurrentQuestion(); 
	
	//Create a a help selected 
	HelpSelected typeOfHelp = new HelpSelected(); 
	
	//Create an answer chosen 
	AnswerChosen answerChosen = new AnswerChosen(); 
	
	
	//Reaction when student button is pressed
	public Scene studentButtonPressed(Question ChA, Question ChB, Question ChC, Question ChD, Question ChE, 
			Question ChF, Question ChG, Question ChH, Question ChI, Question ChJ, int truth ) { 
		int n = 0; 
		if (typeOfHelp.getTypeOfHelp()=='P') {
	
			if(currentQuestion.getCurrentQuestion()=='A') {
				
				do  {
					answerChosen.setAnswer(ChA.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
				
			}
			else if(currentQuestion.getCurrentQuestion()=='B') {

				do  {
					answerChosen.setAnswer(ChB.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='C') {

				do  {
					answerChosen.setAnswer(ChC.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='D') {
				do  {
					answerChosen.setAnswer(ChD.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='E') {
				do  {
					answerChosen.setAnswer(ChE.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='F') {
				do  {
					answerChosen.setAnswer(ChF.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='G') {
				do  {
					answerChosen.setAnswer(ChG.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='H') {
				do  {
					answerChosen.setAnswer(ChH.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='I') {
				do  {
					answerChosen.setAnswer(ChI.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='J') {
				do  {
					answerChosen.setAnswer(ChJ.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			
			HBox hbox = new HBox(1); 
			HBox hbox2 = new HBox(50);
			Label answerChosenText = new Label("The answer this student chose was " + answerChosen.getText()); 
			answerChosenText.setFont(new Font("Chalkboard", 30));
			hbox.getChildren().addAll(answerChosenText); 
			hbox.setAlignment(Pos.CENTER);
			hbox2.getChildren().addAll(useResponse, differentAnswer); 
			hbox2.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane();  
			pane.setCenter(hbox);
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setBottom(hbox2);
			Scene answerPeek = new Scene(pane, 1000, 750); 
			return answerPeek; 
			
		}
		
		else  {
			Random rand = new Random(); 
	
			if(currentQuestion.getCurrentQuestion()=='A') {
				do  {
					answerChosen.setAnswer(ChA.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='B') {
				do  {
					answerChosen.setAnswer(ChB.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='C') {
				do  {
					answerChosen.setAnswer(ChC.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='D') {
				do  {
					answerChosen.setAnswer(ChD.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='E') {
				do  {
					answerChosen.setAnswer(ChE.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='F') {
				do  {
					answerChosen.setAnswer(ChF.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 		
			}
			else if(currentQuestion.getCurrentQuestion()=='G') {
				do  {
					answerChosen.setAnswer(ChG.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='H') {
				do  {
					answerChosen.setAnswer(ChH.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='I') {
				do  {
					answerChosen.setAnswer(ChI.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			else if(currentQuestion.getCurrentQuestion()=='J') {
				do  {
					answerChosen.setAnswer(ChJ.answers[n]);	
					n++; 
				} while(n<truth && answerChosen.getTruth()!=true); 
			}
			
			HBox hbox = new HBox(1); 
			HBox hbox2 = new HBox(50);
			Label answerChosenText = new Label("The answer this student chose was " + answerChosen.getText()); 
			answerChosenText.setFont(new Font("Chalkboard", 30));
			hbox.getChildren().addAll(answerChosenText); 
			hbox.setAlignment(Pos.CENTER);
			hbox2.getChildren().addAll(continueCheatSave); 
			hbox2.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane();  
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(hbox);
			pane.setBottom(hbox2);
			Scene answerPeek = new Scene(pane, 1000, 750); 
			return answerPeek; 
			
		}
	}
	
	
	//Reaction when question is selected
	public Scene questionSelection(Chapter chapter, Button button1, Button button2, Button button3, Button button4, Question question) { 
		chapter.setUsed(true);
		if(chapter.equals(chapterA)) { 
		currentQuestion.setCurrentQuestion('A');
		} 
		else if(chapter.equals(chapterB)) { 
			currentQuestion.setCurrentQuestion('B');
			} 
		else if(chapter.equals(chapterC)) { 
			currentQuestion.setCurrentQuestion('C');
			} 
		else if(chapter.equals(chapterD)) { 
			currentQuestion.setCurrentQuestion('D');
			} 
		else if(chapter.equals(chapterE)) { 
			currentQuestion.setCurrentQuestion('E');
			} 
		else if(chapter.equals(chapterF)) { 
			currentQuestion.setCurrentQuestion('F');
			} 
		else if(chapter.equals(chapterG)) { 
			currentQuestion.setCurrentQuestion('G');
			} 
		else if(chapter.equals(chapterH)) { 
			currentQuestion.setCurrentQuestion('H');
			} 
		else if(chapter.equals(chapterI)) { 
			currentQuestion.setCurrentQuestion('I');
			} 
		else if(chapter.equals(chapterJ)) { 
			currentQuestion.setCurrentQuestion('J');
			} 
		HBox questionTitleBox = new HBox(5); 
		Label questionTitle = new Label(question.getQuestion());
		questionTitle.setFont(new Font("Chalkboard", 50));
		questionTitle.setWrapText(true);
		questionTitleBox.getChildren().addAll(questionTitle); 
		questionTitleBox.setAlignment(Pos.CENTER);
		VBox vbox1 = new VBox(5); 
		VBox vbox2 = new VBox(5); 
		HBox hbox = new HBox(5); 
		vbox1.getChildren().addAll(button1, button2); 
		vbox2.getChildren().addAll(button3, button4);
		hbox.getChildren().addAll(vbox1, vbox2); 
		hbox.setAlignment(Pos.CENTER);
		HBox hbox2 = new HBox(100); 
		hbox2.getChildren().addAll(peek, cheat); 
		hbox2.setAlignment(Pos.CENTER); 
		BorderPane pane = new BorderPane(); 
		pane.setStyle("-fx-background-color: #3e8446" ); 
		pane.setTop(questionTitleBox); 
		pane.setCenter(hbox);
		pane.setBottom(hbox2);
		Scene questionScene = new Scene(pane, 1000, 750); 
		return questionScene;  
	} 
	
	//Reaction when an answer is selected
	public Scene answerSelection(Answer answer, Chapter chapterA, Chapter chapterB, Chapter chapterC, Chapter chapterD,
			Chapter chapterE, Chapter chapterF, Chapter chapterG, Chapter chapterH, Chapter chapterI, Chapter chapterJ, Save save) { 
	if(answer.getTruth()==true && chapterA.getUsed()==true && chapterB.getUsed()==true &&
			chapterC.getUsed()==true && chapterD.getUsed()==true && 
			chapterE.getUsed()==true && chapterF.getUsed()==true && 
			chapterG.getUsed()==true &&  chapterH.getUsed()==true && 
			chapterI.getUsed()==true && chapterJ.getUsed()==true) { 
			VBox vbox = new VBox(10); 
			vbox.getChildren().addAll(congratulations, youWon, drFodor, haveFun); 
			HBox hbox = new HBox(10); 
			hbox.getChildren().addAll(quit, playAgain); 
			hbox.setAlignment(Pos.CENTER);
			vbox.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			pane.setBottom(hbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene; 
			
		}
		else if (answer.getTruth()==true) { 
			Label youWon= new Label("You won $" + currentWinnings ); 
			totalWinnings+=currentWinnings; 
			currentWinnings = earnings.pop(); 
			youWon.setFont(new Font("Chalkboard", 30));
			VBox vbox = new VBox(10); 
			vbox.getChildren().addAll(correct, youWon, continueCorrect); 
			vbox.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene; 
		}
		
		else if (save.getUsed()==false && answer.getTruth()==false) { 
			VBox vbox = new VBox(10); 
			vbox.getChildren().addAll(incorrect, useSave, saveButton); 
			vbox.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene; 	
			
		}
		
		else  { 
			VBox vbox = new VBox(10); 
			Label correctAnswer = new Label("The correct answer was: " + answer.getText()); 
			Label youEarned = new Label("You earned " + totalWinnings + " fake dollars."); 
			youEarned.setFont(new Font("Chalkboard", 30));
			vbox.getChildren().addAll(incorrect, noSaves, youEarned, startStudying); 
			HBox hbox = new HBox(50); 
			hbox.getChildren().addAll(quit, playAgain); 
			hbox.setAlignment(Pos.CENTER); 
			vbox.setAlignment(Pos.CENTER);
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			pane.setBottom(hbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene;
		}
					
	} 
	
	//Reaction when an answer is selected
	public Scene answerSelection(AnswerChosen answer, Chapter chapterA, Chapter chapterB, Chapter chapterC, Chapter chapterD,
			Chapter chapterE, Chapter chapterF, Chapter chapterG, Chapter chapterH, Chapter chapterI, Chapter chapterJ, Save save) { 
	if(answer.getTruth()==true && chapterA.getUsed()==true && chapterB.getUsed()==true &&
			chapterC.getUsed()==true && chapterD.getUsed()==true && 
			chapterE.getUsed()==true && chapterF.getUsed()==true && 
			chapterG.getUsed()==true &&  chapterH.getUsed()==true && 
			chapterI.getUsed()==true && chapterJ.getUsed()==true) { 
			VBox vbox = new VBox(10); 
			vbox.getChildren().addAll(congratulations, youWon, drFodor, haveFun); 
			HBox hbox = new HBox(10); 
			hbox.getChildren().addAll(quit, playAgain); 
			hbox.setAlignment(Pos.CENTER);
			vbox.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			pane.setBottom(hbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene; 
			
		}
		else if (answer.getTruth()==true) { 
			Label youWon= new Label("You won $" + currentWinnings ); 
			totalWinnings+=currentWinnings; 
			currentWinnings = earnings.pop(); 
			youWon.setFont(new Font("Chalkboard", 30));
			VBox vbox = new VBox(10); 
			vbox.getChildren().addAll(correct, youWon, continueCorrect); 
			vbox.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene; 
		}
		
		else if (save.getUsed()==false && answer.getTruth()==false) { 
			VBox vbox = new VBox(10); 
			vbox.getChildren().addAll(incorrect, useSave, saveButton); 
			vbox.setAlignment(Pos.CENTER); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene; 	
			
		}
		
		else  { 
			VBox vbox = new VBox(10); 
			Label correctAnswer = new Label("The correct answer was: " + answer.getText()); 
			Label youEarned = new Label("You earned " + totalWinnings + " fake dollars."); 
			youEarned.setFont(new Font("Chalkboard", 30));
			vbox.getChildren().addAll(incorrect, noSaves, youEarned, startStudying); 
			HBox hbox = new HBox(50); 
			hbox.getChildren().addAll(quit, playAgain); 
			hbox.setAlignment(Pos.CENTER); 
			vbox.setAlignment(Pos.CENTER);
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox);
			pane.setBottom(hbox);
			Scene questionScene = new Scene(pane, 1000, 750); 
			return questionScene;
		}
					
	} 
	
	
	
	//Reaction when different answer is selected for peek
	public Scene differentAnswerSelection (Question chapter, Button answer1, Button answer2, Button answer3, Button answer4) { 
	
	HBox questionTitleBox = new HBox(5); 
	Label questionTitle = new Label(chapter.getQuestion()); 
	questionTitle.setFont(new Font("Chalkboard", 40));
	questionTitleBox.getChildren().addAll(questionTitle); 
	questionTitleBox.setAlignment(Pos.CENTER);
	VBox vbox1 = new VBox(5); 
	VBox vbox2 = new VBox(5); 
	HBox hbox = new HBox(5); 
	vbox1.getChildren().addAll(answer1, answer2); 
	vbox2.getChildren().addAll(answer3, answer4);
	hbox.getChildren().addAll(vbox1, vbox2); 
	hbox.setAlignment(Pos.CENTER);
	HBox hbox2 = new HBox(100); 
	hbox2.getChildren().addAll(peek, cheat); 
	hbox2.setAlignment(Pos.CENTER); 
	BorderPane pane = new BorderPane(); 
	pane.setStyle("-fx-background-color: #3e8446" ); 
	pane.setTop(questionTitleBox); 
	pane.setCenter(hbox);
	pane.setBottom(hbox2);
	Scene questionScene = new Scene(pane, 1000, 750); 
	return questionScene; 
	} 
	
	public Scene displayStudent() { 
	HBox hbox1 = new HBox(5); 
	if(typeOfHelp.getTypeOfHelp()=='P') { 
	hbox1.getChildren().addAll(peekTitle); 
	} 
	if(typeOfHelp.getTypeOfHelp()=='C') { 
		hbox1.getChildren().addAll(cheatTitle); 
	}
	if(typeOfHelp.getTypeOfHelp()=='S') { 
		hbox1.getChildren().addAll(saveTitle); 
	}
	VBox vbox1 = new VBox(1);
	vbox1.getChildren().addAll(buttonFarhan, buttonOlga, buttonHanna, buttonGiorgian);
	VBox vbox2 = new VBox(1);
	vbox2.getChildren().addAll(buttonTian, buttonJasmine, buttonJoeyC, buttonDaniel);
	VBox vbox3 = new VBox(1); 	
	vbox3.getChildren().addAll(buttonJeremy, buttonJoeyJ, buttonEric, buttonDarren);
	VBox vbox4 = new VBox(1); 	
	vbox4.getChildren().addAll(buttonDrFodor, buttonJihu, buttonChayenne, buttonTyler);
	VBox vbox5 = new VBox(1); 
	vbox5.getChildren().addAll(buttonSylvi, buttonRachel, buttonJimmy, buttonEverett);
	VBox vbox6 = new VBox(1); 	
	vbox6.getChildren().addAll(buttonYang, buttonPeter, buttonLillian, buttonBrendan);
	HBox hbox2 = new HBox(1); 
	hbox2.getChildren().addAll(vbox1, vbox2, vbox3, vbox4, vbox5, vbox6); 
	hbox1.setAlignment(Pos.CENTER);
	hbox2.setAlignment(Pos.CENTER);
	BorderPane pane = new BorderPane(); 
	pane.setStyle("-fx-background-color: #3e8446" ); 
	pane.setTop(hbox1); 
	pane.setCenter(hbox2);
	Scene studentScene = new Scene(pane, 1000, 750); 
	return studentScene; 
	} 
	
public void start(Stage primaryStage) throws Exception {
	
		
		//Push questions onto stack for each chapter 
		chapter1.questionsArray.push(questionCH1Q1); 
		chapter2.questionsArray.push(questionCH2Q1); 
		chapter3.questionsArray.push(questionCH3Q1); 
		chapter4.questionsArray.push(questionCH4Q1); 
		chapter5.questionsArray.push(questionCH5Q1); 
		chapter6.questionsArray.push(questionCH6Q1); 
		chapter7.questionsArray.push(questionCH7Q1); 
		chapter8.questionsArray.push(questionCH8Q1); 
		chapter9.questionsArray.push(questionCH9Q1); 
		chapter10.questionsArray.push(questionCH10Q1); 
		chapter11.questionsArray.push(questionCH11Q1); 
		chapter12.questionsArray.push(questionCH12Q1); 
		chapter13.questionsArray.push(questionCH13Q1); 
		chapter14.questionsArray.push(questionCH14Q1); 
		chapter15.questionsArray.push(questionCH15Q1); 
		chapter16.questionsArray.push(questionCH16Q1); 
		chapter17.questionsArray.push(questionCH17Q1); 
		chapter18.questionsArray.push(questionCH18Q1); 
		chapter19.questionsArray.push(questionCH19Q1); 
		chapter20.questionsArray.push(questionCH20Q1); 
		chapter21.questionsArray.push(questionCH21Q1); 
		chapter22.questionsArray.push(questionCH22Q1); 
		chapter23.questionsArray.push(questionCH23Q1); 
		chapter24.questionsArray.push(questionCH24Q1); 
		chapter25.questionsArray.push(questionCH25Q1); 
		chapter26.questionsArray.push(questionCH26Q1); 
		chapter27.questionsArray.push(questionCH27Q1); 
		
		//Shuffle questions in each chapter 
		Collections.shuffle(chapter1.questionsArray);
		Collections.shuffle(chapter2.questionsArray);
		Collections.shuffle(chapter3.questionsArray);
		Collections.shuffle(chapter4.questionsArray);
		Collections.shuffle(chapter5.questionsArray);
		Collections.shuffle(chapter6.questionsArray);
		Collections.shuffle(chapter7.questionsArray);
		Collections.shuffle(chapter8.questionsArray);
		Collections.shuffle(chapter9.questionsArray);
		Collections.shuffle(chapter10.questionsArray);
		Collections.shuffle(chapter11.questionsArray);
		Collections.shuffle(chapter12.questionsArray);
		Collections.shuffle(chapter13.questionsArray);
		Collections.shuffle(chapter14.questionsArray);
		Collections.shuffle(chapter15.questionsArray);
		Collections.shuffle(chapter16.questionsArray);
		Collections.shuffle(chapter17.questionsArray);
		Collections.shuffle(chapter18.questionsArray);
		Collections.shuffle(chapter19.questionsArray);
		Collections.shuffle(chapter20.questionsArray);
		Collections.shuffle(chapter21.questionsArray);
		Collections.shuffle(chapter22.questionsArray);
		Collections.shuffle(chapter23.questionsArray);
		Collections.shuffle(chapter24.questionsArray);
		Collections.shuffle(chapter25.questionsArray);
		Collections.shuffle(chapter26.questionsArray);
		Collections.shuffle(chapter27.questionsArray);
		
		//Add chapters to a stack of chapters 
		allChapters.push(chapter1); 
		allChapters.push(chapter2); 
		allChapters.push(chapter3); 
		allChapters.push(chapter4); 
		allChapters.push(chapter5); 
		allChapters.push(chapter6); 
		allChapters.push(chapter7); 
		allChapters.push(chapter8); 
		allChapters.push(chapter9); 
		allChapters.push(chapter10); 
		allChapters.push(chapter11); 
		allChapters.push(chapter12); 
		allChapters.push(chapter13); 
		allChapters.push(chapter14); 
		allChapters.push(chapter15); 
		allChapters.push(chapter16); 
		allChapters.push(chapter17); 
		allChapters.push(chapter18); 
		allChapters.push(chapter19); 
		allChapters.push(chapter20); 
		allChapters.push(chapter21); 
		allChapters.push(chapter22); 
		allChapters.push(chapter23); 
		allChapters.push(chapter24); 
		allChapters.push(chapter25); 
		allChapters.push(chapter26); 
		allChapters.push(chapter27); 
		
		//Shuffle all the chapters 
		Collections.shuffle(allChapters);

		//Assign random chapter to each button 
		chapterA = allChapters.pop(); 
		QuestionButton buttonChapterA = new QuestionButton(chapterA.getChapter()); 
		Question ChA = chapterA.questionsArray.pop();
		Answer ChAR1 = ChA.answers[0];
		Answer ChAR2 = ChA.answers[1];
		Answer ChAR3 = ChA.answers[2];
		Answer ChAR4 = ChA.answers[3];
		 
		chapterB = allChapters.pop(); 
		QuestionButton buttonChapterB = new QuestionButton(chapterB.getChapter());
		Question ChB = chapterB.questionsArray.pop();
		Answer ChBR1 = ChB.answers[0];
		Answer ChBR2 = ChB.answers[1];
		Answer ChBR3 = ChB.answers[2];
		Answer ChBR4 = ChB.answers[3];
 
		chapterC = allChapters.pop(); 
		QuestionButton buttonChapterC = new QuestionButton(chapterC.getChapter());
		Question ChC = chapterC.questionsArray.pop();
		Answer ChCR1 = ChC.answers[0];
		Answer ChCR2 = ChC.answers[1];
		Answer ChCR3 = ChC.answers[2];
		Answer ChCR4 = ChC.answers[3];
	
		chapterD = allChapters.pop(); 
		QuestionButton buttonChapterD = new QuestionButton(chapterD.getChapter());
		Question ChD = chapterD.questionsArray.pop();
		Answer ChDR1 = ChD.answers[0];
		Answer ChDR2 = ChD.answers[1];
		Answer ChDR3 = ChD.answers[2];
		Answer ChDR4 = ChD.answers[3];

		chapterE = allChapters.pop(); 
		QuestionButton buttonChapterE = new QuestionButton(chapterE.getChapter());
		Question ChE = chapterE.questionsArray.pop();
		Answer ChER1 = ChE.answers[0];
		Answer ChER2 = ChE.answers[1];
		Answer ChER3 = ChE.answers[2];
		Answer ChER4 = ChE.answers[3];
	
		chapterF = allChapters.pop(); 
		QuestionButton buttonChapterF = new QuestionButton(chapterF.getChapter());
		Question ChF = chapterF.questionsArray.pop();
		Answer ChFR1 = ChF.answers[0];
		Answer ChFR2 = ChF.answers[1];
		Answer ChFR3 = ChF.answers[2];
		Answer ChFR4 = ChF.answers[3];
	
		chapterG = allChapters.pop();
		QuestionButton buttonChapterG= new QuestionButton(chapterG.getChapter());
		Question ChG = chapterG.questionsArray.pop();
		Answer ChGR1 = ChG.answers[0];
		Answer ChGR2 = ChG.answers[1];
		Answer ChGR3 = ChG.answers[2];
		Answer ChGR4 = ChG.answers[3];
		
		chapterH = allChapters.pop();
		Question ChH = chapterH.questionsArray.pop();   
		QuestionButton buttonChapterH = new QuestionButton(chapterH.getChapter());
		Answer ChHR1 = ChH.answers[0];
		Answer ChHR2 = ChH.answers[1];
		Answer ChHR3 = ChH.answers[2];
		Answer ChHR4 = ChH.answers[3];
	
		chapterI = allChapters.pop(); 
	    Question ChI = chapterI.questionsArray.pop();
	    QuestionButton buttonChapterI = new QuestionButton(chapterI.getChapter()); 
		Answer ChIR1 = ChI.answers[0];
		Answer ChIR2 = ChI.answers[1];
		Answer ChIR3 = ChI.answers[2];
		Answer ChIR4 = ChI.answers[3];
		
		chapterJ = allChapters.pop(); 
		Question ChJ = chapterJ.questionsArray.pop();
		QuestionButton buttonChapterJ = new QuestionButton(chapterJ.getChapter());
		Answer ChJR1 = ChJ.answers[0];
		Answer ChJR2 = ChJ.answers[1];
		Answer ChJR3 = ChJ.answers[2];
		Answer ChJR4 = ChJ.answers[3];
		
		
		//Create a save
		Save save = new Save(); 
		save.setUsed(false);
		
		//Create a peak 
		Peek peekObject = new Peek(); 
		peekObject.setUsed(false);
		
		//Create a cheat 
		Cheat cheatObject = new Cheat(); 
		cheatObject.setUsed(false);
	
		
		
		//Declare answer buttons 
		AnswerButton answerA1 = new AnswerButton(ChAR1.getText()); 
		AnswerButton answerA2 = new AnswerButton(ChAR2.getText()); 
		AnswerButton answerA3 = new AnswerButton(ChAR3.getText()); 
		AnswerButton answerA4 = new AnswerButton(ChAR4.getText()); 
		
		AnswerButton answerB1 = new AnswerButton(ChBR1.getText()); 
		AnswerButton answerB2 = new AnswerButton(ChBR2.getText()); 
		AnswerButton answerB3 = new AnswerButton(ChBR3.getText()); 
		AnswerButton answerB4 = new AnswerButton(ChBR4.getText());
		
		AnswerButton answerC1 = new AnswerButton(ChCR1.getText()); 
		AnswerButton answerC2 = new AnswerButton(ChCR2.getText()); 
		AnswerButton answerC3 = new AnswerButton(ChCR3.getText()); 
		AnswerButton answerC4 = new AnswerButton(ChCR4.getText());
		
		AnswerButton answerD1 = new AnswerButton(ChDR1.getText()); 
		AnswerButton answerD2 = new AnswerButton(ChDR2.getText()); 
		AnswerButton answerD3 = new AnswerButton(ChDR3.getText()); 
		AnswerButton answerD4 = new AnswerButton(ChDR4.getText());

		AnswerButton answerE1 = new AnswerButton(ChER1.getText()); 
		AnswerButton answerE2 = new AnswerButton(ChER2.getText()); 
		AnswerButton answerE3 = new AnswerButton(ChER3.getText()); 
		AnswerButton answerE4 = new AnswerButton(ChER4.getText());
		
		AnswerButton answerF1 = new AnswerButton(ChFR1.getText()); 
		AnswerButton answerF2 = new AnswerButton(ChFR2.getText()); 
		AnswerButton answerF3 = new AnswerButton(ChFR3.getText()); 
		AnswerButton answerF4 = new AnswerButton(ChFR4.getText()); 
		
		AnswerButton answerG1 = new AnswerButton(ChGR1.getText()); 
		AnswerButton answerG2 = new AnswerButton(ChGR2.getText()); 
		AnswerButton answerG3 = new AnswerButton(ChGR3.getText()); 
		AnswerButton answerG4 = new AnswerButton(ChGR4.getText()); 
		
		AnswerButton answerH1 = new AnswerButton(ChHR1.getText()); 
		AnswerButton answerH2 = new AnswerButton(ChHR2.getText()); 
		AnswerButton answerH3 = new AnswerButton(ChHR3.getText()); 
		AnswerButton answerH4 = new AnswerButton(ChHR4.getText()); 
		
		AnswerButton answerI1 = new AnswerButton(ChIR1.getText()); 
		AnswerButton answerI2 = new AnswerButton(ChIR2.getText()); 
		AnswerButton answerI3 = new AnswerButton(ChIR3.getText()); 
		AnswerButton answerI4 = new AnswerButton(ChIR4.getText()); 
		
		AnswerButton answerJ1 = new AnswerButton(ChJR1.getText()); 
		AnswerButton answerJ2 = new AnswerButton(ChJR2.getText()); 
		AnswerButton answerJ3 = new AnswerButton(ChJR3.getText()); 
		AnswerButton answerJ4 = new AnswerButton(ChJR4.getText()); 
		
		//Push each question's winnings into earnings stack 
		earnings.push(500000); 
		earnings.push(250000); 
		earnings.push(150000); 
		earnings.push(50000); 
		earnings.push(25000); 
		earnings.push(15000); 
		earnings.push(5000); 
		earnings.push(3000); 
		earnings.push(1000); 
		earnings.push(1000); 
		
		totalWinnings = 0; //total winnings is 0 at beginning 
		
		currentWinnings = earnings.pop();//amount first question is worth 
		
		//Set button styles 
		
		back.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		backStudent.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		quit.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		play.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		gameRules.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		playAgain.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		peek.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");
		cheat.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		saveButton.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		continueCorrect.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		continueCheatSave.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;");  
		useResponse.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		differentAnswer.setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		
		
	
		//Set style for Labels 
		lily.setFont(new Font("Chalkboard", 46));
		lily.setWrapText(true); 
		drFodorStudent.setFont(new Font("Chalkboard", 30));
		drFodorStudent.setWrapText(true); 
		splash.setFont(new Font("Chalkboard", 50));
		gameRulesTitle.setFont(new Font("Chalkboard", 50));
		congratulations.setFont(new Font("Chalkboard", 70));
		youWon.setFont(new Font("Chalkboard", 50));
		drFodor.setFont(new Font("Chalkboard", 50));
		haveFun.setFont(new Font("Chalkboard", 50)); 
		questionTitle.setFont(new Font("Chalkboard", 40)); 
		useSave.setFont(new Font("Chalkboard", 40));
		noSaves.setFont(new Font("Chalkboard", 50));
		startStudying.setFont(new Font("Chalkboard", 40));
		peekTitle.setFont(new Font("Chalkboard", 50));
		cheatTitle.setFont(new Font("Chalkboard", 50));
		saveTitle.setFont(new Font("Chalkboard", 50));
		correct.setFont(new Font("Chalkboard", 70));
		incorrect.setFont(new Font("Chalkboard", 70));
		noSaves.setWrapText(true);
		noSaves.setAlignment(Pos.CENTER);
		
		//Set style for text 
		gameRulesText.setFont(new Font("Chalkboard", 30));
		
	
		
		//Button to restart game 
		playAgain.setOnAction(e -> {
			chapterA.setUsed(false); 
			chapterB.setUsed(false); 
			chapterC.setUsed(false); 
			chapterD.setUsed(false); 
			chapterE.setUsed(false); 
			chapterF.setUsed(false); 
			chapterG.setUsed(false); 
			chapterH.setUsed(false); 
			chapterI.setUsed(false); 
			chapterJ.setUsed(false); 
			
			try {
				start(primaryStage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();			} 
			
			
		}); 
		
	
		//Button to start game 
		play.setOnAction(e-> {
			
			HBox currentEarnings = new HBox(5); 
			currentEarningsTitle = new Label("Your Current Earnings $ " + totalWinnings); 
			currentEarningsTitle.setFont(new Font("Chalkboard", 30));
			currentEarnings.getChildren().addAll(currentEarningsTitle); 
			currentEarnings.setAlignment(Pos.CENTER); 
			VBox questions1 = new VBox(5);
			VBox questions2 = new VBox(5); 
			VBox selectQuestionTitle = new VBox(5); 
			questionWorth = new Label("This Question is Worth $ " + currentWinnings); 
			questionWorth.setFont(new Font("Chalkboard", 30));
			selectQuestionTitle.getChildren().addAll(questionTitle, questionWorth); 
			selectQuestionTitle.setAlignment(Pos.CENTER); 
			questions1.getChildren().addAll(buttonChapterA, buttonChapterB, buttonChapterC, buttonChapterD, buttonChapterE); 
			questions2.getChildren().addAll(buttonChapterF, buttonChapterG, buttonChapterH, buttonChapterI, buttonChapterJ); 
			HBox questionsAll = new HBox(10); 
			questionsAll.setAlignment(Pos.CENTER); 
			questionsAll.getChildren().addAll(questions1, questions2); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(questionsAll);
			pane.setTop(selectQuestionTitle);
			pane.setBottom(currentEarnings); 
			Scene newScene = new Scene(pane, 1000, 750); 
			primaryStage.setScene(newScene); 
			
		});
		
		//Button to quit game 
		quit.setOnAction(e-> { 
			 
		        System.exit(0);
		}); 
		
		
		//Button to explain game rules 
		gameRules.setOnAction(e-> {
			
			HBox gameRulesTitleBox = new HBox(5); 
			gameRulesTitleBox.getChildren().addAll(gameRulesTitle); 
			gameRulesTitleBox.setAlignment(Pos.CENTER);
			HBox hbox = new HBox(5); 
			hbox.setAlignment(Pos.CENTER);
			hbox.getChildren().addAll(back); 
			HBox hbox2 = new HBox(5); 
			hbox2.getChildren().addAll(gameRulesText);
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(hbox2);
			pane.setBottom(hbox); 
			pane.setTop(gameRulesTitleBox); 
			
			
			Scene rulesScene = new Scene(pane, 1000, 750); 
			primaryStage.setScene(rulesScene); 
			
		});
		
		//Continue game if answer is correct
		continueCorrect.setOnAction(e-> {
			HBox currentEarnings = new HBox(5); 
			currentEarningsTitle = new Label("Your Current Earnings $ " + totalWinnings);
			currentEarningsTitle.setFont(new Font("Chalkboard", 30));
			currentEarnings.getChildren().addAll(currentEarningsTitle); 
			currentEarnings.setAlignment(Pos.CENTER); 
			VBox questions1 = new VBox(5);
			VBox questions2 = new VBox(5); 
			VBox selectQuestionTitle = new VBox(5); 
			questionWorth = new Label("This Question is Worth $ " + currentWinnings); 
			questionWorth.setFont(new Font("Chalkboard", 30));
			selectQuestionTitle.getChildren().addAll(questionTitle, questionWorth); 
			selectQuestionTitle.setAlignment(Pos.CENTER); 
			questions1.getChildren().addAll(buttonChapterA, buttonChapterB, buttonChapterC, buttonChapterD, buttonChapterE); 
			questions2.getChildren().addAll(buttonChapterF, buttonChapterG, buttonChapterH, buttonChapterI, buttonChapterJ); 
			HBox questionsAll = new HBox(10); 
			questionsAll.setAlignment(Pos.CENTER); 
			questionsAll.getChildren().addAll(questions1, questions2); 
			BorderPane pane = new BorderPane(); 
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(questionsAll);
			pane.setTop(selectQuestionTitle);
			pane.setBottom(currentEarnings); 
			Scene newScene = new Scene(pane, 1000, 750); 
			primaryStage.setScene(newScene); 
			
		}); 
	
		
		//Button when player decides to peek 
		peek.setOnAction(e->{ 
		if (peekObject.getUsed()==false) { 
		peekObject.setUsed(true);
		typeOfHelp.setHelpSelected('P');
		primaryStage.setScene(displayStudent()); 
		} 
		}); ;
		
		//Button when player decides to peek 
		cheat.setOnAction(e->{ 
			if (cheatObject.getUsed()==false) { 
			cheatObject.setUsed(true);
			typeOfHelp.setHelpSelected('C'); 
			primaryStage.setScene(displayStudent());  
			} 
			}); ;
			
			//Button when user decides to use a save 
			saveButton.setOnAction(e->{ 
				if (save.getUsed()==false) { 
				save.setUsed(true);
				typeOfHelp.setHelpSelected('S'); 
				primaryStage.setScene(displayStudent()); 
				} 
				}); 
			
			 

		backStudent.setOnAction(e -> { primaryStage.setScene(displayStudent()); }); 

		buttonFarhan.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
		 ChF, ChG, ChH, ChI,  ChJ, 2)); }); 
		buttonOlga.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 0)); }); 
		buttonHanna.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1)); }); 
		buttonGiorgian.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 0 )); }); 
		buttonTian.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1)); }); 
		buttonJasmine.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3)); }); 
		buttonJoeyC.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3)); }); 
		buttonDaniel.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3)); }); 
		buttonJeremy.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1)); }); 
		buttonJoeyJ.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3 )); }); 
		buttonEric.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 2 )); }); 
		buttonDarren.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1 )); }); 
		buttonBrendan.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1 )); }); 
		buttonJihu.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 2 )); }); 
		buttonChayenne.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 2 )); }); 
		buttonTyler.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1 )); }); 
		buttonSylvi.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3 )); }); 
		buttonRachel.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3 )); }); 
		buttonEverett.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 2 )); }); 
		buttonJimmy.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 1)); }); 
		buttonYang.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 2 ));  }); 
		buttonPeter.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 2 ));  }); 
		buttonLillian.setOnAction(e -> { 
			VBox vbox = new VBox(); 
			vbox.getChildren().addAll(lily, backStudent); 
			BorderPane pane = new BorderPane(); 
			vbox.setAlignment(Pos.CENTER);
			pane.setStyle("-fx-background-color: #3e8446" ); 
			pane.setCenter(vbox); 
			Scene newScene = new Scene(pane, 1000, 750); 
			primaryStage.setScene(newScene);
			
		}); 
		buttonDrFodor.setOnAction(e -> { primaryStage.setScene(studentButtonPressed(ChA, ChB, ChC, ChD, ChE, 
				 ChF, ChG, ChH, ChI,  ChJ, 3 )); 
		
		VBox vbox = new VBox(); 
		vbox.getChildren().addAll(drFodorStudent, backStudent); 
		BorderPane pane = new BorderPane(); 
		vbox.setAlignment(Pos.CENTER);
		pane.setStyle("-fx-background-color: #3e8446" ); 
		pane.setCenter(vbox); 
		Scene newScene = new Scene(pane, 1000, 750); 
		primaryStage.setScene(newScene);
		
		
		
		}); 
		
	

		continueCheatSave.setOnAction(e-> { primaryStage.setScene(answerSelection(answerChosen, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } );
		
		useResponse.setOnAction(e-> { primaryStage.setScene(answerSelection(answerChosen, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } );

		
		 differentAnswer.setOnAction(e-> { 
		if(currentQuestion.getCurrentQuestion()=='A') { 	
			primaryStage.setScene(differentAnswerSelection(ChA, answerA1, answerA2, answerA3, answerA4)); 
			
			} 
		if(currentQuestion.getCurrentQuestion()=='B') { 	
			primaryStage.setScene(differentAnswerSelection(ChB, answerB1, answerB2, answerB3, answerB4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='C') { 	
			primaryStage.setScene(differentAnswerSelection(ChC, answerC1, answerC2, answerC3, answerC4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='D') { 	
			primaryStage.setScene(differentAnswerSelection(ChD, answerD1, answerD2, answerD3, answerD4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='E') { 	
			primaryStage.setScene(differentAnswerSelection(ChE, answerE1, answerE2, answerE3, answerE4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='F') { 	
			primaryStage.setScene(differentAnswerSelection(ChF, answerF1, answerF2, answerF3, answerF4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='G') { 	
			primaryStage.setScene(differentAnswerSelection(ChG, answerG1, answerG2, answerG3, answerG4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='H') { 	
			primaryStage.setScene(differentAnswerSelection(ChH, answerH1, answerH2, answerH3, answerH4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='I') { 	
			primaryStage.setScene(differentAnswerSelection(ChI, answerI1, answerI2, answerI3, answerI4)); 
			} 
		if(currentQuestion.getCurrentQuestion()=='J') { 	
			primaryStage.setScene(differentAnswerSelection(ChJ, answerJ1, answerJ2, answerJ3, answerJ4)); 
		}
		 }); 
		
		buttonChapterA.setOnAction(e-> { 
			if(chapterA.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterA, answerA1, answerA2, answerA3, answerA4, ChA));} 
			} 
		});
		
		answerA1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChAR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerA2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChAR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerA3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChAR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerA4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChAR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
	
		
	buttonChapterB.setOnAction(e-> { 
		if(chapterB.getUsed()==false) { 
		{primaryStage.setScene(questionSelection(chapterB, answerB1, answerB2, answerB3, answerB4, ChB));} 
		} 
	});
	

	answerB1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChBR1, chapterA, chapterB, chapterC, chapterD,
			chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
	
	answerB2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChBR2, chapterA, chapterB, chapterC, chapterD,
			chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
			
	answerB3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChBR3, chapterA, chapterB, chapterC, chapterD,
			chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
	
	answerB4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChBR4, chapterA, chapterB, chapterC, chapterD,
			chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
	
		
		buttonChapterC.setOnAction(e-> { 
			if(chapterC.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterC, answerC1, answerC2, answerC3, answerC4, ChC));} 
			} 
		});
		
		answerC1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChCR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerC2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChCR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerC3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChCR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerC4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChCR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		

		buttonChapterD.setOnAction(e-> { 
			if(chapterD.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterD, answerD1, answerD2, answerD3, answerD4, ChD));} 
			} 
		});
		
		answerD1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChDR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerD2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChDR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerD3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChDR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerD4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChDR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 

		buttonChapterE.setOnAction(e-> { 
			if(chapterE.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterE, answerE1, answerE2, answerE3, answerE4, ChE));} 
			} 
		});
		
		answerE1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChER1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerE2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChER2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerE3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChER3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerE4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChER4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		

		buttonChapterF.setOnAction(e-> { 
			if(chapterF.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterF, answerF1, answerF2, answerF3, answerF4, ChF));} 
			} 
		});
		
		answerF1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChFR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerF2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChFR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerF3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChFR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerF4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChFR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
	

		buttonChapterG.setOnAction(e-> { 
			if(chapterG.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterG, answerG1, answerG2, answerG3, answerG4, ChG));} 
			} 
		});
		
		answerG1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerG2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerG3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerG4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		

		buttonChapterH.setOnAction(e-> { 
			if(chapterH.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterH, answerH1, answerH2, answerH3, answerH4, ChH));} 
			} 
		});
		
		answerH1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChHR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerH2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChHR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerH3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChHR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerH4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChHR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		

		buttonChapterI.setOnAction(e-> { 
			if(chapterI.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterI, answerI1, answerI2, answerI3, answerI4, ChI));} 
			} 
		});
		
		answerI1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChIR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerI2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChIR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerI3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChIR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerI4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChIR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		

		buttonChapterJ.setOnAction(e-> { 
			if(chapterJ.getUsed()==false) { 
			{primaryStage.setScene(questionSelection(chapterJ, answerJ1, answerJ2, answerJ3, answerJ4, ChJ));} 
			} 
		});
		
		answerJ1.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR1, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerJ2.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR2, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
				
		answerJ3.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR3, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		answerJ4.setOnAction(e-> { primaryStage.setScene(answerSelection(ChGR4, chapterA, chapterB, chapterC, chapterD,
				chapterE, chapterF, chapterG,  chapterH, chapterI, chapterJ, save));  } ); 
		
		HBox hbox2 = new HBox(50); 
		hbox2.getChildren().add(splash); 
		hbox2.setAlignment(Pos.CENTER); 
		HBox hbox = new HBox(250);
		hbox.getChildren().addAll(quit, gameRules, play); 
		
		hbox.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setBottom(hbox); 
		pane.setCenter(hbox2);
		
		Scene splash = new Scene(pane, 1000, 750);
		
		{
		BorderPane pane1 = new BorderPane();
		Scene correct = new Scene(pane1, 1000, 750); 
		} 
		
		pane.setStyle("-fx-background-color: #3e8446" ); 
		
		
		
		
		primaryStage.setTitle("Are You Smarter Than a 260 Student?"); // Set the stage title
		primaryStage.setScene(splash); // Place the scene in the stage
		primaryStage.show(); // Display the stage
		
		back.setOnAction(e-> {
			primaryStage.setScene(splash);
		});
		
	}  
	public static void main(String[] args) throws FileNotFoundException { 
		
	 launch(args); 
	} 
	



public class Chapter implements Serializable{ 
	Stack <Question> questionsArray = new Stack(); 
	String chapterName; 
	Boolean used; 
	
	public Chapter() {}; 
	public Chapter(String name, boolean used, Stack <Question> questionsArray) { 
		this.chapterName = name;
		this.used = used; 
		this.questionsArray = questionsArray; 
	}
	public String getChapter() { 
		return this.chapterName; 
	}
	public void setUsed(boolean used) {
		this.used= used;
	}
	public boolean getUsed() {
		return used;
	}
	
}
	
public class Question{ 
	String textQuestion; 
	Answer[] answers; 
	
	public Question() { 
		
	}
	public Question(String text, Answer[] answers) { 
		this.textQuestion = text;
		this.answers = answers;
		
	}
	public void setQuestion(String question) { 
		this.textQuestion = question; 
	}
	
	public String getQuestion() { 
		return this.textQuestion;
	}
	
	
	
}

public class CurrentQuestion{
	char currentQuestion; 
	
	public CurrentQuestion() {}; 
	
	public CurrentQuestion(char currentQuestion) { 
		this.currentQuestion = currentQuestion; 
	}
	
	public void setCurrentQuestion(char currentQuestion) { 
		this.currentQuestion = currentQuestion; 
	}
	
	public char getCurrentQuestion() {
		return this.currentQuestion; 
	}
	
	
	
}
public class HelpSelected{
	char typeOfHelp; 
	
	public HelpSelected() {}; 
	
	public HelpSelected(char typeOfHelp) { 
		this.typeOfHelp=typeOfHelp; 
	}
	
	public void setHelpSelected(char typeOfHelp) { 
		this.typeOfHelp=typeOfHelp; 
	}
	
	public char getTypeOfHelp() {
		return this.typeOfHelp; 
	}
	
	
	
}

public class Answer { 
	boolean isTrue; 
	String text; 
	
	public Answer() {}; 
	
	public Answer(boolean truth, String text) { 
		this.isTrue = truth; 
		this.text = text; 
	}
	public void setTruth(boolean truth) { 
		this.isTrue = truth; 
	}
	public boolean getTruth() { 
		return this.isTrue; 
	}
	
	public void setText(String text) { 
		this.text = text;
	}
	public String getText() { 
		return this.text;
	}
	
}

public class Save {
	boolean used; 
	
	Save() { 
	}
	
	public void setUsed(boolean used) { 
		this.used=used;
	}
	
	public boolean getUsed()
	{ 
		return this.used;
	}
}
public class Cheat {
	boolean used; 
	
	Cheat() { 
	}
	
	public void setUsed(boolean used) { 
		this.used=used;
	}
	
	public boolean getUsed()
	{ 
		return this.used;
	}
}

public class Peek {
	boolean used; 
	
	Peek() { 
	}
	
	public void setUsed(boolean used) { 
		this.used=used;
	}
	
	public boolean getUsed()
	{ 
		return this.used;
	}
}

public class Student { 
	String name; 
	
	Student() { }
	
	Student(String name) {
		this.name=name; 
	}
	
}

public class AnswerChosen  {
		Answer answerChosen; 
		
		public AnswerChosen() {}; 
		
		public AnswerChosen(Answer answerChosen) { 
			this.answerChosen=answerChosen; 
		}
		public void setAnswer(Answer answerChosen) { 
			this.answerChosen=answerChosen; 
		}
		public Answer getAnswerh() { 
			return this.answerChosen; 
		}
		public String getText() {
			return answerChosen.getText(); 
		}
		
		public boolean getTruth() { 
			return answerChosen.getTruth(); 
		}
		

		
	
}
public class StudentButton extends Button{ 
	public StudentButton(String text) { 
		super(text); 
		setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		setMaxWidth(Double.MAX_VALUE);
		
		
	}
}

public class AnswerButton extends Button{ 
	public AnswerButton(String text) { 
		super(text); 
		setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		setMaxWidth(Double.MAX_VALUE);
		
		
	}
}

public class QuestionButton extends Button{ 
	public QuestionButton(String text) { 
		super(text); 
		setStyle("-fx-font: 32 Chalkboard;-fx-base: #ffac3f;"); 
		setMaxWidth(Double.MAX_VALUE);
		
		
	}
}







} 




