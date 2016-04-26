package task6;

import java.util.*;
import java.io.*;

//Denna klass ärver Proc, det gör att man kan använda time och signalnamn utan punktnotation
//It inherits Proc so that we can use time and the signal names without dot notation

class Gen extends Proc{

	//Slumptalsgeneratorn startas:
	//The random number generator is started:
	Random slump = new Random();

	//Generatorn har två parametrar:
	//There are two parameters:
	public Proc sendTo;    //Anger till vilken process de genererade kunderna ska skickas //Where to send customers
	public double lambda;  //Hur många per sekund som ska generas //How many to generate per second
	private double customerTime;

	//Här nedan anger man vad som ska göras när en signal kommer //What to do when a signal arrives
	public void TreatSignal(Signal x){
		switch (x.signalType){
			case READY:{
				SignalList.SendSignal(ARRIVAL, sendTo, time);
				customerTime = time + expDist(lambda);
				if (customerTime < 480) {
					SignalList.SendSignal(READY, this, customerTime);
				}
				break;
			}
		}
	}
	
	public double expDist(double lambda){
		return (-1/lambda) * Math.log(1 - slump.nextDouble());
	}
}