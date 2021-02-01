//Name:			Jean Lionel Ndabaga, Serge Nikore;
//Project:		EZA project;
//Description:	A program that is used to scan the input from sensors and specifies the amount of fertilisers that will be needed by the farmer;
//Date:    		28/01/2021;
//Sources:		https://homeguides.sfgate.com/low-ph-soil-affecting-carrot-plant-68706.html;
//Sources:		https://www.noble.org/news/publications/ag-news-and-views/1999/january/understanding-and-correcting-soil-acidity;

import java.util.*;

public class Main{
	public static void main(String[] args){
		
		//==========================================================================================================
		//creating Scanner object to help reading the inputs
		Scanner eza = new Scanner(System.in);
		
		//==========================================================================================================
		//Soil texture percentages detection( using acoustic sensors);
		
		System.out.print("Enter percentage of clay:"); 
		double clay = eza.nextDouble();										//reading the amount of clay in land;
		System.out.print("Enter percentage of sand:");
		double sand = eza.nextDouble();										//reading the amount of clay in land;
		System.out.print("Enter percentage of silt:");
		double silt = eza.nextDouble();										//reading the amount of clay in land;
		
		//sum of tecture percentages
		
		double sum = clay + sand + silt;									//calculating the sum of the texture elements;
		
		//==========================================================================================================
		//calculating individual percentage in texture mixture, and rounding them off to the second decimal;
		double clayP =  Math.round(((100/sum)*clay) * 100.0) / 100.0;		//percetage of clay in mixture;
		
		System.out.println("The percentage of clay is: " + clayP + "%");
		
		double sandP =  Math.round(((100/sum)*sand) * 100.0) / 100.0;		//percetage of sand in mixture;
		
		System.out.println("The percentage of sand is: " + sandP + "%");
		
		double siltP =  Math.round(((100/sum)*silt) * 100.0) / 100.0;		//percetage of silt in mixture;
		
		System.out.println("The percentage of silt is: " + siltP + "%");
			

		//==========================================================================================================
		//water percentage
		
		System.out.print("Enter percentage of water in soil btn 0-2:");
		double water = eza.nextDouble();									//reading the amount of water in land;
		
		//to sense the biodegradable components in soil will use  OPTICAL BIOSENSORS
		
		System.out.print("Enter percentage of organic matter:");
		double organic = eza.nextDouble();									//reading the amount of organic matters in land;
		
		// to sense the micro organisms will use microbial sensors;
		
		System.out.print("Enter percentage of micro organism:");
		double micro = eza.nextDouble();
		
		//To know the type and amount of gas in the land we will use gas detectors/gas sensors;
		
		System.out.print("Enter percentage of gases:");
		double gas = eza.nextDouble();
		
		//determination of soil pH, we will use Soil Moisture Sensors;
		
		System.out.print("Enter the pH of land:");
		double pH = eza.nextDouble();
		
		//determination of soil pH, we will use temperature sensors;
		
		System.out.print("Enter the temperature 45F - 85F:");
		double temp = eza.nextDouble();
		
		//determination of soil depth;
		
		System.out.print("Enter the depth 20.5 or less or greater:");
		double deep = eza.nextDouble();
		
		//==========================================================================================================
		//specifying the type of texture
		//sand soil= sand(86-100); silt(0-14); clay(0-10);
		//loam soil= sand(23-52); silt(28-50); clay(7-27);
		//silt soil= sand(0-20); silt(88-100); clay(0-12);
		//clay soil= sand(0-45); silt(0-40); clay(40-100);
		
		
		//==========================================================================================================
		//identification of what to be added based on the type of crop;
		
		
		System.out.println("Choose the crop: Carrots, Onion --->");
		String crop = eza.next().toLowerCase();								//any letters you will enter will be changed to lower case;
		
		//declaration of the variables to use in calculations of texture for carrots and maize;
		double lowerIncreamentPSand;
		double higherIncreamentPSand;
		double exactLowerValueOfSand;
		double exactHigherValueOfSand;
		double increamentOfSiltInSand;
		double clayAmount;
		double clayToAdd;
		double lowerIncreamentPSilt;
		double higherIncreamentPSilt;
		double exactLowerValueOfSilt;
		double exactHigherValueOfSilt;
		double increamentOfSand;
		double neededLowLevel;
		double neededHighLevel;
		double exactLowerValueToAdd;
		double exactHigherValueToAdd;
		double increamentOfSandAndSilt;
		double sandAmount;
		
		
		if (crop.equals("carrots")){
			
			//====================================================================================================================================================
			//calculation of sand level needed accordingly to the sand level of loam soil, because carrots grow healthier in loam soil;
			if (sandP < 23){
				lowerIncreamentPSand = 23 - sandP;							//calculations to know the minimum amount of sand to add in case it is less that 23%, which is the minimum %
				higherIncreamentPSand = 52 - sandP;							//calculations to know the maximum amount of sand to add "  "				"	 52%,				maximum %
				exactLowerValueOfSand = lowerIncreamentPSand*(sum/100);		//converting % to real grams as inputted by sensors;
				exactHigherValueOfSand = higherIncreamentPSand*(sum/100);	//converting % to real grams as inputted by the sensors;
				System.out.println("to neutralise sand You need to add between: "+ exactLowerValueOfSand +", and "+ exactHigherValueOfSand +" grams of sand per meter sq");//printing the real grams that will be added to obtain the loam soil;
			} 
			else if (sandP > 52 ){											//if the amount of sand is greater than 52%, that means silt has a lower percentage, where they must be the same or about to be the same;
				increamentOfSiltInSand = sand - silt;						//calculating the amount of silt to be added to be equal to the amount of sand in the portion
				clayAmount = increamentOfSiltInSand/2;						//amount of clay needed must be a half of any of the two;
				clayToAdd = clayAmount -clay;								//calculation of amount of clay to add so that it reaches their half;
				System.out.println("to neutralise sand you may add: "+ increamentOfSiltInSand + " grams of silt in a meter sq, and "+ clayToAdd + " rams of clay in a meter sq");//printing out the amount to add;
			}else {
				System.out.println("sand level is okay");					//if the amount of sand is between that range it is okay;
			}
			
			//====================================================================================================================================================
			//calculation of silt level needed accordingly to the level of loam soil;
			if (siltP < 28){												//if te amount of silt is lower 28& which is the lowest %; this calculations will happen.
				lowerIncreamentPSilt = 28 - siltP;							//calculation of the lower possible amount of silt that can be added to reach loam soil;
				higherIncreamentPSilt = 50 - siltP;							//calculation of the higher possible amount of silt to form loam soil;
				exactLowerValueOfSilt = lowerIncreamentPSilt*(sum/100);		//converting percentages in real grams as readed from percentage
				exactHigherValueOfSilt = higherIncreamentPSilt*(sum/100);	//converting percentages in real grams as readed from percentage
				System.out.println("to neutralise silt You need to add between: "+ exactLowerValueOfSilt +", and "+ exactHigherValueOfSilt +" grams of sand per meter sq");//printing the amount to be added;
			} 
			else if (siltP > 50 ){											//if silt percentage is greater than 50%, the following calculations will happen
				increamentOfSand = silt - sand;								//calculation of amount of sand to add to reach loam soil;
				clayAmount = silt/2;										//calculation of amount of clay needed so that the land is a complete loam soil;
				clayToAdd = clayAmount -clay;								//calculation of clay that will be added,
				System.out.println("to neutralise silt you may add: "+ increamentOfSand + " grams of silt in a meter sq, and "+ clayToAdd + " grams of clay in a meter sq");
			}else {
				System.out.println("silt level is okay");
			}
			
			//====================================================================================================================================================
			//calculation of clay level referring to the level of clay in loam soil
			if (clayP < 7){
				neededLowLevel = sum/10;									//
				neededHighLevel = sum/5;
				exactLowerValueToAdd = neededLowLevel - clay;
				exactHigherValueToAdd = neededHighLevel - clay;
				System.out.println("to neutralise clay You need to add between: "+ exactLowerValueToAdd +", and "+ exactHigherValueToAdd +" grams of clay per meter sq");
			} 
			else if (siltP > 27 ){
				increamentOfSandAndSilt = clay*2;
				System.out.println("to neutralise silt you may add: "+ increamentOfSandAndSilt + " grams of silt in a meter sq, and "+ increamentOfSandAndSilt + " grams of sand in a meter sq");
			}
			else {
				System.out.println("clay level is okay");
			}
			
			
			//==================================================================================================================================================== 
			if (water < 2){
				System.out.println("you need to irrigate twice a week, then plant in the next week");
			}
			else {
				System.out.println("level of water is okay");
			}
			
			//==================================================================================================================================================== 
			if (temp <45){
				float increamentOfTemperature = 45 - (float)temp;			// calculating the degrees required to reach the needed one(45);
				System.out.println("you need more "+ increamentOfTemperature +" derees");
			}
			else if(temp > 85){
				System.out.println("you need to wait for the cooler season at least at 85 degrees to cultivate carrots");
			}
			else {
				System.out.println("the temperature is ok for carrots");
			}
			
			//==================================================================================================================================================== 
			if (pH <6){
				System.out.println("you need to add 30g of wood ashes per sq meter");	//wood ashes is the cheapest thing they can add for reducing acidity in soil, but there are also some 
			}
			else {
				System.out.println("the pH is ok");
			}
			
			//====================================================================================================================================================
			if (deep < 20.5){
				System.out.println("You need to till your garden to atleast 20.5 cm depth,");
			}
			else {
				System.out.println("depth is okay");
			}
		}
		
		//==========================================================================================================
		//specifying the type of texture
		//sandy soil= sand(86-100); silt(0-14); clay(0-10);
		//loamy soil= sand(23-52); silt(28-50); clay(7-27);
		//silty soil= sand(0-20); silt(88-100); clay(0-12);
		//clay soil= sand(0-45); silt(0-40); clay(40-100);
		
		
		if (crop.equals("onion")){
			
			//====================================================================================================================================================
			//calculation of sand level needed accordingly to the sand level of Sandy soil, because onion grow healthier in sandy soil;
			if (sandP < 86){
				lowerIncreamentPSand = 86 - sandP;							//calculations to know the minimum amount of sand to add in case it is less that 86%, which is the minimum %
				higherIncreamentPSand = 100 - sandP;						//calculations to know the maximum amount of sand to add "  "				"	 100%,				maximum %
				exactLowerValueOfSand = lowerIncreamentPSand*(sum/100);		//converting % to real grams as inputted by sensors;
				exactHigherValueOfSand = higherIncreamentPSand*(sum/100);	//converting % to real grams as inputted by the sensors;
				System.out.println("to neutralise sand You need to add between: "+ exactLowerValueOfSand +", and "+ exactHigherValueOfSand +" grams of sand per meter sq");//printing the real grams that will be added to obtain the sandy soil;
			} 
			else {
				System.out.println("sand level is okay");					//if the amount of sand is between that range it is okay;
			}
			
			//====================================================================================================================================================
			//calculation of silt level needed accordingly to the level of loam soil;
			if (siltP > 14 ){											//if silt percentage is greater than 50%, the following calculations will happen
				
				//I multiply by 6.2, because the sum of silt and sand must be 14% or below, and when you multiply that 6.2, you will get the amount of sand needed to form 86%;
				sandAmount = (silt + sand) * 6.2;								//calculation of amount of total sand to form sandy soil;
				increamentOfSand  = sandAmount - sand;							//calculation of sand to be added in land;
				System.out.println("to neutralise silt you may add: "+ increamentOfSand + " grams of sand in a meter sq");
			} 
			else {
				System.out.println("silt level is okay");
			}
			
			//====================================================================================================================================================
			//calculation of clay level referring to the level of clay in loam soil
			if (clayP > 10){
				//I multiply by 6.2, because the sum of silt and sand must be 14% or below, and when you multiply that 6.2, you will get the amount of sand needed to form 86%;
				sandAmount = (silt + sand) * 6.2;								//calculation of amount of total sand to form sandy soil;
				increamentOfSand  = sandAmount - sand;							//calculation of sand to be added in land;
				System.out.println("to neutralise clay you may add: "+ increamentOfSand + " grams of sand in a meter sq");
			} 
			else {
				System.out.println("clay level is okay");
			}
			
			
			//==================================================================================================================================================== 
			if (water < 2){
				System.out.println("you need to irrigate twice a week, then plant in the next week");
			}
			else {
				System.out.println("level of water is okay");
			}
			
			//==================================================================================================================================================== 
			if (temp <55){
				float increamentOfTemp = 55- (float)temp;
				System.out.println("you need more: "+ increamentOfTemp +" degrees to cultivate onions");
			}
			else if(temp > 75){
				System.out.println("you need a cooler temperature atleast at 75 degrees");
			}
			else {
				System.out.println("the temperature is ok for carrots");
			}
			
			//==================================================================================================================================================== 
			if (pH <5.5){
				
				//this switch case will cast double to integer to help knowing the amount of fertiliser according to the pH detected;
				switch ((int)pH) {
				  case (1):
					System.out.println("you need to add 500ml of Ammonium nitrate per sq meter to increase the pH");
					break;
				  case (2):
					System.out.println("you need to add cup of 400ml of Ammonium nitrate per sq meter to increase the pH");
					break;
				  case (3):
					System.out.println("you need to add cup of 300ml of Ammonium nitrate per sq meter to increase the pH");
					break;
				  case (4):
					System.out.println("you need to add cup of 200ml of Ammonium nitrate per sq meter to increase the pH");
					break;
				  case (5):
					System.out.println("you need to add cup of 100ml of Ammonium nitrate per sq meter to increase the pH");
					break;
				}
			}
			
			//********************************************************************************************************************************************
			// switch case for specifying the amount of fertiliser to be added according to the pH read;
			else if (pH > 6.5){
				
				switch ((int)pH) {
					
				  case (14):
					System.out.println("you need to add 800mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (13):
					System.out.println("you need to add 700mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (12):
					System.out.println("you need to add 600mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (11):
					System.out.println("you need to add 500mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (10):
					System.out.println("you need to add 400mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (9):
					System.out.println("you need to add 300mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (8):
					System.out.println("you need to add 200mg of ammonium sulfate per sq meter to increase the pH");
					break;
				  case (7):
					System.out.println("you need to add 100mg of ammonium sulfate per sq meter to increase the pH");
					break;
				}
			}
			else {
				System.out.println("the pH is ok");
			}
			
			//====================================================================================================================================================
			if (deep < 20.5){
				System.out.println("You need to till your garden to atleast 20.5 cm depth,");
			}
			else {
				System.out.println("depth is okay");
			}
		}
		
	}
}

