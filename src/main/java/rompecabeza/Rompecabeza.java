package rompecabeza;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Rompecabeza {

	static JFrame ventana = new JFrame();
	static Boton jbotones[][] = new Boton[3][3];
	static Service ObjLog = new Service(3, 3);
	static ImageIcon imagen[][] = new ImageIcon[3][3];
	static int matriz[][] = new int[3][3];
	static JRadioButtonMenuItem ima[];
	static JMenuBar lista = new JMenuBar();
	static JMenu opima = new JMenu("Imagenes ");
	static JLabel fondo = new JLabel();
	static int imag = 1;
	static int tam = 1;
	static int px = 10;
	static int py = 30;
	static int tx = 100;
	static int ty = 100;
	static int p = 340;
	static int tam1 = 3;

	public static void main(String[] args) {
		ventana.setTitle("HardHeaded");
		ventana.setSize(670, 400);
		ventana.setLocationRelativeTo(null);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setIconImage(new ImageIcon("imagenes/logo.png").getImage());
		ventana.setLayout(null);
		ventana.setResizable(false);

		lista.setBounds(0, 0, 2000, 20);
		ventana.add(lista);

		ayuda();
		imagenes();
		dificultad();
		botones();

		ventana.setVisible(true);
	}

	static void botones() {
		matriz = ObjLog.MatrizAleatoria();
		for (int x = 0; x < jbotones.length; x++) {
			for (int y = 0; y < jbotones[x].length; y++) {
				jbotones[x][y] = new Boton();
				jbotones[x][y].setName(Integer.toString(matriz[x][y]));
				jbotones[x][y].setBounds(px, py, tx, ty);
				imagen[x][y] = new ImageIcon("imagenes/r" + imag + "/" + tam
						+ "/" + Integer.toString(matriz[x][y]) + ".JPG");
				Icon icono = new ImageIcon(
						imagen[x][y].getImage()
								.getScaledInstance(jbotones[x][y].getWidth(),
										jbotones[x][y].getHeight(),
										Image.SCALE_DEFAULT));
				jbotones[x][y].setIcon(icono);
				ventana.add(jbotones[x][y]);
				px += tx;
			}
			px = 10;
			py += ty;
		}

		if (tam1 == 3) {
			fondo.setBounds(p, 30, 300, 300);
			fondo.setVisible(true);
			ImageIcon imagen = new ImageIcon("imagenes/fondo" + tam1 + ".jpg");
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
					fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
			fondo.setIcon(icono);
		} else if (tam1 == 4) {
			fondo.setBounds(p, 30, 400, 400);
			fondo.setVisible(true);
			ImageIcon imagen = new ImageIcon("imagenes/fondo" + tam1 + ".jpg");
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
					fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
			fondo.setIcon(icono);
		} else {
			fondo.setBounds(p, 30, 500, 500);
			fondo.setVisible(true);
			ImageIcon imagen = new ImageIcon("imagenes/fondo" + tam1 + ".jpg");
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
					fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
			fondo.setIcon(icono);
		}

		ventana.add(fondo);
		ventana.repaint();
	}

	static void ayuda() {
		JMenu otros = new JMenu("Opciones");
		lista.add(otros);

		JMenuItem Nuevo = new JMenuItem("Nuevo");
		Nuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevo();
			}
		});
		otros.add(Nuevo);

		JMenuItem Imacom = new JMenuItem("Imagen Completa");
		Imacom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame ventemer = new JFrame();
				JLabel imacom = new JLabel();
				ventemer.setIconImage(new ImageIcon("imagenes/logo.png")
						.getImage());
				ventemer.setTitle("IMAGEN COMPLETA");
				ventemer.setSize(555, 423);
				ventemer.setLocationRelativeTo(ventana);
				ventemer.setLayout(null);
				imacom.setBounds(0, 0, 550, 396);
				ImageIcon imagen = new ImageIcon("imagenes/r" + imag
						+ "/imacom.jpg");
				Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
						imacom.getWidth(), imacom.getHeight(),
						Image.SCALE_DEFAULT));
				imacom.setIcon(icono);
				ventemer.add(imacom);
				ventemer.setResizable(false);
				ventemer.setVisible(true);
			}
		});
		otros.add(Imacom);

		JSeparator separator = new JSeparator();
		otros.add(separator);

		JMenuItem acerde = new JMenuItem("Acerca De");
		acerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				acercade();
			}
		});
		otros.add(acerde);
	}

	static void acercade() {
		JFrame ventayu = new JFrame();
		ventayu.setSize(526, 467);
		ventayu.setLocationRelativeTo(null);
		ventayu.setIconImage(new ImageIcon("imagenes/logo.png").getImage());
		ventayu.setTitle("ACERCA DE");
		ventayu.setLayout(null);
		ventayu.setResizable(false);

		JLabel lbltitulo = new JLabel("HARDHEADED");
		lbltitulo.setForeground(Color.BLUE);
		lbltitulo.setFont(new Font("Ravie", Font.PLAIN, 20));
		lbltitulo.setBounds(178, 11, 349, 28);
		ventayu.add(lbltitulo);

		JLabel lblVersion = new JLabel("VERSION 1.0");
		lblVersion.setForeground(Color.BLUE);
		lblVersion.setFont(new Font("Ravie", Font.PLAIN, 20));
		lblVersion.setBounds(190, 50, 167, 28);
		ventayu.add(lblVersion);

		JLabel logo = new JLabel("");
		logo.setBounds(10, 100, 240, 195);
		logo.setIcon(new ImageIcon("imagenes/logo.png"));
		ventayu.add(logo);

		JLabel lblPerteneceA = new JLabel("PERTENECE A:");
		lblPerteneceA.setForeground(Color.BLUE);
		lblPerteneceA.setFont(new Font("Ravie", Font.PLAIN, 18));
		lblPerteneceA.setBounds(256, 97, 177, 28);
		ventayu.add(lblPerteneceA);

		JLabel lblAdrianConza = new JLabel("ADRIAN CONZA");
		lblAdrianConza.setForeground(Color.BLUE);
		lblAdrianConza.setFont(new Font("Ravie", Font.PLAIN, 14));
		lblAdrianConza.setBounds(266, 129, 155, 28);
		ventayu.add(lblAdrianConza);

		JLabel lblCelular = new JLabel("CELULAR:");
		lblCelular.setForeground(Color.BLUE);
		lblCelular.setFont(new Font("Ravie", Font.PLAIN, 18));
		lblCelular.setBounds(256, 182, 177, 28);
		ventayu.add(lblCelular);

		JLabel cel = new JLabel("099308011");
		cel.setForeground(Color.BLUE);
		cel.setFont(new Font("Ravie", Font.PLAIN, 14));
		cel.setBounds(266, 214, 155, 28);
		ventayu.add(cel);

		JLabel lblCorreo = new JLabel("CORREO:");
		lblCorreo.setForeground(Color.BLUE);
		lblCorreo.setFont(new Font("Ravie", Font.PLAIN, 18));
		lblCorreo.setBounds(256, 270, 177, 28);
		ventayu.add(lblCorreo);

		JLabel lblPacaconzagmailcom = new JLabel("pacaconza94@gmail.com");
		lblPacaconzagmailcom.setForeground(Color.BLUE);
		lblPacaconzagmailcom.setFont(new Font("Ravie", Font.PLAIN, 14));
		lblPacaconzagmailcom.setBounds(266, 302, 234, 28);
		ventayu.add(lblPacaconzagmailcom);

		JLabel lblCodigoFuente = new JLabel("CODIGO FUENTE:");
		lblCodigoFuente.setForeground(Color.BLUE);
		lblCodigoFuente.setFont(new Font("Ravie", Font.PLAIN, 18));
		lblCodigoFuente.setBounds(10, 345, 193, 28);
		ventayu.add(lblCodigoFuente);

		JTextField caja1 = new JTextField(
				"https://docs.google.com/open?id=0B8XUrMQBYGI2RHNyckJLSzlKVTQ");
		caja1.setEditable(false);
		caja1.setForeground(Color.BLUE);
		caja1.setFont(new Font("Ravie", Font.PLAIN, 11));
		caja1.setBounds(5, 377, 510, 28);
		ventayu.add(caja1);

		ventayu.setVisible(true);
	}

	static void imagenes() {
		lista.add(opima);

		JMenuItem nueima = new JMenuItem("Cargar Imagen");
		nueima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CargarIma();
			}
		});
		opima.add(nueima);

		JSeparator separator = new JSeparator();
		opima.add(separator);

		radmenu();
	}

	static void radmenu() {
		ima = new JRadioButtonMenuItem[leer()];
		for (int i = 0; i < ima.length; i++) {
			ima[i] = new JRadioButtonMenuItem("Imagen " + (i + 1));
			ima[i].addActionListener(new Escuchador());
			opima.add(ima[i]);
		}
	}

	static class Escuchador implements ActionListener {
		public void actionPerformed(ActionEvent evento) {
			for (int i = 0; i < ima.length; i++) {
				if (evento.getSource() == ima[i]) {
					imag = i + 1;
					nuevo();

					ima[i].setSelected(true);
					ima[i].setEnabled(false);
				} else {
					ima[i].setSelected(false);
					ima[i].setEnabled(true);
				}
			}
		}
	}

	static void CargarIma() {
		int n = 0;
		JFileChooser cargar = new JFileChooser();
		cargar.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG",
				"jpg");
		cargar.setFileFilter(filtro);
		int seleccion = cargar.showOpenDialog(null);
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File imagen = cargar.getSelectedFile();
			if (imagen.getName().toUpperCase().endsWith(".JPG")) {
				n = numeroima();
				guardarima(String.valueOf(imagen), n);
				for (int i = 0; i < ima.length; i++)
					ima[i].setVisible(false);
				radmenu();
			} else
				JOptionPane.showMessageDialog(null,
						"Tipo de archivo no soportado o Archivo no encontrado");
		}
	}

	static int numeroima() {
		int n = 0;
		try {
			n = leer();
			n++;
			FileOutputStream esc = new FileOutputStream("imagenes/ima.txt");
			esc.write(String.valueOf(n).getBytes());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo");
		}
		return n;
	}

	static int leer() {
		int n = 0;
		try {
			FileReader l = new FileReader("imagenes/ima.txt");
			BufferedReader leer = new BufferedReader(l);
			n = Integer.parseInt(leer.readLine());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se encontro el archivo");
		}
		return n;
	}

	static void guardarima(String ruta, int n) {
		try {
			File directorio = new File("imagenes/r" + n);
			directorio.mkdir();
			BufferedImage imagen = ImageIO.read(new File(ruta));
			File direc = new File(directorio + "/imacom.jpg");
			ImageIO.write(imagen, "jpg", direc);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error al crear el archivo");
		} catch (java.lang.IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "No se permite ese archivo");
		}
		String dir = "imagenes/r" + n + "/imacom.jpg";
		dividirImagen(dir, n);
	}

	static void dividirImagen(String ruta, int n) {
		int bn = 1;
		int a = 3;
		do {
			int ima = 1;
			try {
				File directorio = new File("imagenes/r" + n + "/" + bn);
				directorio.mkdir();
				BufferedImage imagen = ImageIO.read(new File(ruta));
				int w = imagen.getWidth() / a;
				int h = imagen.getHeight() / a;
				int x = 0;
				int y = 0;
				for (int i = 0; i < a; i++) {
					x = 0;
					for (int j = 0; j < a; j++) {
						BufferedImage recorte = imagen.getSubimage(x, y, w, h);
						File file = new File(directorio + "/" + ima + ".jpg");
						ImageIO.write(recorte, "jpg", file);
						ima++;
						x += w;
					}
					y += h;
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null,
						"Error al dividir la imagen");
			}
			bn++;
			if (bn == 2)
				a = 4;
			if (bn == 3)
				a = 5;

		} while (bn <= 3);
	}

	static void dificultad() {
		JMenu pie = new JMenu(" Dificultad ");
		lista.add(pie);

		final JRadioButtonMenuItem P09 = new JRadioButtonMenuItem("Facil");
		final JRadioButtonMenuItem P16 = new JRadioButtonMenuItem("Intermedio");
		final JRadioButtonMenuItem P25 = new JRadioButtonMenuItem("Dificil");

		P09.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tam1 = 3;
				tam = 1;
				p = 340;
				ventana.setSize(670, 400);
				ventana.setLocationRelativeTo(null);
				nuevo();

				P09.setSelected(true);
				P16.setSelected(false);
				P25.setSelected(false);

				P09.setEnabled(false);
				P16.setEnabled(true);
				P25.setEnabled(true);
			}
		});

		P16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tam1 = 4;
				tam = 2;
				p = 440;
				ventana.setSize(870, 500);
				ventana.setLocationRelativeTo(null);
				nuevo();

				P09.setSelected(false);
				P16.setSelected(true);
				P25.setSelected(false);

				P09.setEnabled(true);
				P16.setEnabled(false);
				P25.setEnabled(true);
			}
		});

		P25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tam1 = 5;
				tam = 3;
				p = 540;
				ventana.setSize(1070, 600);
				ventana.setLocationRelativeTo(null);
				nuevo();

				P09.setSelected(false);
				P16.setSelected(false);
				P25.setSelected(true);

				P09.setEnabled(true);
				P16.setEnabled(true);
				P25.setEnabled(false);
			}
		});

		pie.add(P09);
		pie.add(P16);
		pie.add(P25);
	}

	static void nuevo() {
		for (int i = 0; i < jbotones.length; i++)
			for (int j = 0; j < jbotones[i].length; j++)
				jbotones[i][j].setVisible(false);

		jbotones = new Boton[tam1][tam1];
		imagen = new ImageIcon[tam1][tam1];
		ObjLog = new Service(tam1, tam1);
		matriz = new int[tam1][tam1];
		px = 10;
		py = 30;
		fondo.setVisible(false);
		botones();
	}

}