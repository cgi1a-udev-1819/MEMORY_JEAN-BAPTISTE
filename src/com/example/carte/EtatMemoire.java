package com.example.carte;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JToggleButton;

public class EtatMemoire {

	List<JToggleButton> listeBoutonsSelectionnes = new LinkedList<>();
	int nombreCoups = 0;
	int nombreDoublons = 0;

	public void nouveauBoutonSelectionne(JToggleButton button) {

		nombreCoups++;

		if (listeBoutonsSelectionnes.size() == 1) {
			for (JToggleButton buttonList : listeBoutonsSelectionnes) {
				if (button.getClientProperty("carte") == buttonList.getClientProperty("carte")) {
					button.setEnabled(false);
					buttonList.setEnabled(false);
					nombreDoublons++;
					System.out.println("Doublons trouve:" + nombreDoublons);

				} else {
					button.setSelected(false);
					buttonList.setSelected(false);
					System.out.println("Coup effectué:" + nombreCoups);

				}

				listeBoutonsSelectionnes.clear();
			}
		} else {
			listeBoutonsSelectionnes.add(button);
		}

	}
}
