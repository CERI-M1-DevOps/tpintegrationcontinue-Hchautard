package liste;

public class Noeud {
    private Object element;
    private Noeud suivant;

    /**
     * Constructeur de Noeud.
     */
    public Noeud(int e, Noeud suivant) {
        element = e;
        this.suivant = suivant;
    }


    /**
     * Retourne l'élément du Noeud.
     * @return l'élément du Noeud
     */
    public Object getElement() {
        return element;
    }
    /**
     * Modifie l'élément du Noeud.
     * @param element le nouvel élément
     */

    public void setElement(Object element) {
        this.element = element;
    }

    /**
     * Retourne le Noeud suivant.
     * @return le Noeud suivant
     */
    public Noeud getSuivant() {
        return suivant;
    }
    /**
     * Met à jour le Noeud suivant.
     * @param suivant le Noeud suivant
     */

    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    /**
     * Retourne une représentation textuelle du Noeud.
     * La représentation est de la forme "Noeud(e)" où e est l'élément du Noeud.
     * @return une représentation textuelle du Noeud
     */
    public String toString() {
        return "Noeud(" + element + ")";
    }
}
