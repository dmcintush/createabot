import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.text.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;

public class Game {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndDisplayGUI();
            }
        });

    }

    private static void createAndDisplayGUI() {

    	BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File("icon.png"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		ImageIcon imageIcon = new ImageIcon(bufferedImage);

        JFrame frame = new JFrame("Create-A-Bot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MyPanel());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setIconImage(imageIcon.getImage());
        frame.setVisible(true);
        frame.requestFocus();

    }

}

class MyPanel extends JPanel {

	public final int WIDTH = 320;
	public final int HEIGHT = 240;
	public final int SCALE = 2;

	public int k;

	public Random random = new Random();

	boolean done = false;

	Robot robot = new Robot();

    public MyPanel() {

    	setBackground(Color.WHITE);

		setBorder(BorderFactory.createLineBorder(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()), 5, true));

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
				if(robot.state == 1) {
					robot.mouse(e.getX(), e.getY());
				} else {
					robot.move(e.getX(), e.getY());
				}
            }
        });

    }

    public Dimension getPreferredSize() {

		/* WIDTH = 640 + 16
		 * HEIGHT = 480 + 9 */

        return new Dimension(WIDTH * SCALE, HEIGHT * SCALE);

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

		if(robot.state == 1) {
			g.setColor(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));

			k = (int)(Math.random() * 2 + 1);
			if(k == 1) {
				g.drawImage(robot.frame1, 220 - 1, 100 + 12, 216, 288, null);
			} else {
				g.drawImage(robot.frame2, 220 - 1, 100 + 12, 216, 288, null);
			}
			robot.delay(1);

			g.drawImage(robot.letters1[2], 22, 28, 48, 48, null);
			g.drawImage(robot.letters1[6], 22 + 36, 28, 48, 48, null);
			g.drawImage(robot.letters1[4], 22 + 36 * 2, 28, 48, 48, null);
			g.drawImage(robot.letters1[0], 22 + 36 * 3, 28, 48, 48, null);
			g.drawImage(robot.letters1[8], 22 + 36 * 4, 28, 48, 48, null);
			g.drawImage(robot.letters1[4], 22 + 36 * 5, 28, 48, 48, null);
			g.drawImage(robot.letters1[10], 22 + 36 * 6 + 12, 28, 48, 48, null);
			g.drawImage(robot.letters1[5], 22 + 36 * 7 + 12, 28, 48, 48, null);
			g.drawImage(robot.letters1[9], 22 + 36 * 8 + 12, 28, 48, 48, null);
			g.drawImage(robot.letters1[6], 22 + 36 * 9 + 12, 28, 48, 48, null);
			g.drawImage(robot.letters1[6], 22 + 36 * 10 + 24, 28, 48, 48, null);
			g.drawImage(robot.letters1[5], 22 + 36 * 11 + 24, 28, 48, 48, null);
			g.drawImage(robot.letters1[1], 22 + 36 * 12 + 24, 28, 48, 48, null);
			g.drawImage(robot.letters1[5], 22 + 36 * 13 + 24, 28, 48, 48, null);
			g.drawImage(robot.letters1[8], 22 + 36 * 14 + 24, 28, 48, 48, null);
			g.drawImage(robot.letters1[11], 22 + 36 * 15 + 24, 28, 48, 48, null);

			g.drawImage(robot.currentHead, 296, 148 + 2 + 12, 64, 64, null);
			g.drawImage(robot.currentTorso, 296, 148 + 64 + 2 + 12, 64, 64, null);
			g.drawImage(robot.currentLeg, 296, 148 + 128 + 2 + 12, 64, 64, null);


			g.drawImage(robot.right, 448, 148 + 8 + 2 + 12, 48, 48, null);
			g.drawImage(robot.right, 448, 148 + 64 + 8 + 2 + 12, 48, 48, null);
			g.drawImage(robot.right, 448, 148 + 128 + 8 + 2 + 12, 48, 48, null);

			g.drawImage(robot.done, 592 - 24, 432 - 24, 48, 48, null);
		} else {
			g.drawImage(robot.background, 0, 0, this.getWidth(), this.getHeight(), null);

			/* g.drawString("D", 16, 47);
			 * g.drawString("E", 16 + 40, 47);
			 * g.drawString("S", 16 + 80, 47);
			 * g.drawString("T", 16 + 120, 47);
			 * g.drawString("R", 16 + 160, 47);
			 * g.drawString("O", 16 + 200, 47);
			 * g.drawString("Y", 16 + 240, 47);
			 * g.drawString("!", 16 + 280, 47); */
			g.drawImage(robot.letters2[3], 12, 24, 64, 64, null);
			g.drawImage(robot.letters2[4], 12 + 58 * 1, 24, 64, 64, null);
			g.drawImage(robot.letters2[7], 12 + 58 * 2, 24, 64, 64, null);
			g.drawImage(robot.letters2[8], 12 + 58 * 3, 24, 64, 64, null);
			g.drawImage(robot.letters2[6], 12 + 58 * 4, 24, 64, 64, null);
			g.drawImage(robot.letters2[5], 12 + 58 * 5, 24, 64, 64, null);
			g.drawImage(robot.letters2[10], 12 + 58 * 6, 24, 64, 64, null);
			g.drawImage(robot.letters2[11], 12 + 58 * 7, 24, 64, 64, null);

			robot.draw(g);

			g.drawImage(robot.right, 356, 408, 48, 48, null);
			g.drawImage(robot.left, 252, 408, 48, 48, null);
			g.drawImage(robot.pause, 304, 408, 48, 48, null);
			g.drawImage(robot.explosion, 428, 408, 48, 48, null);

			g.drawImage(robot.currentEarth, 592 - 12 - 20, 0 + 6 + 20, 64, 64, null);
		}

		repaint();

    }

}

