
public class TrainLinkedListApp {
	BasicLinkedList<TrainCar> train = new BasicLinkedList<TrainCar>();

	public static void main(String[] args) {
		TrainLinkedListApp app = new TrainLinkedListApp();
		app.buildInitialTrain();
				
		//print out the train size
		System.out.println(app.trainSize());
		
		//first stop, we remove a car and add a couple more
		app.firstStop();

		//print out the train size
		System.out.println("After First Stop train size: " + app.trainSize());

		//second stop, we need to remove all the tankers
		app.secondStop();

		//print out the train size
		System.out.println("After Second Stop train size: " + app.trainSize());
		
		//at the last stop we remove all of the train cars and we're done
		app.lastStop();

		//print out the train size
		System.out.println("After Last Stop train size: " + app.trainSize());
	}
	
	private int trainSize() {
		return train.size();
	}
	
	private void buildInitialTrain() {
		//build the train for it's initial trip
		TrainCar car1 = new TrainCar(CarType.BOXCAR, "Amazon Packages");
		TrainCar car2 = new TrainCar(CarType.FLATBED, "Farm Machinery");
		TrainCar car3 = new TrainCar(CarType.BOXCAR, "Paper");
		TrainCar car4 = new TrainCar(CarType.BOXCAR, "Grease");
		TrainCar car5 = new TrainCar(CarType.TANKER, "Crude Oil #1");
		TrainCar car6 = new TrainCar(CarType.TANKER, "Crude Oil #2");
		TrainCar car7 = new TrainCar(CarType.TANKER, "Crude Oil #3");
		TrainCar car8 = new TrainCar(CarType.FLATBED, "Empty Shipping Container");
		TrainCar car9 = new TrainCar(CarType.HOPPER, "Wheat Grain");
		TrainCar car10 = new TrainCar(CarType.HOPPER, "Coal");
		
		//connect the cars
		train.add(car1);
		train.add(car2);
		train.add(car3);
		train.add(car4);
		train.add(car5);
		train.add(car6);
		train.add(car7);
		train.add(car8);
		train.add(car9);
		train.add(car10);
		
		//test out the find and get
		//see if we can find the position of the paper box car and then get it
		int position = train.find(car3);
		TrainCar paperCar = train.get(position);
		System.out.println("Train is built correctly. found and retrieved the paper car at position: " + paperCar + " - " + position);

		//print out the train cars
		System.out.println(train);
	}
	
	private void firstStop() {
		//at this stop we need to pull off the first box car and insert a new BoxCar after the farm machinery
		TrainCar boxcar = train.remove();
		
		System.out.println("First Stop: Removed - " + boxcar);
		
		TrainCar newBoxcar = new TrainCar(CarType.BOXCAR, "Farm Fence Posts and Barbwire");
		train.insert(newBoxcar, 1);

		//print out the train cars
		System.out.println(train);
	}
	
	private void secondStop() {
		//at this stop we need to pull off all of the tanker cars.  They should start at position 5 and there's 3 of them
		TrainCar car = train.removeAt(5);
		System.out.println("Second Stop: Removed - " + car);
		
		car = train.removeAt(5);
		System.out.println("Second Stop: Removed - " + car);
		
		car = train.removeAt(5);
		System.out.println("Second Stop: Removed - " + car);
		
		//print out the train cars
		System.out.println(train);
	}

	private void lastStop() {
		//at this stop we simply pull the remaining cars off of the train until we have no more train.
		
		try{
			while(true) {
				TrainCar car = train.remove();
				System.out.println("Last Stop: Removed - " + car);
			}
		} catch (IllegalStateException ise) {
			//when we get an ise that means we don't have any more cars to remove and the train is now empty
		}
				
		//print out the train cars
		System.out.println(train);
	}

	class TrainCar {
		private CarType type;
		private String contents;
		
		public TrainCar(CarType carType, String carContents) {
			this.type = carType;
			this.contents = carContents;
		}	
		
		public String toString() {
			return type.toString() + " - " + contents;
		}
	}
	
	enum CarType {
		BOXCAR, TANKER, FLATBED, HOPPER
	}
}
