import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Pelota {

	public int x, y;
	private int masX = 1, masY = 1;

	public Pelota (int x, int y){

		this.x = x;
		this.y = y;

	}	

	public void movimiento(){

		x += masX;
		y += masY;

		if (x > 450){

			masX = -masX;
		}

		if (y > 430){

			masY = -masY;
		}

		if (x < 0){

			masX = -masX;
		}

		if (y < 0){

			masY = -masY;
		}
	}

}