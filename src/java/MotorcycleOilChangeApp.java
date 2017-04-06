
public class MotorcycleOilChangeApp {
	//we will use a 12 piece socket set for this job
	private BasicHashTable<String, String> toolset = new BasicHashTable<>(12);
	
	public static void main(String [] args) {
		MotorcycleOilChangeApp app = new MotorcycleOilChangeApp();
		app.changeOil();
	}
	
	public void changeOil() {
		buildToolset();
		
		//remove skid plate to get at the oil pan
		removeSkidPlate();
		
		//drain the oil by removing the drain plug and refill
		drainAndReplaceOil();
		
		//replace the skid plate
		replaceSkidPlate();
		
		emptyToolset();
	}
	
	/**
	 * This loads the toolbox with all the needed tools
	 */
	private void buildToolset() {
		toolset.put("8mm", "8mm Socket");
		toolset.put("10mm", "10mm Socket");
		toolset.put("12mm", "12mm Socket");
		toolset.put("14mm", "14mm Socket");
		toolset.put("17mm", "17mm Socket");
		toolset.put("1/4sae", "1/4sae Socket");
		toolset.put("3/8sae", "3/8sae Socket");
		toolset.put("1/2sae", "1/2sae Socket");
		toolset.put("5/8sae", "5/8sae Socket");
		toolset.put("3/4sae", "3/4sae Socket");
		toolset.put("1/4d", "1/4 socket wrench");
		toolset.put("2de", "2 inch Drive extension");
		System.out.println("Toolset size: " + toolset.size());
	}
	
	private void emptyToolset() {
		toolset.delete("8mm");
		toolset.delete("10mm");
		toolset.delete("12mm");
		toolset.delete("14mm");
		toolset.delete("17mm");
		toolset.delete("1/4sae");
		toolset.delete("3/8sae");
		toolset.delete("1/2sae");
		toolset.delete("5/8sae");
		toolset.delete("3/4sae");
		toolset.delete("1/4d");
		toolset.delete("2de");
		System.out.println("Toolset size: " + toolset.size());
	}
	
	private void removeSkidPlate() {
		//get the 10mm socket and wrench
		String socket = toolset.get("10mm");
		String wrench = toolset.get("1/4d");
		System.out.println("Removed 4 skid plate nuts with the " + socket + " and " + wrench);
	}
	
	private void replaceSkidPlate() {
		//get the 10mm socket and wrench
		String socket = toolset.get("10mm");
		String wrench = toolset.get("1/4d");
		System.out.println("Replaced 4 skid plate nuts with the " + socket + " and " + wrench);
	}

	private void drainAndReplaceOil() {
		//this motorcycle's drain plug nut is 17mm.  That's a strange size, check to see if the toolset has it
		System.out.println("Toolset has 17mm socket: " + toolset.hasValue("17mm Socket") + " - " + toolset.hasKey("17mm"));

		String socket = toolset.get("17mm");
		String wrench = toolset.get("1/4d");
		System.out.println("Removed oil drain plug with " + socket + " and " + wrench);
		System.out.println("Drained 1.7 quarts of oil");
		System.out.println("Replaced oil drain plug with " + socket + " and " + wrench);
		System.out.println("Added 1.7 quarts of oil");
	}
}
