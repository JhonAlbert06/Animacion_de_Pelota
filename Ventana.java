import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Ventana extends JFrame {	

	private Hilo hilo;

	private Button pausar;
	private Button reanudar;
	private Button agregarBola;

	public Ventana(){

		init();

	}


	private void init(){

		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);

		Marco cuadro = new Marco();
		add(cuadro);

		hilo = new Hilo(cuadro);
		hilo.start();

		try {
			hilo.sleep(300);	
		} catch (InterruptedException e){}
		
		pausar = new Button("Pausar");
		pausar.setFont(new Font("Arial", Font.PLAIN, 18));
		pausar.setBackground(Color.WHITE);
		cuadro.add(pausar);
		pausar.addActionListener((ActionEvent e) ->{
			
			hilo.suspend();

		});

		reanudar = new Button("Reanudar");
		reanudar.setFont(new Font("Arial", Font.PLAIN, 18));
		reanudar.setBackground(Color.WHITE);
		cuadro.add(reanudar);
		reanudar.addActionListener((ActionEvent e) ->{
			
			hilo.resume();

		});


		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public class Hilo extends Thread {

		Marco cuadro;

		public Hilo(Marco cuadro){

			this.cuadro = cuadro;
		}

		@Override
		public void run(){

			while(true){
				cuadro.repaint();
			}
		}
	
	}

	class Marco extends JPanel {

		Pelota bola = new Pelota(100, 100);

		private final int ancho = 15, alto = 15;

		public Marco(){

			setBackground(Color.BLACK);	
		}

		@Override
		public void paintComponent(Graphics g){

			super.paintComponent(g);

			g.setColor(Color.WHITE);
			//g.drawOval(100,100, ancho, alto);
			//g.fillOval(100,100, ancho, alto);
			escribir(g);
			bucle();

		}

		public void escribir(Graphics g){

			g.fillOval(bola.x, bola.y, ancho, alto);;
		}

		public void bucle(){

			bola.movimiento();
		}

	}

}