class Robot {

	public int state = 1;

	public int x = 296;
	public int y = 148 + 2;
	public int y2 = 408;
	public int xd = 0;
	public int yd = 0;

	public BufferedImage left;
	public BufferedImage right;
	public BufferedImage done;
	public BufferedImage pause;
	public BufferedImage frame1;
	public BufferedImage frame2;
	public BufferedImage earth;
	public BufferedImage earth2;
	public BufferedImage explosion;
	public BufferedImage jetpack;
	public BufferedImage jetpack2;
	public BufferedImage background;
	public BufferedImage rocket;

	// A, B, C, D, E, O, R, S, T, U, Y, !
	public BufferedImage[] letters1;
	public BufferedImage[] letters2;

	public BufferedImage[] heads;
	public BufferedImage[] torsos;
	public BufferedImage[] legs;

	public BufferedImage currentHead;
	public BufferedImage currentTorso;
	public BufferedImage currentLeg;
	public BufferedImage currentEarth;

	public boolean[][] table = { {true, false, false, false, false, false},
								 {true, false, false},
								 {true, false, false} };

	public Robot() {

		letters1 = new BufferedImage[12];
		letters2 = new BufferedImage[12];

		heads = new BufferedImage[6];
		torsos = new BufferedImage[3];
		legs = new BufferedImage[3];

		try {
			left = ImageIO.read(new File("left.png"));
			right = ImageIO.read(new File("right.png"));
			done = ImageIO.read(new File("done.png"));
			pause = ImageIO.read(new File("pause.png"));
			frame1 = ImageIO.read(new File("frame1.png"));
			frame2 = ImageIO.read(new File("frame2.png"));
			earth = ImageIO.read(new File("earth.png"));
			earth2 = ImageIO.read(new File("earth-2.png"));
			explosion = ImageIO.read(new File("explosion.png"));
			jetpack = ImageIO.read(new File("jetpack.png"));
			jetpack2 = ImageIO.read(new File("jetpack-1.png"));
			background = ImageIO.read(new File("background.png"));
			rocket = ImageIO.read(new File("rocket.png"));
			currentEarth = earth;

			letters1[0] = ImageIO.read(new File("a.png"));
			letters1[1] = ImageIO.read(new File("b.png"));
			letters1[2] = ImageIO.read(new File("c.png"));
			letters1[3] = ImageIO.read(new File("d.png"));
			letters1[4] = ImageIO.read(new File("e.png"));
			letters1[5] = ImageIO.read(new File("o.png"));
			letters1[6] = ImageIO.read(new File("r.png"));
			letters1[7] = ImageIO.read(new File("s.png"));
			letters1[8] = ImageIO.read(new File("t.png"));
			letters1[9] = ImageIO.read(new File("u.png"));
			letters1[10] = ImageIO.read(new File("y.png"));
			letters1[11] = ImageIO.read(new File("exc.png"));

			letters2[0] = ImageIO.read(new File("a-1.png"));
			letters2[1] = ImageIO.read(new File("b-i.png"));
			letters2[2] = ImageIO.read(new File("c-1.png"));
			letters2[3] = ImageIO.read(new File("d-i.png"));
			letters2[4] = ImageIO.read(new File("e-1.png"));
			letters2[5] = ImageIO.read(new File("o-1.png"));
			letters2[6] = ImageIO.read(new File("r-i.png"));
			letters2[7] = ImageIO.read(new File("s-i.png"));
			letters2[8] = ImageIO.read(new File("t-i.png"));
			letters2[9] = ImageIO.read(new File("u-i.png"));
			letters2[10] = ImageIO.read(new File("y-i.png"));
			letters2[11] = ImageIO.read(new File("exc-i.png"));

			heads[0] = ImageIO.read(new File("head1.png"));
			heads[1] = ImageIO.read(new File("head2.png"));
			heads[2] = ImageIO.read(new File("head3.png"));
			heads[3] = ImageIO.read(new File("ward.png"));
			heads[4] = ImageIO.read(new File("musicman.png"));
			heads[5] = ImageIO.read(new File("burton.png"));
			currentHead = heads[0];

			torsos[0] = ImageIO.read(new File("torso1.png"));
			torsos[1] = ImageIO.read(new File("torso2.png"));
			torsos[2] = ImageIO.read(new File("torso3.png"));
			currentTorso = torsos[0];

			legs[0] = ImageIO.read(new File("legs1.png"));
			legs[1] = ImageIO.read(new File("legs2.png"));
			legs[2] = ImageIO.read(new File("legs3.png"));
			currentLeg = legs[0];
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void draw(Graphics g) {

		int j = (int)(Math.random() * 2 + 1);
		if(j == 1) {
			g.drawImage(jetpack, x - 32, y + 64 - 24, 128, 128, null);
		} else {
			g.drawImage(jetpack2, x - 32, y + 64 - 24, 128, 128, null);
		}

		g.drawImage(currentHead, x, y + 12, 64, 64, null);
		g.drawImage(currentTorso, x, y + 64 + 12, 64, 64, null);
		g.drawImage(currentLeg, x, y + 128 + 12, 64, 64, null);

		delay(1);
		x += xd;

		if(x <= 0 - 3 + 4) {
			xd = 0;
		} else if(x >= 576 + 13 - 4) {
			xd = 0;
		}

		if(y2 >= 90) {
			y2 -= yd;
			g.drawImage(rocket, 569, y2, 48, 48, null);
		} else {
			currentEarth = earth2;
		}

	}

	public void mouse(int x, int y) {

		if(x > 448 && x < 496 && y > 158 + 12 && y < 206 + 12) {
			for(int i = 0; i < heads.length; i++) {
				if(table[0][i]) {
					if(i == heads.length - 1) {
						table[0][5] = false;
						table[0][0] = true;
						currentHead = heads[0];
						break;
					}
					table[0][i] = false;
					table[0][i + 1] = true;
					currentHead = heads[i + 1];
					break;
				}
			}
		} else if(x > 448 && x < 496 && y > 222 + 12 && y < 270 + 12) {
			for(int i = 0; i < torsos.length; i++) {
				if(table[1][i]) {
					if(i == torsos.length - 1) {
						table[1][2] = false;
						table[1][0] = true;
						currentTorso = torsos[0];
						break;
					}
					table[1][i] = false;
					table[1][i + 1] = true;
					currentTorso = torsos[i + 1];
					break;
				}
			}
		} else if(x > 448 && x < 496 && y > 286 + 12 && y < 334 + 12) {
			for(int i = 0; i < legs.length; i++) {
				if(table[2][i]) {
					if(i == legs.length - 1) {
						table[2][2] = false;
						table[2][0] = true;
						currentLeg = legs[0];
						break;
					}
					table[2][i] = false;
					table[2][i + 1] = true;
					currentLeg = legs[i + 1];
					break;
				}
			}
		} else if(x > 568 && x < 616 && y > 408 && y < 456) {
			state = 2;
		}

	}

	public void move(int x, int y) {

		if(x > 356 && x < 404 && y > 408 && y < 456 && xd != 1) {
			this.xd = 2;
		} else if(x > 252 && x < 300 && y > 408 && y < 456 && xd != -1) {
			this.xd = -2;
		} else if(x > 304 && x < 352 && y > 408 && y < 456) {
			this.xd = 0;
		} else if(x > 428 && x < 476 && y > 408 && y < 456 && xd == 0 && !currentEarth.equals(earth2)) {
			yd = 1;
		}

	}

	public void delay(int n)	{

		long startDelay = System.currentTimeMillis();
		long endDelay = 0;
		while (endDelay - startDelay < n)
			endDelay = System.currentTimeMillis();

	}

}