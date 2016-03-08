package view.panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JPanel;

import model.Game;
import model.board.Cell;
import view.ImageManager;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private Game game;
	private ImageManager imgManager;
	private int rows, columns;
	private int cellSize;
	private Color color;
	private Image[][] images;


	public GamePanel(Game game, ImageManager imgManager, final int cellSize, final GamePanelListener listener, Color color) {
		this.game = game;
		this.imgManager = imgManager;
		this.rows = game.getBoardSize();
		this.columns = game.getBoardSize();
		this.images = new Image[rows][columns];
		this.cellSize = cellSize;
		this.color = color;
		setSize(columns * cellSize, rows * cellSize);

		addMouseMotionListener(new MouseMotionAdapter() {

			private Integer currentRow;
			private Integer currentColumn;

			@Override
			public void mouseMoved(MouseEvent e) {
				int row = e.getY() / cellSize;
				int column = e.getX() / cellSize;
				if (row >= GamePanel.this.rows || column >= GamePanel.this.columns || row < 0 || column < 0) {
					return;
				}

				if (!nullSafeEquals(currentRow, row) || !nullSafeEquals(currentColumn, column)) {
					currentRow = row;
					currentColumn = column;
					if (listener != null) {
						listener.onMouseOver(row, column);
					}
				}
			}

			private boolean nullSafeEquals(Object o1, Object o2) {
				return o1 == null ? o2 == null : o1.equals(o2);
			}
		});
	}

	public void put(Image image, int row, int column) {
		images[row][column] = image;
	}

	public void clear(int row, int column) {
		images[row][column] = null;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(color);
		g.fillRect(0, 0, columns * cellSize, rows * cellSize);

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (images[i][j] != null) {
					g.drawImage(images[i][j], j * cellSize, i * cellSize, null);
				}
			}
		}
	}
	
	public void refresh() {
		for(int i=0; i<game.getBoardSize(); i++){
			for(int j=0; j<game.getBoardSize(); j++) {
				Cell cell = game.get(i, j);
				if (cell.hasFog()) {
					put(imgManager.get("FOG"), i, j);
				} else {
					put(imgManager.get(cell), i, j);
				}
			}
		}
		repaint();
	}
}