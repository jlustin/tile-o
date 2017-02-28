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

	//random strokes || gradients
	final static float dash1[] = {10.0f};
    final static BasicStroke dashed =
        new BasicStroke(1.0f,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10.0f, dash1, 0.0f);
    
    GradientPaint redtowhite = new GradientPaint(0,0,Color.RED,100, 0,Color.WHITE);
	
	
	public boolean aTileIsSelected = false;
	public Tile selectedTile;
	

	public boolean aConnectionIsSelected = false;
	public Connection selectedConnection;


	//UI elements
	private List<Rectangle2D> rectangles = new ArrayList<Rectangle2D>();
	private static final int MINAXISSIZE = 10;
	
	// data element;
	private Game myGame;
	private HashMap<Rectangle2D, Tile> tiles;
	private HashMap<Tile, Rectangle2D> tRectangles;
	private HashMap<Rectangle2D, Connection> connections;

	
	public TilePanel(Game game) {
		super();
		//you guys can add tiles here to try the layout
		//add the tiles in the same format and only here
		
		Tile t1 = new NormalTile(1, 1, game);
		Tile t2 = new NormalTile(1, 2, game);
		new NormalTile(13, 9, game);
		Tile t4 = new NormalTile(10, 10, game);
		Tile t5 = new NormalTile(10, 11, game);
		new NormalTile(8, 9, game);
		new NormalTile(3, 5, game);
		new NormalTile(11, 13, game);
		new NormalTile(11, 10, game);
		Tile t3 = new NormalTile(2,1, game);
		new ActionTile(3,1, game, 2);
		Connection connect = new Connection(game);
		t1.addConnection(connect);
		t2.addConnection(connect);
		Connection c2 = new Connection(game);
		c2.addTile(t1);
		c2.addTile(t3);
		init(game);
		Connection c3 = new Connection(game);
		c3.addTile(t4);
		c3.addTile(t5);
		
	}
	
	
	private void init(Game game) {
		this.myGame = game;
		tiles = new HashMap<Rectangle2D, Tile>();
		connections = new HashMap<Rectangle2D, Connection>();
		tRectangles = new HashMap<Tile, Rectangle2D>();
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("The mouse has been pressed " + "x: " + x + " y:" + y);								
				for (Rectangle2D rectangle : rectangles) {
					if (rectangle.contains(x, y)) {
						if(tiles.containsKey(rectangle)){
							selectedTile = tiles.get(rectangle);
							System.out.println("A legit tile has been selected. " + "x: " + selectedTile.getX() + " y:" + selectedTile.getY());
							//System.out.println("number of players");
							break;
						}
						else if(connections.containsKey(rectangle)){
							selectedConnection = connections.get(rectangle);
							System.out.println("a legit connection has been selected");
							break;
						}
//						break;

					
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
			
			float gridspace = (float)(squareSize + 2*SPACING);
			float locationX = SPACING;
			float locationY = SPACING;
			
			//the things commented below were for me to check my math
//			float size = (float) (axisSize*squareSize + SPACING*(axisSize*2));
//			System.out.println(size);
//			System.out.println(axisSize);
//			System.out.println(squareSize);
//			System.out.println(SPACING);
			for (Tile aTile: myGame.getTiles()) {
				int x = aTile.getX()-1;
				int y = aTile.getY()-1;
				locationX = (float) (SPACING + gridspace*x);
				locationY = (float) (SPACING + gridspace*y);

				//the below was used for testing
				//System.out.println(aTile.toString());
				Rectangle2D rect = new Rectangle2D.Float(
						locationX, 
						locationY, 
						squareSize, 
						squareSize);
				rectangles.add(rect);
				tiles.put(rect, aTile);
				tRectangles.put(aTile, rect);
				
				if(aTile instanceof NormalTile){
					g2d.setColor(Color.BLUE);
				}
				
				else if(aTile instanceof WinTile){
					g2d.setColor(Color.BLACK);
				}
				
				else if(aTile instanceof ActionTile){
					g2d.setColor(Color.RED);
				}
				
				g2d.draw(rect);
				//if instead you want a full colored tile, uncomment the below and comment the above
				g2d.fill(rect);

				
				if (selectedTile != null && selectedTile.equals(aTile)) {
					aTileIsSelected = true;
<<<<<<< Updated upstream
					g2d.setStroke(dashed); //doesn't work. I want to show the tile differently when selected
=======
					Rectangle2D rectangle = tRectangles.get(aTile);
					
					g2d.setColor(Color.PINK); //doesn't work. I want to show the tile differently when selected
				
					g2d.fill(rectangle);
					
					
>>>>>>> Stashed changes
				}

				repaint();
			}
			
			//horizontal
//			for (Tile aTile: myGame.getTiles()){
//				for(Tile bTile: myGame.getTiles()){
//					
//				}
//			}
			
			
			for (Connection aConnection: myGame.getConnections()){
				List<Tile> tempTiles = aConnection.getTiles();
				if(tempTiles.size() == 2){
					Tile tile1 = tempTiles.get(0);
					Tile tile2 = tempTiles.get(1);
					//horizontal
					if (isH(tile1, tile2)) {
						//use hRect
						
						locationX = (float) (SPACING + squareSize + smallestXIndex(tile1, tile2)*gridspace);
						locationY = (float) (((700/axisSize)/2 - SPACING/2) + smallestYIndex(tile1, tile2)*gridspace);
						Rectangle2D rect = new Rectangle2D.Float(
								locationX, 
								locationY, 
								2*SPACING, 
								SPACING);
						rectangles.add(rect);
						connections.put(rect, aConnection);
						g2d.setColor(Color.BLACK);
						g2d.fill(rect);
					}					
					else if(isV(tile1, tile2)) {
						locationX = (float) (((700/axisSize)/2 - SPACING/2) + smallestXIndex(tile1, tile2)*gridspace);
						locationY = (float) (SPACING + squareSize + smallestYIndex(tile1, tile2)*gridspace);

						Rectangle2D rect = new Rectangle2D.Float(
								locationX, 
								locationY, 
								SPACING, 
								2*SPACING);
						rectangles.add(rect);
						connections.put(rect, aConnection);
						g2d.setColor(Color.BLACK);
						g2d.fill(rect);
					}										
				}
				
				if (selectedConnection != null && selectedConnection.equals(aConnection)){
					aConnectionIsSelected = true;
				}
				
				repaint();
			}
			
		}
	}
	
	public int smallestXIndex(Tile tile1, Tile tile2){
		int smallest = tile1.getX();
		if (tile2.getX()<smallest){
			smallest = tile2.getX();
		}
		return smallest-1;
	}
	
	public int smallestYIndex(Tile tile1, Tile tile2){
		int smallest = tile1.getY();
		if (tile2.getY()<smallest) {
			smallest = tile2.getY();
		}
		return smallest-1;
	}
	
	
	public boolean isH(Tile tile1, Tile tile2){
		if (tile1.getY() == tile2.getY()){
			return true;
		}
		
		return false;
	}
	public boolean isV(Tile tile1, Tile tile2){
		if (tile1.getX() == tile2.getX()){
			return true;
		}
		return false;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
		repaint();
	}
	

	
	

}






