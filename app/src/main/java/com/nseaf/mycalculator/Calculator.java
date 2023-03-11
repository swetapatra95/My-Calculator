package com.nseaf.mycalculator;
public class Calculator {
    String numberString;
    String detailsString;
    long intNumber;
    long intNumberS;
    double realNumber;
    double realNumberS;
    boolean isIntNumber;
    boolean isIntNumberS;
    boolean numHasRadixPoint;
    long memoryInt;
    double memoryDouble;
    boolean isIntMemory;
    String evaluate;
    boolean isFirstEvaluation;

    public Calculator() {
        this.numberString = "0";
        this.detailsString = "";
        this.isIntNumber = true;
        this.isIntNumberS = true;
        this.isIntMemory = true;
        this.numHasRadixPoint = false;
        this.intNumber = 0;
        this.intNumberS = 0;
        this.realNumber = 0.0;
        this.realNumberS = 0.0;
        this.evaluate = "";
        this.memoryInt = 0;
        this.memoryDouble = 0.0;
        this.isFirstEvaluation = true;
    }

    public void clearClicked() {
        numberString="0";
        detailsString="";
        intNumber=0;
        realNumber=0.0;
        intNumberS = 0;
        realNumberS = 0.0;
        evaluate = "";
        isIntNumber=true;
        isIntNumberS=true;
        numHasRadixPoint=false;

    }

    public void processNumber(int i) {

        if(numberString.length()<12) {  // limit of 12 digits

            if (isIntNumber) {

                intNumber = intNumber * 10 + i;
                numberString = String.valueOf(intNumber);

            }
            else {
                numberString += i;
                realNumber = Double.parseDouble(numberString);
            }
            detailsString = "Clicked: "+i;
        }
        else
            detailsString="The number is too long..";
    }



    public void memPlusClicked() {

        if (isIntMemory) {
            memoryDouble = memoryInt + Double.parseDouble(numberString);
            isIntMemory = false;
        }
        else {
            memoryDouble = memoryDouble + Double.parseDouble(numberString);
        }

        if (memoryDouble % 1 == 0.0) {
            memoryInt = (int) memoryDouble;
            memoryDouble = 0.0;
            isIntMemory = true;
        }

        detailsString = "M+ evaluate";

    }

    public void memRecallClicked() {
        detailsString = "Memory Recover (MR)";

        if (isIntMemory) {
            intNumber = memoryInt;
            isIntNumber = true;
            numberString = Long.toString(memoryInt);
        }
        else {
            realNumber = memoryDouble;
            isIntNumber = false;
            numberString = Double.toString(memoryDouble);
        }
    }

    public void memMinusClicked() {

        if (isIntMemory) {
            memoryDouble = memoryInt - Double.parseDouble(numberString);
            isIntMemory = false;
        }
        else {
            memoryDouble = memoryDouble - Double.parseDouble(numberString);
        }

        if (memoryDouble % 1 == 0.0) {
            memoryInt = (int) memoryDouble;
            memoryDouble = 0.0;
            isIntMemory = true;
        }

        detailsString = "M- evaluate";
    }

    public void memClearClicked() {

        memoryInt = 0;
        memoryDouble = 0.0;
        isIntMemory = true;

        numberString = "0";
        isIntNumber = true;
        intNumber = 0;
        detailsString = "Memory cleared (MC)";
    }

    public void exponentClicked() {

        if (isIntNumber){
            realNumber = Math.exp(intNumber);
        }
        else {
            realNumber = Math.exp(realNumber);
        }

        isIntNumber = false;

        if (realNumber % 1 == 0.0) {
            isIntNumber = true;
            intNumber = (int) realNumber;
        }

        if (isIntNumber) {
            numberString = String.valueOf(intNumber);
        }
        else {
            numberString = String.valueOf(realNumber);
        }


        detailsString = "Operation: eˣ";
    }

    public void mathPiClicked() {

        realNumber = Math.PI;
        isIntNumber = false;

        if (realNumber % 1 == 0.0) {
            isIntNumber = true;
            intNumber = (int) realNumber;
        }

        if (isIntNumber) {
            numberString = String.valueOf(intNumber);
        }
        else {
            numberString = String.valueOf(realNumber);
        }

        detailsString = "Operation: \uD835\uDF0B";
    }

    public void divideClicked() {
        operationClicked();
        evaluate = "/";
        detailsString = "Operation: ÷";
    }

    public void multiplyClicked() {
        operationClicked();
        evaluate = "*";
        detailsString = "Operation: ×";
    }

    public void minusClicked() {
        operationClicked();
        evaluate = "-";
        detailsString = "Operation: -";
    }

    public void plusClicked() {
        operationClicked();
        evaluate = "+";
        detailsString = "Operation: +";
    }


