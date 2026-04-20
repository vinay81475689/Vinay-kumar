package activities;


		public class car
		{
			String color;
			String transmission;
			int make;
			int tyres;
			int doors;
	     
		public car(String color,String transmission,int make){
			 this.color = color;
			 this.transmission = transmission;
			 this.make = make;
			 this.doors= 4;
			 this.tyres = 4;
		 }
		
	public void displayDetails() {
		System.out.println("color :" + this.color);
		System.out.println("Transmission typr :" + this.transmission);
		System.out.println("Year of nabufacture :" + this.make);
		System.out.println("No : of Tyres :" + this.tyres);
		System.out.println("No : of doors :" + this.doors);
	}
	public accelerate() {
		System.out.print("car is moving");
	}
	public brake() {
		System.out.println("car is stopped");
	}

	
}
