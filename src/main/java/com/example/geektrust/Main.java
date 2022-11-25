package com.example.geektrust;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = null;
		if (args.length == 0 || args == null) {
			BufferedReader br_console = new BufferedReader(new InputStreamReader(System.in));
			br = br_console;
		} else {
			String fileName = "sample_input/" + args[0];// input1.txt
			BufferedReader br_file = new BufferedReader(new FileReader(new File(fileName)));
			br = br_file;
		}

		Map<String, Integer> map1 = new HashMap<>();
		Map<String, List<PassengerSource>> metroCardPassengerSource = new HashMap<>();

		Set<String> centralCheckIn = new HashSet<>();
		Set<String> airportCheckIn = new HashSet<>();

		int totalCollectionAirport = 0;
		int totalCollectionCentral = 0;
		int collectionAirport = 0;
		int collectionCentral = 0;

		int[] airportPassenger = new int[3];
		int[] centralPassenger = new int[3];

		while (true) {
			String input = br.readLine();
			if (input == null) {
				break;
			}
			if (input.isEmpty()) {
				continue;
			}
			String[] arr = input.split(" ");
			ActionType actionType = ActionType.forName(arr[0]);
			if (actionType == null) {
				throw new Exception("Invalid action" + arr[0]);
			}
			String result[] = actionType.perform(arr);
			
			if (actionType.toString().equals("PRINT_SUMMARY")) {
				System.out.print("TOTAL_COLLECTION CENTRAL " );
				PrintPassengerSummary.printPassenger(centralPassenger, metroCardPassengerSource, "CENTRAL");
				System.out.print("TOTAL_COLLECTION AIRPORT ");
				PrintPassengerSummary.printPassenger(airportPassenger, metroCardPassengerSource, "AIRPORT");
			} else if (actionType.toString().equals("BALANCE")) {
				map1.put(result[0], Integer.parseInt(result[1]));
			} else {
				PassengerType passengerType = PassengerType.valueOf(result[1]);

				if (result[2].equals("CENTRAL")) {
					switch (passengerType) {
					case KID:
						centralPassenger[0]++;
						break;
					case ADULT:
						centralPassenger[1]++;
						break;
					case SENIOR_CITIZEN:
						centralPassenger[2]++;
						break;
					default:
						System.out.println("central switch breaker activated!");
					}
					centralCheckIn.add(result[0]);
					collectionCentral = BillSummary.getCost(result, map1, airportCheckIn);
					totalCollectionCentral += collectionCentral;
				} else {
					switch (passengerType) {
					case KID:
						airportPassenger[0]++;
						break;
					case ADULT:
						airportPassenger[1]++;
						break;
					case SENIOR_CITIZEN:
						airportPassenger[2]++;
						break;
					default:
						System.out.println("airpost switch breaker activated!");
					}
					airportCheckIn.add(result[0]);
					collectionAirport = BillSummary.getCost(result, map1, centralCheckIn);
					totalCollectionAirport += collectionAirport;
				}
				List<PassengerSource> passengerSourceList = metroCardPassengerSource.getOrDefault(result[0], new ArrayList<>());
				passengerSourceList.add(new PassengerSource(passengerType, result[2]));
				metroCardPassengerSource.put(result[0], passengerSourceList);
			}
		}
	}
}
