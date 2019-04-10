/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt_del_2;

/**
 * @author Borgar Bordoy - bobor16@student.sdu.dk
 * @author Martin Lykke - mlykk17@student.sdu.dk
 * @author Rasmus Hansen - raha817@student.sdu.dk
 */
public interface Dict {

    public void insert(int k);

    public int[] orderedTraversal();

    public boolean search(int k);
}
