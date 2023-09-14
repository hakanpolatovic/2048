import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class KeyHandler implements KeyListener{

	public boolean left,right,up,down=false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keycode = e.getKeyCode();
		
		if (keycode == KeyEvent.VK_UP) {
			up=true;
		}
		if (keycode == KeyEvent.VK_DOWN) {
			down=true;
		}
		if (keycode == KeyEvent.VK_LEFT) {
			left=true;
		}
		if (keycode == KeyEvent.VK_RIGHT) {
			right=true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int keycode = e.getKeyCode();
		
		if (keycode == KeyEvent.VK_UP) {
			up=false;
		}
		if (keycode == KeyEvent.VK_DOWN) {
			down=false;
		}
		if (keycode == KeyEvent.VK_LEFT) {
			left=false;
		}
		if (keycode == KeyEvent.VK_RIGHT) {
			right=false;
		}
	}

	

}
