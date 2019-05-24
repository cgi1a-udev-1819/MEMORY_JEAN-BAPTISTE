package com.example.carte;

import java.io.IOException;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;

import com.example.util.ResourceUtility;

public class Jeu {
	private ImageIcon[][] figures = loadImages();

	public Jeu() throws IOException {
	}

	public ImageIcon[][] loadImages() throws IOException {
		int rows = 4;
		int cols = 3;
		ImageIcon[][] images = ResourceUtility
				.splitImageIcon(ResourceUtility.loadBufferedImage("images/butterfly2.png"), rows, cols);

		for (int i = 0; i < images.length; i++) {
			for (int j = 0; j < images[i].length; j++) {
				images[i][j].setDescription(i + "-" + j);

			}

		}

		return images;
	}

	public Deque<ImageIcon> creerPioche() throws IOException {

		Deque<ImageIcon> pioche = new LinkedList<ImageIcon>();

		ImageIcon[][] images = figures;

		for (int i = 0; i < images.length; i++) {
			for (int j = 0; j < images[i].length; j++) {
				pioche.add(images[i][j]);
				pioche.add(images[i][j]);
			}
		}

		Collections.shuffle((List<?>) pioche);

		return pioche;
	}
}