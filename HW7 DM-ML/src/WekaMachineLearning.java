/*
 * Homework 7: Machine Learning / Data Mining 
 * Name: Pat Wongwiset
 * Computing ID: nw9ca
 * Sources referenced:
 * 
 * Any additional comments:
 * 
 * Referenced Libraries:
 * 		- weka.jar
 * 		- weka-src.jar
 * 
 * Datasets:   (add/change this list depending on which data sets you use)
 * 		- iris
 * 		- diabetes
 * 		- nursery
 * 		- soybean
 * 
 */

/* Import statements */
//n
//
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.evaluation.NominalPrediction;
import weka.classifiers.rules.PART;
import weka.classifiers.trees.J48;
import weka.classifiers.rules.JRip;
import weka.core.FastVector;
import weka.core.Instances;

@SuppressWarnings("deprecation")

public class WekaMachineLearning {
	public static Scanner in = new Scanner(System.in);

	// main method: predictive learning experiment
	public static void main(String[] args) throws Exception {
		do {
			int dataChoice = getInput();
			int k = 5;
			BufferedReader datafile;
			// You may edit the files to read here.
			// Make sure to change options ( getInput() )
			if (dataChoice == 1) {
				datafile = readDataFile("iris.arff");
			} else if (dataChoice == 2) {
				datafile = readDataFile("diabetes.arff");
			} else { // dataChoice == 3
				datafile = readDataFile("nursery.arff");
			} 

			Instances data = new Instances(datafile);
			// If we were using the iris data set...
			// Each instance of the data set has 5 attributes. (sepallength,
			// sepalwidth, petallength, petalwidth, class)
			// We are interested in classifying our data with the class it's
			// associated with.
			// Here, we are indicating that the class label is the last
			// attribute
			// (in the last position)
			data.setClassIndex(data.numAttributes() - 1);

			// K-Fold Cross Validation
			k = getK(); // Ask for k input from user
			Instances[][] split = crossValidationSplit(data, k);

			// Separate split into training and testing arrays
			Instances[] trainingSplits = split[0];
			Instances[] testingSplits = split[1];

			// Selecting classifier. (Algorithm)
			Classifier algo;
			int sel = selectAlgo();
			if (sel == 1) {
				algo = new J48();
			} else if (sel == 2) {
				algo = new JRip();
			} else {
				algo = new PART();
			}

			FastVector predictions = new FastVector();
			// For each training-testing split pair, train and test the
			// classifier
			for (int i = 0; i < trainingSplits.length; i++) {
				Evaluation validation = classify(algo, trainingSplits[i], testingSplits[i]);
				predictions.appendElements(validation.predictions());
			}

			// Prints rules and decision trees
			System.out.println(algo.toString());

			// Calculate overall accuracy of current classifier on all splits
			double accuracy = calculateAccuracy(predictions);

			// Print current classifier's name and accuracy
			System.out.println("Using " + k + "-fold cross validation in this experiment.");
			System.out.println("Accuracy of " + algo.getClass().getSimpleName() + ": "
					+ String.format("%.2f%%", accuracy) + "\n---------------------------------");
		} while (repeat());

	}

	// ******************************
	// Method: getInput()
	// Purpose: Provide the selection of data set the user want to use
	public static int getInput() {
		int choice = 1;
		do {
			// Ask user for the data set they wish to use.
			// User selects one from the given text menu.
			// Edit this menu if you wish to add datasets or change them.
			System.out.println("Enter the integer of the corresponding data set you would like to use.");
			System.out.println("1. Iris");
			System.out.println("2. Diabetes");
			System.out.println("3. Nursery");
			System.out.println("4. Soybean");
			choice = in.nextInt();
			in.nextLine();
			if (choice < 1 || choice > 4) {
				System.out.println("ERROR. Please enter either the integer in the range 1 - 3.");
			}
		} while (choice < 1 || choice > 4); // keep user in loop until user
											// enters valid input

		return choice;

	}

	// ******************************
	// Method: getK()
	// Purpose: to prompt user for the number of folds for
	// k-fold cross validation
	public static int getK() {
		System.out.println("Enter the number of folds (k) split cross validations.");
		int k = in.nextInt();
		while(k < 2){
			System.out.println("ERROR: Please enter an integer greater than 2.");
			k = in.nextInt();
		}
		double training = 100*(k-1)/k;
		double testing = 100 - training;
		System.out.println("Entering '" + k + "' will give you " + training + "% Training and " + testing + "% Testing.");
		return k;
	}

	// ******************************
	// Method: selectAlgo()
	// Purpose: Provide the selection of algorithm to analyze data that the user want to use
	public static int selectAlgo() {
		int choice = 1;
		do {

			System.out.println("Enter the integer of the corresponding algorithm you would like to use.");
			System.out.println("1. J48 (C4.5)");
			System.out.println("2. JRip (RIPPER)");
			System.out.println("3. PART");
			choice = in.nextInt();
			in.nextLine();
			if (choice < 1 || choice > 3) {
				System.out.println("ERROR. Please enter either the integer 1, 2, or 3.");
			}
		} while (choice < 1 || choice > 3);

		return choice;
	}

	// ******************************
	// Method: repeat()
	// Purpose: repeat the procedure again with another test
	public static boolean repeat() {
		int choice;

		do {
			System.out.println("Do you want to run another test? 1. Yes or 2. No");
			choice = in.nextInt();
			in.nextLine();
			if (choice < 1 || choice > 2) {
				System.out.println(choice + " is an invalid choice. " + "Please enter \"1\" or \"2\".");
			}
		} while (choice < 1 || choice > 2);

		return choice == 1;
	}

	// ******************************
	// Method: readDataFile()
	// Purpose: read the data from the defined filename
	public static BufferedReader readDataFile(String filename) {
		BufferedReader inputReader = null;

		try {
			inputReader = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException ex) {
			System.err.println("File not found: " + filename);
		}

		return inputReader;
	}

	// ******************************
	// Method: classify()
	// Purpose: evaluate how well the program is 
	// to evaluate the classifier (evaluating how well it performed on testing
	// set)
	public static Evaluation classify(Classifier model, Instances trainingSet, Instances testingSet) throws Exception {
		Evaluation evaluation = new Evaluation(trainingSet);

		model.buildClassifier(trainingSet); //
		evaluation.evaluateModel(model, testingSet); // passing classifier (e.g.
														// J48) and testing data

		return evaluation;
	}

	// ******************************
	// Method: calculate Accuracy()
	// Purpose: return the percentage of correctness the program implements
	// (showing accuracy in term of percent)
	public static double calculateAccuracy(FastVector predictions) {
		double correct = 0;

		for (int i = 0; i < predictions.size(); i++) {
			NominalPrediction np = (NominalPrediction) predictions.elementAt(i);
			if (np.predicted() == np.actual()) {
				correct++;
			}
		}
		return 100 * correct / predictions.size();
	}

	// ******************************
	// Method: crossValidationSplit()
	// Purpose: splitting the classes equally in each fold
	public static Instances[][] crossValidationSplit(Instances data, int numberOfFolds) {

		Instances[][] split = new Instances[2][numberOfFolds];

		for (int i = 0; i < numberOfFolds; i++) {
			split[0][i] = data.trainCV(numberOfFolds, i);
			split[1][i] = data.testCV(numberOfFolds, i);
		}

		return split;
	}

}