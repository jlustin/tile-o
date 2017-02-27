package ca.mcgill.ecse223.tileo.view;

import javax.swing.JPanel;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.NormalTile;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;


public class TilePanel extends JPanel{

	/**
	 * Create the panel.
	 */
	public TilePanel() {
		TileO tileO = TileOApplication.getTileO();
		Game currentGame = tileO.getCurrentGame();
//		Tile e = new NormalTile(1, 2, currentGame);
//		new NormalTile(1, 1, currentGame);
//		new NormalTile(5, 5, currentGame);
//		
		List<Tile> listTiles = currentGame.getTiles();
		//listTiles.add(e);
		
		int i = getXAxis(currentGame);
		int j = getYAxis(currentGame);
		//TODO: set default size and bigger size
		if (i<6) {
			i=6;
		}
		if (j<6) {
			j=6;
		}
		
		JPanel[][] panelHolder = new JPanel[i][j];
		setLayout(new GridLayout(i, j, 2, 2));
		for(int m = 0; m < i; m++) {
		   for(int n = 0; n < j; n++) {
		      panelHolder[m][n] = new JPanel();
		      add(panelHolder[m][n]);
		      }
		   }
		 
		for (Tile aTile: listTiles) {
			 
			panelHolder[aTile.getX()][aTile.getY()].add(new JButton("Foo") );
			
			
		}
		
		
	}

	
	public int getXAxis(Game aGame) {
		List<Tile> listTiles = aGame.getTiles();
		int xSize=0;
		
		for (Tile tempTile: listTiles) {
			if (tempTile.getX()>xSize){
				xSize = tempTile.getX();
			}
		}
		
		return xSize;		
	}
	
	public int getYAxis(Game aGame) {
		List<Tile> listTiles = aGame.getTiles();
		int ySize=0;
		
		for (Tile tempTile: listTiles) {
			if (tempTile.getY()>ySize){
				ySize = tempTile.getY();
			}
		}
		
		return ySize;		
	}

}
