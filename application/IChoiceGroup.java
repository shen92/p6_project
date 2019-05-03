//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
// Title: Quiz Generator
//
// Files: ChoiceGroup.java, IChoiceGroup.java, IGUI.java, IQuestion.java,
// IQuestionDatabase.java, ITopicR.java, Main.java, Question.java,
// QuestionDatabase.java, QuestionDisplayGUI.java, QuizGeneratorGUI.java,
// QuizResultsGUI.java, TopicRow.java, application.css
//
// Course: CS400 Spring 2019 Sec 001 & 002
//
// Author, E-mail:
// Bojun Xu, bxu57@wisc.edu
// Yingjie Shen, shen92@wisc.edu
// Kerui Wang, kwang392@wisc.edu
// Dongxia Wu, dwu93@wisc.edu
// Zhelai Chen, zchen743@wisc.edu
//
// Lecturer's Name: Deb Deppeler
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
package application;

import java.util.ArrayList;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * Every ChoiceGroup of a question can be presented as a HashTable.
 * 
 * In the HashTable, the Key is the choice text, and the value is the Choice Status.
 * 
 * The choice status is represented as an inner class with two fields, correctness and is checked
 * 
 * @Author Kerui Wang
 */
public interface IChoiceGroup {

  /*
   * * This method adds a new choice to the choiceGroup
   * 
   * @param choiceText key of a node in HashTable
   * 
   * @param correctness used for updating the correctness field of the value in a node
   */
  void addChoice(String choiceText, String correctness);

  /**
   * IF AND ONLY IF status is isSelected and is Correct can return true.
   * 
   * This method is used for count number of correct in the quiz section
   */
  boolean isCorrect(String choiceText);

  /**
   * IF AND ONLY IF status is isSelected and is Correct can return true.
   * 
   * This method is used for count number of correct in the quiz section
   */
  boolean isCorrect();

  /**
   * This method returns if the question is answered(user selected the answer)
   * 
   * @return true if the question is answered
   */
  boolean isAnswered();

  /**
   * This method returns the number of choices in the choice group
   * 
   * @return int size of the choiceGroup
   */
  int size();

  /**
   * This method returns the toggle group of a question.
   * 
   * This method can be called to in the ShowQuestionGUI class
   * 
   * @return ToggleGroup toggleGroup
   */
  ToggleGroup getToggleGroup();

  /*
   * This method gets the RadioButton of a choice in a choiceGroup
   * 
   * @param String choiceText key of the choice
   * 
   * @return RadioBox radioBox of the choice
   */
  RadioButton getRadioButton(String choiceText);

  /**
   * This method clears the select status when the quiz is submitted
   */
  void reset();

  /**
   * This class is used for external iteration for quiz
   * 
   * @return ArrayList<String> keys of the hashTable
   */
  ArrayList<String> getChoiceGroupKeys();

  boolean checkCorrectness(String choiceContent);


}
