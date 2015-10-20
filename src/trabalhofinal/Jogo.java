/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhofinal;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author AGM
 */
public class Jogo extends StateBasedGame{

    public static final String nomeDoJogo = "Race Obstacles!";
    public static final int menu = 0;
    public static final int play = 1;

    public Jogo(String gName) {
        super(gName);
        this.addState(new Menu(menu));
        this.addState(new Play(play));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppGameContainer appgc;
        try {
            appgc = new AppGameContainer(new Jogo(nomeDoJogo));
            appgc.setDisplayMode(640, 360, false);
            appgc.start();
        } catch (SlickException ex) {
            Logger.getLogger(Jogo.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(menu).init(gc, this);
        this.getState(play).init(gc, this);
        this.enterState(menu);
    }

}
