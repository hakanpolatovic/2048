import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{

	
	
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	int userwidth = (int)screenSize.getWidth();
	int userheigth = (int)screenSize.getWidth();
	int leftpivot = (userwidth/4)+50;
	int uppivot = (userheigth/16);
	int array[][]= new int[4][4];
	int spacing =35;
	int point = 0;
	boolean gameover = false;
	boolean ableToMove = false;
	
	KeyHandler key = new KeyHandler();
	
	public Panel(){
		
		this.setSize(getPreferredSize());
		this.setBackground(Color.BLACK);
		this.addKeyListener(key);
		this.requestFocus();
		this.setFocusable(true);
	}
	
	
	
	 @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;

	        
	        g2d.setColor(Color.WHITE);
	        BasicStroke stroke = new BasicStroke(5.0f);
	        g2d.setStroke(stroke);
	        
	    	int x=leftpivot;
	    	int y=uppivot;
	    	
	        	
	    	Font font = new Font("Verdana", Font.PLAIN, 36); 
	    	g2d.setFont(font);
	    	
	        	for(int z=0; z<=3; z++) {
	        		g2d.setColor(Color.WHITE);
	        		g2d.fillRect(x,y, 100, 100);
	        		
	        		if(array[z][0]>0) {
	        			String col1row1 = String.valueOf(array[z][0]);
		        		spacer(z,0);
		        		g2d.setColor(Color.BLACK);
	        			g2d.drawString(col1row1, x+spacing, y+65);
	        			}
	        		
	        		x=x+150;
	        	}
	        	x=leftpivot;
	        	y=uppivot;
	        	for(int z=0; z<=3; z++) {
	        		g2d.setColor(Color.WHITE);
	        		g2d.fillRect(x,y+150, 100, 100);
	    
	     
	        		
	        		if(array[z][1]>0) {
	        			String col1row1 = String.valueOf(array[z][1]);
		        		spacer(z,1);
		        		g2d.setColor(Color.BLACK);
		        		g2d.drawString(col1row1, x+spacing, y+215);
	        		}
	        		x=x+150;
	        	}
	        	x=leftpivot;
	        	y=uppivot;
	        	for(int z=0; z<=3; z++) {
	        		g2d.setColor(Color.WHITE);
	        		g2d.fillRect(x,y+300, 100, 100);
	        		
	        		if(array[z][2]>0) {
	        			String col1row1 = String.valueOf(array[z][2]);
		        		spacer(z,2);
		        		g2d.setColor(Color.BLACK);
		        		g2d.drawString(col1row1, x+spacing, y+365);
	        		}
	        		x=x+150;
	        	}
	        	x=leftpivot;
	        	y=uppivot;
	        	for(int z=0; z<=3; z++) {
	        		g2d.setColor(Color.WHITE);
	        		g2d.fillRect(x,y+450, 100, 100);    		
	        		
	        		if(array[z][3]>0) {
	        			String col1row1 = String.valueOf(array[z][3]);
		        		spacer(z,3);
		        		g2d.setColor(Color.BLACK);
		        		g2d.drawString(col1row1, x+spacing, y+515);
	        		}
	        		x=x+150;
	        	}
	        	if(gameover==true) {
	        		
	        		String gameover = "Game Over!";
	        		g2d.setColor(Color.WHITE);
	        		g2d.drawString(gameover, (userwidth/2)-(gameover.length()*12),50);
	        	}
	        	String points = String.valueOf(point);
	        	g2d.setColor(Color.WHITE);
	        	g2d.drawString(points, 50, 50);
	        	
	        	
	        
	        
	    }


	private void spacer(int x,int y) {
		// TODO Auto-generated method stub
		
		if(array[x][y]<=99) {
			spacing=35;
		}
		if(array[x][y]>=100 && array[0][0]<=999) {
			spacing=15;
		}
		if(array[x][y]>=1000) {
			spacing=5;
		}
	}



	@Override
    public void run() {
    	
		arrayInitialize();

        int fps = 60; 
        long targetTime = 1000 / fps; 
        long lastUpdateTime = System.currentTimeMillis();
        long lastRenderTime = lastUpdateTime;
        long lastFpsUpdateTime = lastUpdateTime;
        long totalFrameCount = 0;
        
        while (true) { 
        	
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastUpdateTime;

            updateGameLogic(elapsedTime); 

            if (currentTime - lastRenderTime >= targetTime) {
                repaint();
                lastRenderTime = currentTime;
               
            }

            long sleepTime = targetTime - (currentTime - lastRenderTime);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            lastUpdateTime = currentTime;
            totalFrameCount++;

         
        }
    }



	private void updateGameLogic(long elapsedTime) {
		// TODO Auto-generated method stub
		
		
		
		if(key.up==true) {
			System.out.println("up");
			check(1);				
			key.up=false;
			
		}
		if(key.down==true) {
			System.out.println("down");
			check(2);				
			key.down=false;
		
		}
		if(key.left==true) {
			System.out.println("left");
			check(3);	
			key.left=false;
		}
		if(key.right==true) {
			System.out.println("right");
			check(4);						
			key.right=false;
			
		}
		
		
	
		
	}


	private void check(int direction) {
		// TODO Auto-generated method stub
		
		ableToMove = false;
		
		
		if(direction==1) {
			
			for(int x=0; x<=3; x++) {
				for(int y=1; y<=3; y++) {
					
					if(array[x][y]!=0 && array[x][y-1]==0) {
				
						ableToMove=true;
					}
					if(array[x][y]!=0 && array[x][y-1]==array[x][y]) {
				
						ableToMove=true;
					}
				}
			}
		}
		if(direction==2) {
			
			for(int x=0; x<=3; x++) {
				for(int y=0; y<=2; y++) {
					
					if(array[x][y]!=0 && array[x][y+1]==0) {
				
						ableToMove=true;
					}
					if(array[x][y]!=0 && array[x][y+1]==array[x][y]) {
				
						ableToMove=true;
					}
				}
			}
		}
		if(direction==3) {
			
			for(int x=1; x<=3; x++) {
				for(int y=0; y<=3; y++) {
					
					if(array[x][y]!=0 && array[x-1][y]==0) {
				
						ableToMove=true;
					}
					if(array[x][y]!=0 && array[x-1][y]==array[x][y]) {
				
						ableToMove=true;
					}
				}
			}
		}
		if(direction==4) {
			
			for(int x=0; x<=2; x++) {
				for(int y=0; y<=3; y++) {
					
					if(array[x][y]!=0 && array[x+1][y]==0) {
				
						ableToMove=true;
					}
					if(array[x][y]!=0 && array[x+1][y]==array[x][y]) {
				
						ableToMove=true;
					}
				}
			}
		}
		
		

		if(ableToMove==true){
			
			switch(direction) {
			
			case 1: up();
			break;
			case 2: down();
			break;
			case 3:left();
			break;
			case 4:right();
			break;
			}
		
	}
	checkpoints();
	checkgameover();	
	
	}



	private void checkpoints() {
		// TODO Auto-generated method stub
		
		
		
	}



	private void checkgameover() {
		// TODO Auto-generated method stub
	gameover=true;
		for(int x=0; x<=3; x++) {
			for(int y=0; y<=3; y++) {
				
				if(array[x][y]==0) {
			
					gameover=false;
				}
			
			}
		}
		if(gameover==true) {
			for(int x=0; x<=2; x++) {
				for(int y=0; y<=3; y++) {
					
					if(array[x][y]==array[x+1][y]) {
				
						gameover=false;
					}
				
				}
			}
			for(int x=0; x<=3; x++) {
				for(int y=0; y<=2; y++) {
					
					if(array[x][y]==array[x][y+1]) {
				
						gameover=false;
					}
				
				}
			
			}
			for(int x=0; x<=3; x++) {
				for(int y=1; y<=3; y++) {
					
					if(array[x][y]==array[x][y-1]) {
				
						gameover=false;
					}
				
				}
			}
			for(int x=1; x<=3; x++) {
				for(int y=0; y<=3; y++) {
					
					if(array[x][y]==array[x-1][y]) {
				
						gameover=false;
					}
				
				}
			}
		}
	
	}



	private void right() {
		// TODO Auto-generated method stub
	
		for(int x=2; x>=0; x--) {
			for(int y=3; y>=0; y--) {
		if(array[x+1][y]==array[x][y]) {
			
			array[x+1][y]=array[x][y]*2;
			point=point+array[x+1][y];
			array[x][y]=0;
			
			
				}
		
			}
		}
			
		for(int x=2; x>=0; x--) {
			for(int y=3; y>=0; y--) {
			
				for(int z=x+1; z<=3; z++) {
					
					if(array[z][y]==0) {
						
						array[z][y]=array[z-1][y];
						array[z-1][y]=0;
					}
				}

				}
			}
		randomnum();

	
	
	}



	private void left() {
		// TODO Auto-generated method stub
		
		for(int x=1; x<=3; x++) {
			for(int y=0; y<=3; y++) {
				
		if(array[x-1][y]==array[x][y]) {
			
			array[x-1][y]=array[x][y]*2;
			point=point+array[x-1][y];
			array[x][y]=0;
			
			
				}
		
			}
		}
			
		for(int x=1; x<=3; x++) {
			for(int y=0; y<=3; y++) {
			
				for(int z=x-1; z>=0; z--) {
					
					if(array[z][y]==0) {
						
						array[z][y]=array[z+1][y];
						array[z+1][y]=0;
					}
				}

				}
			}
		randomnum();
	}



	private void down() {
		// TODO Auto-generated method stub
		
		for(int x=3; x>=0; x--) {
			for(int y=2; y>=0; y--) {
				
		if(array[x][y+1]==array[x][y]) {
			
			array[x][y+1]=array[x][y]*2;
			point=point+array[x][y+1];
			array[x][y]=0;
			
			
				}
		
			}
		}
			
		for(int x=3; x>=0; x--) {
			for(int y=2; y>=0; y--) {
			
				for(int z=y+1; z<=3; z++) {
					
					if(array[x][z]==0) {
						
						array[x][z]=array[x][z-1];
						array[x][z-1]=0;
					}
				}

				}
			}
		randomnum();
	}



	private void up() {
		// TODO Auto-generated method stub
		
		for(int x=0; x<=3; x++) {
			for(int y=1; y<=3; y++) {
				
		if(array[x][y-1]==array[x][y]) {
			
			array[x][y-1]=array[x][y]*2;
			point=point+array[x][y-1];
			array[x][y]=0;
			
			
				}
		
			}
		}
			
		for(int x=0; x<=3; x++) {
			for(int y=1; y<=3; y++) {
			
				for(int z=y-1; z>=0; z--) {
					
					if(array[x][z]==0) {
						
						array[x][z]=array[x][z+1];
						array[x][z+1]=0;
					}
				}

				}
			}
		randomnum();
	}
	private void randomnum() {
		
		int num;
		for(int i=1; i>0;  i++) {
			
			int ranx=ThreadLocalRandom.current().nextInt(0,4);
			int rany=ThreadLocalRandom.current().nextInt(0,4);
			int random=ThreadLocalRandom.current().nextInt(0,11);
			if(random>7) {
				num=4;
			}
			else {
				num=2;
			}
			if(array[ranx][rany]==0) {
				array[ranx][rany]=num;
				break;
			}
			
			
		}
	}



	private void arrayInitialize() {
		// TODO Auto-generated method stub

			array[0][0]=2;

	

		
	}
	
}
