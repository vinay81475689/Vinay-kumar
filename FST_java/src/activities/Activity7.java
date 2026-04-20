package activities;

interface BicycleParts {
	int tyres = 2;
	int maxSpeed = 30;
}

interface BicycleOperations {
	public void speedUp(int increment);

	public void applyBrake(int decrement);
}

class Bicycle implements BicycleParts, BicycleOperations {
	int gears;
	int currentSpeed;

	public Bicycle(int gears, int currentSpeed) {
		this.gears = gears;
		this.currentSpeed = currentSpeed;

	}

	public String bicycleDesc() {
		return ("no of gears are" + this.gears + "\nSpeed of bicycle is " + this.currentSpeed
				+ "\nMax Speed of bicycle is " + maxSpeed);

	}

	public void speedUp(int increment) {
		currentSpeed += increment;
		System.out.println("current speed " + currentSpeed);
	}

	public void applyBrake(int decrement) {
		currentSpeed -= decrement;
		System.out.println("Current Speed" + currentSpeed);
	}
}

class MountainBike extends Bicycle {
	int seatHeight;

	public MountainBike(int gears, int currentSpeed, int seatHeight) {
		super(gears, currentSpeed);
		this.seatHeight = seatHeight;
	}

	public String bicycleDesc() {
		return ("no of gears are" + this.gears + "\nSeat Height is" + this.seatHeight + "\nSpeed of bicycle is "
				+ this.currentSpeed + "\nMax Speed of bicycle is " + maxSpeed);

	}
}

public class Activity7 {
	public static void main(String[] args) {
		MountainBike mb = new MountainBike(6, 0, 5);
		mb.bicycleDesc();
		mb.speedUp(5);
	}
}
