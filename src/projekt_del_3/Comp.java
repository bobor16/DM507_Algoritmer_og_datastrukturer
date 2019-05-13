/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_3;

import projekt_del_2.Node;
import java.util.Comparator;

/**
 *
 * @author Borgar Bordoy
 */
public class Comp implements Comparator<Node> {

    @Override
    public int compare(Node t, Node t1) {
        return t.getKey() - t1.getKey();
    }

}
