package no.hvl.dat100.prosjekt.modell;

import java.util.Random;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling samling av kort som skal sorteres.
	 */

	public static void sorter(KortSamling samling) {

		int pos;

		Kort[] sorterteKort = new Kort[samling.getAntallKort()];

		for (Kort kort : samling.getAlleKort()) {
			pos = 0;
			for (Kort sammenlign : samling.getAlleKort()) {
				if (kort.compareTo(sammenlign) > 0) {
					pos++;
				}
			}
			sorterteKort[pos] = kort;
		}

		samling.fjernAlle();
		for (Kort k : sorterteKort) {
			samling.leggTil(k);
		}

	}

	/**
	 * Stokkar en kortsamling.
	 * 
	 * @param samling samling av kort som skal stokkes.
	 */
	public static void stokk(KortSamling samling) {

		Random rand = new Random();
		Kort[] kort = samling.getAlleKort();
		Kort tempKort;
		int pos1, pos2;
		int grense = samling.getAntallKort();

		if (grense > 1) {
			for (int i = 0; i < samling.getAntallKort() * 4; i++) {
				pos1 = rand.nextInt(grense);
				pos2 = rand.nextInt(grense);

				tempKort = kort[pos1];

				kort[pos1] = kort[pos2];
				kort[pos2] = tempKort;
			}

			samling.fjernAlle();

			for (Kort k : kort) {
				samling.leggTil(k);
			}
		}

	}

}
