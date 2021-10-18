package no.hvl.dat100.prosjekt.kontroll;

import no.hvl.dat100.prosjekt.kontroll.spill.Handling;
import no.hvl.dat100.prosjekt.kontroll.spill.HandlingsType;
import no.hvl.dat100.prosjekt.modell.Kort;
import no.hvl.dat100.prosjekt.modell.Kortfarge;

public class Test {

	public static void main(String[] args) {
		Spill spill = new Spill();
		Bord bord = spill.getBord();
		
		spill.start();
		
		ISpiller spiller = spill.getSyd();
		
		Kort[] allekort = spiller.getHand().getAlleKort();
		Kort kort = allekort[0];
		System.out.println(kort.toString());
		System.out.println();
		
		// teste legg ned handling
		Handling handling = new Handling(HandlingsType.LEGGNED,kort);
		
		spill.utforHandling(spiller, handling);
		

		System.out.println(spiller.getHand().getAlleKort()[0] + " " + spiller.getHand().getAlleKort()[1]);
		
		System.out.println(kort.toString() + " " + spill.getBord().seOversteBunkeTil());
		
//		assertEquals(kort,spill.getBord().seOversteBunkeTil());
//		assertFalse(spiller.getHand().har(kort));
	}

}
