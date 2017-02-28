package ca.mcgill.ecse223.tileo.view;

import javax.swing.JPanel;

import ca.mcgill.ecse223.tileo.application.TileOApplication;
import ca.mcgill.ecse223.tileo.model.Game;
import ca.mcgill.ecse223.tileo.model.NormalTile;
import ca.mcgill.ecse223.tileo.model.Tile;
import ca.mcgill.ecse223.tileo.model.TileO;

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
	private static final int MINWIDTH = 9;
	private static final int MINHEIGHT = 9;
	private static float tileW = 50;
	private static float tileH = 50;
	
	
	// data element;
	private Game game;
	private HashMap<Rectangle2D, Tile> tiles;
	private Tile selectedTile;
	
	
	
	
	public TilePanel(Game game) {
		init(game);
		
		new NormalTile(1, 2, game);
		new NormalTile(1, 1, game);
		new NormalTile(5, 5, game);
		new NormalTile(8, 10, game);
		new NormalTile(9, 15, game);
		
		List<Tile> listTiles = game.getTiles();
		
		int i = getXAxis(game);
		int j = getYAxis(game);

		if (i<MINWIDTH) {
			i=MINWIDTH;
			
		}
		
		if(j<MINHEIGHT) {
			j=MINHEIGHT;
		}
		
		if(i>j) {
			j=i;
		}
		if(j>i) {
			i=j;
		}
		
		
		JPanel[][] panelHolder = new JPanel[i][j];
		GridLayout grid = new GridLayout(i, j);
		//grid.setHgap(i/6);
		//grid.setVgap(j/6);
		setLayout(grid);
		
		for(int m = 0; m < i; m++) {
			for(int n = 0; n < j; n++) {											
				panelHolder[m][n] = new JPanel();
				add(panelHolder[m][n]);				
				panelHolder[m][n].setBorder(BorderFactory.createLineBorder(Color.black));
				//panelHolder[m][n].setOpaque(true);
								 
			}			
		}
		
		/*
		tileH = panelHolder[1][1].getHeight();
		tileW = panelHolder[1][1].getWidth();
		*/
		
		
		for (Tile aTile: listTiles) {
			MyTile paint = new MyTile();
			
			int x = aTile.getX()-1;
			int y = aTile.getY()-1;
			
			//RectDraw newrect = new RectDraw();
			//panelHolder[x][y].setBorder(BorderFactory.createLineBorder(Color.black));
			//panelHolder[x][y].
			panelHolder[x][y].add(paint);
		}			
				
	}
	
	
	private void init(Game game) {
		this.game = game;
		tiles = new HashMap<Rectangle2D, Tile>();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				System.out.println("The mouse has been pressed " + "x: " + x + " y:" + y);
				for (Rectangle2D rectangle : rectangles) {
					if (rectangle.contains(x, y)) {
						selectedTile = tiles.get(rectangle);
						System.out.println("A legit tile has been selected. " + "x: " + x + " y:" + y);
						break;
					}
				}
				repaint();
			}
		});		
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
	
	public void doDrawing(Graphics g) {
		Graphics2D g2d = (Graphics2D) g.create();
		if (game != null) {
			for (Tile aTile: game.getTiles()) {
				
				Rectangle2D rect = new Rectangle2D.Float(0, 0, 100, 100);
				
				rectangles.add(rect);
				tiles.put(rect, aTile);
				
				g2d.setColor(Color.BLUE);
				g2d.fill(rect);
			}
			
		}
	}
	
	
	
	public class MyTile extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			doDrawing(g);
		}
		
	}
	
	
	

}






