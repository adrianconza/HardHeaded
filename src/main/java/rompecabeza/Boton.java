package rompecabeza;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Boton extends JButton implements MouseMotionListener,
		MouseListener {

	private static final long serialVersionUID = 1L;

	static int tx = 100;
	static int ty = 100;
	static int p = 340;
	static int tam1 = 3;

	public Boton() {
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void mouseDragged(MouseEvent mme) {
		setLocation(getX() + mme.getX() - getWidth() / 2, getY() + mme.getY()
				- getHeight() / 2);
	}

	public void mouseMoved(MouseEvent mme) {
	}

	public void mouseReleased(MouseEvent mme) {
		int x = Boton.p;
		int y = 30;
		for (int x1 = 0; x1 < Boton.tam1; x1++) {
			for (int y1 = 0; y1 < Boton.tam1; y1++) {
				if ((getX() > x - 50) && (getX() < x + 50) && (getY() > y - 50)
						&& (getY() < y + 50)) {
					setBounds(x, y, Boton.tx, Boton.ty);
					Service.PosicionBoton(x1, y1, Integer.parseInt(getName()));
				}
				x += Boton.tx;
			}
			x = Boton.p;
			y += Boton.ty;
		}
		if (Service.comparar())
			JOptionPane.showMessageDialog(null, " MUY BIEN GANO", "GANASTES",
					2, new ImageIcon("imagenes/estrella.png"));
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

}
