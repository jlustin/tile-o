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
	
	
	// data element;
	private Game game;
	private HashMap<Rectangle2D, Tile> tiles;
	private Tile selectedTile;
	
	
	
	
	public TilePanel(Game game) {
		init(game);
		
		new NormalTile(1, 2, game);
		new NormalTile(1, 1, game);
		new NormalTile(5, 5, game);
		new NormalTile(8, 15, game);
		
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
		GridLayout grid = new GridLayout(i, j, 300/i, 300/j);
		//grid.setHgap(i/6);
		//grid.setVgap(j/6);
		setLayout(grid);
		
		for(int m = 0; m < i; m++) {
			for(int n = 0; n < j; n++) {
				panelHolder[m][n] = new JPanel();
				add(panelHolder[m][n]);
				//panelHolder[m][n].setBorder(BorderFactory.createLineBorder(Color.black));
				//panelHolder[m][n].setOpaque(true);
			}
		}
		for (Tile aTile: listTiles) {
			
			int x = aTile.getX()-1;
			int y = aTile.getY()-1;
			//RectDraw newrect = new RectDraw();
			panelHolder[x][y].setBorder(BorderFactory.createLineBorder(Color.black));
			//panelHolder[x][y].
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
				for (Rectangle2D rectangle : rectangles) {
					if (rectangle.contains(x, y)) {
						selectedTile = tiles.get(rectangle);
						break;
					}
				}
				repaint();
			}
		});		
	}
	
	
	
	public void createTile(JPanel panel) {
		float w = panel.getWidth();
		float h = panel.getHeight();
		Rectangle2D rect = new Rectangle2D.Float(0, 0, w, h);
		
	}

	
	/*
	public void doDrawing(Graphics g) {
		if (game != null) {
			TileO tileO = TileOApplication.getTileO();
			Game currentGame = tileO.getCurrentGame();
			new NormalTile(1, 2, currentGame);
			new NormalTile(1, 1, currentGame);
			new NormalTile(5, 5, currentGame);
			
			List<Tile> listTiles = currentGame.getTiles();
			
			int i = getXAxis(currentGame);
			int j = getYAxis(currentGame);

			if (i<MINWIDTH) {
				i=MINWIDTH;
			}
			if (j<MINHEIGHT) {
				j=MINHEIGHT;
			}
			
			JPanel[][] panelHolder = new JPanel[i][j];
			GridLayout grid = new GridLayout(i*2 -1, j*2 -1);
			//grid.setHgap(i/6);
			//grid.setVgap(j/6);
			setLayout(grid);
			
			for(int m = 0; m < i; m++) {
				for(int n = 0; n < j; n++) {
					panelHolder[m][n] = new JPanel();
					add(panelHolder[m][n]);
				}
			}
			for (Tile aTile: listTiles) {
				int x = aTile.getX();
				int y = aTile.getY();
				panelHolder[x][y].add(newrect);
				
			}
				
		}
	}
	
	*/
	
	private static class RectDraw extends JPanel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
        super.paintComponent(g);  
         g.drawRect(230,80,10,10);  
         g.setColor(Color.RED);  
         g.fillRect(230,80,10,10);  
         }

	}		
		
	
/*
	public Rectangle2D drawTile(JPanel panelHolder) {
		int h = panelHolder.getHeight();
		int w = panelHolder.getWidth();
		Rectangle2D rectangle = new Rectangle2D.Float(h*(1/6), w*(1/6), w*(2/3), h*(2/3));
		return rectangle;
	}

*/	
	
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






