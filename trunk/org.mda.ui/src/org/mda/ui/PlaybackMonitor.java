package org.mda.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

import javax.swing.JPanel;

import mda.AbstractSessionItem;
import mda.Session;

import org.mda.MidiPlayer;
import org.mda.MidiPlayerListener;
import org.mda.PlayerMode;

/**
 * Displays current sound and time elapsed.
 */
public class PlaybackMonitor extends JPanel implements Runnable, MidiPlayerListener {

	/**
   *
   */
  private static final long serialVersionUID = 8132172147066530595L;

  private int height = 500;

	Thread pbThread;
	Color jfcBlue = new Color(102, 102, 122);
	Font font10 = new Font(Font.DIALOG, Font.BOLD, 10);
	Font font24 = new Font(Font.DIALOG, Font.BOLD, 24);
	Font font28 = new Font(Font.DIALOG, Font.BOLD, 28);
	Font font42 = new Font(Font.DIALOG, Font.BOLD, 42);
	Font font60 = new Font(Font.DIALOG, Font.BOLD, 60);
	FontMetrics fm28, fm42, fm10, fm60;
	private MidiPlayer player;

	public PlaybackMonitor(final MidiPlayer player) {
		player.addMidiPlayerListener(this);
		fm28 = getFontMetrics(font28);
		fm42 = getFontMetrics(font42);
		fm10 = getFontMetrics(font10);
		fm60 = getFontMetrics(font60);
		this.player = player;
	}

	private Graphics2D createGraphics(final Font font, final Graphics g) {
		Graphics2D g3 = (Graphics2D) g;
		g3.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g3.setColor(jfcBlue);
		g3.setFont(font);
		return g3;
	}


	public void paint(Graphics gu) {
		try {
			Graphics2D g2d = (Graphics2D) gu;
			g2d.setClip(g2d.getClip().getBounds().x, g2d.getClip().getBounds().y, g2d.getClip().getBounds().width, height);
			//g2d.setBackground(black);
			g2d.clearRect(0, 0, g2d.getClip().getBounds().width, height);
			g2d = createGraphics(font10, g2d);

			createGraphics(font28, g2d);
			g2d.drawString(player.getCurrentName(), 5, fm28.getHeight() + fm10.getHeight() + 5);

			if (player.getSequencer() != null && player.getSequencer().isRunning()) {
				g2d.setFont(font60);
				String s = player.getCurrentPositionInSong();
				int strW = (int) fm60.getStringBounds(s, g2d).getWidth();

				int pos = getSize().width - strW - 100;
				g2d.drawString(s, pos , fm60.getAscent());

				for (int i = 0; i < 4; i++) {
					if (i <=  player.getCurrentTick())
						g2d.setColor(jfcBlue);
					else
						g2d.setColor(Color.WHITE);

					Double double1 = new Rectangle2D.Double(pos + strW + i * 20, fm60.getAscent(), 19, 18);
					g2d.fill(double1);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void start() {
		pbThread = new Thread(this);
		pbThread.setName("PlaybackMonitor");
		pbThread.start();
	}

	public void stop() {
		if (pbThread != null) {
			pbThread.interrupt();
		}
		pbThread = null;
	}

	public void run() {
		while (pbThread != null) {
			try {
				Thread.sleep(99);
			} catch (Exception e) {
				break;
			}
			repaint();
		}
		pbThread = null;
	}

	@Override
	public void sessionItemChanged (AbstractSessionItem newSong) {
		repaint();

	}

	@Override
	public void started() {
		start();
		repaint();
	}

	@Override
	public void stopped() {
		stop();
		repaint();
	}

	@Override
	public void modeToggled(PlayerMode chosePlayerMode) {
		// TODO Auto-generated method stub

	}

  @Override
  public void barChanged(int currentBar) {
    // TODO Auto-generated method stub

  }

  @Override
  public void sessionChanged(Session newSession) {
    // TODO Auto-generated method stub

  }
}