    public void equalClicked() {
        if (!evaluate.equalsIgnoreCase("")) {

            if (evaluate.equalsIgnoreCase("+")) {
                if (isIntNumber && isIntNumberS) {
                    intNumber += intNumberS;
                    isIntNumber = true;
                }
                else if (!isIntNumber && !isIntNumberS){
                    realNumber += realNumberS;
                    isIntNumber = false;
                }
                else if (!isIntNumber && isIntNumberS) {
                    realNumber += intNumberS;
                    isIntNumber = false;
                }
                else if (isIntNumber && !isIntNumberS) {
                    realNumber = intNumber + realNumberS;
                    isIntNumber = false;
                }

                if (!isIntNumber) {
                    if (realNumber % 1 == 0.0) {
                        intNumber = (int) realNumber;
                        isIntNumber = true;

                    }
                }

                numberString = isIntNumber ?  String.valueOf(intNumber) : String.valueOf(realNumber);
            }

            else if (evaluate.equalsIgnoreCase("-")) {
                if (isIntNumber && isIntNumberS) {
                    intNumber = intNumberS - intNumber;
                    isIntNumber = true;
                }
                else if (!isIntNumber && !isIntNumberS){
                    realNumber = realNumberS - realNumber;
                    isIntNumber = false;
                }
                else if (!isIntNumber && isIntNumberS) {
                    realNumber = intNumberS - realNumber;
                    isIntNumber = false;
                }
                else if (isIntNumber && !isIntNumberS) {
                    realNumber = realNumberS - intNumber;
                    isIntNumber = false;
                }

                if (!isIntNumber) {
                    if (realNumber % 1 == 0.0) {
                        intNumber = (int) realNumber;
                        isIntNumber = true;

                    }
                }

                numberString = isIntNumber ?  String.valueOf(intNumber) : String.valueOf(realNumber);

            }

            else if (evaluate.equalsIgnoreCase("/")) {

                if (isIntNumber && isIntNumberS) {
                    realNumber = (double) intNumberS / (double) intNumber;
                    isIntNumber = false;
                }
                else if (!isIntNumber && !isIntNumberS){
                    realNumber = (double) realNumberS / (double) realNumber;
                    isIntNumber = false;
                }
                else if (!isIntNumber && isIntNumberS) {
                    realNumber = (double) intNumberS / (double) realNumber;
                    isIntNumber = false;
                }
                else if (isIntNumber && !isIntNumberS) {
                    realNumber = (double) realNumberS / (double) intNumber;
                    isIntNumber = false;
                }

                if (!isIntNumber) {
                    if (realNumber % 1 == 0.0) {
                        intNumber = (int) realNumber;
                        isIntNumber = true;

                    }
                }

                numberString = isIntNumber ?  String.valueOf(intNumber) : String.valueOf(realNumber);


            }

            else if (evaluate.equalsIgnoreCase("*")) {


                if (isIntNumber && isIntNumberS) {
                    intNumber = intNumberS * intNumber;
                    isIntNumber = true;
                }
                else if (!isIntNumber && !isIntNumberS){
                    realNumber = realNumberS * realNumber;
                    isIntNumber = false;
                }
                else if (!isIntNumber && isIntNumberS) {
                    realNumber = intNumberS * realNumber;
                    isIntNumber = false;
                }
                else if (isIntNumber && !isIntNumberS) {
                    realNumber = realNumberS * intNumber;
                    isIntNumber = false;
                }

                if (!isIntNumber) {
                    if (realNumber % 1 == 0.0) {
                        intNumber = (int) realNumber;
                        isIntNumber = true;

                    }
                }

                numberString = isIntNumber ?  String.valueOf(intNumber) : String.valueOf(realNumber);


            }
        }

        isIntNumberS = true;
        intNumberS = 0;
        realNumberS = 0.0;
        detailsString = "Answer";
        evaluate = "";
        isFirstEvaluation = true;
    }

    public void percentageClicked() {

        if (isFirstEvaluation) {

            if (isIntNumber) {

                realNumber = (double) intNumber / 100;
            }
            else {

                realNumber = (double) realNumber / 100;
            }

            isIntNumber = false;
        }
        else {

            if (isIntNumber && isIntNumberS) {
                realNumber = ((double) intNumber * (double) intNumberS) / 100;
                isIntNumber = false;
            }
            else if (!isIntNumber && !isIntNumberS){
                realNumber = ((double) realNumber * (double) realNumberS) / 100;
                isIntNumber = false;
            }
            else if (!isIntNumber && isIntNumberS) {
                realNumber = ((double) intNumber * (double) realNumberS) / 100;
                isIntNumber = false;
            }
            else if (isIntNumber && !isIntNumberS) {
                realNumber = ((double) realNumber * (double) intNumberS) / 100;
                isIntNumber = false;
            }

        }

        if (realNumber % 1 == 0.0) {
            isIntNumber = true;
            intNumber = (int) realNumber;
        }

        if (isIntNumber) {
            numberString = String.valueOf(intNumber);
        }
        else {
            numberString = String.valueOf(realNumber);
        }

        detailsString = "Operation: %";
    }

    public void radixClicked() {
        if(!numHasRadixPoint) {
            numberString += ".";
            detailsString = "Clicked: .";
            numHasRadixPoint = true;
            isIntNumber = false;
            realNumber = (float) intNumber;
            intNumber = 0;
        }
    }


    private void operationClicked() {
        if (isFirstEvaluation) {
            isFirstEvaluation = false;
            if(isIntNumber) {
                intNumberS = intNumber;
                isIntNumberS = true;
                intNumber = 0;
            }
            else {
                realNumberS = realNumber;
                isIntNumberS = false;
                intNumber = 0;
                isIntNumber = true;
            }

        }

        else {
            equalClicked();
            operationClicked();
        }

        numHasRadixPoint = false;
        numberString = "0";
    }

}