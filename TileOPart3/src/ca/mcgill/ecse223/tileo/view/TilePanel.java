package ca.mcgill.ecse223.tileo.view;

import javax.swing.JPanel;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.ActionTile;
import ca.mcgill.ecse223.tileo.model.Connection;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.NormalTile;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;
import ca.mcgill.ecse223.tileo.model.WinTile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;


public class TilePanel extends JPanel{

	//UI elements
	private List<Rectangle2D> rectangles = new ArrayList<Rectangle2D>();
	private static final int MINAXISSIZE = 10;
	
	// data element;
	private Game myGame;
	private HashMap<Rectangle2D, Tile> tiles;
	private HashMap<Rectangle2D, Connection> connections;
	private Tile selectedTile;
	private Connection selectedConnection;
	
	
	
	
	public TilePanel(Game game) {
		super();
		//you guys can add tiles here to try the layout
		//add the tiles in the same format and only here
//		new NormalTile(1, 1, game);
//		new NormalTile(1, 2, game);
//		new NormalTile(13, 9, game);
//		new NormalTile(10, 10, game);
//		new NormalTile(8, 19, game);
//		new NormalTile(3, 5, game);
//		new NormalTile(17, 13, game);
//		new NormalTile(11, 18, game);
//		new NormalTile(2,1, game);
//		new ActionTile(3,1, game, 2);
		
		init(game);
		
	}
	
	
	private void init(Game game) {
		this.myGame = game;
		tiles = new HashMap<Rectangle2D, Tile>();
		connections = new HashMap<Rectangle2D, Connection>();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("The mouse has been pressed " + "x: " + x + " y:" + y);
				for (Rectangle2D rectangle : rectangles) {
					if (rectangle.contains(x, y)) {
						selectedTile = tiles.get(rectangle);
						System.out.println("A legit tile has been selected. " + "x: " + selectedTile.getX() + " y:" + selectedTile.getY());
						break;
					}
				}
				repaint();
			}
		});
	}
	
	public void setGame(Game game) {
		init(game);
		repaint();
	}
	
	//below are 3 helper methods, DONT TOUCH :)))
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
	
	public int equalize(int xAxisSize, int yAxisSize) {
		int biggest = MINAXISSIZE;
		
		if (xAxisSize>MINAXISSIZE || yAxisSize>MINAXISSIZE) {
			if(xAxisSize>yAxisSize) {
				biggest = xAxisSize;
			}
			else {
				biggest = yAxisSize;
			}
		}		
		return biggest;
	}
	
	//do not touch
	public void doDrawing(Graphics g) {		
		if (myGame != null) {
			Graphics2D g2d = (Graphics2D) g.create();
			
			//base size
			int axisSize = equalize(getXAxis(myGame), getYAxis(myGame));;
			float squareSize = (float) ((700/axisSize) * (2.9/5.0));
			float SPACING = (float) ((700/axisSize) * (1.0/5.0));
			
			//the things commented below were for me to check my math
//			float size = (float) (axisSize*squareSize + SPACING*(axisSize*2));
//			System.out.println(size);
//			System.out.println(axisSize);
//			System.out.println(squareSize);
//			System.out.println(SPACING);
			for (Tile aTile: myGame.getTiles()) {
				int x = aTile.getX()-1;
				int y = aTile.getY()-1;
				float locationX = (float) (squareSize*x + SPACING*(2*x + 1));
				float locationY = (float) (squareSize*y + SPACING*(2*y + 1));

				//the below was used for testing
				//System.out.println(aTile.toString());
				Rectangle2D rect = new Rectangle2D.Float(
						locationX, 
						locationY, 
						squareSize, 
						squareSize);
				rectangles.add(rect);
				tiles.put(rect, aTile);
				
				if(aTile instanceof NormalTile){
					g2d.setColor(Color.BLUE);
				}
				
				if(aTile instanceof WinTile){
					g2d.setColor(Color.BLACK);
				}
				
				if(aTile instanceof ActionTile){
					g2d.setColor(Color.RED);
				}
				
				g2d.draw(rect);
				//if instead you want a full colored tile, uncomment the below and comment the above
				g2d.fill(rect);
				repaint();
			}
			
			//horizontal
//			for (Tile aTile: myGame.getTiles()){
//				for(Tile bTile: myGame.getTiles()){
//					
//				}
//			}
			
		}
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
		repaint();
	}
	

	
	

}






