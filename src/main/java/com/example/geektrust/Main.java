package com.example.geektrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = null;
    	if(args.length == 0|| args == null){
    		BufferedReader br_console = new BufferedReader(new InputStreamReader(System.in));
    		br = br_console;
    	}
    	else {
    		String fileName = "sample_input/"+args[0];//input1.txt
    		BufferedReader br_file = new BufferedReader(new FileReader(new File(fileName)));
    		br = br_file;
    	}
    	
    	Map<String, Integer> map1 = new HashMap<>() ;
    	Map<String, Pair> map2 = new HashMap<>();
    	
    	Set<String> centralCheckIn = new HashSet<>();
    	Set<String> airportCheckIn = new HashSet<>();
    	
    	int totalCollectionAirport = 0;
    	int totalCollectionCentral = 0;
    	int collectionAirport = 0;
    	int collectionCentral = 0;
    	
    	while(true) {
    		String input = br.readLine();
    		if(input == null) {
    			break;
    		}
    		if(input.isEmpty()) {
    			continue;
    		}
    		String[] arr = input.split(" ");
    		ActionType actionType = ActionType.forName(arr[0]);
    		if(actionType == null) {
    			throw new Exception ("Invalid action" + arr[0]);
    		}
    		String result[] = actionType.perform(arr);
    		if(actionType.toString().equals("PRINT_SUMMARY")) {
//    			BillSummary.genereateBill(map1, map2);
    		}
    		else if(actionType.toString().equals("BALANCE")){
    			map1.put(result[0], Integer.parseInt(result[1]));
    		}
    		else {
    			PassengerType passengerType = PassengerType.valueOf(result[1]);
    			if(result[2].equals("CENTRAL")) {
    				centralCheckIn.add(result[0]);
    				collectionCentral = BillSummary.getCost(result, map1, airportCheckIn);
    				totalCollectionCentral += collectionCentral;
    				System.out.println("central="+totalCollectionCentral);
    			}
    			else {
    				airportCheckIn.add(result[0]);
    				collectionAirport = BillSummary.getCost(result, map1, centralCheckIn);
    				totalCollectionAirport += collectionAirport;
    				System.out.println("Airport="+totalCollectionAirport);
    			}
    			map2.put(result[0], new Pair(passengerType, result[2]));
    		}
    	}
    	System.out.println("total Central Collection "+totalCollectionCentral);
    	System.out.println("total Airport Collection "+totalCollectionAirport);
    }
}
