package com.example.carte;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Deque;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

import com.example.swing.FrameForDemoMaker;
import com.example.util.ResourceUtility;

public class CarteApp extends FrameForDemoMaker {
	private static final int ROW_COUNT = 4;
	private static final int COLUMN_COUNT = 6;
	private ImageIcon dosCarte = ResourceUtility.loadImage("images/dos.png");
	private Jeu jeu = new Jeu();
	private EtatMemoire memoire = new EtatMemoire();

	public CarteApp() throws IOException {
		super("Mémoire");
		setDefaultBounds(100, 100, 900, 600);
	}

	@Override
	public void init(JFrame frame) {
		Container cp = frame.getContentPane();
		cp.setLayout(new GridLayout(ROW_COUNT, COLUMN_COUNT));

		Deque<ImageIcon> pioche;
		try {
			pioche = jeu.creerPioche();
			for (ImageIcon image : pioche) {
				cp.add(createButton(image));
			}

//			while (!pioche.isEmpty()) {
//				cp.add(createButton(pioche[i]));
//			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public JComponent createButton(ImageIcon image) {

		ImageIcon imageIcon = image; // Récupération depuis la pioche
		JToggleButton button = new JToggleButton(dosCarte);
		button.setSelectedIcon(imageIcon);
		button.setDisabledIcon(imageIcon);
		button.setDisabledSelectedIcon(imageIcon);

//		JButton button = new JButton(imageIcon);

		button.putClientProperty("carte", imageIcon.getDescription());

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				memoire.nouveauBoutonSelectionne(button);

			}
		});

		return button;

//		JButton button = new JButton(pioche.pop());
//		return button;
	}

	public static void main(String[] args) throws IOException {
		CarteApp example = new CarteApp();
		SwingUtilities.invokeLater(example);
	}
}