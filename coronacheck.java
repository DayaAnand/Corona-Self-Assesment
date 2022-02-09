import java.util.*;
class coronacheck {
    static int risk=0;
    private static Scanner in = new Scanner(System.in);
    // function to check the temperature of the user. function called when given a wrong input by the user to start from the beginning.
    private static void func(){
        System.out.println("\nPlease let me know your current temperature in degree Fahrenheit:");
        System.out.println("\n1.Normal(96F-98.6F)\n2.Fever(98.6F-102F)\n3.High Fever(>102F)\n4.Don't know\n");
        int temperature=in.nextInt();
        if(temperature==1 || temperature==2 || temperature==3 || temperature==4){
            symptoms();
        }
        else{
            System.out.println("\nWrong Entry!, Sorry start from the beginning!");
            func();
        }
    }
    // function to fetch symptom from the user
    private static void symptoms() {
        System.out.println("\nAre you experiencing any of the symptoms below?");
        String symptoms[]= {"Dry cough","Sore throat","Weakness","Change in Appetite","Difficulty in Breathing","Drowsiness","none of these"};
        for(int i=0;i<symptoms.length;i++){
            System.out.println(i+1+"."+symptoms[i]);
        }
        int userSymptom=in.nextInt();
        if(userSymptom==1 || userSymptom==2 || userSymptom==3 || userSymptom==4 || userSymptom==5 || userSymptom==6){
            risk++;
            travelhistory();
        }
        else if(userSymptom==7){
            travelhistory();
        }
        else{
            System.out.println("\nWrong Entry!, Sorry start from the beginning!");
            func();
        }
    }
    // function to fetch the travel history
    private static void travelhistory() {
        System.out.println("\nNow please select your travel and exposure details:");
        System.out.println("\n1.No Travel History\n2.No contact with anyone with Symptoms\n3.History of abroad travel in last 14 days\n");
        int travelhis=in.nextInt();

        if(travelhis==1 ||travelhis==2){
            otherdiseasehistory();
        }
        else if(travelhis==3){
            finalmessage();
        }
        else{
            System.out.println("\nWrong Entry!, Sorry start from the beginning!");
            func();
        }
    }
    // function to know about the history of the disease condition    
    private static void otherdiseasehistory() {
        System.out.println("\nDo you have any of these conditions?");
        System.out.println("\n1.Diabetes\n2.High Blood Pressure\n3.Heart disease\n4.Lung diseases\n5.None of these\n");
        int otherdiseasehis=in.nextInt();
        if(otherdiseasehis==1 || otherdiseasehis==2 || otherdiseasehis==3 || otherdiseasehis==4){
            if(risk!=0){
                finalmessage();
            }
            else{
                System.out.println("Except this condition, there is no more sign for corona.,\n");
                positivemessage();
            }
        }
        else if(otherdiseasehis==5){
            if(risk==0){
                positivemessage();
            }
            else{
                System.out.println("Good.. But still it is suggested to have a physical test at nearby Hospital!");
            }
        }
        else{
            System.out.println("\nWrong Entry!, Sorry start from the beginning!");
            func();
        }
	}

    // function to print a warning message
	private static void finalmessage() {
        System.out.println("Seems Risky.., It is recommmended to have a physical test at nearby hospital!");
    }

    // function to print a positive message
    private static void positivemessage() {
        System.out.println("\nThat's good., You are all fine!");
    }
    
    public static void main(String[] args) {
        System.out.println("Hi there, Welcome to Corona Self Assesment!");
        System.out.println("Developed by Daya Anand C H");
        System.out.println("Please Enter Your Name");
        String name=in.nextLine().toUpperCase();
        System.out.println("\nHello "+name+", here I have created an assessment scan. Do answer the questions honestly!");
        System.out.println("So, lets get started!");
        System.out.println("NOTE: For Multiple choice questions, Reply your answers with respective numbers (i.e., 1,2..etc.)");
        System.out.println("How old are you?");
        int age=in.nextInt();
        if(age>12){
            System.out.println("Please select your Gender:\n1.Male\n2.Female\n3.Prefer not to say");
            int gender=in.nextInt();
            if(gender==1 ||gender==2 ||gender==3){
                func();
            }
            else{
                System.out.println("\nWrong Entry!, Sorry start from the beginning!");
            }
        }
        else{
            System.out.println("\nSorry! This Assessment test suits only for the people above the age of 12.");
        }
        System.out.println("\nThanks for your time,"+name+"\n\nProgrammed by Daya Anand C H.");
        System.out.println("\nSTAY HOME! STAY SAFE!\n");
    }
}