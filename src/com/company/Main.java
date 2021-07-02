package com.company;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {

    public static void greetingStrangers(){
        System.out.println();
        System.out.println("Hello and welcome to our hotel ");
        System.out.println("\"Digital Montana\"");
        System.out.println();
    }

    public static void showingOptionMenu(){
        System.out.println("Would you like first find a suiting room for your preference?");
        System.out.println("If ypu want please press 1.");
        System.out.println("Or if you have already chosen your room and want to make reservation");
        System.out.println("please press 2.");
        System.out.println("And if you want to exit please press 3.");
    }

    public static int goingToRefOrMenu(){
        Scanner inpot = new Scanner(System.in);

        System.out.println("Would you like to see the reference of the booked rooms or go to the menu?");
        System.out.println("If you want to see the reference please press 1;");
        System.out.println("If you want to go to the menu please press 2.");
        int customerSecondChoice = inpot.nextInt();

        return customerSecondChoice;
    }

    public static void mainMenuOptions(){
        Scanner inpot = new Scanner(System.in);
        greetingStrangers();
        showingOptionMenu();

        System.out.print("Choose option: ");

        byte chosenOption = inpot.nextByte();
        if (chosenOption == 1){
            choosingFloor();
            mainMenuOptions();
        }
        else if (chosenOption == 2){
            System.out.println();
            bookingPeriod();
        }
        else if(chosenOption == 3){
            System.out.println("Thank you! Have a great day!");
        }
        else{
            trowingErrorMessage();
            mainMenuOptions();
        }
    }

    public static void trowingErrorMessage(){
        System.out.println("Invalid input!");
    }

    public static void showingApartmentsSpec(){
        System.out.println();
        System.out.println("So our hotel has only two but luxurious floor!");
        System.out.println("And each floor has for different rooms.");
        System.out.println("For example the rooms ending with even number have included breakfast, 3 king size beds and special baby cot.");
        System.out.println("Or if you want room just to spent the night rooms ending with odd number are just for you.");
        System.out.println("And you should know about the orientation.");
        System.out.println("The rooms facing east are with beautiful view towards the endless sea.");
        System.out.println("And the rooms facing west are looking towards the beautiful city.");
        System.out.println();
    }

    public static void choosingFloor(){
        Scanner inpot = new Scanner(System.in);

        showingApartmentsSpec();

        System.out.print("Soo... which floor would you like to be in: ");
        byte floorAns = inpot.nextByte();

        if (floorAns == 1){
            floor1();
        }
        else if (floorAns == 2) {
            floor2();
        }else {
            trowingErrorMessage();
            choosingFloor();
        }
    }

    public static void floor1(){
        Scanner inpot = new Scanner(System.in);

        int[] apartment1 = {1 , 101, 2}; //east - sea, no breakfast
        int[] apartment2 = {1 , 102, 4}; //east - sea, breakfast, baby cot
        int[] apartment3 = {1 , 103, 2}; //west - city, no breakfast
        int[] apartment4 = {1 , 104, 4}; //west - city, breakfast, baby cot

        System.out.print("What orientation would you like [east or west]: ");
        String customerAns = inpot.nextLine();
        String lowerCaseAns = customerAns.toLowerCase(Locale.ROOT);

        if (lowerCaseAns.equals("east")){
            System.out.print("With how many beds :");
            byte bedsAns = inpot.nextByte();

            if (bedsAns == 2){
                System.out.println(apartment1[1]);
                System.out.println();
            }
            else if (bedsAns == 4){
                System.out.println(apartment2[1]);
                System.out.println();
            }else {
                trowingErrorMessage();
                floor1();
            }
        }
        else if (lowerCaseAns.equals("west")){
            System.out.print("With how many beds: ");
            byte bedsAns = inpot.nextByte();

            if (bedsAns == 2){
                System.out.println(apartment3[1]);
                System.out.println();
            }
            else if (bedsAns == 4){
                System.out.println(apartment4[1]);
                System.out.println();
            }else {
                trowingErrorMessage();
                floor1();
            }
        }else {
            trowingErrorMessage();
            choosingFloor();
        }
    }

    public static void floor2(){
        Scanner inpot = new Scanner(System.in);

        int[] apartment1 = {2 , 201, 2}; //east - sea, no breakfast
        int[] apartment2 = {2 , 202, 4}; //east - sea, breakfast, baby cot
        int[] apartment3 = {2 , 203, 2}; //west - city, no breakfast
        int[] apartment4 = {2 , 204, 4}; //west - city, breakfast, baby cot

        System.out.print("What orientation would you like [east or west]: ");
        String customerAns = inpot.nextLine();
        String lowerCaseAns = customerAns.toLowerCase(Locale.ROOT);

        if (lowerCaseAns.equals("east")){
            System.out.print("With how many beds: ");
            byte bedsAns = inpot.nextByte();

            if (bedsAns == 2){
                System.out.println(apartment1[1]);
                System.out.println();
            }
            else if (bedsAns == 4){
                System.out.println(apartment2[1]);
                System.out.println();
            }
            else {
                trowingErrorMessage();
                floor2();
            }
        }
        else if (lowerCaseAns.equals("west")){
            System.out.print("With how many beds :");
            byte bedsAns = inpot.nextByte();

            if (bedsAns == 2){
                System.out.println(apartment3[1]);
                System.out.println();
            }
            else if (bedsAns == 4){
                System.out.println(apartment4[1]);
                System.out.println();
            }
            else {
                trowingErrorMessage();
                floor2();
            }
        }
        else {
            trowingErrorMessage();
            choosingFloor();
        }
    }

    public static void bookingPeriod(){
        Scanner inpot = new Scanner(System.in);

        System.out.println("The booking is in the simple date format 'dd/MM/yyyy'.");
        System.out.print("Please enter your starting date: ");
        String startingDateStr = inpot.nextLine();
        System.out.print("Please enter your ending date: ");
        String endingDateStr = inpot.nextLine();

        String bookedDates = startingDateStr + " - " + endingDateStr;

        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate startingDate = LocalDate.parse(startingDateStr, dtf);
            LocalDate endingDate = LocalDate.parse(endingDateStr, dtf);
            Period vacationDuration = Period.between(startingDate, endingDate);

            boolean isAfter = endingDate.isAfter(startingDate);

            if (isAfter) {
                System.out.print("Please enter comment to your reservation: ");
                String costumerComment = inpot.nextLine();

                System.out.println("The reservation is for " + costumerComment + " and it will last " + vacationDuration.getDays() + " days.");
                bookingRoom(bookedDates);

            } else {
                trowingErrorMessage();
                bookingPeriod();
            }

        } catch (Exception e) {
            trowingErrorMessage();
            bookingPeriod();
        }
    }

    public static List<String> bookingRoom(String bookedDates){
        Scanner inpot = new Scanner(System.in);

        List<String> bookedRoomsAndPeriodList = new ArrayList<>();

        System.out.print("Please enter your chosen room here: ");
        String costumerRoom = inpot.nextLine();

        String bookedRoomStr;

        switch (costumerRoom){
            case "101":
                bookedRoomStr = "101" + "->" + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "102":
                bookedRoomStr = "102" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "103":
                bookedRoomStr = "103" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "104":
                bookedRoomStr = "104" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "201":
                bookedRoomStr = "201" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "202":
                bookedRoomStr = "202" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "203":
                bookedRoomStr = "203" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            case "204":
                bookedRoomStr = "204" + "->"  + bookedDates;
                bookedRoomsAndPeriodList.add(bookedRoomStr);
                System.out.println("Reservation was made");
                if (goingToRefOrMenu() == 1){
                    System.out.println(bookedRoomsAndPeriodList);
                    mainMenuOptions();
                }
                else if (goingToRefOrMenu() == 2){
                    mainMenuOptions();
                }
                else{
                    trowingErrorMessage();
                    mainMenuOptions();
                }

            default:trowingErrorMessage();
                bookingRoom(bookedDates);
                break;
        }

        return bookedRoomsAndPeriodList;
    }

    public static void main(String[] args) {
        mainMenuOptions();
    }
}