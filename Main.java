public class Main {
    public static void main(String[] args) {

        // On va voir combien de plaque d'immatriculations sont possibles
// format --> AA - 111 - AA
// 'I' ; 'O' ; 'U' sont interdits, et la combinaison 'SS'

//-- La liste des lettres et chiffres utilisés
        String[] lettres = {"A","B","C","D","E","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};  //-- 23 lettres, de 0 à 22
        String[] chiffres = {"0","1","2","3","4","5","6","7","8","9"}; //-- 10 chiffres, de 0 à 9

//-- les compteurs qui me serviront dans la boucle
        int cptL11 = 0; int cptL12 = 0; int cptC11 = 0; int cptC12 = 0; int cptC13 = 0; int cptL21 = 0; int cptL22 = 0;
        int cptNbPlaque = 0; //--Compteur du total de plaque généré
        int cptSS = 0; //-- On va compter le nombre de plaques qu'il y aurait avec 'SS' si ce n'était pas interdit

//-- Les valeurs qui composent la plaque, pour un format --> m11+m12 - n11+n12+n13 - m21+m22
        String l11 = "n"; String l12 = "n"; String l21 = "n"; String l22 = "n";
        String c11 = "n"; String c12 = "n"; String c13 = "n";

        while ( (l11 != "Z") || (l12 != "Z") || (c11 != "9") || (c12 != "9") || (c13 != "9") || (l21 != "Z") || (l22 != "Z") ) {
            l11 = lettres[cptL11];
            l12 = lettres[cptL12];
            c11 = chiffres[cptC11];
            c12 = chiffres[cptC12];
            c13 = chiffres[cptC13];
            l21 = lettres[cptL21];
            l22 = lettres[cptL22];

            if (cptL22 == 22) {
                if (cptL21 == 22) {
                    cptL21 = 0;
                    if (cptC13 == 9) {
                        cptC13 = 0;
                        if (cptC12 == 9) {
                            cptC12 = 0;
                            if (cptC11 == 9) {
                                cptC11 = 0;
                                if (cptL12 == 22) {
                                    cptL12 = 0;
                                    cptL11 ++;
                                } else {
                                    cptL12 ++;
                                }
                            } else {
                                cptC11 ++;
                            }
                        } else {
                            cptC12 ++;
                        }
                    } else {
                        cptC13 ++;
                    }
                } else {
                    cptL21 ++;
                }
                cptL22 = 0;
            } else {
                cptL22++;
            }
            if ((l11 == "S" && l12 == "S") || (l21 == "S" && l22 == "S") ) {
                cptSS ++;
            } else {
                System.out.println( l11+l12 + "-" + c11+c12+c13 + "-" + l21+l22 );
                cptNbPlaque ++;
            }
        }

        System.out.println(" ");
        System.out.println("Fin !");
        System.out.println("Nombre total de plaque générées --> " + cptNbPlaque);
        System.out.println("Nombre de plaques avec SS (pas affichées dans la liste) --> " + cptSS);
    }
}