package liste;

public class ListeSimple {
    private long size;
    Noeud tete;

    /**
     * Retourne le nombre d'éléments de la liste.
     * @return le nombre d'éléments de la liste
     */
    public long getSize() {
        return size;
    }


    /**
     * Ajoute un élément en tête de liste.
     * @param element l'élément ajouter
     */
    public void ajout(int element) {
        tete = new Noeud(element, tete);
        size++;
    }

    /**
     * Modifie la première occurrence de l'objet element par l'objet nouvelleValeur.
     * @param element l'objet cherché 
     * @param nouvelleValeur la nouvelle valeur affecter l'objet
     */
    public void modifiePremier(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null && courant.getElement() != element)
            courant = courant.getSuivant();
        if (courant != null)
            courant.setElement(nouvelleValeur);
    }

    /**
     * Modifie tous les occurences de l'objet element par l'objet nouvelleValeur.
     * @param element l'objet cherché 
     * @param nouvelleValeur la nouvelle valeur affecter l'objet
     */
    public void modifieTous(Object element, Object nouvelleValeur) {
        Noeud courant = tete;
        while (courant != null) {
            if (courant.getElement() == element)
                courant.setElement(nouvelleValeur);
            courant = courant.getSuivant();
        }
    }

    /**
     * Retourne une représentation textuelle de la liste.
     * La représentation est de la forme "ListeSimple(n1, n2, ...)" où  n1, n2...
     * sont les éléments de la liste.
     * @return une représentation textuelle de la liste
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("ListeSimple(");
        Noeud n = tete;
        while (n != null) {
            sb.append(n);
            n = n.getSuivant();
            if (n != null)
                sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Supprime la première occurrence de l'objet spécifié dans la liste.
     * Si l'objet est trouvé en tête de liste, la tête est mise à jour.
     * Si l'objet est trouvé ailleurs dans la liste, le lien vers l'objet suivant
     * est mis à jour pour exclure l'objet supprimé.
     * Si l'objet n'est pas trouvé, la liste reste inchangée.
     * La taille de la liste est décrémentée si un élément est supprimé.
     * 
     * @param element l'objet à supprimer de la liste
     */
    public void supprimePremier(Object element) {
        if (tete != null) {
            if (tete.getElement() == element) {
                tete = tete.getSuivant();
                size--;
                return;
            }
            Noeud precedent = tete;
            Noeud courant = tete.getSuivant();
            while (courant != null && courant.getElement() != element) {
                precedent = precedent.getSuivant();
                courant = courant.getSuivant();
            }
            if (courant != null) {
                precedent.setSuivant(courant.getSuivant());
                size--;
            }
        }
    }

    /**
     * Supprime toutes les occurrences de l'objet spécifié dans la liste.
     * La tête de la liste est mise à jour si l'objet est trouvé en tête de liste.
     * Les liens vers les objets suivants sont mis à jour pour exclure les objets supprimés.
     * La taille de la liste est mise à jour.
     * 
     * @param element l'objet à supprimer de la liste
     */
    public void supprimeTous(int element) {
       tete = supprimeTousRecurs(element, tete);
    }


    /**
     * Supprime toutes les occurrences de l'objet spécifié dans la liste en
     * parcourant la liste de manière récursive.
     * La tête de la liste est mise à jour si l'objet est trouvé en tête de
     * liste.
     * Les liens vers les objets suivants sont mis à jour pour exclure les
     * objets supprimés.
     * La taille de la liste est mise à jour.
     * 
     * @param element l'objet à supprimer de la liste
     * @param tete la tête de la liste
     * @return la tête de la liste modifiée
     */
    public Noeud supprimeTousRecurs(Object element, Noeud tete) {
        if (tete != null) {
            Noeud suiteListe = supprimeTousRecurs(element, tete.getSuivant());
            if (tete.getElement() == element) {
                size--;
                return suiteListe;
            } else {
                tete.setSuivant(suiteListe);
                return tete;
            }
        } else return null;
    }

    /**
     * Retourne le deuxième élément en fin de liste.
     * Si la liste a moins de deux éléments, la méthode retourne null.
     * @return le deuxième élément en fin de liste, ou null si la liste a moins de deux éléments
     */
    public Noeud getAvantDernier() {
        if (tete == null || tete.getSuivant() == null)
            return null;
        else {
            Noeud courant = tete;
            Noeud suivant = courant.getSuivant();
            while (suivant.getSuivant() != null) {
                courant = suivant;
                suivant = suivant.getSuivant();
            }
            return courant;
        }
    }

    /**
     * Inverse la liste en place.
     * La méthode parcourt la liste et inverse les liens vers les objets suivants.
     * La tête de la liste est mise à jour.
     */
    public void inverser() {
        Noeud precedent = null;
        Noeud courant = tete;
        while (courant != null) {
            Noeud next = courant.getSuivant();
            courant.setSuivant(precedent);
            precedent = courant;
            courant = next;
        }
        tete = precedent;
    }

    /**
     * Retourne le précédent du Noeud r dans la liste.
     * La méthode suppose que le Noeud r existe dans la liste.
     * @param r le Noeud dont on cherche le précédent
     * @return le précédent du Noeud r dans la liste
     */
    public Noeud getPrecedent(Noeud r) {
    // la liste n'est pas vide puisqu'on transmet un Node de la liste et le Node existe obligatoirement
        Noeud precedent = tete;
        Noeud courant = precedent.getSuivant();
        while (courant != r) {
            precedent = courant;
            courant = courant.getSuivant();
        }
        return precedent;
    }

    /**
     * Echange les deux Noeuds r1 et r2 dans la liste.
     * La méthode suppose que les deux Noeuds existent dans la liste.
     * @param r1 un des Noeuds à échanger
     * @param r2 l'autre Noeud à échanger
     */
    public void echanger(Noeud r1, Noeud r2) {
        if (r1 == r2)
            return;
        Noeud precedentR1;
        Noeud precedentR2;
        if (r1 != tete && r2 != tete) {
            precedentR1 = getPrecedent(r1);
            precedentR2 = getPrecedent(r2);
            precedentR1.setSuivant(r2);
            precedentR2.setSuivant(r1);
        } else if (r1 == tete) {
            precedentR2 = getPrecedent(r2);
            precedentR2.setSuivant(tete);
            tete = r2;
        }
        else {
            precedentR1 = getPrecedent(r1);
            precedentR1.setSuivant(tete);
            tete = r1;
        }
        Noeud temp = r2.getSuivant();
        r2.setSuivant(r1.getSuivant());
        r1.setSuivant(temp);
    }

}