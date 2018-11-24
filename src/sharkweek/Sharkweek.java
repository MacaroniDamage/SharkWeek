package sharkweek;

public class Sharkweek {

	public static void main(String[] args) {
		int zyklus = 0;
		
		if(args.length > 0) {
			if(args[0].equals("show"))
			{
				System.out.println(args.length);
				if(args.length == 1)
				{
					System.out.println("Der Kalender wird angezeigt");
					System.out.println(args.length);
				}
				else if(args.length > 2)
				{	
					if(args[1].equals("prognosis"))
					{
						if(args.length == 2) 
						{
							System.out.println("Der Kalender mit den Zyklen wird angezeigt!");
						}
						else if(args.length == 3) 
						{
							//Intervall vom String in ein Integer konvertiert
							zyklus = Integer.parseInt(args[2]);
							//Gibt den gespeicherten Zyklus aus
							System.out.println("Ein neuer Zyklus wurde definiert!");
							System.out.println("Intervall: " + zyklus);
						}
					}
				}
			}//END OF ARGUMENT: SHOW
			if(args[1].equals("setperiod"))
			{
				
			}
		}//END OF ARGUMENTS
		
	}

}
